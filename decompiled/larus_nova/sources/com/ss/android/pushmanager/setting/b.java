package com.ss.android.pushmanager.setting;

import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.ss.android.message.AppProvider;
import j77.i;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f449565c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<ISettingsUpdateListener> f449566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f449567b;

    public static b b() {
        if (f449565c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f449565c != null) goto L9;
        f449565c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f449565c;
    }

    public final boolean a() {
        Boolean r100 = this.f449567b;
        if (r100 != null) goto L5;
        Boolean r101 = Boolean.valueOf(d().Q());
        this.f449567b = r101;
        return r101.booleanValue();
    L5:
        return r100.booleanValue();
    }

    public b() {
        this.f449566a = new HashSet();
        this.f449567b = null;
        PushMultiProcessSharedProvider.e(AppProvider.getApp());
    }

    public static LocalSettings c() {
        return (LocalSettings) i.a(AppProvider.getApp(), LocalSettings.class);
    }

    public static PushOnlineSettings d() {
        return (PushOnlineSettings) i.a(AppProvider.getApp(), PushOnlineSettings.class);
    }

    public static boolean e() {
        if (c().l() == true) goto L5;
    L7:
        return false;
    L5:
        if (d().l() == false) goto L7;
        return true;
    }

    public final void f(ISettingsUpdateListener r100) {
        Set<ISettingsUpdateListener> r101 = this.f449566a;
        monitor-enter(r101);
        ((HashSet) this.f449566a).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
