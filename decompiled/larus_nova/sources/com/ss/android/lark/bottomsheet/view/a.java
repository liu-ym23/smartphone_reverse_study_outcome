package com.ss.android.lark.bottomsheet.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f410750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f410751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f410752c;

    /* JADX INFO: renamed from: com.ss.android.lark.bottomsheet.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC4773a {
        void a();

        void b();

        void c();

        void d(float r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f410753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f410754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f410755c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f410753a == r101.f410753a) goto L12;
            return false;
        L12:
            if (this.f410754b == r101.f410754b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f410755c, r101.f410755c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f410753a * 31;
            long r101 = this.f410754b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Interpolator r103 = this.f410755c;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "AnimatorConfig(targetTopMargin=" + this.f410753a + ", duration=" + this.f410754b + ", interpolator=" + this.f410755c + ')';
        }

        public b(int r100, long r101) {
            this.f410753a = r100;
            this.f410754b = r101;
            this.f410755c = null;
        }
    }

    public final ValueAnimator a() {
        return (ValueAnimator) this.f410752c.getValue();
    }

    public a(CoordinatorLayout r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f410750a = r100;
        this.f410751b = r101;
        this.f410752c = LazyKt.lazy(new ExpandValueAnimator$animator$2(this));
    }
}
