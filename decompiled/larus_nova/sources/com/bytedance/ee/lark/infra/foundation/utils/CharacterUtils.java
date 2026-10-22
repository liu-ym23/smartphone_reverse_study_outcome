package com.bytedance.ee.lark.infra.foundation.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/* JADX INFO: loaded from: classes19.dex */
public class CharacterUtils {
    public static final String EMPTY = "";
    public static final long GB = 1073741824;
    static final char[] HEX_CHARS = null;
    public static final long KB = 1024;
    public static final long MB = 1048576;
    private static final String TAG = "CharacterUtils";

    public CharacterUtils() {
    }

    public static String empty() {
        return "";
    }

    public static String nullValue() {
        return null;
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_lark_infra_foundation_utils_CharacterUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static List<Object> getArrayFromJsonArray(JSONArray r100) throws Exception {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L12;
        Object r103 = r100.get(r102);
        if ((r103 instanceof JSONArray) == false) goto L9;
        r103 = getArrayFromJsonArray((JSONArray) r103);
    L11:
        r101.add(r103);
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof JSONObject) == false) goto L11;
        r103 = getMapFromJson((JSONObject) r103);
        goto L11
    L12:
        return r101;
    }

    private static String getCharSet(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1388966911: goto L25;
            case -1109877331: goto L21;
            case -119555963: goto L17;
            case 3584301: goto L13;
            case 111113226: goto L9;
            default: goto L28;
        };
    L28:
        switch(r101) {
            case 0: goto L32;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L30;
            case 4: goto L30;
            default: goto L29;
        };
    L29:
        return r100;
    L30:
        return "UTF-16LE";
    L32:
        return "latin1";
    L9:
        if (r100.equals("ucs-2") == false) goto L28;
        r101 = 4;
        goto L28
    L13:
        if (r100.equals("ucs2") == false) goto L28;
        r101 = 3;
        goto L28
    L17:
        if (r100.equals("utf16le") == false) goto L28;
        r101 = 2;
        goto L28
    L21:
        if (r100.equals("latin1") == false) goto L28;
        r101 = 1;
        goto L28
    L25:
        if (r100.equals(MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING) == false) goto L28;
        r101 = 0;
        goto L28
    }

    public static JSONObject getJsonFromMap(Map r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (JSONObject) new JSONParser().parse(JSONValue.toJSONString(r100));
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e.toString()});
        return null;
    }

    public static Map<String, Object> getMapFromJson(JSONObject r100) throws Exception {
        HashMap r101 = new HashMap();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = getArrayFromJsonArray((JSONArray) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = getMapFromJson((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }

    public static byte[] hexStringToBytes(String r100) throws IllegalArgumentException {
        if (r100 == null) goto L10;
        if ((r100.length() % 2) == 1) goto L10;
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        byte[] r103 = new byte[r102 / 2];
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L8;
        r103[r104 / 2] = (byte) ((Character.digit(r101[r104], 16) << 4) + Character.digit(r101[r104 + 1], 16));
        r104 = r104 + 2;
        goto L6
    L8:
        return r103;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r100);
    }

    public static final boolean isChinese(char r100) {
        Character.UnicodeBlock r101 = Character.UnicodeBlock.of(r100);
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r101 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r101 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r101 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r101 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static int length(String r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length();
    }

    public static String md5Hex(File r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        if (r101 != null) goto L6;
        return null;
    L6:
        int r102 = a.f242800a;     // Catch: Exception -> L12
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L12
        byte[] r104 = new byte[8192];     // Catch: Exception -> L12
    L7:
        int r105 = r103.read(r104, 0, 8192);     // Catch: Exception -> L12
        if (r105 <= 0) goto L10;
        r101.update(r104, 0, r105);     // Catch: Exception -> L12
        goto L7
    L10:
        r103.close();     // Catch: Exception -> L12
        return toHexString(r101.digest());
    L12:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        return null;
    }

    public static String null2Empty(String r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return empty();
    }

    public static String replaceBlank(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return PatternProtector.compile("\\s*|\t|\r|\n").matcher(r100).replaceAll("");
    }

    public static String splitCharByPoints(String r100) {
        StringBuilder r101 = new StringBuilder();
        char[] r102 = r100.toCharArray();
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L10;
        r101.append(r102[r103]);
        if (r103 == (r102.length - 1)) goto L8;
        r101.append(".");
    L8:
        r103 = r103 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    public static String toAndroidStyleColor(String r100) {
        int r101 = r100.length();
        if (r101 != 7) goto L6;
        return r100;
    L6:
        if (r101 == 4) goto L8;
        return r100;
    L8:
        if (r100.charAt(0) == '#') goto L10;
        return r100;
    L10:
        return "#" + r100.charAt(1) + r100.charAt(1) + r100.charAt(2) + r100.charAt(2) + r100.charAt(3) + r100.charAt(3);
    }

    public static String toBinaryString(byte... r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 8];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L10;
        int r105 = r100[r103];
        if (r105 >= 0) goto L8;
        r105 = r105 + 256;
    L8:
        int r106 = r104 + 1;
        r102[r104] = r101[(r105 >>> 7) & 1];
        int r107 = r106 + 1;
        r102[r106] = r101[(r105 >>> 6) & 1];
        int r108 = r107 + 1;
        r102[r107] = r101[(r105 >>> 5) & 1];
        int r109 = r108 + 1;
        r102[r108] = r101[(r105 >>> 4) & 1];
        int r110 = r109 + 1;
        r102[r109] = r101[(r105 >>> 3) & 1];
        int r111 = r110 + 1;
        r102[r110] = r101[(r105 >>> 2) & 1];
        int r112 = r111 + 1;
        r102[r111] = r101[(r105 >>> 1) & 1];
        r104 = r112 + 1;
        r102[r112] = r101[r105 & 1];
        r103 = r103 + 1;
        goto L4
    L10:
        return new String(r102);
    }

    public static Bitmap toBitmap(View r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        if ((r100 instanceof ListView) == false) goto L9;
        ListView r103 = (ListView) r100;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r105 >= r103.getChildCount()) goto L14;
        r104 = r104 + r103.getChildAt(r105).getHeight();
        r105 = r105 + 1;
    L14:
        r102 = r104;
    L15:
        r100.setDrawingCacheEnabled(true);
        r100.clearFocus();
        r100.setPressed(false);
        boolean r106 = r100.willNotCacheDrawing();
        r100.setWillNotCacheDrawing(false);
        int r107 = r100.getDrawingCacheBackgroundColor();
        r100.setDrawingCacheBackgroundColor(-1);
        if (r107 == (-1)) goto L18;
        r100.destroyDrawingCache();
    L18:
        r100.buildDrawingCache();
        Bitmap r108 = r100.getDrawingCache();
        if (r108 != null) goto L21;
        return null;
    L21:
        Bitmap r109 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r110 = new Canvas(r109);
        r110.drawBitmap(r108, 0.0f, 0.0f, null);
        r110.save();
        r110.restore();
        if (r109.isRecycled() == true) goto L24;
        r109.recycle();
    L24:
        r100.destroyDrawingCache();
        r100.setWillNotCacheDrawing(r106);
        r100.setDrawingCacheBackgroundColor(r107);
        return r109;
    L9:
        if ((r100 instanceof ScrollView) == false) goto L15;
        ScrollView r111 = (ScrollView) r100;
        r104 = 0;
        int r112 = 0;
    L12:
        if (r112 >= r111.getChildCount()) goto L14;
        r104 = r104 + r111.getChildAt(r112).getHeight();
        r112 = r112 + 1;
        goto L12
    }

    public static byte[] toByteArray(InputStream r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: IOException -> L13
        byte[] r102 = new byte[100];     // Catch: IOException -> L13
    L7:
        int r103 = r100.read(r102, 0, 100);     // Catch: IOException -> L13
        if (r103 == (-1)) goto L9;
        r101.write(r102, 0, r103);     // Catch: IOException -> L13
        goto L7
    L9:
        byte[] r104 = r101.toByteArray();     // Catch: IOException -> L13
        r101.close();     // Catch: IOException -> L13
        r100.close();     // Catch: IOException -> L13
        return r104;
    L13:
        e = move-exception;
        AppBrandLogger.w(TAG, new Object[]{e.getMessage()});
        return null;
    }

    public static Drawable toDrawable(Bitmap r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        if (r100 != null) goto L6;
        return null;
    L6:
        return new BitmapDrawable(r102, r100);
    }

    public static String toFileSizeString(long r100) {
        DecimalFormat r101 = new DecimalFormat("0.00");
        if (r100 >= 1024) goto L6;
        return r100 + "B";
    L6:
        if (r100 >= 1048576) goto L9;
        return r101.format(r100 / 1024.0d) + "K";
    L9:
        if (r100 >= 1073741824) goto L12;
        return r101.format(r100 / 1048576.0d) + "M";
    L12:
        return r101.format(r100 / 1.073741824E9d) + "G";
    }

    public static float toFloat(Object r100) {
        return CastFloatProtector.parseFloat(r100.toString());
    L4:
        return -1.0f;
    }

    public static String toHexString(byte... r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L10;
        int r105 = r100[r103];
        if (r105 >= 0) goto L8;
        r105 = r105 + 256;
    L8:
        int r106 = r104 + 1;
        r102[r104] = r101[r105 >>> 4];
        r104 = r106 + 1;
        r102[r106] = r101[r105 & 15];
        r103 = r103 + 1;
        goto L4
    L10:
        return new String(r102);
    }

    public static int toInt(byte[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r102 = r102 + ((r100[r101] & UByte.MAX_VALUE) << (r101 * 8));
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public static <T> List<T> toList(T[] r100) {
        return Arrays.asList(r100);
    }

    public static long toLong(Object r100) {
        return CastLongProtector.parseLong(r100.toString());
    L4:
        return -1;
    }

    public static String toSlashString(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        String r103 = "";
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        char r105 = r101[r104];
        if (r105 != '\"') goto L7;
    L10:
        r103 = r103 + "\\";
    L11:
        r103 = r103 + r105;
        r104 = r104 + 1;
        goto L3
    L7:
        if (r105 == '\'') goto L10;
        if (r105 != '\\') goto L11;
    L12:
        return r103;
    }

    public static String toString(InputStream r100) {
        return toString(r100, XML.CHARSET_UTF8);
    }

    public static Map<String, Object> getMapFromJson(String r100) throws Exception {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return getMapFromJson((JSONObject) new JSONParser().parse(r100));
    }

    public static String md5Hex(String r100) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L11
    L5:
        if (r100.length() == 0) goto L11;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L9
        return toHexString(r101.digest());
    }

    public static String toBinaryString(int r100) {
        return Integer.toBinaryString(r100);
    }

    public static Bitmap toBitmap(Drawable r100) {
        if ((r100 instanceof BitmapDrawable) == false) goto L7;
        return ((BitmapDrawable) r100).getBitmap();
    L7:
        if ((r100 instanceof ColorDrawable) == false) goto L11;
        Bitmap r101 = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
        new Canvas(r101).drawColor(((ColorDrawable) r100).getColor());
        return r101;
    L11:
        if ((r100 instanceof NinePatchDrawable) == false) goto L14;
        Bitmap r102 = Bitmap.createBitmap(r100.getIntrinsicWidth(), r100.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        r100.setBounds(0, 0, r100.getIntrinsicWidth(), r100.getIntrinsicHeight());
        r100.draw(r103);
        return r102;
    L14:
        return null;
    }

    public static byte[] toByteArray(Bitmap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r100.compress(Bitmap.CompressFormat.PNG, 100, r101);
        byte[] r102 = r101.toByteArray();
        r101.close();     // Catch: IOException -> L8
    L10:
        return r102;
    L8:
        e = move-exception;
        AppBrandLogger.w(TAG, new Object[]{e.getMessage()});
        goto L10
    }

    public static Drawable toDrawable(byte[] r100) {
        return toDrawable(toBitmap(r100));
    }

    public static String toHexString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        StringBuilder r101 = new StringBuilder();
        byte[] r102 = r100.getBytes();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        r101.append(Integer.toHexString(r102[r104] & UByte.MAX_VALUE));
        r101.append(" ");
        r104 = r104 + 1;
        goto L7
    L10:
        return r101.toString();
    }

    public static int toInt(Object r100) {
        return CastIntegerProtector.parseInt(r100.toString());
    L4:
        return -1;
    }

    public static String toString(Object[] r100) {
        return Arrays.deepToString(r100);
    }

    public static String md5Hex(byte[] r100) {
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L11
    L5:
        if (r100.length == 0) goto L11;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r101.update(r100);     // Catch: Exception -> L9
        return toHexString(r101.digest());
    }

    public static Bitmap toBitmap(byte[] r100) {
        return toBitmap(r100, -1, -1);
    }

    public static byte[] toByteArray(Drawable r100) {
        return toByteArray(toBitmap(r100));
    }

    public static String toHexString(int r100) {
        return Integer.toHexString(r100);
    }

    public static byte[] toByteArray(String r100, boolean r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == true) goto L24;
        if (r101 == false) goto L8;
        String r102 = r100.replaceAll("\\s+", "");
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(r102.length() / 2);
        int r104 = 0;
    L11:
        if (r104 >= r102.length()) goto L13;
        r103.write(("0123456789ABCDEF".indexOf(r102.charAt(r104)) << 4) | "0123456789ABCDEF".indexOf(r102.charAt(r104 + 1)));
        r104 = r104 + 2;
        goto L11
    L13:
        byte[] r105 = r103.toByteArray();
        r103.close();     // Catch: IOException -> L16
    L18:
        return r105;
    L16:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e.getMessage()});
        goto L18
    L8:
        return r100.getBytes();
    L24:
        return null;
    }

    public static int toDp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_bytedance_ee_lark_infra_foundation_utils_CharacterUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int toPx(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_bytedance_ee_lark_infra_foundation_utils_CharacterUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int toSp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_bytedance_ee_lark_infra_foundation_utils_CharacterUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity) + 0.5f);
    }

    public static String toString(InputStream r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r100, r101));     // Catch: IOException -> L9
    L4:
        String r104 = r103.readLine();     // Catch: IOException -> L9
        if (r104 == null) goto L6;
        r102.append(r104);     // Catch: IOException -> L9
        r102.append("\n");     // Catch: IOException -> L9
        goto L4
    L6:
        r103.close();     // Catch: IOException -> L9
        r100.close();     // Catch: IOException -> L9
    L12:
        return r102.toString();
    L9:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"toString", e});
        goto L12
    }

    public static String toString(Object[] r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.append(r100[r104]);
        r102.append(r101);
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public static String md5Hex(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L14;
        if (r101 < 0) goto L14;
        if (r102 <= 0) goto L14;
    L12:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L14
    L8:
        if ((r101 + r102) > r100.length) goto L14;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        r103.update(r100, r101, r102);     // Catch: Exception -> L12
        return toHexString(r103.digest());
    L14:
        return null;
    }

    public static Bitmap toBitmap(byte[] r100, int r101, int r102) {
        Bitmap r103 = null;
        if (r100.length != 0) goto L14;
        return null;
    L14:
        BitmapFactory.Options r104 = new BitmapFactory.Options();     // Catch: Exception -> L11
        r104.inDither = false;     // Catch: Exception -> L11
        r104.inPreferredConfig = null;     // Catch: Exception -> L11
        if (r101 <= 0) goto L9;
        if (r102 <= 0) goto L9;
        r104.outWidth = r101;     // Catch: Exception -> L11
        r104.outHeight = r102;     // Catch: Exception -> L11
    L9:
        r103 = BitmapFactory.decodeByteArray(r100, 0, r100.length, r104);     // Catch: Exception -> L11
        r103.setDensity(96);     // Catch: Exception -> L11
        return r103;
    L11:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e.getMessage()});
        return r103;
    }

    public static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L14;
        if (r110 < 0) goto L12;
        if ((r110 + r111) > r100.length) goto L12;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r111) goto L10;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return new String(r102, 0, r101);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }

    public static final String trimString(String r100, int r101, boolean r110, String r111) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        StringBuilder r102 = new StringBuilder();
        char[] r103 = r100.toCharArray();
        int r104 = r103.length;
        boolean r105 = false;
        int r106 = 0;
    L8:
        if (r106 >= r104) goto L23;
        char r107 = r103[r106];
        if (r101 < 2) goto L12;
        r102.append(r107);
    L19:
        if (isChinese(r107) == false) goto L21;
        r101 = r101 - 2;
    L22:
        r106 = r106 + 1;
        goto L8
    L21:
        r101 = r101 - 1;
        goto L22
    L12:
        if (r101 != 1) goto L23;
        if (isChinese(r107) == false) goto L17;
        if (r110 == false) goto L19;
        r102.append(r107);
        goto L19
    L17:
        r102.append(r107);
    L23:
        String r108 = r102.toString();
        if (r108.contentEquals(r100) == true) goto L27;
        if (r111 == null) goto L27;
        r105 = true;
    L27:
        if (r105 == true) goto L29;
        return r108;
    L29:
        return r108 + r111;
    }
}
