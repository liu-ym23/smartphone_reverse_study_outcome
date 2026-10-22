package com.bytedance.ies.bullet.core;

import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f246516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f246517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f246518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f246519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoadStage f246520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f246521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f246522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f246523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f246524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f246525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a36.a f246526l;

    public k() {
        this(0);
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        this.f246515a = r100;
        this.f246518d = new JSONObject();
        this.f246519e = new JSONObject();
        this.f246520f = LoadStage.BEGIN;
        this.f246521g = GearStrategyConsts.EV_SELECT_BEGIN;
        this.f246522h = "unknown";
        this.f246523i = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();
        this.f246525k = "default_bid";
    }

    public /* synthetic */ k(int r100) {
        this("");
    }

    public final boolean b(JSONObject r100, JSONObject r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.k("Tracert inject, monitorId " + this.f246515a + ", " + r100 + ", " + r101, null, null, 6);
        if (this.f246517c == true) goto L6;
        return false;
    L6:
        if (r100 == null) goto L8;
        g16.c.a(this.f246518d, r100);
    L8:
        if (r101 == null) goto L12;
        g16.c.a(this.f246519e, r101);
        return true;
    L12:
        return true;
    }

    public final void a(String r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "tracertId");
        Intrinsics.checkNotNullParameter(r101, "sdkType");
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.k("Tracert init, monitorId " + this.f246515a, null, null, 6);
        JSONObject r104 = new JSONObject();
        this.f246519e = r104;
        if (r102 == null) goto L5;
        long r105 = r102.longValue();
    L6:
        r104.put("entry_start_timestamp", r105);
        this.f246518d.put("tracert_id", r100);
        this.f246518d.put(HianalyticsBaseData.SDK_TYPE, r101);
        this.f246517c = true;
        return;
    L5:
        r105 = System.currentTimeMillis();
        goto L6
    }
}
