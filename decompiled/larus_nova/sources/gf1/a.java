package gf1;

import android.os.SystemClock;
import com.bytedance.android.live.browser.t;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.log.alog.TTLiveALogTag;
import e30.c;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f481043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f481046d;

    public a(String r100, String r101, t r102) {
        this.f481043a = 0;
        this.f481044b = r100;
        this.f481045c = r101;
        this.f481046d = r102;
    }

    public final void a(int r100, int r101, String r102) {
        long r103 = 0;
        if (r100 != 0) goto L5;
        this.f481043a = SystemClock.uptimeMillis();
    L8:
        HashMap r104 = new HashMap();
        r104.put("webview_scene", this.f481044b);
        r104.put("url", this.f481045c);
        if (r101 == 0) goto L11;
        r104.put("error_code", Integer.valueOf(r101));
        r104.put("error_msg", r102);
    L11:
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll(LiveSlardarConstants.SERVICE_WEBVIEW_LOAD_STATUS), r100, r103, r104);
        if (r100 != 2) goto L14;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError(LiveSlardarConstants.SERVICE_WEBVIEW_LOAD_STATUS), r100, r104);
    L14:
        t r105 = this.f481046d;
        if (r105 == null) goto L29;
        if (r100 != 0) goto L18;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll(((c) r105).f470899a), 0, r104);
        return;
    L18:
        if (r100 == 1) goto L25;
        if (r100 != 2) goto L21;
        c r106 = (c) r105;
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll(r106.f470899a), 2, r103, r104);
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixError(r106.f470899a), 2, r103, r104);
        zl2.a r107 = zl2.a.b();
        String r108 = TTLiveALogTag.Recharge.info;
        String r109 = r106.f470899a;
        r107.getClass();
        zl2.a.d(r108, r109, 1, zl2.a.c(r104));
        return;
    L21:
        if (r100 != 3) goto L33;
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll(((c) r105).f470899a), 3, r103, r104);
        return;
    L33:
        return;
    L25:
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll(((c) r105).f470899a), 1, r103, r104);
        return;
    L29:
        return;
    L5:
        long r110 = this.f481043a;
        if (r110 <= 0) goto L28;
        this.f481043a = 0;
        r103 = SystemClock.uptimeMillis() - r110;
        goto L8
    }
}
