package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusItemRecyclerAsrBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f378235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomMarkdownTextView f378236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f378237c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378235a;
    }

    public LarusItemRecyclerAsrBinding(FrameLayout r100, CustomMarkdownTextView r101, FrameLayout r102) {
        this.f378235a = r100;
        this.f378236b = r101;
        this.f378237c = r102;
    }
}
