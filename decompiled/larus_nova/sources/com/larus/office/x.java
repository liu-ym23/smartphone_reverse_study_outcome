package com.larus.office;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class x {
    public static final String a(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        w r101 = b(r100);
        if (r101 == null) goto L7;
        OfficeInputParam r102 = r101.f363627a;
        if (r102 == null) goto L7;
        String r103 = r102.getDocLogicKey();
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        return "default_doc_logic_key";
    L17:
        return r103;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public static final w b(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (w) r100.getHostAbilityOrNull(w.class);
    }
}
