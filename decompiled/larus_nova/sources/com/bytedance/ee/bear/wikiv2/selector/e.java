package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends com.larksuite.framework.mvp.a<m.a> implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f241173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f241175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f241176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectorConfig f241177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseTitleBar f241178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SwipeRefreshLayout f241179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f241180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Group f241181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FolderSelectAdapter f241182k;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.a, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f285682a = null;
        tt5.a.h("FolderSelectView", "destroy()...");
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        Group r100 = null;
        this.f241175d.setOnClickListener(null);
        BaseTitleBar r101 = (BaseTitleBar) this.f241175d.findViewById(R.id.list_folder_select_titlebar);
        this.f241178g = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r101 = null;
    L5:
        r101.setDividerVisible(false);
        BaseTitleBar r102 = this.f241178g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r102 = null;
    L8:
        r102.setLeftClickListener(new k(this));
        BaseTitleBar r103 = this.f241178g;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r103 = null;
    L11:
        r103.setTitle(this.f241174c);
        BaseTitleBar r104 = this.f241178g;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r104 = null;
    L14:
        r104.h(8.0f);
        ((FrameLayout) this.f241175d.findViewById(R.id.search_layout)).setOnClickListener(new l(this));
        SwipeRefreshLayout r105 = (SwipeRefreshLayout) this.f241175d.findViewById(R.id.list_swipe_refresh);
        this.f241179h = r105;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r105 = null;
    L17:
        r105.setRefreshing(false);
        SwipeRefreshLayout r106 = this.f241179h;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r106 = null;
    L20:
        r106.setOnRefreshListener(new i(this));
        RecyclerView r107 = (RecyclerView) this.f241175d.findViewById(R.id.list_recycler_view);
        Context r108 = this.f241176e.getContext();
        r107.setLayoutManager(new LinearLayoutManager(r108));
        AccountService$Account r109 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r109);
        FolderSelectAdapter r110 = new FolderSelectAdapter(r108, r109);
        this.f241182k = r110;
        r107.setAdapter(r110);
        FolderSelectAdapter r111 = this.f241182k;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r111 = null;
    L23:
        r111.f241078d = new j(this);
        com.bytedance.ee.bear.list.loadstateview.h r112 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f241175d.findViewById(R.id.list_state_view_root));
        this.f241180i = r112;
        r112.a(EmptyCategory.FOLDER_SELECT);
        com.bytedance.ee.bear.list.loadstateview.h r113 = this.f241180i;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r113 = null;
    L26:
        r113.e(new g(this));
        this.f241181j = (Group) this.f241175d.findViewById(R.id.list_doc_operate_btn_group);
        ((Button) this.f241175d.findViewById(R.id.list_folder_select_copy_or_move)).setOnClickListener(new h(this));
        Group r114 = this.f241181j;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L30:
        r100.setVisibility(8);
        tt5.a.h("FolderSelectView", "create()...");
        return;
    L29:
        r100 = r114;
        goto L30
    }

    public final void h() {
        int r100 = this.f241173b;
        int r101 = 8;
        Group r102 = null;
        if (r100 != 6) goto L10;
        Group r103 = this.f241181j;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L8:
        r102.setVisibility(8);
        return;
    L7:
        r102 = r103;
        goto L8
    L10:
        if (r100 == 4) goto L12;
    L21:
        Group r104 = this.f241181j;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L25:
        r102.setVisibility(0);
        return;
    L24:
        r102 = r104;
        goto L25
    L12:
        if (this.f241177f.f229377i == true) goto L21;
        Group r105 = this.f241181j;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L18:
        if (this.f241177f.f229377i == false) goto L20;
        r101 = 0;
    L20:
        r102.setVisibility(r101);
        return;
    L16:
        r102 = r105;
        goto L18
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void showLoading() {
        tt5.a.h("FolderSelectView", "showLoading()...");
        com.bytedance.ee.bear.list.loadstateview.h r100 = this.f241180i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r100 = null;
    L5:
        r100.j();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void E(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        tt5.a.h("FolderSelectView", "showLoadFailed()...throwable = " + r100);
        SwipeRefreshLayout r101 = this.f241179h;
        com.bytedance.ee.bear.list.loadstateview.h r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r101 = null;
    L5:
        r101.setRefreshing(false);
        com.bytedance.ee.bear.list.loadstateview.h r103 = this.f241180i;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L9:
        r102.b(r100);
        h();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void I(List<? extends Document> r100) {
        int r101 = hu5.a.c(r100);
        tt5.a.h("FolderSelectView", "showList()...size = " + r101);
        SwipeRefreshLayout r102 = this.f241179h;
        FolderSelectAdapter r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r102 = null;
    L5:
        r102.setRefreshing(false);
        com.bytedance.ee.bear.list.loadstateview.h r104 = this.f241180i;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r104 = null;
    L8:
        r104.c(r101);
        FolderSelectAdapter r105 = this.f241182k;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r105 = null;
    L11:
        if (r100 != null) goto L13;
        r105.getClass();
        r100 = new ArrayList();
    L13:
        r105.f241077c = r100;
        FolderSelectAdapter r106 = this.f241182k;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r103.notifyDataSetChanged();
        h();
        return;
    L16:
        r103 = r106;
        goto L17
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void u(Document r100) {
        tt5.a.h("FolderSelectView", "setParent()...");
        tt5.a.h("FolderSelectView", "addCreateBtn()...folderType = " + this.f241173b);
        if (this.f241177f.f229376h == true) goto L6;
        tt5.a.h("FolderSelectView", "disable create folder.");
        return;
    L6:
        if (this.f241173b == 6) goto L21;
        BaseTitleBar r101 = this.f241178g;
        BaseTitleBar r102 = null;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r101 = null;
    L11:
        r101.g();
        BaseTitleBar r103 = this.f241178g;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r103 = null;
    L14:
        r103.a(new f(this, kac.a.b(R.drawable.ud_icon_creat_folder_outlined)), true);
        BaseTitleBar r104 = this.f241178g;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L18:
        r102.setActionIconTint(R.color.facade_selector_icon_n1);
        return;
    L17:
        r102 = r104;
        goto L18
    }

    public e(int r100, String r101, View r102, Fragment r103, SelectorConfig r104) {
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r104, "selectorConfig");
        this.f241173b = r100;
        this.f241174c = r101;
        this.f241175d = r102;
        this.f241176e = r103;
        this.f241177f = r104;
    }
}
