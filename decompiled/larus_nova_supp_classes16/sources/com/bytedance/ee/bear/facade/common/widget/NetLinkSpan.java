package com.bytedance.ee.bear.facade.common.widget;

import android.text.style.URLSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NetLinkSpan extends URLSpan {
    public final String a;
    public final ErrorTipsView.b b;

    public NetLinkSpan(String r1) {
        super(r1);
        this.a = r1;
        this.b = null;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View r3) {
        tt5.a.b("NetLinkSpan", "onClicked... ready to jump to url : " + this.a);
        ErrorTipsView.b r4 = this.b;
        if (r4 == null) goto L6;
        r4.onClick("linkUrl", this.a);
        return;
    }
}
