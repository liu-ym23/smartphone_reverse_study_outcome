package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.SheetEditViewModel;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeAnchor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FabPanelFragment extends BaseFragment implements FormulaPickerFragment.d {
    public static final /* synthetic */ int t = 0;
    public qm5.a e;
    public FabPanelViewModel f;
    public DocViewModel g;
    public MutableLiveData<SheetItem[]> h;
    public AvailableItem[] i;
    public SheetDragView j;
    public MagicIndicator k;
    public wuc.a l;
    public ViewPager m;
    public c n;
    public int o;
    public Runnable p;
    public boolean q;
    public boolean r;
    public SelectMediaViewModel s;

    public static class AvailableItem extends SheetItem {
        int tabPosition;

        public AvailableItem(int r1, String r2, String r3, String r4) {
            this.tabPosition = r1;
            this.id = r2;
            this.title = r3;
            this.value = r4;
        }
    }

    public class a implements FabPanelViewModel.b {
        public final /* synthetic */ FabPanelFragment a;

        public a(FabPanelFragment r1) {
            this.a = r1;
        }

        public final void a(Class<?> r4, Bundle r5) {
            SheetDragView r0 = this.a.j;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setDragUpEnable(true);
            FragmentManager r1 = this.a.getChildFragmentManager();
            Fragment r2 = r1.findFragmentByTag(r4.getName());
            if (r2 != null) goto L8;
            PluginHost.writePluginHostToBundle(this.a, r5);
            r2 = Fragment.instantiate(this.a.getContext(), r4.getName(), r5);
        L8:
            FragmentTransaction r6 = r1.beginTransaction();
            String r7 = r4.getName();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r7, 2131381566) == true) goto L12;
            r6 = r6.replace(2131381566, r2, r7);
        L12:
            r6.commitAllowingStateLoss();
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ FabPanelFragment a;

        public b(FabPanelFragment r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r2) {
            uuc.a r0 = this.a.k.a;
            if (r0 == null) goto L5;
            r0.onPageScrollStateChanged(r2);
        L5:
            FabPanelFragment r1 = this.a;
            r1.o = r2;
            if (r2 != 0) goto L11;
            Runnable r3 = r1.p;
            if (r3 == null) goto L12;
            r3.run();
            this.a.p = null;
            return;
        L12:
            return;
        }

        public final void onPageSelected(int r3) {
            FabPanelFragment r0 = this.a;
            AvailableItem r4 = r0.i[r3];
            r0.k.b(r4.tabPosition);
            this.a.f.clickItem(r4.getId(), r4.getValue());
        }

        public final void onPageScrolled(int r3, float r4, int r5) {
            FabPanelFragment r0 = this.a;
            r0.k.a(r0.i[r3].tabPosition, r4, r5);
        }
    }

    public class c extends FragmentPagerAdapter {
        public final /* synthetic */ FabPanelFragment a;

        public final int getCount() {
            return this.a.i.length;
        }

        public final Fragment getItem(int r4) {
            String r0 = SubPanelEnum.style.name();
            AvailableItem[] r1 = this.a.i;
            if (r4 >= r1.length) goto L5;
            r0 = r1[r4].getId();
        L5:
            Bundle r5 = new Bundle();
            PluginHost.writePluginHostToBundle(this.a, r5);
            r5.putString("sub_fragment_id", r0);
            return Fragment.instantiate(this.a.getContext(), SubPanelEnum.valueOf(r0).fragment, r5);
        }

        public final long getItemId(int r3) {
            return this.a.i[r3].getId().hashCode();
        }

        public final int getItemPosition(Object r9) {
            Bundle r10 = ((Fragment) r9).getArguments();
            if (r10 != null) goto L5;
            return -2;
        L5:
            String r1 = r10.getString("sub_fragment_id", SubPanelEnum.style.name());
            int r4 = r10.getInt("sub_fragment_index", -1);
            int r5 = 0;
        L6:
            AvailableItem[] r6 = this.a.i;
            if (r5 >= r6.length) goto L15;
            if (TextUtils.equals(r1, r6[r5].getId()) == true) goto L10;
            r5 = r5 + 1;
            goto L6
        L10:
            if (r5 != r4) goto L12;
            return -1;
        L12:
            r10.putInt("sub_fragment_index", r5);
            return r5;
        L15:
            return -2;
        }

        public c(FabPanelFragment r1, FragmentManager r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class d extends xuc.a {
        public final /* synthetic */ FabPanelFragment b;

        public class a extends com.bytedance.ee.bear.widgets.t {
            public final /* synthetic */ SheetItem[] c;
            public final /* synthetic */ int d;
            public final /* synthetic */ d e;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r3) {
                if (this.c[this.d].isEnable() == false) goto L6;
                FabPanelFragment r4 = this.e.b;
                String r0 = this.c[this.d].getId();
                int r1 = FabPanelFragment.t;
                r4.sF(r0, true);
            L6:
                if (this.c[this.d].isEnable() == true) goto L9;
                this.e.b.f.clickItem(this.c[this.d].getId(), null);
                return;
            }

            public a(d r1, SheetItem[] r2, int r3) {
                this.e = r1;
                this.c = r2;
                this.d = r3;
            }
        }

        public final int a() {
            SheetItem[] r0 = (SheetItem[]) this.b.h.getValue();
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.length;
        }

        static {
        }

        public d(FabPanelFragment r1) {
            this.b = r1;
        }

        public final xuc.c b(Context r5) {
            yuc.a r0 = new yuc.a(r5);
            r0.setMode(1);
            r0.setColors(new Integer[]{Integer.valueOf(r5.getResources().getColor(2131103404))});
            r0.setLineHeight(r5.getResources().getDimensionPixelSize(2131168159));
            r0.setXOffset(-com.bytedance.ee.util.ui.n.d(7));
            r0.setStartInterpolator(new AccelerateInterpolator());
            r0.setEndInterpolator(new DecelerateInterpolator(3.0f));
            return r0;
        }

        public final xuc.d c(Context r7, int r8) {
            SheetItem[] r0 = (SheetItem[]) this.b.h.getValue();
            bvc.a r1 = new bvc.a(r7);
            r1.setContentDescription(r0[r8].getId());
            avc.c r2 = new avc.c(r7);
            r2.setSelectedColor(r7.getResources().getColor(2131105861));
            if (r0[r8].isEnable() == false) goto L5;
            int r3 = r7.getResources().getColor(2131105862);
        L6:
            r2.setNormalColor(r3);
            r2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            r2.getPaint().setStrokeWidth(1.0f);
            r2.setText(r0[r8].getTitle());
            r2.setTextSize(17.0f);
            r1.setInnerPagerTitleView(r2);
            if (this.b.f.showBadges(r0[r8].getId()) == false) goto L15;
            Intrinsics.checkNotNullParameter(r7, "context");
            UDBadgeView r4 = new UDBadgeView(r7, null, 0, 2131953811);
            String r9 = r4.h;
            if (r9 == null) goto L11;
            r4.setText(r9);
        L11:
            Drawable r10 = r4.m;
            if (r10 == null) goto L14;
            r4.setIcon(r10);
        L14:
            r4.b();
            r1.setAutoCancelBadge(true);
            r1.setBadgeView(r4);
            r1.setXBadgeRule(new bvc.b(BadgeAnchor.CONTENT_RIGHT, 0));
            r1.setYBadgeRule(new bvc.b(BadgeAnchor.CONTENT_TOP, com.bytedance.ee.util.ui.n.d(-2)));
        L15:
            r1.setOnClickListener(new a(this, r0, r8));
            this.b.j.setSlideView(r1);
            return r1;
        L5:
            r3 = r7.getResources().getColor(2131105860);
            goto L6
        }
    }

    public final boolean S90() {
        this.f.setActive(false);
        return true;
    }

    public final void V90() {
        MutableLiveData<SheetItem[]> r0 = this.h;
        if (r0 != null) goto L5;
    L16:
        this.i = new AvailableItem[0];
        return;
    L5:
        if (r0.getValue() == null) goto L16;
        SheetItem[] r1 = (SheetItem[]) this.h.getValue();
        ArrayList r2 = new ArrayList();
        int r3 = 0;
    L9:
        if (r3 >= r1.length) goto L14;
        if (r1[r3].isEnable() == false) goto L13;
        r2.add(new AvailableItem(r3, r1[r3].getId(), r1[r3].getTitle(), r1[r3].getValue()));
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        this.i = (AvailableItem[]) r2.toArray(new AvailableItem[0]);
    }

    public final void onDestroyView() {
        if (this.h.getValue() == null) goto L7;
        SheetItem[] r0 = (SheetItem[]) this.h.getValue();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        SheetItem r4 = r0[r3];
        this.f.clearBadges(r4.getId());
        r3 = r3 + 1;
    L7:
        this.f.setToolkitDelegate(null);
        this.f.setActive(false);
        this.e.getClass();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_close_fabPanel", new HashMap());
        qm5.b.a(this.r);
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public FabPanelFragment() {
        this.o = 0;
    }

    public final void U90() {
        V90();
        this.n.notifyDataSetChanged();
        xuc.a r0 = this.l.e;
        if (r0 == null) goto L6;
        r0.a.notifyChanged();
    L6:
        if (this.q == true) goto L11;
        AvailableItem[] r1 = this.i;
        if (r1.length == 0) goto L12;
        this.k.b(r1[0].tabPosition);
        this.q = true;
        return;
    L12:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = com.bytedance.ee.bear.browser.plugin.q.a(this, FabPanelViewModel.class);
        this.s = ViewModelProviders.of(getActivity()).get(SelectMediaViewModel.class);
        this.f.setToolkitDelegate(new a(this));
        this.g = com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class);
        this.h = this.f.getTopItems();
        V90();
        this.h.observe(this, new com.bytedance.ee.bear.sheet.panel.oppanel.a(this));
        qm5.a r3 = new qm5.a();
        this.e = r3;
        r3.a = this.g.getBearUrl();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment.d
    public final void Bo(String r2, boolean r3) {
        ((FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class)).startKeyboardHandoff(r3);
        SheetEditViewModel r4 = com.bytedance.ee.bear.browser.plugin.q.a(this, SheetEditViewModel.class);
        if (r4 == null) goto L5;
        r4.notifyFormulaFunctionPicked(r2);
    L5:
        Fragment r5 = getChildFragmentManager().findFragmentByTag(FormulaPickerFragment.class.getName());
        if (r5 == null) goto L9;
        getChildFragmentManager().beginTransaction().remove(r5).commitAllowingStateLoss();
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        final FabView r6 = r4.findViewById(2131386175);
        this.f.showKeyboardFab().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.sheet.panel.oppanel.b(r6));
        final FabViewModel r0 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        r6.setOnClickListener(new com.bytedance.ee.bear.sheet.panel.oppanel.c(this, r0));
        SheetDragView r1 = (SheetDragView) r4.findViewById(2131372039);
        this.j = r1;
        r1.getTopBar().setBackgroundResource(2131247771);
        this.j.setSlideView(r4.findViewById(2131381570));
        this.j.setOnCloseListener(new com.bytedance.ee.bear.sheet.panel.oppanel.d(this, r6));
        this.j.setSource("sheet_toolbar");
        this.j.setDocumentUrl(this.g.getBearUrl());
        this.k = r4.findViewById(2131381569);
        wuc.a r7 = new wuc.a(getContext());
        this.l = r7;
        r7.setAdapter(new d(this));
        this.l.setAdjustMode(true);
        this.k.setNavigator(this.l);
        ViewPager r8 = r4.findViewById(2131387534);
        this.m = r8;
        r8.setOffscreenPageLimit(2);
        ViewPager r9 = this.m;
        c r10 = new c(this, getChildFragmentManager());
        this.n = r10;
        r9.setAdapter(r10);
        this.m.addOnPageChangeListener(new b(this));
        Map<String, String> r11 = qm5.d.a;
        qm5.d.a(this, getChildFragmentManager(), 2131381566, new e(this));
    }

    public final void sF(String r6, boolean r7) {
        AvailableItem[] r0 = this.i;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        AvailableItem r3 = r0[r2];
        if (TextUtils.equals(r6, r3.getId()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        this.m.setCurrentItem(r3.tabPosition, r7);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564570, r3, false);
    }
}
