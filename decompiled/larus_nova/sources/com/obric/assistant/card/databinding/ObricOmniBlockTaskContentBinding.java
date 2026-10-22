package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricOmniBlockTaskContentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f386281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomMarkdownTextView f386282b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386281a;
    }

    public ObricOmniBlockTaskContentBinding(LinearLayout r100, CustomMarkdownTextView r101) {
        this.f386281a = r100;
        this.f386282b = r101;
    }
}
