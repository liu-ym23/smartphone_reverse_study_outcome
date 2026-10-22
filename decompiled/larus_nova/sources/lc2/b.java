package lc2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.u;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f<? extends t>> f508396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f508397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f508398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakHandler f508399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f508400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e52.a f508401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f508402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f508403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<List<? extends f<? extends t>>, Unit> f508404i;

    public final void b() {
        if (this.f508396a.isEmpty() == false) goto L8;
        if (u.f536265a.getValue().dropUselessRenderPost == false) goto L8;
        return;
    L8:
        if (this.f508397b == false) goto L14;
        Iterator<T> r100 = this.f508396a.iterator();
    L11:
        if (r100.hasNext() == false) goto L14;
        f r101 = (f) r100.next();
        r101.f133156q = Long.valueOf(System.currentTimeMillis());
    L14:
        if (this.f508399d == null) goto L19;
        HandlerThread r102 = this.f508400e;
        if (r102 == null) goto L19;
        if (ThreadMethodProxy.isAlive(r102) != true) goto L19;
    L20:
        WeakHandler r103 = this.f508399d;
        Intrinsics.checkNotNull(r103);
        Message.obtain(r103, 10086, new LinkedList(this.f508396a)).sendToTarget();
        ((LinkedList) this.f508396a).clear();
        return;
    L19:
        HandlerThread r104 = zb2.a.a();
        this.f508400e = r104;
        this.f508399d = new WeakHandler(r104.getLooper(), this.f508398c);
        goto L20
    }

    public final void a(f<? extends t> r100) {
        Intrinsics.checkNotNullParameter(r100, "absTextMessage");
        ((LinkedList) this.f508396a).add(r100);
    }

    public b(e52.a r100, Handler r101, Function1 r102) {
        c r103 = c.f508406b;
        Intrinsics.checkNotNullParameter(r100, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r101, "uiHandler");
        Intrinsics.checkNotNullParameter(r103, "processor");
        Intrinsics.checkNotNullParameter(r102, "rendFunc");
        this.f508401f = r100;
        this.f508402g = r101;
        this.f508403h = r103;
        this.f508404i = r102;
        this.f508396a = new LinkedList();
        this.f508398c = new a(this);
    }
}
