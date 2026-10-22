package com.bytedance.reparo.secondary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f267478d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ScheduledExecutorService f267479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Context f267480f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f267481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f267483c;

    static {
        f267478d = new f();
        f267479e = null;
        f267480f = null;
    }

    public static f a() {
        f r100 = f267478d;
        if (r100.f267482b == true) goto L16;
        r100.f267482b = true;
        PolarisFileWrapper r101 = new PolarisFileWrapper(f267480f.getFilesDir(), "reparo-root/localConfig");     // Catch: Throwable -> L10
        if (r101.exists() == false) goto L12;
        r100.f267483c = new JSONObject(w87.b.h(r101));     // Catch: Throwable -> L10
    L12:
        if (r100.f267483c != null) goto L14;
        r100.f267483c = new JSONObject();
    L14:
        f267479e.schedule(new e(r100), 10, TimeUnit.SECONDS);
    L16:
        return f267478d;
    }

    public f() {
        this.f267481a = new HashSet();
        this.f267482b = false;
        this.f267483c = null;
    }

    public final void b(String r100) {
        if (MonitorService.c().getLogTypeSwitch(r100) == false) goto L7;
        this.f267483c.put(r100, 1);     // Catch: JSONException -> L10
        return;
    L15:
        return;
    L7:
        if (this.f267483c.opt(r100) == null) goto L13;
        this.f267483c.remove(r100);
        return;
    }
}
