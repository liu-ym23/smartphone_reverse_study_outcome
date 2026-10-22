package com.larus.office.plugins.slides.media.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class ImageSaveUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f363415a = null;

    static {
        f363415a = LazyKt.lazy(new d());
    }

    public static void a(String r100, String r101, Function1 r102) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageSaveUtils$doDownloadImg$1(r100, r101, r102, null), 3, null);
    }

    public static Boolean b(Bitmap r110, String r111, Function1 r112) {
        if (r110 != null) goto L5;
        return null;
    L5:
        StringBuilder r100 = new StringBuilder();
        AppHost.Companion r101 = AppHost.f326268a;
        r100.append(r101.getAppName());
        r100.append(System.currentTimeMillis());
        r100.append(".jpeg");
        String r102 = r100.toString();
        if (r111 != null) goto L9;
        r111 = (String) f363415a.getValue();
    L9:
        if (i1.e(r110, r111, r102) == false) goto L17;
        String r103 = r111 + File.separator + r102;
        Intrinsics.checkNotNull(r111);
        if (StringsKt.startsWith$default(r111, (String) f363415a.getValue(), false, 2, null) == false) goto L13;
        i1.f(r101.getApplication(), r103, true);
        ImageSave.f295932a.getClass();
        ImageSave.g(r103);
    L13:
        if (r112 == null) goto L16;
        r112.invoke(new a(true, r103, r102, new PolarisFileWrapper(r103).length(), r110.getWidth(), r110.getHeight()));
    L16:
        return Boolean.TRUE;
    L17:
        Intrinsics.checkNotNull(r111);
        if (StringsKt.startsWith$default(r111, (String) f363415a.getValue(), false, 2, null) == false) goto L20;
        ImageSave r113 = ImageSave.f295932a;
        String r114 = r111 + File.separator + r102;
        r113.getClass();
        ImageSave.g(r114);
    L20:
        FLogger.f375446a.w("ImageSave", "save failed");
        if (r112 == null) goto L24;
        r112.invoke(new a("", "", 48));
    L24:
        return Boolean.FALSE;
    }
}
