package io.ktor.websocket;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a0;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xwc.c f492163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f492164b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f492165c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CloseReason f492166d = null;

    static {
        Intrinsics.checkNotNullParameter("io.ktor.websocket.WebSocket", "name");
        f492163a = xwc.e.c("io.ktor.websocket.WebSocket");
        f492164b = new a0("ws-incoming-processor");
        f492165c = new a0("ws-outgoing-processor");
        f492166d = new CloseReason(CloseReason.Codes.NORMAL, "OK");
    }
}
