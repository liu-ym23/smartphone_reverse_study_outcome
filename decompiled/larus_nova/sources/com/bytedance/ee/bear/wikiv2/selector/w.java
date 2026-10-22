package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import iq5.d0;
import iq5.e0;
import iq5.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w extends com.larksuite.framework.mvp.a<n.a> implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f241216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectorConfig f241217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ce5.a f241218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n.a f241219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RootSelectAdapter f241220f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f241221a;

        public b(w r100) {
            this.f241221a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            n.a r101 = this.f241221a.f241219e;
            if (r101 == null) goto L6;
            r101.onCancelClick();
            return;
        }
    }

    public static final class c extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w f241222c;

        public c(w r100) {
            this.f241222c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            tt5.a.h("RootSelectView", "on search click.");
            n.a r101 = this.f241222c.f241219e;
            if (r101 == null) goto L6;
            r101.p();
            return;
        }
    }

    public static final class d implements iq5.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f241223a;

        @Override // iq5.r
        public final void a() {
            n.a r100 = this.f241223a.f241219e;
            if (r100 == null) goto L6;
            r100.r3();
            return;
        }

        public d(w r100) {
            this.f241223a = r100;
        }

        @Override // iq5.r
        public final void b(int r100) {
            tt5.a.h("RootSelectView", "onClickWiki()...position = " + r100);
            n.a r101 = this.f241223a.f241219e;
            if (r101 == null) goto L6;
            r101.M5();
            return;
        }

        @Override // iq5.r
        public final void c(int r100) {
            tt5.a.h("RootSelectView", "onClickMyFolder()...position = " + r100);
            n.a r101 = this.f241223a.f241219e;
            if (r101 == null) goto L6;
            r101.k6();
            return;
        }

        @Override // iq5.r
        public final void d(int r100) {
            tt5.a.h("RootSelectView", "onClickMyShareFolder()...position = " + r100);
            n.a r101 = this.f241223a.f241219e;
            if (r101 == null) goto L6;
            r101.h2();
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.a, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f285682a = null;
        tt5.a.h("RootSelectView", "destroy()...");
        this.f241219e = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("RootSelectView", "create()...");
        BaseTitleBar r100 = (BaseTitleBar) this.f241216b.findViewById(R.id.wiki_root_select_title);
        boolean r101 = false;
        r100.setLeftIconVisibility(false);
        r100.setLeftText(this.f241216b.getContext().getString(R.string.Doc_Facade_Cancel));
        r100.setLeftTextColor(this.f241216b.getContext().getResources().getColorStateList(R.color.facade_selector_icon_n1));
        r100.setTitle(this.f241217c.f229370b);
        r100.setLeftClickListener(new b(this));
        LinearLayout r102 = (LinearLayout) this.f241216b.findViewById(R.id.wiki_root_select_search);
        Set<SelectorType> r103 = x.f495382a;
        boolean r104 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r105 = this.f241217c.f229369a;
        Intrinsics.checkNotNullParameter(r105, "selectorType");
        Intrinsics.checkNotNullParameter(r105, "selectorType");
        if (r104 == true) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L10;
        r102.setVisibility(8);
    L11:
        RecyclerView r107 = (RecyclerView) this.f241216b.findViewById(R.id.wiki_root_select_list);
        r107.setLayoutManager(new LinearLayoutManager(this.f241216b.getContext()));
        RootSelectAdapter r108 = new RootSelectAdapter(this.f241216b.getContext(), new ArrayList());
        this.f241220f = r108;
        r108.f241113b = new d(this);
        r107.setAdapter(r108);
        k();
        RootSelectAdapter r109 = this.f241220f;
        RootSelectAdapter r110 = null;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r109 = null;
    L14:
        Iterator<T> r111 = r109.getData().iterator();
    L16:
        if (r111.hasNext() == false) goto L20;
        Object r112 = r111.next();
        if ((((iq5.p) r112) instanceof o) == false) goto L16;
    L22:
        if (((iq5.p) r112) != null) goto L43;
        int r113 = o.f241190b;
        if (o.a.b(this.f241217c.f229374f) == true) goto L26;
    L41:
        Unit r114 = Unit.INSTANCE;
        goto L43
    L26:
        if (o.a.a() == false) goto L41;
        Set<SelectorType> r115 = x.f495382a;
        boolean r116 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r117 = this.f241217c.f229369a;
        Intrinsics.checkNotNullParameter(r117, "selectorType");
        if (r116 == true) goto L30;
    L32:
        boolean r118 = false;
    L33:
        if (r118 == true) goto L41;
        String r119 = dq5.j.a(this.f241218d);
        if (r119 != null) goto L37;
    L38:
        r101 = true;
    L39:
        if (r101 == false) goto L41;
        int r120 = dq5.j.f469673a;
        up5.g.a(dq5.j.b(this.f241218d).subscribe(new iq5.v(this), iq5.w.f495381a), new CompositeDisposable());
        goto L41
    L37:
        if (r119.length() != 0) goto L39;
    L30:
        if (x.f495382a.contains(r117) == false) goto L32;
        r118 = true;
    L43:
        if (this.f241217c.f229371c == false) goto L53;
        com.bytedance.ee.bear.wikiv2.a r121 = new com.bytedance.ee.bear.wikiv2.a(this.f241216b.getContext());
        r121.setViewDelegate(this.f241219e);
        RootSelectAdapter r122 = this.f241220f;
        if (r122 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L48:
        r110.addHeaderView(r121);
        return;
    L47:
        r110 = r122;
        goto L48
    L53:
        return;
    L20:
        r112 = null;
        goto L22
    L10:
        r102.setOnClickListener(new c(this));
        goto L11
    L5:
        if (x.f495382a.contains(r105) == false) goto L7;
        r106 = true;
        goto L8
    }

    public final void k() {
        ArrayList r100 = new ArrayList();
        SelectorScope r101 = this.f241217c.f229374f;
        CollectionsKt.listOf(new SelectorType[]{SelectorType.WIKI_MOVE_TO, SelectorType.WIKI_SHORTCUT_TO, SelectorType.WIKI_MAKE_COPY_TO, SelectorType.WIKI_CREATE_TO}).contains(this.f241217c.f229369a);
        if (qc5.a.h() == true) goto L5;
        h(r100, new iq5.p[]{new o(r101), new iq5.q(r101), new d0(r101), new e0(r101)});
    L6:
        RootSelectAdapter r102 = this.f241220f;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r102 = null;
    L9:
        r102.setNewData(r100);
        return;
    L5:
        h(r100, new iq5.p[]{new o(r101), new e0(r101), new iq5.a(new iq5.q(r101), new d0(r101)), new iq5.q(r101), new d0(r101)});
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n
    public final void I(List<? extends Document> r100) {
        if (hu5.a.f(r100) == false) goto L12;
        p r101 = new p(this.f241216b.getContext());
        r101.setViewDelegate(this.f241219e);
        FolderSelectAdapter r102 = r101.f241192a;
        if (r100 != null) goto L7;
        r102.getClass();
        r100 = new ArrayList();
    L7:
        r102.f241077c = r100;
        r101.f241192a.notifyDataSetChanged();
        RootSelectAdapter r103 = this.f241220f;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r103 = null;
    L10:
        r103.addFooterView(r101);
        return;
    }

    @Override // com.larksuite.framework.mvp.a, com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f241219e = (n.a) r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n
    public final void u1(List<? extends RecentOperationResult.a> r100) {
        if (hu5.a.f(r100) == false) goto L9;
        q r101 = new q(this.f241216b.getContext());
        r101.setViewDelegate(this.f241219e);
        RecentOperationAdapter r102 = r101.f241195a;
        r102.f241105b = r100;
        r102.notifyDataSetChanged();
        r101.setUserComponentAbility(this.f241218d);
        RootSelectAdapter r103 = this.f241220f;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r103 = null;
    L7:
        r103.addFooterView(r101);
        return;
    }

    public final void h(List<iq5.p> r100, iq5.p... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L25;
        iq5.p r104 = r101[r103];
        if (r104.a(this.f241218d) == false) goto L24;
        Set<SelectorType> r105 = x.f495382a;
        boolean r106 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r107 = this.f241217c.f229369a;
        Intrinsics.checkNotNullParameter(r107, "selectorType");
        boolean r108 = true;
        if (r106 == true) goto L9;
    L11:
        boolean r109 = false;
    L12:
        if (r109 == true) goto L15;
    L21:
        r108 = false;
    L22:
        if (r108 == true) goto L24;
        ((ArrayList) r100).add(r104);
        goto L24
    L15:
        if ((r104 instanceof o) == true) goto L22;
        if ((r104 instanceof e0) == true) goto L22;
        if ((r104 instanceof d0) == false) goto L21;
    L9:
        if (x.f495382a.contains(r107) == false) goto L11;
        r109 = true;
    L24:
        r103 = r103 + 1;
        goto L3
    }

    public w(View r100, SelectorConfig r101, ce5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "selectorConfig");
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        this.f241216b = r100;
        this.f241217c = r101;
        this.f241218d = r102;
    }
}
