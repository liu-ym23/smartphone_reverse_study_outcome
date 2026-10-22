package e19;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public interface i {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(i r100, Function0 r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            r100.a(null, r101);
        }
    }

    void a(String r100, Function0<Unit> r101);
}
