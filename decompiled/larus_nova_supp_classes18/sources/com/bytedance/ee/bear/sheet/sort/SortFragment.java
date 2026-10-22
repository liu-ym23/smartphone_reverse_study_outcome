package com.bytedance.ee.bear.sheet.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.oppanel.FabPanelViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0002H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0002¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/sheet/sort/SortFragment;", "Lcom/bytedance/ee/bear/sheet/panel/BaseCellPanelFragment;", "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onReceiveEmptyData", "bindView", "sheetItem", "getPanelName", "", "getViewModel", "Lcom/bytedance/ee/bear/sheet/panel/BaseCellPanelViewModel;", "onKeyEventBackPressed", "exit", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SortFragment extends BaseCellPanelFragment<SheetItem> {
    public static final /* synthetic */ int h = 0;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SheetItem a;
        public final /* synthetic */ SortFragment b;

        public b(SheetItem r1, SortFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (this.a.isEnable() == false) goto L6;
            SortFragment r5 = this.b;
            String r0 = this.a.getId();
            String r1 = this.a.getValue();
            int r2 = SortFragment.h;
            r5.ca0(r0, r1);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return "sort";
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void da0() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final BaseCellPanelViewModel<SheetItem> Z90() {
        return q.a(this, FabPanelViewModel.class);
    }

    public final boolean S90() {
        T90(2130772114);
        return true;
    }

    public SortFragment() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void U90(SheetItem r3) {
        Intrinsics.checkNotNullParameter(r3, "sheetItem");
        super.U90(r3);
        View r0 = X90(r3.getId());
        if (r0 == null) goto L6;
        r0.setOnClickListener(new b(r3, this));
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        fa0(Z90().getPanelTitle("sort"));
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(getContext(), 2130772113);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564581, r3, false);
    }
}
