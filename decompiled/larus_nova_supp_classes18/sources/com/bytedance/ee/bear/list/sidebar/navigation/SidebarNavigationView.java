package com.bytedance.ee.bear.list.sidebar.navigation;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher;
import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$closeChatMode$1$1;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.ContextsKt;
import gc5.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sc5.i;
import vd5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001fJ\b\u0010,\u001a\u00020#H\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0018\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020/2\u0006\u0010)\u001a\u00020*H\u0002J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u00101\u001a\u00020/H\u0002J\u000e\u00108\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u00109\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationView;", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "Lcom/bytedance/ee/bear/list/sidebar/ISidebarComponent;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAdapter", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationAdapter;", "isDisableWiki", "", "module", "", "homeDriveOnBoarding", "Lcom/bytedance/ee/bear/list/drive/HomeDriveOnBoarding;", "isVisibleToUser", "mHomeDriveGuideRunnable", "Ljava/lang/Runnable;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "spaceHomePageAiLauncher", "Lcom/bytedance/ee/bear/list/homepage/ai/SpaceHomePageAiLauncher;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "isPadMode", "onItemClickCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "navigationId", "", "getOnItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "init", "fragment", "Landroidx/fragment/app/Fragment;", "currentPosition", "removeHomeDriveGuideRunnable", "getNavigationItems", "", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationItem;", "onNavigationItemClick", "item", "showHomeDriveGuide", "dismissOnboarding", "onResumeView", "onPauseView", "onDestroyView", "reportPageClick", "setCurrentModule", "getSubModule", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarNavigationView extends BaseRecyclerView implements vd5.a {
    public static final /* synthetic */ int w = 0;
    public SidebarNavigationAdapter l;
    public boolean m;
    public String n;
    public i o;
    public boolean p;
    public final b q;
    public ce5.a r;
    public SpaceHomePageAiLauncher s;
    public SidebarNavigationView$init$2 t;
    public boolean u;
    public Function1<? super Integer, Unit> v;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SidebarNavigationView a;

        public b(SidebarNavigationView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView] */
        public final void a() {
            ?? r0 = this.a;
            int r1 = SidebarNavigationView.w;
            FragmentActivity r2 = ContextsKt.findActivity(r0.getContext());
            SidebarNavigationAdapter r3 = null;
            if ((r2 instanceof FragmentActivity) == false) goto L5;
            FragmentActivity r4 = r2;
        L6:
            if (r4 != null) goto L8;
            return;
        L8:
            if (qc5.a.h() == true) goto L10;
            return;
        L10:
            if (r0.p == false) goto L21;
            r0.o = new i(new ce5.a(), r4);
            tt5.a.h("SideBarNavigationView", "showHomeDriveOnBoardingPage");
            i r5 = r0.o;
            if (r5 == null) goto L22;
            SidebarNavigationAdapter r6 = r0.l;
            if (r6 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L17:
            r5.f(r3.b);
            return;
        L16:
            r3 = r6;
            goto L17
        L22:
            return;
        L21:
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // vd5.a
    public final void f() {
        this.p = true;
    }

    @Override // vd5.a
    public final void g(c r1, int r2, int r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r1, "host");
    }

    @Override // vd5.a
    public final void h(c r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
    }

    @Override // vd5.a
    public final void o(c r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
    }

    @Override // vd5.a
    public final void onDestroyView() {
        j.e(this.q);
        SpaceHomePageAiLauncher r0 = this.s;
        if (r0 == null) goto L8;
        tt5.a.h("SpaceHomePageAiLauncher", "onDestroy close chat mode ");
        String r1 = r0.b;
        if (r1 == null) goto L9;
        r0.a().f(r1, new SpaceHomePageAiLauncher$closeChatMode$1$1());
        return;
    L9:
        return;
    }

    public final Function1<Integer, Unit> getOnItemClickCallback() {
        return this.v;
    }

    public final String getSubModule() {
        return this.n;
    }

    public final void setCurrentModule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        this.n = r2;
    }

    public final void setOnItemClickCallback(Function1<? super Integer, Unit> r1) {
        this.v = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<com.bytedance.ee.bear.list.sidebar.navigation.b> u(boolean r12) {
        ArrayList r0 = new ArrayList();
        if (r12 == false) goto L5;
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.HOME_PAGE.id, 2131254884, getContext().getResources().getColor(2131108852), getContext().getString(2131889609), 2131102121));
    L5:
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.SIDEBAR_DRIVE.id, 2131254274, getContext().getResources().getColor(2131108852), getContext().getString(2131888777)));
        if (this.m == true) goto L8;
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.WIKI.id, 2131256223, getContext().getResources().getColor(2131105567), getContext().getString(2131887849)));
    L8:
        ce5.a r1 = this.r;
        ce5.a r3 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r1 = null;
    L11:
        qc5.b.a(r1);
        if (r12 == true) goto L14;
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.FAVORITE.id, 2131254138, getContext().getResources().getColor(2131108869), getContext().getString(2131887927), 2131101124));
    L14:
        ce5.a r2 = this.r;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L18:
        qc5.b.a(r3);
        int r4 = t.a;
        if (qc5.a.a() == false) goto L21;
        if (r12 == true) goto L21;
    L23:
        if (qc5.a.a() == false) goto L25;
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.AI_NOTE.id, 2131255862, getContext().getResources().getColor(2131105567), getContext().getString(2131888699), 2131101111));
    L25:
        return r0;
    L21:
        r0.add(new com.bytedance.ee.bear.list.sidebar.navigation.b(NavigationEnum.MANUAL_OFFLINE.id, 2131255243, getContext().getResources().getColor(2131108655), getContext().getString(2131887949)));
        goto L23
    L17:
        r3 = r2;
        goto L18
    }

    public SidebarNavigationView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attr");
        super(r2, r3);
        this.n = "recent";
        this.q = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView$init$2] */
    public final void v(final Fragment r3, ce5.a r4, final boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        this.u = r5;
        this.r = r4;
        setOverScrollMode(2);
        this.m = ud5.a.a(this);
        qc5.b.a(r4);
        SidebarNavigationAdapter r1 = new SidebarNavigationAdapter(r3, u(r5), r5, r6);
        this.l = r1;
        Function1<com.bytedance.ee.bear.list.sidebar.navigation.b, Unit> r7 = new SidebarNavigationView$init$1(this, r3);
        Intrinsics.checkNotNullParameter(r7, "listener");
        r1.a = r7;
        RecyclerView.Adapter r8 = this.l;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r8 = null;
    L5:
        setAdapter(r8);
        final Context r9 = getContext();
        this.t = new SidebarNavigationView$init$2(this, r9);
        final Context r10 = getContext();
        SidebarNavigationView$init$2 r11 = new SidebarNavigationView$init$3(this, r10);
        if (r5 == true) goto L9;
        r11 = this.t;
    L9:
        setLayoutManager(r11);
        int r12 = SpaceHomePageAiLauncher.g;
        SpaceHomePageAiLauncher.Companion.a(getContext(), r4, new SidebarNavigationView$init$4(this, r5));
    }
}
