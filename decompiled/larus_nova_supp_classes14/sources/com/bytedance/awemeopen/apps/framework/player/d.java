package com.bytedance.awemeopen.apps.framework.player;

import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements k {
    public static final d a = null;
    public static r14.c b;
    public static final LinkedHashMap<String, r14.c> c = null;
    public static p54.b d;
    public static final LinkedHashMap<String, p54.b> e = null;
    public static final ArrayList<p54.a> f = null;

    public d() {
    }

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void g(String r1, boolean r2, String r3) {
    }

    public final void onPlayPrepare(String r1) {
    }

    static {
        a = new d();
        c = new LinkedHashMap();
        e = new LinkedHashMap();
        f = new ArrayList();
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        LinkedHashMap<String, r14.c> r0 = c;
        r0.remove(r2);
        Map.Entry r1 = (Map.Entry) CollectionsKt.lastOrNull(r0.entrySet());
        p54.b r3 = null;
        if (r1 == null) goto L5;
        r14.c r4 = (r14.c) r1.getValue();
    L6:
        b = r4;
        LinkedHashMap<String, p54.b> r5 = e;
        r5.remove(r2);
        Map.Entry r6 = (Map.Entry) CollectionsKt.lastOrNull(r5.entrySet());
        if (r6 == null) goto L9;
        r3 = (p54.b) r6.getValue();
    L9:
        d = r3;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void h(String r2) {
        Iterator<p54.a> r3 = f.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onVideoPause();
        goto L4
    }

    public final void onPlaying(String r3) {
        Iterator<p54.a> r4 = f.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        p54.a r0 = r4.next();
        r14.c r1 = b;
        if (r1 == null) goto L10;
        Video r2 = r1.P();
        if (r2 == null) goto L10;
        r2.getDuration();
    L10:
        r0.onVideoPlay();
        goto L4
    }

    public static void a(String r1, FeedPlayerHelper r2) {
        Intrinsics.checkNotNullParameter(r1, "page");
        Intrinsics.checkNotNullParameter(r2, "playerController");
        e.put(r1, r2);
        d = r2;
    }

    public static void i(String r1, r14.c r2) {
        Intrinsics.checkNotNullParameter(r1, "page");
        if (r2 != null) goto L5;
        return;
    L5:
        c.put(r1, r2);
        b = r2;
        Iterator<p54.a> r3 = f.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().a();
        goto L7
    }

    public final void l(String r1, l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        Iterator<p54.a> r3 = f.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().e();
        goto L4
    }
}
