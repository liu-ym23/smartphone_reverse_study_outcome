package com.bytedance.ug.sdk.luckydog.task.tasktimer.executor;

import il7.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f272256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NormalTimerTaskExecutor f272257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NormalTimerTaskExecutor.b f272258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap f272259d;

    @Override // il7.f.a
    public final void onError() {
        this.f272257b.v(this.f272258c, this.f272259d);
    }

    @Override // il7.f.a
    public final void onSuccess(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        this.f272257b.f272235l.set(true);
        this.f272257b.f272234k.put((String) this.f272256a.getKey(), r100);
    L11:
        this.f272257b.v(this.f272258c, this.f272259d);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public c(Map.Entry r100, NormalTimerTaskExecutor r101, NormalTimerTaskExecutor.e r102, ConcurrentHashMap r103) {
        this.f272256a = r100;
        this.f272257b = r101;
        this.f272258c = r102;
        this.f272259d = r103;
    }
}
