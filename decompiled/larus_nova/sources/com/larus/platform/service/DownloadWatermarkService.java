package com.larus.platform.service;

import com.larus.platform.api.v3;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.utils.logger.FLogger;
import java.util.ArrayDeque;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class DownloadWatermarkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadWatermarkService f365700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f365701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayDeque<String> f365702c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f365703d = null;

    public DownloadWatermarkService() {
    }

    static {
        f365700a = new DownloadWatermarkService();
        f365701b = new HashSet();
        f365702c = new ArrayDeque();
        f365703d = LazyKt.lazy(new j0());
    }

    public static boolean d() {
        if (((v3) f365703d.getValue()) != null) goto L7;
        return false;
    L7:
        return e();
    }

    public static boolean e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(n0.f365775a.b()));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L11;
        FLogger.f375446a.w("DownloadWatermarkSvc", "isInEnterpriseMode failed, fallback false: " + r102);
        r101 = Boolean.FALSE;
    L11:
        if (((Boolean) r101).booleanValue() == true) goto L26;
        return false;
    L26:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(z2.f365865a.enableEnterpriseDownloadWatermark()));     // Catch: Throwable -> L16
    L18:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L23;
        FLogger.f375446a.w("DownloadWatermarkSvc", "settings read failed, fallback true: " + r104);
        r103 = Boolean.TRUE;
    L23:
        return ((Boolean) r103).booleanValue();
    L16:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        HashSet<String> r101 = f365701b;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (r101.add(r100) == true) goto L11;
        monitor-exit(r101);
        return;
    L11:
        f365702c.addLast(r100);     // Catch: Throwable -> L18
    L12:
        ArrayDeque<String> r102 = f365702c;     // Catch: Throwable -> L18
        if (r102.size() <= 128) goto L15;
        f365701b.remove(r102.removeFirst());     // Catch: Throwable -> L18
        goto L12
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r101);
    }

    public final Object a(com.larus.platform.service.watermark.a r100, Continuation<? super com.larus.platform.service.watermark.g> r101) {
        if ((r101 instanceof DownloadWatermarkService$applyWatermarkToFileAsLocal$1) == false) goto L7;
        DownloadWatermarkService$applyWatermarkToFileAsLocal$1 r102 = (DownloadWatermarkService$applyWatermarkToFileAsLocal$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L13
    L28:
        Object r107 = Result.m9449constructorimpl((com.larus.platform.service.watermark.g) r104);     // Catch: Throwable -> L13
    L31:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L38;
        FLogger.f375446a.w("DownloadWatermarkSvc", "applyWatermarkToFileAsLocal failed: " + r108);
        return new com.larus.platform.service.watermark.g.a("applyWatermarkToFileAsLocal exception: " + r108.getMessage());
    L38:
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        v3 r109 = (v3) f365703d.getValue();
        if (r109 != null) goto L22;
        return new com.larus.platform.service.watermark.g.a("service unavailable");
    L22:
        if (e() == false) goto L24;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        r102.label = 1;     // Catch: Throwable -> L13
        r104 = r109.b(r100, r102);     // Catch: Throwable -> L13
        if (r104 != r105) goto L28;
        return r105;
    L24:
        return new com.larus.platform.service.watermark.g.a("gate closed");
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new DownloadWatermarkService$applyWatermarkToFileAsLocal$1(this, r101);
        goto L8
    }

    public final Object b(LocalImageWatermarkRequest r100, Continuation<? super com.larus.platform.service.watermark.g> r101) {
        if ((r101 instanceof DownloadWatermarkService$applyWatermarkToLocalImage$1) == false) goto L7;
        DownloadWatermarkService$applyWatermarkToLocalImage$1 r102 = (DownloadWatermarkService$applyWatermarkToLocalImage$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L13
    L28:
        Object r107 = Result.m9449constructorimpl((com.larus.platform.service.watermark.g) r104);     // Catch: Throwable -> L13
    L31:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L38;
        FLogger.f375446a.w("DownloadWatermarkSvc", "applyWatermarkToLocalImage failed: " + r108);
        return new com.larus.platform.service.watermark.g.a("applyWatermarkToLocalImage exception: " + r108.getMessage());
    L38:
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        v3 r109 = (v3) f365703d.getValue();
        if (r109 != null) goto L22;
        return new com.larus.platform.service.watermark.g.a("service unavailable");
    L22:
        if (e() == false) goto L24;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        r102.label = 1;     // Catch: Throwable -> L13
        r104 = r109.c(r100, r102);     // Catch: Throwable -> L13
        if (r104 != r105) goto L28;
        return r105;
    L24:
        return new com.larus.platform.service.watermark.g.a("gate closed");
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new DownloadWatermarkService$applyWatermarkToLocalImage$1(this, r101);
        goto L8
    }

    public final Object c(com.larus.platform.service.watermark.d r100, Continuation<? super com.larus.platform.service.watermark.g> r101) {
        if ((r101 instanceof DownloadWatermarkService$exchangeWatermarkUrl$1) == false) goto L7;
        DownloadWatermarkService$exchangeWatermarkUrl$1 r102 = (DownloadWatermarkService$exchangeWatermarkUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L13
    L38:
        Object r107 = Result.m9449constructorimpl((com.larus.platform.service.watermark.g) r104);     // Catch: Throwable -> L13
    L41:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L45;
        FLogger.f375446a.w("DownloadWatermarkSvc", "exchangeWatermarkUrl failed: " + r108);
        r107 = new com.larus.platform.service.watermark.g.a("exchangeWatermarkUrl exception: " + r108.getMessage());
    L45:
        com.larus.platform.service.watermark.g r109 = (com.larus.platform.service.watermark.g) r107;
        if ((r109 instanceof com.larus.platform.service.watermark.g.b) == false) goto L48;
        com.larus.platform.service.watermark.g.b r110 = (com.larus.platform.service.watermark.g.b) r109;
    L49:
        if (r110 == null) goto L51;
        DownloadWatermarkService r111 = f365700a;
        String r112 = r110.f365853a;
        r111.getClass();
        f(r112);
    L51:
        return r107;
    L48:
        r110 = null;
        goto L49
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        String r113 = r100.f365850a;
        Intrinsics.checkNotNullParameter(r113, "url");
        if (StringsKt.isBlank(r113) == false) goto L20;
        boolean r114 = false;
    L24:
        if (r114 == false) goto L27;
        FLogger.f375446a.i("DownloadWatermarkSvc", "skip resolved watermark url");
        return new com.larus.platform.service.watermark.g.b(r100.f365850a);
    L27:
        v3 r115 = (v3) f365703d.getValue();
        if (r115 != null) goto L32;
        return new com.larus.platform.service.watermark.g.a("service unavailable");
    L32:
        if (e() == false) goto L34;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L13
        r102.label = 1;     // Catch: Throwable -> L13
        r104 = r115.a(r100, r102);     // Catch: Throwable -> L13
        if (r104 != r105) goto L38;
        return r105;
    L34:
        return new com.larus.platform.service.watermark.g.a("gate closed");
    L20:
        HashSet<String> r117 = f365701b;
        monitor-enter(r117);
        r114 = r117.contains(r113);     // Catch: Throwable -> L52
        monitor-exit(r117);
    L52:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new DownloadWatermarkService$exchangeWatermarkUrl$1(this, r101);
        goto L8
    }
}
