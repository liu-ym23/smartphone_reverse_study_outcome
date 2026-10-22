package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFloatWindowDetailResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 implements h.f<ECFloatWindowDetailResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ String e;

    @Override // vi2.h.f
    public final wi2.a<ECFloatWindowDetailResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("taskType", r1));
        r0.add(si2.k.a.a("extraParams", this.b));
        String r3 = this.c;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.add(si2.k.a.a("uniqueID", r3));
        r0.add(si2.k.a.a("user_id", com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId()));
        JSONObject r4 = this.d;
        boolean r5 = false;
        if (r4 == null) goto L14;
        Iterator<String> r6 = r4.keys();
    L9:
        if (r6.hasNext() == false) goto L14;
        String r7 = r6.next();
        if ("bizID".equals(r7) == false) goto L13;
        r5 = true;
    L13:
        r0.add(si2.k.a.a(r7, this.d.optString(r7)));
    L14:
        if (r5 == true) goto L16;
        r0.add(si2.k.a.a("bizID", this.e));
    L16:
        Map<String, String> r8 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r9 = h.g(si2.g.M, r0);
        int r10 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECFloatWindowDetailResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r9, ECFloatWindowDetailResponse.class), r8, null);
    }

    public c0(String r1, String r2, String r3, JSONObject r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
