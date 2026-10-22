package jg7;

import hg7.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f499033a;

    @Override // hg7.g
    public final boolean l() {
        com.bytedance.sync.v2.net.b r100 = this.f499033a.f499037c;
        return false;
    }

    public b(d r100) {
        this.f499033a = r100;
    }

    @Override // hg7.g
    public final void F(ig7.a r100) {
        com.bytedance.sync.v2.net.b r101 = this.f499033a.f499037c;
        if (r101 == null) goto L6;
        r101.F(r100);
        return;
    }
}
