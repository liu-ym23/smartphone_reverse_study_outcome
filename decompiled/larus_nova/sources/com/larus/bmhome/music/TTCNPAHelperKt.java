package com.larus.bmhome.music;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaCallback;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.service.z2;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class TTCNPAHelperKt {

    public static final class a implements TtCnpaCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Integer> f312714a;

        public a(SafeContinuation r100) {
            this.f312714a = r100;
        }

        @Override // com.bytedance.ttcnpa.TtCnpaCallback
        public final void onResult(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorDesc");
            Integer r102 = Integer.valueOf(r100);
            this.f312714a.resumeWith(Result.m9449constructorimpl(r102));
        }
    }

    public static final Object a(String r100, String r101, Continuation<? super Integer> r102) {
        if ((r102 instanceof TTCNPAHelperKt$appendTTCNPAFlag$1) == false) goto L7;
        TTCNPAHelperKt$appendTTCNPAFlag$1 r103 = (TTCNPAHelperKt$appendTTCNPAFlag$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        String r108 = (String) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L28:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (String) r103.L$1;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L23:
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 2;
        SafeContinuation r110 = new SafeContinuation(IntrinsicsKt.intercepted(r103));
        TTCNPA.f271037a.a(r100, r100, r101, new a(r110));
        r105 = r110.getOrThrow();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L26:
        if (r105 != r106) goto L28;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        if (z2.f365865a.enableMusicSaveTtcnpa() == false) goto L19;
        TTCNPAHelper r111 = TTCNPAHelper.f312711a;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (r111.a(r103) != r106) goto L23;
        return r106;
    L19:
        return Boxing.boxInt(0);
    L7:
        r103 = new TTCNPAHelperKt$appendTTCNPAFlag$1(r102);
        goto L8
    }

    public static final Object b(String r100, MusicCreationContent r101, Continuation<? super Integer> r102) {
        if ((r102 instanceof TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1) == false) goto L7;
        TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1 r103 = (TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L33
    L28:
        if (((Number) r105).intValue() == 0) goto L31;
        new PolarisFileWrapper(r100).delete();     // Catch: Throwable -> L33
        return Boxing.boxInt(102);
    L31:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L36:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L40;
        new PolarisFileWrapper(r100).delete();
        return Boxing.boxInt(102);
    L40:
        return Boxing.boxInt(0);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        if (AppHost.f326268a.isOversea() == true) goto L19;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L33
        String r110 = r101.getVid();     // Catch: Throwable -> L33
        if (r110 == null) goto L23;
        r103.L$0 = r100;     // Catch: Throwable -> L33
        r103.label = 1;     // Catch: Throwable -> L33
        r105 = a(r100, r110, r103);     // Catch: Throwable -> L33
        if (r105 != r106) goto L28;
        return r106;
    L23:
        return Boxing.boxInt(102);
    L19:
        return Boxing.boxInt(0);
    L33:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1(r102);
        goto L8
    }
}
