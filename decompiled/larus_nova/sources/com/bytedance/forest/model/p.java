package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.postprocessor.ForestPostProcessor;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForestPostProcessor<?> f244361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f244363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f244364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f244365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f244366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NetWorker f244367g;

    public /* synthetic */ p(String r100, NetWorker r110, ForestPostProcessor r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r110 = NetWorker.Downloader;
    L9:
        NetWorker r102 = r110;
        if ((r112 & 32) == 0) goto L12;
        r111 = null;
    L12:
        this(r100, r101, null, false, r102, r111);
        return;
    L5:
        r101 = true;
        goto L7
    }

    public /* synthetic */ p(String r100, boolean r110, boolean r111, NetWorker r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r113 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r113 & 16) == 0) goto L13;
        r112 = NetWorker.TTNet;
    L13:
        this(r100, r101, null, r102, r112);
        return;
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public p(String r100, boolean r101, Long r102, boolean r103, NetWorker r104) {
        this.f244363c = r100;
        this.f244364d = r101;
        this.f244365e = r102;
        this.f244366f = r103;
        this.f244367g = r104;
    }

    public p(String r100, boolean r101, Long r102, boolean r103, NetWorker r104, ForestPostProcessor<?> r105) {
        this(r100, r101, r102, r103, r104);
        this.f244361a = r105;
    }
}
