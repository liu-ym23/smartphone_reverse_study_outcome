package com.bytedance.ee.bear.bitable.lynx;

import com.lynx.tasm.q1;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends q1 {
    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        int r100 = BitableModalLynxFragment.M;
        tt5.a.h("BitableModalLynxFragment", "onLoadSuccess");
    }

    public d() {
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadFailed(String r100) {
        super.onLoadFailed(r100);
        int r101 = BitableModalLynxFragment.M;
        tt5.a.h("BitableModalLynxFragment", "onLoadFailed: " + r100);
    }
}
