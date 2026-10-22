package com.bytedance.ee.bear.middleground.permission.share.provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements bu5.a {
    public final /* synthetic */ DocShareProvider a;
    public final /* synthetic */ String b;

    public b(DocShareProvider r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void didReceivePush(String r2) {
        tt5.a.h("DocShareProvider", "(" + this.a + ") initSecretPush - pushListener, token: " + du5.b.k(this.b));
        this.a.j();
    }
}
