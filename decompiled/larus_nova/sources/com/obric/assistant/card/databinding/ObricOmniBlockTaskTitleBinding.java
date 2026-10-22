package com.obric.assistant.card.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricOmniBlockTaskTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShimmerTextView f386303c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386301a;
    }

    public ObricOmniBlockTaskTitleBinding(ConstraintLayout r100, SimpleDraweeView r101, ShimmerTextView r102) {
        this.f386301a = r100;
        this.f386302b = r101;
        this.f386303c = r102;
    }
}
