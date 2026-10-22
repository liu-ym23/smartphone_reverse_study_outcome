package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ButtonModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class b extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<ButtonModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDButton f216171e;

    public void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.BUTTON.getValue();
    }

    public b(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<ButtonModel> r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        UDButton r102 = this.f216171e;
        if (r102 == null) goto L15;
        i(r102, (ButtonModel) ListProtector.get(r100, 0));
        return;
    L15:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static void i(View r100, ButtonModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        UDButton r102 = (UDButton) r100;
        r102.setText(r101.getText());
        r102.setBackgroundColor(ColorUtils.h(r101.getBackground()));
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larksuite.component.universe_design.button.UDButton");
        this.f216171e = (UDButton) r102;
        h(r102);
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        UDButton r103 = new UDButton(r100, null, 0, 6, null);
        com.bytedance.ee.bear.bitable.m.e(r103, com.bytedance.ee.util.ui.n.d(24));
        r103.setMinWidth(com.bytedance.ee.util.ui.n.d(68));
        r103.setPadding(com.bytedance.ee.util.ui.n.d(4), 0, com.bytedance.ee.util.ui.n.d(4), 0);
        r103.setGravity(17);
        r103.setCornerRadius(com.bytedance.ee.util.ui.n.d(6));
        r103.setTextSize(12.0f);
        r103.setTextColor(ResourcesCompat.getColor(r100.getResources(), R.color.white, r100.getTheme()));
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        i(r100, (ButtonModel) r101);
    }
}
