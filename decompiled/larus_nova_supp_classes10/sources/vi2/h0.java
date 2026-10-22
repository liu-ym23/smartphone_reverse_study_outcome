package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECRedPacketResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h0 implements h.f<ECRedPacketResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // vi2.h.f
    public final wi2.a<ECRedPacketResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_id", r1));
        r0.add(si2.k.a.a("author_id", this.b));
        r0.add(si2.k.a.a("sec_author_id", this.c));
        String r3 = this.d;
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.add(si2.k.a.a("adv_id", r3));
        String r5 = this.e;
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r0.add(si2.k.a.a("redpack_type", r4));
        Map<String, String> r6 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r7 = h.g(si2.g.O, r0);
        int r8 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECRedPacketResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r7, ECRedPacketResponse.class), r6, null);
    }

    public h0(String r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = "1";
    }
}
