package com.bytedance.ies.argus.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusEnv {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ArgusEnv> f245917d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r06.a f245918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f245919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f245920c;

    public final class a {
        public a() {
        }
    }

    public static final class b {
        public static ArgusEnv a() {
            return ArgusEnv.f245917d.getValue();
        }
    }

    static {
        f245917d = LazyKt.lazy(ArgusEnv$Companion$instance$2.INSTANCE);
    }

    public final r06.a.C7412a a() {
        r06.a r100 = this.f245918a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f535464c;
    }

    public ArgusEnv() {
        this.f245919b = LazyKt.lazy(new ArgusEnv$ttmParam$2(this));
        this.f245920c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }
}
