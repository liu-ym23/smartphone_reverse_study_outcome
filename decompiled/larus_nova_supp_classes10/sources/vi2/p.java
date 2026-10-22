package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements h.f<yi2.a> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    @Override // vi2.h.f
    public final wi2.a<yi2.a> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_id", r1));
        r0.add(si2.k.a.a("author_id", this.b));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        SsResponse r4 = h.h("https://ecom.snssdk.com/live/ecom/small_window/", r0);
        return h.f((yi2.a) h.j(r4, yi2.a.class), r3, r4);
    }

    public p(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
