package com.ss.android.lark.ug.plugin.internal;

import com.squareup.wire.Message;
import java.util.HashMap;
import k9c.d;
import k9c.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class PluginManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<PluginManager> f444453b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, g<?, ?>> f444454a;

    public static final class a {
        @JvmStatic
        public static PluginManager a() {
            return PluginManager.f444453b.getValue();
        }
    }

    static {
        f444453b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PluginManager$Companion$instance$2.INSTANCE);
    }

    public PluginManager() {
        this.f444454a = new HashMap();
    }

    public final synchronized g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reachPointType");     // Catch: Throwable -> L6
        g<? extends Message<?, ?>, ? extends d<? extends Message<?, ?>>> r101 = (g) this.f444454a.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
