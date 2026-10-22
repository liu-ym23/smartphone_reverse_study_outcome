package com.ivy.ivykit.plugin.impl.jsb;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes23.dex */
public final class o {
    public static final void a(LynxView r100, String r101, Object r102) {
        if (r102 != null) goto L5;
        JavaOnlyArray r103 = JavaOnlyArray.from(CollectionsKt.emptyList());
    L8:
        r100.sendGlobalEvent(r101, r103);
        return;
    L5:
        if ((r102 instanceof List) == false) goto L7;
        r103 = JavaOnlyArray.from((List) r102);
        goto L8
    L7:
        r103 = JavaOnlyArray.of(new Object[]{r102});
        goto L8
    }
}
