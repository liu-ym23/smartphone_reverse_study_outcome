package com.bytedance.locallife.poi.media.ui;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements hy6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f262847a;

    @Override // hy6.a
    public final com.bytedance.locallife.poi.media.layer.a a() {
        return new com.bytedance.locallife.poi.media.layer.a(this.f262847a);
    }

    @Override // hy6.a
    public final com.bytedance.locallife.poi.media.layer.d b() {
        return new com.bytedance.locallife.poi.media.layer.d(this.f262847a);
    }

    @Override // hy6.a
    public final com.bytedance.locallife.poi.media.layer.c c() {
        return new com.bytedance.locallife.poi.media.layer.c();
    }

    @Override // hy6.a
    public final com.bytedance.locallife.poi.media.layer.b d() {
        return new com.bytedance.locallife.poi.media.layer.b(this.f262847a);
    }

    public final Activity getActivity() {
        return this.f262847a;
    }

    public e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f262847a = r100;
    }
}
