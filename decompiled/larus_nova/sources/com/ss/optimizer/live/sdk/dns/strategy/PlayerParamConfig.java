package com.ss.optimizer.live.sdk.dns.strategy;

import android.util.Pair;
import java.util.concurrent.ConcurrentHashMap;
import xkc.e;

/* JADX INFO: loaded from: classes40.dex */
public final class PlayerParamConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PlayerParamConfig f457012f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f457013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f457014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair> f457015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f457016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f457017e;

    public static PlayerParamConfig a() {
        if (f457012f != null) goto L15;
        monitor-enter(PlayerParamConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f457012f != null) goto L9;
        f457012f = new PlayerParamConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlayerParamConfig.class);     // Catch: Throwable -> L11
    L15:
        return f457012f;
    }

    public PlayerParamConfig() {
        this.f457013a = null;
        new AnonymousClass1(this);
        this.f457014b = new int[]{8, 7, 6, 5, 4, 3, 2};
        this.f457015c = new ConcurrentHashMap();
        this.f457016d = 600;
        this.f457017e = 1000;
    }
}
