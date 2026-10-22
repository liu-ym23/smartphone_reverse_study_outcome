package com.bytedance.android.shopping.sku.common.controller;

import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final int a;
    public a b;
    public final SlcRenderContext c;
    public final Window d;
    public final RecyclerView e;
    public final ViewGroup f;

    public static final class a implements SlcKeyboardMonitor.c {
        public final /* synthetic */ c a;

        public final void a() {
            RecyclerView r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.setPadding(0, 0, 0, 0);
            return;
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void b(int r3) {
            c r0 = this.a;
            RecyclerView r1 = r0.e;
            if (r1 == null) goto L6;
            r1.setPadding(0, 0, 0, r3 - r0.f.getHeight());
            return;
        }
    }

    public c(SlcRenderContext r2, Window r3, RecyclerView r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "footerView");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        if (r3 == null) goto L7;
        WindowManager.LayoutParams r6 = r3.getAttributes();
        if (r6 == null) goto L7;
        int r7 = r6.softInputMode;
    L8:
        this.a = r7;
        if (r3 == null) goto L11;
        r3.setSoftInputMode(48);
    L11:
        a r8 = new a(this);
        this.b = r8;
        if (r2 == null) goto L15;
        r2.n(r8);
        return;
    L15:
        return;
    L7:
        r7 = 0;
        goto L8
    }
}
