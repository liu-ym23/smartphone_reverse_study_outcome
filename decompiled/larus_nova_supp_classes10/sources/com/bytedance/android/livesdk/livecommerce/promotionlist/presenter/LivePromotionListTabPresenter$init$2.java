package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryListAdapter;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryViewHolder;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListScene;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LivePromotionListTabPresenter$init$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public LivePromotionListTabPresenter$init$2(LivePromotionListTabPresenter r8) {
        super(1, r8, LivePromotionListTabPresenter.class, "updateStyle", "updateStyle(Ljava/lang/Integer;)V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView] */
    public final void invoke(Integer r9) {
        LivePromotionListTabPresenter r0 = (LivePromotionListTabPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListTabPresenter.n;
        LivePromotionListScene r2 = r0.d0().getListScene();
        LivePromotionListScene r3 = LivePromotionListScene.INSTANT_RETAIL_FUSION;
        if (r2 != r3) goto L5;
        View r4 = r0.Z().b(2131372865).f();
        r4.setPadding(UtilityKotlinExtentionsKt.d(Float.valueOf(12.0f)), r4.getPaddingTop(), r4.getPaddingRight(), r4.getPaddingBottom());
    L7:
        if (r0.d0().getListScene() != r3) goto L9;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L16;
        ConstraintLayout r6 = r0.l;
        if (r6 == null) goto L28;
        r6.setVisibility(8);
    L28:
        if (r9 == null) goto L51;
        int r10 = r9.intValue();
        ?? r7 = r0.j;
        if (r7 != 0) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L32:
        CategoryListAdapter r8 = r7.a;
        if (r8 == null) goto L43;
        int r11 = r8.getItemCount();
        int r12 = 0;
    L35:
        if (r12 >= r11) goto L43;
        RecyclerView.ViewHolder r13 = r7.findViewHolderForAdapterPosition(r12);
        if ((r13 instanceof CategoryViewHolder) == true) goto L39;
        r13 = null;
    L39:
        CategoryViewHolder r14 = (CategoryViewHolder) r13;
        if (r14 == null) goto L42;
        r14.a.d(r10);
    L42:
        r12 = r12 + 1;
    L43:
        r7.post(new com.bytedance.android.livesdk.livecommerce.iron.category.b(r7, r10));
        if (r10 == r7.b) goto L46;
        bi2.a r15 = bi2.a.a;
        int r16 = UtilityKotlinExtentionsKt.d(8);
        r15.getClass();
        RecyclerView.ItemDecoration r17 = bi2.a.b(r10, false, r5, r16, 0);
        r7.t();
        r7.addItemDecoration(r17);
    L46:
        r7.b = r10;
        return;
    L51:
        return;
    L16:
        if (r0.m == false) goto L20;
        ConstraintLayout r18 = r0.l;
        if (r18 == null) goto L28;
        r18.setVisibility(0);
        goto L28
    L20:
        ConstraintLayout r19 = r0.l;
        if (r19 == null) goto L28;
        if (r19.getVisibility() != 8) goto L28;
        RecyclerView r20 = r0.j;
        if (r20 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L27:
        r20.post(new z(r0));
        goto L28
    L9:
        r5 = false;
        goto L11
    L5:
        View r21 = r0.Z().b(2131372865).f();
        r21.setPadding(0, r21.getPaddingTop(), r21.getPaddingRight(), r21.getPaddingBottom());
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Integer) r1);
        return Unit.INSTANCE;
    }
}
