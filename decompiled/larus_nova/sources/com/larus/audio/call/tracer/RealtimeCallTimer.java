package com.larus.audio.call.tracer;

import com.larus.audio.call.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public final class RealtimeCallTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Long> f289634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f289635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f289636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Long> f289637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f289638e;

    public final void a() {
        if (this.f289638e == true) goto L5;
        return;
    L5:
        com.larus.audio.call.util.c.a(new RealtimeCallTimer$saveToFile$1(this, null));
    }

    public RealtimeCallTimer() {
        this.f289634a = new ArrayList();
        this.f289635b = new ArrayList();
        this.f289636c = new ArrayList();
        this.f289637d = new ArrayList();
        this.f289638e = f.c().appContext().e();
    }
}
