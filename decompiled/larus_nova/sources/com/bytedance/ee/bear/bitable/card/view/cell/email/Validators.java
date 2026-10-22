package com.bytedance.ee.bear.bitable.card.view.cell.email;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes15.dex */
public final class Validators {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f207636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f207637b = null;

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f207636a = LazyKt.lazy(r100, Validators$passAllValidator$2.INSTANCE);
        f207637b = LazyKt.lazy(r100, Validators$emailValidator$2.INSTANCE);
    }
}
