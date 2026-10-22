package com.bytedance.gamecenter.base.order;

import com.bytedance.gamecenter.base.OrderDownloadInfoTrigger;
import com.bytedance.gamecenter.base.r;
import com.ss.android.downloadlib.addownload.model.OrderItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f245032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i.a f245033b;

    @Override // com.bytedance.gamecenter.base.order.i
    public final void d() {
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final void a() {
        this.f245033b = com.bytedance.android.gamecp.common.download.c.f56522a;
    }

    public c() {
        this.f245032a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final JSONArray b(JSONObject r100) {
        return e.d(h.a(), r100);
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final boolean c(OrderItem r100) {
        b r101 = b.a(r100);
        i.a r102 = this.f245033b;
        if (r102 == null) goto L6;
        r101.f245027c = r102.getCurUserId();
    L6:
        return e.a(r101);
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final void e(a r100) {
        i.a r101 = this.f245033b;
        if (r101 == null) goto L5;
        r100.f245020a = r101.getCurUserId();
    L5:
        r100.f245021b = "game";
        e.c(r100);
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter(OrderDownloadInfoTrigger.TAG, "tag");
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final Boolean f(JSONObject r100) {
        return e.b(h.a(), r100);
    }
}
