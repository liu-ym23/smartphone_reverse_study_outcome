package com.obric.audio.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes33.dex */
public final class SvaEnrollTimeoutFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f395791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatButton f395792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OFloatingTitleBar f395793c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f395791a;
    }

    public SvaEnrollTimeoutFragmentBinding(LinearLayout r100, AppCompatButton r101, OFloatingTitleBar r102) {
        this.f395791a = r100;
        this.f395792b = r101;
        this.f395793c = r102;
    }
}
