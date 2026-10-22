package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class StoreLynxJsbChecker {
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final a f = null;
    public final Lazy a;
    public ComponentsWrapper b;
    public final Function3<? super String, ? super String, ? super String, Unit> c;

    public static final class a {
        public a() {
        }
    }

    static {
        f = new a();
        d = LazyKt.lazy(StoreLynxJsbChecker$Companion$tabConfig$2.INSTANCE);
        e = LazyKt.lazy(StoreLynxJsbChecker$Companion$checker$2.INSTANCE);
    }

    public StoreLynxJsbChecker(String r2, ComponentsWrapper r3, Function3 r4) {
        Intrinsics.checkNotNullParameter(r2, "tabId");
        this.b = r3;
        this.c = r4;
        this.a = LazyKt.lazy(new StoreLynxJsbChecker$hasISV$2(this));
    }
}
