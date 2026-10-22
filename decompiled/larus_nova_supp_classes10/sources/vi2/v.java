package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements h.f<xi2.h> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ String e;

    @Override // vi2.h.f
    public final wi2.a<xi2.h> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        if (hh2.f.g() == false) goto L5;
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("sec_author_id", r1));
    L6:
        Map r3 = this.c;
        if (r3 == null) goto L12;
        Iterator r4 = r3.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();
        String r6 = (String) r5.getKey();
        String r7 = (String) r5.getValue();
        int r8 = si2.k.c;
        r0.add(si2.k.a.a(r6, r7));
    L12:
        FilterNullArrayList r9 = new FilterNullArrayList();
        Map r10 = this.d;
        if (r10 == null) goto L18;
        Iterator r11 = r10.entrySet().iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        String r14 = (String) r12.getValue();
        int r15 = si2.k.c;
        r9.add(si2.k.a.a(r13, r14));
    L18:
        Map<String, String> r16 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r17 = this.e;
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r17, r0);
        String r18 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r17, r0);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r18, r0, "post");
        return h.f((xi2.h) h.j(zj2.a.c(r18, r0, true, r9), xi2.h.class), r16, null);
    L5:
        String r19 = this.b;
        int r20 = si2.k.c;
        r0.add(si2.k.a.a("author_id", r19));
        goto L6
    }

    public v(String r1, String r2, Map r3, Map r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
