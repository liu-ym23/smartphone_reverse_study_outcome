package com.bytedance.android.shopping.deepfeed.action;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bytedance.android.shopping.deepfeed.DeepFeedProductFragment;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductSnapHelper;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements h {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.action.b$a$a, reason: collision with other inner class name */
        public static final class C0050a {
            public final Function0<RecyclerView> a;
            public final CoroutineScope b;
            public final Context c;
            public final DeepFeedProductViewModel d;
            public final LifecycleOwner e;
            public final SnapHelper f;
            public final Function0<Fragment> g;
            public final Function1<Boolean, Unit> h;
            public final Fragment i;
            public final boolean j;
            public final boolean k;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0050a) == false) goto L28;
                C0050a r4 = (C0050a) r3;
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
                if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
                return false;
            L24:
                if (this.j == r4.j) goto L26;
                return false;
            L26:
                if (this.k == r4.k) goto L43;
                return false;
            L43:
                return true;
            L28:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v20, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23, types: [int] */
            /* JADX WARN: Type inference failed for: r2v24 */
            public final int hashCode() {
                Function0<RecyclerView> r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                CoroutineScope r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Context r7 = this.c;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                DeepFeedProductViewModel r10 = this.d;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                LifecycleOwner r13 = this.e;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                SnapHelper r16 = this.f;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                Function0<Fragment> r19 = this.g;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                Function1<Boolean, Unit> r22 = this.h;
                if (r22 == null) goto L33;
                int r23 = r22.hashCode();
            L34:
                int r24 = (r21 + r23) * 31;
                Fragment r25 = this.i;
                if (r25 == null) goto L37;
                r1 = r25.hashCode();
            L37:
                int r26 = (r24 + r1) * 31;
                boolean r27 = this.j;
                ?? r28 = 1;
                ?? r29 = r27;
                if (r27 == false) goto L40;
                r29 = 1;
            L40:
                int r30 = (r26 + r29) * 31;
                boolean r31 = this.k;
                if (r31 == true) goto L45;
                r28 = r31;
            L45:
                return r30 + r28;
            L33:
                r23 = 0;
                goto L34
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
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
                return "Config(rvProvider=" + this.a + ", lifeScope=" + this.b + ", context=" + this.c + ", viewModel=" + this.d + ", lifeOwner=" + this.e + ", snapHelper=" + this.f + ", fragment=" + this.g + ", updateCurState=" + this.h + ", container=" + this.i + ", gestureTrackingEnabled=" + this.j + ", infoSwipeEnterDetailEnabled=" + this.k + ")";
            }

            public final Context getContext() {
                return this.c;
            }

            public C0050a(Function0 r2, LifecycleCoroutineScope r3, FragmentActivity r4, DeepFeedProductViewModel r5, LifecycleOwner r6, DeepFeedProductSnapHelper r7, Function0 r8, Function1 r9, DeepFeedProductFragment r10, boolean r11, boolean r12) {
                Intrinsics.checkNotNullParameter(r2, "rvProvider");
                Intrinsics.checkNotNullParameter(r3, "lifeScope");
                Intrinsics.checkNotNullParameter(r5, "viewModel");
                Intrinsics.checkNotNullParameter(r6, "lifeOwner");
                Intrinsics.checkNotNullParameter(r7, "snapHelper");
                Intrinsics.checkNotNullParameter(r8, "fragment");
                Intrinsics.checkNotNullParameter(r9, "updateCurState");
                Intrinsics.checkNotNullParameter(r10, "container");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
                this.g = r8;
                this.h = r9;
                this.i = r10;
                this.j = r11;
                this.k = r12;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void c() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void h() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void i() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void j() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void l() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void n() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void o() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void p(com.bytedance.android.shopping.deepfeed.viewmodel.b r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void q() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void r(com.bytedance.android.shopping.deepfeed.viewmodel.e r2) {
        Intrinsics.checkNotNullParameter(r2, "shopStatus");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void s() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void z() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public Context getContext() {
        return h.a.getContext(this);
    }

    public b() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "popupType");
        Intrinsics.checkNotNullParameter(r2, "popupType");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void t(com.bytedance.android.shopping.deepfeed.data.e r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void u(com.bytedance.android.shopping.deepfeed.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r2, "status");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void y(com.bytedance.android.shopping.deepfeed.data.d r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r2, "params");
    }
}
