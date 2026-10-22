package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashPermissionInfoResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z implements h.f<ECFlashPermissionInfoResponse> {
    public z() {
    }

    @Override // vi2.h.f
    public final wi2.a<ECFlashPermissionInfoResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        Map<String, String> r1 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r2 = h.g("/live/seller/flash/get_permission_info/", r0);
        int r3 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECFlashPermissionInfoResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r2, ECFlashPermissionInfoResponse.class), r1, null);
    }
}
