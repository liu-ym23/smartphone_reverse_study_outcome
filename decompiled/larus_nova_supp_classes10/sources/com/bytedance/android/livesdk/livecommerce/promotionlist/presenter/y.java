package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.tab.CategoryExpandView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements Runnable {
    public final /* synthetic */ LivePromotionListTabPresenter a;

    public y(LivePromotionListTabPresenter r1) {
        this.a = r1;
    }

    public final void a() {
        if (LivePromotionListTabPresenter.h0(this.a).canScrollHorizontally(-1) == false) goto L5;
    L9:
        ConstraintLayout r0 = this.a.l;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        LivePromotionListTabPresenter r1 = this.a;
        r1.m = true;
        CategoryExpandView r4 = r1.l;
        if (r4 == null) goto L22;
        CategoryRecyclerView r2 = r1.j;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L17:
        FrameLayout r5 = (FrameLayout) this.a.Z().b(2131372865).f();
        View r6 = ((QFragmentPresenter) this.a).e.getView();
        if (r6 == null) goto L20;
        RelativeLayout r7 = (RelativeLayout) r6.findViewById(2131378074);
    L21:
        r4.R5(r2, r5, r7, this.a.d0().getPromotionListParams());
        goto L22
    L20:
        r7 = null;
    L22:
        CategoryRecyclerView r3 = LivePromotionListTabPresenter.h0(this.a);
        bi2.a r8 = bi2.a.a;
        int r9 = UtilityKotlinExtentionsKt.d(8);
        int r10 = UtilityKotlinExtentionsKt.d(0);
        r8.getClass();
        RecyclerView.ItemDecoration r11 = bi2.a.b(3, false, true, r9, r10);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r11, "decoration");
        r3.t();
        r3.addItemDecoration(r11);
        return;
    L5:
        if (LivePromotionListTabPresenter.h0(this.a).canScrollHorizontally(1) == true) goto L9;
        ConstraintLayout r12 = this.a.l;
        if (r12 == null) goto L24;
        r12.setVisibility(8);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
