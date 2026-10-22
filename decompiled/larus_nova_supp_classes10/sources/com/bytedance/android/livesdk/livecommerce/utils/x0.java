package com.bytedance.android.livesdk.livecommerce.utils;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x0 {
    public static volatile x0 b;
    public final Subject<Object> a;

    public static x0 a() {
        if (b != null) goto L15;
        monitor-enter(x0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new x0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(x0.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public x0() {
        this.a = PublishSubject.create().toSerialized();
    }
}
