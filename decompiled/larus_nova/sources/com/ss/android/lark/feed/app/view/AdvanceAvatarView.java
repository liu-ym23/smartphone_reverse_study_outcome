package com.ss.android.lark.feed.app.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;

/* JADX INFO: loaded from: classes35.dex */
public class AdvanceAvatarView extends LarkAvatarView {
    @Override // android.view.View
    public final void requestLayout() {
        if (getMeasuredWidth() != 0) goto L5;
    L7:
        super.requestLayout();
        return;
    L5:
        if (getMeasuredHeight() == 0) goto L7;
    }

    public AdvanceAvatarView(Context r100) {
        super(r100);
    }

    public AdvanceAvatarView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AdvanceAvatarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
