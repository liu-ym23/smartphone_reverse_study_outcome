package v3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.bytedance.ai.bridge.method.device.wifi.WifiError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class i extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f552804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f552805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f552806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<WifiError, Unit> f552807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f552808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ConnectivityManager f552809f;

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        h r100 = this.f552804a;
        Object r101 = r100.f552798b;
        Ref.BooleanRef r102 = this.f552808e;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r102.element == false) goto L7;
    L11:
        boolean r103 = false;
    L12:
        monitor-exit(r101);
        if (r103 == true) goto L15;
        return;
    L15:
        this.f552804a.f552799c.removeCallbacks(this.f552805b);
        Function1<WifiError, Unit> r104 = this.f552807d;
        f3.a.C5852a r105 = f3.a.f475262c;
        f3.a r106 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r104.invoke(new WifiError(f3.b.f475293g, "connect wifi unavailable"));
        return;
    L7:
        if (r100.f552803g != this) goto L11;
        r103 = true;
        r102.element = true;     // Catch: Throwable -> L17
        r100.b();     // Catch: Throwable -> L17
        goto L12
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        h r101 = this.f552804a;
        Object r102 = r101.f552798b;
        Ref.BooleanRef r103 = this.f552808e;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r103.element == false) goto L7;
    L11:
        boolean r104 = false;
    L12:
        monitor-exit(r102);
        if (r104 == true) goto L15;
        return;
    L15:
        this.f552804a.f552799c.removeCallbacks(this.f552805b);
        ConnectivityManager r105 = this.f552809f;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r105.bindProcessToNetwork(r100);     // Catch: Throwable -> L21
    L19:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Object r107 = b.f552782a;
        b.d(this.f552806c);
        this.f552807d.invoke(null);
        return;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L7:
        if (r101.f552803g != this) goto L11;
        r104 = true;
        r103.element = true;     // Catch: Throwable -> L25
        goto L12
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        h r101 = this.f552804a;
        Object r102 = r101.f552798b;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101.f552803g != this) goto L7;
        r101.b();     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
    }

    public i(h r100, g r101, Context r102, a r103, Ref.BooleanRef r104, ConnectivityManager r105) {
        this.f552804a = r100;
        this.f552805b = r101;
        this.f552806c = r102;
        this.f552807d = r103;
        this.f552808e = r104;
        this.f552809f = r105;
    }
}
