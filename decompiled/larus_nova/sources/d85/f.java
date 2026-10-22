package d85;

import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f467407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g85.f f467408b;

    public f(boolean r100) {
        this.f467407a = false;
        this.f467407a = r100;
        this.f467408b = o75.b.a().getMimeTypeManager();
    }

    @Override // d85.d
    public final boolean a(w75.c r100, w75.c r101) {
        String r102 = r100.B();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "vc handle, localPreviewExt: " + r102);
        if (this.f467407a == true) goto L6;
        return false;
    L6:
        if (yu5.c.a(r102, ExportFileExtension.PDF) == false) goto L8;
        return false;
    L8:
        if (((g85.b) this.f467408b).e(r102) == false) goto L10;
        return false;
    L10:
        if (((g85.b) this.f467408b).o(r102, null) == false) goto L12;
        return false;
    L12:
        if (((g85.b) this.f467408b).j(r102, null) == true) goto L18;
        return true;
    L18:
        return false;
    }
}
