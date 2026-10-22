package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KVRepo f434404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MmRtcInitInfo f434405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f434406c;

    public static final class a {
    }

    static {
    }

    public f(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        this.f434404a = r100;
    }
}
