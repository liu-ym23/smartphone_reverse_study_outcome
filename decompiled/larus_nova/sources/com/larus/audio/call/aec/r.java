package com.larus.audio.call.aec;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289018a = 0;

    static {
    }

    public static int a(byte[] r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        v58.a r102 = com.larus.audio.call.f.b(r101);
        int r103 = 1;
        com.larus.audio.call.play.b r104 = com.larus.audio.call.f.a(true, r101, null);
        if (r102.f553276b != 12) goto L6;
        r103 = 2;
    L6:
        return (r100.length * r104.f289297c) / (r102.f553275a * r103);
    }
}
