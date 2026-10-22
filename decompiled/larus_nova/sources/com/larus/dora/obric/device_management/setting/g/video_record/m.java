package com.larus.dora.obric.device_management.setting.g.video_record;

import com.larus.dora.impl.device.settings.media.a0;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class m<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGVideoRecordSettingsFragment f340648a;

    public m(DoraObricGVideoRecordSettingsFragment r100) {
        this.f340648a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        a0 r102 = (a0) r100;
        DoraObricGVideoRecordSettingsFragment r103 = this.f340648a;
        List<DoraObricGVideoRecordSettingsFragment.VideoRecordSettingItem> r104 = DoraObricGVideoRecordSettingsFragment.f340616k;
        r103.Z90();
        return Unit.INSTANCE;
    }
}
