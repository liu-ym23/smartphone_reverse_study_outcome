package com.bytedance.ee.bear.profile;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements r1c.a.InterfaceC7423a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236286a;

    @Override // r1c.a.InterfaceC7423a
    public final void onClick() {
        HalfProfileActivity r100 = this.f236286a;
        if (r100.f236253o == false) goto L5;
        r100.finish();
        return;
    L5:
        r100.D1(false, true);
    }

    public f(HalfProfileActivity r100) {
        this.f236286a = r100;
    }
}
