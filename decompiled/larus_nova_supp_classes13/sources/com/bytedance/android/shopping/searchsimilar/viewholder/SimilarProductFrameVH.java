package com.bytedance.android.shopping.searchsimilar.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductFrameView;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import gh3.c;
import gh3.g;
import gh3.h;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/viewholder/SimilarProductFrameVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFrameVH extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final Set<String> a;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ SimilarProductFrameVH a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public a(SimilarProductFrameVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r7) {
            Intrinsics.checkNotNullParameter(r7, "v");
            SimilarProductFrameVH r8 = this.a;
            int r0 = SimilarProductFrameVH.b;
            View r1 = ((RecyclerView.ViewHolder) r8).itemView;
            String r2 = null;
            if ((r1 instanceof SimilarProductFrameView) == true) goto L5;
            r1 = null;
        L5:
            SimilarProductFrameView r3 = (SimilarProductFrameView) r1;
            if (r3 == null) goto L30;
            Set<String> r9 = r8.a;
            Intrinsics.checkNotNullParameter(r9, "watchList");
            ProductFrame r4 = r3.f;
            if (r4 == null) goto L10;
            String r5 = r4.getId();
        L12:
            if (r9.contains(r5) == true) goto L31;
            ProductFrame r6 = r3.f;
            if (r6 == null) goto L16;
            String r10 = r6.getId();
        L17:
            r9.add(r10);
            int r11 = g.a;
            Context r12 = r3.getContext();
            ProductFrame r13 = r3.f;
            if (r13 == null) goto L20;
            String r14 = r13.getId();
        L21:
            Integer r15 = r3.g;
            if (r15 == null) goto L24;
            String r16 = String.valueOf(r15.intValue() + 1);
        L25:
            SimilarProductVM r17 = r3.h;
            Intrinsics.checkNotNullParameter("similar_product_show", "event");
            c r18 = new c("similar_product_show");
            r18.a = r14;
            r18.b = r16;
            if (r17 == null) goto L28;
            r2 = r17.getRequestId();
        L28:
            r18.c = r2;
            h.a(r18, r12);
            return;
        L24:
            r16 = null;
            goto L25
        L20:
            r14 = null;
            goto L21
        L16:
            r10 = null;
            goto L17
        L31:
            return;
        L10:
            r5 = null;
            goto L12
        }
    }

    public interface b {
        void a(int r1);
    }

    public SimilarProductFrameVH(SimilarProductFrameView r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "watchList");
        super(r2);
        this.a = r3;
        ((RecyclerView.ViewHolder) this).itemView.addOnAttachStateChangeListener(new a(this));
    }
}
