package com.bytedance.badger.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
class j extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f199263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f199264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f199265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f199266d;

    public j(x r100, Handler r101, AtomicBoolean r102, q r103, com.bytedance.badger.z.g0 r104) {
        this.f199266d = r100;
        this.f199263a = r102;
        this.f199264b = r103;
        this.f199265c = r104;
        super(r101);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        if (this.f199263a.compareAndSet(false, true) == true) goto L6;
        com.bytedance.badger.e.g("OppoIDHelper", "fetch# onReceiveResult completed, code=" + r100);
        return;
    L6:
        this.f199266d.f199305b.removeCallbacks(this.f199264b);
        if (r101 == null) goto L15;
        String r102 = x.f199300f;
        if (r101.containsKey(r102) == false) goto L15;
        JSONObject r103 = new JSONObject(r101.getString(r102));     // Catch: Exception -> L13
        ((com.bytedance.badger.z.g0) this.f199265c).b(r103.optString(x.f199301g, ""));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        o r104 = this.f199265c;
        p r105 = new p(-9006, e.toString());
    L16:
        ((com.bytedance.badger.z.g0) r104).a(r105);
        return;
    L15:
        r104 = this.f199265c;
        r105 = new p(r100, null);
        goto L16
    }
}
