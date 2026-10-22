package jf3;

import android.os.Looper;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.common.utility.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECHybridListEngine f498880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498881b;

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
        ECHybridListEngine.d r100 = this.f498880a.f46876g;
        r100.getClass();
        if (Logger.debug() == false) goto L8;
        Logger.d("CardPreload_ECHLIdleHandler", "stop ");
    L8:
        Looper.myQueue().removeIdleHandler(r100.f3975c);
        r100.f3974b = false;
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
        int r100 = this.f498881b;
        if (r100 != 2) goto L8;
    L9:
        this.f498880a.l();
        return;
    L8:
        if (r100 == 3) goto L9;
    }

    @Override // jf3.b
    public final void g() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onRealHomepageApiOk  preLoadStop");
    L5:
        ECHybridListEngine.d r100 = this.f498880a.f46876g;
        r100.getClass();
        if (Logger.debug() == false) goto L8;
        Logger.d("CardPreload_ECHLIdleHandler", "stop ");
    L8:
        Looper.myQueue().removeIdleHandler(r100.f3975c);
        r100.f3974b = false;
    }

    @Override // jf3.b
    public final void a(boolean r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CardPreload_PreloadLifeCycle", "onNACreate shouldStraightOut = " + r100);
        return;
    }

    @Override // jf3.b
    public final void b(boolean r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CardPreload_PreloadLifeCycle", "onNAContainerReady shouldStraightOut = " + r100);
    L5:
        int r101 = this.f498881b;
        if (r101 != 1) goto L8;
    L9:
        this.f498880a.l();
        return;
    L8:
        if (r101 == 3) goto L9;
    }

    public f(ECHybridListEngine r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "listEngine");
        this.f498880a = r100;
        this.f498881b = r101;
    }
}
