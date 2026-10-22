package com.bytedance.android.shopping.deepfeed.data;

import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final boolean b;
    public final int c;
    public final int d;
    public final View e;
    public final long f;
    public final PathInterpolator g;
    public final Function0<Unit> h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L22;
        d r7 = (d) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31;
        View r7 = this.e;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        PathInterpolator r12 = this.g;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        Function0<Unit> r15 = this.h;
        if (r15 == null) goto L21;
        r1 = r15.hashCode();
    L21:
        return r14 + r1;
    L16:
        r13 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedScrollTopParams(tipsText=" + this.a + ", isShowTips=" + this.b + ", finalHeight=" + this.c + ", position=" + this.d + ", view=" + this.e + ", durationMs=" + this.f + ", interpolator=" + this.g + ", callback=" + this.h + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r2, boolean r3, int r4, int r5, DeepFeedProductSlcView r6, long r7, PathInterpolator r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r2, "tipsText");
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
    }
}
