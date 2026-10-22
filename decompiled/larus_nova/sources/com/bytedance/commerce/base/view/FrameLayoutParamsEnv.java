package com.bytedance.commerce.base.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/commerce/base/view/FrameLayoutParamsEnv;", "Lcom/bytedance/commerce/base/view/MarginLayoutParamsEnv;", PickerReporterConstants.KEY.TARGET, "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "value", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "()I", "setGravity", "(I)V", "tTarget", "Landroid/widget/FrameLayout$LayoutParams;", "base_release"}, k = 1, mv = {1, 1, 16})
public final class FrameLayoutParamsEnv extends MarginLayoutParamsEnv {
    private final FrameLayout.LayoutParams tTarget;

    public final int getGravity() {
        return this.tTarget.gravity;
    }

    public FrameLayoutParamsEnv(ViewGroup.LayoutParams r100) {
        super(r100);
        this.tTarget = (FrameLayout.LayoutParams) r100;
    }

    public final void setGravity(int r100) {
        this.tTarget.gravity = r100;
    }
}
