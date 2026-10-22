package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusOpenPushReminderBubbleLeftStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f367086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CircleSimpleDraweeView f367087b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f367086a;
    }

    public LarusOpenPushReminderBubbleLeftStyleBinding(ConstraintLayout r100, CircleSimpleDraweeView r101, AppCompatImageView r102, TextView r103, TextView r104, TextView r105) {
        this.f367086a = r100;
        this.f367087b = r101;
    }
}
