package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.title.BitableCardTitleView;
import com.bytedance.ee.bear.facade.common.widget.InterceptTouchEventLinearLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageLinkRvItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterceptTouchEventLinearLayout f211007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableCardTitleView f211008b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211007a;
    }

    public BitablePageLinkRvItemBinding(InterceptTouchEventLinearLayout r100, BitableCardTitleView r101) {
        this.f211007a = r100;
        this.f211008b = r101;
    }
}
