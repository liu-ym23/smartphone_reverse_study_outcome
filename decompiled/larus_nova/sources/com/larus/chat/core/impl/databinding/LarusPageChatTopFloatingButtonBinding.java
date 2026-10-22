package com.larus.chat.core.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.top.view.BackTopButton;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageChatTopFloatingButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f324096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BackTopButton f324097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f324098c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324096a;
    }

    public LarusPageChatTopFloatingButtonBinding(FrameLayout r100, BackTopButton r101, FrameLayout r102) {
        this.f324096a = r100;
        this.f324097b = r101;
        this.f324098c = r102;
    }
}
