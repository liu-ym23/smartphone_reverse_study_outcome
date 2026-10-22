package com.ss.android.lark.appcontext.applifecycle2.impl;

import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle2.api.AppState;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements mva.a.InterfaceC6860a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f408893a;

    public e(c r100) {
        this.f408893a = r100;
    }

    @Override // mva.a.InterfaceC6860a
    public final void a(AppState r100) {
        Intrinsics.checkNotNullParameter(r100, "appState");
        int r101 = c.f408885g;
        StringBuilder r102 = new StringBuilder("process: ");
        r102.append(this.f408893a.f408887b.b());
        r102.append(", receive remote state change: ");
        r102.append("topProcess=" + r100.f408872b + ", isForeground=" + r100.f408871a + ", topActivity=" + r100.f408873c + ", timestamp=" + r100.f408874d);
        r102.append(' ');
        Log.i("AppLifecycle2", r102.toString());
        c r103 = this.f408893a;
        AppState r104 = r103.f408890e;
        r103.f408890e = r100;
        StringBuilder r105 = new StringBuilder("process: ");
        r105.append(r103.f408887b.b());
        r105.append(", app state changed to ");
        if (r103.f408890e.f408871a == false) goto L5;
        String r106 = "Foreground";
    L6:
        r105.append(r106);
        Log.i("AppLifecycle2", r105.toString());
        boolean r107 = r103.f408887b.isForeground();
        if (z.e(r103.f408886a) == true) goto L9;
    L11:
        Iterator<T> r108 = r103.f408891f.iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        jva.b r109 = (jva.b) r108.next();
        r109.a();
        if ((r109 instanceof jva.c) == false) goto L13;
        ((jva.c) r109).b(r104, r103.f408890e);
        goto L13
    L17:
        return;
    L9:
        if (r103.f408890e.f408871a == r107) goto L11;
        Log.e("AppLifecycle2", "notifyAppStateChanged() state not match, need check", new IllegalStateException("appFront=" + r103.f408890e.f408871a + ", processFront=" + r107), true);
        goto L11
    L5:
        r106 = "Background";
        goto L6
    }
}
