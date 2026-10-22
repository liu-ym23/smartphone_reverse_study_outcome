package com.ss.android.lark.flow.feed.action.done;

import aeb.e;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
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
    public final int b(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return R.drawable.icon_flow_long_click_archive;
    }

    @Override // aeb.e
    public final int c(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return R.drawable.icon_flow_hide;
    }

    @Override // aeb.e
    public final int getBackground() {
        return R.color.flow_feed_action_yellow;
    }

    @Override // aeb.e
    public final String d(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return e(r100);
    }

    @Override // aeb.e
    public final String e(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return UIHelper.getString(R.string.LarkIM_Feed_HideFromChats_Button);
    }
}
