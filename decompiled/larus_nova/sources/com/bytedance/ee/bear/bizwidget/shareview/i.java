package com.bytedance.ee.bear.bizwidget.shareview;

/* JADX INFO: loaded from: classes16.dex */
public abstract class i implements b {
    public i() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public void s10(ShareType r100) {
        tt5.a.h("SimpleShareItemClickListener", "doShareTo, not override, shareType: " + r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public void xq(ShareType r100, String r101, int r102) {
        tt5.a.h("SimpleShareItemClickListener", "onCacControlled, not override, shareType: " + r100 + ", token: " + du5.b.i(r101) + ", type: " + r102);
    }
}
