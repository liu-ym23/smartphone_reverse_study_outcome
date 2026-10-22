package com.larus.canvas.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.view.CreationOperateContainerView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutCanvasGenerateBottomProviderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f323782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationOperateContainerView f323783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonDownLoadLayout f323784d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323781a;
    }

    public LarusLayoutCanvasGenerateBottomProviderBinding(ConstraintLayout r100, ConstraintLayout r101, CreationOperateContainerView r102, CommonDownLoadLayout r103) {
        this.f323781a = r100;
        this.f323782b = r101;
        this.f323783c = r102;
        this.f323784d = r103;
    }
}
