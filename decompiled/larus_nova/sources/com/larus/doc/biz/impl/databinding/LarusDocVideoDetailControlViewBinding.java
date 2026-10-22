package com.larus.doc.biz.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.doc.impl.video.widget.PlayerProgressView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocVideoDetailControlViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f330939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonDownLoadLayout f330940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlayerProgressView f330941c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f330939a;
    }

    public LarusDocVideoDetailControlViewBinding(View r100, CommonDownLoadLayout r101, PlayerProgressView r102) {
        this.f330939a = r100;
        this.f330940b = r101;
        this.f330941c = r102;
    }
}
