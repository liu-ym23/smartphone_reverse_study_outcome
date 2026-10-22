package com.larus.comments.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCommentItemActionsDialogLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f325655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f325656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f325657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f325658d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325655a;
    }

    public LarusCommentItemActionsDialogLayoutBinding(ConstraintLayout r100, TextView r101, View r102, RecyclerView r103) {
        this.f325655a = r100;
        this.f325656b = r101;
        this.f325657c = r102;
        this.f325658d = r103;
    }
}
