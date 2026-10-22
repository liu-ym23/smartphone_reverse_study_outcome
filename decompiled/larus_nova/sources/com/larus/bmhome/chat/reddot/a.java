package com.larus.bmhome.chat.reddot;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nf9.e f308494a;

    @Override // com.larus.bmhome.chat.reddot.j
    public final String b() {
        nf9.e r100 = this.f308494a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public a(nf9.e r100) {
        this.f308494a = r100;
    }

    @Override // com.larus.bmhome.chat.reddot.j
    public final void a(int r100) {
        nf9.e r101 = this.f308494a;
        if (r101 == null) goto L6;
        r101.onUpdate(r100);
        return;
    }
}
