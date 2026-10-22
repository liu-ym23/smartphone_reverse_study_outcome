package com.bytedance.android.livesdk.livecommerce.opt;

import com.bytedance.android.ec.monitor.duration.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements h {
    public final WeakReference<h> a;

    public c(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = new WeakReference(r2);
    }

    public final void a(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "timestampCache");
        h r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void c(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        h r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void d(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "timestampCache");
        h r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public final void f(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "timestampCache");
        h r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final void b(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "timestampCache");
        h r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public final void e(Exception r3, Map r4) {
        Intrinsics.checkNotNullParameter("ReportDuration has error", "msg");
        Intrinsics.checkNotNullParameter(r3, "e");
        Intrinsics.checkNotNullParameter(r4, "timestampCache");
        h r5 = this.a.get();
        if (r5 == null) goto L6;
        r5.b("ReportDuration has error", r4);
        return;
    }
}
