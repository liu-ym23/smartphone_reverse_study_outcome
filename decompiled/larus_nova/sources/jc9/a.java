package jc9;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f498169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f498170b;

    public a() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    static {
        a r100 = new a();
        f498169a = r100;
        AppHost.f326268a.a().j(r100);
    }

    public final long b() {
        Long r100 = f498170b;
        if (r100 != null) goto L6;
        return (SystemClock.elapsedRealtime() - AppHost.f326268a.getAppStartTime().getFirst().longValue()) / 1000;
    L6:
        return (SystemClock.elapsedRealtime() - r100.longValue()) / 1000;
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        f498170b = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L25:
        return null;
    L4:
        switch(r100.hashCode()) {
            case -406040016: goto L22;
            case 175802396: goto L19;
            case 463403621: goto L15;
            case 1365911975: goto L11;
            case 1831139720: goto L7;
            default: goto L25;
        };
    L7:
        if (r100.equals("android.permission.RECORD_AUDIO") == false) goto L25;
        return "mic";
    L11:
        if (r100.equals("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L25;
        return "download";
    L15:
        if (r100.equals("android.permission.CAMERA") == false) goto L25;
        return "camera";
    L19:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L25;
    L24:
        return "album";
    L22:
        if (r100.equals("android.permission.READ_EXTERNAL_STORAGE") == true) goto L24;
        goto L24
    }

    public static void d(JSONObject r100) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        r100.put("trigger_interval", f498169a.b());
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("location_request_auth");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void c(boolean r100, JSONObject r101) {
        if (r101 != null) goto L4;
        r101 = new JSONObject();
    L4:
        r101.put("trigger_interval", f498169a.b());
        r101.put("status", r100 ? 1 : 0);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("location_auth_status");
        r103.f21463a.merge(r102);
        r103.b();
    }
}
