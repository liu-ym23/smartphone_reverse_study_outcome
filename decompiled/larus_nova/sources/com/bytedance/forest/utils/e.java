package com.bytedance.forest.utils;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.forest.InternalReporter;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.utils.io.ForestConcurrentBuffer;
import com.bytedance.forest.utils.io.ForestWebStreamingBuffer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f244536h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalReporter f244537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f244538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f244539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f244540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f244541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f244542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f244543g;

    public static final class a {
    }

    static {
        f244536h = new String[]{NetResponse.HEADER_KEY_LOG_ID, OkHttpEventListener.X_TT_TRACE_HOST, OkHttpEventListener.X_TT_TRACE_ID, OkHttpEventListener.X_TT_TRACE_TAG, "date", "x-request-ip", "x-net-info.remoteaddr", "content-encoding", "content-length", com.alipay.sdk.m.p.e.f25658f, "eagleid", "x-link-via", "Ser", "via", "x-cdn-request-id", "x-tos-request-id"};
    }

    public e(Application r100) {
        this.f244543g = new c();
        this.f244537a = new InternalReporter(this);
        this.f244538b = Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
        this.f244539c = r100.getApplicationContext();
        this.f244540d = new ConcurrentHashMap();
        this.f244541e = "";
        this.f244542f = new ConcurrentHashMap();
    }

    public final com.bytedance.forest.model.l a(com.bytedance.forest.model.b r100, Request r101) {
        if (r101.getStreamingLoad() == false) goto L9;
        if (r101.getUseConcurrentBuffer() == true) goto L14;
        com.bytedance.forest.model.l r102 = new ForestWebStreamingBuffer(r100, this, r101.getUseDirectBuffer$forest_release());
    L13:
        return r102;
    L14:
        return new com.bytedance.forest.utils.io.d(r100, this);
    L9:
        if (r101.getUseConcurrentBuffer() == true) goto L15;
        r102 = new ForestBuffer(r100, this, r101.getUseDirectBuffer$forest_release());
        goto L13
    L15:
        return new ForestConcurrentBuffer(r100, this);
    }

    public final void b(String[] r100, Long r101) {
        if (r101 == null) goto L4;
        long r102 = r101.longValue();
    L5:
        int r103 = r100.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        String r105 = r100[r104];
        this.f244540d.put(StringsKt.removePrefix(this.f244541e + '_' + r105, "_"), Long.valueOf(r102));
        r104 = r104 + 1;
        goto L6
    L8:
        return;
    L4:
        r102 = System.currentTimeMillis();
        goto L5
    }
}
