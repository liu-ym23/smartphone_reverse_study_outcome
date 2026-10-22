package com.bytedance.live.bizlink.impl.platform.status;

import jg6.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lh6.b;
import yb6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class StatusCenter implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jh6.a f255046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f255047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f255048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f255049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f255050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f255051f;

    @Override // jg6.a
    public final b a() {
        return (b) this.f255048c.getValue();
    }

    @Override // jg6.a
    public final kg6.e b() {
        return (kg6.e) this.f255047b.getValue();
    }

    @Override // jg6.a
    public final jh6.a c() {
        return this.f255046a;
    }

    public StatusCenter(boolean r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "mediaManager");
        this.f255050e = r100;
        this.f255051f = r101;
        this.f255046a = new jh6.a();
        this.f255047b = LazyKt.lazy(new StatusCenter$mAudioStatusController$2(this));
        this.f255048c = LazyKt.lazy(new StatusCenter$mVideoStatusController$2(this));
        this.f255049d = LazyKt.lazy(StatusCenter$mLinkStatusController$2.INSTANCE);
    }
}
