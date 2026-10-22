package com.larus.dora.obric.device_management.setting.common.sound;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class k<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricSoundSettingsFragment f339679a;

    public k(DoraObricSoundSettingsFragment r100) {
        this.f339679a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        com.larus.dora.impl.device.settings.sound.l r102 = (com.larus.dora.impl.device.settings.sound.l) r100;
        if (Intrinsics.areEqual(r102, com.larus.dora.impl.device.settings.sound.l.a.f334921a) == true) goto L12;
        if (Intrinsics.areEqual(r102, com.larus.dora.impl.device.settings.sound.l.b.f334922a) == true) goto L12;
        if ((r102 instanceof com.larus.dora.impl.device.settings.sound.l.c) == false) goto L10;
        DoraObricSoundSettingsFragment.Y90(this.f339679a, ((com.larus.dora.impl.device.settings.sound.l.c) r102).f334923a);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return Unit.INSTANCE;
    }
}
