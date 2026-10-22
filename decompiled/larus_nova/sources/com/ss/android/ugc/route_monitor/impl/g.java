package com.ss.android.ugc.route_monitor.impl;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes40.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Instrumentation f454424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f454425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f454426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f454427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f454428e;

    public final void a(Context r100, Intent[] r101) {
        Instrumentation r102 = this.f454424a;
        if (r102 == null) goto L6;
        r102.execStartActivities(r100, this.f454425b, this.f454426c, this.f454427d, r101, this.f454428e);
        return;
    }

    public g(Instrumentation r100, IBinder r101, IBinder r102, Activity r103, Bundle r104) {
        this.f454424a = r100;
        this.f454425b = r101;
        this.f454426c = r102;
        this.f454427d = r103;
        this.f454428e = r104;
    }
}
