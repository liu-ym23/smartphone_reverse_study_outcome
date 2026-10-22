package com.larus.extension.chat_extension.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusLayoutChatLtmInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f342792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f342793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f342794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f342795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatEditText f342796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f342797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f342798g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f342792a;
    }

    public LarusLayoutChatLtmInputBinding(ConstraintLayout r100, AppCompatTextView r101, LinearLayout r102, AppCompatTextView r103, AppCompatEditText r104, ProgressBar r105, AppCompatTextView r106) {
        this.f342792a = r100;
        this.f342793b = r101;
        this.f342794c = r102;
        this.f342795d = r103;
        this.f342796e = r104;
        this.f342797f = r105;
        this.f342798g = r106;
    }
}
