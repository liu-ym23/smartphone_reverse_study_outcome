package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusWholeContentLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardView f311280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f311281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardView f311282c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311280a;
    }

    public LarusWholeContentLayoutBinding(CardView r100, TextView r101, CardView r102) {
        this.f311280a = r100;
        this.f311281b = r101;
        this.f311282c = r102;
    }
}
