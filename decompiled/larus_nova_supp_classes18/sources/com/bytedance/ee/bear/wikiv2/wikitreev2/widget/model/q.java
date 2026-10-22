package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public static final Map<String, Integer> a = null;
    public static final Map<String, Integer> b = null;
    public static final Map<String, Integer> c = null;

    public q() {
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        HashMap r1 = new HashMap();
        b = r1;
        HashMap r2 = new HashMap();
        c = r2;
        r0.put("ADD", 2131888318);
        r0.put("DEL", 2131888339);
        r0.put("MOV", 2131888333);
        r0.put("SHORTCUT", 2131887469);
        r0.put("MAKE_COPY", 2131887469);
        r1.put("DEL", 2131889860);
        r1.put("MOV", 2131888334);
        r1.put("FAVORITE", 2131887501);
        r1.put("UNFAVORITE", 2131887503);
        r1.put("SHORTCUT", 2131887528);
        r1.put("MAKE_COPY", 2131887468);
        r2.put(a("EXPAND", 920004002), 2131888323);
        r2.put(a("EXPAND", 920004004), 2131888322);
        r2.put(a("ADD", 920004002), 2131888319);
        r2.put(a("ADD", 920004004), 2131888937);
        r2.put(a("ADD", 920004011), 2131888320);
        r2.put(a("ADD", 10009), 2131888173);
        r2.put(a("ADD", 10013), 2131888173);
        r2.put(a("DEL", 920004002), 2131888340);
        r2.put(a("DEL", 920004004), 2131887499);
        r2.put(a("DEL", 233525001), 2131887499);
        r2.put(a("DEL", 233525002), 2131887462);
        r2.put(a("DEL_CURRENT_ONLY", 233525002), 2131889854);
        r2.put(a("DEL_CURRENT_ONLY", 233525007), 2131889855);
        r2.put(a("DEL_CURRENT_ONLY", -5), 2131889863);
        r2.put(a("MOV", 920004001), 2131888332);
        r2.put(a("MOV", 920004002), 2131888331);
        r2.put(a("MOV", 920004004), 2131887515);
        r2.put(a("MOV", 233525204), 2131887516);
        r2.put(a("MOV", 233525305), 2131887515);
        r2.put(a("MAKE_COPY", 920004004), 2131887330);
        r2.put(a("SHORTCUT", 920004012), 2131887531);
        r2.put(a("SHORTCUT", 920004003), 2131887531);
        r2.put(a("SHORTCUT", 920004004), 2131887531);
        r2.put(a("SHORTCUT", 920004007), 2131887531);
        r2.put(a("SHORTCUT", 920004001), 2131888319);
        r2.put(a("SHORTCUT", 920004002), 2131888319);
        r2.put(a("SHORTCUT", 10009), 2131888173);
        r2.put(a("SHORTCUT", 10013), 2131888173);
        r2.put(a("FAVORITE", 100000002), 2131887471);
        r2.put(a("UNFAVORITE", 100000002), 2131887472);
        r2.put(a("SHORTCUT", 100000002), 2131887532);
        r2.put(a("MAKE_COPY", 100000002), 2131887470);
        r2.put(a("ADD", 100000002), 2131887802);
        r2.put(a("RENAME", 100000002), 2131887815);
    }

    public static int e(WikiAction r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Map<String, Integer> r0 = a;
        HashMap r2 = (HashMap) r0;
        Integer r3 = (Integer) r2.get(r1.name());
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.intValue();
    }

    public static int f(WikiAction r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Map<String, Integer> r0 = b;
        HashMap r2 = (HashMap) r0;
        Integer r3 = (Integer) r2.get(r1.name());
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.intValue();
    }

    public static String a(String r1, int r2) {
        return r1 + '-' + r2;
    }

    public static int b(WikiAction r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
        return c(r1, r2, 2131887802);
    }

    public static /* synthetic */ int d(WikiAction r1, Throwable r2) {
        return c(r1, r2, 2131887802);
    }

    public static int c(WikiAction r2, Throwable r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (tp5.b.d(r3) == false) goto L5;
        int r5 = 920004004;
    L7:
        if (r5 != 90003088) goto L11;
        Integer r6 = 2131889780;
        return r6.intValue();
    L11:
        if (r5 == (-1)) goto L15;
        Map<String, Integer> r0 = c;
        HashMap r1 = (HashMap) r0;
        Integer r7 = (Integer) r1.get(a(r2.name(), r5));
        if (r7 != null) goto L17;
        r7 = (Integer) r1.get(a(r2.name(), 100000002));
    L17:
        if (r2 != WikiAction.DEL) goto L19;
    L20:
        r7 = 2131887463;
    L21:
        if (r7 == null) goto L23;
    L25:
        if (r7 != null) goto L27;
        return r4;
    L27:
        return r7.intValue();
    L23:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L25;
        r7 = 2131888336;
        goto L25
    L19:
        if (r2 != WikiAction.DEL_CURRENT_ONLY) goto L21;
    L15:
        r7 = null;
        goto L17
    L5:
        r5 = tp5.b.a(r3);
        goto L7
    }
}
