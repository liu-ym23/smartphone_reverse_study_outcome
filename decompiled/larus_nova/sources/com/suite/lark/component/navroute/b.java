package com.suite.lark.component.navroute;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f460277b;

    @Override // com.suite.lark.component.navroute.a.d
    public final a.e getPriority() {
        return new a.e(Lifecycle.State.CREATED, this.f460277b);
    }

    public b() {
        this.f460277b = SystemClock.elapsedRealtime();
    }
}
