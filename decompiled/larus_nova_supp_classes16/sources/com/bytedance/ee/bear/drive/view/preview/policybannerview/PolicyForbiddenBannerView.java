package com.bytedance.ee.bear.drive.view.preview.policybannerview;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PolicyForbiddenBannerView extends UDNotice {
    public void setTitle(String r1) {
    }

    public PolicyForbiddenBannerView(Context r2) {
        this(r2, null);
    }

    public void setTip(String r1) {
        setText(r1);
    }

    public PolicyForbiddenBannerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PolicyForbiddenBannerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
    }
}
