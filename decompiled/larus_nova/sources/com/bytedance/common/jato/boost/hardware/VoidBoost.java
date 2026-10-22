package com.bytedance.common.jato.boost.hardware;

import android.content.Context;

/* JADX INFO: loaded from: classes15.dex */
public class VoidBoost implements ICpuBoost {
    public VoidBoost() {
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void init(BoostFramework r100, Context r101) {
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void release() {
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostCpu(long r100) {
        return false;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostGpu(long r100) {
        return false;
    }
}
