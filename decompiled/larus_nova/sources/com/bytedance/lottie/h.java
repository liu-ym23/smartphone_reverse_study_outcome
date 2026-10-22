package com.bytedance.lottie;

import android.util.JsonReader;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements Callable<o<d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsonReader f264447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f264448b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public o<d> call() {
        return e.c(this.f264447a, this.f264448b, true);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ o<d> call() throws Exception {
        return call();
    }

    public h(JsonReader r100) {
        this.f264447a = r100;
        this.f264448b = null;
    }
}
