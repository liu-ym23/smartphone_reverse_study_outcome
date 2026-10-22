package com.bytedance.ies.argus.aspect.eventCenter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.aspect.route.ArgusRouteManager;
import com.bytedance.ies.argus.bean.ArgusRouteRiskType;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends BaseRuntimeContext {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BaseEventCenter f245842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f245844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f245845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, ? extends List<String>> f245846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f245847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f245848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f245849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f245850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f245851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArgusRouteRiskType f245852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.ies.argus.aspect.route.f f245853p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<Activity> f245854q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f245855r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f245856s;

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseRuntimeContext
    public final String g() {
        return KtvSubElement.CONTAINER;
    }

    public e(ArgusContainerDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "containerDelegate");
        this.f245842e = new BaseEventCenter(new d(this));
        this.f245852o = ArgusRouteRiskType.MIDDLE;
        Lazy<ArgusRouteManager> r101 = ArgusRouteManager.f245889h;
        if (ArgusRouteManager.b.a() != null) goto L5;
        com.bytedance.ies.argus.aspect.route.f r102 = null;
    L6:
        this.f245853p = r102;
        return;
    L5:
        r102 = new com.bytedance.ies.argus.aspect.route.f(r100, e());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v2 */
    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.e(r101, "argus_cid", this.f245829b);
        JSONUtilsKt.e(r101, "argus_scene_tag", this.f245831d);
        JSONUtilsKt.e(r101, "seclink_scene", this.f245856s);
        JSONUtilsKt.e(r101, "origin_sec_link_scene", this.f245855r);
        JSONUtilsKt.d(r101, "open_container_class", this.f245843f);
        JSONUtilsKt.d(r101, "container_class", this.f245845h);
        JSONUtilsKt.d(r101, "router_source", this.f245849l);
        JSONUtilsKt.d(r101, "last_ui_page", this.f245850m);
        JSONUtilsKt.d(r101, "intent_extra", String.valueOf(this.f245847j));
        JSONUtilsKt.d(r101, "biz_scene_tag", this.f245851n);
        JSONUtilsKt.d(r101, "web_content_verify_scene", this.f245831d);
        com.bytedance.ies.argus.aspect.route.f r102 = this.f245853p;
        if (r102 == null) goto L24;
        Intrinsics.checkNotNullParameter(r100, "action");
        List<String> r103 = r102.f245916f;
        Lazy<ArgusRouteManager> r104 = ArgusRouteManager.f245889h;
        ArgusRouteManager r105 = ArgusRouteManager.b.a();
        if (r105 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "routeSessionIdChain");
        ?? r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L8:
        if (r107.hasNext() == false) goto L14;
        String r108 = (String) r107.next();
        com.bytedance.ies.argus.aspect.route.a r109 = r105.a(r108);
        if (r109 != null) goto L12;
        r109 = new com.bytedance.ies.argus.aspect.route.a(r108);
    L12:
        r106.add(r109);
    L14:
        if (r106 != 0) goto L16;
        r106 = CollectionsKt.emptyList();
    L16:
        List r110 = CollectionsKt.plus((Collection) r106, r102.f245914d);
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L18:
        if (r112.hasNext() == false) goto L23;
        JSONObject r113 = ((com.bytedance.ies.argus.aspect.route.a) r112.next()).d(r100);
        if (r113 != null) goto L22;
        r113 = new JSONObject();
    L22:
        r111.add(r113);
        goto L18
    L23:
        JSONObject r114 = new JSONObject();
        JSONUtilsKt.d(r114, "first_route_scene", r102.f245914d.f245905e);
        JSONUtilsKt.d(r114, "now_route_scene", r102.f245914d.f245902b);
        JSONUtilsKt.d(r114, "host_deeplink_session_id", r102.f245913c);
        JSONUtilsKt.d(r114, "last_route_chain_info", r111);
    L25:
        JSONUtilsKt.b(r101, false, r114, null);
        return r101;
    L13:
        r106 = 0;
        goto L14
    L24:
        r114 = null;
        goto L25
    }

    public final void i(Uri r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.f245846i != null) goto L7;
    L9:
        this.f245844g = r110;
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = r110.getQuery();
        if (r101 == null) goto L34;
        List r111 = StringsKt.split$default(r101, new String[]{"&"}, false, 0, 6, null);
        if (r111 == null) goto L34;
        Iterator r112 = r111.iterator();
    L15:
        if (r112.hasNext() == false) goto L34;
        String r102 = (String) r112.next();
        if (r102.length() != 0) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L15;
        int r104 = StringsKt.indexOf$default(r102, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        if (r104 <= 0) goto L15;
        if (r104 == (r102.length() - 1)) goto L15;
        String r105 = r102.substring(0, r104);
        Locale r106 = Locale.getDefault();
        if (r105 == null) goto L33;
        String r107 = r105.toLowerCase(r106);
        String r108 = r102.substring(r104 + 1);
        Object r109 = r100.get(r107);
        if (r109 != null) goto L31;
        r109 = new ArrayList();
        r100.put(r107, r109);
    L31:
        ((List) r109).add(r108);
        goto L15
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        r103 = false;
    L34:
        LinkedHashMap r113 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator r114 = r100.entrySet().iterator();
    L36:
        if (r114.hasNext() == false) goto L38;
        Map.Entry r115 = (Map.Entry) r114.next();
        r113.put(r115.getKey(), CollectionsKt.toList((List) r115.getValue()));
        goto L36
    L38:
        this.f245846i = r113;
        return;
    L7:
        if (Intrinsics.areEqual(this.f245844g, r110) == false) goto L9;
    }

    public final void j(String r100) {
        this.f245856s = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f245831d != null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("container sec_link_scene", "updateFrom");
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("container sec_link_scene", "updateFrom");
        this.f245831d = r100;
        int r101 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("RuntimeContext", "set container argus_scene=" + r100 + ", update from: container sec_link_scene");
        com.bytedance.ies.argus.aspect.route.f r102 = this.f245853p;
        if (r102 == null) goto L9;
        com.bytedance.ies.argus.aspect.route.d r103 = r102.f245914d;
    L10:
        if (r103 == null) goto L16;
        r103.f245902b = r100;
        return;
    L16:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void h(String r100, Bundle r101) {
        if (this.f245847j == null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        this.f245845h = r100;
    L7:
        HashMap r102 = new HashMap();
        if (r101 == null) goto L34;
        Iterator<String> r103 = r101.keySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L34;
        String r104 = r103.next();
        String r105 = String.valueOf(r101.get(r104));     // Catch: Exception -> L32
        r102.put(r104, r105.toLowerCase(Locale.getDefault()));     // Catch: Exception -> L32
        if (this.f245849l != null) goto L21;
        if (Intrinsics.areEqual(r104, "key_calling_context") == true) goto L19;
        if (Intrinsics.areEqual(r104, "key_d_calling_context") == false) goto L21;
    L19:
        this.f245849l = r105;     // Catch: Exception -> L32
    L21:
        if (this.f245850m != null) goto L26;
        if (Intrinsics.areEqual(r104, "ui_action_last_page_name_source") == false) goto L26;
        this.f245850m = r105;     // Catch: Exception -> L32
    L26:
        if (Intrinsics.areEqual(r104, "argus_cid") == true) goto L27;
        if (Intrinsics.areEqual(r104, "argus_scene_tag") == false) goto L11;
        this.f245851n = r105;     // Catch: Exception -> L32
        goto L11
    L27:
        f(r105, ArgusBizIdUpdateFrom.BIZ_INTENT_EXTRA);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        int r106 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("TTMStrategy", "parseExtra key=" + r104 + " got error: " + e, null, 12);
    L34:
        this.f245847j = MapsKt.toMap(r102);
    }
}
