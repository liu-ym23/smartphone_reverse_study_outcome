package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class l implements ti6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f255320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ei6.a f255321b;

    @Override // ti6.c
    public final MixStreamType b() {
        return MixStreamType.SERVER_MIX;
    }

    @Override // ti6.c
    public final boolean e() {
        return this.f255320a;
    }

    public l(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "liveLinkService");
        this.f255321b = r100;
    }
}
