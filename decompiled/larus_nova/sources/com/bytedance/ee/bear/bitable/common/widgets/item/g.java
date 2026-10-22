package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.Icon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements k {
    public g() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.k
    public final CommonHeaderView a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new CommonHeaderView(r100.getContext(), null, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.k
    public final void b(View r100, BitablePanelItem r101, com.bytedance.ee.bear.bitable.panel.m r102) {
        Intrinsics.checkNotNullParameter(r100, "headerView");
        Icon r103 = null;
        if ((r100 instanceof CommonHeaderView) == false) goto L5;
        CommonHeaderView r104 = (CommonHeaderView) r100;
    L6:
        if (r104 == null) goto L15;
        if (r101 == null) goto L9;
        String r105 = r101.getLeftText();
    L10:
        r104.setTitle(r105);
        if (r101 == null) goto L13;
        r103 = r101.getLeftIcon();
    L13:
        r104.setAvatar(r103);
        r104.setRightAction(new f(r102));
        return;
    L9:
        r105 = null;
        goto L10
    L15:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
