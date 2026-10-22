package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.LinkModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class m extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<LinkModel> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.LINK.getValue();
    }

    public m(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ResourcesCompat.getDrawable(r100.getResources(), R.drawable.bitable_card_view_link_cell_bg, r100.getTheme());
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        TextView r103 = new TextView(r100);
        r103.setBackground(e(r100));
        r103.setGravity(17);
        r103.setIncludeFontPadding(false);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setMaxLines(1);
        r103.setPadding(com.bytedance.ee.util.ui.n.d(8), 0, com.bytedance.ee.util.ui.n.d(8), 0);
        com.bytedance.ee.bear.bitable.m.e(r103, com.bytedance.ee.util.ui.n.d(24));
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (LinkModel) r101);
    }

    public void h(View r100, LinkModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof TextView) == false) goto L6;
        TextView r102 = (TextView) r100;
        a(r102, true);
        r102.setText(r101.getText());
        return;
    }
}
