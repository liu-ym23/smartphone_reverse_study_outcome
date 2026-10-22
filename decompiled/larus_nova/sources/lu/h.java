package lu;

import bw.u;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ju.b f510795a;

    public h(f r100) {
        this.f510795a = r100;
    }

    @Override // bw.u
    public final void a(boolean r100) {
        ju.b r101 = this.f510795a;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 3;
    L7:
        r101.onVerifyResult(r102);
        return;
    L6:
        r102 = 1;
        goto L7
    }
}
