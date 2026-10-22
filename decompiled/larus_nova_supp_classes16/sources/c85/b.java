package c85;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.config.strategy.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class b extends a<f85.a> {
    @Override // c85.e
    public final String a(w75.c<f85.a> r2) {
        return this.b.i(r2.getDetails());
    }

    public b(com.bytedance.ee.bear.drive.config.strategy.d r1, a95.a r2) {
        super(r1, r2);
    }

    @Override // c85.a
    public boolean d(DriveCache r2, w75.c<f85.a> r3) {
        boolean r4 = super.d(r2, r3);
        if (r4 == true) goto L5;
    L12:
        return r4;
    L5:
        if ((this.b instanceof m) == false) goto L12;
        DriveFilePath r5 = r2.b;
        if (r5 != null) goto L9;
    L10:
        tt5.a.h("DriveComponent", "DriveCacheHandler#availableCache() not enable streaming and not found cache in vc");
        return false;
    L9:
        if (z75.b.d(r5, this.d.b) == true) goto L12;
        goto L10
    }
}
