package com.bytedance.badger.z;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
final class S extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f199447a = null;

    static {
        f199447a = new S();
    }

    public S() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        h0.f199472c.getClass();
        Lazy r100 = h0.f199470a;
        KProperty r101 = e0.f199459a[0];
        return new Handler(((HandlerThread) r100.getValue()).getLooper());
    }
}
