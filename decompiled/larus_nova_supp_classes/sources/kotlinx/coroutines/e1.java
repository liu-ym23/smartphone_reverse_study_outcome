package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class e1 extends JobSupport implements CompletableJob {
    public final boolean c;

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
        return this.c;
    }

    public e1(Job r4) {
        boolean r0 = true;
        super(true);
        P(r4);
        o r5 = (o) JobSupport.b.get(this);
        if ((r5 instanceof p) == false) goto L5;
        p r6 = (p) r5;
    L6:
        if (r6 == null) goto L20;
        JobSupport r7 = r6.i();
        if (r7 == null) goto L20;
    L11:
        if (r7.G() == true) goto L21;
        o r8 = (o) JobSupport.b.get(r7);
        if ((r8 instanceof p) == false) goto L16;
        p r9 = (p) r8;
    L17:
        if (r9 == null) goto L20;
        r7 = r9.i();
        if (r7 != null) goto L11;
    L16:
        r9 = null;
    L21:
        this.c = r0;
        return;
    L20:
        r0 = false;
        goto L21
    L5:
        r6 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean completeExceptionally(Throwable r3) {
        return U(new t(r3, false));
    }
}
