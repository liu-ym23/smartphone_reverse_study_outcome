package i75;

import android.app.Application;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static DriveFilePath a(int r1) {
        if (r1 != 0) goto L4;
    L7:
        Application r2 = eu5.b.a;
        return t.f();
    L4:
        if (r1 == 2) goto L7;
        Application r3 = eu5.b.a;
        return t.j();
    }
}
