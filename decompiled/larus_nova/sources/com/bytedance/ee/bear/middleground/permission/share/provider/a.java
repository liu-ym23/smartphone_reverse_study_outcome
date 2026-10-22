package com.bytedance.ee.bear.middleground.permission.share.provider;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShareProvider f234280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f234281b;

    public a(DocShareProvider r100, String r101) {
        this.f234280a = r100;
        this.f234281b = r101;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DocShareProvider", "(" + this.f234280a + ") initPermissionPush - pushListener, token: " + du5.b.k(this.f234281b));
        this.f234280a.j();
    }
}
