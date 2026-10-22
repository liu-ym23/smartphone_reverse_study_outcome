package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutChatReplyHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f323988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f323989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f323990c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323988a;
    }

    public LarusLayoutChatReplyHeaderBinding(View r100, ImageView r101, TextView r102) {
        this.f323988a = r100;
        this.f323989b = r101;
        this.f323990c = r102;
    }
}
