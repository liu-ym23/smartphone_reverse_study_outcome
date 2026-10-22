package com.larus.security.api;

import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaManifest;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.k3;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class TTCNPAHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TTCNPAHelper f367850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f367851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f367852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<kotlinx.coroutines.i<Unit>> f367853d = null;

    public TTCNPAHelper() {
    }

    static {
        f367850a = new TTCNPAHelper();
        f367853d = new ArrayList();
    }

    public static final String a(TTCNPAHelper r100, l r101) {
        r100.getClass();
        if (r101 != null) goto L6;
        return "null";
    L6:
        return "{label=" + r101.f367861a + ", contentProducer=" + r101.f367862b + ", produceId=" + r101.f367863c + ", reservedCode1=" + r101.f367864d + ", contentPropagator=" + r101.f367865e + ", propagateId=" + r101.f367866f + ", reservedCode2=" + r101.f367867g + com.alipay.sdk.m.u.i.f25855d;
    }

    public static final l b(TTCNPAHelper r100, TtCnpaManifest r101) {
        r100.getClass();
        return new l(r101.getLabel(), r101.getContentProducer(), r101.getProduceId(), r101.getReservedCode1(), r101.getContentPropagator(), r101.getPropagateId(), r101.getReservedCode2());
    }

    public final Object d(m r110, Continuation<? super n> r111) {
        if ((r111 instanceof TTCNPAHelper$writeMetadataManually$1) == false) goto L7;
        TTCNPAHelper$writeMetadataManually$1 r100 = (TTCNPAHelper$writeMetadataManually$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L43:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (m) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L31
    L29:
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L40;
        FLogger.f375446a.e("TTCNPAHelper", "writeMetadataManually init failed", r114);
        String r115 = r114.getMessage();
        if (r115 != null) goto L39;
        r115 = "";
    L39:
        return new n(false, -3, r115, null, null);
    L40:
        CoroutineDispatcher r116 = Dispatchers.getIO();
        TTCNPAHelper$writeMetadataManually$4 r104 = new TTCNPAHelper$writeMetadataManually$4(r110, null);
        r100.L$0 = null;
        r100.label = 2;
        r112 = BuildersKt.withContext(r116, r104, r100);
        if (r112 != r102) goto L43;
        return r102;
    L18:
        ResultKt.throwOnFailure(r112);
        AppHost.Companion r117 = AppHost.f326268a;
        if (r117.isOversea() == false) goto L23;
        return new n(true, 0, "", null, null);
    L23:
        if (StringsKt.isBlank(r110.f367872e) == true) goto L25;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L31
        r117.getApplication();     // Catch: Throwable -> L31
        String r118 = r110.f367871d;     // Catch: Throwable -> L31
        String r106 = r110.f367874g;     // Catch: Throwable -> L31
        r100.L$0 = r110;     // Catch: Throwable -> L31
        r100.label = 1;     // Catch: Throwable -> L31
        if (c(r118, r106, r100) != r102) goto L29;
        return r102;
    L25:
        return new n(false, -1, "empty produceId", null, null);
    L31:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new TTCNPAHelper$writeMetadataManually$1(this, r111);
        goto L8
    }

    public static Object c(String r100, String r101, Continuation r110) {
        boolean r102 = true;
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r110), 1);
        r103.C();
        if (AppHost.f326268a.isOversea() == false) goto L5;
        Result.Companion r104 = Result.Companion;
        r103.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    L34:
        Object r105 = r103.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L38:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        return r105;
    L41:
        return Unit.INSTANCE;
    L5:
        final TTCNPAHelper r106 = f367850a;
        monitor-enter(r106);
        boolean r107 = false;
        if (f367852c == true) goto L16;
        TTCNPA.f271037a.getClass();     // Catch: Throwable -> L42
        if (TTCNPA.f271038b == true) goto L16;
        ((ArrayList) f367853d).add(r103);     // Catch: Throwable -> L42
        if (f367851b == true) goto L15;
        f367851b = true;     // Catch: Throwable -> L42
        r102 = false;
        r107 = true;
    L17:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r106);
        if (r102 == false) goto L21;
        Result.Companion r109 = Result.Companion;
        r103.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L34
    L21:
        r103.i(new k(r103));
        if (r107 == false) goto L34;
        final TTCNPAHelper$initIfNeeded$2$3 r111 = new TTCNPAHelper$initIfNeeded$2$3(r106);
        TTCNPAHelper$initIfNeeded$2$4 r112 = new TTCNPAHelper$initIfNeeded$2$4(r106);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L29
        k3 r114 = k3.f365757a;     // Catch: Throwable -> L29
        if (r114.isInitialized() == false) goto L27;
        FLogger.f375446a.i("TTCNPAHelper", "ttcnpa already initialized");     // Catch: Throwable -> L29
        r111.invoke();     // Catch: Throwable -> L29
        goto L34
    L27:
        r114.a(r100, r101, new i(r106), new j(r111));     // Catch: Throwable -> L29
        FLogger.f375446a.i("TTCNPAHelper", "ttcnpa init started contentProducer=" + r100 + " contentPropagator=" + r101);     // Catch: Throwable -> L29
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L34;
        FLogger.f375446a.e("TTCNPAHelper", "ttcnpa init failed", r116);
        r112.invoke(r116);
    L29:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L15:
        r102 = false;
    L16:
        f367852c = true;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }
}
