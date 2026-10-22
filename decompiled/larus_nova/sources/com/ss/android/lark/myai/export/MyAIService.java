package com.ss.android.lark.myai.export;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public interface MyAIService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f432869a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f432870a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<MyAIService> f432871b = null;

        public Companion() {
        }

        static {
            f432870a = new Companion();
            f432871b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MyAIService$Companion$instance$2.INSTANCE);
        }
    }

    static {
        f432869a = Companion.f432870a;
    }

    Object a();
}
