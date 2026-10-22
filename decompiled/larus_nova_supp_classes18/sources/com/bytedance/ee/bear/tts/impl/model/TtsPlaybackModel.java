package com.bytedance.ee.bear.tts.impl.model;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsPlaybackModel {
    public final Lazy a;
    public final String b;
    public final int c;
    public so5.a d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public TtsPlaybackModel(so5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "playbackBean");
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsPlaybackModel$coreDependency$2.INSTANCE);
        this.b = r3.a;
        this.c = r3.b;
        this.d = r3;
    }

    public final Object a(Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$deleteFromCache$2(this, null), r4);
    }

    public final Object b(Continuation<? super so5.a> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$reload$2(this, null), r4);
    }

    public final Object c(Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPlaybackModel$saveToCache$2(this, null), r4);
    }

    public TtsPlaybackModel(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "docToken");
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsPlaybackModel$coreDependency$2.INSTANCE);
        this.b = r3;
        this.c = r4;
        this.d = null;
    }
}
