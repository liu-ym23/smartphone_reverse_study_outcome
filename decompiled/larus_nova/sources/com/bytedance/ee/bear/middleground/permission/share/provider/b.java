package com.bytedance.ee.bear.middleground.permission.share.provider;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShareProvider f234282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f234283b;

    public b(DocShareProvider r100, String r101) {
        this.f234282a = r100;
        this.f234283b = r101;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DocShareProvider", "(" + this.f234282a + ") initSecretPush - pushListener, token: " + du5.b.k(this.f234283b));
        this.f234282a.j();
    }
}
