package com.bytedance.android.shopping.utils.gallery;

import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ String c;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a() {
            float r0 = (this.a.b.getWidth() - this.a.b.getPaddingLeft()) - this.a.b.getPaddingRight();
            StringBuilder r8 = new StringBuilder();
            int r10 = 0;
        L4:
            if (r10 >= this.a.c.length()) goto L9;
            TextPaint r1 = this.a.a.getPaint();
            String r2 = this.a.c;
            int r3 = RangesKt.coerceAtLeast(1, r1.breakText(r2, r10, r2.length(), true, r0, null)) + r10;
            r8.append(this.a.c.subSequence(r10, r3));
            if (r3 >= this.a.c.length()) goto L8;
            r8.append("\n");
        L8:
            r10 = r3;
            goto L4
        L9:
            this.a.a.setText(r8.toString());
            this.a.a.setVisibility(0);
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

    public b(TextView r1, ViewGroup r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.post(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
