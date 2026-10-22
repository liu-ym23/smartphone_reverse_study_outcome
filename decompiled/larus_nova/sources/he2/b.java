package he2;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements js0.b {
    public b() {
    }

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        ((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).justReportRoomEvent(9, 0, 14, "");
    }
}
