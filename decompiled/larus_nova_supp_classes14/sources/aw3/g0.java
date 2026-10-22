package aw3;

import android.os.Looper;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 {
    public static final CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> a = null;
    public static final a b = null;
    public static AppletBackgroundAudioMediaSessionService c;
    public static com.bytedance.applet.audio.background.a d;
    public static boolean e;

    public static final class a implements e78.c {
        public a() {
        }

        public final boolean b() {
            return false;
        }

        public final void c() {
        }

        public final void d() {
        }

        public final boolean e() {
            return false;
        }

        public final String getBizScene() {
            return "plugin_background_audio";
        }

        public final String getScene() {
            return "plugin_background_audio";
        }

        public final void a() {
            CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r0 = g0.a;
            FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session release from global controller");
            g0.a.clear();
            g0.e(new d0(new z()));
        }

        public final GlobalAudioStateEnum getState() {
            w r0 = w.a;
            if (w.k == null) goto L20;
            BackgroundAudioPlaybackState r1 = w.b.m;
            int r2 = w.a.a[r1.ordinal()];
            if (r2 == 1) goto L19;
            if (r2 == 2) goto L23;
            if (r2 == 3) goto L22;
            if (r2 != 4) goto L15;
            return GlobalAudioStateEnum.STOPPED;
        L15:
            throw new NoWhenBranchMatchedException();
        L22:
            return GlobalAudioStateEnum.STOPPED;
        L23:
            return GlobalAudioStateEnum.PAUSED;
        L19:
            return GlobalAudioStateEnum.PLAYING;
        L20:
            return GlobalAudioStateEnum.NONE;
        }

        public final boolean pause() {
            w r0 = w.a;
            String r1 = w.k;
            if (r1 != null) goto L5;
            return false;
        L5:
            w.z(new o(r1));
            return true;
        }

        public final boolean play() {
            w r0 = w.a;
            String r1 = w.k;
            if (r1 != null) goto L5;
            return false;
        L5:
            w.z(new p(r1));
            return true;
        }

        public final boolean stop() {
            w r0 = w.a;
            String r1 = w.k;
            if (r1 != null) goto L5;
            return false;
        L5:
            w.z(new q(r1));
            return true;
        }
    }

    static {
        a = new CopyOnWriteArrayList();
        b = new a();
    }

    public static void d() {
        com.bytedance.applet.audio.background.a r0 = d;
        if (r0 != null) goto L10;
    L8:
        d = null;
        c = null;
        e = false;
        a.clear();
        return;
    L10:
        AppHost.a.getApplication().unbindService(r0);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.a.e("AppletBackgroundAudioMediaSessionController", "unbind media session service failed", e);
        goto L8
    }

    public static void a(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session metadata changed. state: " + r3.b());
        AppletBackgroundAudioMediaSessionService r4 = c;
        if (r4 != null) goto L5;
        return;
    L5:
        if ((!r4.j) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        r4.k();
        r4.l();
        return;
    }

    public static void b(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session seeked. state: " + r3.b());
        AppletBackgroundAudioMediaSessionService r4 = c;
        if (r4 != null) goto L5;
        return;
    L5:
        if ((!r4.j) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        r4.l();
        return;
    }

    public static void c(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session stopped. state: " + r3.b());
        GlobalAudioController.a.d(b);
        a.clear();
        e(new d0(new x()));
        f(GlobalAudioStateEnum.STOPPED, w.k);
    }

    public static void e(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        com.larus.utils.y.c(new f0(r2));
    }

    public static void f(GlobalAudioStateEnum r3, String r4) {
        GlobalAudioObserver r0 = GlobalAudioObserver.a;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 == null) goto L5;
        r1.put("applet_id", r4);
    L5:
        r0.c("plugin_background_audio", r3, r1);
    }
}
