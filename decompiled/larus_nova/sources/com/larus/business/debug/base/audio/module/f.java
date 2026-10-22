package com.larus.business.debug.base.audio.module;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f320005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f320006b = false;

    static {
        f320005a = LazyKt.lazy(new e());
        f320006b = ArraysKt.contains(new String[]{"local_test", "debug"}, AppHost.f326268a.getBuildChannel());
    }

    public static final Keva a() {
        return (Keva) f320005a.getValue();
    }
}
