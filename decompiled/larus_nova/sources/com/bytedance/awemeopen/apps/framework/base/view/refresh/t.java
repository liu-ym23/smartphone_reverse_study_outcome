package com.bytedance.awemeopen.apps.framework.base.view.refresh;

/* JADX INFO: loaded from: classes14.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f193454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f193456c;

    public abstract void a();

    public t() {
        this.f193455b = true;
    }

    static {
    }

    public final void b(boolean r100) {
        if (this.f193455b != r100) goto L5;
        return;
    L5:
        this.f193455b = r100;
        if (r100 == false) goto L18;
        Boolean r101 = this.f193456c;
        if (r101 == null) goto L19;
        boolean r102 = r101.booleanValue();
        if (this.f193454a != r102) goto L13;
    L16:
        this.f193456c = null;
        return;
    L13:
        if (this.f193455b == true) goto L15;
        this.f193456c = Boolean.valueOf(r102);
        goto L16
    L15:
        this.f193454a = r102;
        a();
        goto L16
    L19:
        return;
    }
}
