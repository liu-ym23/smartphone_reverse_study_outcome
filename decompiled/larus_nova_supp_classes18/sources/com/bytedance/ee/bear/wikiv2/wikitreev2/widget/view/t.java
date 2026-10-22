package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiDeletePlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFavoritePlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiPinPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements WikiDialogs.b {
    public final Context a;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;
    public final TreeNode c;
    public final Fragment d;
    public final boolean e;
    public final PluginHost f;
    public final NetService g;
    public final WikiDialogs h;
    public long i;
    public final CompositeDisposable j;

    public static final class a {
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ t a;
        public final /* synthetic */ SpaceInfo b;

        public b(t r1, SpaceInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r9) {
            WikiDeletePlugin r10 = (WikiDeletePlugin) r9;
            Intrinsics.checkNotNullParameter(r10, "plugin");
            t r0 = this.a;
            WikiDialogs r1 = r0.h;
            Context r2 = r0.getContext();
            t r3 = this.a;
            TreeNode r4 = r3.c;
            if (r4 == null) goto L5;
            WikNodePerm r5 = r4.perm;
        L6:
            w r6 = new w(r10, r3);
            SpaceInfo r11 = this.b;
            if (r11 != null) goto L9;
        L11:
            boolean r12 = false;
        L12:
            SpaceInfo r7 = this.b;
            if (r7 == null) goto L15;
            String r8 = r7.getSpaceName();
        L16:
            r1.h(r2, r4, r5, r6, r12, r8);
            return;
        L15:
            r8 = null;
            goto L16
        L9:
            if (r11.isMyLib() != true) goto L11;
            r12 = true;
            goto L12
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public c(boolean r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r3) {
            WikiPinPlugin r4 = (WikiPinPlugin) r3;
            Intrinsics.checkNotNullParameter(r4, "plugin");
            if (this.a == false) goto L5;
            r4.pin(this.b, this.c);
            return;
        L5:
            r4.unpin(this.b, this.c);
        }
    }

    public static final class d<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t b;

        public d(boolean r1, t r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r4) {
            WikiFavoritePlugin r5 = (WikiFavoritePlugin) r4;
            Intrinsics.checkNotNullParameter(r5, "plugin");
            String r1 = "";
            if (this.a == false) goto L15;
            TreeNode r0 = this.b.c;
            if (r0 == null) goto L8;
            String r2 = r0.space_id;
            if (r2 == null) goto L8;
        L9:
            if (r0 == null) goto L14;
            String r3 = r0.wiki_token;
            if (r3 == null) goto L14;
            r1 = r3;
        L14:
            r5.favorite(r2, r1);
            return;
        L8:
            r2 = "";
            goto L9
        L15:
            TreeNode r6 = this.b.c;
            if (r6 == null) goto L19;
            String r7 = r6.space_id;
            if (r7 == null) goto L19;
        L20:
            if (r6 == null) goto L25;
            String r8 = r6.wiki_token;
            if (r8 == null) goto L25;
            r1 = r8;
        L25:
            r5.unfavorite(r7, r1);
            return;
        L19:
            r7 = "";
            goto L20
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ t a;
        public final /* synthetic */ WikNodePerm b;
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j c;

        public e(t r1, WikNodePerm r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.k(this.b, this.c);
        }
    }

    public static final class f implements View.OnClickListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("WikiFolderBlockMoreViewDelegate", "showRemoveFromWikiConfirmDialog()...click cancel");
        }
    }

    public static final class g implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ t c;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r2) {
                Boolean r3 = (Boolean) r2;
                tt5.a.h("WikiFolderBlockMoreViewDelegate", "WikiTreeModel.rename, success");
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ t a;

            public b(t r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                tt5.a.e("WikiFolderBlockMoreViewDelegate", "WikiTreeModel.rename, rename fail. ", (Throwable) r4, false);
                Toast.showFailureText(this.a.getContext(), 2131887815);
            }
        }

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "text");
            if (this.a == false) goto L5;
            r10 = r10 + com.bytedance.ee.util.io.a.b(this.b);
        L5:
            String r1 = r10;
            t r11 = this.c;
            CompositeDisposable r7 = r11.j;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r12 = r11.b;
            r7.add(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.f(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.q(r1, r12.b, r12.c, Integer.valueOf(r12.d), this.c.b.e(), this.c.g)).subscribe(a.a, new b(this.c)));
        }

        public g(boolean r1, String r2, t r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void a() {
        Bundle r10 = new Bundle();
        r10.putString("src_token", this.b.b);
        r10.putInt("src_obj_type", this.b.d);
        r10.putBoolean("src_origin_external", this.b.m);
        TreeNode r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getOriginTitle();
        if (r1 == null) goto L6;
    L7:
        r10.putString("title", r1);
        r10.putInt("EXTRA_PAGE_MODE", 3);
        r10.putBoolean("src_is_shortcut", this.b.e());
        r10.putString("src_origin_token", this.b.b());
        r10.putString("trigger_location", "wiki_tree");
        String r2 = null;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.d.getActivity());
        Fragment r3 = this.d;
        Context r4 = this.a;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r5 = this.b;
        String r6 = r5.b;
        String r7 = r5.b();
        boolean r8 = this.b.e();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r9 = this.b;
        String r11 = r9.c;
        int r12 = r9.d;
        String r13 = r9.e;
        boolean r14 = this.e;
        TreeNode r15 = this.c;
        if (r15 == null) goto L12;
        WikiDetailInfo r16 = r15.detail_info;
        if (r16 == null) goto L12;
        r2 = r16.owner_id;
    L12:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.d(r3, r4, r6, r7, r8, r11, r12, r13, 4025, r10, r14, t4.a(r2)));
        return;
    L6:
        r1 = this.b.e;
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
        this.h.k(this.a, r3, new g(r1, r2, this));
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
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        TreeNode r2 = this.c;
        String r3 = null;
        if (r2 == null) goto L5;
        WikNodePerm r12 = r2.perm;
    L6:
        if (r12 != null) goto L9;
        tt5.a.h("WikiFolderBlockMoreViewDelegate", "doMoveTo, perm not found. return. ");
        return;
    L9:
        Bundle r14 = new Bundle();
        r14.putInt("srcIsLock", r12.is_locked ? 1 : 0);
        r14.putString("src_space_id", r1.a);
        r14.putString("src_parent_token", this.b.f);
        r14.putString("src_token", r1.b);
        r14.putInt("src_obj_type", r1.d);
        r14.putInt("EXTRA_PAGE_MODE", 2);
        r14.putString("trigger_location", "wiki_tree");
        r14.putBoolean("src_is_shortcut", r1.e());
        r14.putBoolean("src_is_from_folderblock", true);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.d.getActivity());
        qc5.a.j();
        if (r1.e() == true) goto L17;
        Fragment r5 = this.d;
        Context r6 = this.a;
        String r7 = r1.a;
        String r8 = r1.f;
        String r9 = r1.b;
        boolean r10 = r1.k;
        String r11 = r1.e;
        boolean r15 = this.e;
        TreeNode r4 = this.c;
        if (r4 == null) goto L16;
        WikiDetailInfo r13 = r4.detail_info;
        if (r13 == null) goto L16;
        r3 = r13.owner_id;
    L16:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r5, r6, r7, r8, r9, r10, r11, r12, 1031, r14, r15, t4.a(r3), r1.c, r1.d));
        return;
    L17:
        SelectorConfig r16 = new SelectorConfig();
        r16.c(SelectorType.WIKI_MOVE_TO);
        r16.a(SelectorScope.WIKI_ONLY);
        r16.g = 1031;
        r16.d = true;
        Context r17 = this.a;
        if (r17 == null) goto L21;
        String r18 = r17.getString(2131889814);
        if (r18 == null) goto L21;
    L22:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.b = r18;
        r14.putParcelable("extra_config", r16);
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.f(this.d, r14);
        gq5.d.j("move_to", r1.a);
        return;
    L21:
        r18 = "";
        goto L22
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void i() {
        Context r0 = this.d.getContext();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        TreeNode r2 = this.c;
        Boolean r3 = null;
        if (r2 == null) goto L5;
        WikNodePerm r4 = r2.perm;
    L6:
        StringBuilder r5 = new StringBuilder("doRemoveFromWiki()...can_move = ");
        if (r4 == null) goto L9;
        r3 = Boolean.valueOf(r4.can_move);
    L9:
        r5.append(r3);
        tt5.a.h("WikiFolderBlockMoreViewDelegate", r5.toString());
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L12;
        k(r4, r1);
        return;
    L12:
        this.h.n(r0, r1.k, new e(this, r4, r1), f.a);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void b(SpaceInfo r25) {
        Bundle r14 = new Bundle();
        r14.putString("src_space_id", this.b.a);
        r14.putString("src_parent_token", this.b.f);
        TreeNode r1 = this.c;
        if (r1 == null) goto L6;
        String r2 = r1.getOriginTitle();
        if (r2 == null) goto L6;
    L7:
        r14.putString("title", r2);
        r14.putString("src_token", this.b.b);
        r14.putInt("src_obj_type", this.b.d);
        r14.putInt("EXTRA_PAGE_MODE", 4);
        r14.putString("trigger_location", "wiki_tree");
        r14.putBoolean("src_is_shortcut", this.b.e());
        r14.putBoolean("src_origin_external", this.b.m);
        r14.putString("src_origin_token", this.b.b());
        r14.putString("src_origin_space_id", this.b.j);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.d.getActivity());
        qc5.a.j();
        Fragment r3 = this.d;
        Context r4 = this.a;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r5 = this.b;
        String r6 = r5.b;
        String r7 = r5.b();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r8 = this.b;
        String r9 = r8.a;
        String r10 = r8.j;
        if (r25 == null) goto L10;
        String r11 = r25.getSpaceName();
    L11:
        boolean r12 = this.b.e();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r13 = this.b;
        String r15 = r13.f;
        String r16 = r13.c;
        int r17 = r13.d;
        TreeNode r18 = this.c;
        if (r18 == null) goto L15;
        String r19 = r18.getOriginTitle();
        if (r19 == null) goto L15;
    L16:
        String r110 = r19;
        boolean r20 = this.e;
        TreeNode r21 = this.c;
        if (r21 == null) goto L21;
        WikiDetailInfo r22 = r21.detail_info;
        if (r22 == null) goto L21;
        String r23 = r22.owner_id;
    L22:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.c(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.a(r3, r4, r6, r7, r9, r10, r11, r12, r15, r16, r17, r110, 0, 4026, r14, r20, true, t4.a(r23)));
        return;
    L21:
        r23 = null;
    L15:
        r19 = this.b.e;
        goto L16
    L10:
        r11 = null;
    L6:
        r2 = this.b.e;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void c(boolean r4) {
        this.f.findPluginToDo(WikiFavoritePlugin.class, new d(r4, this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void d(SpaceInfo r4) {
        this.f.findPluginToDo(WikiDeletePlugin.class, new b(this, r4));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void g(boolean r6) {
        String r0 = this.b.b();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        if (r1.m == false) goto L5;
        int r2 = r1.d;
    L6:
        this.f.findPluginToDo(WikiPinPlugin.class, new c(r6, r0, r2));
        return;
    L5:
        r2 = 16;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs.b
    public final void h(boolean r4) {
        TreeNode r0 = this.c;
        if (r0 == null) goto L6;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a(this.a, r0, r4, true);
        return;
    }

    public final void k(WikNodePerm r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r6) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        Context r7 = this.a;
        Toast.showLoading(r7, this.d.getString(2131888333));
        this.i = System.currentTimeMillis();
        Disposable r8 = new MoveToSpacePuller(this.g).d(new MoveToSpacePuller.Params(r6.b, "")).flatMap(new z(this)).subscribe(new a0(r7, this), new b0(r7, this));
        this.j.add(r8);
        return;
    L9:
        Context r9 = this.a;
        Toast.showLoading(r9, this.d.getString(2131887769));
        Disposable r10 = new GetMoveNodeAuthorizedUserInfoPuller(this.g).d(new GetMoveNodeAuthorizedUserInfoPuller.Params(r6.b, r6.a)).subscribe(new u(this, r6), new v(r9, this, r6));
        this.j.add(r10);
        return;
    L5:
        if (r5.can_move != true) goto L7;
        r0 = true;
        goto L7
    }

    public static final Flowable j(t r5, String r6, long r7) {
        r5.getClass();
        if ((System.currentTimeMillis() - r5.i) <= 30000) goto L5;
        tt5.a.d("WikiFolderBlockMoreViewDelegate", "pollingMoveToSpaceStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r7, TimeUnit.MILLISECONDS).flatMap(new x(r5, r6)).flatMap(new y(r5, r6));
    }

    public t(Context r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3, TreeNode r4, WebFragment r5, PluginHost r6, NetService r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r5, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "pluginHost");
        Intrinsics.checkNotNullParameter(r7, "netService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
        this.f = r6;
        this.g = r7;
        this.h = new WikiDialogs();
        this.j = new CompositeDisposable();
    }
}
