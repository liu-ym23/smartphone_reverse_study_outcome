package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f192742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f192743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f192744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Model$EventType f192745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f192746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f192747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f192748g;

    public final String toString() {
        return "id=" + this.f192742a + "|g=" + this.f192743b + "|n=" + this.f192748g + '|' + this.f192747f;
    }

    public j(long r100, int r101, long r102, Model$EventType r103, boolean r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r103, "eventType");
        Intrinsics.checkNotNullParameter(r105, "monitorId");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        this.f192742a = r100;
        this.f192743b = r101;
        this.f192744c = r102;
        this.f192745d = r103;
        this.f192746e = r104;
        this.f192747f = r105;
        this.f192748g = r110;
    }
}
