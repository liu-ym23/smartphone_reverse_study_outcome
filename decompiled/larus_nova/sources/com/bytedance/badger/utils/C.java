package com.bytedance.badger.utils;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
final class C extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f199211a = null;

    static {
        f199211a = new C();
    }

    public C() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        f.f199243d.getClass();
        Lazy r100 = f.f199241b;
        KProperty r101 = f.f199240a[0];
        return new Handler(((HandlerThread) r100.getValue()).getLooper());
    }
}
