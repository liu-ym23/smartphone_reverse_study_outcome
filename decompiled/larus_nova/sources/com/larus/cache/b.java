package com.larus.cache;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f321245a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f321246b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<CacheManagerImpl> f321247c = null;

        public a() {
        }

        static {
            f321246b = new a();
            f321247c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.cache.a());
        }
    }

    static {
        f321245a = a.f321246b;
    }
}
