package com.bytedance.android.window.shop.innerflow.presenter;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowAdapter;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowInnerFlowAdapter;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECWindowInnerFlowListPresenter$adapter$2 extends Lambda implements Function0<ECWindowInnerFlowAdapter> {
    final /* synthetic */ ECWindowInnerFlowListPresenter this$0;

    public ECWindowInnerFlowListPresenter$adapter$2(ECWindowInnerFlowListPresenter r1) {
        this.this$0 = r1;
        super(0);
    }

    public final ECWindowInnerFlowAdapter invoke() {
        ECWindowInnerFlowListPresenter r1 = this.this$0;
        int r2 = ECWindowInnerFlowListPresenter.n;
        QContext r3 = r1.u();
        FragmentActivity r4 = l0.c(r3.c());
        if ((r4 instanceof FragmentActivity) == true) goto L5;
        r4 = null;
    L5:
        if (r4 != null) goto L7;
        r4 = r3.a();
    L7:
        ECWindowInnerFlowAdapter r0 = new ECWindowInnerFlowAdapter(r4, new AnonymousClass1(this));
        if (true == r0.a) goto L10;
        r0.a = true;
    L10:
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m851invoke() {
        return invoke();
    }
}
