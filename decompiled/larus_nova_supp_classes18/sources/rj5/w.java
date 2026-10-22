package rj5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements com.bytedance.ee.bear.more.protocol3.m {
    public final /* synthetic */ v a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        if (this.a.c.isVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.c.a().isCurrentEnable("ccm.mobile.move_myaibtn_to_moremenu") == false) goto L7;
        return true;
    }

    public w(v r1) {
        this.a = r1;
    }
}
