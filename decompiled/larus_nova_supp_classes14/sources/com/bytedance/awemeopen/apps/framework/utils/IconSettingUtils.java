package com.bytedance.awemeopen.apps.framework.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class IconSettingUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(IconSettingUtils$needHideIcon$2.INSTANCE);
        b = LazyKt.lazy(IconSettingUtils$needWeakenIcon$2.INSTANCE);
        c = LazyKt.lazy(IconSettingUtils$expectIconPosition$2.INSTANCE);
    }

    public static int a() {
        return ((Number) c.getValue()).intValue();
    }
}
