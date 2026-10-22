package com.bytedance.common.jato.boost.hardware;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ICpuBoost {
    void init(BoostFramework r100, Context r101);

    void release();

    boolean tryBoostCpu(long r100);

    boolean tryBoostGpu(long r100);
}
