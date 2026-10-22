package com.tencent.open.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static h f461725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Random f461726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<Serializable> f461727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<Serializable> f461728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected HandlerThread f461729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Handler f461730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Executor f461731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Executor f461732h;

    public void b() {
    }

    public static synchronized h a() {
        monitor-enter(h.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f461725a != null) goto L7;
        f461725a = new h();     // Catch: Throwable -> L10
    L7:
        h r100 = f461725a;     // Catch: Throwable -> L10
        monitor-exit(h.class);
        return r100;
    }

    public Map<String, String> c() {
        List<Serializable> r100 = g.b("report_via");
        if (r100 == null) goto L5;
        this.f461728d.addAll(r100);
    L5:
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f461728d.size());
        if (this.f461728d.size() != 0) goto L8;
        return null;
    L8:
        JSONArray r101 = new JSONArray();
        Iterator<Serializable> r102 = this.f461728d.iterator();
    L10:
        if (r102.hasNext() == false) goto L23;
        Serializable r103 = r102.next();
        JSONObject r104 = new JSONObject();
        c r105 = (c) r103;
        Iterator<String> r106 = r105.f461721a.keySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L22;
        String r107 = r106.next();
        String r110 = r105.f461721a.get(r107);     // Catch: JSONException -> L20
        if (r110 != null) goto L18;
        r110 = "";
    L18:
        r104.put(r107, r110);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
        goto L13
    L22:
        r101.put(r104);
        goto L10
    L23:
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + r101.toString());
        JSONObject r108 = new JSONObject();
        r108.put("data", r101);     // Catch: JSONException -> L27
        HashMap r109 = new HashMap();
        r109.put("data", r108.toString());
        return r109;
    L27:
        e = move-exception;
        SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
        return null;
    }

    private h() {
        this.f461729e = null;
        this.f461726b = new SecureRandom();
        this.f461728d = Collections.synchronizedList(new ArrayList());
        this.f461727c = Collections.synchronizedList(new ArrayList());
        this.f461731g = l.b();
        this.f461732h = l.b();
        if (this.f461729e != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("opensdk.report.handlerthread", 10);
        this.f461729e = r100;
        ThreadMethodProxy.start(r100);
    L6:
        if (ThreadMethodProxy.isAlive(this.f461729e) == true) goto L8;
        return;
    L8:
        if (this.f461729e.getLooper() == null) goto L12;
        final Looper r101 = this.f461729e.getLooper();
        this.f461730f = new AnonymousClass1(this, r101);
        return;
    }

    public void d() {
        if (m.b(com.tencent.open.utils.g.a()) == true) goto L5;
        return;
    L5:
        this.f461731g.execute(new AnonymousClass3(this));
    }

    public int a(int r100) {
        if (r100 != 0) goto L7;
        int r101 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportFrequencySuccess");
        if (r101 != 0) goto L11;
        return 10;
    L11:
        return r101;
    L7:
        int r102 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportFrequencyFailed");
        if (r102 != 0) goto L13;
        return 100;
    L13:
        return r102;
    }

    public boolean a(String r100, String r101) {
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + r100 + " | ext: " + r101);
        boolean r102 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        int r103 = 100;
        if (r100.equals("report_cgi") == false) goto L13;
        int r104 = a(CastIntegerProtector.parseInt(r101));
        if (this.f461726b.nextInt(100) >= r104) goto L17;
        r102 = true;
    L17:
        r103 = r104;
    L18:
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + r102 + " | frequency: " + r103);
        return r102;
    L11:
        return false;
    L13:
        if (r100.equals("report_via") == false) goto L18;
        r104 = f.a(r101);
        if (this.f461726b.nextInt(100) >= r104) goto L17;
        r103 = r104;
        r102 = true;
        goto L18
    }

    public boolean a(String r100, int r101) {
        int r102 = 5;
        if (r100.equals("report_cgi") == false) goto L9;
        int r103 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportMaxcount");
        if (r103 == 0) goto L14;
    L7:
        r102 = r103;
    L14:
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + r100 + " | dataSize: " + r101 + " | maxcount: " + r102);
        if (r101 < r102) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r100.equals("report_via") == false) goto L13;
        r103 = i.a(com.tencent.open.utils.g.a(), null).a("Agent_ReportBatchCount");
        if (r103 != 0) goto L7;
    L13:
        r102 = 0;
        goto L14
    }

    public void a(final String r100, final Map<String, String> r101) {
        if (m.b(com.tencent.open.utils.g.a()) == true) goto L5;
        return;
    L5:
        l.b(new AnonymousClass4(this, r100, r101));
    }

    public void a(final Bundle r100, String r101, final boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + r100.toString());
        if (a("report_via", r101) == true) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        this.f461731g.execute(new AnonymousClass2(this, r100, r102));
    }

    public void a(String r110, long r111, long r112, long r113, int r114) {
        a(r110, r111, r112, r113, r114, "", false);
    }

    public void a(String r100, long r101, long r102, long r103, int r104, String r110, boolean r111) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + r100 + " | startTime: " + r101 + " | reqSize:" + r102 + " | rspSize: " + r103 + " | responseCode: " + r104 + " | detail: " + r110);
    }
}
