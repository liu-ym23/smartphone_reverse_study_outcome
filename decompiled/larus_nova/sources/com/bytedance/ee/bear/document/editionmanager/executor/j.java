package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.document.editionmanager.data.EditionListResult;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements c15.b {
    @Override // c15.b
    public final void onFail() {
        tt5.a.d("EditionNetExecutor", "onFail:" + ThreadMethodProxy.currentThread().getName());
    }

    public j() {
    }

    @Override // c15.b
    public final void a(EditionListResult r100) {
        z05.f.d(r100);
    }
}
