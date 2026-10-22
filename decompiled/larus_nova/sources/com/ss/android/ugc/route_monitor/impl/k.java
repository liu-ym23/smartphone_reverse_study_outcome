package com.ss.android.ugc.route_monitor.impl;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.route_monitor.impl.route_out.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public final class k extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f454440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Instrumentation f454441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f454442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f454443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f454445f;

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.q
    public final Instrumentation.ActivityResult a(Context r110, Intent r111) {
        Activity r100 = this.f454440a.get();
        Instrumentation r101 = this.f454441b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.execStartActivity(r110, this.f454442c, this.f454443d, r100, r111, this.f454444e, this.f454445f);
    }

    public k(Instrumentation r100, IBinder r101, IBinder r102, Activity r103, int r104, Bundle r105) {
        this.f454441b = r100;
        this.f454442c = r101;
        this.f454443d = r102;
        this.f454444e = r104;
        this.f454445f = r105;
        this.f454440a = new WeakReference(r103);
    }
}
