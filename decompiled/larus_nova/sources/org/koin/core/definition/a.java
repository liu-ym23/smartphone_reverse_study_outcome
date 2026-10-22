package org.koin.core.definition;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static final String a(KClass<?> r100, mwc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (r101 != null) goto L5;
        String r102 = null;
    L6:
        if (r102 == null) goto L9;
        return pwc.a.a(r100) + "::" + r101.getValue();
    L9:
        return pwc.a.a(r100);
    L5:
        r102 = r101.getValue();
        goto L6
    }
}
