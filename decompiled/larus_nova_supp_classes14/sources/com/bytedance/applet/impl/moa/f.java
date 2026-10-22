package com.bytedance.applet.impl.moa;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static e a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaPayload");
        JSONObject r6 = g.b(r5);
        String r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        Object r1 = r6.opt("client_option");
        if ((r1 instanceof JSONObject) == false) goto L8;
        JSONObject r2 = (JSONObject) r1;
    L9:
        if (r2 != null) goto L11;
        return null;
    L11:
        Object r3 = r2.opt("params");
        if ((r3 instanceof JSONObject) == false) goto L14;
        JSONObject r4 = (JSONObject) r3;
    L15:
        if (r4 != null) goto L17;
        return null;
    L17:
        Object r7 = r6.opt("server_option");
        if ((r7 instanceof JSONObject) == false) goto L20;
        JSONObject r8 = (JSONObject) r7;
    L21:
        if (r8 != null) goto L23;
        return null;
    L23:
        String r9 = g.a(r4, "authorization_id");
        if (r9 != null) goto L27;
        return null;
    L27:
        if (g.a(r8, "callback_id") != null) goto L29;
        return null;
    L29:
        String r10 = g.a(r4, "ext");
        if (r10 == null) goto L35;
        JSONObject r11 = g.b(r10);
        if (r11 == null) goto L35;
        r0 = g.a(r11, "doubaoAppletKey");
    L35:
        return new e(r0, r9, r10, g.d(r8));
    L20:
        r8 = null;
        goto L21
    L14:
        r4 = null;
        goto L15
    L8:
        r2 = null;
        goto L9
    }
}
