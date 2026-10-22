package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class v {
    public static final u a(xra.a r110, AINoteScene r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "scene");
        String r100 = r110.f564913r;
        if (r100 != null) goto L5;
    L15:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r112 = r100;
    L8:
        if (r112 == null) goto L15;
        if (r110.f564904i.isMark() == true) goto L14;
        return null;
    L14:
        return new u(r110.c(), r110.f564897b, r111, r110.f564904i, r112, r110.f564914s, r110.f564910o);
    L7:
        r112 = null;
        goto L8
    }
}
