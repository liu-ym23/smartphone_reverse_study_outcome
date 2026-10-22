package com.bytedance.android.livesdk.log;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.platform.IHostConfig;
import com.bytedance.android.livesdkapi.feed.IFeedSceneTracer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements IFeedSceneTracer {
    public static final e d = null;
    public long a;
    public String b;
    public boolean c;

    static {
        d = new e();
    }

    public e() {
        this.c = false;
    }

    public final void end(String r6) {
        if (TextUtils.equals(r6, this.b) == true) goto L5;
        return;
    L5:
        if (this.c == false) goto L18;
        this.c = false;
        this.b = null;
        long r1 = SystemClock.elapsedRealtime() - this.a;
        HashMap r3 = new HashMap();
        r3.put("scene_type", r6);
        r3.put("duration", Long.valueOf(r1));
        if (jc1.k.f(IHostConfig.class) != null) goto L10;
    L15:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_first_frame_scene_monitor_all", 0, r1, r3);
        return;
    L10:
        if (jc1.k.f(IHostConfig.class).appConfig() == null) goto L15;
        if (jc1.k.f(IHostConfig.class).appConfig().enableLiveVideoMixOpt() == false) goto L14;
        r3.put("opt_enable", 1);
        goto L15
    L14:
        r3.put("opt_enable", 0);
        goto L15
    }

    public final void realStart(String r2) {
        if (TextUtils.equals(r2, this.b) == true) goto L6;
        this.b = null;
        this.c = false;
        return;
    L6:
        this.c = true;
    }

    public final void start(String r3) {
        this.b = r3;
        this.a = SystemClock.elapsedRealtime();
    }
}
