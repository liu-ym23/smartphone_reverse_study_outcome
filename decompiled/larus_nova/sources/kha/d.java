package kha;

import android.app.Activity;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements f09.a.InterfaceC5845a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f503575a;

    public d(Activity r100) {
        this.f503575a = r100;
    }

    @Override // f09.a.InterfaceC5845a
    public final void onPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onPreDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r100 == this.f503575a) goto L5;
        return;
    L5:
        AppHost.f326268a.a().f(this);
        FLogger.f375446a.i("LowStorageGuard", "host activity pre-destroyed, release showing lease: " + r100);
        e.f503576a.getClass();
        e.d();
    }

    @Override // f09.a.InterfaceC5845a
    public final void onResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStart(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onCreate(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }
}
