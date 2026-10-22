package com.ss.android.lark.widget.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes38.dex */
public final class PhoneParseUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f449072a = null;

    static {
        f449072a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PhoneParseUtils$phoneNumberUtil$2.INSTANCE);
    }
}
