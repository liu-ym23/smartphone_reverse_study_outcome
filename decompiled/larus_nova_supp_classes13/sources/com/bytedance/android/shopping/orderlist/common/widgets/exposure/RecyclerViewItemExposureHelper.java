package com.bytedance.android.shopping.orderlist.common.widgets.exposure;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy.OrderListOftenBuyRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/exposure/RecyclerViewItemExposureHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewItemExposureHelper extends RecyclerView.OnScrollListener {
    public Function1<? super Integer, Unit> a;
    public final RecyclerView b;
    public final float c;

    public static final class a implements Runnable {
        public final /* synthetic */ RecyclerViewItemExposureHelper a;

        public a(RecyclerViewItemExposureHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.j();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void j() {
        LinearLayoutManager r1 = this.b.getLayoutManager();
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r1 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r2 = r1;
        int r5 = r2.findFirstVisibleItemPosition();
        int r3 = r2.findLastVisibleItemPosition();
    L27:
        Pair r4 = TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r3));
        int r6 = ((Number) r4.component1()).intValue();
        int r7 = ((Number) r4.component2()).intValue();
        if (r6 > r7) goto L68;
    L29:
        View r8 = r1.findViewByPosition(r6);
        if (r8 != null) goto L32;
    L31:
        LinearLayoutManager r18 = r1;
        int r19 = r7;
    L60:
        boolean r9 = false;
    L61:
        if (r9 == false) goto L65;
        Function1<? super Integer, Unit> r10 = this.a;
        if (r10 == null) goto L65;
        Unit r11 = (Unit) r10.invoke(Integer.valueOf(r6));
    L65:
        int r12 = r19;
        if (r6 == r12) goto L76;
        r6 = r6 + 1;
        r7 = r12;
        r1 = r18;
        goto L29
    L76:
        return;
    L32:
        Rect r13 = new Rect();
        if (r8.getLocalVisibleRect(r13) == false) goto L31;
        double r14 = r8.getHeight();
        double r15 = r8.getWidth();
        if (r14 == 0.0d) goto L31;
        if (r15 == 0.0d) goto L31;
        double r16 = r13.left;
        double r17 = r13.top;
        r18 = r1;
        r19 = r7;
        double r20 = r13.right;
        double r21 = r13.bottom;
        if (r16 == 0.0d) goto L45;
        if (r15 == 0.0d) goto L45;
        r20 = r15 - r16;
    L43:
        double r22 = r20 / r15;
    L58:
        if ((r22 * ((double) 100)) < (this.c * 100)) goto L60;
        r9 = true;
    L45:
        if (r20 == r15) goto L49;
        if (r15 != 0.0d) goto L43;
    L49:
        if (r17 == 0.0d) goto L53;
        if (r14 == 0.0d) goto L53;
        r22 = (r14 - r17) / r14;
    L53:
        if (r21 == r14) goto L56;
        if (r14 == 0.0d) goto L56;
        r22 = r21 / r14;
    L56:
        r22 = 1.0d;
        goto L58
    L68:
        return;
    L9:
        if ((r1 instanceof GridLayoutManager) == false) goto L12;
        GridLayoutManager r23 = (GridLayoutManager) r1;
        r5 = r23.findFirstVisibleItemPosition();
        r3 = r23.findLastVisibleItemPosition();
        goto L27
    L12:
        if ((r1 instanceof StaggeredGridLayoutManager) == false) goto L26;
        StaggeredGridLayoutManager r24 = (StaggeredGridLayoutManager) r1;
        int r25 = r24.getSpanCount();
        int[] r26 = new int[r25];
        int r27 = r24.getSpanCount();
        int[] r28 = new int[r27];
        r24.findFirstVisibleItemPositions(r26);
        r24.findLastVisibleItemPositions(r28);
        int r29 = r26[0];
        int r30 = r28[0];
        int r110 = 1;
    L14:
        if (r110 >= r25) goto L19;
        int r111 = r26[r110];
        if (r29 <= r111) goto L18;
        r29 = r111;
    L18:
        r110 = r110 + 1;
        goto L14
    L19:
        int r31 = 1;
    L20:
        if (r31 >= r27) goto L25;
        int r32 = r28[r31];
        if (r30 >= r32) goto L24;
        r30 = r32;
    L24:
        r31 = r31 + 1;
        goto L20
    L25:
        r5 = r29;
        r3 = r30;
        goto L27
    L26:
        r5 = -1;
        r3 = -1;
        goto L27
    }

    public RecyclerViewItemExposureHelper(OrderListOftenBuyRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.b = r2;
        this.c = 0.8f;
    }

    public final void k(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onShow");
        this.a = r2;
        this.b.removeOnScrollListener(this);
        this.b.addOnScrollListener(this);
        this.b.post(new a(this));
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        j();
    }
}
