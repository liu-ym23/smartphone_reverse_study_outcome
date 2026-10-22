package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusSlidesItemPptTemplateSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f369359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardView f369360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f369361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f369362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f369363e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369359a;
    }

    public LarusSlidesItemPptTemplateSelectorBinding(LinearLayout r100, CardView r101, AppCompatImageView r102, SimpleDraweeView r103, AppCompatTextView r104) {
        this.f369359a = r100;
        this.f369360b = r101;
        this.f369361c = r102;
        this.f369362d = r103;
        this.f369363e = r104;
    }
}
