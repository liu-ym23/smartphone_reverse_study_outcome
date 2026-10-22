package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogNotiV3AddSpecialContactBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f332473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatButton f332474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatButton f332475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatEditText f332476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatEditText f332477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332478f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332473a;
    }

    public LarusDoraDialogNotiV3AddSpecialContactBinding(NestedScrollView r100, AppCompatButton r101, AppCompatButton r102, AppCompatEditText r103, AppCompatEditText r104, DoraTextView r105) {
        this.f332473a = r100;
        this.f332474b = r101;
        this.f332475c = r102;
        this.f332476d = r103;
        this.f332477e = r104;
        this.f332478f = r105;
    }
}
