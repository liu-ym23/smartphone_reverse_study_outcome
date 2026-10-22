package com.ss.android.lark.statistics.chat;

import com.obric.assistant.WakeupSoundEffectSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatHitPoint extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatHitPoint f440631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440632b = null;

    static {
        f440631a = new ChatHitPoint();
        f440632b = LazyKt.lazy(ChatHitPoint$statistics$2.INSTANCE);
    }

    public final o5c.b b() {
        return (o5c.b) f440632b.getValue();
    }

    public ChatHitPoint() {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        f440631a.b().sendEvent("thread_detail_page_activated_inchat", new JSONObject().put("source", r100).put("chat_mode", WakeupSoundEffectSettings.CLASSIC));
    }

    public final void c(boolean r100, boolean r101, long r102) {
        b().sendEvent("lark_android_next_page_loading", new JSONObject().put("show_loading", r100 ? 1 : 0).put("on_launch", r101 ? 1 : 0).put("time_cost", r102));
    }
}
