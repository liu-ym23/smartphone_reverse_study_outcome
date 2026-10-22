package com.facebook.imagepipeline.blurhash2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.fresco.nativeheif.Heif;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.logging.FLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class PreviewBlurHashDecoder {
    private static final String TAG = "PreviewBlur";

    public PreviewBlurHashDecoder() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_imagepipeline_blurhash2_PreviewBlurHashDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String base64Decode(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = "UTF-8";
    L11:
        return new String(Base64.decode(r100, 0), r101);
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String recoverMetaData(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        FLog.d(TAG, "recoverMetaData: base64data or metaData is null!");
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        String r102 = base64Decode(r100, "ISO-8859-1");     // Catch: Exception -> L9
        String r103 = base64Decode(r101, "ISO-8859-1");     // Catch: Exception -> L9
        char r104 = r102.charAt(0);     // Catch: Exception -> L9
        char r105 = r102.charAt(1);     // Catch: Exception -> L9
        StringBuilder r106 = new StringBuilder(r103);     // Catch: Exception -> L9
        r106.setCharAt(166, r104);     // Catch: Exception -> L9
        r106.setCharAt(164, r105);     // Catch: Exception -> L9
        r106.append(r102.substring(2));     // Catch: Exception -> L9
        return r106.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String recoverVvicMetaData(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        FLog.d(TAG, "recoverMetaData: base64data or metaData is null!");
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        String r102 = base64Decode(r100, "ISO-8859-1");     // Catch: Exception -> L9
        return base64Decode(r101, "ISO-8859-1") + r102;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bitmap getBlurhashBitmap(String r100, String r101, int r102, int r103) {
        return getBlurhashBitmap(false, r100, r101, r102, r103, null);
    }

    public static Bitmap getBlurhashBitmap(boolean r100, String r101, String r110, int r111, int r112, PreviewBlurHashProducer.PreviewDealFailCallBack r113) {
        if (r100 == false) goto L5;
        String r102 = recoverVvicMetaData(r101, r110);
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L30;
        FLog.d(TAG, "getBlurhashBitmap: totalImgStr is null!");
        r113.decodeFailed("getBlurhashBitmap: totalImgStr is null!");
        return null;
    L30:
        byte[] r103 = r102.getBytes("ISO-8859-1");     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        if (r100 == false) goto L16;
        int[] r104 = new int[1];     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        Bitmap r105 = Heif.previewToRgbaBitmap(r103, r103.length, 64, 64, r104);     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        if (r105 != null) goto L31;
        r113.decodeFailed("previewToRgbaBitmap failed: errCode is " + r104[0]);     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        return null;
    L31:
        Class r106 = INVOKESTATIC_com_facebook_imagepipeline_blurhash2_PreviewBlurHashDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.facebook.imagepipeline.nativecode.NativeBlurFilter");     // Catch: Exception -> L22 Throwable -> L25
        Class<?> r107 = Integer.TYPE;     // Catch: Exception -> L22 Throwable -> L25
        r106.getDeclaredMethod("iterativeBoxBlur", new Class[]{Bitmap.class, r107, r107}).invoke(r106, new Object[]{r105, Integer.valueOf(r111), Integer.valueOf(r112)});     // Catch: Exception -> L22 Throwable -> L25
        return r105;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        r113.decodeFailed("NativeBlurFilter deal failed! " + e.getMessage());     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        return r105;
    L16:
        r105 = BitmapFactory.decodeByteArray(r103, 0, r103.length);     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        if (r105 != null) goto L31;
        r113.decodeFailed("BitmapFactory decodeByteArray failed ");     // Catch: Throwable -> L25 UnsupportedEncodingException -> L27
        return null;
    L27:
        e = move-exception;
        r113.decodeFailed("getBlurhashBitmap deal failed! UnsupportedEncodingException " + e.getMessage());
        e.printStackTrace();
    L29:
        return null;
    L25:
        th = move-exception;
        r113.decodeFailed("getBlurhashBitmap deal failed! " + th.getMessage());
        th.printStackTrace();
        goto L29
    L5:
        r102 = recoverMetaData(r101, r110);
        goto L7
    }
}
