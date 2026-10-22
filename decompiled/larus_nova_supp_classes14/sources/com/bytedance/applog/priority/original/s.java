package com.bytedance.applog.priority.original;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public final long a;
    public final long b;
    public final int c;
    public final long d;

    public s(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        long r0 = r6.optLong("max_event_size");
        if (r0 > 0) goto L6;
        r0 = 1048576;
    L6:
        this.a = r0;
        long r1 = r6.optLong("max_request_body_size");
        if (r1 > 0) goto L10;
        r1 = 3145728;
    L10:
        this.b = r1;
        int r2 = r6.optInt("max_request_event_count");
        if (r2 > 0) goto L14;
        r2 = ECDraweeView.ROUND;
    L14:
        this.c = r2;
        long r3 = r6.optLong("event_ttl");
        if (r3 > 0) goto L18;
        r3 = 604800;
    L18:
        this.d = r3;
    }
}
