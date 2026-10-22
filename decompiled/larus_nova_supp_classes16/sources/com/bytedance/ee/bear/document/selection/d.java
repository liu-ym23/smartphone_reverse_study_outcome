package com.bytedance.ee.bear.document.selection;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "AnimatorParams(speed=" + this.a + ", scrollDirection=" + this.b + ", isHandle=" + this.c + ')';
        }

        public a(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public interface b {
    }

    public d() {
    }

    public static ValueAnimator a(WebView r3, a r4, v r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "params");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(Long.MAX_VALUE);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new e(r4, r3, r5));
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
