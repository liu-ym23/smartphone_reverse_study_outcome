package com.bytedance.ug.sdk.luckycat.impl.storage;

import android.content.SharedPreferences;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f271494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f271495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f271496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ContainerLocalStorage f271497d;

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor r100 = this.f271497d.f271489a.edit();     // Catch: Throwable -> L4
        String r101 = this.f271494a;     // Catch: Throwable -> L4
        ContainerLocalStorage r102 = this.f271497d;     // Catch: Throwable -> L4
        Object r103 = this.f271495b;     // Catch: Throwable -> L4
        long r104 = this.f271496c;     // Catch: Throwable -> L4
        r102.getClass();     // Catch: Throwable -> L4
        r100.putString(r101, ContainerLocalStorage.d(r103, r104)).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(ContainerLocalStorage r100, String r101, Object r102, long r103) {
        this.f271497d = r100;
        this.f271494a = r101;
        this.f271495b = r102;
        this.f271496c = r103;
    }
}
