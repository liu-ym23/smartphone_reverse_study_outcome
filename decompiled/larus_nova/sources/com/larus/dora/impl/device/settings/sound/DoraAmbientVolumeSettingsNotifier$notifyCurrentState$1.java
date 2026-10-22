package com.larus.dora.impl.device.settings.sound;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier", f = "DoraAmbientVolumeSettingsNotifier.kt", i = {0}, l = {25}, m = "notifyCurrentState", n = {"device"}, s = {"L$0"})
public final class DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraAmbientVolumeSettingsNotifier this$0;

    public DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1(DoraAmbientVolumeSettingsNotifier r100, Continuation<? super DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
