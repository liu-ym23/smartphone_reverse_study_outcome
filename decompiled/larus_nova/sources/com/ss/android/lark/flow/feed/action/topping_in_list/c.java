package com.ss.android.lark.flow.feed.action.topping_in_list;

import aeb.e;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements e {
    public c() {
    }

    @Override // aeb.e
    public final int a() {
        return R.color.feed_long_click_color;
    }

    @Override // aeb.e
    public final int getBackground() {
        return R.color.flow_feed_action_violet;
    }

    @Override // aeb.e
    public final int b(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (UIFeedCardExtraKt.isOnTop(r100) == false) goto L5;
        return R.drawable.icon_flow_long_click_untopping;
    L5:
        return R.drawable.icon_flow_long_click_pin;
    }

    @Override // aeb.e
    public final int c(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (UIFeedCardExtraKt.isOnTop(r100) == false) goto L5;
        return R.drawable.icon_flow_untopping;
    L5:
        return R.drawable.icon_flow_topping;
    }

    @Override // aeb.e
    public final String d(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return e(r100);
    }

    @Override // aeb.e
    public final String e(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (UIFeedCardExtraKt.isOnTop(r100) == false) goto L5;
        String r101 = UIHelper.getString(R.string.LarkIM_Feed_Unpin_Button);
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        String r102 = UIHelper.getString(R.string.LarkIM_Feed_PinTop_Button);
        Intrinsics.checkNotNull(r102);
        return r102;
    }
}
