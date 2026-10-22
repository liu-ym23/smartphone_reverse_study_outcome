package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.msgcenter.view.BitableMsgCenterContainer;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableMsgCenterFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f210959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableMsgCenterContainer f210961d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210958a;
    }

    public BitableMsgCenterFragmentBinding(LinearLayout r100, AppCompatImageView r101, AppCompatImageView r102, BitableMsgCenterContainer r103) {
        this.f210958a = r100;
        this.f210959b = r101;
        this.f210960c = r102;
        this.f210961d = r103;
    }
}
