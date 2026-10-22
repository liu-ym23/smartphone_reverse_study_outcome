package x12;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.scope.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final int a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        int r101 = ((d) vh6.c.b(d.class)).getMultiInteractMode();
        int r102 = ((ILinkService) f.a(ILinkService.class)).getRevLinkControlService().getCurrentMode();
        int r103 = com.bytedance.android.live.utils.c.f102546a;
        return r101 | r102;
    }
}
