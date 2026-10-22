package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i0 implements h.f<xi2.s> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;

    @Override // vi2.h.f
    public final wi2.a<xi2.s> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_id", r1));
        Iterator r3 = this.b.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.add(si2.k.a.a((String) r4.getKey(), (String) r4.getValue()));
        goto L4
    L6:
        Map<String, String> r5 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r6 = h.a(this.c, r0);
        int r7 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.s) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r6, xi2.s.class), r5, null);
    }

    public i0(String r1, Map r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
