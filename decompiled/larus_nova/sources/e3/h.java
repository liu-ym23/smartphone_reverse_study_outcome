package e3;

import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class h<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f470895a;

    @Override // e3.f
    public final T provideInstance() {
        WeakReference<T> r100 = this.f470895a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // e3.f
    public final void release() {
        WeakReference<T> r100 = this.f470895a;
        if (r100 == null) goto L5;
        T r101 = r100.get();
    L7:
        if ((r101 instanceof b) == true) goto L17;
    L12:
        WeakReference<T> r102 = this.f470895a;
        if (r102 == null) goto L15;
        r102.clear();
    L15:
        this.f470895a = null;
        return;
    L17:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        ((b) r101).a();     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r101 = null;
        goto L7
    }

    public h(T r100) {
        if (r100 != null) goto L5;
        WeakReference<T> r101 = null;
    L6:
        this.f470895a = r101;
        return;
    L5:
        r101 = new WeakReference(r100);
        goto L6
    }
}
