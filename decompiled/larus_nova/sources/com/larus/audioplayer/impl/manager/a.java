package com.larus.audioplayer.impl.manager;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f290210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, RunnableC3971a> f290211b = null;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.manager.a$a, reason: collision with other inner class name */
    public static final class RunnableC3971a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f290212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z78.a f290213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f290214c;

        public final void a() {
            Handler r100 = a.f290210a;
            a.a(this.f290212a);
            String r101 = this.f290212a;
            int r102 = 1;
            boolean r103 = false;
            switch(r101.hashCode()) {
                case -598194362: goto L36;
                case -405568764: goto L17;
                case 3377875: goto L14;
                case 1678448913: goto L10;
                case 2045333017: goto L6;
                default: goto L39;
            };
        L39:
            boolean r104 = false;
        L41:
            if (r104 == false) goto L45;
            GlobalAudioController r105 = GlobalAudioController.f289658a;
            if (r105.getCurrentState() != GlobalAudioStateEnum.PLAYING) goto L45;
            FLogger.f375446a.i("AudioStopTimerManager", "timer stop " + this.f290212a);
            r105.stop("default");
            r102 = 0;
            r103 = true;
        L45:
            z78.a r106 = this.f290213b;
            if (r106 == null) goto L48;
            r106.a(this.f290212a, r102);
        L48:
            FLogger.f375446a.i("AudioStopTimerManager", "timer triggered, scene: " + this.f290212a + ", result: " + r103);
            return;
        L6:
            if (r101.equals(GlobalAudioSceneEnum.PLUGIN_MUSIC) == false) goto L39;
            r104 = Intrinsics.areEqual(GlobalAudioController.f289658a.getCurrentScene(), GlobalAudioSceneEnum.PLUGIN_MUSIC);
            goto L41
        L10:
            if (r101.equals("plugin_background_audio") == false) goto L39;
            r104 = Intrinsics.areEqual(GlobalAudioController.f289658a.getCurrentScene(), "plugin_background_audio");
            goto L41
        L14:
            if (r101.equals("news") == false) goto L39;
        L19:
            GlobalAudioController r107 = GlobalAudioController.f289658a;
            String r108 = null;
            if (Intrinsics.areEqual(r107.getCurrentScene(), GlobalAudioSceneEnum.PLUGIN_AUDIO) == false) goto L28;
            com.larus.audioplayer.impl.news.a r109 = com.larus.audioplayer.impl.news.a.f290310a;
            com.larus.audioplayer.impl.news.b r110 = com.larus.audioplayer.impl.news.a.f290316g;
            if (r110 == null) goto L24;
            String r111 = r110.a();
        L26:
            if (Intrinsics.areEqual(r111, this.f290212a) == false) goto L28;
        L34:
            r104 = true;
            goto L41
        L24:
            r111 = null;
        L28:
            if (Intrinsics.areEqual(r107.getCurrentScene(), GlobalAudioSceneEnum.PODCAST) == false) goto L39;
            com.larus.audioplayer.impl.news.a r112 = com.larus.audioplayer.impl.news.a.f290310a;
            com.larus.audioplayer.impl.news.b r113 = com.larus.audioplayer.impl.news.a.f290316g;
            if (r113 == null) goto L33;
            r108 = r113.a();
        L33:
            if (Intrinsics.areEqual(r108, GlobalAudioSceneEnum.PODCAST) == false) goto L39;
        L17:
            if (r101.equals(GlobalAudioSceneEnum.PODCAST) == true) goto L19;
        L36:
            if (r101.equals(GlobalAudioSceneEnum.QQ_MUSIC) == false) goto L39;
            r104 = Intrinsics.areEqual(GlobalAudioController.f289658a.getCurrentScene(), GlobalAudioSceneEnum.QQ_MUSIC);
            goto L41
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3971a(String r100, SetAudioStopTimerMethod.a r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f290212a = r100;
            this.f290213b = r101;
        }
    }

    static {
        f290210a = new Handler(Looper.getMainLooper());
        f290211b = new ConcurrentHashMap();
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ConcurrentHashMap<String, RunnableC3971a> r101 = f290211b;
        RunnableC3971a r102 = r101.get(r100);
        if (r102 == null) goto L6;
        f290210a.removeCallbacks(r102);
        r101.remove(r100);
        return true;
    L6:
        return false;
    }
}
