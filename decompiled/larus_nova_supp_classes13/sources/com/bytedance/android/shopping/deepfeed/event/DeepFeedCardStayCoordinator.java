package com.bytedance.android.shopping.deepfeed.event;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductSnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedCardStayCoordinator {
    public final Lazy a;
    public final a b;

    public static final class a {
        public final Function0<RecyclerView> a;
        public final Function0<DeepFeedProductAdapter> b;
        public final SnapHelper c;
        public final DeepFeedProductViewModel d;
        public final Function0<AbsDeepFeedProductVH> e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
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
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            Function0<RecyclerView> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Function0<DeepFeedProductAdapter> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            SnapHelper r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            DeepFeedProductViewModel r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Function0<AbsDeepFeedProductVH> r13 = this.e;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
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
            return "Config(rvProvider=" + this.a + ", adapterProvider=" + this.b + ", snapHelper=" + this.c + ", viewModel=" + this.d + ", currentVHProvider=" + this.e + ")";
        }

        public a(Function0 r2, Function0 r3, DeepFeedProductSnapHelper r4, DeepFeedProductViewModel r5, Function0 r6) {
            Intrinsics.checkNotNullParameter(r2, "rvProvider");
            Intrinsics.checkNotNullParameter(r3, "adapterProvider");
            Intrinsics.checkNotNullParameter(r4, "snapHelper");
            Intrinsics.checkNotNullParameter(r5, "viewModel");
            Intrinsics.checkNotNullParameter(r6, "currentVHProvider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final DeepFeedCardStayTracker a() {
        return (DeepFeedCardStayTracker) this.a.getValue();
    }

    public final void b() {
        DeepFeedCardStayTracker r0 = a();
        if (r0.h == true) goto L5;
        return;
    L5:
        if (r0.i == false) goto L10;
        r0.c();
        return;
    }

    public DeepFeedCardStayCoordinator(a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
        this.a = LazyKt.lazy(new DeepFeedCardStayCoordinator$tracker$2(this));
    }
}
