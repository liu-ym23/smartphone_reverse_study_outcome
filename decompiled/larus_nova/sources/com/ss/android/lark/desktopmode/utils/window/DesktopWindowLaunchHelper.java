package com.ss.android.lark.desktopmode.utils.window;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes35.dex */
public final class DesktopWindowLaunchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<DesktopWindowLaunchHelper> f420397a = null;

    public static final class a {
    }

    static {
        f420397a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DesktopWindowLaunchHelper$Companion$instance$2.INSTANCE);
    }

    public DesktopWindowLaunchHelper() {
    }
}
