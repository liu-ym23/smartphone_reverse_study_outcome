package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r2, String r3, String r4, PageFinder r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            boolean r7 = true;
        L12:
            r2.q(r3, r4, r5, r7);
            return;
        L11:
            r7 = false;
            goto L12
        }
    }

    void p(GULFeedbackDislikeReq r1);

    void q(String r1, String r2, PageFinder r3, boolean r4);

    void r(String r1, String r2, String r3, String r4, String r5);

    void s(String r1, String r2, String r3, String r4);

    void t(String r1, String r2, String r3, String r4);

    void u(ItemCardRecommendReasonStruct r1, j63.c r2, Integer r3);

    void v(j63.c r1, String r2);

    void w(String r1, String r2, String r3, boolean r4, String r5, j63.c r6);
}
