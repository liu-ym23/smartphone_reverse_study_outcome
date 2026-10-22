package po5;

import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f530073b = null;

    static {
        f530073b = new i();
    }

    public i() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        a.f530050a.getClass();
        mo5.g r102 = a.C7218a.a(r100, r101);
        if (r102 != null) goto L6;
        return false;
    L6:
        r102.pause();
        r102.d("TtsPauseCommand-pause", null);
        return true;
    }
}
