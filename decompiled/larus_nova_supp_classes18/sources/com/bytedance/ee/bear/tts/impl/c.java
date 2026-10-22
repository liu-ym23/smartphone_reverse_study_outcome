package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.route.RouteBean;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements mo5.d {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // mo5.d
    public final boolean a(mo5.g r11) {
        Intrinsics.checkNotNullParameter(r11, "itemVM");
        String r1 = mo5.h.a(r11);
        if (r1 != null) goto L6;
        tt5.a.d("TtsDefaultRouter", "openItemSource, itemVM token invalid: " + r11);
        return true;
    L6:
        Integer r4 = mo5.h.b(r11);
        if (r4 != null) goto L9;
    L35:
        tt5.a.d("TtsDefaultRouter", "openItemSource, itemVM type invalid: " + r11);
        return true;
    L9:
        if (r4.intValue() != (-1)) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L35;
        int r6 = r4.intValue();
        if (((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).z5() == true) goto L21;
        tt5.a.k("TtsDefaultRouter", "openItemSource, FG disabled, just open doc.");
        com.bytedance.ee.bear.document.template.b.d(r6, r1);
        return true;
    L21:
        qo5.b r12 = (qo5.b) r11.b().getValue();
        if (r12 != null) goto L25;
        tt5.a.h("TtsDefaultRouter", "openItemSource, m3u8Segment is null, just open doc.");
        com.bytedance.ee.bear.document.template.b.d(r6, r1);
        return true;
    L25:
        String r9 = "";
        String r2 = s45.p.a().ua(sbb.e.d(r6).getType(), r1, "");
        r9 = "anchor-" + r12.a().toString();     // Catch: Exception -> L28
    L30:
        String r13 = r2 + '#' + r9;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L33;
        tt5.a.h("TtsDefaultRouter", "openItemSource, resultUrl: " + du5.b.h(r13));
    L33:
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        RouteBean r3 = new RouteBean();
        r3.c = 1;
        Unit r7 = Unit.INSTANCE;
        r0.m9(r13, r3);
        return true;
    L28:
        e = move-exception;
        tt5.a.e("TtsDefaultRouter", "openItemSource, json error:", e, false);
        goto L30
    L11:
        r5 = false;
        goto L13
    }
}
