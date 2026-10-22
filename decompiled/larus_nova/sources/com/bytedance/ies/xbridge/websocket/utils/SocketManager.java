package com.bytedance.ies.xbridge.websocket.utils;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class SocketManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<SocketManager> f249566a = null;

    public static final class a {
    }

    static {
        new HashMap();
        f249566a = LazyKt.lazy(SocketManager$Companion$instance$2.INSTANCE);
    }

    public SocketManager() {
    }
}
