package m69;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f512299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<e> f512300b = null;

    public a() {
    }

    static {
        f512299a = new a();
        f512300b = new CopyOnWriteArrayList();
    }

    public static void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<e> r101 = f512300b;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @Override // m69.e
    public final void a(String r100) {
        Iterator<T> r101 = f512300b.iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        e r102 = (e) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.a(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        StringBuilder r106 = new StringBuilder("dispatchAsrResult failed, listener=");
        r106.append(r102);
        r106.append(", hasText=");
        if (r100 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        r106.append(true ^ r107);
        g49.d.c("DoraAsrDispatcher", r106.toString(), r105);
        goto L4
    L15:
        if (r100.length() == 0) goto L18;
        r107 = false;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
