package com.bytedance.ee.bear.facade.common.widget;

import android.text.style.URLSpan;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public class NetLinkSpan extends URLSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f226503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ErrorTipsView.b f226504b;

    public NetLinkSpan(String r100) {
        super(r100);
        this.f226503a = r100;
        this.f226504b = null;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        tt5.a.b("NetLinkSpan", "onClicked... ready to jump to url : " + this.f226503a);
        ErrorTipsView.b r101 = this.f226504b;
        if (r101 == null) goto L6;
        r101.onClick("linkUrl", this.f226503a);
        return;
    }
}
