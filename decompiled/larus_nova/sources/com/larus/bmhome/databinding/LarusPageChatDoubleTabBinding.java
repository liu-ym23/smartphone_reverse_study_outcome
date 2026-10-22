package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageChatDoubleTabBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f311127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatConstraintLayout f311128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f311129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f311130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f311131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewPager2 f311132f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311127a;
    }

    public LarusPageChatDoubleTabBinding(ChatConstraintLayout r100, ChatConstraintLayout r101, FrameLayout r102, FrameLayout r103, FrameLayout r104, ViewPager2 r105) {
        this.f311127a = r100;
        this.f311128b = r101;
        this.f311129c = r102;
        this.f311130d = r103;
        this.f311131e = r104;
        this.f311132f = r105;
    }
}
