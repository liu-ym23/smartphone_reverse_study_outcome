package com.bytedance.android.shopping.feed.adapter;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.innerflow.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/QuickDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickDividerItemDecoration extends RecyclerView.ItemDecoration {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> a;
    public Resources b;
    public final b c;
    public final a d;

    public interface a {
        void a(Rect r1, b r2);
    }

    public final class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public final /* synthetic */ QuickDividerItemDecoration f;

        public final String toString() {
            return "State{nextType=" + this.a + ", preType=" + this.b + ", pos=" + this.c + ", curType=" + this.d + ", count=" + this.e + '}';
        }

        public b(QuickDividerItemDecoration r1) {
            this.f = r1;
        }

        public final void a(int r4) {
            this.e = this.f.a.getItemCount();
            int r0 = -1;
            if (r4 <= 0) goto L5;
            int r1 = this.f.a.getItemViewType(r4 - 1);
        L6:
            this.b = r1;
            this.d = this.f.a.getItemViewType(r4);
            if (r4 >= (this.f.a.getItemCount() - 2)) goto L9;
            r0 = this.f.a.getItemViewType(r4 + 1);
        L9:
            this.a = r0;
            this.c = r4;
            return;
        L5:
            r1 = -1;
            goto L6
        }
    }

    public QuickDividerItemDecoration(JediBaseMultiTypeAdapter r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "render");
        new SparseArray();
        this.c = new b(this);
        this.a = r2;
        this.d = r3;
    }

    public final void onDraw(Canvas r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.onDraw(r3, r4, r5);
        if (this.a.getItemCount() != 0) goto L5;
        return;
    L5:
        int r6 = r4.getChildCount();
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L15;
        View r0 = r4.getChildAt(r7);
        if (r0.getLayoutParams() == null) goto L14;
        int r1 = r4.getChildAdapterPosition(r0);
        if (r1 > (this.a.getItemCount() - 1)) goto L11;
        this.c.a(r1);
        r7 = r7 + 1;
        goto L6
    L11:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        if (this.a.getItemCount() != 0) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        this.b = r4.getResources();
    L8:
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != (-1)) goto L11;
        return;
    L11:
        if (r6 > (this.a.getItemCount() - 1)) goto L19;
        this.c.a(r6);
        a r7 = this.d;
        if (r7 == null) goto L18;
        r7.a(r2, this.c);
        return;
    L18:
        return;
    }
}
