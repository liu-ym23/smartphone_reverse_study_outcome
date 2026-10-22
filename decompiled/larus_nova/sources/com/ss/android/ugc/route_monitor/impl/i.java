package com.ss.android.ugc.route_monitor.impl;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.ugc.route_monitor.impl.route_out.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public final class i extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f454430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Instrumentation f454431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f454432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f454433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454434e;

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.q
    public final Instrumentation.ActivityResult a(Context r100, Intent r110) {
        Activity r101 = this.f454430a.get();
        Instrumentation r102 = this.f454431b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.execStartActivity(r100, this.f454432c, this.f454433d, r101, r110, this.f454434e);
    }

    public i(Instrumentation r100, IBinder r101, IBinder r102, Activity r103, int r104) {
        this.f454431b = r100;
        this.f454432c = r101;
        this.f454433d = r102;
        this.f454434e = r104;
        this.f454430a = new WeakReference(r103);
    }
}
