package c85;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.preload.VideoCacheInfo;
import com.bytedance.ee.bear.drive.preload.n;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements f<DriveCache, f85.a> {
    public final n a;
    public final String b;
    public final a95.a c;

    @Override // c85.f
    @Nullable
    public final LinkedHashMap<String, String> b(String r1) {
        return null;
    }

    @Override // c85.f
    public final Object a(String r5) {
        VideoCacheInfo r6 = this.a.d(r5, null);
        if (r6 != null) goto L5;
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.drive.mobile.video_little_rate") == false) goto L14;
        f85.a r1 = r6.getFileModel();
        r1.o = true;
        return r1;
    L14:
        return null;
    L5:
        if (r6.isCacheValid() == false) goto L7;
        tt5.a.h("VideoCacheInfoManager", "video file info hit cache");
        f85.a r2 = r6.getFileModel();
        r2.f(true);
        r2.o = true;
        r2.s = true;
        return r2;
    }

    public final Object apply(Object r4) throws Exception {
        DriveCache r5 = (DriveCache) r4;
        return t.a(r5.k, r5, this.b, this.c);
    }

    public c(String r2, a95.a r3) {
        this.b = r2;
        this.c = r3;
        int r0 = a95.a.d;
        this.a = new n(a95.a.b.a(r3));
    }
}
