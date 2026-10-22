package com.bytedance.ies.web.jsbridge2;

import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f249313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimeLineEvent f249314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f249315c;

    public final void a() {
        if (this.f249315c.f249302f == false) goto L22;
        return;
    L22:
        c0 r100 = b.a(this.f249315c, new JSONObject(this.f249313a));     // Catch: JSONException -> L7
    L12:
        if (r100 == null) goto L15;
        List<TimeLineEvent> r101 = r100.f249326k;
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) r101;
        r102.add(this.f249314b);
    L15:
        if (c0.b(r100) == false) goto L20;
        Objects.toString(r100);
        if (r100 == null) goto L24;
        TimeLineEvent.b r103 = new TimeLineEvent.b();
        r103.b("value", this.f249313a);
        r103.b("reason", "call_invalid_1");
        r103.a("label_abstract_bridge_reject", r100.f249326k);
        b r104 = this.f249315c;
        r104.c(r104.h(), r100.f249319d, 3, "call_invalid_1", r100.f249326k);
        this.f249315c.e(n0.a(new JsBridgeException(r100.f249316a, "Failed to parse invocation.")), r100);
        return;
    L24:
        return;
    L20:
        b.b(this.f249315c, r100);
        return;
    L7:
        e = move-exception;
        if (m.f249390a == false) goto L11;
        Log.getStackTraceString(e);
    L11:
        r100 = null;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, String r101, TimeLineEvent r102) {
        this.f249315c = r100;
        this.f249313a = r101;
        this.f249314b = r102;
    }
}
