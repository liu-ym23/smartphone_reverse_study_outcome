package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Bitmap b;

    public a(b r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.b == null) goto L5;
        int r0 = (int) UIUtils.dip2Px(this.a.a.getContext(), 14.0f);
        Bitmap r1 = Bitmap.createScaledBitmap(this.b, (int) (((r0 * 1.0f) / this.b.getHeight()) * this.b.getWidth()), r0, true);
        SpannableString r2 = new SpannableString(" ");
        com.bytedance.android.shopping.widget.b r3 = new com.bytedance.android.shopping.widget.b(this.a.a.getContext(), r1);
        r3.a = com.bytedance.android.shopping.extensions.b.b(2);
        r2.setSpan(r3, 0, 1, 17);
        this.a.b.append(r2);
    L5:
        b r4 = this.a;
        r4.b.append(r4.c);
        b r5 = this.a;
        TextView r6 = r5.a.c;
        if (r6 == null) goto L9;
        r6.setText(r5.b);
        return;
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
