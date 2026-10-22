package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.camera.video.AudioStats;
import androidx.core.content.FileProvider;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f461869a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f461870b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f461871c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f461872d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f461873e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f461874f = "0123456789ABCDEF";

    private static char a(int r100) {
        int r101 = r100 & 15;
        if (r101 >= 10) goto L5;
        int r102 = r101 + 48;
    L7:
        return (char) r102;
    L5:
        r102 = (r101 - 10) + 97;
        goto L7
    }

    public static boolean a() {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L5;
        File r100 = Environment.getExternalStorageDirectory();
    L6:
        if (r100 == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r100 = null;
        goto L6
    }

    public static String b() {
        File r100 = g.e();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.exists() == true) goto L10;
        r100.mkdirs();
    L10:
        return r100.toString();
    }

    public static boolean c() {
        Context r100 = g.a();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", r100.getPackageName()) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_tencent_open_utils_m_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L13;
        String r103 = Integer.toString(r100[r102] & UByte.MAX_VALUE, 16);
        if (r103.length() != 1) goto L11;
        r103 = "0".concat(r103);
    L11:
        r101.append(r103);
        r102 = r102 + 1;
        goto L7
    L13:
        return r101.toString();
    }

    public static boolean b(Context r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (i(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L8;
        return true;
    L8:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L27;
        return true;
    L27:
        NetworkInfo[] r102 = r101.getAllNetworkInfo();     // Catch: Exception -> L13
    L16:
        if (r102 != null) goto L18;
    L26:
        return false;
    L18:
        if (r102.length == 0) goto L26;
        int r103 = r102.length;
        int r104 = 0;
    L21:
        if (r104 >= r103) goto L26;
        if (r102[r104].isConnectedOrConnecting() == true) goto L24;
        r104 = r104 + 1;
        goto L21
    L24:
        return true;
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e);
        r102 = null;
        goto L16
    }

    public static boolean c(Context r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_tencent_open_utils_m_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Throwable -> L4
        double r102 = Math.sqrt(Math.pow(r101.widthPixels / r101.xdpi, 2.0d) + Math.pow(r101.heightPixels / r101.ydpi, 2.0d));     // Catch: Throwable -> L4
    L6:
        if (r102 <= 6.5d) goto L9;
        return true;
    L9:
        return false;
    L4:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L6
    }

    public static JSONObject d(String r100) throws JSONException {
        if (r100.equals("false") == false) goto L6;
        r100 = "{value : false}";
    L6:
        if (r100.equals("true") == false) goto L9;
        r100 = "{value : true}";
    L9:
        if (r100.contains("allback(") == false) goto L12;
        r100 = r100.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    L12:
        if (r100.contains("online[0]=") == false) goto L15;
        r100 = "{online:" + r100.charAt(r100.length() - 2) + com.alipay.sdk.m.u.i.f25855d;
    L15:
        return new JSONObject(r100);
    }

    public static boolean e(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static String f(String r100) {
        return URLEncoder.encode(r100, "UTF-8");
    L4:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e);
        return "";
    }

    private static boolean g(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo("com.tencent.mtt", 64);     // Catch: Exception -> L16
        String r102 = r101.versionName;     // Catch: Exception -> L16
        if (k.a(r102, "4.3") >= 0) goto L6;
    L17:
        goto L15
    L6:
        if (r102.startsWith("4.4") == true) goto L17;
        Signature[] r103 = r101.signatures;     // Catch: Exception -> L16
        if (r103 == null) goto L17;
        MessageDigest r104 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        r104.update(r103[0].toByteArray());     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        String r105 = a(r104.digest());     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        r104.reset();     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        if (r105.equals("d8391a394d4a179e6fe7bdb8a301258b") == false) goto L17;
        return true;
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e.getMessage());     // Catch: Exception -> L16
    L15:
        return false;
    }

    public static final boolean h(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith("http://") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.startsWith("https://") == true) goto L9;
        return false;
    }

    public static boolean i(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (new PolarisFileWrapper(r100).exists() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] j(String r100) {
        return r100.getBytes("UTF-8");
    L4:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e);
        return new byte[0];
    }

    public static String k(String r100) {
        return a(r100, 2);
    }

    public static File l(String r100) throws IOException {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L5;
    L13:
        return r101;
    L5:
        if (r101.getParentFile() != null) goto L7;
    L12:
        r101.createNewFile();
        goto L13
    L7:
        if (r101.getParentFile().exists() == true) goto L12;
        if (r101.getParentFile().mkdirs() == false) goto L11;
        r101.createNewFile();
        goto L13
    L11:
        SLog.d("openSDK_LOG.Util", "createFile failed" + r100);
        goto L13
    }

    public static boolean m(String r100) {
        String r101 = b();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (r100.contains(r101) == false) goto L9;
        return true;
    }

    public static Bundle a(String r100) {
        Bundle r101 = new Bundle();
        if (r100 == null) goto L17;
        String[] r102 = r100.split("&");     // Catch: Exception -> L10
        int r103 = r102.length;     // Catch: Exception -> L10
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L18;
        String[] r105 = a(r102[r104], ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L10
        if (r105.length != 2) goto L9;
        r101.putString(URLDecoder.decode(r105[0]), URLDecoder.decode(r105[1]));     // Catch: Exception -> L10
    L9:
        r104 = r104 + 1;
        goto L5
    L18:
        return r101;
    L10:
        return null;
    L17:
        return r101;
    }

    public static Bundle b(String r100) {
        URL r101 = new URL(r100.replace("auth://", "http://"));     // Catch: MalformedURLException -> L5
        Bundle r102 = a(r101.getQuery());     // Catch: MalformedURLException -> L5
        r102.putAll(a(r101.getRef()));     // Catch: MalformedURLException -> L5
        return r102;
    L6:
        return new Bundle();
    }

    public static JSONObject c(String r100) {
        URL r101 = new URL(r100.replace("auth://", "http://"));     // Catch: MalformedURLException -> L5
        JSONObject r102 = a(null, r101.getQuery());     // Catch: MalformedURLException -> L5
        a(r102, r101.getRef());     // Catch: MalformedURLException -> L5
        return r102;
    L6:
        return new JSONObject();
    }

    public static boolean d(Context r100) {
        if (k.c(r100, "8.1.5") < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(Context r100) {
        if (k.c(r100, "8.1.8") < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(Context r100) {
        if (k.c(r100, "5.9.5") >= 0) goto L5;
        return false;
    L5:
        return true;
    }

    public static String g(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
        r101.update(j(r100));     // Catch: NoSuchAlgorithmException -> L9
        byte[] r102 = r101.digest();     // Catch: NoSuchAlgorithmException -> L9
        if (r102 == null) goto L15;
        StringBuilder r103 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L9
        int r104 = r102.length;     // Catch: NoSuchAlgorithmException -> L9
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        byte r106 = r102[r105];     // Catch: NoSuchAlgorithmException -> L9
        r103.append(a(r106 >>> 4));     // Catch: NoSuchAlgorithmException -> L9
        r103.append(a(r106));     // Catch: NoSuchAlgorithmException -> L9
        r105 = r105 + 1;     // Catch: NoSuchAlgorithmException -> L9
        goto L5
    L7:
        return r103.toString();
    L15:
        return r100;
    L9:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e.getMessage());
        return r100;
    }

    public static final String a(Context r100) {
        if (r100 == null) goto L7;
        CharSequence r101 = r100.getPackageManager().getApplicationLabel(r100.getApplicationInfo());
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.toString();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean a(File r100, File r101) {
        PolarisFileOutputStreamWrapper r102 = null;
    L67:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L97:
        return false;
    L56:
        e = e;
        r101 = 0;
    L58:
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);     // Catch: Throwable -> L70
        if (r102 != null) goto L89;
    L64:
        if (r101 == 0) goto L97;
        r101.close();     // Catch: IOException -> L67
        r101 = r101;
    L82:
        goto L97
    L89:
        r102.close();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L45:
        e = e;
        r101 = 0;
    L47:
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);     // Catch: Throwable -> L70
        if (r102 != null) goto L85;
    L53:
        if (r101 == 0) goto L97;
        r101.close();     // Catch: IOException -> L67
        r101 = r101;
        goto L82
    L85:
        r102.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L43:
        th = th;
        r101 = 0;
    L71:
        if (r102 != null) goto L95;
    L76:
        if (r101 == 0) goto L107;
        r101.close();     // Catch: IOException -> L79
        throw th;
    L79:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
        throw th;
    L107:
        throw th;
    L95:
        r102.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
        goto L76
    L4:
        if (r101.exists() == false) goto L7;
        r101.delete();     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
    L7:
        if (r101.getParentFile() != null) goto L9;
    L11:
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
        r101 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L34 OutOfMemoryError -> L37 IOException -> L40
    L103:
        byte[] r104 = new byte[102400];     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
    L15:
        int r105 = r101.read(r104);     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
        if (r105 == (-1)) goto L93;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
        r103.flush();     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
    L93:
        r103.close();     // Catch: IOException -> L21
    L87:
        r101.close();     // Catch: IOException -> L25
    L27:
        return true;
    L25:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L21:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L32:
        e = e;
    L42:
        r102 = r103;
        r101 = r101;
    L30:
        e = e;
    L39:
        r102 = r103;
        r101 = r101;
    L28:
        th = th;
    L36:
        r102 = r103;
    L40:
        e = e;
        r101 = 0;
    L37:
        e = e;
        r101 = 0;
    L34:
        th = th;
        r101 = 0;
        goto L36
    L9:
        if (r101.getParentFile().exists() == true) goto L11;
        r101.getParentFile().mkdirs();     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
    L70:
        th = th;
        goto L71
    }

    public static String b(Context r100, Uri r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (DocumentsContract.isDocumentUri(r100, r101) == false) goto L37;
        String r102 = r101.getAuthority();
        if ("com.android.externalstorage.documents".equals(r102) == false) goto L16;
        String[] r103 = DocumentsContract.getDocumentId(r101).split(":");
        String r104 = r103[0];
        if ("primary".equals(r104) == false) goto L14;
        return Environment.getExternalStorageDirectory().getAbsolutePath().concat(HTTP.URL_DEFAULT).concat(r103[1]);
    L14:
        return "/storage/".concat(r104).concat(HTTP.URL_DEFAULT).concat(r103[1]);
    L16:
        if ("com.android.providers.downloads.documents".equals(r102) == false) goto L24;
        String r105 = DocumentsContract.getDocumentId(r101);
        if (r105.startsWith("raw:") == false) goto L22;
        return r105.replaceFirst("raw:", "");
    L22:
        return c(r100, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.parseLong(r105)));
    L24:
        if ("com.android.providers.media.documents".equals(r102) == false) goto L36;
        String[] r106 = DocumentsContract.getDocumentId(r101).split(":");
        String r107 = r106[0];
        if ("image".equals(r107) == false) goto L29;
        Uri r108 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L35:
        return c(r100, ContentUris.withAppendedId(r108, CastLongProtector.parseLong(r106[1])));
    L29:
        if ("video".equals(r107) == false) goto L32;
        r108 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L35
    L32:
        if ("audio".equals(r107) == false) goto L36;
        r108 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L36:
        return null;
    L37:
        String r109 = r101.getScheme();
        if ("content".equals(r109) == false) goto L41;
        return c(r100, r101);
    L41:
        if ("file".equals(r109) == true) goto L43;
        return null;
    L43:
        return r101.getPath();
    }

    public static String c(Context r110, Uri r111) {
        PolarisFileInputStreamWrapper r112 = null;
        Cursor r100 = com_tencent_open_utils_m_android_content_ContentResolver_query(r110.getContentResolver(), r111, new String[]{"_data"}, null, null, null);     // Catch: Exception -> L11
        if (r100 != null) goto L115;
    L88:
        return null;
    L115:
    L9:
        e = e;
    L13:
        SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e.getMessage());
        if (r100 == null) goto L138;
        r100.close();
    L138:
        ParcelFileDescriptor r101 = com_tencent_open_utils_m_android_content_ContentResolver_openFileDescriptor(r110.getContentResolver(), r111, "r");     // Catch: Throwable -> L68 Exception -> L70
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101.getFileDescriptor());     // Catch: Throwable -> L64 Exception -> L66
        File r113 = h(r110, "Images");     // Catch: Throwable -> L60 Exception -> L62
        if (r113 != null) goto L31;
        SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");     // Catch: Throwable -> L60 Exception -> L62
        r102.close();     // Catch: IOException -> L23
    L129:
        r101.close();     // Catch: IOException -> L27
    L29:
        return null;
    L27:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
    L23:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
        goto L129
    L31:
        if (r113.exists() == true) goto L33;
        r113.mkdirs();     // Catch: Throwable -> L60 Exception -> L62
    L33:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r113, r111.getLastPathSegment());     // Catch: Throwable -> L60 Exception -> L62
        if (r103.exists() == true) goto L36;
        r103.createNewFile();     // Catch: Throwable -> L60 Exception -> L62
    L36:
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L60 Exception -> L62
        byte[] r115 = new byte[2048];     // Catch: Throwable -> L56 Exception -> L58
    L39:
        int r104 = r102.read(r115);     // Catch: Throwable -> L56 Exception -> L58
        if (r104 == (-1)) goto L42;
        r114.write(r115, 0, r104);     // Catch: Throwable -> L56 Exception -> L58
        goto L39
    L42:
        r114.flush();     // Catch: Throwable -> L56 Exception -> L58
        String r116 = r103.getAbsolutePath();     // Catch: Throwable -> L56 Exception -> L58
        r102.close();     // Catch: IOException -> L45
    L121:
        r114.close();     // Catch: IOException -> L49
    L127:
        r101.close();     // Catch: IOException -> L53
    L55:
        return r116;
    L53:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
    L49:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
    L45:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
        goto L121
    L58:
        e = move-exception;
        PolarisFileOutputStreamWrapper r117 = r114;
        e = e;
    L113:
        SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());     // Catch: Throwable -> L89
        if (r102 != null) goto L133;
    L78:
        if (r117 != null) goto L107;
    L83:
        if (r101 == null) goto L88;
        r101.close();     // Catch: IOException -> L86
    L86:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
        goto L88
    L107:
        r117.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
        goto L83
    L133:
        r102.close();     // Catch: IOException -> L76
    L76:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
    L89:
        th = th;
    L90:
        r112 = r102;
    L91:
        if (r112 != null) goto L119;
    L96:
        if (r117 != null) goto L125;
    L101:
        if (r101 == null) goto L143;
        r101.close();     // Catch: IOException -> L104
        throw th;
    L104:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
        throw th;
    L143:
        throw th;
    L125:
        r117.close();     // Catch: IOException -> L99
    L99:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
        goto L101
    L119:
        r112.close();     // Catch: IOException -> L94
    L94:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
    L56:
        th = move-exception;
        r112 = r102;
        r117 = r114;
        th = th;
    L62:
        e = e;
        r117 = null;
    L60:
        th = th;
        r117 = null;
        goto L90
    L66:
        e = e;
        r117 = null;
        r102 = null;
    L64:
        th = th;
        r117 = null;
        goto L91
    L70:
        e = e;
        r117 = null;
        r101 = null;
        r102 = null;
    L68:
        th = th;
        r117 = null;
        r101 = null;
        goto L91
    L6:
        if (r100.moveToFirst() == false) goto L88;
        return r100.getString(r100.getColumnIndexOrThrow("_data"));
    L11:
        e = e;
        r100 = null;
        goto L13
    }

    private static int com_tencent_open_utils_m_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_tencent_open_utils_m_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String d(Context r100, String r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        b(r100, r101);
        return f461869a;
    }

    public static String e(Context r100, String r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        String r102 = d(r100, r101);
        f461871c = r102;
        return r102;
    }

    public static boolean f(Context r100, String r101) {
        boolean r102 = false;
        if (c(r100) == true) goto L5;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
    L12:
        if (r103 == true) goto L14;
        return r103;
    L14:
        if (k.c(r100, r101) >= 0) goto L17;
        r102 = true;
    L17:
        return r102;
    L10:
        if (k.a(r100, Constants.PACKAGE_TIM) == null) goto L12;
        r103 = false;
        goto L12
    L5:
        if (k.a(r100, Constants.PACKAGE_QQ_PAD) == null) goto L7;
        r103 = false;
        goto L8
    }

    public static boolean g(Context r100, String r101) {
        boolean r102 = false;
        if (c(r100) == true) goto L5;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        return r103;
    L10:
        if (k.c(r100, r101) >= 0) goto L13;
        r102 = true;
    L13:
        return r102;
    L5:
        if (k.a(r100, Constants.PACKAGE_QQ_PAD) == null) goto L7;
        r103 = false;
        goto L8
    }

    public static File h(Context r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        File[] r102 = r100.getExternalFilesDirs(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.length > 0) goto L10;
        return null;
    L10:
        return r102[0];
    }

    private static boolean i(Context r100, String r101) {
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (com_tencent_open_utils_m_android_content_Context_checkSelfPermission(r100, r101) == 0) goto L15;
        return true;
    L15:
        return false;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e);
        return false;
    L14:
        return false;
    }

    public static Drawable a(String r100, Context r101) {
        InputStream r102 = null;
        Drawable r103 = null;
        r103 = null;
        if (r101 != null) goto L42;
        SLog.e("openSDK_LOG.Util", "context null!");
        return null;
    L42:
        InputStream r104 = r101.getAssets().open(r100);     // Catch: Throwable -> L18 IOException -> L20
        r103 = Drawable.createFromStream(r104, r100);     // Catch: Throwable -> L14 IOException -> L16
        r104.close();     // Catch: Exception -> L11
    L27:
        return r103;
    L11:
        e = e;
        StringBuilder r105 = new StringBuilder("inputStream close exception: ");
    L13:
        r105.append(e.getMessage());
        SLog.e("openSDK_LOG.Util", r105.toString());
    L16:
        e = e;
    L22:
        SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());     // Catch: Throwable -> L14
        r104.close();     // Catch: Exception -> L25
    L25:
        e = e;
        r105 = new StringBuilder("inputStream close exception: ");
    L14:
        th = th;
        r102 = r104;
    L33:
        r102.close();     // Catch: Exception -> L30
    L32:
        throw th;
    L30:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e.getMessage());
        goto L32
    L20:
        e = e;
        r104 = null;
    L18:
        th = th;
        goto L33
    }

    public static void b(Context r100, String r101) {
        if (r100 != null) goto L12;
        return;
    L12:
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        String r103 = r102.versionName;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        f461870b = r103;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        f461869a = r103.substring(0, r103.lastIndexOf(46));     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        String r104 = f461870b;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        f461872d = r104.substring(r104.lastIndexOf(46) + 1, f461870b.length());     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        f461873e = r102.versionCode;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
        return;
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
    }

    public static String c(Context r100, String r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        b(r100, r101);
        return f461870b;
    }

    public static JSONObject a(JSONObject r100, String r101) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        if (r101 == null) goto L16;
        String[] r102 = r101.split("&");
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L16;
        String[] r105 = r102[r104].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r105.length != 2) goto L15;
        r105[0] = URLDecoder.decode(r105[0]);     // Catch: Exception -> L17
        r105[1] = URLDecoder.decode(r105[1]);     // Catch: Exception -> L17
    L18:
        r100.put(r105[0], r105[1]);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e.getMessage());
    L15:
        r104 = r104 + 1;
    L16:
        return r100;
    }

    public static boolean b(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L10;
    L8:
        return false;
    L10:
        return a(r102, l(r101));
    L6:
        e = move-exception;
        SLog.d("openSDK_LOG.Util", "copy fail from " + r100 + " to " + r101 + " ", e);
        goto L8
    }

    public static long a(Context r100, Uri r101) {
        Cursor r102 = com_tencent_open_utils_m_android_content_ContentResolver_query(r100.getContentResolver(), r101, new String[]{"_size"}, null, null, null);
        long r103 = 0;
        if (r102 != null) goto L32;
    L25:
        return 0;
    L32:
        if (r102.getCount() == 0) goto L25;
        int r104 = r102.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L14 Exception -> L16
        if (r102.moveToFirst() == false) goto L10;
        r103 = r102.getLong(r104);     // Catch: Throwable -> L14 Exception -> L16
    L10:
        r102.close();     // Catch: Exception -> L12
    L31:
    L19:
        return r103;
    L16:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);     // Catch: Throwable -> L14
        r102.close();     // Catch: Exception -> L12
    L14:
        th = move-exception;
        r102.close();     // Catch: Exception -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);
    L12:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);
        goto L19
    }

    public static boolean a(Context r100, String r101) {
        boolean r102 = g(r100);     // Catch: Exception -> L9
        if (r102 == false) goto L7;
        a(r100, "com.tencent.mtt", "com.tencent.mtt.MainActivity", r101);     // Catch: Exception -> L6
    L31:
        return true;
    L7:
        a(r100, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO, "com.android.browser.BrowserActivity", r101);     // Catch: Exception -> L6
    L11:
        if (r102 == false) goto L29;
        a(r100, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO, "com.android.browser.BrowserActivity", r101);     // Catch: Exception -> L14
        return true;
    L14:
        a(r100, "com.google.android.browser", "com.android.browser.BrowserActivity", r101);     // Catch: Exception -> L16
        return true;
    L16:
        a(r100, "com.android.chrome", "com.google.android.apps.chrome.Main", r101);     // Catch: Exception -> L18
        return true;
    L18:
        return false;
    L29:
        a(r100, "com.google.android.browser", "com.android.browser.BrowserActivity", r101);     // Catch: Exception -> L21
        return true;
    L21:
        a(r100, "com.android.chrome", "com.google.android.apps.chrome.Main", r101);     // Catch: Exception -> L24
        return true;
    L24:
        return false;
    L9:
        r102 = false;
        goto L11
    }

    public static String a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L8:
        return "";
    L10:
        return Base64.encodeToString(r100.getBytes("UTF-8"), r101);
    L6:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e.getMessage());
        goto L8
    }

    public static String[] a(String r100, String r101) {
        int r102 = r100.indexOf(r101);
        if (r102 != (-1)) goto L7;
        return new String[]{r100};
    L7:
        return new String[]{r100.substring(0, r102), r100.substring(r102 + r101.length())};
    }

    public static boolean a(Context r100, boolean r101) {
        if (c(r100) == false) goto L8;
        if (k.a(r100, Constants.PACKAGE_QQ_PAD) == null) goto L8;
        return true;
    L8:
        if (k.c(r100, "4.1") < 0) goto L10;
        return true;
    L10:
        if (k.a(r100, Constants.PACKAGE_TIM) != null) goto L14;
        return false;
    L14:
        return true;
    }

    public static Uri a(Activity r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L14;
        SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
        return null;
    L14:
        String r103 = Tencent.getAuthorities(r101);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return null;
    L9:
        Uri r104 = FileProvider.getUriForFile(r100, r103, new PolarisFileWrapper(r102));     // Catch: Exception -> L11
        r100.grantUriPermission("com.tencent.mobileqq", r104, 3);     // Catch: Exception -> L11
        r100.grantUriPermission(Constants.PACKAGE_TIM, r104, 3);     // Catch: Exception -> L11
        r100.grantUriPermission(Constants.PACKAGE_QQ_PAD, r104, 3);     // Catch: Exception -> L11
        r100.grantUriPermission(Constants.PACKAGE_QQ_SPEED, r104, 3);     // Catch: Exception -> L11
        return r104;
    L11:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e);
        return null;
    }

    private static ParcelFileDescriptor com_tencent_open_utils_m_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean a(Map<String, Object> r100, String r101, boolean r102) {
        if (r100 != null) goto L7;
        SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
        return r102;
    L7:
        if (r100.containsKey(r101) == true) goto L10;
        SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + r101);
        return r102;
    L10:
        Object r103 = r100.get(r101);
        if ((r103 instanceof Boolean) == true) goto L13;
        return r102;
    L13:
        return ((Boolean) r103).booleanValue();
    }

    public static String a(Map<String, Object> r100, String r101, String r102) {
        if (r100 != null) goto L7;
        SLog.e("openSDK_LOG.Util", "getString error, params==null");
        return r102;
    L7:
        if (r100.containsKey(r101) == true) goto L10;
        SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + r101);
        return r102;
    L10:
        Object r103 = r100.get(r101);
        if ((r103 instanceof String) == true) goto L13;
        return r102;
    L13:
        return (String) r103;
    }

    public static boolean a(Context r100, String r101, String r102) {
        boolean r103 = b(r101, r102);
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + r103);
        return r103;
    }

    public static String a(String r100, Activity r101, String r102, IUiListener r103) {
        boolean r104 = m(r102);     // Catch: Exception -> L23
        SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + r104 + ",hasSDPermission=" + c());     // Catch: Exception -> L23
        if (r104 == true) goto L18;
        File r105 = g.a("Images");     // Catch: Exception -> L23
        if (r105 == null) goto L9;
        String r106 = r105.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;     // Catch: Exception -> L23
    L14:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102);     // Catch: Exception -> L23
        String r108 = r107.getAbsolutePath();     // Catch: Exception -> L23
        String r109 = r106 + File.separator + r107.getName();     // Catch: Exception -> L23
        if (b(r108, r109) == false) goto L17;
        r102 = r109;
        goto L18
    L17:
        r102 = null;
        goto L18
    L9:
        File r110 = g.a().getCacheDir();     // Catch: Exception -> L23
        if (r110 != null) goto L13;
        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");     // Catch: Exception -> L23
        return null;
    L13:
        r106 = r110.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;     // Catch: Exception -> L23
    L18:
        Uri r111 = a(r101, r100, r102);     // Catch: Exception -> L23
        if (r111 != null) goto L22;
        return null;
    L22:
        return r111.toString();
    L23:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e);
        return null;
    }

    public static final String a(String r100, int r101, String r102, String r103) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L27;
        r102 = "UTF-8";
    L27:
    L24:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e.getMessage());
        return r100;
    L11:
        if (r100.getBytes(r102).length > r101) goto L13;
        return r100;
    L13:
        int r104 = 0;
        int r105 = 0;
    L15:
        if (r104 >= r100.length()) goto L23;
        int r106 = r104 + 1;     // Catch: Exception -> L24
        r105 = r105 + r100.substring(r104, r106).getBytes(r102).length;     // Catch: Exception -> L24
        if (r105 > r101) goto L18;
        r104 = r106;
        goto L15
    L18:
        String r107 = r100.substring(0, r104);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r103) == true) goto L31;
        return r107 + r103;
    L31:
        return r107;
    L23:
        return r100;
    }

    private static void a(Context r100, String r101, String r102, String r103) {
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(r101, r102));
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r104.addFlags(1073741824);
        r104.addFlags(268435456);
        r104.setData(UriProtector.parse(r103));
        r100.startActivity(r104);
    }

    public static Bundle a(String r110, String r111, String r112, String r113, String r114, String r115) {
        return a(r110, r112, r113, r111, r114, r115, "", "", "", "", "", "");
    }

    private static Cursor com_tencent_open_utils_m_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }

    public static Bundle a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113) {
        Bundle r108 = new Bundle();
        r108.putString("openid", r100);
        r108.putString("report_type", r101);
        r108.putString("act_type", r102);
        r108.putString("via", r103);
        r108.putString("app_id", r104);
        r108.putString("result", r105);
        r108.putString("type", r106);
        r108.putString("login_status", r107);
        r108.putString("need_user_auth", r110);
        r108.putString("to_uin", r111);
        r108.putString("call_source", r112);
        r108.putString("to_type", r113);
        r108.putString("platform", "1");
        return r108;
    }
}
