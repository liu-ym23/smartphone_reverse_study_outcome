package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/PriceElementView;", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceElementView extends PriceView implements ActionHubAccessor {
    public PriceElement c;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a d;

    public PriceElementView(Context r3) {
        this(r3, null, 6);
    }

    public PriceElementView(Context r2, AttributeSet r3) {
        this(r2, r3, 4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(final PriceElement r2) {
        this.c = r2;
        if (r2 == null) goto L5;
        C(new PriceElementView$bind$$inlined$let$lambda$1(r2, this));
        setVisibility(0);
    L6:
        if (r2 == null) goto L8;
        Action r3 = r2.getAction();
    L9:
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r3);
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.d = r2;
    }

    public PriceElementView(Context r3, AttributeSet r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0, 12);
        this.d = null;
    }
}
