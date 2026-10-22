package com.larus.dora.obric.device_management.setting.common.sound;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class g<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricSoundSettingsFragment f339675a;

    public g(DoraObricSoundSettingsFragment r100) {
        this.f339675a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        DoraObricSoundSettingsFragment r102 = this.f339675a;
        DoraObricSoundSettingsFragment.X90(r102, (com.larus.dora.impl.device.settings.sound.a) r100);
        return Unit.INSTANCE;
    }
}
