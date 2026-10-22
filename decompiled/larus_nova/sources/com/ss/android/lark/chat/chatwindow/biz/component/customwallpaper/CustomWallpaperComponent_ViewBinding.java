package com.ss.android.lark.chat.chatwindow.biz.component.customwallpaper;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class CustomWallpaperComponent_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomWallpaperComponent f411996a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        CustomWallpaperComponent r100 = this.f411996a;
        if (r100 == null) goto L7;
        this.f411996a = null;
        r100.mIVCustomWallpaper = null;
        r100.mIVMaskCustomWallpaper = null;
        r100.mWallpaperWrapper = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CustomWallpaperComponent_ViewBinding(CustomWallpaperComponent r100, View r101) {
        this.f411996a = r100;
        r100.mIVCustomWallpaper = (AppCompatImageView) Utils.findRequiredViewAsType(r101, R.id.chat_window_customWallpaper_container, "field 'mIVCustomWallpaper'", AppCompatImageView.class);
        r100.mIVMaskCustomWallpaper = (AppCompatImageView) Utils.findRequiredViewAsType(r101, R.id.mask_chat_window_customWallpaper_container, "field 'mIVMaskCustomWallpaper'", AppCompatImageView.class);
        r100.mWallpaperWrapper = (DetectSizeChangeFrameLayout) Utils.findRequiredViewAsType(r101, R.id.chat_window_customWallpaper_root, "field 'mWallpaperWrapper'", DetectSizeChangeFrameLayout.class);
    }
}
