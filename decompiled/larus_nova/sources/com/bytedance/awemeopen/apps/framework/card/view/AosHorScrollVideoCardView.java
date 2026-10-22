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

/* JADX INFO: loaded from: classes14.dex */
public final class AosHorScrollVideoCardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f193892a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$CardLoadingStatus;", "", "LOADING", "LOAD_SUCCESS", "LOAD_FAILED", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum CardLoadingStatus extends Enum<CardLoadingStatus> {
        public static final CardLoadingStatus LOADING = null;
        public static final CardLoadingStatus LOAD_FAILED = null;
        public static final CardLoadingStatus LOAD_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardLoadingStatus[] f193893a = null;

        public static CardLoadingStatus valueOf(String r100) {
            return (CardLoadingStatus) r27.a.a(CardLoadingStatus.class, r100);
        }

        public static CardLoadingStatus[] values() {
            return (CardLoadingStatus[]) f193893a.clone();
        }

        static {
            CardLoadingStatus r100 = new CardLoadingStatus("LOADING", 0);
            LOADING = r100;
            CardLoadingStatus r101 = new CardLoadingStatus("LOAD_SUCCESS", 1);
            LOAD_SUCCESS = r101;
            CardLoadingStatus r102 = new CardLoadingStatus("LOAD_FAILED", 2);
            LOAD_FAILED = r102;
            f193893a = new CardLoadingStatus[]{r100, r101, r102};
        }

        public CardLoadingStatus(String r100, int r101) {
            super(r100, r101);
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            int r100 = AosHorScrollVideoCardView.f193892a;
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            int r101 = AosHorScrollVideoCardView.f193892a;
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            if ((r100 instanceof CardViewHolder) == true) goto L5;
            return;
        L5:
            CardViewHolder r102 = (CardViewHolder) r100;
            int r103 = AosHorScrollVideoCardView.f193892a;
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != 1) goto L5;
            com.bytedance.awemeopen.apps.framework.card.c r102 = com.bytedance.awemeopen.apps.framework.card.c.f193814a;
            int r103 = AosHorScrollVideoCardView.f193892a;
            throw null;
        L5:
            if (r101 == 2) goto L9;
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
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(0);
        Intrinsics.checkNotNullParameter("#0D161823", "<this>");
        r100.setColor(ColorProtector.parseColor("#0D161823"));
        Resources r101 = Resources.getSystem();
        r100.setCornerRadius(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        return r100;
    }

    public void setOnCardClickListener(t44.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardListener");
        throw null;
    }
}
