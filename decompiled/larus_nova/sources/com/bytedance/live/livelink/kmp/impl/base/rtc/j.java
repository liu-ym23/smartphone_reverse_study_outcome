package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class j implements ti6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f255318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255319b;

    @Override // ti6.c
    public final MixStreamType b() {
        return MixStreamType.RTC_CLIENT_MIX;
    }

    @Override // ti6.c
    public final boolean e() {
        return this.f255319b;
    }

    public j(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "liveLinkService");
        this.f255318a = r100;
    }
}
