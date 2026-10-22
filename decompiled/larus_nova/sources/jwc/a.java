package jwc;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends b {
    public a() {
        super(Level.NONE);
    }

    @Override // jwc.b
    public final void d(Level r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "msg");
        System.err.println("should not see this - " + r100 + " - " + r101);
    }
}
