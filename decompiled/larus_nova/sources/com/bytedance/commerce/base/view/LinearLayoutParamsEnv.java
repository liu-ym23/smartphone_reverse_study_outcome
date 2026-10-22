package com.bytedance.commerce.base.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/commerce/base/view/LinearLayoutParamsEnv;", "Lcom/bytedance/commerce/base/view/MarginLayoutParamsEnv;", PickerReporterConstants.KEY.TARGET, "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "value", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "()I", "setGravity", "(I)V", "tTarget", "Landroid/widget/LinearLayout$LayoutParams;", "", "weight", "getWeight", "()F", "setWeight", "(F)V", "base_release"}, k = 1, mv = {1, 1, 16})
public final class LinearLayoutParamsEnv extends MarginLayoutParamsEnv {
    private final LinearLayout.LayoutParams tTarget;

    public final int getGravity() {
        return this.tTarget.gravity;
    }

    public final float getWeight() {
        return this.tTarget.weight;
    }

    public LinearLayoutParamsEnv(ViewGroup.LayoutParams r100) {
        super(r100);
        this.tTarget = (LinearLayout.LayoutParams) r100;
    }

    public final void setGravity(int r100) {
        this.tTarget.gravity = r100;
    }

    public final void setWeight(float r100) {
        this.tTarget.weight = r100;
    }
}
