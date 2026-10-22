package com.ss.android.lark.appsetting.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes34.dex */
public final class AppSettingApiModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f408931a = null;

    static {
        f408931a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AppSettingApiModule$dependency$2.INSTANCE);
    }

    public static final a a() {
        return (a) f408931a.getValue();
    }
}
