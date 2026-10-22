package com.bytedance.ee.bear.drive.biz.comment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b1 implements o1 {
    public final /* synthetic */ a1 a;

    public final boolean a() {
        if (this.a.G.livePerm().getValue() != null) goto L6;
        return false;
    L6:
        if (((u55.b) this.a.G.livePerm().getValue()).a() == true) goto L8;
        return false;
    L8:
        if (this.a.F.isHistoryMode() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public b1(a1 r1) {
        this.a = r1;
    }
}
