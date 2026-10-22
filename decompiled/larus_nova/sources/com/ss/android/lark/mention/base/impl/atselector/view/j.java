package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarTipsView;
import com.ss.android.lark.widget.quick_sidebar.tipsview.QuickSideBarTipsItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements ydc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtView f431848a;

    public j(AtView r100) {
        this.f431848a = r100;
    }

    public final void b(boolean r100) {
        QuickSideBarTipsView r101 = this.f431848a.mQuickSideBarTipView;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public final void a(String r110, float r111) {
        AtView r100 = this.f431848a;
        QuickSideBarTipsView r101 = r100.mQuickSideBarTipView;
        float r112 = r111 - UIUtils.dp2px(r100.f431811b, 40.0f);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "text");
        QuickSideBarTipsItemView r102 = r101.f448085a;
        QuickSideBarTipsItemView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
        r102 = null;
    L5:
        r102.setText(r110);
        QuickSideBarTipsItemView r104 = r101.f448085a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
        r104 = null;
    L8:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r105;
        r106.topMargin = (int) (((double) r112) - (((double) r101.getWidth()) / 2.8d));
        QuickSideBarTipsItemView r113 = r101.f448085a;
        if (r113 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
    L12:
        r103.setLayoutParams(r106);
        if (this.f431848a.f431816g.containsKey(r110) == false) goto L16;
        ((LinearLayoutManager) this.f431848a.mRecommendRecyclerView.getLayoutManager()).scrollToPositionWithOffset(this.f431848a.f431816g.get(r110).intValue(), 0);
        return;
    L16:
        return;
    L11:
        r103 = r113;
        goto L12
    }
}
