package com.bytedance.router;

import android.os.Bundle;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f267551a;

    public final synchronized String toString() {
        monitor-enter(this);
        String r100 = this.f267551a.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public h(Bundle r100) {
        if (r100 != null) goto L5;
        r100 = new Bundle();
    L5:
        this.f267551a = r100;
    }
}
