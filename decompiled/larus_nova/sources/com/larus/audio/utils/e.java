package com.larus.audio.utils;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f290029a;

    public e(String r100) {
        Intrinsics.checkNotNullParameter("AudioSdk", EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r100, "subModule");
        this.f290029a = new s0("AudioSdk-".concat(r100));
    }

    public final z a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new z(this.f290029a, AudioLogLevel.ERROR, r100);
    }

    public final z b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new z(this.f290029a, AudioLogLevel.INFO, r100);
    }
}
