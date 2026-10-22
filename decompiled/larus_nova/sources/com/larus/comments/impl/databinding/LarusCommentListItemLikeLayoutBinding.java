package com.larus.comments.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCommentListItemLikeLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f325659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f325660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f325661c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325659a;
    }

    public LarusCommentListItemLikeLayoutBinding(View r100, AppCompatImageView r101, TextView r102) {
        this.f325659a = r100;
        this.f325660b = r101;
        this.f325661c = r102;
    }
}
