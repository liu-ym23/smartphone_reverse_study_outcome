package com.bytedance.ies.bullet.settings;

import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.bullet.service.base.m0;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class SettingService extends s26.a implements m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f248167b;

    @Override // com.bytedance.ies.bullet.service.base.m0
    public final d a0() {
        return (d) this.f248167b.getValue();
    }

    public SettingService() {
        this.f248167b = LazyKt.lazy(SettingService$settings$2.INSTANCE);
    }
}
