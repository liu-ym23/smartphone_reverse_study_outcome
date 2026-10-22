package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public final Context a;
    public final String b;
    public final ViewGroup c;
    public final Map<String, Object> d;
    public final boolean e;
    public final ti.k f;

    public static final class a implements ti.k {
        public a() {
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onRuntimeReady(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        }

        public final void onLoadFailed(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void onPageStart(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void s(View r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L18;
        o r4 = (o) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ViewGroup r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.e;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        int r15 = (r12 + r14) * 31;
        ti.k r16 = this.f;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxViewOption(context=" + this.a + ", url=" + this.b + ", viewGroup=" + this.c + ", initData=" + this.d + ", autoDetachIfFail=" + this.e + ", callback=" + this.f + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public o(Context r2, String r3, ViewGroup r4, Map<String, ? extends Object> r5, boolean r6, ti.k r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ o(Context r10, String r11, ViewGroup r12, Map r13, boolean r14, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c.b r15, int r16) {
        if ((r16 & 4) == 0) goto L5;
        ViewGroup r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Map r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r16 & 32) == 0) goto L17;
        ti.k r8 = new a();
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
