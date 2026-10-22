package com.enroll.audio.enroll.sound;

import android.media.SoundPool;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.sound.SoundPlayer$playAsync$1", f = "SoundPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SoundPlayer$playAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loop;
    final /* synthetic */ int $soundId;
    final /* synthetic */ float $volume;
    int label;

    public SoundPlayer$playAsync$1(int r100, float r101, boolean r102, Continuation<? super SoundPlayer$playAsync$1> r103) {
        this.$soundId = r100;
        this.$volume = r101;
        this.$loop = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SoundPlayer$playAsync$1(this.$soundId, this.$volume, this.$loop, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SoundPlayer$playAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        FLogger r101 = FLogger.f375446a;
        r101.i("SoundPlayer", "playAsync soundId = " + this.$soundId + ", playingSoundId = " + c.f273812b);
        if (this.$soundId != c.f273812b) goto L7;
        r101.i("SoundPlayer", "do play sound id = " + this.$soundId);
        SoundPool r102 = c.f273815e;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("soundPool");
        r102 = null;
    L11:
        SoundPool r103 = r102;
        int r104 = this.$soundId;
        float r105 = this.$volume;
        if (this.$loop == false) goto L14;
        int r106 = -1;
    L15:
        r103.play(r104, r105, r105, 0, r106, 1.0f);
        return Unit.INSTANCE;
    L14:
        r106 = 0;
        goto L15
    L7:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
