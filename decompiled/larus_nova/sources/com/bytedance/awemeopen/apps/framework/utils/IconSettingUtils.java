package com.bytedance.awemeopen.apps.framework.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class IconSettingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f197660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f197661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f197662c = null;

    static {
        f197660a = LazyKt.lazy(IconSettingUtils$needHideIcon$2.INSTANCE);
        f197661b = LazyKt.lazy(IconSettingUtils$needWeakenIcon$2.INSTANCE);
        f197662c = LazyKt.lazy(IconSettingUtils$expectIconPosition$2.INSTANCE);
    }

    public static int a() {
        return ((Number) f197662c.getValue()).intValue();
    }
}
