package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/e;", "data", "", "setDataWithAutoScroll", "", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "InnerAdapter", "InnerSmoothScroller", "PlaceHolderViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionAutoRecycleView extends RecyclerView {
    public final List<e> a;
    public final Lazy b;
    public final InnerSmoothScroller c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "InnerViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InnerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final int a;
        public final List<e> b;
        public final /* synthetic */ InteractionAutoRecycleView c;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerAdapter$InnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public final class InnerViewHolder extends RecyclerView.ViewHolder {
            public InnerViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
            }
        }

        public final int getItemCount() {
            if (((ArrayList) this.c.a).size() < 4) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return this.b.size() + 1;
        L5:
            r0 = false;
            goto L6
        }

        public final int getItemViewType(int r1) {
            if (r1 != 0) goto L5;
            return 0;
        L5:
            return this.a;
        }

        public InnerAdapter(InteractionAutoRecycleView r2, List<e> r3) {
            Intrinsics.checkNotNullParameter(r3, "itemList");
            this.c = r2;
            this.b = r3;
            this.a = 1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
            Intrinsics.checkNotNullParameter(r14, "holder");
            if ((r14 instanceof InnerViewHolder) == false) goto L24;
            boolean r1 = true;
            if ((!this.b.isEmpty()) == false) goto L25;
            if (r15 <= 0) goto L26;
            InnerViewHolder r16 = (InnerViewHolder) r14;
            e r17 = (e) ListProtector.get(this.b, (r15 - 1) % this.b.size());
            r16.getClass();
            Intrinsics.checkNotNullParameter(r17, "item");
            View r0 = ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131378613);
            List<String> r2 = r17.c;
            if (r2 != null) goto L10;
        L16:
            TextView r18 = (TextView) ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131390822);
            r18.setText(r17.b);
            if (r17.getType() != 2) goto L19;
        L21:
            r1 = false;
        L22:
            r18.setSingleLine(r1);
            return;
        L19:
            if (r17.getType() == 1) goto L21;
        L10:
            if ((!r2.isEmpty()) == false) goto L15;
            ECDraweeView r3 = ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131376020);
            ECDraweeView r4 = ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131376021);
            h0.e(r3, (String) ListProtector.get(r2, 0), null, null, null, 120);
            if (r2.size() <= 1) goto L14;
            r4.setVisibility(0);
            r3.setTranslationZ(1.0f);
            h0.e(((RecyclerView.ViewHolder) r16).itemView.findViewById(2131376021), (String) ListProtector.get(r2, 1), null, null, null, 120);
            goto L16
        L14:
            r4.setVisibility(8);
            goto L16
        L15:
            r0.setVisibility(8);
            goto L16
        L26:
            return;
        L25:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != 0) goto L7;
            View r5 = new View(this.c.getContext());
            r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Unit r6 = Unit.INSTANCE;
            return new PlaceHolderViewHolder(r5);
        L7:
            return new InnerViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560693, r3, false));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InnerSmoothScroller extends LinearSmoothScroller {
        public final int getVerticalSnapPreference() {
            return 1;
        }

        public InnerSmoothScroller(Context r1) {
            super(r1);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics r2) {
            if (r2 != null) goto L6;
            return super.calculateSpeedPerPixel(r2);
        L6:
            return 300.0f / r2.densityDpi;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$PlaceHolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PlaceHolderViewHolder extends RecyclerView.ViewHolder {
        public PlaceHolderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    private final Handler getMHandler() {
        return (Handler) this.b.getValue();
    }

    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getTopFadingEdgeStrength() {
        return super/*android.view.ViewGroup*/.getTopFadingEdgeStrength();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMHandler().removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractionAutoRecycleView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        ArrayList r0 = new ArrayList();
        this.a = r0;
        this.b = LazyKt.lazy(InteractionAutoRecycleView$mHandler$2.INSTANCE);
        setLayoutManager(new LinearLayoutManager(r3));
        this.c = new InnerSmoothScroller(r3);
        setAdapter(new InnerAdapter(this, r0));
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(UtilityKotlinExtentionsKt.d(26));
        addItemDecoration(new InteractionAutoRecycleView$itemDecoration$1());
    }

    public static final /* synthetic */ Handler r(InteractionAutoRecycleView r0) {
        return r0.getMHandler();
    }

    public final void setDataWithAutoScroll(List<e> r4) {
        if (r4 == null) goto L8;
        ((ArrayList) this.a).clear();
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r4);
        RecyclerView.Adapter r5 = getAdapter();
        if (r5 == null) goto L6;
        r5.notifyDataSetChanged();
    L6:
        ViewExtensionsKt.d(this);
        getMHandler().removeCallbacksAndMessages(null);
        c r6 = new c(this);
        getMHandler().postDelayed(r6, 500);
        return;
    }
}
