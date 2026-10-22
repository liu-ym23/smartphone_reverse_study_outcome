package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements Runnable {
    public final /* synthetic */ PromotionCardImageComponent a;
    public final /* synthetic */ y0 b;

    public static final class a implements Runnable {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.f.setVisibility(8);     // Catch: Throwable -> L10
            PromotionCardImageComponent r0 = this.a.a;     // Catch: Throwable -> L10
            jj2.c r1 = r0.c;     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            z0 r2 = r1.c;     // Catch: Throwable -> L10
            if (r2 == null) goto L7;
            List r3 = r2.g();     // Catch: Throwable -> L10
        L8:
            UtilityKotlinExtentionsKt.f(r1, r3, new PromotionCardImageComponent$updateLeftTag$1(r0));     // Catch: Throwable -> L10
            return;
        L7:
            r3 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public k(PromotionCardImageComponent r1, y0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECDraweeView r0 = this.a.f;     // Catch: Throwable -> L4
        UIConfigHelper.a(r0, r0, new a(this));     // Catch: Throwable -> L4
        this.a.r.invoke(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
