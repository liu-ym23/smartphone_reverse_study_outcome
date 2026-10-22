package com.bytedance.dux.drawable.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/drawable/api/DoubleColorInitConfigServiceDefault;", "Lcom/bytedance/dux/drawable/api/IDoubleColorInitConfigService;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DoubleColorInitConfigServiceDefault implements IDoubleColorInitConfigService {
    @Override // com.bytedance.dux.drawable.api.IDoubleColorInitConfigService
    public final long getExpDelayTime() {
        return 32;
    }

    @Override // com.bytedance.dux.drawable.api.IDoubleColorInitConfigService
    public final String[] getSupportSceneList() {
        return null;
    }

    @Override // com.bytedance.dux.drawable.api.IDoubleColorInitConfigService
    public final boolean isOpenInvalidateDelayExp() {
        return false;
    }

    @Override // com.bytedance.dux.drawable.api.IDoubleColorInitConfigService
    public final boolean isUseNewAnimation() {
        return false;
    }

    public DoubleColorInitConfigServiceDefault() {
    }
}
