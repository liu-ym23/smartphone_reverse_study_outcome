package com.ss.android.lark.chatwindow.statistics;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o5c.b;
import org.json.JSONObject;
import q5c.a;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatWindowHitPoint extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatWindowHitPoint f416989a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f416990b = null;

    static {
        f416989a = new ChatWindowHitPoint();
        f416990b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ChatWindowHitPoint$statistics$2.INSTANCE);
    }

    @JvmStatic
    public static final void a() {
        Intrinsics.checkNotNullParameter("1", "location");
        new JSONObject().put("stickerpack_stickerforward_location", "1");     // Catch: Throwable -> L5
        f416989a.getClass();     // Catch: Throwable -> L5
        ((b) f416990b.getValue()).sendEvent("stickerpack_stickerforward", null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(th.getMessage());
    }

    public ChatWindowHitPoint() {
    }
}
