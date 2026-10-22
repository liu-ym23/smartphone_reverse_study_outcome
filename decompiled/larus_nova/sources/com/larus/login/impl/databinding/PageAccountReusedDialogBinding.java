package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class PageAccountReusedDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f357638b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357637a;
    }

    public PageAccountReusedDialogBinding(ConstraintLayout r100, TextView r101, CircleSimpleDraweeView r102, ConstraintLayout r103, TextView r104) {
        this.f357637a = r100;
        this.f357638b = r103;
    }
}
