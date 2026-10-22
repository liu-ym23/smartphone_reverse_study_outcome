package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.secure.android.common.util.SafeString;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";
    private static boolean isAegisStringLibraryLoaded;

    public StringUtils() {
    }

    public static String anonymizeMessage(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L13;
        if ((r102 % 2) == 0) goto L11;
        r101[r102] = '*';
    L11:
        r102 = r102 + 1;
        goto L7
    L13:
        return new String(r101);
    }

    public static String byte2Str(byte[] r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        return new String(r100, "UTF-8");
    L7:
        e = move-exception;
        Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
        return "";
    }

    private static boolean checkCompatible(String r100) {
        ClassLoader r101 = SecurityBase64Utils.class.getClassLoader();
        if (r101 != null) goto L15;
        return false;
    L15:
        INVOKEVIRTUAL_com_huawei_hms_framework_common_StringUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, r100);     // Catch: ClassNotFoundException -> L14
        monitor-enter(StringUtils.class);     // Catch: ClassNotFoundException -> L14
        isAegisStringLibraryLoaded = true;     // Catch: Throwable -> L11
        monitor-exit(StringUtils.class);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        throw th;     // Catch: ClassNotFoundException -> L14
    L14:
        return false;
    }

    public static String collection2String(Collection<String> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L14;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        r101.append(r102.next());
        r101.append(i.f25853b);
        goto L7
    L10:
        return r101.toString().substring(0, r101.length() - 1);
    L14:
        return null;
    }

    public static byte[] getBytes(String r100) {
        byte[] r101 = new byte[0];
        if (r100 != null) goto L9;
        return r101;
    L9:
        return r100.getBytes(XML.CHARSET_UTF8);
    L7:
        Logger.w(TAG, "the content has error while it is converted to bytes");
        return r101;
    }

    public static String getTraceInfo(Throwable r100) {
        StackTraceElement[] r101 = r100.getStackTrace();
        StringBuilder r102 = new StringBuilder(1024);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        StackTraceElement r105 = r101[r104];
        r102.append("at ");
        r102.append(r105.toString());
        r102.append(i.f25853b);
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public static byte[] str2Byte(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100.getBytes("UTF-8");
    L8:
        e = move-exception;
        Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static String toLowerCase(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toLowerCase(Locale.ROOT);
    }

    public static byte[] getBytes(long r100) {
        return getBytes(String.valueOf(r100));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_huawei_hms_framework_common_StringUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static String format(String r100, Object... r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return String.format(Locale.ROOT, r100, r101);
    }

    public static boolean strEquals(String r100, String r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static boolean stringToBoolean(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return Boolean.valueOf(r100).booleanValue();
    L7:
        e = move-exception;
        Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
        return r101;
    }

    public static int stringToInteger(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return CastIntegerProtector.parseInt(r100);
    L7:
        e = move-exception;
        Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
        return r101;
    }

    public static long stringToLong(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return CastLongProtector.parseLong(r100);
    L7:
        e = move-exception;
        Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e.getMessage()));
        return r101;
    }

    public static String substring(String r100, int r101) {
        if (checkCompatible(SAFE_STRING_PATH) == false) goto L8;
        return SafeString.substring(r100, r101);
    L6:
        Logger.w(TAG, "SafeString.substring error");
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L14:
        return "";
    L10:
        if (r100.length() < r101) goto L14;
        if (r101 < 0) goto L14;
        return r100.substring(r101);
    }

    public static String replace(String r100, CharSequence r101, CharSequence r102) {
        if (isAegisStringLibraryLoaded == false) goto L5;
    L16:
        return SafeString.replace(r100, r101, r102);
    L8:
        Logger.w(TAG, "SafeString.substring error");
    L10:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        return r100.replace(r101, r102);
    L22:
        return r100;
    L21:
        return r100;
    L5:
        if (checkCompatible(SAFE_STRING_PATH) == false) goto L10;
        goto L16
    }

    public static String substring(String r100, int r101, int r102) {
        if (isAegisStringLibraryLoaded == false) goto L5;
    L19:
        return SafeString.substring(r100, r101, r102);
    L8:
        Logger.w(TAG, "SafeString.substring error");
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        if (r101 < 0) goto L17;
        if (r102 > r100.length()) goto L17;
        if (r102 < r101) goto L17;
        return r100.substring(r101, r102);
    L17:
        return "";
    L5:
        if (checkCompatible(SAFE_STRING_PATH) == false) goto L10;
        goto L19
    }
}
