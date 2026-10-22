package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class e1 extends JobSupport implements CompletableJob {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f504736c;

    @Override // kotlinx.coroutines.JobSupport
    public final boolean I() {
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean complete() {
        return U(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean G() {
        return this.f504736c;
    }

    public e1(Job r100) {
        boolean r101 = true;
        super(true);
        P(r100);
        o r102 = (o) JobSupport.f504600b.get(this);
        if ((r102 instanceof p) == false) goto L5;
        p r103 = (p) r102;
    L6:
        if (r103 == null) goto L20;
        JobSupport r104 = r103.i();
        if (r104 == null) goto L20;
    L11:
        if (r104.G() == true) goto L21;
        o r105 = (o) JobSupport.f504600b.get(r104);
        if ((r105 instanceof p) == false) goto L16;
        p r106 = (p) r105;
    L17:
        if (r106 == null) goto L20;
        r104 = r106.i();
        if (r104 != null) goto L11;
    L16:
        r106 = null;
    L21:
        this.f504736c = r101;
        return;
    L20:
        r101 = false;
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean completeExceptionally(Throwable r100) {
        return U(new t(r100, false));
    }
}
