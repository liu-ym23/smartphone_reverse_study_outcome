package com.bytedance.applet.view;

import android.content.Context;
import com.google.gson.JsonObject;
import d3.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ AppletFragment a;

    public /* synthetic */ c(AppletFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, Object r6) {
        AppletFragment r0 = this.a;
        boolean r7 = ((Boolean) r5).booleanValue();
        int r8 = ((Integer) r6).intValue();
        int r1 = AppletFragment.J;
        Context r2 = r0.getContext();
        if (r2 == null) goto L10;
        com.bytedance.ai.model.widgets.c r3 = r0.k;
        if (r3 == null) goto L10;
        b0 r4 = r3.getAIBridge();
        if (r4 == null) goto L10;
        JsonObject r9 = new JsonObject();
        r9.addProperty("visible", Boolean.valueOf(r7));
        r9.addProperty("height", Integer.valueOf(com.bytedance.ai.utils.o.d(r8, r2)));
        Unit r10 = Unit.INSTANCE;
        r4.a("applet.keyboardStatusChange", r9);
    L10:
        return Unit.INSTANCE;
    }
}
