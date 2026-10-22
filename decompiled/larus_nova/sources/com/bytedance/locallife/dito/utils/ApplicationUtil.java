package com.bytedance.locallife.dito.utils;

import android.app.Application;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class ApplicationUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f258672a = null;

    static {
        f258672a = LazyKt.lazy(ApplicationUtil$application$2.INSTANCE);
    }

    public static Application a() {
        return (Application) f258672a.getValue();
    }
}
