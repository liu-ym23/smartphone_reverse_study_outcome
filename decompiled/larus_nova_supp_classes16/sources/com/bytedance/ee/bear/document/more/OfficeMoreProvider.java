package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.OverrideUIMoreItemFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeMoreProvider extends BaseMoreProvider {
    public final DocumentPluginHost m;
    public final com.bytedance.ee.bear.more.protocol3.extension.a n;
    public final com.bytedance.ee.bear.more.protocol3.panel.u o;
    public final com.bytedance.ee.bear.more.protocol3.panel.e p;
    public OverrideUIMoreItemFactory q;
    public f1 r;
    public boolean s;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.c b() {
        com.bytedance.ee.bear.more.protocol3.panel.w r1 = this.o.a();
        if (r1 != null) goto L6;
        tt5.a.k("OfficeMoreProvider", "buildMoreItems but config is null, fallback empty");
        return new com.bytedance.ee.bear.more.protocol3.c(CollectionsKt.emptyList());
    L6:
        OverrideUIMoreItemFactory r3 = this.q;
        LinkedHashMap r4 = new LinkedHashMap();
        if (r3 == null) goto L46;
        ItemUIStyle r5 = r1.a;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.d = r5;
        ((LinkedHashMap) r3.e).clear();
        List r6 = r1.b;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        CollectionsKt.addAll(r7, ((com.bytedance.ee.bear.more.protocol3.panel.m) r8.next()).b);
        goto L10
    L12:
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L46;
        com.bytedance.ee.bear.more.protocol3.panel.o r10 = (com.bytedance.ee.bear.more.protocol3.panel.o) r9.next();
        Map r11 = com.bytedance.ee.bear.more.protocol3.panel.s.a;
        String r12 = com.bytedance.ee.bear.more.protocol3.panel.s.a(r10.a);
        com.bytedance.ee.bear.more.protocol3.panel.q r13 = r10.c;
        com.bytedance.ee.bear.more.protocol3.panel.f0 r14 = r10.b;
        if ((r14 instanceof com.bytedance.ee.bear.more.protocol3.panel.f0) == false) goto L18;
        com.bytedance.ee.bear.more.protocol3.panel.f0 r16 = r14;
    L19:
        if (r16 == null) goto L21;
        Function1 r17 = r16.c;
    L22:
        if (r16 == null) goto L24;
        Function1 r18 = r16.d;
    L25:
        if (r16 == null) goto L27;
        Function1 r19 = r16.e;
    L28:
        if (r16 == null) goto L30;
        Function1 r110 = r16.b;
    L31:
        if (r16 == null) goto L33;
        ItemUIStyle r20 = r16.a;
    L34:
        if (r13 == null) goto L36;
        r4.put(r12, r13);
    L36:
        if (r13 != null) goto L44;
        if (r110 != null) goto L44;
        if (r17 != null) goto L44;
        if (r18 != null) goto L44;
        if (r19 != null) goto L44;
        if (r20 != null) goto L44;
    L45:
        r9 = r9;
    L44:
        r3.e.put(r12, new com.bytedance.ee.bear.more.protocol3.panel.k(r13, r110, r17, r18, r19, r20));
        goto L45
    L33:
        r20 = null;
        goto L34
    L30:
        r110 = null;
        goto L31
    L27:
        r19 = null;
        goto L28
    L24:
        r18 = null;
        goto L25
    L21:
        r17 = null;
        goto L22
    L18:
        r16 = null;
    L46:
        f1 r21 = new f1(this.m, this, this.p, r4);
        this.r = r21;
        StringBuilder r22 = new StringBuilder("buildMoreItems, group=");
        r22.append(r1.b.size());
        r22.append(", overrides=");
        if (r3 == null) goto L51;
        Map r23 = r3.e;
        if (r23 == null) goto L51;
        int r24 = r23.size();
    L52:
        r22.append(r24);
        tt5.a.h("OfficeMoreProvider", r22.toString());
        int r2 = com.bytedance.ee.bear.more.protocol3.panel.v.a;
        return com.bytedance.ee.bear.more.protocol3.panel.v.d(this, this.p, r21, r1);
    L51:
        r24 = 0;
        goto L52
    }

    public final void d() {
        super/*com.bytedance.ee.bear.more.protocol3.extension.v*/.d();
        tt5.a.h("OfficeMoreProvider", "create, isWiki=" + this.s);
        k(this.n);
        if (((dn4.a) this.m.getUserComponent().a(dn4.a.class)).a().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.a.a().observe(f().getHostFragment(), new j1(this));
    L6:
        if (this.s == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).d(this.m).subscribe(new h1(this), i1.a);
        return;
    }

    public final void a(sj5.b r12, com.bytedance.ee.bear.more.protocol3.l r13) {
        com.bytedance.ee.bear.more.view3.d r14 = com.bytedance.ee.bear.more.view3.d.a;
        Intrinsics.checkNotNullParameter(r12, "host");
        Intrinsics.checkNotNullParameter(r14, "uiItemFactory");
        this.s = this.m.a().isType(sbb.e.n);
        i r16 = new i(this.m, this.s);
        com.bytedance.ee.bear.more.protocol3.panel.e r0 = this.p;
        Intrinsics.checkNotNullParameter(r0, "registry");
        r16.d(r0, "more.copy_link", CommonMoreItemId.COPY_LINK);
        r0.d("more.share", new v(r16));
        r0.d("more.disassociate", new g0(r16));
        r0.d("more.open_ai_chat", new i0(r16));
        r0.d("more.add_to_nav", new j0(r16));
        r0.d("more.floating_window", new k0(r16));
        r0.d("more.add_to_workbench", l0.a);
        r0.d("more.offline_available", new m0(r16));
        r0.d("more.my_ai", new n0(r16));
        r0.d("more.browser_view", new o0(r16));
        r0.d("more.icon", new l(r16));
        r0.d("more.page_view", new m(r16));
        r0.d("more.page_setting", new n(r16));
        r0.d("more.secret_level", o.a);
        r16.d(r0, "more.follow_updates", CommonMoreItemId.SUBSCRIBE);
        r16.d(r0, "more.subscribe_comment", CommonMoreItemId.SUBSCRIBE_COMMENT);
        r0.d("more.bitable_pro", new p(r16));
        r16.d(r0, "more.permission_setting", CommonMoreItemId.PERMISSION);
        r0.d("more.listen_doc", new q(r16));
        r0.d("more.translate", new r(r16));
        r0.d("more.revision_mode", new s(r16));
        r0.d("more.find_replace", new t(r16));
        r16.d(r0, "more.apply_edit_permission", CommonMoreItemId.APPLY_EDIT_PERMISSION);
        r16.d(r0, "more.rename", CommonMoreItemId.RENAME);
        r0.d("more.history", new u(r16));
        r0.d("more.edition_list", new w(r16));
        r0.d("more.outline", new x(r16));
        r0.d("more.template_type_switch", new y(r16));
        r0.d("more.convert_to_template", new z(r16));
        r0.d("more.time_zone", new a0(r16));
        r0.d("more.download_as", new b0(r16));
        r0.d("more.print", new c0(r16));
        r16.d(r0, "more.retention_label", CommonMoreItemId.RETENTION_LABEL);
        r0.d("more.expired_content", d0.a);
        r0.d("more.freshness", e0.a);
        r16.d(r0, "more.contact_support", CommonMoreItemId.CONTACT_SERVICE);
        r16.d(r0, "more.report", CommonMoreItemId.REPORT);
        r0.d("more.transfer_ownership", f0.a);
        r0.d("more.ai_overview", new h0(r16));
        boolean r2 = false;
        if (r16.b == false) goto L9;
        if (r16.a.a().getOpenSource() == DocsOpenSource.vc) goto L7;
        r2 = true;
    L7:
        r0.d("more.move_to", new v0(r2, r16));
        r0.d("more.pin", new w0(r16));
        r0.d("more.star", new x0(r16));
        r0.d("more.wiki_explore_star", new y0(r16));
        r0.d("more.add_short_cut", new z0(r16));
        r0.d("more.wiki_shortcut", new a1(r16));
        r0.d("more.make_copy", new b1(r16));
        r0.d("more.delete", new c1(r16));
    L12:
        tt5.a.h("BaselineMoreItemFactories", "registerAll done, isWiki=" + r16.b + ", total=" + CollectionsKt.toSet(((LinkedHashMap) r0.a).keySet()).size());
        StringBuilder r17 = new StringBuilder("baseline registered, ids=");
        r17.append(CollectionsKt.toSet(((LinkedHashMap) this.p.a).keySet()).size());
        tt5.a.h("OfficeMoreProvider", r17.toString());
        if (this.o.a() != null) goto L16;
        int r18 = d.a;
        com.bytedance.ee.bear.more.protocol3.panel.u r19 = this.o;
        Intrinsics.checkNotNullParameter(r19, "ability");
        r19.registerMoreConfig(DefaultMoreConfig$apply$1.INSTANCE);
    L16:
        OverrideUIMoreItemFactory r110 = new OverrideUIMoreItemFactory(this.p, new OfficeMoreProvider$attachToHost$proxy$1(this));
        this.q = r110;
        super/*com.bytedance.ee.bear.more.protocol3.h*/.a(r12, r110);
        return;
    L9:
        if (r16.a.a().getOpenSource() == DocsOpenSource.vc) goto L11;
        r2 = true;
    L11:
        r0.d("more.move_to", new p0(r2, r16));
        r0.d("more.pin", new q0(r16));
        r0.d("more.star", new r0(r16));
        r0.d("more.add_short_cut", new s0(r16));
        r0.d("more.make_copy", new t0(r16));
        r0.d("more.delete", new u0(r16));
        goto L12
    }

    public OfficeMoreProvider(DocumentPluginHost r2, com.bytedance.ee.bear.more.protocol3.extension.a r3, com.bytedance.ee.bear.more.protocol3.panel.u r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        Intrinsics.checkNotNullParameter(r4, "morePanelAbility");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = new com.bytedance.ee.bear.more.protocol3.panel.e();
    }
}
