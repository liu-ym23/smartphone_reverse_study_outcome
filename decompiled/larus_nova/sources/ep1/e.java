package ep1;

import android.view.ViewGroup;
import android.widget.GridLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class e extends c {
    @Override // ep1.c
    public final boolean c(List<ToolbarButton> r100, ViewGroup r101, Function2<? super ToolbarButton, ? super GridLayout, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "buttons");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "loader");
        return false;
    }

    @Override // ep1.c
    public String b() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L10;
        i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L10;
        if (r101.getValue().booleanValue() != true) goto L10;
        return s1.B(R.string.ttlive_broadcast_more_dialog_title);
    L10:
        return null;
    }

    public e() {
    }

    @Override // ep1.c
    public final int a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        if (z.k(r100) == false) goto L5;
    L19:
        boolean r101 = z.e(r100, false);
        int r102 = t.f121217a;
        if ((!r101) == false) goto L22;
        return R.layout.ttlive_dialog_broadcast_more_action;
    L22:
        return R.layout.ttlive_dialog_broadcast_more_action_old;
    L5:
        if (z.g(r100) == true) goto L19;
        if (z.i(r100) == true) goto L19;
        if (z.j(r100) == true) goto L19;
        if (z.h(r100) == true) goto L19;
        if (z.e(r100, false) == false) goto L19;
        if (PadConfigUtils.c() == false) goto L18;
        return R.layout.ttlive_dialog_cn_more_action_hd;
    L18:
        return R.layout.ttlive_dialog_cn_more_action;
    }
}
