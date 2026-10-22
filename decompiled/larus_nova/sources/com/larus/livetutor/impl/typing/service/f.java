package com.larus.livetutor.impl.typing.service;

import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.looper.TypingLooper;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements TypingLooper.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TypingService f356636a;

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.b
    public final TypingStreamStatus a() {
        return this.f356636a.f356629r;
    }

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.b
    public final int b() {
        return RangesKt.coerceAtMost(this.f356636a.f356625n, this.f356636a.f356627p.length() - 1);
    }

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.b
    public final int c() {
        return this.f356636a.f356627p.length();
    }

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.b
    public final int d() {
        TypingService r100 = this.f356636a;
        return RangesKt.coerceAtLeast((r100.f356627p.length() - r100.f356625n) - 1, 0);
    }

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.b
    public final boolean e() {
        return this.f356636a.f356630s;
    }

    public f(TypingService r100) {
        this.f356636a = r100;
    }
}
