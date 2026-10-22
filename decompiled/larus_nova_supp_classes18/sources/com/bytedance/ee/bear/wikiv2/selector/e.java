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
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends com.larksuite.framework.mvp.a<m.a> implements m {
    public final int b;
    public final String c;
    public final View d;
    public final Fragment e;
    public final SelectorConfig f;
    public BaseTitleBar g;
    public SwipeRefreshLayout h;
    public com.bytedance.ee.bear.list.loadstateview.h i;
    public Group j;
    public FolderSelectAdapter k;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        ((com.larksuite.framework.mvp.a) this).a = null;
        tt5.a.h("FolderSelectView", "destroy()...");
    }

    public final void create() {
        Group r1 = null;
        this.d.setOnClickListener(null);
        BaseTitleBar r0 = (BaseTitleBar) this.d.findViewById(2131378103);
        this.g = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r0 = null;
    L5:
        r0.setDividerVisible(false);
        BaseTitleBar r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r2 = null;
    L8:
        r2.setLeftClickListener(new k(this));
        BaseTitleBar r3 = this.g;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r3 = null;
    L11:
        r3.setTitle(this.c);
        BaseTitleBar r4 = this.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r4 = null;
    L14:
        r4.h(8.0f);
        ((FrameLayout) this.d.findViewById(2131385527)).setOnClickListener(new l(this));
        SwipeRefreshLayout r5 = this.d.findViewById(2131378184);
        this.h = r5;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r5 = null;
    L17:
        r5.setRefreshing(false);
        SwipeRefreshLayout r6 = this.h;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r6 = null;
    L20:
        r6.setOnRefreshListener(new i(this));
        RecyclerView r7 = this.d.findViewById(2131378168);
        Context r8 = this.e.getContext();
        r7.setLayoutManager(new LinearLayoutManager(r8));
        AccountService.Account r9 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r9);
        FolderSelectAdapter r10 = new FolderSelectAdapter(r8, r9);
        this.k = r10;
        r7.setAdapter(r10);
        FolderSelectAdapter r11 = this.k;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r11 = null;
    L23:
        r11.d = new j(this);
        com.bytedance.ee.bear.list.loadstateview.h r12 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.d.findViewById(2131378179));
        this.i = r12;
        r12.a(EmptyCategory.FOLDER_SELECT);
        com.bytedance.ee.bear.list.loadstateview.h r13 = this.i;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r13 = null;
    L26:
        r13.e(new g(this));
        this.j = this.d.findViewById(2131378089);
        ((Button) this.d.findViewById(2131378102)).setOnClickListener(new h(this));
        Group r14 = this.j;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L30:
        r1.setVisibility(8);
        tt5.a.h("FolderSelectView", "create()...");
        return;
    L29:
        r1 = r14;
        goto L30
    }

    public final void h() {
        int r0 = this.b;
        int r2 = 8;
        Group r3 = null;
        if (r0 != 6) goto L10;
        Group r1 = this.j;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L8:
        r3.setVisibility(8);
        return;
    L7:
        r3 = r1;
        goto L8
    L10:
        if (r0 == 4) goto L12;
    L21:
        Group r4 = this.j;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L25:
        r3.setVisibility(0);
        return;
    L24:
        r3 = r4;
        goto L25
    L12:
        if (this.f.i == true) goto L21;
        Group r5 = this.j;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("groupOperate");
    L18:
        if (this.f.i == false) goto L20;
        r2 = 0;
    L20:
        r3.setVisibility(r2);
        return;
    L16:
        r3 = r5;
        goto L18
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void showLoading() {
        tt5.a.h("FolderSelectView", "showLoading()...");
        com.bytedance.ee.bear.list.loadstateview.h r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r0 = null;
    L5:
        r0.j();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void E(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.h("FolderSelectView", "showLoadFailed()...throwable = " + r4);
        SwipeRefreshLayout r0 = this.h;
        com.bytedance.ee.bear.list.loadstateview.h r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r0 = null;
    L5:
        r0.setRefreshing(false);
        com.bytedance.ee.bear.list.loadstateview.h r2 = this.i;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L9:
        r1.b(r4);
        h();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void I(List<? extends Document> r5) {
        int r0 = hu5.a.c(r5);
        tt5.a.h("FolderSelectView", "showList()...size = " + r0);
        SwipeRefreshLayout r1 = this.h;
        FolderSelectAdapter r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r1 = null;
    L5:
        r1.setRefreshing(false);
        com.bytedance.ee.bear.list.loadstateview.h r3 = this.i;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r3 = null;
    L8:
        r3.c(r0);
        FolderSelectAdapter r4 = this.k;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L11:
        if (r5 != null) goto L13;
        r4.getClass();
        r5 = new ArrayList();
    L13:
        r4.c = r5;
        FolderSelectAdapter r6 = this.k;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r2.notifyDataSetChanged();
        h();
        return;
    L16:
        r2 = r6;
        goto L17
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.m
    public final void u(Document r5) {
        tt5.a.h("FolderSelectView", "setParent()...");
        tt5.a.h("FolderSelectView", "addCreateBtn()...folderType = " + this.b);
        if (this.f.h == true) goto L6;
        tt5.a.h("FolderSelectView", "disable create folder.");
        return;
    L6:
        if (this.b == 6) goto L21;
        BaseTitleBar r6 = this.g;
        BaseTitleBar r0 = null;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r6 = null;
    L11:
        r6.g();
        BaseTitleBar r7 = this.g;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r7 = null;
    L14:
        r7.a(new f(this, kac.a.b(2131254172)), true);
        BaseTitleBar r8 = this.g;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L18:
        r0.setActionIconTint(2131101926);
        return;
    L17:
        r0 = r8;
        goto L18
    }

    public e(int r2, String r3, View r4, Fragment r5, SelectorConfig r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "selectorConfig");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
