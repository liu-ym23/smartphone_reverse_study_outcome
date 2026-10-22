package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class QuotaBannerView extends UDNotice {
    public QuotaBannerView(Context r100) {
        this(r100, null);
    }

    public void setTip(String r100) {
        setText(r100);
    }

    public QuotaBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public QuotaBannerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setType(UDNotice.Type.SUCCESS);
        setIconColorful(true);
        i6(true);
        setIconButton(R.drawable.ud_icon_close_outlined);
        setIcon(R.drawable.ud_icon_info_colorful);
        setBackgroundColor(r100.getResources().getColor(R.color.function_info_fill_solid_01));
    }
}
