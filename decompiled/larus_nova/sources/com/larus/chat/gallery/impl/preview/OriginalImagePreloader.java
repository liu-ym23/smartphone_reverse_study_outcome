package com.larus.chat.gallery.impl.preview;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes26.dex */
public final class OriginalImagePreloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OriginalImagePreloader f324211a = null;

    static {
        f324211a = new OriginalImagePreloader();
    }

    public OriginalImagePreloader() {
    }

    public final Object b(String r100, String r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof OriginalImagePreloader$awaitReady$1) == false) goto L7;
        OriginalImagePreloader$awaitReady$1 r103 = (OriginalImagePreloader$awaitReady$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        boolean r108 = Intrinsics.areEqual(r105, Boxing.boxBoolean(true));
        FLogger.f375446a.i("OriginalImagePreloader", "awaitReady: result=" + r108);
        return Boxing.boxBoolean(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        OriginalImagePreloader$awaitReady$result$1 r109 = new OriginalImagePreloader$awaitReady$result$1(r100, r101, null);
        r103.label = 1;
        r105 = TimeoutKt.c(5000, r109, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OriginalImagePreloader$awaitReady$1(this, r102);
        goto L8
    }

    public static final Object a(OriginalImagePreloader r100, String r110, String r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof OriginalImagePreloader$awaitPrefetchReady$1) == false) goto L7;
        OriginalImagePreloader$awaitPrefetchReady$1 r101 = (OriginalImagePreloader$awaitPrefetchReady$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        DataSource r114 = (DataSource) r101.L$2;
        String r115 = (String) r101.L$1;
        String r116 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L25:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (String) r101.L$1;
        r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L19:
        DataSource r105 = (DataSource) r103;
        r101.L$0 = r110;
        r101.L$1 = r111;
        r101.L$2 = r105;
        r101.label = 2;
        kotlinx.coroutines.j r106 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r106.C();
        r105.subscribe(new a(r111, r110, r106), CallerThreadExecutor.getInstance());
        r106.i(new b(r105));
        r103 = r106.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L22:
        if (r103 != r113) goto L25;
        return r113;
    L16:
        ResultKt.throwOnFailure(r103);
        r101.L$0 = r110;
        r101.L$1 = r111;
        r101.label = 1;
        r103 = ImageLoaderKt.C(r110, r111, null, null, r101, 60);
        if (r103 != r113) goto L19;
        return r113;
    L7:
        r101 = new OriginalImagePreloader$awaitPrefetchReady$1(r100, r112);
        goto L8
    }
}
