package com.larus.dora.impl.core;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f332215a;

    public k() {
        this.f332215a = new HashSet();
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        ((HashSet) this.f332215a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
