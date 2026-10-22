package com.bytedance.locallife.live.util;

import android.os.CountDownTimer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f260690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f260691b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f260692c = null;

    public interface a {
        void onTick();
    }

    public static final class b extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c.f260692c.clear();
            c.f260690a = false;
        }

        public b() {
            super(Long.MAX_VALUE, 1000);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            Iterator<T> r101 = c.f260692c.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((a) r101.next()).onTick();
            goto L4
        }
    }

    static {
        f260691b = new b();
        f260692c = new CopyOnWriteArraySet();
    }

    public static void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "onTickListener");
        CopyOnWriteArraySet<a> r101 = f260692c;
        if (r101.remove(r100) == true) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L9;
        f260691b.cancel();
        f260690a = false;
        return;
    }
}
