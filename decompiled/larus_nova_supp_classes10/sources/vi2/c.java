package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class c implements h.f {
    public final /* synthetic */ FilterNullArrayList a;
    public final /* synthetic */ String b;
    public final /* synthetic */ el2.m c;
    public final /* synthetic */ Class d;

    public /* synthetic */ c(FilterNullArrayList r1, String r2, el2.m r3, Class r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // vi2.h.f
    public final wi2.a execute() {
        FilterNullArrayList r0 = this.a;
        String r1 = this.b;
        el2.m r2 = this.c;
        Class r3 = this.d;
        Map<String, String> r4 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        SsResponse<String> r5 = h.i(r1, r0);
        if (r2 == null) goto L6;
        r2.a(r5);
    L6:
        return h.f((com.bytedance.android.ec.model.g) h.j(r5, r3), r4, r5);
    }
}
