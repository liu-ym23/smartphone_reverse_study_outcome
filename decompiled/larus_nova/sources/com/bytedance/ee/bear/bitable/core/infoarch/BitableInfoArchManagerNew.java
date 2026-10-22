package com.bytedance.ee.bear.bitable.core.infoarch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.BitableBackgroundContainer;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ViewHolder;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.k;
import com.bytedance.ee.bear.bitable.infoarch.BitableInfoArchPlugin;
import com.bytedance.ee.bear.bitable.infoarch.block.BlockCatalogModel;
import com.bytedance.ee.bear.bitable.infoarch.header.BitableHeaderContainer;
import com.bytedance.ee.bear.bitable.infoarch.header.HeaderContainerModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer$enableBottomSpace$1$1;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.ToolbarContainerModel;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.view.ViewContainerModel;
import com.bytedance.ee.bear.bitable.preload.NativeCacheController$updateScene$1;
import com.bytedance.ee.bear.bitable.preload.l;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableInfoArchManagerNew extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f210177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f210178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f210179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DocViewModel f210180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewHolder f210181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f210182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vr4.b f210183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.arch.f f210184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f210185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public wr4.c f210186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.arch.e f210187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i f210188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.arch.a f210189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.arch.i f210190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.infoarch.swipe.a f210191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f210192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ct4.f f210193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f210194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f210195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f210196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f210197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h f210198x;

    public static final class a implements ocb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableInfoArchManagerNew f210199a;

        public a(BitableInfoArchManagerNew r100) {
            this.f210199a = r100;
        }

        @Override // ocb.a
        public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
            BitableNativeViewContainer r103 = this.f210199a.f210181g.f210230q;
            CardViewContainer r104 = r103.getCardViewFromXml();
            if (r101 <= 0) goto L5;
            r104.getClass();
            int r105 = n.d(80) + r101;
        L6:
            r104.getMainRecyclerViewFromXml().setPadding(0, 0, 0, r105);
            GalleryViewContainer r106 = r103.getGalleryViewFromXml();
            if (r101 <= 0) goto L9;
            r106.getClass();
            int r107 = r101 + n.d(80);
        L10:
            r106.getMainRecyclerViewFromXml().setPadding(0, 0, 0, r107);
            return;
        L9:
            r107 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableInfoArchManagerNew f210200a;

        public b(BitableInfoArchManagerNew r100) {
            this.f210200a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if ((r107 - r105) == r100.getWidth()) goto L8;
            BitableInfoArchManagerNew r109 = this.f210200a;
            if (r109.f210185k.f210554b == false) goto L9;
            r109.f210183i.y();
            return;
        L9:
            return;
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final SceneModel a() {
        return this.f210184j.f210256b.f210263f;
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final String b() {
        return this.f210180f.getToken();
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void p() {
        tt5.a.h("BitableInfoArchManager", "updateDrawerState openDrawer:false");
        vr4.b r100 = this.f210183i;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public final void q() {
        tt5.a.h("BitableInfoArchManager", "toggleDrawer");
        this.f210183i.m1();
    }

    public final FragmentActivity getActivity() {
        return this.f210179e;
    }

    public final Context getContext() {
        return this.f210177c;
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void c(String r100) {
        this.f210181g.f210230q.setDocumentTraceId(r100);
        this.f210181g.f210230q.setObjToken(this.f210180f.getToken());
        ViewHolder r101 = this.f210181g;
        r101.f210230q.c(r101, new BitableInfoArchManagerNew$initDocumentTraceId$1(this));
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void d(SceneModel r110) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        tt5.a.h("BitableInfoArchManager", "onSceneChanged scene:" + r110);
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L8;
        Iterator r100 = ((ArrayList) this.f210552b).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((com.bytedance.ee.bear.bitable.core.infoarch.arch.h) r100.next()).b(r110, this.f210184j.f210256b);
    L8:
        h r101 = this.f210198x;
        if (r101 == null) goto L11;
        r101.b(r110);
    L11:
        l r102 = this.f210192r;
        SceneModel r103 = r102.f215012a;
        if (r103 == null) goto L14;
        String r104 = r103.getBlockId();
    L15:
        if (r110 == null) goto L17;
        String r105 = r110.getBlockId();
    L19:
        if (y0.a(r104, r105) == false) goto L29;
        SceneModel r106 = r102.f215012a;
        if (r106 == null) goto L23;
        String r107 = r106.getViewId();
    L24:
        if (r110 == null) goto L26;
        String r108 = r110.getViewId();
    L28:
        if (TextUtils.equals(r107, r108) == false) goto L29;
    L49:
        r102.f215012a = r110;
        com.bytedance.ee.bear.bitable.core.infoarch.arch.f r111 = this.f210184j;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "scene");
        r111.f210256b.f210263f = r110;
        r111.f210255a.f210181g.f210230q.d(r110);
        int r109 = com.bytedance.ee.bear.bitable.core.infoarch.arch.i.f210264c;
        int r112 = 0;
        if (com.bytedance.ee.bear.bitable.core.infoarch.arch.i.a.a() == false) goto L77;
        ThemeModel r113 = r110.getDashboardTheme();
        if (r113 == null) goto L55;
        boolean r114 = true;
    L56:
        com.bytedance.ee.bear.bitable.core.infoarch.arch.a r115 = r111.f210255a.f210189o;
        com.bytedance.ee.bear.bitable.core.infoarch.arch.a.C3026a r116 = r115.f210235b;
        if (r116.f210241c == r114) goto L60;
        r116.f210241c = r114;
        r115.b();
    L60:
        com.bytedance.ee.bear.bitable.core.infoarch.arch.e r117 = r111.f210255a.f210187m;
        if (r117.f210254e == r114) goto L73;
        r117.f210254e = r114;
        if (r114 == false) goto L72;
        FragmentActivity r118 = r117.f210250a.getActivity();
        if (r118 == null) goto L68;
        bp5.c.d(r118, null, 0);
    L68:
        TitleBar r119 = r117.f210250a.f210181g.f210229p.f526674b;
        if (r119 == null) goto L71;
        r119.setBackground(0);
    L71:
        r117.f210253d = -1.0f;
        goto L73
    L72:
        r117.b();
    L73:
        if (r113 == null) goto L75;
        r111.f210255a.f210190p.c(r113, false);
        goto L77
    L75:
        r111.f210255a.f210190p.b(false);
        goto L77
    L55:
        r114 = false;
    L77:
        if (r110.isInvalid() == false) goto L80;
    L132:
        nt4.a.c(this.f210181g.f210228o, null, Boolean.TRUE, 1);
        return;
    L80:
        if (r110.isLinkedDocx() == false) goto L85;
        r111.f210255a.f210189o.a(true, true);
        if (Intrinsics.areEqual(r110.isSoloBaseSuite(), Boolean.TRUE) == false) goto L132;
        i.c(r111.f210255a.f210188n, null, false, false, true, false, false, false, true, 112);
        goto L132
    L85:
        if (r110.isForm() == false) goto L90;
        if (Intrinsics.areEqual(r111.f210256b.f210259b, Boolean.TRUE) == true) goto L132;
    L90:
        if (r110.isDashBoard() == false) goto L122;
        if (r110.getDashboardFullScreen() == false) goto L94;
    L96:
        boolean r120 = false;
    L97:
        r111.f210255a.f210189o.a(true, r120);
        boolean r121 = r110.getDashboardFullScreen();
        tt5.a.h("SceneController", "onToggleDashboardFullScreen: isDashboardFullScreen:" + r121);
        if (Intrinsics.areEqual(r111.f210256b.f210260c, Boolean.valueOf(r121)) == true) goto L120;
        r111.f210256b.f210260c = Boolean.valueOf(r121);
        r111.f210255a.f210187m.b();
        k r122 = r111.f210255a.f210182h;
        r122.f210271b = !r121;
        r122.f210273d = r121;
        if (r121 == false) goto L103;
        r122.a(Boolean.FALSE, Boolean.TRUE);
    L104:
        ViewGroup r123 = r111.f210255a.f210181g.f210216c;
        if (r121 == false) goto L107;
        int r124 = 8;
    L108:
        r123.setVisibility(r124);
        BitableHeaderContainer r125 = r111.f210255a.f210181g.f210220g;
        if (r121 == false) goto L111;
        int r126 = 8;
    L112:
        r125.setVisibility(r126);
        if (r111.f210257c == false) goto L120;
        if (com.bytedance.ee.bear.bitable.core.infoarch.arch.i.a.a() == true) goto L120;
        BitableBackgroundContainer r127 = r111.f210255a.f210181g.f210217d;
        if (r121 == false) goto L119;
        r112 = 8;
    L119:
        r127.setVisibility(r112);
        goto L120
    L111:
        r126 = 0;
        goto L112
    L107:
        r124 = 0;
        goto L108
    L103:
        k.b(r122, Boolean.FALSE, null, 2);
    L120:
        i.c(r111.f210255a.f210188n, r110, !r110.getDashboardFullScreen(), false, true, false, false, false, false, 240);
        goto L132
    L94:
        if (com.bytedance.ee.bear.bitable.core.infoarch.arch.i.a.a() == true) goto L96;
        r120 = true;
        goto L97
    L122:
        if (r110.isWorkFlow() == false) goto L125;
        r111.f210255a.f210189o.a(true, true);
        i.c(r111.f210255a.f210188n, r110, false, false, true, false, false, false, false, 240);
        goto L132
    L125:
        if (r110.isBitable() == false) goto L132;
        r111.f210255a.f210189o.a(false, true);
        i.c(r111.f210255a.f210188n, r110, r110.isViewEnableNestedScroll(), true ^ r110.isViewEnableNestedScroll(), true, false, r110.isKanban(), false, false, 208);
        boolean r128 = r110.getShowAIConfigForm();
        if (r128 == r111.f210256b.f210261d) goto L132;
        r111.f210255a.f210181g.f210219f.setExpanded(!r128, false);
        if (Intrinsics.areEqual(r111.f210256b.f210258a, Boolean.valueOf(r128)) == true) goto L131;
        r111.f210256b.f210258a = Boolean.valueOf(r128);
        ViewHolder r129 = r111.f210255a.f210181g;
        Intrinsics.checkNotNullParameter(r129, "viewHolder");
        r129.f210219f.setTempDisableScroll(r128);
    L131:
        r111.f210256b.f210261d = r128;
        goto L132
    L26:
        r108 = null;
        goto L28
    L23:
        r107 = null;
    L29:
        Function0<String> r130 = r102.f215014c;
        String r131 = "";
        if (r130 == null) goto L33;
        String r132 = r130.invoke();
        if (r132 == null) goto L33;
    L34:
        Function0<String> r133 = r102.f215013b;
        if (r133 == null) goto L38;
        String r134 = r133.invoke();
        if (r134 == null) goto L38;
    L39:
        if (r110 == null) goto L42;
        String r135 = r110.getBlockId();
        if (r135 == null) goto L42;
    L43:
        if (r110 == null) goto L48;
        String r136 = r110.getViewId();
        if (r136 == null) goto L48;
        r131 = r136;
    L48:
        com.bytedance.ee.bear.bitable.rust.g.c(r132, r134, r135, r131, new NativeCacheController$updateScene$1());
    L42:
        r135 = "";
    L38:
        r134 = "";
    L33:
        r132 = "";
        goto L34
    L17:
        r105 = null;
        goto L19
    L14:
        r104 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void o(BitableInfoArchPlugin.s r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f210198x = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void e(BlockCatalogModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "actionHandler");
        this.f210181g.f210227n.d(r100, r101);
        nt4.a.c(this.f210181g.f210228o, Boolean.TRUE, null, 2);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void f(HeaderContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "actionHandler");
        this.f210181g.f210220g.d(r100, r101);
        this.f210181g.f210227n.getHeader().d(r100, r101);
        ot4.c r102 = this.f210181g.f210229p;
        TextView r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.getSubTitle();
    L6:
        r102.f526673a = r104;
        View r105 = r102.b();
        if (r105 == null) goto L9;
        r103 = (TextView) r105.findViewById(R.id.widgetTitleMenuText);
    L9:
        if (r103 == null) goto L12;
        r103.setText(r102.f526673a);
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void g(CardViewData r100, BitableInfoArchPlugin.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f210181g.f210230q.g(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void i(GalleryViewData r100, BitableInfoArchPlugin.e.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f210181g.f210230q.h(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void j(GridViewData r100, BitableInfoArchPlugin.f.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f210181g.f210230q.i(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void k(ToolbarContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f210181g.f210223j.c(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void l(ViewContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "actionHandler");
        this.f210181g.f210222i.c(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void m(EmptyData r100, gv4.d r101) {
        ((EmptyView) this.f210181g.f210233t.getValue()).a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void h(BitableNativeViewData r100, gv4.a r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
        BitableNativeViewContainer.k(this.f210181g.f210230q, this.f210179e, r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.f
    public final void n(zs4.d r100, m r101, Map<String, ? extends tb5.i<String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f210181g.f210230q.f(this.f210179e, r100, r101, r102);
    }

    public BitableInfoArchManagerNew(Context r100, ViewGroup r101, FragmentActivity r102, DocViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r103, "docViewModel");
        this.f210177c = r100;
        this.f210178d = r101;
        this.f210179e = r102;
        this.f210180f = r103;
        this.f210183i = new vr4.b(this, new vr4.a(this));
        this.f210185k = new g();
        this.f210196v = com.bytedance.ee.bear.bitable.c.i();
        this.f210197w = DeviceUtils.isPad();
        ViewHolder r104 = new ViewHolder(r101);
        this.f210181g = r104;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.mobile.super.agent.enable") == true) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L15;
        BitableNativeViewContainer r106 = r104.f210230q;
        CardViewContainer r107 = r106.getCardViewFromXml();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        GalleryViewContainer r108 = r106.getGalleryViewFromXml();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        GridViewContainer r109 = r106.getGridViewFromXml();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        Iterator r110 = CollectionsKt.listOf(new BaseListViewContainer[]{r107, r108, r109}).iterator();
    L11:
        if (r110.hasNext() == false) goto L15;
        RecyclerView r111 = ((BaseListViewContainer) r110.next()).getRecyclerView();
        if (r111 == null) goto L11;
        r111.addItemDecoration(new BaseListViewContainer$enableBottomSpace$1$1());
    L15:
        this.f210182h = new k(this.f210181g);
        this.f210184j = new com.bytedance.ee.bear.bitable.core.infoarch.arch.f(this);
        com.bytedance.ee.bear.bitable.core.infoarch.arch.i r112 = new com.bytedance.ee.bear.bitable.core.infoarch.arch.i(this);
        this.f210190p = r112;
        i r113 = new i(this);
        this.f210188n = r113;
        com.bytedance.ee.bear.bitable.core.infoarch.arch.e r114 = new com.bytedance.ee.bear.bitable.core.infoarch.arch.e(this);
        this.f210187m = r114;
        this.f210189o = new com.bytedance.ee.bear.bitable.core.infoarch.arch.a(this);
        this.f210192r = new l(this);
        a r115 = new a(this);
        this.f210194t = r115;
        if (this.f210196v == true) goto L18;
    L20:
        this.f210181g.f210220g.setOnClickListener(new com.bytedance.ee.bear.bitable.core.infoarch.a(this));
        this.f210181g.f210227n.setToggleListener(new com.bytedance.ee.bear.bitable.core.infoarch.b(this));
        this.f210181g.f210227n.setOnFlingListener(new com.bytedance.ee.bear.bitable.core.infoarch.c(this));
        if (this.f210196v == true) goto L23;
    L25:
        ViewHolder r116 = this.f210181g;
        nt4.a r117 = r116.f210228o;
        BitableViewContainer r118 = r116.f210222i;
        Context r119 = this.f210177c;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "rootView");
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "infoArchManager");
        r117.f520490c = r118;
        r117.f520491d = r119;
        r117.f520492e = this;
        this.f210183i.a(r117);
        this.f210183i.a(r114);
        this.f210183i.a(r112);
        this.f210181g.f210227n.setGetFocusView(new BitableInfoArchManagerNew$initBizListener$5(this));
        this.f210181g.f210226m.setScrollApi(r113);
        pcb.a.AbstractC7181a.b(this.f210179e).c(r115);
        int r120 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.native_view_group_cache") == false) goto L34;
        this.f210193s = new ct4.f(this);
        this.f210181g.f210230q.getViewDataProvider().b(this.f210193s);
        this.f210181g.f210220g.setBizCacheController(this.f210193s);
        this.f210181g.f210227n.getHeader().setBizCacheController(this.f210193s);
        return;
    L34:
        return;
    L23:
        if (this.f210197w == false) goto L25;
        this.f210178d.addOnLayoutChangeListener(this.f210195u);
        goto L25
    L18:
        if (this.f210197w == false) goto L20;
        this.f210195u = new b(this);
        goto L20
    L5:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.mobile.super.agent.polish.enable") == false) goto L7;
        r105 = true;
        goto L8
    }
}
