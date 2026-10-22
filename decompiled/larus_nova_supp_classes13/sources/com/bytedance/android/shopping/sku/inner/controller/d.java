package com.bytedance.android.shopping.sku.inner.controller;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public WeakReference<View> a;
    public final a b;
    public boolean c;

    public static final class a implements ul.c {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            if (r2 == false) goto L8;
            WeakReference<View> r3 = this.a.a;
            if (r3 == null) goto L14;
            View r4 = r3.get();
            if (r4 == null) goto L15;
            r4.setVisibility(0);
            return;
        L15:
            return;
        L14:
            return;
        L8:
            WeakReference<View> r5 = this.a.a;
            if (r5 == null) goto L17;
            View r6 = r5.get();
            if (r6 == null) goto L18;
            r6.setVisibility(8);
            return;
        L18:
            return;
        }
    }

    public d() {
        this.b = new a(this);
    }
}
