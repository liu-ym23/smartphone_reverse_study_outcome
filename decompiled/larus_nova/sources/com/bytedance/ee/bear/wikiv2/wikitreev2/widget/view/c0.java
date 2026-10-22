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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class c0 implements WikiDialogs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f242416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeNode f242418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f242419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b f242420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f242421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f242422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WikiDialogs f242423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f242424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f242425j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void a() {
        Boolean r100 = Boolean.valueOf(this.f242417b.d());
        String r101 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102 = this.f242417b;
        String r103 = r102.f241914b;
        Boolean r104 = Boolean.valueOf(r102.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = this.f242417b;
        gq5.d.o(new gq5.d.i("shortcut_to", "ccm_wiki_file_location_select_view", r100, r101, r103, r104, r105.f241915c, sbb.e.c(r105.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r106 = this.f242417b;
        String r107 = r106.f241914b;
        Intrinsics.checkNotNullParameter(r107, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r108 = this.f242420e.getNode(r107);
        Bundle r110 = new Bundle();
        r110.putString("src_token", r106.f241914b);
        r110.putInt("src_obj_type", r106.f241916d);
        r110.putBoolean("src_origin_external", r106.f241925m);
        if (r108 == null) goto L6;
        String r109 = r108.getOriginTitle();
        if (r109 == null) goto L6;
    L7:
        r110.putString("title", r109);
        r110.putInt("EXTRA_PAGE_MODE", 3);
        r110.putBoolean("src_is_shortcut", r106.e());
        r110.putString("src_origin_token", r106.b());
        r110.putString("trigger_location", "wiki_tree");
        String r111 = null;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f242421f.getActivity());
        Fragment r112 = this.f242421f;
        Context r113 = this.f242416a;
        String r114 = r106.f241914b;
        String r115 = r106.b();
        boolean r116 = r106.e();
        String r117 = r106.f241915c;
        int r118 = r106.f241916d;
        String r119 = r106.f241917e;
        boolean r120 = this.f242422g;
        if (r108 == null) goto L12;
        WikiDetailInfo r121 = r108.detail_info;
        if (r121 == null) goto L12;
        r111 = r121.owner_id;
    L12:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.d(r112, r113, r114, r115, r116, r117, r118, r119, DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, r110, r120, t4.a(r111)));
        return;
    L6:
        r109 = r106.f241917e;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void e() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100 = this.f242417b;
        if (r100.f241916d != sbb.e.f541301l.f541317b) goto L5;
        boolean r101 = true;
    L6:
        String r102 = r100.f241917e;
        if (r101 == false) goto L9;
        String r103 = com.bytedance.ee.util.io.a.d(r102);
    L10:
        this.f242423h.k(this.f242416a, r103, new i0(r101, r102, this, r100));
        return;
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void f() {
        Boolean r100 = Boolean.valueOf(this.f242417b.d());
        String r101 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102 = this.f242417b;
        String r103 = r102.f241914b;
        Boolean r104 = Boolean.valueOf(r102.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = this.f242417b;
        gq5.d.o(new gq5.d.i("move_to", "ccm_wiki_file_location_select_view", r100, r101, r103, r104, r105.f241915c, sbb.e.c(r105.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r106 = this.f242417b;
        TreeNode r107 = this.f242420e.getNode(r106.f241914b);
        String r108 = null;
        if (r107 == null) goto L5;
        WikNodePerm r110 = r107.perm;
    L6:
        if (r110 != null) goto L8;
        tt5.a.h("WikiItemMoreViewDelegate", "doMoveTo, perm not found. return. ");
        return;
    L8:
        Bundle r111 = new Bundle();
        r111.putInt("srcIsLock", r110.is_locked ? 1 : 0);
        r111.putString("src_space_id", r106.f241913a);
        TreeNode r109 = this.f242420e.getNode(r106.f241914b);
        if (r109 == null) goto L11;
        String r112 = r109.parent_wiki_token;
    L12:
        r111.putString("src_parent_token", r112);
        r111.putString("src_token", r106.f241914b);
        r111.putInt("src_obj_type", r106.f241916d);
        r111.putInt("EXTRA_PAGE_MODE", 2);
        r111.putString("trigger_location", "wiki_tree");
        r111.putBoolean("src_is_shortcut", r106.e());
        r111.putBoolean("src_is_from_folderblock", false);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f242421f.getActivity());
        qc5.a.j();
        if (r106.e() == true) goto L20;
        Fragment r113 = this.f242421f;
        Context r114 = this.f242416a;
        String r115 = r106.f241913a;
        String r116 = r106.f241918f;
        String r117 = r106.f241914b;
        boolean r118 = r106.f241923k;
        String r119 = r106.f241917e;
        boolean r120 = this.f242422g;
        if (r107 == null) goto L19;
        WikiDetailInfo r121 = r107.detail_info;
        if (r121 == null) goto L19;
        r108 = r121.owner_id;
    L19:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r113, r114, r115, r116, r117, r118, r119, r110, 1024, r111, r120, t4.a(r108), r106.f241915c, r106.f241916d));
        return;
    L20:
        SelectorConfig r122 = new SelectorConfig();
        r122.c(SelectorType.WIKI_MOVE_TO);
        r122.a(SelectorScope.WIKI_ONLY);
        r122.f229375g = 1024;
        r122.f229372d = true;
        Context r123 = this.f242416a;
        if (r123 == null) goto L24;
        String r124 = r123.getString(R.string.LarkCCM_Wiki_MoveTo_Header_Mob);
        if (r124 == null) goto L24;
    L25:
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        r122.f229370b = r124;
        r111.putParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG, r122);
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.f(this.f242421f, r111);
        gq5.d.j("move_to", r106.f241913a);
        return;
    L24:
        r124 = "";
        goto L25
    L11:
        r112 = null;
        goto L12
    L5:
        r110 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void i() {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100 = this.f242417b;
        Context r101 = this.f242421f.getContext();
        TreeNode r102 = this.f242420e.getNode(r100.f241914b);
        if (r102 == null) goto L6;
        WikNodePerm r103 = r102.perm;
        if (r103 == null) goto L6;
    L7:
        tt5.a.h("WikiItemMoreViewDelegate", "doRemoveFromWiki()...can_move = " + r103.can_move);
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L10;
        Intrinsics.checkNotNull(r103);
        k(r103, r100);
        return;
    L10:
        this.f242423h.n(r101, r100.f241923k, new g0(this, r103, r100), h0.f242488a);
        return;
    L6:
        r103 = WikNodePerm.defaulted();
        goto L7
    }

    public final Context getContext() {
        return this.f242416a;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void b(SpaceInfo r210) {
        Boolean r100 = Boolean.valueOf(this.f242417b.d());
        String r101 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102 = this.f242417b;
        String r103 = r102.f241914b;
        Boolean r104 = Boolean.valueOf(r102.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = this.f242417b;
        gq5.d.o(new gq5.d.i("make_a_copy_to", "ccm_wiki_file_location_select_view", r100, r101, r103, r104, r105.f241915c, sbb.e.c(r105.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r106 = this.f242417b;
        String r107 = r106.f241914b;
        Intrinsics.checkNotNullParameter(r107, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r108 = this.f242420e.getNode(r107);
        Bundle r110 = new Bundle();
        r110.putString("src_space_id", r106.f241913a);
        r110.putString("src_parent_token", r106.f241918f);
        if (r108 == null) goto L6;
        String r109 = r108.getOriginTitle();
        if (r109 == null) goto L6;
    L7:
        r110.putString("title", r109);
        r110.putString("src_token", r106.f241914b);
        r110.putInt("src_obj_type", r106.f241916d);
        r110.putInt("EXTRA_PAGE_MODE", 4);
        r110.putString("trigger_location", "wiki_tree");
        r110.putBoolean("src_is_shortcut", r106.e());
        r110.putBoolean("src_origin_external", r106.f241925m);
        r110.putString("src_origin_token", r106.b());
        r110.putString("src_origin_space_id", r106.f241922j);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.f242421f.getActivity());
        qc5.a.j();
        Fragment r111 = this.f242421f;
        Context r112 = this.f242416a;
        String r113 = r106.f241914b;
        String r114 = r106.b();
        String r115 = r106.f241913a;
        String r116 = r106.f241922j;
        SpaceInfo r117 = this.f242420e.getSpaceInfo();
        if (r117 == null) goto L10;
        String r118 = r117.getSpaceName();
    L11:
        boolean r119 = r106.e();
        String r120 = r106.f241918f;
        String r121 = r106.f241915c;
        int r122 = r106.f241916d;
        if (r108 == null) goto L15;
        String r123 = r108.getOriginTitle();
        if (r123 == null) goto L15;
    L16:
        boolean r124 = this.f242422g;
        boolean r211 = !pq5.a.a(this.f242417b);
        if (r108 == null) goto L21;
        WikiDetailInfo r125 = r108.detail_info;
        if (r125 == null) goto L21;
        String r126 = r125.owner_id;
    L22:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.c(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.a(r111, r112, r113, r114, r115, r116, r118, r119, r120, r121, r122, r123, 0, 2026, r110, r124, r211, t4.a(r126)));
        return;
    L21:
        r126 = null;
    L15:
        r123 = r106.f241917e;
        goto L16
    L10:
        r118 = null;
    L6:
        r109 = r106.f241917e;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void c(boolean r110) {
        if (r110 == false) goto L5;
        String r100 = "clip_wiki";
    L6:
        String r101 = r100;
        Boolean r102 = Boolean.valueOf(this.f242417b.d());
        String r103 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r104 = this.f242417b;
        String r105 = r104.f241914b;
        Boolean r106 = Boolean.valueOf(r104.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r107 = this.f242417b;
        gq5.d.o(new gq5.d.i(r101, "none", r102, r103, r105, r106, r107.f241915c, sbb.e.c(r107.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r108 = this.f242417b;
        if (r110 == false) goto L9;
        this.f242420e.favorite(r108.f241914b);
        return;
    L9:
        this.f242420e.unfavorite(r108.f241914b);
        return;
    L5:
        r100 = "unclip_wiki";
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void d(SpaceInfo r210) {
        Boolean r100 = Boolean.valueOf(this.f242417b.d());
        String r101 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102 = this.f242417b;
        String r103 = r102.f241914b;
        Boolean r104 = Boolean.valueOf(r102.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r105 = this.f242417b;
        gq5.d.o(new gq5.d.i("delete", "ccm_wiki_delete_confirm_view", r100, r101, r103, r104, r105.f241915c, sbb.e.c(r105.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r106 = this.f242417b;
        String r110 = this.f242419d;
        String r111 = r106.f241914b;
        Boolean r112 = Boolean.valueOf(r106.e());
        String r113 = r106.f241915c;
        String r114 = sbb.e.c(r106.f241916d);
        Boolean r115 = Boolean.valueOf(r106.c());
        Intrinsics.checkNotNullParameter(new gq5.d.c(r110, r111, r112, r113, r114, r115), "bean");
        JSONObject r107 = new JSONObject();
        String r108 = null;
        if (r115 == null) goto L5;
        String r109 = r115.toString();
    L6:
        gq5.e.b(r107, "is_include_children_page", r109);
        gq5.d.a(r107, r110, r111, r112, r113, r114, null, null, 96);
        gq5.e.c("ccm_wiki_delete_confirm_view", r107);
        TreeNode r116 = this.f242420e.getNode(r106.f241914b);
        if (r116 == null) goto L9;
        WikNodePerm r117 = r116.perm;
    L10:
        WikiDialogs r118 = this.f242423h;
        Context r119 = this.f242421f.getContext();
        String r120 = r106.f241914b;
        Intrinsics.checkNotNullParameter(r120, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r121 = this.f242420e.getNode(r120);
        f0 r122 = new f0(r106, this);
        boolean r123 = this.f242422g;
        SpaceInfo r124 = this.f242420e.getSpaceInfo();
        if (r124 == null) goto L13;
        r108 = r124.getSpaceName();
    L13:
        r118.h(r119, r121, r117, r122, r123, r108);
        return;
    L9:
        r117 = null;
        goto L10
    L5:
        r109 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void g(boolean r110) {
        if (r110 == false) goto L5;
        String r100 = "add_to_quickaccess";
    L6:
        String r101 = r100;
        Boolean r102 = Boolean.valueOf(this.f242417b.d());
        String r103 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r104 = this.f242417b;
        String r105 = r104.f241914b;
        Boolean r106 = Boolean.valueOf(r104.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r107 = this.f242417b;
        gq5.d.o(new gq5.d.i(r101, "none", r102, r103, r105, r106, r107.f241915c, sbb.e.c(r107.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r108 = this.f242417b;
        String r109 = r108.b();
        if (r108.f241925m == false) goto L9;
        int r111 = r108.f241916d;
    L10:
        if (r110 == false) goto L12;
        this.f242420e.pin(r108.f241913a, r109, r111);
        return;
    L12:
        this.f242420e.unPin(r108.f241913a, r109, r111);
        return;
    L9:
        r111 = 16;
        goto L10
    L5:
        r100 = "remove_from_quickaccess";
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void h(boolean r110) {
        if (r110 == false) goto L5;
        String r100 = "star_wiki";
    L6:
        String r101 = r100;
        Boolean r102 = Boolean.valueOf(this.f242417b.d());
        String r103 = this.f242419d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r104 = this.f242417b;
        String r105 = r104.f241914b;
        Boolean r106 = Boolean.valueOf(r104.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r107 = this.f242417b;
        gq5.d.o(new gq5.d.i(r101, "none", r102, r103, r105, r106, r107.f241915c, sbb.e.c(r107.f241916d), this.f242417b.f241925m, Boolean.valueOf(this.f242422g)));
        TreeNode r108 = this.f242418c;
        if (r108 == null) goto L10;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a(this.f242416a, r108, r110, true);
        return;
    L10:
        return;
    L5:
        r100 = "unstar_wiki";
        goto L6
    }

    public final void k(WikNodePerm r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101) {
        if (r100.can_move == false) goto L5;
        Context r102 = this.f242416a;
        Toast.showLoading(r102, this.f242421f.getString(R.string.Doc_Wiki_MovePageMoving));
        this.f242424i = System.currentTimeMillis();
        Disposable r103 = this.f242420e.moveToSpace(r101.f241914b, r101.f241913a).flatMap(new l0(this)).subscribe(new m0(r102, this, r101), new n0(r102, this));
        this.f242425j.add(r103);
        return;
    L5:
        Context r104 = this.f242416a;
        Toast.showLoading(r104, this.f242421f.getString(R.string.Doc_Facade_Loading));
        Disposable r105 = this.f242420e.getMoveNodeAuthorizedUserInfo(r101.f241914b, r101.f241913a).subscribe(new d0(this, r101), new e0(r104, this, r101));
        this.f242425j.add(r105);
    }

    public static final Flowable j(c0 r100, String r101, long r102) {
        r100.getClass();
        if ((System.currentTimeMillis() - r100.f242424i) <= 30000) goto L5;
        tt5.a.d("WikiItemMoreViewDelegate", "pollingMoveToSpaceStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r102, TimeUnit.MILLISECONDS).flatMap(new j0(r100, r101)).flatMap(new k0(r100, r101));
    }

    public c0(Context r100, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r101, TreeNode r102, String r103, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r104, Fragment r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r104, "viewModel");
        Intrinsics.checkNotNullParameter(r105, "viewLifecycleOwner");
        this.f242416a = r100;
        this.f242417b = r101;
        this.f242418c = r102;
        this.f242419d = r103;
        this.f242420e = r104;
        this.f242421f = r105;
        this.f242422g = r106;
        this.f242423h = new WikiDialogs();
        this.f242425j = new CompositeDisposable();
    }
}
