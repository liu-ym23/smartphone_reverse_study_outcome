package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricDoubaoWhisperDialogBodyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f389477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCheckBoxLayout f389478b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389477a;
    }

    public ObricDoubaoWhisperDialogBodyBinding(LinearLayout r100, OCheckBoxLayout r101, OTextView r102) {
        this.f389477a = r100;
        this.f389478b = r101;
    }
}
