package com.ss.android.lark.base.embedded;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.embedding.SplitController;
import androidx.window.embedding.SplitInfo;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class LKSplitController {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LKSplitController f409739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f409740c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f409741d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f409742a;

    public static final class a {
        @JvmStatic
        public static LKSplitController a() {
            hac.b.f484427a.b("LKSplitController", "getInstance");
            if (LKSplitController.f409739b != null) goto L13;
            ReentrantLock r100 = LKSplitController.f409740c;
            r100.lock();
        L10:
            th = move-exception;
            r100.unlock();
            throw th;
        L6:
            if (LKSplitController.f409739b != null) goto L8;
            LKSplitController.f409739b = new LKSplitController();     // Catch: Throwable -> L10
        L8:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
            r100.unlock();
        L13:
            LKSplitController r102 = LKSplitController.f409739b;
            if (r102 == null) goto L16;
            return r102;
        L16:
            return new LKSplitController();
        }
    }

    @JvmStatic
    public static final LKSplitController b() {
        return a.a();
    }

    static {
        f409740c = new ReentrantLock();
        f409741d = true;
    }

    public final SplitController c() {
        return (SplitController) this.f409742a.getValue();
    }

    public final boolean e() {
        if (f409741d == true) goto L7;
        return false;
    L7:
        return c().isSplitSupported();
    }

    public LKSplitController() {
        this.f409742a = LazyKt.lazy(LKSplitController$realSplitController$2.INSTANCE);
    }

    public final boolean d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (f409741d == true) goto L7;
        return false;
    L7:
        return c().isActivityEmbedded(r100);
    }

    public final void f(Consumer<List<SplitInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (f409741d == true) goto L5;
        return;
    L5:
        c().removeSplitListener(r100);
    }

    public final void a(Activity r100, Executor r101, Consumer<List<SplitInfo>> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "executor");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        if (f409741d == true) goto L5;
        return;
    L5:
        c().addSplitListener(r100, r101, r102);
    }
}
