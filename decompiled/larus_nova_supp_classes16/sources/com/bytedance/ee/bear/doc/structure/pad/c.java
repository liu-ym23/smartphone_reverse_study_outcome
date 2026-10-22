package com.bytedance.ee.bear.doc.structure.pad;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ CenterLayoutManager a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RecyclerView c;

    public c(CenterLayoutManager r1, int r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        View r0 = this.a.findViewByPosition(this.b);
        if (r0 == null) goto L33;
        CenterLayoutManager r1 = this.a;
        RecyclerView r2 = this.c;
        if (r1.getOrientation() != 1) goto L7;
        int r3 = r2.getHeight() / 2;
    L9:
        if (r1.getOrientation() != 1) goto L11;
        int r5 = r0.getTop();
        int r4 = r0.getHeight() / 2;
    L12:
        int r6 = (r5 + r4) - r3;
        View r7 = r1.getChildAt(0);
        if (r7 != null) goto L16;
        int r8 = 0;
    L23:
        int r9 = -r8;
        if (r6 >= r9) goto L26;
        r6 = r9;
    L29:
        if (r1.getOrientation() != 1) goto L31;
        r2.scrollBy(0, r6);
        return;
    L31:
        r2.scrollBy(r6, 0);
        return;
    L26:
        if (r6 <= r8) goto L29;
        r6 = r8;
        goto L29
    L16:
        if (r1.getOrientation() != 1) goto L18;
        int r10 = r7.getHeight();
    L19:
        int r11 = r1.getItemCount() * r10;
        if (r1.getOrientation() != 1) goto L22;
        r8 = RangesKt.coerceAtLeast(r11 - r2.getHeight(), 0);
        goto L23
    L22:
        r8 = RangesKt.coerceAtLeast(r11 - r2.getWidth(), 0);
        goto L23
    L18:
        r10 = r7.getWidth();
        goto L19
    L11:
        r5 = r0.getLeft();
        r4 = r0.getWidth() / 2;
        goto L12
    L7:
        r3 = r2.getWidth() / 2;
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
