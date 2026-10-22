package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemButtonV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f358434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f358437e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358433a;
    }

    public LarusBlockItemButtonV2Binding(LinearLayout r100, LinearLayout r101, SimpleDraweeView r102, SimpleDraweeView r103, AppCompatTextView r104) {
        this.f358433a = r100;
        this.f358434b = r101;
        this.f358435c = r102;
        this.f358436d = r103;
        this.f358437e = r104;
    }
}
