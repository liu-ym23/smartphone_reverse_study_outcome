package com.bytedance.ee.bear.share.newshare;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements bu5.a {
    public final /* synthetic */ ShareDocFragment a;
    public final /* synthetic */ String b;

    public j(ShareDocFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void didReceivePush(String r2) {
        tt5.a.h("ShareDocFragment", "(" + this.a + ") initSecretPush - pushListener, token: " + du5.b.k(this.b));
        this.a.Pa0();
    }
}
