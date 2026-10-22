package com.ss.android.lark.flow.feed.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes36.dex */
public final class ItemFlowMenuItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f423377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f423378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f423379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f423380d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f423377a;
    }

    public ItemFlowMenuItemBinding(RelativeLayout r100, LinearLayout r101, AppCompatImageView r102, TextView r103) {
        this.f423377a = r100;
        this.f423378b = r101;
        this.f423379c = r102;
        this.f423380d = r103;
    }
}
