package com.bytedance.live.livelink.kmp.impl.core.audio;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<fi6.a> f255360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<f> f255361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ri6.c> f255362c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function0<fi6.a> r100, Function0<f> r101, Function0<? extends ri6.c> r102) {
        Intrinsics.checkNotNullParameter(r100, "getConfig");
        Intrinsics.checkNotNullParameter(r101, "getAudioDiagnosis");
        Intrinsics.checkNotNullParameter(r102, "getExternalAudioFrameObserver");
        this.f255360a = r100;
        this.f255361b = r101;
        this.f255362c = r102;
    }
}
