package sd5;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements e {
    public final Context a;

    public a(Context r1) {
        this.a = r1;
    }

    @Override // sd5.e
    public final RouteBean a(Document r4) {
        RouteBean r0 = new RouteBean();
        r0.f = t0.g(this.a, r4);
        Bundle r1 = new Bundle();
        r1.putString("wiki_version", r4.a());
        r0.n = r1;
        return r0;
    }
}
