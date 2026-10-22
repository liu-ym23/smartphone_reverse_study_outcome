package com.ss.android.lark.bottomsheet.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ExpandValueAnimatorInForseti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f410735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tua.b f410736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f410737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f410738d;

    public interface a {
        void a();

        void b();

        void c();

        void d(float r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f410740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f410741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f410742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Interpolator f410743d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f410740a == r101.f410740a) goto L12;
            return false;
        L12:
            if (this.f410741b == r101.f410741b) goto L15;
            return false;
        L15:
            if (this.f410742c == r101.f410742c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f410743d, r101.f410743d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f410740a * 31) + this.f410741b) * 31;
            long r101 = this.f410742c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Interpolator r103 = this.f410743d;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "AnimatorConfig(startY=" + this.f410740a + ", endY=" + this.f410741b + ", duration=" + this.f410742c + ", interpolator=" + this.f410743d + ')';
        }

        public b(int r100, int r101, long r102) {
            this.f410740a = r100;
            this.f410741b = r101;
            this.f410742c = r102;
            this.f410743d = null;
        }
    }

    public final ValueAnimator a() {
        return (ValueAnimator) this.f410738d.getValue();
    }

    public ExpandValueAnimatorInForseti(View r100, b r101, tua.b r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f410735a = r100;
        this.f410736b = r102;
        this.f410737c = r101;
        this.f410738d = LazyKt.lazy(new ExpandValueAnimatorInForseti$animator$2(this));
    }
}
