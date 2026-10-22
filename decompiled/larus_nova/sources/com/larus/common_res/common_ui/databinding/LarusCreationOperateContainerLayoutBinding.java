package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.CreationOperateContainerView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCreationOperateContainerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f326648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f326649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f326650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f326651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f326652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f326653g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326647a;
    }

    public LarusCreationOperateContainerLayoutBinding(CreationOperateContainerView r100, Button r101, ConstraintLayout r102, AppCompatTextView r103, ConstraintLayout r104, ImageView r105, AppCompatTextView r106) {
        this.f326647a = r100;
        this.f326648b = r101;
        this.f326649c = r102;
        this.f326650d = r103;
        this.f326651e = r104;
        this.f326652f = r105;
        this.f326653g = r106;
    }
}
