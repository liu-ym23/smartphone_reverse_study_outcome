package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 extends com.bytedance.applet.aibridge.baidunavi.h.a {
    public float c;
    public final /* synthetic */ float d;

    public f0(float r1) {
        this.d = r1;
        this.c = Float.NaN;
    }

    @Override // com.bytedance.applet.aibridge.baidunavi.h.a
    public final void a(float r3) {
        if (Float.isNaN(this.c) == false) goto L5;
    L6:
        this.c = r3;
        int r0 = g.a;
        JsonObject r1 = new JsonObject();
        r1.addProperty("degree", Float.valueOf(r3));
        Unit r4 = Unit.INSTANCE;
        g.a("flow.onHeadingChange", r1);
        return;
    L5:
        if (Math.abs(this.c - r3) >= this.d) goto L6;
    }
}
