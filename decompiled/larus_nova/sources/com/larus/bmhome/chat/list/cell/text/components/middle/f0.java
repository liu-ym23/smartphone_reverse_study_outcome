package com.larus.bmhome.chat.list.cell.text.components.middle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.layout.widget.w0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.v2;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.g f306261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f306262d;

    @Override // com.larus.bmhome.chat.layout.widget.w0, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if (y0.e(this.f306261c.f307199c) == false) goto L5;
        String r101 = this.f306261c.f307199c;
    L6:
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r102 == null) goto L9;
        v2 r103 = r102.Y();
    L10:
        if (r103 == null) goto L14;
        boolean r104 = true;
        if (r103.a(UriProtector.parse(r101)) != true) goto L14;
    L15:
        if (r104 == false) goto L17;
        return;
    L17:
        com.larus.platform.service.q r105 = com.larus.platform.service.q.f365787a;
        Context r106 = r100.getContext();
        Bundle r107 = new Bundle();
        r107.putString("link_url", r101);
        r107.putString("show_closeall", "1");
        Unit r108 = Unit.INSTANCE;
        r105.e(r106, r107, null);
        return;
    L14:
        r104 = false;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = "https://" + this.f306261c.f307199c;
        goto L6
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.linkColor = -16750849;
        r100.setColor(-16750849);
        r100.setUnderlineText(this.f306262d);
    }

    public f0(com.larus.bmhome.chat.markdown.richtext.g r100, boolean r101) {
        this.f306261c = r100;
        this.f306262d = r101;
        super(null, null);
    }
}
