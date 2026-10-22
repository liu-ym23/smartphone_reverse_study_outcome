package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECAskExplainResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements h.f<ECAskExplainResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    @Override // vi2.h.f
    public final wi2.a<ECAskExplainResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("promotion_id", r1));
        r0.add(si2.k.a.a("user_id", this.b));
        r0.add(si2.k.a.a("author_id", this.c));
        r0.add(si2.k.a.a("sec_author_id", this.d));
        r0.add(si2.k.a.a("room_id", this.e));
        r0.add(si2.k.a.a("room_unique_key", this.f));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r4 = h.a(si2.g.D, r0);
        int r5 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECAskExplainResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r4, ECAskExplainResponse.class), r3, null);
    }

    public u(String r1, String r2, String r3, String r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
