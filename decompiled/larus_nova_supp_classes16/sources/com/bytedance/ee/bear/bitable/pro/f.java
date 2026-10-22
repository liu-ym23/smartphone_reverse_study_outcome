package com.bytedance.ee.bear.bitable.pro;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements BitableProViewModel.a {
    public final /* synthetic */ BitableProFragment a;

    @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.a
    public final void success() {
        tt5.a.h(this.a.v, "click back update success");
    }

    public f(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.a
    public final void a(int r4) {
        tt5.a.d(this.a.v, "click back update fail " + r4);
    }
}
