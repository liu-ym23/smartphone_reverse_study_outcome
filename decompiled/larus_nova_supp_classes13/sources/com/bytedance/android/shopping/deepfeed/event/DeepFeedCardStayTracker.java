package com.bytedance.android.shopping.deepfeed.event;

import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductAdapter;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedCardStayTracker {
    public InFeedProductV2 a;
    public int b;
    public String c;
    public String d;
    public View e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final DeepFeedCardStayTracker$appLifecycleObserver$1 m;
    public final Function0<RecyclerView> n;
    public final Function0<DeepFeedProductAdapter> o;
    public final SnapHelper p;
    public final DeepFeedProductViewModel q;
    public final Function0<AbsDeepFeedProductVH> r;

    public static final class a {
    }

    static {
    }

    public final void c() {
        RecyclerView r0 = (RecyclerView) this.n.invoke();
        View r1 = null;
        if (r0 == null) goto L45;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        if (r2 == null) goto L45;
        View r3 = this.p.findSnapView(r2);
        if (r3 == null) goto L16;
        int r4 = r2.getPosition(r3);
        if (r4 == (-1)) goto L16;
        Integer r5 = Integer.valueOf(r4);
        DeepFeedProductAdapter r6 = (DeepFeedProductAdapter) this.o.invoke();
        if (r6 == null) goto L14;
        InFeedProductV2 r7 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem(r6, r4, false);
    L15:
        Pair r8 = TuplesKt.to(r5, r7);
    L46:
        if (r8 == null) goto L48;
        int r9 = ((Number) r8.component1()).intValue();
        InFeedProductV2 r10 = (InFeedProductV2) r8.component2();
        RecyclerView r11 = (RecyclerView) this.n.invoke();
        if (r11 == null) goto L56;
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
        if (r12 == null) goto L56;
        r1 = r12.findViewByPosition(r9);
    L56:
        b(r9, r10, true, null, r1);
        return;
    L48:
        if (this.g == false) goto L59;
        a("card_switch");
        return;
    L59:
        return;
    L14:
        r7 = null;
    L16:
        RecyclerView r13 = (RecyclerView) this.n.invoke();
        if (r13 == null) goto L45;
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if ((r14 instanceof LinearLayoutManager) == true) goto L22;
        r14 = null;
    L22:
        LinearLayoutManager r15 = (LinearLayoutManager) r14;
        if (r15 == null) goto L45;
        int r16 = r13.getPaddingTop();
        int r17 = r13.getHeight() - r13.getPaddingBottom();
        int r18 = r15.findFirstVisibleItemPosition();
        int r19 = r15.findLastVisibleItemPosition();
        int r20 = 0;
        int r110 = -1;
        if (r18 > r19) goto L36;
    L27:
        if (r18 == (-1)) goto L34;
        View r111 = r15.findViewByPosition(r18);
        if (r111 == null) goto L34;
        int r112 = Math.min(r17, r111.getBottom()) - Math.max(r16, r111.getTop());
        if (r112 <= r20) goto L34;
        r110 = r18;
        r20 = r112;
    L34:
        if (r18 == r19) goto L36;
        r18 = r18 + 1;
    L36:
        int r21 = (int) (r13.getHeight() * 0.5f);
        if (r110 == (-1)) goto L45;
        if (r20 < r21) goto L45;
        Integer r22 = Integer.valueOf(r110);
        DeepFeedProductAdapter r23 = (DeepFeedProductAdapter) this.o.invoke();
        if (r23 == null) goto L43;
        InFeedProductV2 r24 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem(r23, r110, false);
    L44:
        r8 = TuplesKt.to(r22, r24);
        goto L46
    L43:
        r24 = null;
    L45:
        r8 = null;
        goto L46
    }

    public final void a(String r17) {
        if (this.g == true) goto L6;
        this.a = null;
        this.b = -1;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.k = false;
        return;
    L6:
        InFeedProductV2 r8 = this.a;
        int r9 = this.b;
        long r10 = SystemClock.elapsedRealtime() - this.f;
        if (r8 == null) goto L10;
        if (r9 == (-1)) goto L10;
        this.q.reportCardStayTime(r8, r9, r10, r17, this.k, this.d, this.e);
    L10:
        this.a = null;
        this.b = -1;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.k = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.shopping.deepfeed.event.DeepFeedCardStayTracker$appLifecycleObserver$1] */
    public DeepFeedCardStayTracker(Function0<? extends RecyclerView> r2, Function0<DeepFeedProductAdapter> r3, SnapHelper r4, DeepFeedProductViewModel r5, Function0<? extends AbsDeepFeedProductVH> r6) {
        Intrinsics.checkNotNullParameter(r2, "rvProvider");
        Intrinsics.checkNotNullParameter(r3, "adapterProvider");
        Intrinsics.checkNotNullParameter(r4, "snapHelper");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "currentVHProvider");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.r = r6;
        this.b = -1;
        this.h = true;
        this.m = new DeepFeedCardStayTracker$appLifecycleObserver$1(this);
    }

    public final void b(int r3, InFeedProductV2 r4, boolean r5, String r6, View r7) {
        String r0 = f.a(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.c, r0) == false) goto L11;
        if (this.g == false) goto L11;
        return;
    L11:
        if (this.g == false) goto L15;
        if (r5 == false) goto L14;
        a("card_switch");
        goto L15
    L14:
        return;
    L15:
        this.a = r4;
        this.b = r3;
        this.c = r0;
        this.e = r7;
        if (r6 != null) goto L42;
        RecyclerView.ViewHolder r8 = (AbsDeepFeedProductVH) this.r.invoke();
        View r9 = null;
        if (r8 != null) goto L20;
    L27:
        RecyclerView r10 = (RecyclerView) this.n.invoke();
        if (r10 == null) goto L30;
        RecyclerView.ViewHolder r11 = r10.findViewHolderForAdapterPosition(r3);
    L32:
        if ((r11 instanceof AbsDeepFeedProductVH) == true) goto L34;
        r11 = null;
    L34:
        r8 = (AbsDeepFeedProductVH) r11;
    L35:
        if (r8 == null) goto L37;
        String r12 = r8.q;
    L38:
        this.d = r12;
        if (r8 == null) goto L41;
        r9 = r8.itemView;
    L41:
        this.e = r9;
        r6 = r12;
        goto L42
    L37:
        r12 = null;
        goto L38
    L30:
        r11 = null;
        goto L32
    L20:
        if (r8.getAdapterPosition() != r3) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == true) goto L26;
        r8 = null;
    L26:
        if (r8 != null) goto L35;
    L22:
        r1 = false;
    L42:
        this.d = r6;
        this.f = SystemClock.elapsedRealtime();
        this.g = true;
        this.k = this.l;
        this.l = false;
    }
}
