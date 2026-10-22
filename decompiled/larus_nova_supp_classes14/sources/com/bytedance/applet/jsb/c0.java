package com.bytedance.applet.jsb;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 implements a88.c, a88.b {
    public static final c0 a = null;
    public static String b;
    public static String c;

    public c0() {
    }

    public final void b(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "musicId");
    }

    static {
        c0 r0 = new c0();
        a = r0;
        c = "stopped";
        MusicPlayManagerDelegate r1 = MusicPlayManagerDelegate.b;
        r1.l();
        r1.k(r0);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "prepare";
        g.a(r2, "prepare");
        j(r2, "prepare");
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        f.a(r2, 0);
        c(r2, 0);
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        g.a(r2, "finish");
        j(r2, "finish");
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "error";
        g.a(r2, "error");
        j(r2, "error");
    }

    public final String k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originalResolution");
        switch(r2.hashCode()) {
            case 2249154: goto L18;
            case 68069317: goto L14;
            case 1377272541: goto L10;
            case 1670753181: goto L6;
            default: goto L21;
        };
    L21:
        return null;
    L6:
        if (r2.equals("SuperHigh") == false) goto L21;
        return "highest";
    L10:
        if (r2.equals("Standard") == false) goto L21;
        return "medium";
    L14:
        if (r2.equals("FourK") == false) goto L21;
        return "lossless";
    L18:
        if (r2.equals("High") == false) goto L21;
        return "higher";
    }

    public final void onError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        c = "error";
        g.a(r2, "error");
        j(r2, "error");
    }

    public static void c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        HashSet r0 = AppletRuntime.c.a;
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.put("music_id", r2);
        r1.put("action_type", Integer.valueOf(r3));
        Unit r4 = Unit.INSTANCE;
        AppletRuntime.c.a("musicActionTriggered", r1);
    }

    public static void j(String r2, String r3) {
        HashSet r0 = AppletRuntime.c.a;
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.put("music_id", r2);
        r1.put("status", r3);
        Unit r4 = Unit.INSTANCE;
        AppletRuntime.c.a("musicPlayStatusChanged", r1);
    }

    public final void g(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        if (r3 != 0) goto L5;
        String r4 = "stopped";
    L12:
        b = r2;
        c = r4;
        g.a(r2, r4);
        j(r2, r4);
        return;
    L5:
        if (r3 != 1) goto L7;
        r4 = "playing";
        goto L12
    L7:
        if (r3 == 2) goto L9;
        r4 = CommentPublishScene.UNKNOWN;
        goto L12
    L9:
        r4 = "paused";
        goto L12
    }

    public final void i(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        b = r2;
        if (r3 != 3) goto L6;
        c = "error";
        g.a(r2, "error");
        j(r2, "error");
        return;
    }

    public final void a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        Intrinsics.checkNotNullParameter(r3, "fromProgress");
        Intrinsics.checkNotNullParameter(r4, "toProgress");
        f.a(r2, 3);
        c(r2, 3);
    }
}
