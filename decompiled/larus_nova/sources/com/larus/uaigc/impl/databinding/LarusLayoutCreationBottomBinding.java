package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.view.CreationOperateContainerView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLayoutCreationBottomBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonAiBeautifyLayout f373212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationOperateContainerView f373213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonDownLoadLayout f373214d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373211a;
    }

    public LarusLayoutCreationBottomBinding(View r100, CommonAiBeautifyLayout r101, CreationOperateContainerView r102, CommonDownLoadLayout r103) {
        this.f373211a = r100;
        this.f373212b = r101;
        this.f373213c = r102;
        this.f373214d = r103;
    }
}
