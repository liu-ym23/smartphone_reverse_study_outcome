package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricFeedbackExperiencePlanEntryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f389479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCheckBoxLayout f389480b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389479a;
    }

    public ObricFeedbackExperiencePlanEntryBinding(LinearLayout r100, OCheckBoxLayout r101, LinearLayout r102, OTextView r103) {
        this.f389479a = r100;
        this.f389480b = r101;
    }
}
