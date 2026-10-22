package com.bytedance.live.livelink.kmp.impl.extend.spatialaudio;

import aj6.c;
import aj6.d;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.b;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f255602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f255603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aj6.b f255604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aj6.b f255605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final aj6.a f255606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f255607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f255608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<f> f255609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ExtendContext f255610i;

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255610i;
    }

    public a(ExtendContext r100) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        this.f255610i = r100;
        d r101 = new d(0, 0, 0);
        this.f255602a = r101;
        this.f255603b = new d(0, 0, 0);
        aj6.b r102 = new aj6.b(new c(0.0f, 0.0f, 0.0f), new c(0.0f, 0.0f, 0.0f), new c(0.0f, 0.0f, 0.0f));
        this.f255604c = r102;
        this.f255605d = new aj6.b(new c(0.0f, 0.0f, 0.0f), new c(0.0f, 0.0f, 0.0f), new c(0.0f, 0.0f, 0.0f));
        this.f255606e = new aj6.a(r101, r102);
        this.f255609h = CollectionsKt.emptyList();
    }
}
