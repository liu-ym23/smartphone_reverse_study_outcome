package com.larus.office.base.watermark.local;

import android.graphics.Bitmap;
import com.larus.office.base.service.IOfficeWatermarkSdkService;
import com.larus.office.base.service.o;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.b;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes29.dex */
public final class LocalImageBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalImageBridge f361240a = null;

    static {
        f361240a = new LocalImageBridge();
    }

    public LocalImageBridge() {
    }

    public static Object b(LocalImageWatermarkRequest r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalImageBridge$apply$2(r100, null), r101);
    }

    public static final Object a(LocalImageBridge r100, LocalImageWatermarkRequest r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof LocalImageBridge$getWatermarkedResource$1) == false) goto L7;
        LocalImageBridge$getWatermarkedResource$1 r101 = (LocalImageBridge$getWatermarkedResource$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L64:
        Object r105 = Result.m9449constructorimpl((o) r103);     // Catch: Throwable -> L13
    L67:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r105);
        if (r113 == null) goto L81;
        FLogger.f375446a.w("LocalImageBridge", "getWatermarkedImageResource failed: " + r113);
    L72:
        return null;
    L81:
        return r105;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        IOfficeWatermarkSdkService r106 = (IOfficeWatermarkSdkService) ServiceManager.get().getService(IOfficeWatermarkSdkService.class);
        if (r106 == null) goto L72;
        b r107 = r110.f365823a;
        if ((r107 instanceof b.C4473b) == false) goto L23;
        b.C4473b r108 = (b.C4473b) r107;
    L24:
        if (r108 == null) goto L26;
        String r109 = r108.f365847a;
    L28:
        if ((r107 instanceof b.a) == false) goto L30;
        b.a r114 = (b.a) r107;
    L31:
        if (r114 == null) goto L51;
        Bitmap r115 = r114.f365846a;
        if (r115 == null) goto L51;
        f361240a.getClass();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L44
        ByteArrayOutputStream r117 = new ByteArrayOutputStream();     // Catch: Throwable -> L44
        r115.compress(Bitmap.CompressFormat.JPEG, 85, r117);     // Catch: Throwable -> L39
        byte[] r118 = r117.toByteArray();     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L44
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L44
    L46:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L50;
        FLogger.f375446a.w("LocalImageBridge", "bitmapToBytes failed: " + r120);
        r119 = null;
    L50:
        byte[] r121 = (byte[]) r119;
    L52:
        if (r109 != null) goto L54;
    L57:
        boolean r122 = true;
    L58:
        if (r122 == false) goto L61;
        if (r121 == null) goto L72;
    L61:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L13
        String r124 = r110.f365825c.getSubScene();     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        r103 = r106.L(r124, r109, r121, r101);     // Catch: Throwable -> L13
        if (r103 != r112) goto L64;
        return r112;
    L54:
        if (r109.length() == 0) goto L57;
        r122 = false;
        goto L58
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L51:
        r121 = null;
        goto L52
    L30:
        r114 = null;
        goto L31
    L26:
        r109 = null;
        goto L28
    L23:
        r108 = null;
    L13:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new LocalImageBridge$getWatermarkedResource$1(r100, r111);
        goto L8
    }
}
