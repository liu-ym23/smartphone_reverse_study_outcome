package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricBlockFeedbackBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f386053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f386054b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386053a;
    }

    public ObricBlockFeedbackBinding(RelativeLayout r100, TextView r101) {
        this.f386053a = r100;
        this.f386054b = r101;
    }
}
