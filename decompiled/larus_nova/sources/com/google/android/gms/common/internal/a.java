package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f274528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static t f274529b;

    static {
        f274528a = new Object();
    }

    public a() {
    }

    public abstract void a(q r100, ServiceConnection r101);

    public abstract boolean b(q r100, ServiceConnection r101, String r102, Executor r103);

    public boolean bindService(ComponentName r100, ServiceConnection r101, String r102) {
        return b(new q(r100), r101, r102, null);
    }

    public void unbindService(ComponentName r100, ServiceConnection r101, String r102) {
        a(new q(r100), r101);
    }

    @ResultIgnorabilityUnspecified
    public boolean bindService(String r100, ServiceConnection r101, String r102) {
        return b(new q(r100), r101, r102, null);
    }

    public void unbindService(String r100, ServiceConnection r101, String r102) {
        a(new q(r100), r101);
    }

    public boolean bindService(ComponentName r100, ServiceConnection r101, String r102, Executor r103) {
        return b(new q(r100), r101, r102, r103);
    }
}
