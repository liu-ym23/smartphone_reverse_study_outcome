package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutBotReplyHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f358703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358704c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358702a;
    }

    public LarusLayoutBotReplyHeaderBinding(View r100, ImageView r101, TextView r102) {
        this.f358702a = r100;
        this.f358703b = r101;
        this.f358704c = r102;
    }
}
