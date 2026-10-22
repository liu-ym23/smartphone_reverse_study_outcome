package com.bytedance.locallife.pdp.container.view.lynx;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Pair;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.c f261310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f261311b;

    public c(b.c r100, b r101) {
        this.f261310a = r100;
        this.f261311b = r101;
    }

    public final void a() {
        b.c r100 = this.f261310a;
        if (r100.f261304a == false) goto L35;
        b r101 = this.f261311b;
        Pair<l, LynxLoader> r102 = r100.f261305b;
        int r103 = b.f261289j;
        r101.getClass();
        boolean r104 = true;
        if (r102.getFirst().f261331b != LynxLoadDispatcher.LoadType.CACHE) goto L19;
        r101.f261293d.b(r102.getFirst(), r102.getSecond());
        if ((!((ArrayList) r101.f261292c.f261288d).isEmpty()) == false) goto L10;
        String r105 = r102.getFirst().f261332c;
        b.d();
        return;
    L10:
        if ((!((ArrayList) r101.f261293d.f261285a).isEmpty()) == true) goto L43;
        String r106 = r102.getFirst().f261332c;
        b.d();
        if (r101.f261296g.get() != 0) goto L48;
        Iterator r107 = ((ArrayList) r101.f261293d.f261287c).iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        r101.c(false, (l) r107.next());
        goto L16
    L18:
        ((ArrayList) r101.f261293d.f261287c).clear();
        return;
    L48:
        return;
    L43:
        return;
    L19:
        r101.f261292c.b(r102.getFirst(), r102.getSecond());
        a r108 = r101.f261292c;
        if ((!((ArrayList) r108.f261285a).isEmpty()) == false) goto L22;
    L25:
        if (r104 == true) goto L34;
        String r109 = r102.getFirst().f261332c;
        b.d();
        if (r101.f261296g.get() != 0) goto L49;
        Iterator r110 = ((ArrayList) r101.f261292c.f261287c).iterator();
    L31:
        if (r110.hasNext() == false) goto L33;
        r101.c(false, (l) r110.next());
        goto L31
    L33:
        ((ArrayList) r101.f261292c.f261287c).clear();
        return;
    L49:
        return;
    L34:
        String r111 = r102.getFirst().f261332c;
        b.d();
        return;
    L22:
        if ((!((ArrayList) r108.f261286b).isEmpty()) == true) goto L25;
        r104 = false;
        goto L25
    L35:
        b r112 = this.f261311b;
        Pair<l, LynxLoader> r113 = r100.f261305b;
        int r114 = b.f261289j;
        r112.getClass();
        String r115 = r113.getFirst().f261332c;
        Objects.toString(r113.getFirst().f261331b);
        b.d();
        if (r113.getFirst().f261331b != LynxLoadDispatcher.LoadType.NORMAL) goto L38;
        r112.f261292c.b(r113.getFirst(), r113.getSecond());
        return;
    L38:
        r112.f261293d.b(r113.getFirst(), r113.getSecond());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
