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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f216877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifeCycleFragment f216878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f216879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f216880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f216881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f216882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f216883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f216884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f216885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SelectCreationMenuConfig f216886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CreateSelectResult f216887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f216888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SelectCreationMenuAdapter f216889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SelectCreationMenuViewModel f216890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b.a f216891o;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final /* synthetic */ void v6(boolean r100) {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("SelectCreationMenuView", "create()...");
        if (this.f216878b.getActivity() == null) goto L5;
        this.f216890n = (SelectCreationMenuViewModel) new ViewModelProvider(this.f216878b.getActivity()).get(SelectCreationMenuViewModel.class);
    L6:
        SelectCreationMenuAdapter r100 = this.f216889m;
        RecyclerView r101 = (RecyclerView) this.f216879c.findViewById(R.id.list_menu_create_recycler_view);
        r101.setAdapter(r100);
        r101.setLayoutManager(new GridLayoutManager(this.f216877a, 4));
        r100.setOnItemClickListener(new f(this));
        g r102 = new g(this, r101);
        r101.getViewTreeObserver().addOnPreDrawListener(r102);
        if (this.f216880d.findFragmentById(R.id.recentTemplatesFragment) != null) goto L27;
        String r103 = this.f216883g;
        String r104 = this.f216881e;
        String r105 = this.f216882f;
        boolean r106 = this.f216884h;
        boolean r107 = this.f216885i;
        CreateSelectResult r108 = this.f216887k;
        CreateSelectResult.CREATOR.getClass();
        yn5.b r109 = new yn5.b(r103, r104, r105, r106, r107, CreateSelectResult.a.d(r108), this.f216888l);
        Fragment r110 = ((wn5.a) org.koin.java.a.a(wn5.a.class)).c(this.f216877a, r109);
        FragmentTransaction r111 = this.f216880d.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r111, r110, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.recentTemplatesFragment) == true) goto L13;
        r111 = r111.add(R.id.recentTemplatesFragment, r110);
    L13:
        r111.commitAllowingStateLoss();
        BenefitStore r112 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        boolean r113 = r112.hasBenefit("ccm_create_doc");
        boolean r114 = r112.hasBenefit("ccm_create_base");
        if (this.f216886j.f216822r == false) goto L17;
        if (r113 == true) goto L24;
        if (r114 == false) goto L17;
        return;
    L24:
        return;
    L17:
        View r115 = this.f216879c.findViewById(R.id.list_recommend_divider);
        if (r115 == null) goto L20;
        r115.setVisibility(8);
    L20:
        FrameLayout r116 = (FrameLayout) this.f216879c.findViewById(R.id.recentTemplatesFragment);
        if (r116 == null) goto L26;
        r116.setVisibility(8);
        return;
    L26:
        return;
    L27:
        return;
    L5:
        tt5.a.h("SelectCreationMenuView", "initView()...activity is null");
        goto L6
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f216891o = (b.a) r100;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void o1(ArrayList<SelectCreationMenuItem> r100, ArrayList<SelectCreationMenuItem> r101) {
        ArrayList r102 = new ArrayList();
        if (hu5.a.f(r100) == false) goto L6;
        r102.addAll(r100);
    L6:
        if (hu5.a.f(r101) == false) goto L8;
        r102.addAll(r101);
    L8:
        this.f216889m.setNewData(r102);
    }

    public h(Context r100, LifeCycleFragment r101, View r102, FragmentManager r103, String r104, String r105, String r106, boolean r107, boolean r110, SelectCreationMenuConfig r111, CreateSelectResult r112, String r113) {
        this.f216889m = new SelectCreationMenuAdapter();
        this.f216877a = r100;
        this.f216878b = r101;
        this.f216879c = r102;
        this.f216880d = r103;
        this.f216881e = r104;
        this.f216882f = r105;
        this.f216883g = r106;
        this.f216884h = r107;
        this.f216885i = r110;
        this.f216886j = r111;
        this.f216887k = r112;
        this.f216888l = r113;
    }
}
