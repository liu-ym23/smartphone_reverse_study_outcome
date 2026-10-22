package com.bytedance.applet.impl;

import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.GuiView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements dw8.p {
    public final /* synthetic */ AppletChatInputController.b a;

    public final boolean c() {
        return false;
    }

    public final Map<String, String> getLogExtra() {
        return null;
    }

    public final String getPageName() {
        return null;
    }

    public final String m() {
        return null;
    }

    public final String b() {
        return this.a.b();
    }

    public final Map<String, String> getExtra() {
        return this.a.getExtra();
    }

    public final Integer getSource() {
        return this.a.getSource();
    }

    public h(AppletModelContextProvider r1) {
        this.a = r1;
    }

    public final GuiContext a(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        AppletChatInputController.e r5 = this.a.c();
        GuiView r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        String r1 = r5.a;
        String r2 = r5.b;
        AppletChatInputController.f r6 = r5.c;
        if (r6 == null) goto L9;
        r0 = new GuiView(r6.a);
    L9:
        return new GuiContext(r1, r2, r0);
    }
}
