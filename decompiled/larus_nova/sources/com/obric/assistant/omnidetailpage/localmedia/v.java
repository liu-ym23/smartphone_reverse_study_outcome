package com.obric.assistant.omnidetailpage.localmedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f390846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MediaPlayer f390847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AudioManager f390848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f390849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function2<? super String, ? super q, Unit> f390850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function0<Unit> f390851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f390852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f390853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Handler f390854i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f390855j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final r f390856k = null;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            v.f390846a.getClass();     // Catch: Throwable -> L11
            v.c();     // Catch: Throwable -> L11
            MediaPlayer r100 = v.f390847b;     // Catch: Throwable -> L11
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.isPlaying() != true) goto L7;
        L8:
            if (r101 == false) goto L14;
            v.f390854i.postDelayed(this, 200);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r101 = false;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public v() {
    }

    public final synchronized void d() {
        monitor-enter(this);
        String r100 = f390849d;     // Catch: Throwable -> L19
        f390854i.removeCallbacks(f390855j);     // Catch: Throwable -> L19
        Function2<? super String, ? super q, Unit> r101 = f390850e;     // Catch: Throwable -> L19
        if (r101 == null) goto L6;
        r101.invoke(r100, new q(0));     // Catch: Throwable -> L19
    L6:
        MediaPlayer r102 = f390847b;     // Catch: Throwable -> L19
        if (r102 != null) goto L24;
    L13:
        f390847b = null;     // Catch: Throwable -> L19
        AudioManager r103 = f390848c;     // Catch: Throwable -> L19
        if (r103 == null) goto L16;
        r103.abandonAudioFocus(f390856k);     // Catch: Throwable -> L19
    L16:
        f390848c = null;     // Catch: Throwable -> L19
        f390849d = null;     // Catch: Throwable -> L19
        f390850e = null;     // Catch: Throwable -> L19
        f390851f = null;     // Catch: Throwable -> L19
        f390852g = false;     // Catch: Throwable -> L19
        f390853h = false;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L24:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        r102.reset();     // Catch: Throwable -> L10
        r102.release();     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Result.m9448boximpl(r105);     // Catch: Throwable -> L19
        goto L13
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L19
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.omnidetailpage.localmedia.r] */
    static {
        f390846a = new v();
        f390854i = new Handler(Looper.getMainLooper());
        f390855j = new a();
        f390856k = new r();
    }

    public static q b() {
        MediaPlayer r100 = f390847b;
        Object r101 = 0;
        if (r100 == null) goto L5;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(r100.getDuration()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = r101;
    L13:
        int r104 = ((Number) r103).intValue();
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r100.getCurrentPosition()));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r105) == true) goto L22;
        r101 = r105;
    L22:
        int r106 = ((Number) r101).intValue();
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r100.isPlaying()));     // Catch: Throwable -> L25
    L27:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L30;
        r107 = r108;
    L30:
        boolean r109 = ((Boolean) r107).booleanValue();
        if (r104 <= 0) goto L33;
        float r110 = r106 / r104;
    L35:
        return new q(r109, r110);
    L33:
        r110 = 0.0f;
    L25:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        return new q(0);
    }

    public static void c() {
        Function2<? super String, ? super q, Unit> r100 = f390850e;
        if (r100 == null) goto L6;
        r100.invoke(f390849d, b());
        return;
    }

    public static void a(MediaPlayer r100) {
        if (fna.g.d() == true) goto L6;
        r100.start();
        return;
    L6:
        r100.start();
        gna.a.c(r100.hashCode());
    }
}
