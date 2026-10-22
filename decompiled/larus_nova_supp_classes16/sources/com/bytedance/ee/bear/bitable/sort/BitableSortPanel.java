package com.bytedance.ee.bear.bitable.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.viewmodel.BitableToolboxViewModel;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanel;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContentView", "onViewCreated", "", "view", "onStart", "initPanelStyle", "initBottomFixButton", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSortPanel extends BaseActionPanelFragment {

    public static final class a {
    }

    static {
    }

    public final View la0(CommonActionPanelLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        return null;
    }

    public final mr4.a o() {
        Fragment r0 = getChildFragmentManager().findFragmentByTag("BitableSortPanel");
        Integer r2 = null;
        if ((r0 instanceof BitableSortPanelFragment) == false) goto L5;
        BitableSortPanelFragment r1 = (BitableSortPanelFragment) r0;
    L6:
        if (r1 == null) goto L16;
        BitableToolboxViewModel r3 = (BitableToolboxViewModel) q.a(r1, BitableToolboxViewModel.class);
        int r4 = com.bytedance.ee.bear.bitable.utils.g.a;
        PanelData r5 = (PanelData) r3.getPanelData().getValue();
        if (r5 == null) goto L10;
        String r6 = r5.getSrcObjToken();
    L11:
        PanelData r7 = (PanelData) r3.getPanelData().getValue();
        if (r7 == null) goto L15;
        r2 = r7.getSrcObjType();
    L15:
        return com.bytedance.ee.bear.bitable.utils.g.a(r6, r2);
    L10:
        r6 = null;
        goto L11
    L16:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Fragment r0 = getChildFragmentManager().findFragmentByTag("BitableSortPanel");
        LinearLayout r2 = null;
        if ((r0 instanceof BitableSortPanelFragment) == false) goto L5;
        BitableSortPanelFragment r1 = (BitableSortPanelFragment) r0;
    L6:
        if (r1 == null) goto L17;
        NestedScrollView r3 = r1.e;
        if (r3 == null) goto L17;
        r3.getViewTreeObserver().addOnDrawListener(r1);
        if (r1.t == false) goto L17;
        LinearLayout r4 = r1.l;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L16:
        r2.post(new g(r1));
        goto L17
    L15:
        r2 = r4;
    L17:
        na0(true);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public BitableSortPanel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r2, r3);
        ((BaseActionPanelFragment) this).p = 0;
        View r0 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, Float.valueOf(0.45f), null, null, 6);
        qa0(true);
        pa0(2131100558);
        va0(getString(2131886766));
        if (((BaseActionPanelFragment) this).z == null) goto L6;
        r0 = ja0();
    L6:
        if (r0 == null) goto L9;
        r0.setOnClickListener(new com.bytedance.ee.bear.bitable.sort.a(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        if (r5 == null) goto L5;
        com.bytedance.ee.bear.bitable.common.fragment.b.a(this, BitableSortPanelFragment.class, "BitableSortPanel", 28);
        return r5;
    L5:
        return null;
    }
}
