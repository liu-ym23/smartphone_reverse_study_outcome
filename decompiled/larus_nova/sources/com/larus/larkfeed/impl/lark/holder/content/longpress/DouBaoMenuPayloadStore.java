package com.larus.larkfeed.impl.lark.holder.content.longpress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class DouBaoMenuPayloadStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouBaoMenuPayloadStore f355360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DouBaoMenuPayloadStore$payloads$1 f355361b = null;

    public DouBaoMenuPayloadStore() {
    }

    static {
        f355360a = new DouBaoMenuPayloadStore();
        f355361b = new DouBaoMenuPayloadStore$payloads$1();
    }

    public final synchronized c a(yya.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "actionContext");     // Catch: Throwable -> L6
        c r101 = (c) f355361b.get(r100.m().getId());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
