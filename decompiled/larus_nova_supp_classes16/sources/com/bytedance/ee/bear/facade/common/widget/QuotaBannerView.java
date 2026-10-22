package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class QuotaBannerView extends UDNotice {
    public QuotaBannerView(Context r2) {
        this(r2, null);
    }

    public void setTip(String r1) {
        setText(r1);
    }

    public QuotaBannerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuotaBannerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setType(UDNotice.Type.SUCCESS);
        setIconColorful(true);
        i6(true);
        setIconButton(2131254123);
        setIcon(2131254918);
        setBackgroundColor(r1.getResources().getColor(2131102129));
    }
}
