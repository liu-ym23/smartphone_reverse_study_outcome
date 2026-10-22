package com.facebook.common.webp;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class WebpSupportStatus {
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final byte[] WEBP_NAME_BYTES = null;
    private static final byte[] WEBP_RIFF_BYTES = null;
    private static final byte[] WEBP_VP8L_BYTES = null;
    private static final byte[] WEBP_VP8X_BYTES = null;
    private static final byte[] WEBP_VP8_BYTES = null;
    public static final boolean sIsExtendedWebpSupported = false;
    public static final boolean sIsSimpleWebpSupported = false;
    public static final boolean sIsWebpSupportRequired = false;

    @Nullable
    public static WebpBitmapFactory sWebpBitmapFactory;
    private static boolean sWebpLibraryChecked;

    static {
        sIsWebpSupportRequired = false;
        sIsSimpleWebpSupported = true;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        sWebpBitmapFactory = null;
        sWebpLibraryChecked = false;
        WEBP_RIFF_BYTES = asciiBytes("RIFF");
        WEBP_NAME_BYTES = asciiBytes("WEBP");
        WEBP_VP8_BYTES = asciiBytes("VP8 ");
        WEBP_VP8L_BYTES = asciiBytes("VP8L");
        WEBP_VP8X_BYTES = asciiBytes("VP8X");
    }

    public WebpSupportStatus() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isExtendedWebpSupported() {
        return true;
    }

    @Nullable
    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        if (sWebpLibraryChecked == true) goto L5;
        WebpBitmapFactory r100 = (WebpBitmapFactory) INVOKESTATIC_com_facebook_common_webp_WebpSupportStatus_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();     // Catch: Throwable -> L8
    L9:
        sWebpLibraryChecked = true;
        return r100;
    L8:
        r100 = null;
        goto L9
    L5:
        return sWebpBitmapFactory;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_common_webp_WebpSupportStatus_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static byte[] asciiBytes(String r100) {
        return r100.getBytes("ASCII");
    L4:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static boolean isAnimatedWebpHeader(byte[] r100, int r101) {
        boolean r102 = matchBytePattern(r100, r101 + 12, WEBP_VP8X_BYTES);
        if ((r100[r101 + 20] & 2) != 2) goto L5;
        boolean r103 = true;
    L6:
        if (r102 == false) goto L9;
        if (r103 == false) goto L9;
        return true;
    L9:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] r100, int r101) {
        boolean r102 = matchBytePattern(r100, r101 + 12, WEBP_VP8X_BYTES);
        if ((r100[r101 + 20] & 16) != 16) goto L5;
        boolean r103 = true;
    L6:
        if (r102 == false) goto L9;
        if (r103 == false) goto L9;
        return true;
    L9:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    public static boolean isLosslessWebpHeader(byte[] r100, int r101) {
        return matchBytePattern(r100, r101 + 12, WEBP_VP8L_BYTES);
    }

    public static boolean isSimpleWebpHeader(byte[] r100, int r101) {
        return matchBytePattern(r100, r101 + 12, WEBP_VP8_BYTES);
    }

    public static boolean isExtendedWebpHeader(byte[] r100, int r101, int r102) {
        if (r102 >= 21) goto L5;
    L7:
        return false;
    L5:
        if (matchBytePattern(r100, r101 + 12, WEBP_VP8X_BYTES) == false) goto L7;
        return true;
    }

    public static boolean isWebpHeader(byte[] r100, int r101, int r102) {
        if (r102 >= 20) goto L5;
    L9:
        return false;
    L5:
        if (matchBytePattern(r100, r101, WEBP_RIFF_BYTES) == false) goto L9;
        if (matchBytePattern(r100, r101 + 8, WEBP_NAME_BYTES) == false) goto L9;
        return true;
    }

    public static boolean isWebpSupportedByPlatform(byte[] r100, int r101, int r102) {
        if (isSimpleWebpHeader(r100, r101) == false) goto L7;
        return sIsSimpleWebpSupported;
    L7:
        if (isLosslessWebpHeader(r100, r101) == false) goto L11;
        return sIsExtendedWebpSupported;
    L11:
        if (isExtendedWebpHeader(r100, r101, r102) == true) goto L13;
        return false;
    L13:
        if (isAnimatedWebpHeader(r100, r101) == false) goto L16;
        return false;
    L16:
        return sIsExtendedWebpSupported;
    }

    private static boolean matchBytePattern(byte[] r100, int r101, byte[] r102) {
        if (r102 == null) goto L18;
        if (r100 == null) goto L18;
        if ((r102.length + r101) <= r100.length) goto L9;
        return false;
    L9:
        int r103 = 0;
    L11:
        if (r103 >= r102.length) goto L16;
        if (r100[r103 + r101] != r102[r103]) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }
}
