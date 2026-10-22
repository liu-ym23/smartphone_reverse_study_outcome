package com.bytedance.ee.bear.document.selection;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f221603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f221604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f221605c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f221603a == r101.f221603a) goto L12;
            return false;
        L12:
            if (this.f221604b == r101.f221604b) goto L15;
            return false;
        L15:
            if (this.f221605c == r101.f221605c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f221603a * 31) + this.f221604b) * 31;
            if (this.f221605c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "AnimatorParams(speed=" + this.f221603a + ", scrollDirection=" + this.f221604b + ", isHandle=" + this.f221605c + ')';
        }

        public a(int r100, int r101, boolean r102) {
            this.f221603a = r100;
            this.f221604b = r101;
            this.f221605c = r102;
        }
    }

    public interface b {
    }

    public d() {
    }

    public static ValueAnimator a(WebView r100, a r101, v r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "params");
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(Long.MAX_VALUE);
        r103.setInterpolator(new LinearInterpolator());
        r103.addUpdateListener(new e(r101, r100, r102));
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
