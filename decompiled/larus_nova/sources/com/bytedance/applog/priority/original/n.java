package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Engine f192773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f192774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Model$PriorityName f192775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f192776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f192777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f192778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f192779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PriorityCallback f192780h;

    public n(Engine r100, t r101, Model$PriorityName r102, long r103, long r104, int r105, long r110, PriorityCallback r111) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "priorityName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        this.f192773a = r100;
        this.f192774b = r101;
        this.f192775c = r102;
        this.f192776d = r103;
        this.f192777e = r104;
        this.f192778f = r105;
        this.f192779g = r110;
        this.f192780h = r111;
    }
}
