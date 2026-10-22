package com.bytedance.android.window.shop.home.presenter;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "p1", "", "Lcom/bytedance/android/window/shop/repository/dto/p;", "p2", "", "invoke", "(Ljava/lang/String;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowHybridSubTabsPresenter$onBind$1$2 extends FunctionReferenceImpl implements Function2<String, List<? extends com.bytedance.android.window.shop.repository.dto.p>, Unit> {
    public ECWindowHybridSubTabsPresenter$onBind$1$2(ECWindowHybridSubTabsPresenter r8) {
        super(2, r8, ECWindowHybridSubTabsPresenter.class, "setTabSelected", "setTabSelected(Ljava/lang/String;Ljava/util/List;)V", 0);
    }

    public final void invoke(String r5, List<com.bytedance.android.window.shop.repository.dto.p> r6) {
        Intrinsics.checkNotNullParameter(r6, "p2");
        ECWindowHybridSubTabsPresenter r0 = (ECWindowHybridSubTabsPresenter) ((CallableReference) this).receiver;
        int r1 = ECWindowHybridSubTabsPresenter.s;
        r0.getClass();
        if (Lifecycle.State.DESTROYED == r0.U().getLifecycle().getCurrentState()) goto L30;
        Iterator<com.bytedance.android.window.shop.repository.dto.p> r7 = r6.iterator();
        boolean r2 = false;
        int r3 = 0;
    L7:
        if (r7.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r7.next().b(), r5) == true) goto L13;
        r3 = r3 + 1;
    L13:
        Integer r8 = Integer.valueOf(r3);
        int r9 = r8.intValue();
        if (r9 >= 0) goto L16;
    L18:
        if (r2 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L28;
        int r10 = r8.intValue();
        ECTabLayout.Tab r11 = r0.e0().getTabAt(r10);
        if (r11 == null) goto L29;
        r11.select();
        return;
    L29:
        return;
    L28:
        return;
    L16:
        if (r9 == r0.e0().getSelectedTabPosition()) goto L18;
        r2 = true;
        goto L18
    L12:
        r3 = -1;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (List) r2);
        return Unit.INSTANCE;
    }
}
