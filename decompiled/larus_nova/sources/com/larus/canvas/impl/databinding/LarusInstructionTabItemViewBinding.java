package com.larus.canvas.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusInstructionTabItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f323776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f323777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f323778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f323779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f323780e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323776a;
    }

    public LarusInstructionTabItemViewBinding(LinearLayout r100, AppCompatImageView r101, SimpleDraweeView r102, AppCompatTextView r103, AppCompatTextView r104) {
        this.f323776a = r100;
        this.f323777b = r101;
        this.f323778c = r102;
        this.f323779d = r103;
        this.f323780e = r104;
    }
}
