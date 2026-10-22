package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, AtomicBoolean> f271253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f271254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f271255c;

    public b(j r100, String... r101) {
        this.f271255c = r100;
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(TuplesKt.to(r101[r104], new AtomicBoolean(false)));
        r104 = r104 + 1;
        goto L3
    L5:
        this.f271253a = MapsKt.toMap(r102);
        this.f271254b = new AtomicBoolean(false);
    }
}
