package pk5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements LocationHelper.b {
    public final /* synthetic */ gk5.a a;

    public d(p r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        nk5.b.e(this.a, r2);
    }

    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        nk5.b.b(this.a, r2);
    }
}
