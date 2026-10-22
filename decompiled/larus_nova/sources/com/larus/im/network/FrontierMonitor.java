package com.larus.im.network;

import android.os.SystemClock;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.im.internal.p;
import com.larus.platform.api.p2;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class FrontierMonitor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f350571i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f350572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p2 f350573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f350574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f350575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f350576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f350577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.im.trace.b f350578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f350579h;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.im.network.e] */
    public FrontierMonitor(p r100) {
        Intrinsics.checkNotNullParameter(r100, UploadTypeInf.TIMER);
        this.f350572a = r100;
        this.f350578g = new com.larus.im.trace.b();
        this.f350579h = new e(this);
    }

    public final void a(boolean r100) {
        Long r101 = this.f350577f;
        if (r101 == null) goto L10;
        long r102 = r101.longValue();
        this.f350572a.a("WS_LIFE");
        long r103 = SystemClock.elapsedRealtime() - r102;
        if (this.f350576e == false) goto L7;
        String r104 = "online";
    L8:
        com.larus.im.trace.b r105 = this.f350578g;
        vf9.a r106 = new vf9.a(r104, (int) r103);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "info");
        JSONObject r107 = new JSONObject(GsonProtectorUtils.toJson(r105.f350906a, r106, vf9.a.class));
        o.f365780a.reportEvent("ws_life", r107);
        goto L10
    L7:
        r104 = OperationName.OPERATION_OFFLINE_AVAILABLE;
    L10:
        if (r100 == false) goto L12;
        this.f350572a.b(new FrontierMonitor$performLifeReport$2(this, null));
        this.f350577f = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L12:
        this.f350577f = null;
    }
}
