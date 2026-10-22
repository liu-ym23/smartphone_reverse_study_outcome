package eg1;

import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.AbsShellWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.BroadcastMultiProcessWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.P0LoadObserveWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.ShellLinkWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.ShellOnViewCreatedWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.ShellViewBeforeWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.SinglePageModeWidget;
import com.larus.nova.R;
import hs1.c;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c<? extends AbsShellWidget>> f472603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<c<? extends AbsShellWidget>> f472604b = null;

    static {
        f472603a = CollectionsKt.listOf(new c[]{new c("ShellViewBeforeWidget", ShellViewBeforeWidget.class, null), new c("BroadcastMultiProcessWidget", BroadcastMultiProcessWidget.class, null), new c("SinglePageModeWidget", SinglePageModeWidget.class, null), new c("ShellLinkWidget", ShellLinkWidget.class, null)});
        f472604b = CollectionsKt.listOf(new c[]{new c("ShellOnViewCreatedWidget", ShellOnViewCreatedWidget.class, null), new c("P0LoadObserveWidget", P0LoadObserveWidget.class, Integer.valueOf(R.id.interaction_container))});
    }
}
