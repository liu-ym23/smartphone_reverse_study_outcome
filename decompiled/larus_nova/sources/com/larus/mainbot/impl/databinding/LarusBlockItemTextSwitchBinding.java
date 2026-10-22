package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemTextSwitchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f358498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextSwitcher f358499d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358496a;
    }

    public LarusBlockItemTextSwitchBinding(LinearLayout r100, SimpleDraweeView r101, AppCompatTextView r102, TextSwitcher r103) {
        this.f358496a = r100;
        this.f358497b = r101;
        this.f358498c = r102;
        this.f358499d = r103;
    }
}
