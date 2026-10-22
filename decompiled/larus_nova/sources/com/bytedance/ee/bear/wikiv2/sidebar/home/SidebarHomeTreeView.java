package com.bytedance.ee.bear.wikiv2.sidebar.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.contract.AnalyticConstant$OpenType;
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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003=>?B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0&2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J$\u0010,\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207H\u0002J*\u00108\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/home/SidebarHomeTreeView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/bytedance/ee/bear/list/sidebar/ISidebarComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;Landroid/util/AttributeSet;II)V", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "sidebarRootTreeViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;", "getSidebarRootTreeViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;", "setSidebarRootTreeViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;)V", "viewModelStoreHolder", "Landroidx/lifecycle/ViewModelStore;", "host", "Lcom/bytedance/ee/bear/list/sidebar/SidebarHost;", "sidebarTreeCtrlView", "mIsFirstContentDrawn", "", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "onViewCreated", "", "onPageSelected", "onDestroyView", "onRefreshFromDatabaseAndNetwork", "Lio/reactivex/Flowable;", "onRefreshFromNet", "onRefreshDocumentFromNet", "reloadType", "", "", "refreshSidebarTreeView", "workspacePair", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/home/IWikiRelationDecoration;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "notifyFirstContentDraw", "decoration", "instanceViewConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView$ViewConfig;", NotificationCompat.CATEGORY_NAVIGATION, "param", "Lcom/bytedance/ee/bear/wikiv2/sidebar/home/SidebarHomeTreeView$NavigationParams;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "SidebarTreeCtrlViewDelegate", "NavigationParams", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeTreeView extends FrameLayout implements ViewModelStoreOwner, vd5.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f241226g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce5.a f241227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SidebarTreeCtrlView f241228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewModelStore f241229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vd5.c f241230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SidebarTreeCtrlView f241231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f241232f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TreeNode f241233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnalyticConstant$OpenType f241234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f241235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f241236d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f241233a, r101.f241233a) == true) goto L12;
            return false;
        L12:
            if (this.f241234b == r101.f241234b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f241235c, r101.f241235c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f241236d, r101.f241236d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f241233a.hashCode() * 31;
            AnalyticConstant$OpenType r101 = this.f241234b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f241235c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f241236d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "NavigationParams(treeNode=" + this.f241233a + ", openType=" + this.f241234b + ", uniqueUiId=" + this.f241235c + ", from=" + this.f241236d + ')';
        }

        public b(TreeNode r100, AnalyticConstant$OpenType r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "treeNode");
            this.f241233a = r100;
            this.f241234b = r101;
            this.f241235c = r102;
            this.f241236d = r103;
        }
    }

    public final class c extends WikiTreeCtrlView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidebarHomeTreeView f241237a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f241238a = null;

            static {
                f241238a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Boolean r101 = (Boolean) r100;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f241239a = null;

            static {
                f241239a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.d("SidebarHomeTreeView", "onRefreshDocumentFromNet fail: " + ((Throwable) r100));
            }
        }

        public c(SidebarHomeTreeView r100) {
            this.f241237a = r100;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void m(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "reloadType");
            Intrinsics.checkNotNullParameter(r100, "reloadType");
            tt5.a.h("SidebarHomeTreeView", "reload data");
            SidebarHomeTreeView r101 = this.f241237a;
            vd5.c r102 = r101.f241230d;
            if (r102 == null) goto L8;
            SidebarDocTabVM r103 = r102.f554196c;
            if (r103 == null) goto L9;
            r101.getClass();
            r103.addDisposable(((SidebarTreeCtrlVM) new ViewModelProvider(r102.f554194a).get(SidebarTreeCtrlVM.class)).onRefreshFromNetWithType(r102.f554195b, r100).observeOn(fo5.d.d()).map(new j(r101, r102)).subscribe(a.f241238a, b.f241239a));
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void r(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileExtra");
            tt5.a.h("SidebarHomeTreeView", "onUploadFinish");
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "newToken");
            Intrinsics.checkNotNullParameter(r101, "uniqueUiId");
            SidebarTreeCtrlView r102 = this.f241237a.f241231e;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "uniqueUiId");
            r102.getWikiTreeViewFromXml().j(r101);
            TreeNode r103 = this.f241237a.f241231e.g(r100);
            if (r103 != null) goto L6;
            tt5.a.k("SidebarHomeTreeView", "onInsert fail: treeNode is null");
            return;
        L6:
            SidebarHomeTreeView.a(this.f241237a, new b(r103, AnalyticConstant$OpenType.WIKI_CREATE_NEW, r101, "tab_create"));
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void f(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r101, "uniqueUiId");
            TreeNode r102 = this.f241237a.f241231e.g(r100);
            if (r102 != null) goto L7;
            tt5.a.k("SidebarHomeTreeView", "onItemClick fail: treeNode is null");
            return;
        L7:
            if (r102.wiki_node_type != VirtualNode.TITLE_TOTAL_SHARE.getWikiNodeType()) goto L10;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/list/space/activity").j("extra_destination", NavigationEnum.SHARED_SPACE.f228307id).e();
            return;
        L10:
            SidebarHomeTreeView.a(this.f241237a, new b(r102, AnalyticConstant$OpenType.WIKI_ALL, r101, null));
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void g(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "toToken");
            Intrinsics.checkNotNullParameter(r102, "toSpaceName");
            o.a(r100, r102, r101, null, Boolean.FALSE);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void o(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toSpaceId");
            Intrinsics.checkNotNullParameter(r101, "toToken");
            Intrinsics.checkNotNullParameter(r102, "toSpaceName");
            o.a(r100, r102, r101, null, Boolean.FALSE);
        }
    }

    public static final class d implements xd5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidebarHomeTreeView f241240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vd5.c f241241b;

        @Override // xd5.a
        public final Flowable<?> generate() {
            SidebarHomeTreeView r100 = this.f241240a;
            vd5.c r101 = this.f241241b;
            int r102 = SidebarHomeTreeView.f241226g;
            r100.getClass();
            return ((SidebarTreeCtrlVM) new ViewModelProvider(r101.f554194a).get(SidebarTreeCtrlVM.class)).onRefreshFromNet(r101.f554195b).observeOn(fo5.d.d()).map(new l(r100, r101));
        }

        public d(SidebarHomeTreeView r100, vd5.c r101) {
            this.f241240a = r100;
            this.f241241b = r101;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f241242a = null;

        static {
            f241242a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f241243a = null;

        static {
            f241243a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("SidebarHomeTreeView", "onRefreshFromDatabaseAndNet fail: " + ((Throwable) r100));
        }
    }

    static {
    }

    @Override // vd5.a
    public final /* synthetic */ void f() {
    }

    public final SidebarTreeCtrlView getSidebarRootTreeViewFromXml() {
        KeyEvent.Callback r100 = this.f241228b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sidebar_root_tree_view);
        this.f241228b = (SidebarTreeCtrlView) r100;
    L6:
        return (SidebarTreeCtrlView) r100;
    }

    @Override // vd5.a
    public final void onDestroyView() {
        vd5.c r100 = this.f241230d;
        if (r100 == null) goto L7;
        SidebarDocTabVM r101 = r100.f554196c;
        if (r101 == null) goto L7;
        r101.removeRefreshFlowable("SidebarHomeTreeView");
    L7:
        this.f241229c.clear();
        this.f241230d = null;
    }

    public final ce5.a getUserComponentAbility() {
        return this.f241227a;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.f241229c;
    }

    @Override // vd5.a
    public final void h(vd5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        SidebarDocTabVM r101 = r100.f554196c;
        if (r101 == null) goto L5;
        r101.addRefreshFlowable("SidebarHomeTreeView", new d(this, r100));
    L5:
        SidebarDocTabVM r102 = r100.f554196c;
        if (r102 == null) goto L8;
        r102.addDisposable(((SidebarTreeCtrlVM) new ViewModelProvider(r100.f554194a).get(SidebarTreeCtrlVM.class)).onRefreshFromDatabaseAndNetwork(r100.f554195b).observeOn(fo5.d.d()).map(new k(this, r100)).subscribe(e.f241242a, f.f241243a));
    L8:
        this.f241230d = r100;
    }

    @Override // vd5.a
    public final void o(vd5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        SidebarTreeCtrlView r101 = this.f241231e;
        if (r101.f242306f == null) goto L6;
        r101.getViewModel().refresh();
        return;
    }

    public final void setSidebarRootTreeViewFromXml(SidebarTreeCtrlView r100) {
        this.f241228b = r100;
    }

    public SidebarHomeTreeView(Context r100, ce5.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        super(r100, null, 0, 0);
        this.f241227a = r101;
        this.f241229c = new ViewModelStore();
        LayoutInflater.from(r100).inflate(R.layout.sidebar_home_tree_layout, this);
        this.f241231e = getSidebarRootTreeViewFromXml();
    }

    public static final void a(SidebarHomeTreeView r110, b r210) {
        r110.getClass();
        TreeNode r100 = r210.f241233a;
        Fragment r101 = null;
        if (r100.isSpaceDocument == true) goto L15;
        Bundle r102 = new Bundle();
        AnalyticConstant$OpenType r103 = r210.f241234b;
        if (r103 == null) goto L7;
        String r104 = r103.getType();
    L8:
        r102.putString("ccm_open_type", r104);
        r102.putSerializable("wiki_info", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r210.f241233a));
        r102.putString("unique_ui_id", r210.f241235c);
        String r105 = r210.f241236d;
        if (r105 == null) goto L11;
        r102.putString("extra_from", r105);
    L11:
        TreeNode r106 = r210.f241233a;
        String r107 = r106.space_id;
        String r108 = r106.wiki_token;
        vd5.c r109 = r110.f241230d;
        if (r109 == null) goto L14;
        r101 = r109.f554194a;
    L14:
        o.b(r107, "", r108, r102, Boolean.FALSE, r101, null);
        return;
    L7:
        r104 = null;
        goto L8
    L15:
        vd5.c r111 = r110.f241230d;
        if (r111 == null) goto L37;
        Fragment r112 = r111.f554194a;
        if (r112 == null) goto L38;
        FragmentActivity r113 = r112.getActivity();
        if (r113 == null) goto L39;
        Document r114 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.b(r100);
        r114.f227906x2 = true;
        r114.f227903w = true;
        boolean r115 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        Context r116 = r110.getContext();
        ArrayList r117 = new ArrayList();
        Context r118 = new e0(r116, r114, "home", r117, "quick_access", "").getContext();
        if (r114.getType() != sbb.e.f541295f.f541317b) goto L25;
        sd5.e r119 = new sd5.c(r118, "home", 1, "");
    L31:
        RouteBean r120 = r119.a(r114);
        vd5.c r121 = r110.f241230d;
        if (r121 == null) goto L34;
        r101 = r121.f554194a;
    L34:
        r120.a(r101);
        t0.r(new v0(r113, r114, r115, r120, "home", "quick_access", AnalyticConstant$OpenType.HOME_CREATE_PIN.getType(), -1, false, 0), r110.f241227a);
        return;
    L25:
        if (r114.getType() != sbb.e.f541301l.f541317b) goto L28;
        r119 = new sd5.b(new e0(r118, r114, "home", r117, "quick_access", ""), "");
        goto L31
    L28:
        if (r114.getType() != sbb.e.f541303n.f541317b) goto L30;
        r119 = new g();
        goto L31
    L30:
        r119 = new sd5.a(r118);
        goto L31
    L39:
        return;
    L38:
        return;
    }

    public static final void b(SidebarHomeTreeView r110, vd5.c r111, Pair r112) {
        r110.getClass();
        kq5.c r100 = (kq5.c) r112.getFirst();
        e3 r113 = (e3) r112.getSecond();
        String r114 = "";
        boolean r115 = false;
        if (r110.f241232f == true) goto L24;
        vd5.c r101 = r110.f241230d;
        if (r101 == null) goto L11;
        Fragment r102 = r101.f554194a;
        if (r102 == null) goto L11;
        if (r102.getUserVisibleHint() != true) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L24;
        ResultCode r104 = r100.b();
        if (r104.isDEC0() == false) goto L16;
    L22:
        x.c().e(0, "", "content", "key_open_finish_content");
    L23:
        r110.f241232f = true;
        goto L24
    L16:
        if (r104.isDEC1() == true) goto L22;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L21;
        x.c().e(1, "SEC4", "content", "key_open_finish_content");
        goto L23
    L21:
        x.c().e(1, "SEC5", "content", "key_open_finish_content");
    L11:
        r103 = false;
    L24:
        SidebarTreeCtrlView r116 = r110.f241231e;
        Fragment r105 = r111.f554194a;
        WikiTreeCtrlView.c r106 = new WikiTreeCtrlView.c();
        r106.f242320c = true;
        r106.f242321d = true;
        r106.f242322e = true;
        r106.f242323f = true;
        r106.f242325h = true;
        vd5.c r107 = r110.f241230d;
        Integer r117 = null;
        if (r107 == null) goto L27;
        List<? extends Function<TreeNode, Boolean>> r108 = CollectionsKt.listOf(new n(r107.f554194a, new WeakReference(r110.f241231e), r110.f241227a));
    L28:
        r106.f242328k = r108;
        vd5.c r109 = r110.f241230d;
        if (r109 == null) goto L31;
        List<? extends Function<TreeNode, Boolean>> r118 = CollectionsKt.listOf(new p(r109.f554194a.getViewLifecycleOwner(), new WeakReference(r110.f241231e)));
    L32:
        r106.f242329l = r118;
        r106.f242327j = CollectionsKt.listOf(new Function[]{kq5.f.f505593a, kq5.g.f505594a, new kq5.h(r110)});
        r106.f242326i = i.f505596a;
        r106.f242332o = CollectionsKt.listOf(new WikiBottomDecoration(R.dimen.space_kit_len_60));
        Intrinsics.checkNotNullParameter("SidebarHomeTreeView", "<set-?>");
        r106.f242333p = "SidebarHomeTreeView";
        r106.f242334q = "sidebar";
        r106.f242335r = 1;
        r106.f242331n = true;
        f1 r119 = new f1(r105, r113, null, r106, r110, null, r111.f554195b);
        r119.f242480h = false;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r119, "initConfig");
        if (r116.f242312l.get() == true) goto L35;
        r116.i(r119);
        r116.f242312l.set(true);
    L48:
        r110.f241231e.setViewDelegate(new c(r110));
        r100.a(r110.f241231e, r113);
        return;
    L35:
        e3 r120 = r119.f242475c;
        if (r120 == null) goto L48;
        WikiTreeView r121 = r116.getWikiTreeViewFromXml();
        int r122 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.f241908a;
        String r123 = r120.o();
        if (r123 == null) goto L41;
        r114 = r123;
    L41:
        r121.setSpaceId(r114);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r124 = r116.getViewModel();
        String r125 = r119.f242476d;
        r124.load(r120, r125, r119.f242479g, !r116.m(r125), r119.f242480h);
        WikiTreeView r126 = r116.getWikiTreeViewFromXml();
        SpaceInfo r127 = r116.getViewModel().getSpaceInfo();
        if (r127 == null) goto L44;
        r115 = r127.isMyLib();
    L44:
        r126.setMyLib(r115);
        WikiTreeView r128 = r116.getWikiTreeViewFromXml();
        SpaceInfo r129 = r116.getViewModel().getSpaceInfo();
        if (r129 == null) goto L47;
        r117 = Integer.valueOf(r129.space_type);
    L47:
        r128.setSpaceType(r117);
        goto L48
    L31:
        r118 = null;
        goto L32
    L27:
        r108 = null;
        goto L28
    }

    @Override // vd5.a
    public final void g(vd5.c r100, int r101, int r102, Intent r103) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f241231e.o(r101, r102, r103);
    }
}
