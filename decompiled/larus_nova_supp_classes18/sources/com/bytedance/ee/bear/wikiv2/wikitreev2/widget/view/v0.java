package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v0 implements WikiTreeView.b {
    public final /* synthetic */ WikiTreeCtrlView a;

    public static final class a extends c0 {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j k;
        public final /* synthetic */ WikiTreeCtrlView l;

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
        public final void onDismiss() {
            this.l.getWikiTreeViewFromXml().n(this.k.n, false);
        }

        public a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r10, TreeNode r11, WikiTreeCtrlView r12, Context r13, String r14, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r15, Fragment r16, boolean r17) {
            this.k = r10;
            this.l = r12;
            Intrinsics.checkNotNull(r13);
            super(r13, r10, r11, r14, r15, r16, r17);
        }
    }

    public v0(WikiTreeCtrlView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19) {
        Intrinsics.checkNotNullParameter(r19, "node");
        WikiTreeCtrlView.c r2 = this.a.g;
        WikiTreeCtrlView.c r3 = null;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r2 = null;
    L6:
        if (r2.q == null) goto L22;
        WikiTreeCtrlView.c r5 = this.a.g;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r5 = null;
    L10:
        boolean r6 = r5.s;
        this.a.getRootToken();
        String r7 = gq5.a.a(r19, ResourceData.KEY_PAGE, r6);
        Intrinsics.checkNotNullParameter(r19, "<this>");
        if (TextUtils.equals("wikiroot%title_total_share_token", r19.b) == false) goto L13;
        String r8 = "ccm_space_shared_page_view";
    L14:
        String r9 = r8;
        Boolean r10 = Boolean.valueOf(r19.d());
        String r11 = this.a.getSpaceId();
        String r12 = r19.b;
        Boolean r13 = Boolean.valueOf(r19.e());
        String r14 = r19.c;
        String r15 = sbb.e.c(r19.d);
        WikiTreeCtrlView.c r16 = this.a.g;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r16 = null;
    L17:
        Integer r17 = r16.r;
        Boolean r18 = Boolean.valueOf(this.a.n());
        Boolean r110 = Boolean.valueOf(gq5.a.c(r19));
        WikiTreeCtrlView.c r20 = this.a.g;
        if (r20 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L21:
        gq5.d.n(new gq5.d.g(r7, r9, r10, r11, r12, r13, r14, r15, r17, r18, r110, gq5.a.b(r19, r3.s, this.a.getRootToken())));
        goto L22
    L20:
        r3 = r20;
        goto L21
    L13:
        r8 = "ccm_docs_page_view";
    L22:
        WikiTreeCtrlView.d r4 = this.a.getViewDelegate();
        if (r4 == null) goto L26;
        r4.f(r19.b, r19.n);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void d(WikiHomePageV2 r19) {
        Intrinsics.checkNotNullParameter(r19, "homePage");
        WikiTreeCtrlView.c r2 = this.a.g;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.g == false) goto L26;
        WikiTreeCtrlView.c r3 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r2 = null;
    L11:
        if (r2.q == null) goto L20;
        String r10 = r19.wikiToken;
        if (r10 != null) goto L15;
        return;
    L15:
        Boolean r11 = Boolean.FALSE;
        String r9 = this.a.getSpaceId();
        String r12 = r19.objToken;
        String r13 = sbb.e.c(r19.objType);
        WikiTreeCtrlView.c r5 = this.a.g;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L19:
        gq5.d.n(new gq5.d.g("wiki_homepage", "ccm_docs_page_view", r11, r9, r10, r11, r12, r13, r3.r, Boolean.valueOf(this.a.n()), Boolean.TRUE, "wiki_tree"));
        goto L20
    L18:
        r3 = r5;
    L20:
        WikiTreeCtrlView.d r4 = this.a.getViewDelegate();
        if (r4 == null) goto L25;
        r4.d(r19);
        return;
    L25:
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        WikiTreeCtrlView r0 = this.a;
        if (r0.f == null) goto L6;
        r0.getViewModel().registerChainPush(r3.a);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void h(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        WikiTreeCtrlView r0 = this.a;
        if (r0.f == null) goto L5;
        tt5.a.h(r0.e, "click#2 add node on root " + du5.b.g(this.a.getViewModel().getRootToken()));
    L5:
        this.a.l(r4);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void b(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "node");
        if (r9 == false) goto L25;
        WikiTreeCtrlView r10 = this.a;
        int r0 = WikiTreeCtrlView.q;
        TreeNode r1 = r10.getViewModel().getNode(r8.b);
        if (r1 == null) goto L26;
        r10.k.add(r10.getViewModel().requestNodePerm(r8.a, r8.b).observeOn(fo5.d.d()).subscribe(new x0(r10, r8), new y0(r10)));
        if (r1.isShortcut() == false) goto L18;
        String r2 = r1.origin_title;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        r10.k.add(((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r1.obj_token, r1.obj_type).subscribe(new z0(r1), new a1(r10)));
        goto L18
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
    L18:
        if (qc5.a.h() == false) goto L27;
        String r4 = r8.b;
        String r5 = r8.b();
        if (r8.t == false) goto L22;
        Flowable r11 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r4, r8.d);
    L23:
        r10.k.add(r11.observeOn(fo5.d.d()).subscribe(new b1(r10, r5), new c1(r10)));
        return;
    L22:
        int r12 = com.bytedance.ee.bear.more.protocol3.extension.s.a;
        Intrinsics.checkNotNull(r4);
        r11 = com.bytedance.ee.bear.more.protocol3.extension.s.a(r4);
        goto L23
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "node");
        WikiTreeCtrlView.c r2 = this.a.g;
        WikiTreeCtrlView.c r3 = null;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r2 = null;
    L6:
        if (r2.q != null) goto L8;
    L22:
        if (r20 == false) goto L24;
        this.a.getViewModel().expand(r19.n);
        return;
    L24:
        this.a.getViewModel().collapse(r19.n);
        return;
    L8:
        if (r20 == false) goto L10;
        String r5 = "expand";
    L11:
        WikiTreeCtrlView.c r6 = this.a.g;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L14:
        boolean r7 = r6.s;
        this.a.getRootToken();
        String r8 = gq5.a.a(r19, r5, r7);
        Boolean r9 = Boolean.valueOf(r19.d());
        String r10 = this.a.getSpaceId();
        String r11 = r19.b;
        Boolean r12 = Boolean.valueOf(r19.e());
        String r13 = r19.c;
        String r14 = sbb.e.c(r19.d);
        WikiTreeCtrlView.c r15 = this.a.g;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r15 = null;
    L17:
        Integer r16 = r15.r;
        Boolean r17 = Boolean.valueOf(this.a.n());
        Boolean r18 = Boolean.valueOf(gq5.a.c(r19));
        WikiTreeCtrlView.c r21 = this.a.g;
        if (r21 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L21:
        gq5.d.n(new gq5.d.g(r8, "none", r9, r10, r11, r12, r13, r14, r16, r17, r18, gq5.a.b(r19, r3.s, this.a.getRootToken())));
        goto L22
    L20:
        r3 = r21;
        goto L21
    L10:
        r5 = "collapse";
        goto L11
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "focusToken");
        Intrinsics.checkNotNullParameter(r3, "focusUid");
        this.a.getViewModel().setFocus(r2, r3);
        WikiTreeCtrlView.d r4 = this.a.getViewDelegate();
        if (r4 == null) goto L6;
        r4.c(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void i(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "node");
        WikiTreeCtrlView.c r2 = this.a.g;
        WikiTreeCtrlView.c r3 = null;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r2 = null;
    L6:
        if (r2.q != null) goto L8;
    L22:
        if (r20 == false) goto L24;
        this.a.getViewModel().expandSpace(r19.n);
        return;
    L24:
        this.a.getViewModel().collapseSpace(r19.n);
        return;
    L8:
        if (r20 == false) goto L10;
        String r5 = "expand";
    L11:
        WikiTreeCtrlView.c r6 = this.a.g;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L14:
        boolean r7 = r6.s;
        this.a.getRootToken();
        String r8 = gq5.a.a(r19, r5, r7);
        Boolean r9 = Boolean.valueOf(r19.d());
        String r10 = this.a.getSpaceId();
        String r11 = r19.b;
        Boolean r12 = Boolean.valueOf(r19.e());
        String r13 = r19.c;
        String r14 = sbb.e.c(r19.d);
        WikiTreeCtrlView.c r15 = this.a.g;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r15 = null;
    L17:
        Integer r16 = r15.r;
        Boolean r17 = Boolean.valueOf(this.a.n());
        Boolean r18 = Boolean.valueOf(gq5.a.c(r19));
        WikiTreeCtrlView.c r21 = this.a.g;
        if (r21 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L21:
        gq5.d.n(new gq5.d.g(r8, "none", r9, r10, r11, r12, r13, r14, r16, r17, r18, gq5.a.b(r19, r3.s, this.a.getRootToken())));
        goto L22
    L20:
        r3 = r21;
        goto L21
    L10:
        r5 = "collapse";
        goto L11
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.b
    public final void a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r35, int r36, View r37) {
        Intrinsics.checkNotNullParameter(r35, "node");
        TreeNode r11 = this.a.getViewModel().getNode(r35.b);
        if (r11 == null) goto L6;
        WikNodePerm r2 = r11.perm;
        if (r2 == null) goto L6;
    L7:
        WikNodePerm r12 = r2;
        WikiTreeCtrlView.c r3 = null;
        if (r36 != 2131387817) goto L18;
        Boolean r16 = Boolean.valueOf(r35.d());
        String r17 = this.a.getSpaceId();
        String r4 = r35.b;
        Boolean r19 = Boolean.valueOf(r35.e());
        String r5 = r35.c;
        String r21 = sbb.e.c(r35.d);
        WikiTreeCtrlView.c r6 = this.a.g;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L12:
        Integer r7 = r6.r;
        Boolean r23 = Boolean.valueOf(this.a.n());
        Boolean r24 = Boolean.valueOf(gq5.a.c(r35));
        WikiTreeCtrlView.c r8 = this.a.g;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L16:
        gq5.d.n(new gq5.d.g("add", "ccm_wiki_tree_add_view", r16, r17, r4, r19, r5, r21, r7, r23, r24, gq5.a.b(r35, r3.s, this.a.getRootToken())));
        this.a.e(r35, r12.can_create, false, false, r37);
        return;
    L15:
        r3 = r8;
        goto L16
    L18:
        if (r36 != 2131387821) goto L36;
        Boolean r18 = Boolean.valueOf(r35.d());
        String r110 = this.a.getSpaceId();
        String r9 = r35.b;
        Boolean r111 = Boolean.valueOf(r35.e());
        String r10 = r35.c;
        String r22 = sbb.e.c(r35.d);
        WikiTreeCtrlView.c r13 = this.a.g;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r13 = null;
    L22:
        Integer r14 = r13.r;
        Boolean r25 = Boolean.valueOf(this.a.n());
        Boolean r26 = Boolean.valueOf(gq5.a.c(r35));
        WikiTreeCtrlView.c r15 = this.a.g;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
    L26:
        gq5.d.n(new gq5.d.g("more", "ccm_wiki_tree_more_view", r18, r110, r9, r111, r10, r22, r14, r25, r26, gq5.a.b(r35, r3.s, this.a.getRootToken())));
        String r112 = this.a.getSpaceId();
        String r113 = r35.b;
        Boolean r114 = Boolean.valueOf(r35.e());
        String r20 = r35.c;
        String r115 = sbb.e.c(r35.d);
        boolean r27 = r35.m;
        Boolean r28 = Boolean.valueOf(this.a.n());
        Intrinsics.checkNotNullParameter(new gq5.d.h(r112, r113, r114, r20, r115, r27, r28), "bean");
        JSONObject r1 = new JSONObject();
        int r29 = gq5.d.a;
        if (r27 == false) goto L29;
        String r30 = "space";
    L30:
        r1.put("original_docs_container", r30);
        gq5.d.a(r1, r112, r113, r114, r20, r115, null, r28, 32);
        gq5.e.c("ccm_wiki_tree_more_view", r1);
        if (r11 == null) goto L33;
        r11.is_star = this.a.getViewModel().isFavorite(r35.b);
    L33:
        this.a.getViewModel().isFavorite(r35.b);
        WikiTreeCtrlView r116 = this.a;
        r116.n = new a(r35, r11, this.a, r116.getContext(), this.a.getSpaceId(), this.a.getViewModel(), this.a.getViewLifecycleOwner(), this.a.n());
        WikiTreeCtrlView r31 = this.a;
        WikiDialogs r32 = r31.j;
        FragmentActivity r33 = r31.getViewLifecycleOwner().getActivity();
        SpaceInfo r34 = this.a.getViewModel().getSpaceInfo();
        WikiTreeCtrlView r38 = this.a;
        c0 r117 = r38.n;
        Intrinsics.checkNotNull(r12);
        WikiTreeCtrlView r39 = this.a;
        r32.l(r33, r11, r34, r117, r38.f(r11, r35, r12, r39.n, r39.getUserComponentAbility()), this.a.getViewLifecycleOwner(), r37);
        return;
    L29:
        r30 = DocumentType.WIKI_NAME;
        goto L30
    L25:
        r3 = r15;
        goto L26
    L36:
        return;
    L6:
        r2 = WikNodePerm.defaulted();
        goto L7
    }
}
