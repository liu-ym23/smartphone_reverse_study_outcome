package fga;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
public interface a extends m1a.a {

    /* JADX INFO: renamed from: fga.a$a, reason: collision with other inner class name */
    public static final class C5900a {
        public static /* synthetic */ Object a(a r100, boolean r101, boolean r102, Continuation r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = false;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = false;
        L9:
            return r100.w80(false, r101, r102, r103);
        }
    }

    Object w80(boolean r100, boolean r101, boolean r102, Continuation<? super Boolean> r103);
}
