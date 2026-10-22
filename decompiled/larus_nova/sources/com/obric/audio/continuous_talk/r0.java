package com.obric.audio.continuous_talk;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f395216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f395217b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Function1<? super Long, Unit> f395218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f395219d = null;

    public r0() {
    }

    static {
        f395216a = new r0();
        f395217b = new AtomicLong(0);
        f395219d = PThreadExecutorsUtils.newSingleThreadExecutor(new o0());
    }

    public final synchronized void a(final Function1<? super Long, Unit> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);     // Catch: Throwable -> L6
        final long r101 = f395217b.incrementAndGet();     // Catch: Throwable -> L6
        f395218c = r100;     // Catch: Throwable -> L6
        f395219d.execute(new q0(r101, r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(long r100) {
        monitor-enter(this);
        final long r101 = f395217b.get();     // Catch: Throwable -> L15
        if (r100 < r101) goto L8;
        monitor-exit(this);
        return;
    L8:
        final Function1<? super Long, Unit> r102 = f395218c;     // Catch: Throwable -> L15
        if (r102 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        f395219d.execute(new p0(r101, r102));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
