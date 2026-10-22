package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(f r3, String r4, StopReason r5, y r6, Function1 r7, int r8) {
            if ((r8 & 1) == 0) goto L6;
            r4 = null;
        L6:
            if ((r8 & 4) == 0) goto L9;
            r6 = new y(false, 7);
        L9:
            if ((r8 & 8) == 0) goto L11;
            r7 = null;
        L11:
            r3.b(r4, r5, r6, r7);
        }
    }

    void a(b r1, Function1<? super d, Unit> r2);

    void b(String r1, StopReason r2, y r3, Function1<? super d, Unit> r4);

    void c(StopReason r1);
}
