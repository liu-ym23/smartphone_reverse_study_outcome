package po5;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements a {
    public static final i b = null;

    static {
        b = new i();
    }

    public i() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r2, Map r3) {
        a.a.getClass();
        mo5.g r4 = a.C0291a.a(r2, r3);
        if (r4 != null) goto L6;
        return false;
    L6:
        r4.pause();
        r4.d("TtsPauseCommand-pause", null);
        return true;
    }
}
