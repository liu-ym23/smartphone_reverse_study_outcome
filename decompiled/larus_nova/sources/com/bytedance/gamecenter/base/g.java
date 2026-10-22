package com.bytedance.gamecenter.base;

import com.ss.android.downloadlib.addownload.model.OrderItem;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements com.bytedance.gamecenter.base.order.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.gamecenter.base.order.i f244982a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f244983a = null;

        static {
            f244983a = new g();
        }
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final void a() {
        this.f244982a.a();
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final void d() {
        this.f244982a.d();
    }

    public g() {
        if (w.f() == false) goto L5;
        this.f244982a = new com.bytedance.gamecenter.base.order.d();
        return;
    L5:
        this.f244982a = new com.bytedance.gamecenter.base.order.c();
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final JSONArray b(JSONObject r100) {
        return this.f244982a.b(r100);
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final boolean c(OrderItem r100) {
        return this.f244982a.c(r100);
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final void e(com.bytedance.gamecenter.base.order.a r100) {
        this.f244982a.e(r100);
    }

    @Override // com.bytedance.gamecenter.base.order.i
    public final Boolean f(JSONObject r100) {
        return this.f244982a.f(r100);
    }
}
