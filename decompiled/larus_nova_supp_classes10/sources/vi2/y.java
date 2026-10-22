package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements h.f<ECFlashResponse> {
    public final /* synthetic */ String a;

    @Override // vi2.h.f
    public final wi2.a<ECFlashResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        Map<String, String> r1 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r2 = h.g(this.a, r0);
        int r3 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECFlashResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r2, ECFlashResponse.class), r1, null);
    }

    public y(String r1) {
        this.a = r1;
    }
}
