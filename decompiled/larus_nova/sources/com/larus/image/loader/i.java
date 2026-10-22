package com.larus.image.loader;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f350977a;

    public /* synthetic */ i(h r100) {
        this.f350977a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f350977a;
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("is_empty", r100.f350970a);
        r102.put("origin_url", r100.f350971b);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, r100.f350972c);
        r102.put("image_key", r100.f350973d);
        r102.put("renew_url", r100.f350974e);
        r102.put("biz_tag", r100.f350975f);
        r102.put("err_code", r100.f350976g);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("image_renew_url_monitor", r102);
    }
}
