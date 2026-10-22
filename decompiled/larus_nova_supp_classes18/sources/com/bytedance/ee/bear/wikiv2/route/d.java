package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.extension.LoadDataToCacheExtension;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    public final boolean b;

    public d(com.bytedance.ee.bear.route.d... r3) {
        super(r3);
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        this.b = r4;
        tt5.a.h("WikiRouteInterceptorV2", "isDefaultFoldCheckHit: " + r4);
        return;
    L5:
        if (com.ss.android.lark.base.embedded.f.a() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void i(BearUrl r3) {
        com.bytedance.ee.bear.bitable.preload.k r0 = (com.bytedance.ee.bear.bitable.preload.k) org.koin.java.a.a(com.bytedance.ee.bear.bitable.preload.k.class);     // Catch: Throwable -> L6
        if (r0.a() == false) goto L11;
        r0.preload(r3.e);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        tt5.a.l("WikiRouteInterceptorV2", "preload Bitable data failed", th);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r2, RouteBean r3) {
        if (wo5.c.a("ccm.mobile.android_doc_support_expand_page") == true) goto L5;
        return "/wikiv2/detail/expand/activity";
    L5:
        if (r3 == null) goto L10;
        if (r3.o == false) goto L10;
        return "/wikiv2/detail/expand/activity";
    L10:
        if (this.b == false) goto L12;
        return "/wikiv2/detail/expand/activity";
    L12:
        return "/wikiv2/detail/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r22, BearUrl r23, RouteBean r24) {
        RouteBean r3 = r24;
        if (fx4.a.g(r23) == false) goto L130;
        tt5.a.h("WikiRouteInterceptorV2", "Dispatch wikiUrl.");
        if (g(r22, r23, r24) == true) goto L139;
        String r12 = "";
        if (ForsetiHelper.p() == false) goto L82;
        String r0 = r23.b;
        if (r3 != null) goto L11;
    L16:
        String r11 = "";
        String r13 = r11;
        int r10 = -1;
        String r14 = null;
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
    L23:
        WikiInfo r8 = null;
    L25:
        if (TextUtils.isEmpty(r14) == true) goto L27;
    L42:
        LoadDataToCacheExtension.m(new ce5.a(), r23, r8);
        i(r23);
        if (r3 != null) goto L46;
        r3 = new RouteBean();
    L46:
        if (((Boolean) ForsetiHelper.e.getValue()).booleanValue() == false) goto L64;
        if (ForsetiHelper.k() == false) goto L57;
        if (r8 != null) goto L51;
    L55:
        boolean r1 = false;
    L56:
        r3.s = r1;
        goto L64
    L51:
        if (r8.getObjType() != sbb.e.o.b) goto L53;
    L54:
        r1 = true;
        goto L56
    L53:
        if (r8.getObjType() != sbb.e.i.b) goto L55;
    L57:
        if (r8 != null) goto L59;
    L61:
        boolean r2 = false;
    L62:
        r3.s = r2;
        goto L64
    L59:
        if (r8.getObjType() != sbb.e.o.b) goto L61;
        r2 = true;
    L64:
        if (r23.d != null) goto L66;
    L68:
        boolean r4 = false;
    L69:
        if (r4 == true) goto L71;
    L73:
        PostCard r7 = h(r23, r3, r8, r13);
        r7.e();     // Catch: Throwable -> L76
    L80:
        gq5.c.a(r23.h);
        return true;
    L76:
        th = move-exception;
        if (PostCard.Type.FORSETI.equals(r7.getType()) == false) goto L81;
        tt5.a.e("WikiRouteInterceptorV2", "route by forseti error!", th, !eu5.c.d());
        r3.s = false;
        h(r23, r3, r8, r13).e();
        goto L80
    L81:
        throw th;
    L71:
        if (DowngradeSettingUtil.a("downgradeForsetiTemplatePreview") == true) goto L73;
        r3.s = true;
        goto L73
    L66:
        if (TextUtils.equals(DocsOpenSource.template_preview.name(), (CharSequence) r23.d.get("from")) == false) goto L68;
        r4 = true;
        goto L69
    L27:
        if (TextUtils.isEmpty(r0) == true) goto L42;
        r8 = p0.g(new ce5.a(), r0);
        if (r3 == null) goto L42;
        if ((r3 instanceof WikiRouteBean) == true) goto L42;
        if (r8 == null) goto L42;
        RouteBean r9 = new WikiRouteBean(r8.getObjToken(), r8.getObjType(), r8.getWikiToken(), r8.getSpaceId(), "");
        Bundle r5 = new Bundle();
        r5.putString("wiki_version", "");
        r3.n = r5;
        Field[] r15 = r24.getClass().getDeclaredFields();
        int r16 = r15.length;
        int r17 = 0;
    L34:
        if (r17 >= r16) goto L41;
        Field r6 = r15[r17];
        r6.setAccessible(true);
        r6.set(r9, r6.get(r3));     // Catch: IllegalAccessException -> L38
    L40:
        r17 = r17 + 1;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        r3 = r9;
        goto L42
    L20:
        if (TextUtils.isEmpty(r14) == true) goto L23;
        if (r10 == (-1)) goto L23;
        r8 = new WikiInfo();
        ((Result) r8).code = 0;
        r8.setWikiToken(r0);
        r8.setObjType(r10);
        r8.setObjToken(r14);
        r8.setSpaceId(r11);
        goto L25
    L11:
        if ((r3 instanceof WikiRouteBean) == false) goto L14;
        WikiRouteBean r18 = (WikiRouteBean) r3;
        r11 = r18.y;
        r13 = r18.z;
        r14 = r18.v;
        r10 = r18.w;
        goto L18
    L14:
        if (hu5.a.e(r3.k) == true) goto L16;
        Map<String, String> r19 = r3.k;
        String r110 = r19.get("space_id");
        String r111 = r19.get("space_name");
        String r112 = r19.get(ResourceData.KEY_ID);
        r10 = na5.a.a(r19.get("docType"));
        r14 = r112;
        r11 = r110;
        r13 = r111;
        goto L18
    L82:
        PostCard r20 = d(r23, r3);
        String r21 = r23.b;
        if (r3 != null) goto L85;
    L90:
        String r113 = "";
        String r114 = r113;
        String r25 = null;
        int r115 = -1;
    L92:
        if (TextUtils.isEmpty(r21) == false) goto L94;
    L97:
        WikiInfo r26 = null;
    L98:
        LoadDataToCacheExtension.m(new ce5.a(), r23, r26);
        i(r23);
        if (r3 == null) goto L101;
        Bundle r27 = r3.e;
        Bundle r28 = r3.n;
        int r29 = r3.c;
    L102:
        Map r30 = r23.d;
        if (r30 == null) goto L105;
        String r116 = (String) r30.get("docId");
        String r117 = (String) r23.d.get("sourceType");
        boolean r31 = "template_preview".equals(r23.d.get("from"));
        String r32 = r117;
        r12 = r116;
    L106:
        if (r28 == null) goto L108;
        boolean r33 = r28.getBoolean("force_single_top", false);
    L109:
        boolean r118 = r33;
        r20.i(ResourceData.KEY_URL, r23.e).i("space_id", r113).i("space_name", r114).j(ResourceData.KEY_TYPE, r115).i(ResourceData.KEY_OBJ_TOKEN, r25).n("wiki_info", r26).i("doc_feed_id", r12).i("source_type", r32).c("remind_binder", r27).k(r29).h(r28);
        if (r31 == true) goto L112;
        if (r118 == true) goto L112;
    L114:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L121;
        if (r24 == null) goto L121;
        int r34 = r24.a;
        if (r34 == (-1)) goto L121;
        r20.g(r34, 0);
    L121:
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity() != null) goto L123;
        r20.m(268435456);
    L123:
        if (r28 != null) goto L125;
    L127:
        r20.e();
        gq5.c.a(r23.h);
        return true;
    L125:
        if (r28.getBoolean("popLastDocument", false) == false) goto L127;
        r20.m(536870912);
    L112:
        r20.m(536870912);
        goto L114
    L108:
        r33 = false;
        goto L109
    L105:
        r32 = "";
        r31 = false;
        goto L106
    L101:
        r29 = -1;
        r27 = null;
        r28 = null;
        goto L102
    L94:
        if (TextUtils.isEmpty(r25) == true) goto L97;
        if (r115 == (-1)) goto L97;
        r26 = new WikiInfo();
        ((Result) r26).code = 0;
        r26.setWikiToken(r21);
        r26.setObjType(r115);
        r26.setObjToken(r25);
        r26.setSpaceId(r113);
        goto L98
    L85:
        if ((r3 instanceof WikiRouteBean) == false) goto L88;
        WikiRouteBean r119 = (WikiRouteBean) r3;
        r113 = r119.y;
        r114 = r119.z;
        r25 = r119.v;
        r115 = r119.w;
        goto L92
    L88:
        if (hu5.a.e(r3.k) == true) goto L90;
        Map<String, String> r35 = r3.k;
        String r120 = r35.get("space_id");
        String r121 = r35.get("space_name");
        String r122 = r35.get(ResourceData.KEY_ID);
        r115 = na5.a.a(r35.get("docType"));
        r25 = r122;
        r113 = r120;
        r114 = r121;
        goto L92
    L139:
        return true;
    L130:
        return false;
    }

    public final PostCard h(BearUrl r16, RouteBean r17, WikiInfo r18, String r19) {
        StringBuilder r3 = new StringBuilder("buildWikiPostCard: wikiInfo is null:");
        if (r18 != null) goto L5;
        boolean r6 = true;
    L6:
        r3.append(r6);
        tt5.a.h("WikiRouteInterceptorV2", r3.toString());
        PostCard r4 = d(r16, r17);
        Bundle r7 = r17.e;
        Bundle r8 = r17.n;
        int r9 = r17.c;
        r17.q = RouteBean.DestStyle.FULL_SCREEN;
        if (r8 != null) goto L9;
    L11:
        Map r5 = r16.d;
        String r10 = "";
        if (r5 == null) goto L14;
        String r11 = (String) r5.get("docId");
        String r12 = (String) r16.d.get("sourceType");
        boolean r13 = TextUtils.equals("template_preview", (CharSequence) r16.d.get("from"));
    L15:
        if (r8 == null) goto L17;
        boolean r14 = r8.getBoolean("force_single_top", false);
    L18:
        PostCard r0 = r4.i(ResourceData.KEY_URL, r16.e).o("bear_url", r16);
        if (r18 == null) goto L23;
        WikiInfo.Info r15 = ((Result) r18).data;
        if (r15 == null) goto L23;
        r10 = r15.space_id;
    L23:
        PostCard r1 = r0.i("space_id", r10).i("space_name", r19);
        if (r18 == null) goto L28;
        WikiInfo.Info r110 = ((Result) r18).data;
        if (r110 == null) goto L28;
        int r111 = r110.obj_type;
    L29:
        PostCard r2 = r1.j(ResourceData.KEY_TYPE, r111);
        if (r18 == null) goto L34;
        WikiInfo.Info r112 = ((Result) r18).data;
        if (r112 == null) goto L34;
        String r113 = r112.obj_token;
    L35:
        r2.i(ResourceData.KEY_OBJ_TOKEN, r113).n("wiki_info", r18).i("doc_feed_id", r11).i("source_type", r12).c("remind_binder", r7).k(r9).h(r8);
        if (r13 == true) goto L38;
        if (r14 == true) goto L38;
    L40:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L45;
        int r20 = r17.a;
        if (r20 == (-1)) goto L45;
        r4.g(r20, 0);
    L45:
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity() != null) goto L47;
        r4.m(268435456);
    L47:
        if (r8 != null) goto L49;
    L51:
        return r4;
    L49:
        if (r8.getBoolean("popLastDocument", false) == false) goto L51;
        r4.m(536870912);
    L38:
        r4.m(536870912);
    L34:
        r113 = null;
    L28:
        r111 = -1;
        goto L29
    L17:
        r14 = false;
        goto L18
    L14:
        r11 = "";
        r12 = r11;
        r13 = false;
        goto L15
    L9:
        if (r8.getBoolean("single_top_in_forseti", false) == false) goto L11;
        r17.r = true;
        goto L11
    L5:
        r6 = false;
        goto L6
    }
}
