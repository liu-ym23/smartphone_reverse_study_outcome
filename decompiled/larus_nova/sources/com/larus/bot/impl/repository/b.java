package com.larus.bot.impl.repository;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<b> f319362a = null;

    public static final class a {
    }

    public b() {
    }

    static {
        f319362a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.bot.impl.repository.a());
    }
}
