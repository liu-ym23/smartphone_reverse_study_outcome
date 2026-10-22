package q30;

import com.bytedance.android.live.schema.api.e;
import com.bytedance.android.monitorV2.g;
import jz2.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements e {
    public c() {
    }

    @Override // com.bytedance.android.live.schema.api.e
    public final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r104, "common");
        d.a r105 = new d.a(r100);
        r105.f501114b = "webcast_cn_container";
        r105.f501116d = r101;
        r105.f501117e = r102;
        r105.f501118f = r103;
        r105.f501120h = r104;
        r105.b(0);
        d r106 = r105.a();
        g.e().getClass();
        g.c(r106);
    }
}
