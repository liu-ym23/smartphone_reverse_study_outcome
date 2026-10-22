package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.facade.common.widget.InterceptTouchEventLinearLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardLinkTagOptionItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterceptTouchEventLinearLayout f210667a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210667a;
    }

    public BitableCardLinkTagOptionItemBinding(InterceptTouchEventLinearLayout r100, UDCheckBox r101, TextView r102) {
        this.f210667a = r100;
    }
}
