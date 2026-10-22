package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NoNetworkView extends UDNotice {
    public NoNetworkView(Context r2) {
        this(r2, null);
    }

    public void setTip(String r1) {
        setText(r1);
    }

    public NoNetworkView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NoNetworkView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setType(UDNotice.Type.WARNING);
        setIconColorful(true);
        setIcon(2131256185);
        setText(r1.getString(2131887839));
    }
}
