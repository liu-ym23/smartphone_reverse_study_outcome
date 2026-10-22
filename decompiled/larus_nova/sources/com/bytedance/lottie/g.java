package com.bytedance.lottie;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Callable<o<d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f264445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f264446b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public o<d> call() {
        Context r100 = this.f264445a;
        int r101 = this.f264446b;
        Map<String, q<d>> r102 = e.f264439a;
        return e.b(r100.getResources().openRawResource(r101), "rawRes_" + r101, true);
    L5:
        e = move-exception;
        return new o(e);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ o<d> call() throws Exception {
        return call();
    }

    public g(Context r100, int r101) {
        this.f264445a = r100;
        this.f264446b = r101;
    }
}
