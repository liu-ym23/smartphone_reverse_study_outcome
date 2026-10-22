package zr2;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v extends w {
    public v(as2.a r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        RevToolbarButton r101 = r100.f16090a;
        if (r101 == null) goto L5;
        ToolbarButton r102 = u.a(r101);
    L6:
        super(r102, null, null, null);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
