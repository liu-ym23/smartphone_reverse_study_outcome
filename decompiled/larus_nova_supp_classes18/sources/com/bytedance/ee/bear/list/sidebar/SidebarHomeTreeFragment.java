package com.bytedance.ee.bear.list.sidebar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.list.sidebar.model.SidebarDocTabVM;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\"\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/SidebarHomeTreeFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubFragment;", "<init>", "()V", "sidebarHomeTreeView", "Lcom/bytedance/ee/bear/list/sidebar/ISidebarComponent;", "sidebarHost", "Lcom/bytedance/ee/bear/list/sidebar/SidebarHost;", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setRefreshLayout", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "onRefresh", "onPageSelected", "setUserVisibleHint", "isVisibleToUser", "", "initRefreshLayout", "onResume", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeTreeFragment extends Hilt_SidebarHomeTreeFragment implements c, e {
    public vd5.a g;
    public vd5.c h;
    public SmartRefreshLayout i;

    public static final class a {
    }

    public static final class b implements SidebarDocTabVM.b {
        public final /* synthetic */ SidebarHomeTreeFragment a;

        @Override // com.bytedance.ee.bear.list.sidebar.model.SidebarDocTabVM.b
        public final void a() {
            tt5.a.h("SidebarHomeTreeFragment", "onRefreshSuccess");
            SmartRefreshLayout r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.h(true);
            return;
        }

        public b(SidebarHomeTreeFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.sidebar.model.SidebarDocTabVM.b
        public final void b(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "t");
            tt5.a.h("SidebarHomeTreeFragment", "onRefreshFail: " + r3);
            SmartRefreshLayout r4 = this.a.i;
            if (r4 == null) goto L6;
            r4.h(true);
            return;
        }
    }

    static {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r1) {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // wc5.e
    public final void onPageSelected() {
        vd5.c r0 = this.h;
        if (r0 == null) goto L8;
        vd5.a r1 = this.g;
        if (r1 == null) goto L9;
        r1.o(r0);
        return;
    L9:
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L6;
        c r0 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        return r0.e9();
    L6:
        return PassportcConvention.b(this);
    L8:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.sidebar.Hilt_SidebarHomeTreeFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        vd5.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.onDestroyView();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        vd5.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m46provideComponent() {
        return provideComponent();
    }

    public SidebarHomeTreeFragment() {
    }

    @Override // wc5.e
    public final void d2(cqa.h r2) {
        vd5.c r3 = this.h;
        if (r3 == null) goto L7;
        vd5.a r0 = this.g;
        if (r0 == null) goto L7;
        r0.o(r3);
    L7:
        vd5.c r4 = this.h;
        if (r4 == null) goto L13;
        SidebarDocTabVM r5 = r4.c;
        if (r5 == null) goto L14;
        r5.refresh(new b(this));
        return;
    L14:
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        if (r2 == true) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof wc5.c) == false) goto L9;
        wc5.c r3 = getParentFragment();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.list.homepage.IDocTabFragment");
        this.i = r3.xZ();
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        vd5.c r4 = new vd5.c(this, new ce5.a(this));
        this.h = r4;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L5;
        SidebarDocTabVM r6 = (SidebarDocTabVM) new ViewModelProvider(r5).get(SidebarDocTabVM.class);
    L6:
        r4.c = r6;
        vd5.c r7 = this.h;
        if (r7 == null) goto L12;
        vd5.a r8 = this.g;
        if (r8 == null) goto L12;
        r8.h(r7);
    L12:
        if ((getParentFragment() instanceof wc5.c) == false) goto L15;
        wc5.c r9 = getParentFragment();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.list.homepage.IDocTabFragment");
        this.i = r9.xZ();
        return;
    L15:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        vd5.c r0 = this.h;
        if (r0 == null) goto L8;
        vd5.a r1 = this.g;
        if (r1 == null) goto L9;
        r1.g(r0, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        SidebarHomeTreeView r6 = null;
        if (r5 == null) goto L9;
        SidebarHomeTreeView r7 = ((tp5.a) org.koin.java.a.c(tp5.a.class, null, null, 6)).b(r5, new ce5.a(this));
        if ((r7 instanceof vd5.a) == false) goto L7;
        r6 = r7;
    L7:
        this.g = r6;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.View");
        return r6;
    L9:
        return null;
    }
}
