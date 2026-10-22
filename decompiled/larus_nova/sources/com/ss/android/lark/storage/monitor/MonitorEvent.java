package com.ss.android.lark.storage.monitor;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class MonitorEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f441096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f441097c;

    public boolean b() {
        return false;
    }

    public Map<String, Object> c() {
        HashMap r100 = new HashMap();
        long r101 = this.f441096b;
        if (r101 < 0) goto L5;
        r100.put("cost_total", Long.valueOf(r101));
    L5:
        return r100;
    }

    public final void a() {
        final Map<String, ? extends Object> r100 = c();
        if (b() == true) goto L7;
        int r101 = b.a.f441106a;
        String r102 = this.f441097c;
        Function0<String> r103 = new MonitorEvent$send$1$1(this, r100);
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "block");
        b.f441102a.getClass();
        a r104 = b.f441103b;
        if (r104 == null) goto L9;
        r104.sendEvent(this.f441095a, r100);
        return;
    L9:
        return;
    L7:
        int r105 = b.a.f441106a;
        String r106 = this.f441097c;
        String r107 = "skiped report event: " + this.f441095a + ' ';
        Intrinsics.checkNotNullParameter(r106, "tag");
        Intrinsics.checkNotNullParameter(r107, "message");
        b.f441102a.getClass();
    }

    public MonitorEvent(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f441095a = r100;
        this.f441096b = r101;
        this.f441097c = "MonitorEvent";
    }
}
