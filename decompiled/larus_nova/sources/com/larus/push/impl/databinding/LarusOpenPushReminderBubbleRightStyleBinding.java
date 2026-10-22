package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusOpenPushReminderBubbleRightStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f367088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CircleSimpleDraweeView f367089b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f367088a;
    }

    public LarusOpenPushReminderBubbleRightStyleBinding(ConstraintLayout r100, CircleSimpleDraweeView r101, TextView r102, TextView r103, TextView r104) {
        this.f367088a = r100;
        this.f367089b = r101;
    }
}
