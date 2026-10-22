package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCreationDetailPromptVideoLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f310813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoPlayView f310814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f310815c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310813a;
    }

    public LarusCreationDetailPromptVideoLayoutBinding(FrameLayout r100, VideoPlayView r101, FrameLayout r102) {
        this.f310813a = r100;
        this.f310814b = r101;
        this.f310815c = r102;
    }
}
