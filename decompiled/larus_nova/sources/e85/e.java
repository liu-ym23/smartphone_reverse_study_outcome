package e85;

import b85.f0;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import i75.h;
import w75.a;

/* JADX INFO: loaded from: classes16.dex */
public final class e<FM extends w75.a> extends a<FM> {
    @Override // e85.d
    public final FM b(DriveCache r100, w75.c r101) throws DriveException {
        if (this.f471359e == true) goto L24;
        w75.a r102 = r101.getDetails();
        w75.b r103 = r102.c();
        if (((g85.b) this.f471357c.getMimeTypeManager()).d(r101.B()) == false) goto L10;
        if (((g85.b) this.f471357c.getMimeTypeManager()).l(r101.B()) == true) goto L10;
        r101.z("UNKNOWN");
    L22:
        r101.H();
        r101.k();
        return this.f471355a;
    L10:
        if (this.f471357c.getPreviewStrategy().e(r103.f558559c, r103.f558567k) == false) goto L13;
        r101.z("UNKNOWN");
        tt5.a.h("DriveComponent", "Meta Builder#setPreviewStatus() status=5 srcStatus=" + r103.f558561e);
        r103.f558561e = 5;
        goto L22
    L13:
        if (this.f471357c.getPreviewStrategy().a(r103.f558559c) == false) goto L18;
        if (h.c(this.f471357c.getMimeTypeManager(), r103.f558567k, r101.B()) == true) goto L18;
        r101.z("UNKNOWN");
        tt5.a.h("DriveComponent", "Meta Builder#setPreviewStatus() status=6 srcStatus=" + r103.f558561e);
        r103.f558561e = 6;
    L18:
        if ("ogg".equalsIgnoreCase(r101.B()) == false) goto L22;
        if ("audio/ogg".equalsIgnoreCase(r102.f558549r) == true) goto L22;
        r101.z("UNKNOWN");
        goto L22
    L24:
        return null;
    }

    public e(FM r100, f0 r101, IFileDownloadDependency r102, a95.a r103) {
        super(r100, r101, r102, r103);
    }
}
