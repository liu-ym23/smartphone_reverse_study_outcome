package com.bytedance.applet.aibridge;

import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements a88.d {
    public final String a;
    public final boolean b;
    public final boolean c;

    public final boolean b() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public final void a(String r4) {
        i r0 = i.a;
        String r1 = this.a;
        JsonObject r2 = new JsonObject();
        r2.addProperty("enterMethod", r4);
        Unit r5 = Unit.INSTANCE;
        i.l(r1, 2, r2);
    }

    public final void c(String r4) {
        i r0 = i.a;
        String r1 = this.a;
        JsonObject r2 = new JsonObject();
        r2.addProperty("enterMethod", r4);
        Unit r5 = Unit.INSTANCE;
        i.l(r1, 1, r2);
    }

    public j(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
