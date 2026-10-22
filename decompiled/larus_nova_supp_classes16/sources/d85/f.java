package d85;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements d {
    public final boolean a;
    public final g85.f b;

    public f(boolean r2) {
        this.a = false;
        this.a = r2;
        this.b = o75.b.a().getMimeTypeManager();
    }

    @Override // d85.d
    public final boolean a(w75.c r3, w75.c r4) {
        String r5 = r3.B();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "vc handle, localPreviewExt: " + r5);
        if (this.a == true) goto L6;
        return false;
    L6:
        if (yu5.c.a(r5, "pdf") == false) goto L8;
        return false;
    L8:
        if (((g85.b) this.b).e(r5) == false) goto L10;
        return false;
    L10:
        if (((g85.b) this.b).o(r5, null) == false) goto L12;
        return false;
    L12:
        if (((g85.b) this.b).j(r5, null) == true) goto L18;
        return true;
    L18:
        return false;
    }
}
