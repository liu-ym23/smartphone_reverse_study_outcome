package sd5;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderRouteBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements e {
    public final Context a;
    public final String b;
    public final int c;
    public final String d;

    @Override // sd5.e
    public final RouteBean a(Document r3) {
        FolderRouteBean r0 = new FolderRouteBean();
        r0.w = r3.m;
        r0.D = this.d;
        r0.x = this.b;
        r0.v = this.c;
        r0.y = r3.U;
        r0.z = r3.T;
        r0.f = t0.g(this.a, r3);
        r0.B = r3.x;
        int r1 = r3.L1;
        r0.A = r1;
        r0.C = FolderVersion.isPersonalFolder(r1, r3.P1);
        return r0;
    }

    public c(Context r1, String r2, int r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
