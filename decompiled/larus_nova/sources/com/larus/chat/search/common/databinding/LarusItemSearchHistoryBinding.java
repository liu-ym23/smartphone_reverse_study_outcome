package com.larus.chat.search.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemSearchHistoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f325447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f325448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f325449c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325447a;
    }

    public LarusItemSearchHistoryBinding(LinearLayout r100, AppCompatImageView r101, TextView r102) {
        this.f325447a = r100;
        this.f325448b = r101;
        this.f325449c = r102;
    }
}
