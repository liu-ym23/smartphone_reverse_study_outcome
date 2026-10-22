package mv0;

import com.bytedance.android.live.revlink.api.ILinkService;

/* JADX INFO: loaded from: classes47.dex */
public final class w implements qs0.t {
    public w() {
    }

    @Override // qs0.t
    public final boolean a(String r100) {
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        p11.e r102 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getMultiAnchorService();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.a(r100) != true) goto L7;
        return true;
    }
}
