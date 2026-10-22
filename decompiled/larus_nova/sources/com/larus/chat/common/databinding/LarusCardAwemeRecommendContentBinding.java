package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.venus.ShapeConstraintLayout;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCardAwemeRecommendContentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f323909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusCardAwemeAuthorInfoBinding f323910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f323911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f323912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ShapeConstraintLayout f323913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ShapeConstraintLayout f323914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f323915g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323909a;
    }

    public LarusCardAwemeRecommendContentBinding(View r100, LarusCardAwemeAuthorInfoBinding r101, SimpleDraweeView r102, ImageView r103, ShapeConstraintLayout r104, ShapeConstraintLayout r105, AppCompatTextView r106) {
        this.f323909a = r100;
        this.f323910b = r101;
        this.f323911c = r102;
        this.f323912d = r103;
        this.f323913e = r104;
        this.f323914f = r105;
        this.f323915g = r106;
    }
}
