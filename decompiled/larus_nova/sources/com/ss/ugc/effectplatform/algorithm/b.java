package com.ss.ugc.effectplatform.algorithm;

import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f457239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f457240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f457241c = null;

    public b() {
    }

    static {
        f457241c = new b();
        f457239a = f.a.f457253a;
    }

    public final void a() {
        if (f457240b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f457240b == true) goto L9;
        f457239a.loadLibrary("newep");     // Catch: Throwable -> L12
        f457240b = true;     // Catch: Throwable -> L12
    L9:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }
}
