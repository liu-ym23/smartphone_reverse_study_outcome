package gp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements a {
    public b() {
    }

    @Override // gp1.a
    public final boolean a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        if (r100 != ToolbarButton.VS_ACTIVITY_ONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gp1.a
    public final ExtendedToolbarButton.b b(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        ExtendedToolbarButton.a r101 = ExtendedToolbarButton.f115618h;
        ToolbarButton r102 = ToolbarButton.VS_ACTIVITY_ONE;
        r101.getClass();
        ExtendedToolbarButton.b r103 = ExtendedToolbarButton.a.a(r102);
        r103.f115622d = 1;
        return r103;
    }
}
