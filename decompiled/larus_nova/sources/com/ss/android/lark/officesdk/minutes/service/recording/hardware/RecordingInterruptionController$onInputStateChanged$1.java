package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, 223}, m = "onInputStateChanged", n = {"playbackState", "action", "$this$withLock_u24default$iv", "earbudsConnected"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class RecordingInterruptionController$onInputStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onInputStateChanged$1(RecordingInterruptionController r100, Continuation<? super RecordingInterruptionController$onInputStateChanged$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [T, com.ss.android.lark.officesdk.minutes.service.recording.hardware.k$d] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        RecordingInterruptionController$onInputStateChanged$1 r101 = this;
    L6:
        Object r102 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r101.label;
        if (r103 != 0) goto L9;
        ResultKt.throwOnFailure(r102);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r101.L$0 = null;
        r101.L$1 = r112;
        r101.L$2 = null;
        r101.Z$0 = false;
        r101.label = 1;
        throw null;
    L9:
        if (r103 == 1) goto L14;
        if (r103 != 2) goto L13;
        ResultKt.throwOnFailure(r102);
    L34:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        boolean r104 = r101.Z$0;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r101.L$2;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r101.L$1;
        HardwarePlaybackState r107 = (HardwarePlaybackState) r101.L$0;
        ResultKt.throwOnFailure(r102);
        r111.f435535a = r107;     // Catch: Throwable -> L57
        if (r111.f435538d == false) goto L30;
        if (r104 == false) goto L30;
        if (r107 != HardwarePlaybackState.APP_CALL) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == false) goto L30;
        r111.f435538d = false;     // Catch: Throwable -> L57
        r111.f435539e = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L57
        Job r109 = r111.f435545k;     // Catch: Throwable -> L57
        if (r109 == null) goto L29;
        Job.DefaultImpls.cancel$default(r109, null, 1, null);     // Catch: Throwable -> L57
    L29:
        r111.f435545k = null;     // Catch: Throwable -> L57
        r106.element = k.d.f435573a;     // Catch: Throwable -> L57
        goto L30
    L21:
        if (r107 == HardwarePlaybackState.SYS_CALL) goto L24;
        r108 = false;
    L30:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L57
        r105.unlock(null);
        k r114 = (k) r106.element;
        if (r114 == null) goto L34;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 2;
        if ((r114 instanceof k.e) == false) goto L38;
        k.e r115 = (k.e) r114;
        throw null;
    L38:
        if ((r114 instanceof k.f) == false) goto L40;
        k.f r116 = (k.f) r114;
        throw null;
    L40:
        if (Intrinsics.areEqual(r114, k.c.f435572a) == false) goto L42;
        throw null;
    L42:
        if (Intrinsics.areEqual(r114, k.d.f435573a) == false) goto L44;
        throw null;
    L44:
        if (Intrinsics.areEqual(r114, k.b.f435571a) == false) goto L46;
        throw null;
    L46:
        if (Intrinsics.areEqual(r114, k.a.f435570a) == false) goto L49;
        throw null;
    L49:
        throw new NoWhenBranchMatchedException();
    L57:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L5:
        r101 = new RecordingInterruptionController$onInputStateChanged$1(r111, this);
        goto L6
    }
}
