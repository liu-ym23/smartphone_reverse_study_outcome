package mva;

import android.app.Activity;
import com.ss.android.lark.appcontext.applifecycle2.api.AppState;
import com.ss.android.lark.appcontext.applifecycle2.impl.e;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a.InterfaceC6860a> f515900a;

    public b() {
        this.f515900a = new LinkedList();
    }

    @Override // mva.a
    public final void a(jva.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r101 = r100.f500587b;
        String r102 = r100.f500586a;
        Activity r103 = r100.f500589d;
        if (r103 == null) goto L5;
        String r104 = r103.getClass().getSimpleName();
    L6:
        AppState r105 = new AppState(r101, r102, r104, r100.f500588c);
        LinkedList<a.InterfaceC6860a> r106 = this.f515900a;
        monitor-enter(r106);
        Iterator<T> r107 = this.f515900a.iterator();     // Catch: Throwable -> L15
    L10:
        if (r107.hasNext() == false) goto L12;
        ((a.InterfaceC6860a) r107.next()).a(r105);     // Catch: Throwable -> L15
        goto L10
    L12:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r106);
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        r104 = null;
        goto L6
    }

    @Override // mva.a
    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LinkedList<a.InterfaceC6860a> r101 = this.f515900a;
        monitor-enter(r101);
        this.f515900a.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
