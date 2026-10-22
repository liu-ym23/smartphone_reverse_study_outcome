package yn0;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements l81.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f568516a = null;

    public t() {
    }

    static {
        f568516a = new t();
    }

    @Override // l81.t
    public final void a(DataCenter r100, List<? extends ToolbarButton> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        IRoomService r102 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r102 == null) goto L8;
        com.bytedance.android.live.room.u r103 = r102.getToolbarConfig();
        if (r103 == null) goto L9;
        r103.a(r100, r101);
        return;
    L9:
        return;
    }
}
