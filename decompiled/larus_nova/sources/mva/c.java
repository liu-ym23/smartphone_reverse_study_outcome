package mva;

import com.ss.android.lark.appcontext.applifecycle2.impl.e;
import com.ss.android.lark.appcontext.applifecycle2.ipc.BroadcastRemoteStateService;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f515902b;

    @Override // mva.a
    public final void a(jva.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.f500587b == false) goto L6;
        String r101 = "lifecycle2 process " + this.f515901a + " only detector but still trigger state change: " + r100.a();
        Log.e("AppLifecycle2", r101, new IllegalStateException(r101), true);
        return;
    }

    @Override // mva.a
    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f515902b.b(r100);
    }

    public c(String r100, BroadcastRemoteStateService r101) {
        Intrinsics.checkNotNullParameter(r100, "processName");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f515901a = r100;
        this.f515902b = r101;
    }
}
