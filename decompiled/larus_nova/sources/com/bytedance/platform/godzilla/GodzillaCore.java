package com.bytedance.platform.godzilla;

import android.app.Activity;
import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import p57.b;
import p57.g;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum GodzillaCore extends Enum<GodzillaCore> {
    public static final GodzillaCore INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GodzillaCore[] f266612a = null;
    private b mConsumeExceptionHandler;
    private WeakReference<Activity> mLastDestoryActivity;
    private WeakReference<Activity> mLastPauseActivity;
    private WeakReference<Activity> mLastResumedActivity;
    private WeakReference<Activity> mLastStopActivity;

    static {
        GodzillaCore r100 = new GodzillaCore();
        INSTANCE = r100;
        f266612a = new GodzillaCore[]{r100};
        new HashMap();
    }

    public GodzillaCore() {
        super("INSTANCE", 0);
        this.mLastResumedActivity = null;
        this.mLastPauseActivity = null;
        this.mLastStopActivity = null;
        this.mLastDestoryActivity = null;
        this.mConsumeExceptionHandler = null;
    }

    public static GodzillaCore[] values() {
        return (GodzillaCore[]) f266612a.clone();
    }

    public void destroy() {
        b r100 = this.mConsumeExceptionHandler;
        if (r100 == null) goto L12;
        List<g> r101 = r100.f527790c;
        monitor-enter(r101);
        ((LinkedList) r100.f527790c).clear();     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static GodzillaCore valueOf(String r100) {
        return (GodzillaCore) a.a(GodzillaCore.class, r100);
    }

    public void addUncaughtExceptionConsumer(g r100) {
        if (this.mConsumeExceptionHandler != null) goto L12;
        b r101 = new b();
        this.mConsumeExceptionHandler = r101;
        if (r101.f527788a == true) goto L12;
        Thread.UncaughtExceptionHandler r102 = Thread.getDefaultUncaughtExceptionHandler();
        r101.f527789b = r102;
        if (r102 == r101) goto L10;
        Thread.setDefaultUncaughtExceptionHandler(r101);
    L11:
        r101.f527788a = true;
        goto L12
    L10:
        r101.f527789b = null;
    L12:
        Logger.b("UncaughtExceptionPlugin", "init mConsumeExceptionHandler:" + this.mConsumeExceptionHandler);
        Logger.b("UncaughtExceptionPlugin", "add consumer:" + r100);
        b r103 = this.mConsumeExceptionHandler;
        List<g> r104 = r103.f527790c;
        monitor-enter(r104);
        ((LinkedList) r103.f527790c).add(r100);     // Catch: Throwable -> L17
        monitor-exit(r104);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void removeUncaughtExceptionConsumer(g r100) {
        Logger.b("UncaughtExceptionPlugin", "remove consumer:" + r100);
        b r101 = this.mConsumeExceptionHandler;
        List<g> r102 = r101.f527790c;
        monitor-enter(r102);
        ((LinkedList) r101.f527790c).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void init(Application r100, com.bytedance.platform.godzilla.common.a r101, Logger.Level r102) {
        if (r101 == null) goto L4;
        Logger.f266616c = r101;
    L4:
        if (r102 == null) goto L9;
        Logger.f266614a = r102;
        if (r102 != Logger.Level.DEBUG) goto L10;
        Logger.f266615b = true;
        return;
    L10:
        return;
    }
}
