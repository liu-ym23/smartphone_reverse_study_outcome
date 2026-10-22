package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2, 3, 3, 4, 5, 5, 6}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 706, TTVideoEngineInterface.PLAYER_OPTION_SET_PRECISE_PAUSE_PTS, 712, 718, 723, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION}, m = "resumeAfterInterruption", n = {"expectedState", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$resumeAfterInterruption$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$resumeAfterInterruption$1(d r100, Continuation<? super HardwareRecordingManager$resumeAfterInterruption$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        d r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        HardwareRecordingManager$resumeAfterInterruption$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L66;
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L28;
            case 4: goto L25;
            case 5: goto L28;
            case 6: goto L10;
            case 7: goto L28;
            default: goto L9;
        };
    L10:
        e r104 = (e) r101.L$1;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L19
        a r106 = (a) r102;     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r106, a.c.f435551a) == false) goto L14;
    L23:
        r111.f435552a = e.a(r104, HardwareRecordingSessionState.RECORDING, null, 111);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L14:
        if ((r106 instanceof a.b) == true) goto L23;
        if ((r106 instanceof a.C5196a) == false) goto L22;
        lvb.a.b(null, "[resumeAfterInterruption] resume OfficeSDK failed, session=" + r104 + ", result=" + r106);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L22:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    L25:
        e r112 = (e) r101.L$1;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L19
    L52:
        cvb.a r108 = (cvb.a) r102;     // Catch: Throwable -> L19
        if ((r108 instanceof cvb.a.C5595a) == false) goto L55;
        lvb.a.b(null, "[resumeAfterInterruption] resume hardware failed, session=" + r112 + ", result=" + r108);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L55:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    L28:
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L19
    L38:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r109.unlock(null);
        return Unit.INSTANCE;
    L31:
        r112 = (e) r101.L$1;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L62
    L46:
        b r115 = (b) r102;     // Catch: Throwable -> L62
        if (r115 == null) goto L58;
        long r116 = r112.f435556d;     // Catch: Throwable -> L62
        r101.L$0 = r114;     // Catch: Throwable -> L62
        r101.L$1 = r112;     // Catch: Throwable -> L62
        r101.label = 4;     // Catch: Throwable -> L62
        r102 = r115.resumeRecord();     // Catch: Throwable -> L62
        if (r102 != r103) goto L52;
        return r103;
    L58:
        lvb.a.b(null, "[resumeAfterInterruption] missing hardware adapter, session=" + r112);     // Catch: Throwable -> L62
        throw null;     // Catch: Throwable -> L62
    L34:
        r114 = (kotlinx.coroutines.sync.a) r101.L$1;
        HardwareRecordingSessionState r117 = (HardwareRecordingSessionState) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r118 = r111.f435552a;     // Catch: Throwable -> L62
        if (r118 != null) goto L41;
        r109 = r114;
        goto L38
    L41:
        if (r118.f435557e != r117) goto L60;
        r101.L$0 = r114;     // Catch: Throwable -> L62
        r101.L$1 = r118;     // Catch: Throwable -> L62
        r101.label = 2;     // Catch: Throwable -> L62
        Object r119 = r111.n(r118, "resumeAfterInterruption", r101);     // Catch: Throwable -> L62
        if (r119 == r103) goto L69;
        r102 = r119;
        r112 = r118;
        goto L46
    L69:
        return r103;
    L60:
        lvb.a.e(null, "[resumeAfterInterruption] ignore unexpected session=" + r118 + ", expectedState=" + r117);     // Catch: Throwable -> L62
        throw null;     // Catch: Throwable -> L62
    L66:
        ResultKt.throwOnFailure(r102);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 1;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L62:
        th = th;
        ?? r120 = "[resumeAfterInterruption] resume OfficeSDK failed, session=";
    L64:
        r120.unlock(null);
        throw th;
    L19:
        th = th;
        r120 = r101;
        goto L64
    L5:
        r101 = new HardwareRecordingManager$resumeAfterInterruption$1(r111, this);
        goto L6
    }
}
