package com.bytedance.live.artist.utils;

import java.util.HashMap;
import vk6.g;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Long> f254856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kf6.a f254857b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f254857b = g.f555528a;
        this.f254856a = new HashMap();
    }

    public final void a(String r100) {
        long r101 = System.nanoTime();
        Long r102 = this.f254856a.get(r100);
        if (r102 == null) goto L6;
        long r103 = (r101 - r102.longValue()) / 1000000;
        this.f254857b.debug("TimeCost", "method: " + r100 + " use time " + r103 + " ms");
        return;
    }
}
