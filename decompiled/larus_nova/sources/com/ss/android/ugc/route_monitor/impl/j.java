package com.ss.android.ugc.route_monitor.impl;

import android.app.Fragment;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.ugc.route_monitor.impl.route_out.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public final class j extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f454435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Instrumentation f454436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f454437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f454438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454439e;

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.q
    public final Instrumentation.ActivityResult a(Context r100, Intent r110) {
        Fragment r101 = this.f454435a.get();
        Instrumentation r102 = this.f454436b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.execStartActivity(r100, this.f454437c, this.f454438d, r101, r110, this.f454439e);
    }

    public j(Instrumentation r100, IBinder r101, IBinder r102, Fragment r103, int r104) {
        this.f454436b = r100;
        this.f454437c = r101;
        this.f454438d = r102;
        this.f454439e = r104;
        this.f454435a = new WeakReference(r103);
    }
}
