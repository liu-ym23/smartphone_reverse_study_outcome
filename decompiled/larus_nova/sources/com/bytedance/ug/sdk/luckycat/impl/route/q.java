package com.bytedance.ug.sdk.luckycat.impl.route;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class q extends zl7.a<JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f271466b;

    @Override // zl7.a, zl7.n
    public final void a() {
        zl7.i r100 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r100 == null) goto L5;
        r100.e0("SchemaProxyPendingManager.triggerStaticSettingsUpdate");
    L5:
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L8;
        r101.f(this);
    L8:
        SchemaProxyPendingManager r102 = SchemaProxyPendingManager.f271436f;
        SchemaProxyPendingManager.f271434d.removeMessages(1);
        String r103 = this.f271466b.f271453d;
        r102.getClass();
        SchemaProxyPendingManager.c(false, r103, "setting_update_fail");
    }

    @Override // zl7.a, zl7.n
    public void update() {
        zl7.i r100 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r100 == null) goto L5;
        r100.f(this);
    L5:
        SchemaProxyPendingManager r101 = SchemaProxyPendingManager.f271436f;
        SchemaProxyPendingManager.f271434d.removeMessages(1);
        SchemaProxyPendingManager.a(r101, this.f271466b, SchemaProxyPendingReason.STATIC_SETTINGS_UPDATE);
    }

    public q(k r100) {
        this.f271466b = r100;
    }

    public void update(JSONObject r100) {
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L5;
        r101.f(this);
    L5:
        SchemaProxyPendingManager r102 = SchemaProxyPendingManager.f271436f;
        SchemaProxyPendingManager.f271434d.removeMessages(1);
        SchemaProxyPendingManager.a(r102, this.f271466b, SchemaProxyPendingReason.STATIC_SETTINGS_UPDATE);
    }

    @Override // zl7.a, zl7.n
    public /* bridge */ /* synthetic */ void update(Object r100) {
        update((JSONObject) r100);
    }
}
