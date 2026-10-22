package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentMiniArtifactProductBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f358635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusMiniArtifactInputBinding f358636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatConstraintLayout f358637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f358638d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358635a;
    }

    public LarusFragmentMiniArtifactProductBinding(ChatConstraintLayout r100, LarusMiniArtifactInputBinding r101, ChatConstraintLayout r102, FrameLayout r103) {
        this.f358635a = r100;
        this.f358636b = r101;
        this.f358637c = r102;
        this.f358638d = r103;
    }
}
