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
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0016J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u000203H\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u000203H\u0016J\b\u0010G\u001a\u00020BH\u0016J\b\u0010H\u001a\u00020BH\u0016J\b\u0010I\u001a\u00020BH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/lark/BaseHeaderFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/list/homepage/IPadHomeStyle;", "<init>", "()V", "mPresenter", "Lcom/bytedance/ee/bear/content/creation/mvp/SelectCreationMenuPresenter;", "enableFolder", "", "getEnableFolder", "()Z", "setEnableFolder", "(Z)V", "isPrivateKaPkg", "setPrivateKaPkg", "config", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;", "getConfig", "()Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;", "setConfig", "(Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuConfig;)V", "menuContext", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;", "getMenuContext", "()Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;", "setMenuContext", "(Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuContext;)V", "mCreationMenuManager", "Lcom/bytedance/ee/bear/list/create/ListSelectCreationMenuManager;", "forsetiChainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "listener", "Lcom/ss/android/lark/api/ui/IForsetiNodeWidthListener;", "minWideWidth", "", "minNormalWidth", "isWideItem", "isNarrowItem", "headerView", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;", "getHeaderView", "()Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;", "setHeaderView", "(Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemView;)V", "mListener", "Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "getMListener", "()Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "setMListener", "(Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateForsetiViewMode", "onResume", "initMVP", "rootView", "Landroid/view/ViewGroup;", "addObserver", "notifyForsetiViewMode", "mode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "getLogTag", "", "onDestroyView", "provideHasTemplate", "isWiki", "getWikiList", "getModule", "getSubModule", "getSrcModule", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseHeaderFragment extends BaseCCMForsetiFragment implements wc5.h {
    public com.bytedance.ee.bear.content.creation.mvp.e f;
    public final SelectCreationMenuConfig g;
    public final iw4.h h;
    public final x0 i;
    public final int j;
    public final int k;
    public boolean l;
    public boolean m;
    public com.bytedance.ee.bear.creationmenu.c n;
    public com.bytedance.ee.bear.creationmenu.f o;

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
        com.ss.android.lark.forsetiutils.b r0 = com.ss.android.lark.forsetiutils.b.a;
        FragmentActivity r1 = getActivity();
        r0.getClass();
        ForsetiViewMode r2 = com.ss.android.lark.forsetiutils.b.a(r1);
        tt5.a.h("BaseHeaderFragment", "updateForsetiViewMode mode:" + r2);
        if (r2 == null) goto L6;
        aa0(r2);
        return;
    }

    public BaseHeaderFragment() {
        boolean r0 = ((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().a;
        boolean r1 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).d();
        SelectCreationMenuConfig r2 = new SelectCreationMenuConfig();
        r2.k = true;
        r2.l = t0.s();
        if (r1 == true) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r2.o = r3;
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        r2.p = r4.f("spacekit.mobile.docx_create_enable");
        r2.n = r0;
        r2.q = r4.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        int r5 = com.bytedance.ee.bear.content.creation.location.a.a;
        r2.i = com.bytedance.ee.bear.content.creation.location.a.g();
        r2.b = com.bytedance.ee.bear.content.creation.location.a.i();
        r2.e = com.bytedance.ee.bear.content.creation.location.a.h();
        r2.h = com.bytedance.ee.bear.content.creation.location.a.f();
        r2.j = true;
        com.bytedance.ee.bear.content.creation.location.a.b r6 = com.bytedance.ee.bear.content.creation.location.a.j();
        if (r6.a == false) goto L12;
        boolean r7 = r6.b;
    L13:
        r2.a = r7;
        r2.d = true;
        r2.f = true;
        r2.g = true;
        this.g = r2;
        iw4.h r8 = new iw4.h();
        r8.b = W90();
        r8.c = m6();
        r8.d = X90();
        r8.f = false;
        qc5.a.j();
        r8.g = true;
        this.h = r8;
        this.i = new x0();
        this.j = UIHelper.dp2px(633.0f);
        this.k = UIHelper.dp2px(340.0f);
        return;
    L12:
        r7 = false;
        goto L13
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L8;
        r3 = false;
        goto L9
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.bytedance.ee.bear.content.creation.mvp.e r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r0 = null;
    L5:
        r0.destroy();
        this.i.d(requireActivity());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("BaseHeaderFragment", "onResume() called");
        ba0();
    }

    public final void Z90(ViewGroup r13) {
        tt5.a.h(getLogTag(), "initMVP()...");
        com.bytedance.ee.bear.creationmenu.c r0 = this.n;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        boolean r8 = this instanceof PadWikiFragment;
        com.bytedance.ee.bear.creationmenu.c r9 = new com.bytedance.ee.bear.creationmenu.c(requireContext(), this, r13, !r8, this.h, this.l, this.m, r8);
        this.n = r9;
        com.bytedance.ee.bear.creationmenu.f r1 = this.o;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, "listener");
        hac.b.a.b("CreationMenuItemView", "setWikiPlusMenuItemClickListener() called with: listener = " + r1 + " this:" + r9);
        r9.B = r1;
    L8:
        com.bytedance.ee.bear.content.creation.mvp.c r3 = new com.bytedance.ee.bear.content.creation.mvp.c(this.g, getContext());
        com.bytedance.ee.bear.creationmenu.c r2 = this.n;
        iw4.h r4 = this.h;
        this.f = new com.bytedance.ee.bear.content.creation.mvp.e(this, r2, r3, r4.b, "", r4.e, r4.f, "quick_access", r4.d, r4.g);
        Y90();
        com.bytedance.ee.bear.content.creation.mvp.e r5 = this.f;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r5 = null;
    L11:
        r5.create();
    }

    public void aa0(ForsetiViewMode r4) {
        Intrinsics.checkNotNullParameter(r4, "mode");
        tt5.a.h(getLogTag(), "notifyForsetiViewMode() called with: mode = " + r4);
        com.bytedance.ee.bear.creationmenu.c r0 = this.n;
        if (r0 == null) goto L15;
        ViewGroup r1 = r0.w;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r1 = null;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        if (r4.isExpand() == false) goto L12;
        int r5 = 0;
    L13:
        r1.setVisibility(r5);
        return;
    L12:
        r5 = 8;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.i.b(requireActivity(), getParentFragment());
        Fragment r6 = getParentFragment();
        if (r6 == null) goto L5;
        ForsetiViewModel r7 = (ForsetiViewModel) new ViewModelProvider(r6, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        r7.getSecondNodeWidth().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.lark.a(this));
        r7.getViewMode().observe(getViewLifecycleOwner(), new b(this));
    L5:
        Z90((ViewGroup) r4);
        ba0();
        tt5.a.h(getLogTag(), "this:" + hashCode());
    }
}
