package com.suite.lark.platform.component.storage.clean;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class CleanStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Object> f460593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, CleanRequest<? extends f>> f460594b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f460595c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f460596d = null;

    static {
        f460593a = new HashMap();
        f460594b = new HashMap();
        f460595c = LazyKt.lazy(CleanStore$diskCacheRepo$2.INSTANCE);
        f460596d = LazyKt.lazy(CleanStore$gson$2.INSTANCE);
    }
}
