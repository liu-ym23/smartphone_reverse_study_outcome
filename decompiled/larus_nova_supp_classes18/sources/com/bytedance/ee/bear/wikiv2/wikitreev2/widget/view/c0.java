package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class c0 implements WikiDialogs.b {
    public final Context a;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;
    public final TreeNode c;
    public final String d;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b e;
    public final Fragment f;
    public final boolean g;
    public final WikiDialogs h;
    public long i;
    public final CompositeDisposable j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void a() {
        Boolean r4 = Boolean.valueOf(this.b.d());
        String r5 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        String r6 = r1.b;
        Boolean r7 = Boolean.valueOf(r1.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        gq5.d.o(new gq5.d.i("shortcut_to", "ccm_wiki_file_location_select_view", r4, r5, r6, r7, r2.c, sbb.e.c(r2.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = this.b;
        String r8 = r3.b;
        Intrinsics.checkNotNullParameter(r8, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r9 = this.e.getNode(r8);
        Bundle r13 = new Bundle();
        r13.putString("src_token", r3.b);
        r13.putInt("src_obj_type", r3.d);
        r13.putBoolean("src_origin_external", r3.m);
        if (r9 == null) goto L6;
        String r10 = r9.getOriginTitle();
        if (r10 == null) goto L6;
    L7:
        r13.putString("title", r10);
        r13.putInt("EXTRA_PAGE_MODE", 3);
        r13.putBoolean("src_is_shortcut", r3.e());
        r13.putString("src_origin_token", r3.b());
        r13.putString("trigger_location", "wiki_tree");
        String r11 = null;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f.getActivity());
        Fragment r12 = this.f;
        Context r14 = this.a;
        String r15 = r3.b;
        String r16 = r3.b();
        boolean r17 = r3.e();
        String r18 = r3.c;
        int r19 = r3.d;
        String r20 = r3.e;
        boolean r110 = this.g;
        if (r9 == null) goto L12;
        WikiDetailInfo r21 = r9.detail_info;
        if (r21 == null) goto L12;
        r11 = r21.owner_id;
    L12:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.d(r12, r14, r15, r16, r17, r18, r19, r20, 2025, r13, r110, t4.a(r11)));
        return;
    L6:
        r10 = r3.e;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void e() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = this.b;
        if (r0.d != sbb.e.l.b) goto L5;
        boolean r1 = true;
    L6:
        String r2 = r0.e;
        if (r1 == false) goto L9;
        String r3 = com.bytedance.ee.util.io.a.d(r2);
    L10:
        this.h.k(this.a, r3, new i0(r1, r2, this, r0));
        return;
    L9:
        r3 = r2;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void f() {
        Boolean r4 = Boolean.valueOf(this.b.d());
        String r5 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        String r6 = r1.b;
        Boolean r7 = Boolean.valueOf(r1.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        gq5.d.o(new gq5.d.i("move_to", "ccm_wiki_file_location_select_view", r4, r5, r6, r7, r2.c, sbb.e.c(r2.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = this.b;
        TreeNode r8 = this.e.getNode(r3.b);
        String r9 = null;
        if (r8 == null) goto L5;
        WikNodePerm r13 = r8.perm;
    L6:
        if (r13 != null) goto L8;
        tt5.a.h("WikiItemMoreViewDelegate", "doMoveTo, perm not found. return. ");
        return;
    L8:
        Bundle r15 = new Bundle();
        r15.putInt("srcIsLock", r13.is_locked ? 1 : 0);
        r15.putString("src_space_id", r3.a);
        TreeNode r10 = this.e.getNode(r3.b);
        if (r10 == null) goto L11;
        String r11 = r10.parent_wiki_token;
    L12:
        r15.putString("src_parent_token", r11);
        r15.putString("src_token", r3.b);
        r15.putInt("src_obj_type", r3.d);
        r15.putInt("EXTRA_PAGE_MODE", 2);
        r15.putString("trigger_location", "wiki_tree");
        r15.putBoolean("src_is_shortcut", r3.e());
        r15.putBoolean("src_is_from_folderblock", false);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f.getActivity());
        qc5.a.j();
        if (r3.e() == true) goto L20;
        Fragment r12 = this.f;
        Context r14 = this.a;
        String r16 = r3.a;
        String r17 = r3.f;
        String r18 = r3.b;
        boolean r19 = r3.k;
        String r110 = r3.e;
        boolean r20 = this.g;
        if (r8 == null) goto L19;
        WikiDetailInfo r21 = r8.detail_info;
        if (r21 == null) goto L19;
        r9 = r21.owner_id;
    L19:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r12, r14, r16, r17, r18, r19, r110, r13, DocUserPermission.USER_PERM_FULL_ACCESS, r15, r20, t4.a(r9), r3.c, r3.d));
        return;
    L20:
        SelectorConfig r22 = new SelectorConfig();
        r22.c(SelectorType.WIKI_MOVE_TO);
        r22.a(SelectorScope.WIKI_ONLY);
        r22.g = DocUserPermission.USER_PERM_FULL_ACCESS;
        r22.d = true;
        Context r23 = this.a;
        if (r23 == null) goto L24;
        String r24 = r23.getString(2131889814);
        if (r24 == null) goto L24;
    L25:
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r22.b = r24;
        r15.putParcelable("extra_config", r22);
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.f(this.f, r15);
        gq5.d.j("move_to", r3.a);
        return;
    L24:
        r24 = "";
        goto L25
    L11:
        r11 = null;
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void i() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = this.b;
        Context r1 = this.f.getContext();
        TreeNode r2 = this.e.getNode(r0.b);
        if (r2 == null) goto L6;
        WikNodePerm r3 = r2.perm;
        if (r3 == null) goto L6;
    L7:
        tt5.a.h("WikiItemMoreViewDelegate", "doRemoveFromWiki()...can_move = " + r3.can_move);
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L10;
        Intrinsics.checkNotNull(r3);
        k(r3, r0);
        return;
    L10:
        this.h.n(r1, r0.k, new g0(this, r3, r0), h0.a);
        return;
    L6:
        r3 = WikNodePerm.defaulted();
        goto L7
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void b(SpaceInfo r25) {
        Boolean r4 = Boolean.valueOf(this.b.d());
        String r5 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        String r6 = r1.b;
        Boolean r7 = Boolean.valueOf(r1.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        gq5.d.o(new gq5.d.i("make_a_copy_to", "ccm_wiki_file_location_select_view", r4, r5, r6, r7, r2.c, sbb.e.c(r2.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = this.b;
        String r8 = r3.b;
        Intrinsics.checkNotNullParameter(r8, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r9 = this.e.getNode(r8);
        Bundle r15 = new Bundle();
        r15.putString("src_space_id", r3.a);
        r15.putString("src_parent_token", r3.f);
        if (r9 == null) goto L6;
        String r10 = r9.getOriginTitle();
        if (r10 == null) goto L6;
    L7:
        r15.putString("title", r10);
        r15.putString("src_token", r3.b);
        r15.putInt("src_obj_type", r3.d);
        r15.putInt("EXTRA_PAGE_MODE", 4);
        r15.putString("trigger_location", "wiki_tree");
        r15.putBoolean("src_is_shortcut", r3.e());
        r15.putBoolean("src_origin_external", r3.m);
        r15.putString("src_origin_token", r3.b());
        r15.putString("src_origin_space_id", r3.j);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f.getActivity());
        qc5.a.j();
        Fragment r11 = this.f;
        Context r12 = this.a;
        String r13 = r3.b;
        String r14 = r3.b();
        String r16 = r3.a;
        String r17 = r3.j;
        SpaceInfo r18 = this.e.getSpaceInfo();
        if (r18 == null) goto L10;
        String r19 = r18.getSpaceName();
    L11:
        boolean r110 = r3.e();
        String r111 = r3.f;
        String r112 = r3.c;
        int r20 = r3.d;
        if (r9 == null) goto L15;
        String r113 = r9.getOriginTitle();
        if (r113 == null) goto L15;
    L16:
        boolean r21 = this.g;
        boolean r22 = !pq5.a.a(this.b);
        if (r9 == null) goto L21;
        WikiDetailInfo r23 = r9.detail_info;
        if (r23 == null) goto L21;
        String r24 = r23.owner_id;
    L22:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.c(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.a(r11, r12, r13, r14, r16, r17, r19, r110, r111, r112, r20, r113, 0, 2026, r15, r21, r22, t4.a(r24)));
        return;
    L21:
        r24 = null;
    L15:
        r113 = r3.e;
        goto L16
    L10:
        r19 = null;
    L6:
        r10 = r3.e;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void c(boolean r13) {
        if (r13 == false) goto L5;
        String r0 = "clip_wiki";
    L6:
        String r1 = r0;
        Boolean r3 = Boolean.valueOf(this.b.d());
        String r4 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        String r5 = r2.b;
        Boolean r6 = Boolean.valueOf(r2.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = this.b;
        gq5.d.o(new gq5.d.i(r1, "none", r3, r4, r5, r6, r7.c, sbb.e.c(r7.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r8 = this.b;
        if (r13 == false) goto L9;
        this.e.favorite(r8.b);
        return;
    L9:
        this.e.unfavorite(r8.b);
        return;
    L5:
        r0 = "unclip_wiki";
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void d(SpaceInfo r20) {
        Boolean r4 = Boolean.valueOf(this.b.d());
        String r5 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        String r6 = r1.b;
        Boolean r7 = Boolean.valueOf(r1.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        gq5.d.o(new gq5.d.i("delete", "ccm_wiki_delete_confirm_view", r4, r5, r6, r7, r2.c, sbb.e.c(r2.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = this.b;
        String r11 = this.d;
        String r12 = r3.b;
        Boolean r13 = Boolean.valueOf(r3.e());
        String r14 = r3.c;
        String r15 = sbb.e.c(r3.d);
        Boolean r10 = Boolean.valueOf(r3.c());
        Intrinsics.checkNotNullParameter(new gq5.d.c(r11, r12, r13, r14, r15, r10), "bean");
        JSONObject r8 = new JSONObject();
        String r9 = null;
        if (r10 == null) goto L5;
        String r16 = r10.toString();
    L6:
        gq5.e.b(r8, "is_include_children_page", r16);
        gq5.d.a(r8, r11, r12, r13, r14, r15, null, null, 96);
        gq5.e.c("ccm_wiki_delete_confirm_view", r8);
        TreeNode r17 = this.e.getNode(r3.b);
        if (r17 == null) goto L9;
        WikNodePerm r18 = r17.perm;
    L10:
        WikiDialogs r19 = this.h;
        Context r21 = this.f.getContext();
        String r22 = r3.b;
        Intrinsics.checkNotNullParameter(r22, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r23 = this.e.getNode(r22);
        f0 r24 = new f0(r3, this);
        boolean r25 = this.g;
        SpaceInfo r26 = this.e.getSpaceInfo();
        if (r26 == null) goto L13;
        r9 = r26.getSpaceName();
    L13:
        r19.h(r21, r23, r18, r24, r25, r9);
        return;
    L9:
        r18 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void g(boolean r13) {
        if (r13 == false) goto L5;
        String r0 = "add_to_quickaccess";
    L6:
        String r1 = r0;
        Boolean r3 = Boolean.valueOf(this.b.d());
        String r4 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        String r5 = r2.b;
        Boolean r6 = Boolean.valueOf(r2.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = this.b;
        gq5.d.o(new gq5.d.i(r1, "none", r3, r4, r5, r6, r7.c, sbb.e.c(r7.d), this.b.m, Boolean.valueOf(this.g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r8 = this.b;
        String r9 = r8.b();
        if (r8.m == false) goto L9;
        int r10 = r8.d;
    L10:
        if (r13 == false) goto L12;
        this.e.pin(r8.a, r9, r10);
        return;
    L12:
        this.e.unPin(r8.a, r9, r10);
        return;
    L9:
        r10 = 16;
        goto L10
    L5:
        r0 = "remove_from_quickaccess";
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void h(boolean r13) {
        if (r13 == false) goto L5;
        String r0 = "star_wiki";
    L6:
        String r1 = r0;
        Boolean r3 = Boolean.valueOf(this.b.d());
        String r4 = this.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = this.b;
        String r5 = r2.b;
        Boolean r6 = Boolean.valueOf(r2.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = this.b;
        gq5.d.o(new gq5.d.i(r1, "none", r3, r4, r5, r6, r7.c, sbb.e.c(r7.d), this.b.m, Boolean.valueOf(this.g)));
        TreeNode r8 = this.c;
        if (r8 == null) goto L10;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a(this.a, r8, r13, true);
        return;
    L10:
        return;
    L5:
        r0 = "unstar_wiki";
        goto L6
    }

    public final void k(WikNodePerm r4, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r5) {
        if (r4.can_move == false) goto L5;
        Context r6 = this.a;
        Toast.showLoading(r6, this.f.getString(2131888333));
        this.i = System.currentTimeMillis();
        Disposable r7 = this.e.moveToSpace(r5.b, r5.a).flatMap(new l0(this)).subscribe(new m0(r6, this, r5), new n0(r6, this));
        this.j.add(r7);
        return;
    L5:
        Context r8 = this.a;
        Toast.showLoading(r8, this.f.getString(2131887769));
        Disposable r9 = this.e.getMoveNodeAuthorizedUserInfo(r5.b, r5.a).subscribe(new d0(this, r5), new e0(r8, this, r5));
        this.j.add(r9);
    }

    public static final Flowable j(c0 r5, String r6, long r7) {
        r5.getClass();
        if ((System.currentTimeMillis() - r5.i) <= 30000) goto L5;
        tt5.a.d("WikiItemMoreViewDelegate", "pollingMoveToSpaceStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r7, TimeUnit.MILLISECONDS).flatMap(new j0(r5, r6)).flatMap(new k0(r5, r6));
    }

    public c0(Context r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3, TreeNode r4, String r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r6, Fragment r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "viewLifecycleOwner");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new WikiDialogs();
        this.j = new CompositeDisposable();
    }
}
