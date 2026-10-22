package com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes14.dex */
public final class TDViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Method> f193749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Field> f193750b = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f193749a = LazyKt.lazy(r100, TDViewHelper$Companion$sDispatchDetachMethod$2.INSTANCE);
        f193750b = LazyKt.lazy(r100, TDViewHelper$Companion$sAttachInfoField$2.INSTANCE);
    }
}
