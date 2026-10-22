package com.larus.audio.utils;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f290011b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f290012c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f290013d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a0 f290014e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f290015a;

    public static final class a {
    }

    static {
        new a0("call_id");
        f290011b = new a0("task_id");
        new a0("session_id");
        new a0("log_id");
        new a0("style_id");
        new a0("audio_scene");
        new a0("session_category");
        new a0("session_mode");
        new a0("session_options");
        new a0("result");
        f290012c = new a0("reason");
        new a0("bot_id");
        new a0("bot_name");
        f290013d = new a0("conversation_id");
        f290014e = new a0(MusicAppletPage.KEY_MESSAGE_ID);
        new a0("voice_id");
        new a0("text");
        new a0("error_msg");
    }

    public final int hashCode() {
        return this.f290015a.hashCode();
    }

    public a0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawValue");
        this.f290015a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = null;
        if ((r100 instanceof a0) == false) goto L5;
        a0 r102 = (a0) r100;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.f290015a;
    L9:
        return Intrinsics.areEqual(r101, this.f290015a);
    L5:
        r102 = null;
        goto L6
    }
}
