package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.android.live.liveinteract.plantform.utils.c0;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public final com.bytedance.android.live.pushstream.d a;
    public final c0 b;

    public static final class a {
    }

    static {
    }

    public f(com.bytedance.android.live.pushstream.d r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.a = r2;
        this.b = r3;
    }

    public final void a(String r9, JSONObject r10) {
        c0 r0 = this.b;
        if (r0 != null) goto L5;
        this.a.c1(r9, r10, 1, false, false);
        return;
    L5:
        if (d0.b == true) goto L7;
    L8:
        if (r10 == null) goto L10;
        r10.put("sync_index", c0.c.incrementAndGet());
    L10:
        Iterator r1 = r0.a.iterator();
    L12:
        if (r1.hasNext() == false) goto L17;
        ((com.bytedance.android.live.liveinteract.plantform.utils.q) r1.next()).a(r9, r10);
        goto L12
    L17:
        return;
    L7:
        if (r0.b == false) goto L10;
        goto L8
    }
}
