package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricBlockAskUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f386046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f386047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CustomMarkdownTextView f386048c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386046a;
    }

    public ObricBlockAskUserBinding(FrameLayout r100, FrameLayout r101, CustomMarkdownTextView r102) {
        this.f386046a = r100;
        this.f386047b = r101;
        this.f386048c = r102;
    }
}
