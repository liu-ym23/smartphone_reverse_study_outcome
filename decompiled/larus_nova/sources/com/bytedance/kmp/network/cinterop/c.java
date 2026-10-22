package com.bytedance.kmp.network.cinterop;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f252492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f252493b = null;

    static {
        f252492a = MapsKt.emptyMap();
        f252493b = kotlinx.coroutines.sync.b.a();
    }
}
