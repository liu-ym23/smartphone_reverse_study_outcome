package i75;

import android.app.Application;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;

/* JADX INFO: loaded from: classes16.dex */
public final class f {
    public static DriveFilePath a(int r100) {
        if (r100 != 0) goto L4;
    L7:
        Application r101 = eu5.b.f474075a;
        return t.f();
    L4:
        if (r100 == 2) goto L7;
        Application r102 = eu5.b.f474075a;
        return t.j();
    }
}
