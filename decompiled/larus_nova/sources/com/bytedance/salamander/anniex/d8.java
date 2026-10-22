package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d8 f268040b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.salamander.adapter.i f268041a;

    public static final class a {
    }

    static {
        f268040b = new d8();
    }

    public d8() {
        this.f268041a = new com.bytedance.salamander.adapter.i("anniex.salamander.monitor", true);
    }

    public final void a(Function1<? super Boolean, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "workLoad");
        int r101 = com.bytedance.salamander.adapter.r.f267796a;
        com.bytedance.salamander.adapter.i r102 = this.f268041a;
        Intrinsics.checkNotNull(r102);
        com.bytedance.salamander.adapter.r.a.a(r100, r102, AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
