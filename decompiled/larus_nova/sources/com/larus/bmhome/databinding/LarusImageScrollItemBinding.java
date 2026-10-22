package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusImageScrollItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f310940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f310941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f310942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageCoverEditView f310943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f310944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f310945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewStub f310946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f310947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f310948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f310949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDraweeView f310950k;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310940a;
    }

    public LarusImageScrollItemBinding(ConstraintLayout r100, FrameLayout r101, ImageView r102, ImageCoverEditView r103, ImageView r104, ProgressBar r105, ViewStub r106, ImageView r107, LinearLayout r108, AppCompatTextView r110, SimpleDraweeView r111) {
        this.f310940a = r100;
        this.f310941b = r101;
        this.f310942c = r102;
        this.f310943d = r103;
        this.f310944e = r104;
        this.f310945f = r105;
        this.f310946g = r106;
        this.f310947h = r107;
        this.f310948i = r108;
        this.f310949j = r110;
        this.f310950k = r111;
    }
}
