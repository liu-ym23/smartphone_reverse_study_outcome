package com.bytedance.forest;

import com.bytedance.forest.pollyfill.NetWorker;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f244203a = null;

    static {
        int[] r100 = new int[NetWorker.values().length];
        f244203a = r100;
        r100[NetWorker.TTNet.ordinal()] = 1;
        r100[NetWorker.Downloader.ordinal()] = 2;
    }
}
