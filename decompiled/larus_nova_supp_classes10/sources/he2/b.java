package he2;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements js0.b {
    public b() {
    }

    public final void onSuccess(String r7) {
        Intrinsics.checkNotNullParameter(r7, "track");
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).justReportRoomEvent(9, 0, 14, "");
    }
}
