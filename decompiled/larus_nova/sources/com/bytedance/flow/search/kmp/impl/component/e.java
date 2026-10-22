package com.bytedance.flow.search.kmp.impl.component;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Function0<vv5.a>> f243563a = null;

    static {
        f243563a = new LinkedHashMap();
    }

    public static vv5.a a(String r100, vv5.a r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r101;
    L11:
        Function0 r103 = (Function0) ((LinkedHashMap) f243563a).get(r100);
        if (r103 == null) goto L18;
        vv5.a r104 = (vv5.a) r103.invoke();
        if (r104 != null) goto L17;
        return r101;
    L17:
        return r104;
    L18:
        return r101;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
