package com.larus.bmhome.chat.outerinput;

import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r100, String r101, FrameLayout r102, com.larus.bmhome.notification.n r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            boolean r105 = true;
        L7:
            if ((r104 & 8) == 0) goto L9;
            r103 = null;
        L9:
            r100.b(r101, r102, r105, r103);
            return;
        L5:
            r105 = false;
            goto L7
        }
    }

    boolean a();

    void b(String r100, FrameLayout r101, boolean r102, Function1<? super Integer, Unit> r103);

    void c(String r100);
}
