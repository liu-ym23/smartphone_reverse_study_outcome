package z45;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m0 implements Function<DriveCache, DriveCache> {
    public final /* synthetic */ j0 a;

    public m0(j0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) throws Exception {
        DriveCache r4 = (DriveCache) r3;
        if (r4.r == true) goto L5;
        return r4;
    L5:
        if (z75.b.d(r4.b, this.a.p.b) == true) goto L9;
        tt5.a.h("DriveComponent", "fetchManualOfflineFileInOffline() current is wps fileinfo cache, ignore");
        return null;
    L9:
        return r4;
    }
}
