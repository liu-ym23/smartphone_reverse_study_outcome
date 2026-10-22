package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ ECStockProgressLayout a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public d(ECStockProgressLayout r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void a() {
        int r0 = UtilityKotlinExtentionsKt.d(48);
        long r1 = this.b;
        if (r1 == 0) goto L5;
        float r3 = (1 - ((this.c * 1.0f) / r1)) * 100;
    L6:
        float r2 = 10;
        if (r3 > r2) goto L12;
        float r4 = r0;
        float r5 = r4 / this.a.getWidth();
        ProgressBar r6 = this.a.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L11:
        r6.setProgress((int) (r5 * 100));
        ECStockProgressLayout.a(this.a, r4);
    L16:
        TextView r7 = this.a.d;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r4 < r7.getLeft()) goto L25;
        TextView r8 = this.a.d;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r8.setVisibility(4);
        return;
    L25:
        TextView r9 = this.a.d;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L28:
        r9.setVisibility(0);
        return;
    L12:
        float r10 = r0;
        r4 = r10 + (((r3 - r2) / 90) * (this.a.getWidth() - r10));
        ProgressBar r11 = this.a.a;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L15:
        r11.setProgress((int) ((r4 / this.a.getWidth()) * 100));
        ECStockProgressLayout.a(this.a, r4);
        goto L16
    L5:
        r3 = 0.0f;
        goto L6
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
