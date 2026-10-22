package s72;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r72.j;
import r72.k;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f540911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakHandler f540912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f540913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f540914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<va, k32.a> f540915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<k32.a, Unit> f540916f;

    public final void a(va r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f540912b == null) goto L8;
        HandlerThread r101 = this.f540913c;
        if (r101 == null) goto L8;
        if (ThreadMethodProxy.isAlive(r101) != true) goto L8;
    L9:
        WeakHandler r102 = this.f540912b;
        Intrinsics.checkNotNull(r102);
        Message.obtain(r102, 12345, r100).sendToTarget();
        return;
    L8:
        HandlerThread r103 = zb2.a.a();
        this.f540913c = r103;
        this.f540912b = new WeakHandler(r103.getLooper(), this.f540911a);
        goto L9
    }

    public b(Handler r100, j r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "uiHandler");
        Intrinsics.checkNotNullParameter(r101, "processFunc");
        Intrinsics.checkNotNullParameter(r102, "rendFunc");
        this.f540914d = r100;
        this.f540915e = r101;
        this.f540916f = r102;
        this.f540911a = new a(this);
    }
}
