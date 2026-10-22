package com.larus.dora.impl.onboarding;

import android.os.SystemClock;
import com.larus.avlink.api.IDoraAVLinkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f336616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f336617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f336618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f336619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f336620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function1<? super z98.f, Unit> f336621f;

    static {
    }

    public static boolean a() {
        if ((SystemClock.elapsedRealtime() - f336619d) > 3000) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Function1 r100) {
        f336621f = r100;
        IDoraAVLinkService r101 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r101 == null) goto L6;
        r101.m(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final WeakReference r100) {
        IDoraAVLinkService r101 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        b r102 = 0;
    L7:
        r101.K(r102);
        return;
    L6:
        r102 = new b(r100);
        goto L7
    }
}
