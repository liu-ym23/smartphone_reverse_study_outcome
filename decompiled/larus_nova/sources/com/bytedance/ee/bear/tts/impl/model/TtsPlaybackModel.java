package com.bytedance.ee.bear.tts.impl.model;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes18.dex */
public final class TtsPlaybackModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f239603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f239605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public so5.a f239606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f239607e;

    public static final class a {
    }

    static {
    }

    public TtsPlaybackModel(so5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "playbackBean");
        this.f239603a = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsPlaybackModel$coreDependency$2.INSTANCE);
        this.f239604b = r100.f542715a;
        this.f239605c = r100.f542716b;
        this.f239606d = r100;
    }

    public final Object a(Continuation<? super Boolean> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$deleteFromCache$2(this, null), r100);
    }

    public final Object b(Continuation<? super so5.a> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$reload$2(this, null), r100);
    }

    public final Object c(Continuation<? super Boolean> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$saveToCache$2(this, null), r100);
    }

    public TtsPlaybackModel(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        this.f239603a = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsPlaybackModel$coreDependency$2.INSTANCE);
        this.f239604b = r100;
        this.f239605c = r101;
        this.f239606d = null;
    }
}
