package com.bytedance.ug.sdk.luckycat.impl.route;

import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class SchemaProxyPendingManager implements com.bytedance.ug.sdk.luckycat.utils.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f271432b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f271433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.ug.sdk.luckycat.utils.j f271434d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static q f271435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SchemaProxyPendingManager f271436f = null;

    static {
        f271431a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SchemaProxyPendingManager.class), "mSchemaProxyPendingConfig", "getMSchemaProxyPendingConfig()Lcom/bytedance/ug/sdk/luckycat/impl/route/SchemaProxyPendingSettingsConfig;"))};
        SchemaProxyPendingManager r100 = new SchemaProxyPendingManager();
        f271436f = r100;
        f271432b = LazyKt.lazy(SchemaProxyPendingManager$mSchemaProxyPendingConfig$2.INSTANCE);
        f271433c = -1;
        f271434d = new com.bytedance.ug.sdk.luckycat.utils.j(Looper.getMainLooper(), r100);
    }

    public SchemaProxyPendingManager() {
    }

    public static r b() {
        Lazy r100 = f271432b;
        KProperty r101 = f271431a[0];
        return (r) r100.getValue();
    }

    @Override // com.bytedance.ug.sdk.luckycat.utils.j.a
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 1) goto L20;
        Object r101 = r100.obj;
        if ((r101 instanceof k) == true) goto L8;
        r101 = null;
    L8:
        k r102 = (k) r101;
        zl7.i r103 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r103 == null) goto L12;
        r103.e0("SchemaProxyPendingManager.handlePendingSchemaProxyTimeOut");
    L12:
        if (r102 != null) goto L14;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", "pending schema is null");
        return;
    L14:
        c(false, r102.f271453d, "timeout");
        zl7.k r104 = r102.f271450a;
        if (r104 == null) goto L17;
        r104.onFail("pending time out");
    L17:
        n.f271464f = null;
        r102.f271452c = true;
        r102.f271451b = null;
        r102.f271450a = null;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", "pending schema is timeout");
        return;
    }

    public static final void a(SchemaProxyPendingManager r110, k r111, SchemaProxyPendingReason r210) {
        r110.getClass();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", "handPendingProxySchema begin");
        r111.getClass();
        if ((System.currentTimeMillis() - r111.f271455f) <= r111.f271454e) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L12;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", "proxy pending schema invalid, pendingSchema: " + r111.f271453d + " pendingMs: " + r111.f271454e);
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L18;
        r101.e0("SchemaProxyPendingManager.handPendingProxySchema");
        return;
    L18:
        return;
    L12:
        d r102 = new d(r111.f271450a);
        Uri.Builder r103 = UriProtector.parse(r111.f271453d).buildUpon();
        r103.appendQueryParameter("schema_pending_reason", r210.getReason());
        gn7.g r104 = new gn7.g(r111.f271451b, r103.build().toString(), r102, null, false, 0, false, null);
        r102.f271441b = r104;
        r111.f271452c = true;
        r111.f271451b = null;
        r111.f271450a = null;
        boolean r105 = gn7.d.a(r104);
        if (r210 != SchemaProxyPendingReason.STATIC_SETTINGS_UPDATE) goto L20;
        if (r105 == false) goto L16;
        c(true, r111.f271453d, "");
        return;
    L16:
        c(false, r111.f271453d, "no_valid_value");
        return;
    L20:
        return;
    L5:
        if (r111.f271452c == true) goto L7;
        r100 = true;
        goto L8
    }

    public static void c(boolean r100, String r101, String r102) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", "reportLuckycatRouteUpdateSettingsEvent");     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        if (r100 == false) goto L6;
        int r104 = 1;
    L7:
        r103.put("result", r104);     // Catch: Throwable -> L9
        r103.put("url", r101);     // Catch: Throwable -> L9
        r103.put("failReason", r102);     // Catch: Throwable -> L9
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("luckycat_route_update_settings_event", r103, true);     // Catch: Throwable -> L9
        return;
    L6:
        r104 = 0;
    L9:
        th = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SchemaProxyPendingManager", th.getMessage());
    }
}
