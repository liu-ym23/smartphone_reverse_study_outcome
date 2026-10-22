package com.lynx.tasm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f383571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f383572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f383573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f383574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f383575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f383576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f383577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, a8a.a> f383578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f383579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f383580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f383581k;

    public r0(int r100, String r101, long r102, long r103, long r110, long r111, Map r112, long r113, long r114, String r210) {
        this.f383571a = r100;
        this.f383572b = null;
        this.f383573c = r101;
        this.f383574d = r102;
        this.f383575e = r103;
        this.f383576f = r110;
        this.f383577g = r111;
        if (r112 != null) goto L5;
    L8:
        this.f383578h = Collections.emptyMap();
    L9:
        this.f383579i = r113;
        this.f383580j = r114;
        this.f383581k = r210;
        return;
    L5:
        if (r112.isEmpty() == true) goto L8;
        this.f383578h = Collections.unmodifiableMap(new HashMap(r112));
        goto L9
    }
}
