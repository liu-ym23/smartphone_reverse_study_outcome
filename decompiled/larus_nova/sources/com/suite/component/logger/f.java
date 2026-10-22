package com.suite.component.logger;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements com.suite.component.logger.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f460139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LinkedList<c> f460140b;

    public f() {
    }

    static {
        f460139a = new f();
        f460140b = new LinkedList();
    }

    @Override // com.suite.component.logger.api.a
    public final Queue<c> a() {
        LinkedList<c> r100 = f460140b;
        monitor-enter(r100);
        LinkedList<c> r101 = f460140b;     // Catch: Throwable -> L7
        f460140b = new LinkedList();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
