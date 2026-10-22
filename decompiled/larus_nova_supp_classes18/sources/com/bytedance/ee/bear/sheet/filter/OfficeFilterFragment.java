package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.oppanel.OfficeFabPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0014\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0014J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeFilterFragment;", "Lcom/bytedance/ee/bear/sheet/panel/BaseCellPanelFragment;", "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "openChildFragment", "fragment", "Ljava/lang/Class;", "bindView", "sheetItem", "onKeyEventBackPressed", "exit", "onReceiveEmptyData", "getViewModel", "Lcom/bytedance/ee/bear/sheet/panel/BaseCellPanelViewModel;", "getPanelName", "", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFilterFragment extends BaseCellPanelFragment<SheetItem> {
    public static final /* synthetic */ int h = 0;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ OfficeFilterFragment b;
        public final /* synthetic */ SheetItem c;

        public b(View r1, OfficeFilterFragment r2, SheetItem r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            this.a.setSelected(true);
            OfficeFilterFragment r7 = this.b;
            String r0 = this.c.getId();
            String r1 = this.c.getValue();
            int r2 = OfficeFilterFragment.h;
            r7.ca0(r0, r1);
            if (Intrinsics.areEqual("filterClear", this.c.getId()) == false) goto L6;
            this.b.T90(2130772114);
            return;
        L6:
            if (Intrinsics.areEqual("filterByCell", this.c.getId()) == false) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual("cancelFilterByCell", this.c.getId()) == false) goto L10;
            return;
        L10:
            if (Intrinsics.areEqual("filterPersonal", this.c.getId()) == true) goto L30;
            OfficeFilterFragment r8 = this.b;
            Class<?> r3 = OfficeFilterItemEnum.valueOf(this.c.getId()).getFragment();
            FragmentManager r4 = r8.getFragmentManager();
            if (r4 == null) goto L32;
            Fragment r5 = r4.findFragmentByTag(r3.getName());
            if (r5 != null) goto L20;
            Bundle r9 = new Bundle();
            PluginHost.writePluginHostToBundle(r8, r9);
            Context r10 = r8.getContext();
            if (r10 == null) goto L19;
            r5 = Fragment.instantiate(r10, r3.getName(), r9);
            goto L20
        L19:
            r5 = null;
        L20:
            if (r5 == null) goto L31;
            FragmentTransaction r11 = r4.beginTransaction().setCustomAnimations(2130772113, 2130772114);
            String r12 = r3.getName();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r12, 2131372508) == true) goto L25;
            r11 = r11.replace(2131372508, r5, r12);
        L25:
            r11.commitAllowingStateLoss();
            return;
        L31:
            return;
        L32:
            return;
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ SheetItem a;
        public final /* synthetic */ OfficeFilterFragment b;

        public c(SheetItem r1, OfficeFilterFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r3, boolean r4) {
            tt5.a.h("FilterFragment", "setOnSwitchCheckedChangeListener，isChecked: " + r4 + ", sheetItem = " + this.a);
            OfficeFilterFragment r5 = this.b;
            String r0 = this.a.getId();
            if (r4 == false) goto L5;
            String r6 = "1";
        L6:
            int r1 = OfficeFilterFragment.h;
            r5.ca0(r0, r6);
            return;
        L5:
            r6 = "0";
            goto L6
        }
    }

    public static final class d implements on5.b.a {
        public final /* synthetic */ OfficeFilterFragment a;

        @Override // on5.b.a
        public final void exit() {
            OfficeFilterFragment r0 = this.a;
            int r1 = OfficeFilterFragment.h;
            r0.T90(2130772114);
        }

        public d(OfficeFilterFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return "filter";
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void da0() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final BaseCellPanelViewModel<SheetItem> Z90() {
        return com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeFabPanelViewModel.class);
    }

    public final void onDestroyView() {
        com.bytedance.ee.bear.browser.plugin.q.a(this, FilterViewModel.class).clearFilterData();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final boolean S90() {
        T90(2130772114);
        return true;
    }

    public OfficeFilterFragment() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void U90(SheetItem r5) {
        Intrinsics.checkNotNullParameter(r5, "sheetItem");
        super.U90(r5);
        View r0 = X90(r5.getId());
        if (Intrinsics.areEqual("filterPersonal", r5.getId()) == false) goto L19;
        View r1 = X90("filterPersonal_info");
        if ((r1 instanceof TextView) == false) goto L7;
        TextView r2 = (TextView) r1;
    L8:
        String r3 = r5.getInfo();
        if (r3 == null) goto L14;
        if (r2 == null) goto L12;
        r2.setVisibility(0);
    L12:
        if (r2 == null) goto L17;
        r2.setText(r3);
    L17:
        if ((r0 instanceof SheetListItemView) == false) goto L22;
        SheetListItemView r4 = (SheetListItemView) r0;
        r4.d(r5, new c(r5, this));
        r4.setClickable(false);
        return;
    L22:
        return;
    L14:
        if (r2 == null) goto L17;
        r2.setVisibility(8);
        goto L17
    L7:
        r2 = null;
        goto L8
    L19:
        if (r0 == null) goto L24;
        r0.setOnClickListener(new b(r0, this, r5));
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        fa0(Z90().getPanelTitle("filter"));
        Map<String, String> r4 = on5.b.a;
        on5.b.a(this, getFragmentManager(), 2131372508, new d(this));
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(getContext(), 2130772113);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564557, r3, false);
    }
}
