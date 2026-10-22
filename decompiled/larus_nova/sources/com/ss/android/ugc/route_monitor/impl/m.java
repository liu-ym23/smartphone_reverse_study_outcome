package com.ss.android.ugc.route_monitor.impl;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.route_monitor.impl.route_out.q;

/* JADX INFO: loaded from: classes40.dex */
public final class m extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Instrumentation f454481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f454482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f454483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f454486f;

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.q
    public final Instrumentation.ActivityResult a(Context r100, Intent r110) {
        Instrumentation r101 = this.f454481a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.execStartActivity(r100, this.f454482b, this.f454483c, this.f454484d, r110, this.f454485e, this.f454486f);
    }

    public m(Instrumentation r100, IBinder r101, IBinder r102, String r103, int r104, Bundle r105) {
        this.f454481a = r100;
        this.f454482b = r101;
        this.f454483c = r102;
        this.f454484d = r103;
        this.f454485e = r104;
        this.f454486f = r105;
    }
}
