package com.bytedance.helios.sdk;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeliosEnvImpl f245582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HeliosEnvImpl.CheckPoint f245583b;

    public /* synthetic */ j(HeliosEnvImpl r100, HeliosEnvImpl.CheckPoint r101) {
        this.f245582a = r100;
        this.f245583b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HeliosEnvImpl r100 = this.f245582a;
        HeliosEnvImpl.CheckPoint r101 = this.f245583b;
        ((LinkedList) r100.f245471n).add(r101);
    }
}
