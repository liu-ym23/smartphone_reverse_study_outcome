package com.larus.audio.call;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f289121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f289122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final buc.a f289123c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f289124d = null;

    static {
        f289123c = buc.b.a(false);
        f289124d = new Object();
    }

    public static i c() {
        Object r100 = f289124d;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f289123c.c() == false) goto L13;
        i r101 = f289122b;     // Catch: Throwable -> L14
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("curDepend");     // Catch: Throwable -> L14
        r101 = null;
    L10:
        monitor-exit(r100);
        return r101;
    L13:
        throw new IllegalStateException("FlowAVKit getDepend error, FlowAVKit not init");     // Catch: Throwable -> L14
    }

    public static g d() {
        Object r100 = f289124d;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f289123c.c() == false) goto L13;
        g r101 = f289121a;     // Catch: Throwable -> L14
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");     // Catch: Throwable -> L14
        r101 = null;
    L10:
        monitor-exit(r100);
        return r101;
    L13:
        throw new IllegalStateException("FlowAVKit getSettings error, FlowAVKit not init!");     // Catch: Throwable -> L14
    }

    public static void g() {
        i r100 = f289122b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("curDepend");
        r100 = null;
    L5:
        f289121a = r100.c();
    }

    public static boolean f() {
        return d().C;
    }

    public static v58.a b(boolean r100) {
        return c().f(r100);
    }

    public static void e(Context r100, com.larus.voicecall.impl.i r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "depend");
        Object r102 = f289124d;
        monitor-enter(r102);
        int r103 = com.larus.im.a.f346406a;     // Catch: Throwable -> L11
        if (com.larus.im.internal.d.f347915c == false) goto L10;
        f289121a = r101.c();     // Catch: Throwable -> L11
        f289122b = r101;     // Catch: Throwable -> L11
        f289123c.d(true);     // Catch: Throwable -> L11
        com.larus.audio.call.util.c.a(new FlowAVKit$init$1$1(r100, null));     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L10:
        throw new IllegalStateException("FlowAVKit init error : FlowAVSDK init failed!");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static com.larus.audio.call.play.b a(boolean r100, boolean r101, Integer r102) {
        int r103 = com.larus.audio.call.common.c.f289096a;
        if (r100 == false) goto L6;
        if (r101 == false) goto L6;
        int r104 = TECameraUtils.CAPTURE_HQ_2X;
    L7:
        if (r102 == null) goto L9;
        int r105 = r102.intValue();
    L10:
        if (r100 == false) goto L13;
        if (r101 == false) goto L13;
        int r106 = com.larus.audio.call.common.a.f289093a;
        int r107 = 12;
    L15:
        return new com.larus.audio.call.play.b(3, r104, r105, r107);
    L13:
        int r108 = com.larus.audio.call.common.a.f289093a;
        r107 = 4;
        goto L15
    L9:
        r105 = 24000;
    L6:
        r104 = 1280;
        goto L7
    }
}
