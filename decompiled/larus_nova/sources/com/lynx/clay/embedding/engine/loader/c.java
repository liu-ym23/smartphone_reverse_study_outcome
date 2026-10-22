package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Callable<FlutterLoader.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f380746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f380747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f380748c;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public FlutterLoader.b call() {
        FlutterLoader r100 = this.f380748c;
        return FlutterLoader.d(this.f380746a, r100.f380723e, this.f380747b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ FlutterLoader.b call() throws Exception {
        return call();
    }

    public c(FlutterLoader r100, Context r101, JSONObject r102) {
        this.f380748c = r100;
        this.f380746a = r101;
        this.f380747b = r102;
    }
}
