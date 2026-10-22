package com.bytedance.ee.bear.lark;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.lark.space.PadWikiFragment;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0016J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u000203H\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u000203H\u0016J\b\u0010G\u001a\u00020BH\u0016J\b\u0010H\u001a\u00020BH\u0016J\b\u0010I\u001a\u00020BH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/lark/BaseHeaderFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/list/homepage/IPadHomeStyle;", "<init>", "()V", "mPresenter", "Lcom/bytedance/ee/bear/content/creation/mvp/SelectCreationMenuPresenter;", "enableFolder", "", "getEnableFolder", "()Z", "setEnableFolder", "(Z)V", "isPrivateKaPkg", "setPrivateKaPkg", "config", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;", "getConfig", "()Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;", "setConfig", "(Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;)V", "menuContext", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;", "getMenuContext", "()Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;", "setMenuContext", "(Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;)V", "mCreationMenuManager", "Lcom/bytedance/ee/bear/list/create/ListSelectCreationMenuManager;", "forsetiChainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "listener", "Lcom/ss/android/lark/api/ui/IForsetiNodeWidthListener;", "minWideWidth", "", "minNormalWidth", "isWideItem", "isNarrowItem", "headerView", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;", "getHeaderView", "()Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;", "setHeaderView", "(Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;)V", "mListener", "Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "getMListener", "()Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "setMListener", "(Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateForsetiViewMode", "onResume", "initMVP", "rootView", "Landroid/view/ViewGroup;", "addObserver", "notifyForsetiViewMode", "mode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "getLogTag", "", "onDestroyView", "provideHasTemplate", "isWiki", "getWikiList", "getModule", "getSubModule", "getSrcModule", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseHeaderFragment extends BaseCCMForsetiFragment implements wc5.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.content.creation.mvp.e f227159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SelectCreationMenuConfig f227160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final iw4.h f227161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x0 f227162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f227163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f227164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f227165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f227166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.c f227167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.f f227168o;

    public static final class a {
    }

    static {
    }

    public String W90() {
        return "";
    }

    public String X90() {
        return "";
    }

    public void Y90() {
    }

    public String getLogTag() {
        return "BaseHeaderFragment";
    }

    public String m6() {
        return "";
    }

    public final void ba0() {
        com.ss.android.lark.forsetiutils.b r100 = com.ss.android.lark.forsetiutils.b.f424768a;
        FragmentActivity r101 = getActivity();
        r100.getClass();
        ForsetiViewMode r102 = com.ss.android.lark.forsetiutils.b.a(r101);
        tt5.a.h("BaseHeaderFragment", "updateForsetiViewMode mode:" + r102);
        if (r102 == null) goto L6;
        aa0(r102);
        return;
    }

    public BaseHeaderFragment() {
        boolean r100 = ((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().f217118a;
        boolean r101 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).d();
        SelectCreationMenuConfig r102 = new SelectCreationMenuConfig();
        r102.f216815k = true;
        r102.f216816l = t0.s();
        if (r101 == true) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r102.f216819o = r103;
        com.bytedance.ee.bear.appsetting.c r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        r102.f216820p = r104.f("spacekit.mobile.docx_create_enable");
        r102.f216818n = r100;
        r102.f216821q = r104.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        int r105 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        r102.f216813i = com.bytedance.ee.bear.content.creation.location.a.g();
        r102.f216806b = com.bytedance.ee.bear.content.creation.location.a.i();
        r102.f216809e = com.bytedance.ee.bear.content.creation.location.a.h();
        r102.f216812h = com.bytedance.ee.bear.content.creation.location.a.f();
        r102.f216814j = true;
        com.bytedance.ee.bear.content.creation.location.a.b r106 = com.bytedance.ee.bear.content.creation.location.a.j();
        if (r106.f216833a == false) goto L12;
        boolean r107 = r106.f216834b;
    L13:
        r102.f216805a = r107;
        r102.f216808d = true;
        r102.f216810f = true;
        r102.f216811g = true;
        this.f227160g = r102;
        iw4.h r108 = new iw4.h();
        r108.f496209b = W90();
        r108.f496210c = m6();
        r108.f496211d = X90();
        r108.f496213f = false;
        qc5.a.j();
        r108.f496214g = true;
        this.f227161h = r108;
        this.f227162i = new x0();
        this.f227163j = UIHelper.dp2px(633.0f);
        this.f227164k = UIHelper.dp2px(340.0f);
        return;
    L12:
        r107 = false;
        goto L13
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.bitable.enable", true) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.bytedance.ee.bear.content.creation.mvp.e r100 = this.f227159f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r100 = null;
    L5:
        r100.destroy();
        this.f227162i.d(requireActivity());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("BaseHeaderFragment", "onResume() called");
        ba0();
    }

    public final void Z90(ViewGroup r110) {
        tt5.a.h(getLogTag(), "initMVP()...");
        com.bytedance.ee.bear.creationmenu.c r100 = this.f227167n;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        boolean r101 = this instanceof PadWikiFragment;
        com.bytedance.ee.bear.creationmenu.c r102 = new com.bytedance.ee.bear.creationmenu.c(requireContext(), this, r110, !r101, this.f227161h, this.f227165l, this.f227166m, r101);
        this.f227167n = r102;
        com.bytedance.ee.bear.creationmenu.f r103 = this.f227168o;
        if (r103 == null) goto L8;
        Intrinsics.checkNotNullParameter(r103, "listener");
        hac.b.f484427a.b("CreationMenuItemView", "setWikiPlusMenuItemClickListener() called with: listener = " + r103 + " this:" + r102);
        r102.B = r103;
    L8:
        com.bytedance.ee.bear.content.creation.mvp.c r104 = new com.bytedance.ee.bear.content.creation.mvp.c(this.f227160g, getContext());
        com.bytedance.ee.bear.creationmenu.c r105 = this.f227167n;
        iw4.h r106 = this.f227161h;
        this.f227159f = new com.bytedance.ee.bear.content.creation.mvp.e(this, r105, r104, r106.f496209b, "", r106.f496212e, r106.f496213f, "quick_access", r106.f496211d, r106.f496214g);
        Y90();
        com.bytedance.ee.bear.content.creation.mvp.e r107 = this.f227159f;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r107 = null;
    L11:
        r107.create();
    }

    public void aa0(ForsetiViewMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        tt5.a.h(getLogTag(), "notifyForsetiViewMode() called with: mode = " + r100);
        com.bytedance.ee.bear.creationmenu.c r101 = this.f227167n;
        if (r101 == null) goto L15;
        BaseRecyclerView r102 = r101.f217313w;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r102 = null;
    L8:
        if (r102 != null) goto L10;
        return;
    L10:
        if (r100.isExpand() == false) goto L12;
        int r103 = 0;
    L13:
        r102.setVisibility(r103);
        return;
    L12:
        r103 = 8;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f227162i.b(requireActivity(), getParentFragment());
        Fragment r102 = getParentFragment();
        if (r102 == null) goto L5;
        ForsetiViewModel r103 = (ForsetiViewModel) new ViewModelProvider(r102, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        r103.getSecondNodeWidth().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.lark.a(this));
        r103.getViewMode().observe(getViewLifecycleOwner(), new b(this));
    L5:
        Z90((ViewGroup) r100);
        ba0();
        tt5.a.h(getLogTag(), "this:" + hashCode());
    }
}
