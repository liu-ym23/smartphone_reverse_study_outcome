package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.view.ImmerseBgVideoView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutChatBgBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f311010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmerseBgVideoView f311011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f311012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f311013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f311014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f311015f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311010a;
    }

    public LarusLayoutChatBgBinding(View r100, ImmerseBgVideoView r101, SimpleDraweeView r102, ImageView r103, ImageView r104, ImageView r105) {
        this.f311010a = r100;
        this.f311011b = r101;
        this.f311012c = r102;
        this.f311013d = r103;
        this.f311014e = r104;
        this.f311015f = r105;
    }
}
