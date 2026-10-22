package com.larus.common.app_ops;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.os.Build;
import android.os.Process;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.settings.value.e10;
import com.larus.settings.value.lg;
import com.larus.utils.l0;
import com.ss.texturerender.VideoSurfaceTexture;
import faceverify.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f326236a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<String> f326237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set<String> f326238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f326239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<Integer, String> f326240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f326241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f326242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f326243h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashSet<String> f326244i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<String, c> f326245j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashSet<String> f326246k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap<String, c> f326247l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashSet<String> f326248m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<String, c> f326249n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashSet<String> f326250o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap<String, c> f326251p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final HashSet<String> f326252q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final HashMap<String, c> f326253r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Set<String> f326254s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set<String> f326255t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Set<String> f326256u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Set<String> f326257v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Set<String> f326258w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Set<String> f326259x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final HashSet<String> f326260y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static AppOpsManager f326261z;

    public a() {
    }

    public final synchronized void h() {
        monitor-enter(this);
        int r100 = f326242g;     // Catch: Throwable -> L35
        int r101 = 1;
        if (1 > r100) goto L9;
        int r102 = 1;
    L6:
        f326244i.add(f326243h + r102);     // Catch: Throwable -> L35
        if (r102 == r100) goto L9;
        r102 = r102 + 1;     // Catch: Throwable -> L35
    L9:
        int r103 = f326242g;     // Catch: Throwable -> L35
        if (1 > r103) goto L15;
        int r104 = 1;
    L12:
        f326246k.add(f326243h + r104);     // Catch: Throwable -> L35
        if (r104 == r103) goto L15;
        r104 = r104 + 1;     // Catch: Throwable -> L35
    L15:
        int r105 = f326242g;     // Catch: Throwable -> L35
        if (1 > r105) goto L21;
        int r106 = 1;
    L18:
        f326248m.add(f326243h + r106);     // Catch: Throwable -> L35
        if (r106 == r105) goto L21;
        r106 = r106 + 1;     // Catch: Throwable -> L35
    L21:
        int r107 = f326242g;     // Catch: Throwable -> L35
        if (1 > r107) goto L27;
        int r108 = 1;
    L24:
        f326250o.add(f326243h + r108);     // Catch: Throwable -> L35
        if (r108 == r107) goto L27;
        r108 = r108 + 1;     // Catch: Throwable -> L35
    L27:
        int r109 = f326242g;     // Catch: Throwable -> L35
        if (1 > r109) goto L32;
    L29:
        f326252q.add(f326243h + r101);     // Catch: Throwable -> L35
        if (r101 == r109) goto L32;
        r101 = r101 + 1;     // Catch: Throwable -> L35
    L32:
        HashSet<String> r110 = f326260y;     // Catch: Throwable -> L35
        r110.add("bluetooth");     // Catch: Throwable -> L35
        r110.add("audio");     // Catch: Throwable -> L35
        r110.add("location");     // Catch: Throwable -> L35
        r110.add("camera");     // Catch: Throwable -> L35
        r110.add("phone");     // Catch: Throwable -> L35
        r110.add("wifi");     // Catch: Throwable -> L35
        r110.add("activity_recognition");     // Catch: Throwable -> L35
        r110.add(w.BLOB_ELEM_TYPE_SENSOR);     // Catch: Throwable -> L35
        r110.add("bluetooth_manager");     // Catch: Throwable -> L35
        r110.add("connectivity");     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L35:
        th = move-exception;
        throw th;
    }

    static {
        f326236a = new a();
        new LinkedHashSet();
        new LinkedHashSet();
        f326240e = new HashMap();
        f326241f = true;
        f326242g = 300;
        f326243h = "appOpsTag";
        f326244i = new HashSet();
        f326245j = new HashMap();
        new HashMap();
        new LinkedList();
        f326246k = new HashSet();
        f326247l = new HashMap();
        new HashMap();
        new LinkedList();
        f326248m = new HashSet();
        f326249n = new HashMap();
        new HashMap();
        new LinkedList();
        f326250o = new HashSet();
        f326251p = new HashMap();
        new HashMap();
        new LinkedList();
        f326252q = new HashSet();
        f326253r = new HashMap();
        new HashMap();
        new LinkedList();
        f326254s = SetsKt.mutableSetOf(new String[]{"android:camera", "android:phone_call_camera"});
        f326255t = SetsKt.mutableSetOf(new String[]{"android:bluetooth_connect", "android:bluetooth_scan", "android:bluetooth_advertise"});
        f326256u = SetsKt.mutableSetOf(new String[]{"android:read_calendar", "android:write_calendar", "android:read_calendar_real"});
        f326257v = SetsKt.mutableSetOf(new String[]{"android:read_contacts", "android:read_contacts_real", "android:write_contacts"});
        f326258w = SetsKt.mutableSetOf(new String[]{"android:read_media_audio", "android:read_media_images", "android:read_media_video"});
        f326259x = SetsKt.mutableSetOf(new String[]{"android:audio_media_volume"});
        f326260y = new HashSet();
    }

    public static boolean b() {
        if (AppHost.f326268a.isTestChannel() == false) goto L7;
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        new zv9.d();
        if (((zv9.c) l0.a(zv9.d.a(), new lg())).a() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static void i() {
        JSONObject r100 = new JSONObject();
        r100.put("brand", Build.BRAND);
        r100.put("manufacturer", Build.MANUFACTURER);
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);
        r100.put("enable", b());
        r100.put(VideoSurfaceTexture.KEY_TIME, System.currentTimeMillis());
        IApplog.f287053a.reportEvent("security_app_ops_enable", r100);
    }

    public static int a(String r100) {
        if (f326261z != null) goto L22;
        return -2;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 29) goto L11;
        AppOpsManager r102 = f326261z;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("appOpsManager");     // Catch: Throwable -> L14
        r102 = null;
    L10:
        int r103 = r102.unsafeCheckOpNoThrow(r100, Process.myUid(), AppHost.f326268a.getApplication().getPackageName());     // Catch: Throwable -> L14
    L12:
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L14
    L17:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L21;
        r104 = -2;
    L21:
        return ((Number) r104).intValue();
    L11:
        r103 = -1;
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static void j(JSONObject r100) {
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L8;
        ComponentName r102 = r101.getComponentName();
        if (r102 == null) goto L8;
        String r103 = r102.getClassName();
        if (r103 == null) goto L8;
    L9:
        r100.put("brand", Build.BRAND);
        r100.put("manufacturer", Build.MANUFACTURER);
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);
        r100.put("top_page", r103);
        r100.put(VideoSurfaceTexture.KEY_TIME, System.currentTimeMillis());
        IApplog.f287053a.reportEvent("security_app_ops", r100);
        return;
    L8:
        r103 = "";
        goto L9
    }

    public final synchronized c d(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        c r101 = f326253r.get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized c e(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        c r101 = f326249n.get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized c f(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        c r101 = f326245j.get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized c g(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        c r101 = f326251p.get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public final c c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "opCode");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (f326254s.contains(r100) == false) goto L15;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "key");     // Catch: Throwable -> L11
        c r102 = f326247l.get(r101);     // Catch: Throwable -> L11
        if (r102 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    L15:
        if (f326255t.contains(r100) == false) goto L19;
        return e(r101);
    L19:
        if (f326256u.contains(r100) == true) goto L32;
        if (f326257v.contains(r100) == true) goto L32;
        if (f326258w.contains(r100) == true) goto L32;
        if (f326259x.contains(r100) == false) goto L30;
        return d(r101);
    L30:
        return f(r101);
    L32:
        return g(r101);
    }
}
