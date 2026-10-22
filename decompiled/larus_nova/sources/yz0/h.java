package yz0;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface h extends f80.b {

    public static final class a {
        public static /* synthetic */ Observable a(h r100, yh6.b r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            return r100.S4(r101, r102, null);
        }
    }

    <T extends yh6.c> Observable<T> S4(yh6.b<T> r100, boolean r101, String r102);
}
