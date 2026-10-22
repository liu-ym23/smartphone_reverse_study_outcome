package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r2, String r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            r2.b(r3, r4);
        }
    }

    void a(String r1);

    void b(String r1, String r2);

    void c(String r1, ProductInfo r2);
}
