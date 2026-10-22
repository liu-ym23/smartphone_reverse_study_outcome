package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f204281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f204283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f204284d;

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.f204281a, this.f204282b).edit().putString(this.f204283c, this.f204284d.toString()).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(Context r100, JSONObject r101) {
        this.f204281a = r100;
        this.f204282b = "SP_EXPERIMENT_CACHE";
        this.f204283c = "SP_EXPERIMENT_CACHE";
        this.f204284d = r101;
    }
}
