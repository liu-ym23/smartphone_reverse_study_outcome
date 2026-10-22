package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.Application;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends CommonPocketModeDetector {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f385028j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f385029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f385030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f385031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f385032n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f385033o = null;

    public static final class a extends ContentObserver {
        public a(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            super.onChange(r100);
            c r101 = h.f385028j;
            c.a();
            ILogDepend.f384986a.i("ObricPocketModeDetector", "pocket mode enable state changed to " + h.f385029k);
        }
    }

    public static final class b extends ContentObserver {
        public b(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            super.onChange(r100);
            c r101 = h.f385028j;
            c.b();
            ILogDepend.f384986a.i("ObricPocketModeDetector", "on systemui pocket mode state changed to " + h.f385030l);
        }
    }

    public static final class c {
        public static void a() {
            boolean r100 = true;
            if (Settings.System.getInt(IAppContext.f384977a.getApplication().getContentResolver(), "pocket_mode_enable", 1) == 1) goto L6;
            r100 = false;
        L6:
            h.f385029k = r100;     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            ILogDepend.f384986a.e("ObricPocketModeDetector", "updatePocketModeEnableState failed", th);
        }

        public static void b() {
            boolean r100 = false;
            if (Settings.Global.getInt(IAppContext.f384977a.getApplication().getContentResolver(), "obric_proximity_hint_dismissed", 0) != 1) goto L5;
            r100 = true;
        L5:
            h.f385030l = r100;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            ILogDepend.f384986a.e("ObricPocketModeDetector", "updateSystemUIState failed", th);
        }

        public c() {
        }
    }

    static {
        f385028j = new c();
        f385029k = true;
        f385032n = new b(iaa.h.f488968a);
        f385033o = new a((Handler) iaa.h.f488970c.getValue());
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean e() {
        ILogDepend.f384986a.i("ObricPocketModeDetector", "isPocketModeManuallyDismissed() return " + f385030l);
        return f385030l;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void g() {
        ILogDepend.f384986a.i("ObricPocketModeDetector", "showProximityNearAlert() called");
        Application r100 = IAppContext.f384977a.getApplication();
        Intent r101 = new Intent("com.obric.systemui.FORCE_ALERT_PROXIMITY_NEAR");
        r101.setPackage("com.android.systemui");
        r100.sendBroadcast(r101);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean h() {
        ILogDepend.f384986a.i("ObricPocketModeDetector", "isPocketModeEnabled() return " + f385029k);
        return f385029k;
    }

    @Override // com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector, com.obric.aiagent.product.platform.api.pocketmode.a
    public final void init() {
        c r100 = f385028j;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f385031m == false) goto L18;
        ILogDepend.f384986a.i("ObricPocketModeDetector", "init() already called, skip");     // Catch: Throwable -> L15
        monitor-exit(r100);
        return;
    L18:
        IAppContext.Companion r101 = IAppContext.f384977a;     // Catch: Throwable -> L11
        r101.getApplication().getContentResolver().registerContentObserver(Settings.Global.getUriFor("obric_proximity_hint_dismissed"), false, f385032n);     // Catch: Throwable -> L11
        r101.getApplication().getContentResolver().registerContentObserver(Settings.System.getUriFor("pocket_mode_enable"), false, f385033o);     // Catch: Throwable -> L11
        c.b();     // Catch: Throwable -> L11
        c.a();     // Catch: Throwable -> L11
        f385031m = true;     // Catch: Throwable -> L11
        ILogDepend.f384986a.i("ObricPocketModeDetector", "init() called");     // Catch: Throwable -> L11
    L13:
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        ILogDepend.f384986a.e("ObricPocketModeDetector", "init() failed", th);     // Catch: Throwable -> L15
        goto L13
    }

    public h() {
    }
}
