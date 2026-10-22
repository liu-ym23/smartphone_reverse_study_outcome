package sd5;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.route.parcelable.DriveRouteBean;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements e {
    public final Context a;
    public final List<Document> b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    @Override // sd5.e
    public final RouteBean a(Document r4) {
        DriveRouteBean r0 = new DriveRouteBean();
        r0.v = this.b;
        r0.f = t0.g(this.a, r4);
        Bundle r5 = new Bundle();
        r5.putString("module", this.c);
        r5.putString("sub_module", this.d);
        r5.putString("src_module", this.e);
        r5.putString("parent_token", this.f);
        r0.n = r5;
        return r0;
    }

    public b(e0 r2, String r3) {
        this.a = r2.getContext();
        this.b = r2.d;
        this.c = r2.c;
        this.d = r2.e;
        this.e = r2.f;
        this.f = r3;
    }
}
