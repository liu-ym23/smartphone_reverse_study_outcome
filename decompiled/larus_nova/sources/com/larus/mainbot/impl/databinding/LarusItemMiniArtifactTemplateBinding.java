package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemMiniArtifactTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f358692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f358694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358695e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358691a;
    }

    public LarusItemMiniArtifactTemplateBinding(ConstraintLayout r100, ConstraintLayout r101, SimpleDraweeView r102, View r103, TextView r104) {
        this.f358691a = r100;
        this.f358692b = r101;
        this.f358693c = r102;
        this.f358694d = r103;
        this.f358695e = r104;
    }
}
