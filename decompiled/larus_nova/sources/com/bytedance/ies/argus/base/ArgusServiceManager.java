package com.bytedance.ies.argus.base;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusServiceManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<ArgusServiceManager> f245935b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<s06.b> f245936a;

    public static final class a {
        public static ArgusServiceManager a() {
            return ArgusServiceManager.f245935b.getValue();
        }
    }

    static {
        f245935b = LazyKt.lazy(ArgusServiceManager$Companion$instance$2.INSTANCE);
    }

    public ArgusServiceManager() {
        this.f245936a = new CopyOnWriteArrayList();
    }
}
