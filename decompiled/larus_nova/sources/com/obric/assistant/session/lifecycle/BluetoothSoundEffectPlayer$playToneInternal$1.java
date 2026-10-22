package com.obric.assistant.session.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.BluetoothSoundEffectPlayer", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {205, 207}, m = "playToneInternal", n = {}, s = {})
final class BluetoothSoundEffectPlayer$playToneInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BluetoothSoundEffectPlayer this$0;

    public BluetoothSoundEffectPlayer$playToneInternal$1(BluetoothSoundEffectPlayer r100, Continuation<? super BluetoothSoundEffectPlayer$playToneInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return BluetoothSoundEffectPlayer.d(this.this$0, this);
    }
}
