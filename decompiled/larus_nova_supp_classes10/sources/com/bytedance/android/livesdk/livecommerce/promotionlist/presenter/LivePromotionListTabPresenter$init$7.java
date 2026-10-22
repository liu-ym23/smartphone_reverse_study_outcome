package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.tab.CategoryExpandView;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LivePromotionListTabPresenter$init$7 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d, Unit> {
    public LivePromotionListTabPresenter$init$7(LivePromotionListTabPresenter r8) {
        super(1, r8, LivePromotionListTabPresenter.class, "changeComponentVisibility", "changeComponentVisibility(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$ChangeComponentVisibilityEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        final LivePromotionListTabPresenter r0 = (LivePromotionListTabPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListTabPresenter.n;
        r0.getClass();
        String r2 = r7.a;
        if (r2.hashCode() == 1908904590) goto L6;
        return;
    L6:
        if (r2.equals("list_with_tab_banner") == true) goto L8;
        return;
    L8:
        if (r7.b == true) goto L10;
        return;
    L10:
        if (r7.c == false) goto L40;
        CategoryExpandView r8 = r0.l;
        if (r8 == null) goto L36;
        RelativeLayout r3 = null;
        if (r8.T5() == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L36;
        CategoryRecyclerView r4 = r0.j;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");
    L21:
        FrameLayout r5 = (FrameLayout) r0.Z().b(2131372865).f();
        View r6 = ((QFragmentPresenter) r0).e.getView();
        if (r6 == null) goto L24;
        r3 = (RelativeLayout) r6.findViewById(2131378074);
    L24:
        r8.S5(r4, r5, r3);
    L36:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L30
        CategoryRecyclerView r10 = r0.j;     // Catch: Throwable -> L30
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("categoryList");     // Catch: Throwable -> L30
    L28:
        r10.r(new LivePromotionListTabPresenter$changeComponentVisibility$$inlined$runCatching$lambda$1(r0));     // Catch: Throwable -> L30
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L41;
        ECExceptionMonitor.e(r12);
        return;
    L41:
        return;
    L30:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d) r1);
        return Unit.INSTANCE;
    }
}
