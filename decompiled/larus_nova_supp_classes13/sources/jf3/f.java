package jf3;

import android.os.Looper;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.common.utility.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements b {
    public final ECHybridListEngine a;
    public final int b;

    public static final class a {
    }

    static {
    }

    @Override // jf3.b
    public final void c() {
        if (Logger.debug() == false) goto L6;
        Logger.d("CardPreload_PreloadLifeCycle", "onNAStraightOutRenderEnd ");
        return;
    }

    @Override // jf3.b
    public final void d() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onNADestroy  preLoadStop");
    L5:
        ECHybridListEngine.d r0 = this.a.g;
        r0.getClass();
        if (Logger.debug() == false) goto L8;
        Logger.d("CardPreload_ECHLIdleHandler", "stop ");
    L8:
        Looper.myQueue().removeIdleHandler(((ak.a) r0).c);
        ((ak.a) r0).b = false;
    }

    @Override // jf3.b
    public final void e() {
        if (Logger.debug() == false) goto L6;
        Logger.d("CardPreload_PreloadLifeCycle", "onNAStraightOutStart ");
        return;
    }

    @Override // jf3.b
    public final void f() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onRealDataRenderEnd  preLoadStart");
    L5:
        int r0 = this.b;
        if (r0 != 2) goto L8;
    L9:
        this.a.l();
        return;
    L8:
        if (r0 == 3) goto L9;
    }

    @Override // jf3.b
    public final void g() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onRealHomepageApiOk  preLoadStop");
    L5:
        ECHybridListEngine.d r0 = this.a.g;
        r0.getClass();
        if (Logger.debug() == false) goto L8;
        Logger.d("CardPreload_ECHLIdleHandler", "stop ");
    L8:
        Looper.myQueue().removeIdleHandler(((ak.a) r0).c);
        ((ak.a) r0).b = false;
    }

    @Override // jf3.b
    public final void a(boolean r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CardPreload_PreloadLifeCycle", "onNACreate shouldStraightOut = " + r3);
        return;
    }

    @Override // jf3.b
    public final void b(boolean r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onNAContainerReady shouldStraightOut = " + r3);
    L5:
        int r4 = this.b;
        if (r4 != 1) goto L8;
    L9:
        this.a.l();
        return;
    L8:
        if (r4 == 3) goto L9;
    }

    public f(ECHybridListEngine r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "listEngine");
        this.a = r2;
        this.b = r3;
    }
}
