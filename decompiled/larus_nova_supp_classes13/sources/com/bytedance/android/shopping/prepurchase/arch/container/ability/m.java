package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface m {

    public static final class a {
        public static /* synthetic */ boolean a(m r1, String r2, boolean r3, String r4, PageFinder r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r3 = true;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = "";
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.a(r2, r3, r4, r5);
        }
    }

    boolean a(String r1, boolean r2, String r3, PageFinder r4);

    m b(String r1);

    m c(View r1, String r2, PageFinder r3);

    m d(Map<String, ? extends Object> r1);
}
