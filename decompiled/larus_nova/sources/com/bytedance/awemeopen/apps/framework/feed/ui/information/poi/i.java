package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f196273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f196274b;

    public /* synthetic */ i(m r100, long r101) {
        this.f196273a = r100;
        this.f196274b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r100 = this.f196273a;
        long r101 = this.f196274b;
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.e(r101);
    }
}
