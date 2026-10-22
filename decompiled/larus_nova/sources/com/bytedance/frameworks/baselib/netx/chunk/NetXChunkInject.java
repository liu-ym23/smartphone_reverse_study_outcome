package com.bytedance.frameworks.baselib.netx.chunk;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public interface NetXChunkInject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f244801a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f244802a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f244803b = null;

        public Companion() {
        }

        static {
            f244803b = new Companion();
            f244802a = LazyKt.lazy(NetXChunkInject$Companion$instance$2.INSTANCE);
        }
    }

    static {
        f244801a = Companion.f244803b;
    }

    b a();
}
