package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import dv7.t;
import dv7.v;

/* JADX INFO: loaded from: classes23.dex */
public class TaskCompletionSource<TResult> {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final v<TResult> f274661zza;

    public TaskCompletionSource() {
        this.f274661zza = new v();
    }

    public Task<TResult> getTask() {
        return this.f274661zza;
    }

    public TaskCompletionSource(CancellationToken r100) {
        this.f274661zza = new v();
        r100.onCanceledRequested(new t(this));
    }

    public static /* synthetic */ v zza(TaskCompletionSource r100) {
        return r100.f274661zza;
    }

    public void setException(Exception r100) {
        this.f274661zza.a(r100);
    }

    public void setResult(TResult r100) {
        this.f274661zza.setResult(r100);
    }

    public boolean trySetException(Exception r100) {
        v<TResult> r101 = this.f274661zza;
        r101.getClass();
        Preconditions.checkNotNull(r100, "Exception must not be null");
        Object r102 = r101.f470201a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r101.f470203c == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L12
        return false;
    L8:
        r101.f470203c = true;     // Catch: Throwable -> L12
        r101.f470206f = r100;     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        r101.f470202b.a(r101);
        return true;
    }

    public boolean trySetResult(TResult r100) {
        v<TResult> r101 = this.f274661zza;
        Object r102 = r101.f470201a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r101.f470203c == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L12
        return false;
    L8:
        r101.f470203c = true;     // Catch: Throwable -> L12
        r101.f470205e = r100;     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        r101.f470202b.a(r101);
        return true;
    }
}
