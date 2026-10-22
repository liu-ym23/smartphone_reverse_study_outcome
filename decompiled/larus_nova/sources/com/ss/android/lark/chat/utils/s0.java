package com.ss.android.lark.chat.utils;

import android.view.View;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class s0 implements com.ss.android.lark.chat.drawable.a.InterfaceC4854a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f416733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f416734b;

    @Override // com.ss.android.lark.chat.drawable.a.InterfaceC4854a
    public final float a() {
        View r100 = this.f416733a;
        if (r100 == null) goto L5;
        int r101 = MsgBubbleUtil.f416621a;
        int r102 = MsgBubbleUtil.b(r100, this.f416734b) + this.f416733a.getHeight();
    L7:
        return r102;
    L5:
        r102 = UIUtils.dp2px(this.f416734b.getContext(), 20.0f);
        goto L7
    }

    public s0(View r100, View r101) {
        this.f416733a = r100;
        this.f416734b = r101;
    }
}
