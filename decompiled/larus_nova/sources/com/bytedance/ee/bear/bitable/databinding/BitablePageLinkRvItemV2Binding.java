package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.LinkTagView;
import com.bytedance.ee.bear.facade.common.widget.InterceptTouchEventLinearLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageLinkRvItemV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterceptTouchEventLinearLayout f211009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkTagView f211010b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211009a;
    }

    public BitablePageLinkRvItemV2Binding(InterceptTouchEventLinearLayout r100, LinkTagView r101) {
        this.f211009a = r100;
        this.f211010b = r101;
    }
}
