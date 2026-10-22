package com.bytedance.gamecenter.base;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f244950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f244951c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f244951c.getClass();     // Catch: Throwable -> L6
        if (this.f244950b == null) goto L9;
        Objects.toString(this.f244949a);     // Catch: Throwable -> L6
        this.f244950b.onResult(this.f244949a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public c(d r100, JSONObject r101, o r102) {
        this.f244951c = r100;
        this.f244949a = r101;
        this.f244950b = r102;
    }
}
