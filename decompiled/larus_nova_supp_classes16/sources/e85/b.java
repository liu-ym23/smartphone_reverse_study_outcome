package e85;

import android.text.TextUtils;
import b85.f0;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import i75.h;
import java.util.LinkedHashMap;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<FM extends w75.a> extends a<FM> {
    public final c85.f<DriveCache, FM> g;

    @Override // e85.d
    public final FM b(DriveCache r9, w75.c r10) throws DriveException {
        String r0 = r10.getDetails().c().k;
        boolean r2 = false;
        if (h.i(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        f0 r3 = this.b;
        if (r3 == null) goto L14;
        g75.a r4 = r3.f;
        if (r4 == null) goto L14;
        boolean r5 = r4.isWpsCostOptimization(r10.getDetails(), false);
    L15:
        o75.b.a().getDriveConfig();
        g85.f r6 = o75.b.a().getMimeTypeManager();
        String r7 = r10.I();
        String r8 = r10.B();
        String r11 = r10.getExtra();
        g85.b r12 = (g85.b) r6;
        if (r12.g(r7) == false) goto L23;
        if (r12.i(r8, null) == false) goto L23;
        if (TextUtils.isEmpty(r11) == false) goto L23;
        r2 = true;
    L23:
        if ((!r2) == false) goto L74;
        if (((g85.b) this.c.getMimeTypeManager()).d(r10.B()) == true) goto L72;
        if (this.c.getPreviewStrategy().e(r10.getFileSize(), r10.I()) == true) goto L70;
        if (((g85.b) this.c.getMimeTypeManager()).o(r10.B(), r10.r()) == false) goto L38;
        FM r13 = (FM) this.g.a(this.b.a);
        if (r13 == null) goto L33;
        return r13;
    L33:
        LinkedHashMap<String, String> r14 = this.g.b(r10.getFileToken());
        if (r14 != null) goto L36;
    L67:
        r10.H();
        r10.k();
        return this.a;
    L36:
        if (r14.size() <= 0) goto L67;
        r10.u(r14);
        goto L67
    L38:
        if (r1 == false) goto L54;
        if (this.d == false) goto L54;
        if (r9.r == false) goto L54;
        if (r5 == true) goto L52;
        f0 r16 = this.b;
        if (r16.b == true) goto L50;
        if (r16.c == true) goto L50;
        r10.K(2);
    L50:
        throw new DriveException(ErrCode.DEFAULT, "not support wps cache in vcfollow mode or history model vc=" + this.b.b);
    L52:
        throw new DriveException(ErrCode.DEFAULT, "not support wps cache when isWpsCostOptimization is " + r5);
    L54:
        if ("ogg".equalsIgnoreCase(r10.I()) == false) goto L61;
        if (TextUtils.isEmpty(r10.getDetails().r) == false) goto L61;
        throw new DriveException(ErrCode.DEFAULT, "not support ogg file with empty mime type");
    L61:
        if ("txt".equalsIgnoreCase(r10.I()) == false) goto L67;
        if ("3".equals(r10.getDetails().v) == false) goto L67;
        throw new DriveException(ErrCode.DEFAULT, "not support upload txt file cache");
    L70:
        throw new DriveException(ErrCode.DEFAULT, "not support, local is oversize");
    L72:
        throw new DriveException(ErrCode.DEFAULT, "not support, local is archive");
    L74:
        throw new DriveException(ErrCode.DEFAULT, "not support local cache");
    L14:
        r5 = false;
        goto L15
    L5:
        if (q75.b.a(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public b(FM r1, f0 r2, IFileDownloadDependency r3, c85.f<DriveCache, FM> r4, a95.a r5) {
        super(r1, r2, r3, r5);
        this.g = r4;
    }
}
