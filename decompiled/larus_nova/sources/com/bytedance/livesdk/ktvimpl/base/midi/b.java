package com.bytedance.livesdk.ktvimpl.base.midi;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import zk6.k;
import zk6.o;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f256376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<o, Runnable> f256377b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f256376a = new Handler(Looper.getMainLooper());
        this.f256377b = new ConcurrentHashMap();
    }

    public static boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L14;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L10;
    L12:
        return false;
    L10:
        if (r102.isFile() == false) goto L12;
        return true;
    L14:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // zk6.m
    public final void e(o r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.e();
        Runnable r101 = this.f256377b.remove(r100);
        if (r101 == null) goto L6;
        this.f256376a.removeCallbacks(r101);
        return;
    }

    @Override // zk6.j
    public final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "musicId");
        com.bytedance.android.live.ktv.common.music.download.h r102 = com.bytedance.android.live.ktv.common.music.download.h.f70063a;
        return com.bytedance.android.live.ktv.common.music.download.h.d(r100, d5.c(r101));
    }

    @Override // zk6.m
    public final void b(int r100, o r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        e(r101);
        c r102 = new c(this, r101, r100);
        this.f256377b.put(r101, r102);
        this.f256376a.postDelayed(r102, 0);
    }

    @Override // zk6.j
    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "midiUrl");
        Intrinsics.checkNotNullParameter(r101, "musicId");
        return g(d(r100, r101));
    }

    @Override // zk6.j
    public final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "musicId");
        com.bytedance.android.live.ktv.common.music.download.h r102 = com.bytedance.android.live.ktv.common.music.download.h.f70063a;
        return com.bytedance.android.live.ktv.common.music.download.h.e(r100, d5.c(r101));
    }

    @Override // zk6.j
    public final boolean f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lyricUrl");
        Intrinsics.checkNotNullParameter(r101, "musicId");
        return g(a(r100, r101));
    }
}
