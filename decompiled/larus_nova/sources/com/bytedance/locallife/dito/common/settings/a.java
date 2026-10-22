package com.bytedance.locallife.dito.common.settings;

import com.bytedance.locallife.dito.common.experiment.DitoSettingsCache;
import com.bytedance.locallife.dito.config.h;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements h {
    public a() {
    }

    @Override // com.bytedance.locallife.dito.config.h
    public final boolean a() {
        Lazy r100 = DitoSettingsCache.f257345a;
        return ((Boolean) DitoSettingsCache.f257345a.getValue()).booleanValue();
    }
}
