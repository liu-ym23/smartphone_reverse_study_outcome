package com.bytedance.ee.bear.content.creation.mvp;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.larksuite.framework.mvp.IView;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements b {
    public final Context a;
    public final LifeCycleFragment b;
    public final View c;
    public final FragmentManager d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final SelectCreationMenuConfig j;
    public final CreateSelectResult k;
    public final String l;
    public final SelectCreationMenuAdapter m;
    public SelectCreationMenuViewModel n;
    public b.a o;

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final /* synthetic */ void v6(boolean r1) {
    }

    public final void create() {
        tt5.a.h("SelectCreationMenuView", "create()...");
        if (this.b.getActivity() == null) goto L5;
        this.n = (SelectCreationMenuViewModel) new ViewModelProvider(this.b.getActivity()).get(SelectCreationMenuViewModel.class);
    L6:
        SelectCreationMenuAdapter r0 = this.m;
        RecyclerView r1 = this.c.findViewById(2131378154);
        r1.setAdapter(r0);
        r1.setLayoutManager(new GridLayoutManager(this.a, 4));
        r0.setOnItemClickListener(new f(this));
        g r2 = new g(this, r1);
        r1.getViewTreeObserver().addOnPreDrawListener(r2);
        if (this.d.findFragmentById(2131383859) != null) goto L27;
        String r3 = this.g;
        String r4 = this.e;
        String r5 = this.f;
        boolean r6 = this.h;
        boolean r7 = this.i;
        CreateSelectResult r8 = this.k;
        CreateSelectResult.CREATOR.getClass();
        yn5.b r9 = new yn5.b(r3, r4, r5, r6, r7, CreateSelectResult.a.d(r8), this.l);
        Fragment r10 = ((wn5.a) org.koin.java.a.a(wn5.a.class)).c(this.a, r9);
        FragmentTransaction r11 = this.d.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131383859) == true) goto L13;
        r11 = r11.add(2131383859, r10);
    L13:
        r11.commitAllowingStateLoss();
        BenefitStore r12 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        boolean r13 = r12.hasBenefit("ccm_create_doc");
        boolean r14 = r12.hasBenefit("ccm_create_base");
        if (this.j.r == false) goto L17;
        if (r13 == true) goto L24;
        if (r14 == false) goto L17;
        return;
    L24:
        return;
    L17:
        View r16 = this.c.findViewById(2131378167);
        if (r16 == null) goto L20;
        r16.setVisibility(8);
    L20:
        FrameLayout r17 = (FrameLayout) this.c.findViewById(2131383859);
        if (r17 == null) goto L26;
        r17.setVisibility(8);
        return;
    L26:
        return;
    L27:
        return;
    L5:
        tt5.a.h("SelectCreationMenuView", "initView()...activity is null");
        goto L6
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.o = (b.a) r1;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void o1(ArrayList<SelectCreationMenuItem> r3, ArrayList<SelectCreationMenuItem> r4) {
        ArrayList r0 = new ArrayList();
        if (hu5.a.f(r3) == false) goto L6;
        r0.addAll(r3);
    L6:
        if (hu5.a.f(r4) == false) goto L8;
        r0.addAll(r4);
    L8:
        this.m.setNewData(r0);
    }

    public h(Context r2, LifeCycleFragment r3, View r4, FragmentManager r5, String r6, String r7, String r8, boolean r9, boolean r10, SelectCreationMenuConfig r11, CreateSelectResult r12, String r13) {
        this.m = new SelectCreationMenuAdapter();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
