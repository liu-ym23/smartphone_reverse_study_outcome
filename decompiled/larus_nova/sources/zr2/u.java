package zr2;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u {
    public static final ToolbarButton a(RevToolbarButton r100) {
        int r101 = t.f573407b[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return null;
    L11:
        return ToolbarButton.FAST_GIFT;
    L9:
        return ToolbarButton.GIFT;
    }

    public static final NewToolbarButtonConstants b(RevToolbarConstants r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLiveType");
        int r101 = t.f573406a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return NewToolbarButtonConstants.ToolbarFastGift.INSTANCE;
    L11:
        return NewToolbarButtonConstants.ToolbarFastGift.INSTANCE;
    L9:
        return NewToolbarButtonConstants.ToolbarGift.INSTANCE;
    }
}
