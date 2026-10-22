package com.obric.assistant.remote_card_container.cache;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class CardCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CardCacheManager f391235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f391236b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f391237c = null;

    public CardCacheManager() {
    }

    static {
        f391235a = new CardCacheManager();
        f391236b = LazyKt.lazy(new b());
        f391237c = LazyKt.lazy(new c());
    }

    public static void a() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CardCacheManager$deleteInvalidCachesRegular$1(null), 3, null);
    }

    public static void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Looper r101 = Looper.myLooper();
        Lazy r102 = f391237c;
        if (Intrinsics.areEqual(r101, ((Handler) r102.getValue()).getLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) r102.getValue()).post(r100);
    }
}
