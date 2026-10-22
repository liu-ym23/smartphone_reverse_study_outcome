package b78;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final buc.c b;

    public final boolean a() {
        if (this.b.b() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a = r2;
        this.b = buc.b.b();
    }

    public final void b(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "caller");
        if (r6 == false) goto L5;
        int r8 = 0;
    L6:
        int r0 = this.b.b();
        com.larus.audio.call.util.e.a.i(this.a, "[emitStateChange] target " + r8 + ", current " + r0 + ", from " + r7 + '.');
        if (r0 != r8) goto L9;
        return;
    L9:
        buc.c r9 = this.b;
        r9.getClass();
        if (buc.c.b.compareAndSet(r9, r0, r8) == false) goto L15;
        buc.f.a r10 = r9.a;
        if (r10 == buc.f.a.a) goto L16;
        r10.getClass();
        buc.f.a("CAS(" + r0 + ", " + r8 + ')');
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r8 = -1;
        goto L6
    }
}
