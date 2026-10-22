package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardButtonComponent$addCartListener$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a$a, reason: collision with other inner class name */
    public static final class C0088a {
        public static /* synthetic */ Long a(a r7, long r8, long r10) {
            return r7.d(r8, r10, false, false);
        }

        public static /* synthetic */ void c(a r7, String r8, String r9, View r10, int r11) {
            if ((r11 & 2) == 0) goto L5;
            boolean r3 = true;
        L7:
            if ((r11 & 16) == 0) goto L9;
            r10 = null;
        L9:
            r7.a(r8, r3, r9, null, r10);
            return;
        L5:
            r3 = false;
            goto L7
        }

        public static /* synthetic */ void b(a r10, String r11, Integer r12, j0 r13, int r14, PromotionCardButtonComponent$addCartListener$1 r15, com.bytedance.android.btm.api.model.d r16, il2.a r17, int r18) {
            if ((r18 & 8) == 0) goto L5;
            int r5 = 0;
        L7:
            if ((r18 & 32) == 0) goto L9;
            PromotionCardButtonComponent$addCartListener$1 r7 = null;
        L10:
            r10.c(r11, r12, r13, r5, 0, r7, r16, r17);
            return;
        L9:
            r7 = r15;
            goto L10
        L5:
            r5 = r14;
            goto L7
        }
    }

    void a(String r1, boolean r2, String r3, BtmItemBuilder r4, View r5);

    LivePromotionCardV2$containerAbility$1$eventAction$1 b();

    void c(String r1, Integer r2, j0 r3, int r4, int r5, cf.a r6, com.bytedance.android.btm.api.model.d r7, il2.a r8);

    Long d(long r1, long r3, boolean r5, boolean r6);

    void e(Action r1);

    boolean f(View r1);
}
