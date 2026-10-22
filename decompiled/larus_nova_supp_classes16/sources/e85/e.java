package e85;

import b85.f0;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import i75.h;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<FM extends w75.a> extends a<FM> {
    @Override // e85.d
    public final FM b(DriveCache r7, w75.c r8) throws DriveException {
        if (this.e == true) goto L24;
        w75.a r9 = r8.getDetails();
        w75.b r0 = r9.c();
        if (((g85.b) this.c.getMimeTypeManager()).d(r8.B()) == false) goto L10;
        if (((g85.b) this.c.getMimeTypeManager()).l(r8.B()) == true) goto L10;
        r8.z("UNKNOWN");
    L22:
        r8.H();
        r8.k();
        return this.a;
    L10:
        if (this.c.getPreviewStrategy().e(r0.c, r0.k) == false) goto L13;
        r8.z("UNKNOWN");
        tt5.a.h("DriveComponent", "Meta Builder#setPreviewStatus() status=5 srcStatus=" + r0.e);
        r0.e = 5;
        goto L22
    L13:
        if (this.c.getPreviewStrategy().a(r0.c) == false) goto L18;
        if (h.c(this.c.getMimeTypeManager(), r0.k, r8.B()) == true) goto L18;
        r8.z("UNKNOWN");
        tt5.a.h("DriveComponent", "Meta Builder#setPreviewStatus() status=6 srcStatus=" + r0.e);
        r0.e = 6;
    L18:
        if ("ogg".equalsIgnoreCase(r8.B()) == false) goto L22;
        if ("audio/ogg".equalsIgnoreCase(r9.r) == true) goto L22;
        r8.z("UNKNOWN");
        goto L22
    L24:
        return null;
    }

    public e(FM r1, f0 r2, IFileDownloadDependency r3, a95.a r4) {
        super(r1, r2, r3, r4);
    }
}
