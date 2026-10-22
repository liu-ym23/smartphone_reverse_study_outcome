package com.bytedance.sync.v2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import xf7.t;

/* JADX INFO: loaded from: classes3.dex */
public class WsMonitor implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f270383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f270384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f270385c;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAnyActivityPause() {
        zf7.b.a("WsMonitor ON_PAUSE");
        this.f270385c = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAnyActivityResume() {
        zf7.b.a("WsMonitor ON_RESUME");
        this.f270385c = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAnyActivityStart() {
        zf7.b.a("WsMonitor ON_START");
        this.f270385c = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAnyActivityStop() {
        zf7.b.a("WsMonitor ON_STOP");
        this.f270385c = true;
    }

    public WsMonitor() {
        this.f270384b = new AtomicBoolean(false);
    }

    public final void a(long r100) {
        boolean r101 = false;
        if (this.f270384b.compareAndSet(false, true) == false) goto L23;
        JSONObject r102 = new JSONObject();
        if (r100 > 0) goto L21;
        r101 = true;
    L21:
        r102.put("socket_connected_when_start", r101);     // Catch: JSONException -> L10
        r102.put("foreground_may_launch", this.f270385c);     // Catch: JSONException -> L10
    L12:
        JSONObject r103 = new JSONObject();
        r103.put("time", r100);     // Catch: JSONException -> L15
    L17:
        t.a("sync_sdk_ws_connect_ts", r102, r103, null);
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
