package l52;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o;
import com.bytedance.android.livesdk.interactivity.square.j;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements o<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f507488a;

    public a(b r100) {
        this.f507488a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o
    public final void a(d r110) {
        d r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "updateInfo");
        com.bytedance.android.livesdk.interactivity.square.c r100 = ((j) this.f507488a).f141171i;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "updateInfo");
        ArrayList r101 = new ArrayList();
        int r112 = r111.f507496a;
        if (r112 <= 0) goto L19;
        int r102 = 0;
    L5:
        if (r102 >= r112) goto L19;
        h52.c r103 = (h52.c) ((ArrayDeque) r100.f497445a).poll();
        if (r103 == null) goto L18;
        if ((System.currentTimeMillis() - r103.d()) >= r100.f141108c) goto L11;
        r101.add(r103);
        goto L18
    L11:
        Iterator r104 = ((ArrayDeque) r100.f497445a).iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        h52.c r105 = (h52.c) r104.next();
        if ((System.currentTimeMillis() - r105.d()) < r100.f141108c) goto L18;
        r104.remove();
    L18:
        r102 = r102 + 1;
    L19:
        Iterator r113 = r101.iterator();
    L21:
        if (r113.hasNext() == false) goto L23;
        h52.c r106 = (h52.c) r113.next();
        m52.b r107 = this.f507488a.f507492d;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "data");
        ((LinkedList) r107.f512095a).add(r106);
        goto L21
    L23:
        m52.b r114 = this.f507488a.f507492d;
        if (r114.f512095a.isEmpty() == false) goto L27;
        return;
    L27:
        if (r114.f512097c == null) goto L32;
        HandlerThread r108 = r114.f512098d;
        if (r108 == null) goto L32;
        if (ThreadMethodProxy.isAlive(r108) != true) goto L32;
    L33:
        Message.obtain(r114.f512097c, 17234, new LinkedList(r114.f512095a)).sendToTarget();
        ((LinkedList) r114.f512095a).clear();
        return;
    L32:
        HandlerThread r109 = zb2.a.a();
        r114.f512098d = r109;
        r114.f512097c = new WeakHandler(r109.getLooper(), r114.f512096b);
        goto L33
    }
}
