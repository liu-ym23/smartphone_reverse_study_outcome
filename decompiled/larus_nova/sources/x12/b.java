package x12;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.revenue.service.interact.d;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static int a() {
        int r100 = ((d) vh6.c.b(d.class)).getMultiInteractMode();
        int r101 = ((ILinkService) f.a(ILinkService.class)).getRevLinkControlService().getCurrentMode();
        int r102 = com.bytedance.android.live.utils.c.f102546a;
        return r100 | r101;
    }

    static {
    }
}
