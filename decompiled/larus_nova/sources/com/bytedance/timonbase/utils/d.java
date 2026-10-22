package com.bytedance.timonbase.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f270913b;

    public d(Function0 r100) {
        this.f270913b = r100;
        this.f270912a = LazyKt.lazy(TMTimer$handler$2.INSTANCE);
    }
}
