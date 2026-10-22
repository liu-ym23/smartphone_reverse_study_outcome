package com.bytedance.android.livesdk.livecommerce.playback.video;

import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static WeakReference<e> a;
    public static Set<String> b;

    static {
    }

    public static void a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (b != null) goto L13;
        b = new LinkedHashSet();
    L13:
        Set<String> r2 = b;
        if (r2 == null) goto L17;
        r2.add(r1);
        return;
    L17:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void b(e r2) {
        int r0 = bj2.a.a;
        bj2.a.b("ReplayVideoManager", "setVideoPlayBackPlayController:" + r2);
        a = new WeakReference(r2);
    }
}
