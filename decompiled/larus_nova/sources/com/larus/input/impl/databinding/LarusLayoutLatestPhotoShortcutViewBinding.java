package com.larus.input.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutLatestPhotoShortcutViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatestPhotoShortcutGestureLayout f351488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f351489b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351488a;
    }

    public LarusLayoutLatestPhotoShortcutViewBinding(LatestPhotoShortcutGestureLayout r100, SimpleDraweeView r101) {
        this.f351488a = r100;
        this.f351489b = r101;
    }
}
