package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusGenericToolViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f358653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f358654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ShimmerTextView f358656e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358652a;
    }

    public LarusGenericToolViewBinding(GenericToolView r100, View r101, LinearLayout r102, SimpleDraweeView r103, ShimmerTextView r104) {
        this.f358652a = r100;
        this.f358653b = r101;
        this.f358654c = r102;
        this.f358655d = r103;
        this.f358656e = r104;
    }
}
