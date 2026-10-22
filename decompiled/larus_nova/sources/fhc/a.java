package fhc;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    public a() {
    }

    public final void a(Queue r100, d[] r101) {
        ArrayBlockingQueue r102 = (ArrayBlockingQueue) r100;
        if (r102.size() >= 1) goto L5;
        return;
    L5:
        r102.toArray(r101);
        Arrays.sort(r101, 0, r102.size());
        int r103 = r102.size();
        if (r103 > 0) goto L12;
        if (r103 <= 0) goto L9;
        d r104 = r101[0];
        throw null;
    L9:
        throw new IllegalArgumentException();
    L12:
        d r105 = r101[0];
        throw null;
    }
}
