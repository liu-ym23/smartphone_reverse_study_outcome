package jwc;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes42.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Level f500743a;

    public abstract void d(Level r100, String r101);

    public b(Level r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
        this.f500743a = r100;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        b(Level.DEBUG, r100);
    }

    public final boolean c(Level r100) {
        Intrinsics.checkNotNullParameter(r100, "lvl");
        if (this.f500743a.compareTo(r100) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(Level r100, String r101) {
        if (this.f500743a.compareTo(r100) > 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        d(r100, r101);
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
