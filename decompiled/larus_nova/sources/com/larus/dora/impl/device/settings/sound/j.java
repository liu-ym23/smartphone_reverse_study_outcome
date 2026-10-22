package com.larus.dora.impl.device.settings.sound;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class j<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoundSettingsFragment f334919a;

    public j(SoundSettingsFragment r100) {
        this.f334919a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        SoundSettingsFragment r102 = this.f334919a;
        SoundSettingsFragment.W90(r102, (a) r100);
        return Unit.INSTANCE;
    }
}
