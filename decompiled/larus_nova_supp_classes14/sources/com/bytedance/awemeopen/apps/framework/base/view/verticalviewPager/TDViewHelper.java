package com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TDViewHelper {
    public static final Lazy<Method> a = null;
    public static final Lazy<Field> b = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        a = LazyKt.lazy(r0, TDViewHelper$Companion$sDispatchDetachMethod$2.INSTANCE);
        b = LazyKt.lazy(r0, TDViewHelper$Companion$sAttachInfoField$2.INSTANCE);
    }
}
