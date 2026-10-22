package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f259723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Number f259724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f259725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f259726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f259727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f259728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f259729g;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> a() {
        Map<String, String> r100 = new LinkedHashMap();
        String r101 = this.f259727e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if ((!r103) == true) goto L26;
    L17:
        String r104 = this.f259725c;
        if (r104 != null) goto L20;
    L21:
        r102 = true;
    L23:
        if ((!r102) == false) goto L25;
        r100.put("filter_coupon_ids", this.f259725c);
    L25:
        return r100;
    L20:
        if (r104.length() != 0) goto L23;
    L26:
        Map r105 = com.bytedance.ies.xbridge.utils.e.b(new JSONObject(this.f259727e));     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L13
        r100 = MapsKt.toMutableMap(r105);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        if (LiveLifeSaaSUtil.A() == false) goto L17;
        LiveLifeSaaSUtil.t().e("CouponMigrationInfo", e);
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final boolean b() {
        if (Intrinsics.areEqual(this.f259724b, 2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f259724b, 3) == true) goto L8;
        return false;
    }

    public i() {
        this.f259723a = "icon";
        this.f259724b = 1;
        this.f259726d = "life_icon_click";
        this.f259729g = -1;
    }
}
