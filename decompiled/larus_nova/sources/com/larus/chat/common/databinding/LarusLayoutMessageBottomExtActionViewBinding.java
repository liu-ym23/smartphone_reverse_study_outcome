package com.larus.chat.common.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutMessageBottomExtActionViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f324014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f324015c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324013a;
    }

    public LarusLayoutMessageBottomExtActionViewBinding(View r100, SimpleDraweeView r101, AppCompatTextView r102) {
        this.f324013a = r100;
        this.f324014b = r101;
        this.f324015c = r102;
    }
}
