package com.larus.chat.job.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusChatJobEditTextItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f325047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f325048b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325047a;
    }

    public LarusChatJobEditTextItemBinding(FrameLayout r100, EditText r101) {
        this.f325047a = r100;
        this.f325048b = r101;
    }
}
