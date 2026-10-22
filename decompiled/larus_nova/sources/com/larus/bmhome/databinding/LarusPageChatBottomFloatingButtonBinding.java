package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton;
import com.larus.bmhome.view.FastScrollButton;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageChatBottomFloatingButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f311110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BottomFloatingButton f311111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f311112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f311113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FastScrollButton f311114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f311115f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311110a;
    }

    public LarusPageChatBottomFloatingButtonBinding(FrameLayout r100, BottomFloatingButton r101, LinearLayout r102, LinearLayout r103, FastScrollButton r104, TextView r105) {
        this.f311110a = r100;
        this.f311111b = r101;
        this.f311112c = r102;
        this.f311113d = r103;
        this.f311114e = r104;
        this.f311115f = r105;
    }
}
