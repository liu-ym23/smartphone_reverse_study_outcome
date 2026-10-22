package com.larus.audio.call.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements com.larus.audio.call.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f289645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.larus.audio.call.j f289646b = null;

    public e() {
    }

    static {
        f289645a = new e();
        f289646b = com.larus.audio.call.f.c().l();
    }

    @Override // com.larus.audio.call.j
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.d("FlowAVKit_" + r100, r101);
    }

    @Override // com.larus.audio.call.j
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.e("FlowAVKit_" + r100, r101);
    }

    @Override // com.larus.audio.call.j
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.i("FlowAVKit_" + r100, r101);
    }

    @Override // com.larus.audio.call.j
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.v("FlowAVKit_" + r100, r101);
    }

    @Override // com.larus.audio.call.j
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.w("FlowAVKit_" + r100, r101);
    }

    @Override // com.larus.audio.call.j
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.e("FlowAVKit_" + r100, r101, r102);
    }

    @Override // com.larus.audio.call.j
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f289646b.w("FlowAVKit_" + r100, r101, r102);
    }
}
