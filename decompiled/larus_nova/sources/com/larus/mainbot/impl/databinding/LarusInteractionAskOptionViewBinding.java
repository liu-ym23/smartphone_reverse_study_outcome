package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskOptionView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusInteractionAskOptionViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f358665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358667e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358663a;
    }

    public LarusInteractionAskOptionViewBinding(InteractionAskOptionView r100, TextView r101, AppCompatImageView r102, TextView r103, TextView r104) {
        this.f358663a = r100;
        this.f358664b = r101;
        this.f358665c = r102;
        this.f358666d = r103;
        this.f358667e = r104;
    }
}
