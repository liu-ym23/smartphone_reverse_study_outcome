package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ ECStockProgressLayout a;
    public final /* synthetic */ Float b;
    public final /* synthetic */ String c;

    public l(ECStockProgressLayout r1, Float r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Float r0 = this.b;
        if (r0 == null) goto L8;
        float r1 = 10;
        if (r0.floatValue() > r1) goto L7;
        float r2 = ECStockProgressLayout.a(this.a);
        this.a.getWidth();
        ECStockProgressLayout r3 = this.a;
        ECStockProgressLayout.b(r3, ECStockProgressLayout.a(r3));
    L9:
        TextView r4 = this.a.d;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L12:
        boolean r5 = false;
        if (r2 < r4.getLeft()) goto L18;
        TextView r6 = this.a.d;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L17:
        r6.setVisibility(4);
    L22:
        String r7 = this.c;
        if (r7 != null) goto L25;
        return;
    L25:
        if (r7.length() <= 3) goto L27;
        boolean r8 = true;
    L28:
        Integer r9 = null;
        if (r8 == true) goto L32;
        r7 = null;
    L32:
        if (r7 == null) goto L50;
        TextView r10 = this.a.b;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L37:
        if ((r10.getPaint().measureText(r7) + (UtilityKotlinExtentionsKt.d(8) * 2)) <= r2) goto L51;
        Integer r11 = Integer.valueOf((int) this.a.h);
        if (r11.intValue() <= 1) goto L41;
        r5 = true;
    L41:
        if (r5 == false) goto L43;
        r9 = r11;
    L43:
        if (r9 == null) goto L52;
        int r12 = r9.intValue();
        int r13 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        int r14 = ((int) r2) - (UtilityKotlinExtentionsKt.d(8) * 2);
        TextView r15 = this.a.b;
        if (r15 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L47:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a(r12, r14, r7, r15);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L27:
        r8 = false;
        goto L28
    L18:
        TextView r16 = this.a.d;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L21:
        r16.setVisibility(0);
        goto L22
    L7:
        float r17 = ECStockProgressLayout.a(this.a);
        r2 = r17 + (((this.b.floatValue() - r1) / 90) * (this.a.getWidth() - r17));
        ECStockProgressLayout.b(this.a, r2);
        goto L9
    L8:
        r2 = 0.0f;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
