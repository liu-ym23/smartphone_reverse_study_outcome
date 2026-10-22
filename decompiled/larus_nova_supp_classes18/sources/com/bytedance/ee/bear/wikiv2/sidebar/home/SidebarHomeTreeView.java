package com.bytedance.ee.bear.wikiv2.sidebar.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.sidebar.model.SidebarDocTabVM;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kq5.i;
import kq5.j;
import kq5.k;
import kq5.l;
import lc5.x;
import sd5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003=>?B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J$\u0010,\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207H\u0002J*\u00108\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/home/SidebarHomeTreeView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/bytedance/ee/bear/list/sidebar/ISidebarComponent;", "context", "Landroid/content/Context;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;Landroid/util/AttributeSet;II)V", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "sidebarRootTreeViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;", "getSidebarRootTreeViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;", "setSidebarRootTreeViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;)V", "viewModelStoreHolder", "Landroidx/lifecycle/ViewModelStore;", "host", "Lcom/bytedance/ee/bear/list/sidebar/SidebarHost;", "sidebarTreeCtrlView", "mIsFirstContentDrawn", "", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "onViewCreated", "", "onPageSelected", "onDestroyView", "onRefreshFromDatabaseAndNetwork", "Lio/reactivex/Flowable;", "onRefreshFromNet", "onRefreshDocumentFromNet", "reloadType", "", "", "refreshSidebarTreeView", "workspacePair", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/home/IWikiRelationDecoration;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "notifyFirstContentDraw", "decoration", "instanceViewConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewConfig;", "navigation", "param", "Lcom/bytedance/ee/bear/wikiv2/sidebar/home/SidebarHomeTreeView$NavigationParams;", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "SidebarTreeCtrlViewDelegate", "NavigationParams", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeTreeView extends FrameLayout implements ViewModelStoreOwner, vd5.a {
    public static final /* synthetic */ int g = 0;
    public final ce5.a a;
    public SidebarTreeCtrlView b;
    public final ViewModelStore c;
    public vd5.c d;
    public final SidebarTreeCtrlView e;
    public boolean f;

    public static final class a {
    }

    public static final class b {
        public final TreeNode a;
        public final AnalyticConstant.OpenType b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            AnalyticConstant.OpenType r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "NavigationParams(treeNode=" + this.a + ", openType=" + this.b + ", uniqueUiId=" + this.c + ", from=" + this.d + ')';
        }

        public b(TreeNode r2, AnalyticConstant.OpenType r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "treeNode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final class c extends WikiTreeCtrlView.d {
        public final /* synthetic */ SidebarHomeTreeView a;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Boolean r2 = (Boolean) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r3) {
                tt5.a.d("SidebarHomeTreeView", "onRefreshDocumentFromNet fail: " + ((Throwable) r3));
            }
        }

        public c(SidebarHomeTreeView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void m(List<String> r6) {
            Intrinsics.checkNotNullParameter(r6, "reloadType");
            Intrinsics.checkNotNullParameter(r6, "reloadType");
            tt5.a.h("SidebarHomeTreeView", "reload data");
            SidebarHomeTreeView r0 = this.a;
            vd5.c r1 = r0.d;
            if (r1 == null) goto L8;
            SidebarDocTabVM r2 = r1.c;
            if (r2 == null) goto L9;
            r0.getClass();
            r2.addDisposable(((SidebarTreeCtrlVM) new ViewModelProvider(r1.a).get(SidebarTreeCtrlVM.class)).onRefreshFromNetWithType(r1.b, r6).observeOn(fo5.d.d()).map(new j(r0, r1)).subscribe(a.a, b.a));
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void r(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileExtra");
            tt5.a.h("SidebarHomeTreeView", "onUploadFinish");
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void e(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "newToken");
            Intrinsics.checkNotNullParameter(r6, "uniqueUiId");
            SidebarTreeCtrlView r1 = this.a.e;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r6, "uniqueUiId");
            r1.getWikiTreeViewFromXml().j(r6);
            TreeNode r7 = this.a.e.g(r5);
            if (r7 != null) goto L6;
            tt5.a.k("SidebarHomeTreeView", "onInsert fail: treeNode is null");
            return;
        L6:
            SidebarHomeTreeView.a(this.a, new b(r7, AnalyticConstant.OpenType.WIKI_CREATE_NEW, r6, "tab_create"));
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void f(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r6, "uniqueUiId");
            TreeNode r7 = this.a.e.g(r5);
            if (r7 != null) goto L7;
            tt5.a.k("SidebarHomeTreeView", "onItemClick fail: treeNode is null");
            return;
        L7:
            if (r7.wiki_node_type != VirtualNode.TITLE_TOTAL_SHARE.getWikiNodeType()) goto L10;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/list/space/activity").j("extra_destination", NavigationEnum.SHARED_SPACE.id).e();
            return;
        L10:
            SidebarHomeTreeView.a(this.a, new b(r7, AnalyticConstant.OpenType.WIKI_ALL, r6, null));
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void g(String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "toSpaceId");
            Intrinsics.checkNotNullParameter(r4, "toToken");
            Intrinsics.checkNotNullParameter(r5, "toSpaceName");
            o.a(r3, r5, r4, null, Boolean.FALSE);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void o(String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "toSpaceId");
            Intrinsics.checkNotNullParameter(r4, "toToken");
            Intrinsics.checkNotNullParameter(r5, "toSpaceName");
            o.a(r3, r5, r4, null, Boolean.FALSE);
        }
    }

    public static final class d implements xd5.a {
        public final /* synthetic */ SidebarHomeTreeView a;
        public final /* synthetic */ vd5.c b;

        @Override // xd5.a
        public final Flowable<?> generate() {
            SidebarHomeTreeView r0 = this.a;
            vd5.c r1 = this.b;
            int r2 = SidebarHomeTreeView.g;
            r0.getClass();
            return ((SidebarTreeCtrlVM) new ViewModelProvider(r1.a).get(SidebarTreeCtrlVM.class)).onRefreshFromNet(r1.b).observeOn(fo5.d.d()).map(new l(r0, r1));
        }

        public d(SidebarHomeTreeView r1, vd5.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            tt5.a.d("SidebarHomeTreeView", "onRefreshFromDatabaseAndNet fail: " + ((Throwable) r3));
        }
    }

    static {
    }

    @Override // vd5.a
    public final /* synthetic */ void f() {
    }

    public final SidebarTreeCtrlView getSidebarRootTreeViewFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131386420);
        this.b = (SidebarTreeCtrlView) r0;
    L6:
        return (SidebarTreeCtrlView) r0;
    }

    @Override // vd5.a
    public final void onDestroyView() {
        vd5.c r0 = this.d;
        if (r0 == null) goto L7;
        SidebarDocTabVM r1 = r0.c;
        if (r1 == null) goto L7;
        r1.removeRefreshFlowable("SidebarHomeTreeView");
    L7:
        this.c.clear();
        this.d = null;
    }

    public final ce5.a getUserComponentAbility() {
        return this.a;
    }

    public ViewModelStore getViewModelStore() {
        return this.c;
    }

    @Override // vd5.a
    public final void h(vd5.c r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r5, "host");
        SidebarDocTabVM r0 = r5.c;
        if (r0 == null) goto L5;
        r0.addRefreshFlowable("SidebarHomeTreeView", new d(this, r5));
    L5:
        SidebarDocTabVM r1 = r5.c;
        if (r1 == null) goto L8;
        r1.addDisposable(((SidebarTreeCtrlVM) new ViewModelProvider(r5.a).get(SidebarTreeCtrlVM.class)).onRefreshFromDatabaseAndNetwork(r5.b).observeOn(fo5.d.d()).map(new k(this, r5)).subscribe(e.a, f.a));
    L8:
        this.d = r5;
    }

    @Override // vd5.a
    public final void o(vd5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r2, "host");
        SidebarTreeCtrlView r3 = this.e;
        if (r3.f == null) goto L6;
        r3.getViewModel().refresh();
        return;
    }

    public final void setSidebarRootTreeViewFromXml(SidebarTreeCtrlView r1) {
        this.b = r1;
    }

    public SidebarHomeTreeView(Context r3, ce5.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        super(r3, null, 0, 0);
        this.a = r4;
        this.c = new ViewModelStore();
        LayoutInflater.from(r3).inflate(2131564863, this);
        this.e = getSidebarRootTreeViewFromXml();
    }

    public static final void a(SidebarHomeTreeView r19, b r20) {
        r19.getClass();
        TreeNode r2 = r20.a;
        Fragment r4 = null;
        if (r2.isSpaceDocument == true) goto L15;
        Bundle r8 = new Bundle();
        AnalyticConstant.OpenType r3 = r20.b;
        if (r3 == null) goto L7;
        String r5 = r3.getType();
    L8:
        r8.putString("ccm_open_type", r5);
        r8.putSerializable("wiki_info", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r20.a));
        r8.putString("unique_ui_id", r20.c);
        String r6 = r20.d;
        if (r6 == null) goto L11;
        r8.putString("extra_from", r6);
    L11:
        TreeNode r1 = r20.a;
        String r7 = r1.space_id;
        String r9 = r1.wiki_token;
        vd5.c r0 = r19.d;
        if (r0 == null) goto L14;
        r4 = r0.a;
    L14:
        o.b(r7, "", r9, r8, Boolean.FALSE, r4, null);
        return;
    L7:
        r5 = null;
        goto L8
    L15:
        vd5.c r10 = r19.d;
        if (r10 == null) goto L37;
        Fragment r11 = r10.a;
        if (r11 == null) goto L38;
        FragmentActivity r12 = r11.getActivity();
        if (r12 == null) goto L39;
        Document r13 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.b(r2);
        r13.x2 = true;
        r13.w = true;
        boolean r14 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        Context r15 = r19.getContext();
        ArrayList r16 = new ArrayList();
        Context r17 = new e0(r15, r13, "home", r16, "quick_access", "").getContext();
        if (r13.getType() != sbb.e.f.b) goto L25;
        sd5.e r18 = new sd5.c(r17, "home", 1, "");
    L31:
        RouteBean r21 = r18.a(r13);
        vd5.c r22 = r19.d;
        if (r22 == null) goto L34;
        r4 = r22.a;
    L34:
        r21.a(r4);
        t0.r(new v0(r12, r13, r14, r21, "home", "quick_access", AnalyticConstant.OpenType.HOME_CREATE_PIN.getType(), -1, false, 0), r19.a);
        return;
    L25:
        if (r13.getType() != sbb.e.l.b) goto L28;
        r18 = new sd5.b(new e0(r17, r13, "home", r16, "quick_access", ""), "");
        goto L31
    L28:
        if (r13.getType() != sbb.e.n.b) goto L30;
        r18 = new g();
        goto L31
    L30:
        r18 = new sd5.a(r17);
        goto L31
    L39:
        return;
    L38:
        return;
    }

    public static final void b(SidebarHomeTreeView r17, vd5.c r18, Pair r19) {
        r17.getClass();
        kq5.c r9 = (kq5.c) r19.getFirst();
        e3 r10 = (e3) r19.getSecond();
        String r11 = "";
        boolean r12 = false;
        if (r17.f == true) goto L24;
        vd5.c r1 = r17.d;
        if (r1 == null) goto L11;
        Fragment r2 = r1.a;
        if (r2 == null) goto L11;
        if (r2.getUserVisibleHint() != true) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L24;
        ResultCode r4 = r9.b();
        if (r4.isDEC0() == false) goto L16;
    L22:
        x.c().e(0, "", "content", "key_open_finish_content");
    L23:
        r17.f = true;
        goto L24
    L16:
        if (r4.isDEC1() == true) goto L22;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L21;
        x.c().e(1, "SEC4", "content", "key_open_finish_content");
        goto L23
    L21:
        x.c().e(1, "SEC5", "content", "key_open_finish_content");
    L11:
        r3 = false;
    L24:
        SidebarTreeCtrlView r14 = r17.e;
        Fragment r5 = r18.a;
        WikiTreeCtrlView.c r6 = new WikiTreeCtrlView.c();
        r6.c = true;
        r6.d = true;
        r6.e = true;
        r6.f = true;
        r6.h = true;
        vd5.c r7 = r17.d;
        Integer r16 = null;
        if (r7 == null) goto L27;
        List<? extends Function<TreeNode, Boolean>> r8 = CollectionsKt.listOf(new n(r7.a, new WeakReference(r17.e), r17.a));
    L28:
        r6.k = r8;
        vd5.c r13 = r17.d;
        if (r13 == null) goto L31;
        List<? extends Function<TreeNode, Boolean>> r15 = CollectionsKt.listOf(new p(r13.a.getViewLifecycleOwner(), new WeakReference(r17.e)));
    L32:
        r6.l = r15;
        r6.j = CollectionsKt.listOf(new Function[]{kq5.f.a, kq5.g.a, new kq5.h(r17)});
        r6.i = i.a;
        r6.o = CollectionsKt.listOf(new WikiBottomDecoration(2131168357));
        Intrinsics.checkNotNullParameter("SidebarHomeTreeView", "<set-?>");
        r6.p = "SidebarHomeTreeView";
        r6.q = "sidebar";
        r6.r = 1;
        r6.n = true;
        f1 r110 = new f1(r5, r10, null, r6, r17, null, r18.b);
        r110.h = false;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r110, "initConfig");
        if (r14.l.get() == true) goto L35;
        r14.i(r110);
        r14.l.set(true);
    L48:
        r17.e.setViewDelegate(new c(r17));
        r9.a(r17.e, r10);
        return;
    L35:
        e3 r20 = r110.c;
        if (r20 == null) goto L48;
        WikiTreeView r0 = r14.getWikiTreeViewFromXml();
        int r21 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
        String r22 = r20.o();
        if (r22 == null) goto L41;
        r11 = r22;
    L41:
        r0.setSpaceId(r11);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r23 = r14.getViewModel();
        String r24 = r110.d;
        r23.load(r20, r24, r110.g, !r14.m(r24), r110.h);
        WikiTreeView r25 = r14.getWikiTreeViewFromXml();
        SpaceInfo r26 = r14.getViewModel().getSpaceInfo();
        if (r26 == null) goto L44;
        r12 = r26.isMyLib();
    L44:
        r25.setMyLib(r12);
        WikiTreeView r27 = r14.getWikiTreeViewFromXml();
        SpaceInfo r28 = r14.getViewModel().getSpaceInfo();
        if (r28 == null) goto L47;
        r16 = Integer.valueOf(r28.space_type);
    L47:
        r27.setSpaceType(r16);
        goto L48
    L31:
        r15 = null;
        goto L32
    L27:
        r8 = null;
        goto L28
    }

    @Override // vd5.a
    public final void g(vd5.c r2, int r3, int r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r2, "host");
        this.e.o(r3, r4, r5);
    }
}
