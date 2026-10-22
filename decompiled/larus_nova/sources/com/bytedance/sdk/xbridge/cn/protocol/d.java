package com.bytedance.sdk.xbridge.cn.protocol;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.utils.ThreadPool;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.huawei.hms.api.FailedBinderCallBack;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final le7.a<DATA> f270074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f270075b;

    public abstract void b(DATA r100);

    public JSONObject a() {
        return new JSONObject();
    }

    public d(le7.a<DATA> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        this.f270074a = r100;
    }

    public final void c(DATA r100) {
        this.f270074a.f508952j = System.currentTimeMillis();
        b(r100);
        this.f270074a.f508951i = System.currentTimeMillis();
        le7.a<DATA> r101 = this.f270074a;
        if ((!StringsKt.isBlank(r101.f508946d)) == false) goto L5;
        String r102 = r101.f508946d;
    L7:
        if (Intrinsics.areEqual(r102, "Loki") == false) goto L14;
        Map<String, Object> r103 = this.f270074a.L;
        Lazy r104 = OptimizeConfigKt.f269934a;
        if (Intrinsics.areEqual(((LinkedHashMap) r103).get("loki_jsb_log_drop_switch"), Boolean.TRUE) == false) goto L14;
        id7.a r105 = id7.c.f489344d.f489348c;
        if (r105 == null) goto L28;
        r105.a(this.f270074a, r100);
        return;
    L28:
        return;
    L14:
        id7.c.f489344d.getClass();
        le7.a<DATA> r106 = this.f270074a;
        if (r106.f508955m == false) goto L17;
    L24:
        int r107 = ce7.a.f23465a;
        le7.a<DATA> r108 = this.f270074a;
        Intrinsics.checkNotNullParameter(r108, NotificationCompat.CATEGORY_CALL);
        ThreadPool.b(new ce7.b(r108));
        id7.a r109 = id7.c.f489344d.f489348c;
        if (r109 == null) goto L29;
        r109.a(this.f270074a, r100);
        return;
    L29:
        return;
    L17:
        if (r106.f508942J == true) goto L24;
        if (Intrinsics.areEqual(r106.f508946d, "webcast") == true) goto L24;
        UGLogger.c r110 = UGLogger.f270252a;
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", this.f270074a.d()), TuplesKt.to("methodName", this.f270074a.f508943a), TuplesKt.to("code", Integer.valueOf(this.f270074a.f508953k)), TuplesKt.to("message", this.f270074a.f508954l), TuplesKt.to("data", a().toString()), TuplesKt.to(FailedBinderCallBack.CALLER_ID, this.f270074a.f508945c)});
        UGLogger.a r112 = new UGLogger.a();
        String r113 = this.f270075b;
        if (r113 != null) goto L23;
        r113 = "";
    L23:
        r112.a("bulletSession", r113);
        r112.a(FailedBinderCallBack.CALLER_ID, this.f270074a.f508945c);
        Unit r114 = Unit.INSTANCE;
        UGLogger.c("BulletSdk", "BDXBridge end handle method", "BridgeResult", r111, r112);
        goto L24
    L5:
        r102 = r101.f508947e;
        goto L7
    }
}
