package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.view.RiskTipsTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusRiskTipsTextViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358823b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358822a;
    }

    public LarusRiskTipsTextViewBinding(RiskTipsTextView r100, TextView r101) {
        this.f358822a = r100;
        this.f358823b = r101;
    }
}
