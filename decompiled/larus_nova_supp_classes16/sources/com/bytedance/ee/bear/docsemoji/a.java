package com.bytedance.ee.bear.docsemoji;

import android.content.Context;
import android.widget.ImageView;
import sz7.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements uz4.a {
    public a() {
    }

    @Override // uz4.a
    public final void b(String r11, String r12, ImageView r13) {
        q r9 = new q(r13.getContext());
        q.d(r9, r11, r12, -1, -1, null, false, null);
        r13.setImageDrawable(r9);
    }

    @Override // uz4.a
    public final q a(Context r10, String r11, String r12, int r13) {
        q r8 = new q(r10);
        q.d(r8, r11, r12, -1, -1, r10.getDrawable(r13), false, null);
        return r8;
    }

    @Override // uz4.a
    public final void c(String r2, String r3, int r4, ImageView r5) {
        r5.setImageDrawable(a(r5.getContext(), r2, r3, r4));
    }

    @Override // uz4.a
    public final void d(String r11, String r12, int r13, ImageView r14, boolean r16) {
        Context r0 = r14.getContext();
        q r9 = new q(r0);
        q.d(r9, r11, r12, -1, -1, r0.getDrawable(r13), r16, 0);
        r14.setImageDrawable(r9);
    }
}
