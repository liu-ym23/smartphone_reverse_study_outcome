package com.bytedance.awemeopen.apps.framework.card.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosHorScrollVideoCardView extends FrameLayout {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$CardLoadingStatus;", "", "LOADING", "LOAD_SUCCESS", "LOAD_FAILED", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum CardLoadingStatus extends Enum<CardLoadingStatus> {
        public static final CardLoadingStatus LOADING = null;
        public static final CardLoadingStatus LOAD_FAILED = null;
        public static final CardLoadingStatus LOAD_SUCCESS = null;
        public static final /* synthetic */ CardLoadingStatus[] a = null;

        public static CardLoadingStatus valueOf(String r1) {
            return (CardLoadingStatus) r27.a.a(CardLoadingStatus.class, r1);
        }

        public static CardLoadingStatus[] values() {
            return (CardLoadingStatus[]) a.clone();
        }

        static {
            CardLoadingStatus r0 = new CardLoadingStatus("LOADING", 0);
            LOADING = r0;
            CardLoadingStatus r1 = new CardLoadingStatus("LOAD_SUCCESS", 1);
            LOAD_SUCCESS = r1;
            CardLoadingStatus r3 = new CardLoadingStatus("LOAD_FAILED", 2);
            LOAD_FAILED = r3;
            a = new CardLoadingStatus[]{r0, r1, r3};
        }

        public CardLoadingStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$SmallVideoCardRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CardViewHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class SmallVideoCardRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$SmallVideoCardRecyclerAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
        public final class CardViewHolder extends RecyclerView.ViewHolder {
            public CardViewHolder() {
                throw null;
            }
        }

        public final int getItemCount() {
            int r0 = AosHorScrollVideoCardView.a;
            throw null;
        }

        public final int getItemViewType(int r1) {
            int r2 = AosHorScrollVideoCardView.a;
            throw null;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "holder");
            if ((r1 instanceof CardViewHolder) == true) goto L5;
            return;
        L5:
            CardViewHolder r3 = (CardViewHolder) r1;
            int r4 = AosHorScrollVideoCardView.a;
            throw null;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            if (r3 != 1) goto L5;
            com.bytedance.awemeopen.apps.framework.card.c r4 = com.bytedance.awemeopen.apps.framework.card.c.a;
            int r5 = AosHorScrollVideoCardView.a;
            throw null;
        L5:
            if (r3 == 2) goto L9;
            throw new RuntimeException("unSupport view type!");
        L9:
            throw null;
        }
    }

    public static final class a {
    }

    static {
        new ConcurrentHashMap();
    }

    private final Drawable getLoadingRoundDrawable() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        Intrinsics.checkNotNullParameter("#0D161823", "<this>");
        r0.setColor(ColorProtector.parseColor("#0D161823"));
        Resources r2 = Resources.getSystem();
        r0.setCornerRadius(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        return r0;
    }

    public void setOnCardClickListener(t44.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cardListener");
        throw null;
    }
}
