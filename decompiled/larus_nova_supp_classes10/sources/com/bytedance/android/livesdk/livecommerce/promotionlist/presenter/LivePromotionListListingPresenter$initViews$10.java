package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0015\u0010\u0003\u001a\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "p1", "", "Lkotlin/ParameterName;", "name", "productId", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListListingPresenter$initViews$10 extends FunctionReferenceImpl implements Function1<String, Pair<? extends float[], ? extends float[]>> {
    public LivePromotionListListingPresenter$initViews$10(LivePromotionListListingPresenter r8) {
        super(1, r8, LivePromotionListListingPresenter.class, "getCardLocation", "getCardLocation(Ljava/lang/String;)Lkotlin/Pair;", 0);
    }

    public final Pair<float[], float[]> invoke(String r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        LivePromotionListListingPresenter r0 = (LivePromotionListListingPresenter) ((CallableReference) this).receiver;
        if (r0.k != null) goto L5;
        return null;
    L5:
        if (r0.m == null) goto L50;
        PromotionLinearLayoutManager r1 = r0.l;
        if (r1 == null) goto L51;
        int r2 = r1.findFirstVisibleItemPosition();
        PromotionLinearLayoutManager r3 = r0.l;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L11:
        int r4 = r3.findLastVisibleItemPosition();
        Iterator<ql.a> r5 = r0.d0().getTotalPromotions().iterator();
        int r6 = 0;
    L13:
        if (r5.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r5.next().getProductId(), r9) == true) goto L19;
        r6 = r6 + 1;
    L19:
        Integer r10 = Integer.valueOf(r6);
        if (r10.intValue() < 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L26;
        r10 = null;
    L26:
        if (r10 == null) goto L52;
        int r11 = r10.intValue();
        LivePromotionListPageAdapter r8 = r0.m;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L30:
        int r12 = r11 + (r8.c ? 1 : 0);
        if (r2 > r12) goto L43;
        if (r4 <= r12) goto L43;
        PromotionRecyclerView r13 = r0.k;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L37:
        RecyclerView.ViewHolder r14 = r13.findViewHolderForAdapterPosition(r12);
        if ((r14 instanceof LivePromotionItemViewHolder) == true) goto L40;
        r14 = null;
    L40:
        LivePromotionItemViewHolder r15 = (LivePromotionItemViewHolder) r14;
        if (r15 == null) goto L53;
        View r16 = r15.a.F0(PromotionCardModuleName.CardModule);
        int[] r17 = wg.a.c(r16);
        float r18 = r17[0];
        return new Pair(new float[]{r18, r17[1]}, new float[]{r18 + r16.getWidth(), r17[1] + r16.getHeight()});
    L53:
        return null;
    L43:
        View r19 = ((QFragmentPresenter) r0).e.getView();
        if (r19 == null) goto L55;
        float[] r20 = cf.m.a(r19);
        return new Pair(r20, r20);
    L55:
        return null;
    L52:
        return null;
    L22:
        r7 = false;
        goto L23
    L18:
        r6 = -1;
        goto L19
    L51:
        return null;
    L50:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
