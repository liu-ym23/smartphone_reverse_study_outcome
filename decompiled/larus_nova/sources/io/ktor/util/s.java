package io.ktor.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class s {
    public static final void a(StringValuesBuilderImpl r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "builder");
        Iterator<T> r102 = r101.entries().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.d((String) r103.getKey(), (List) r103.getValue());
        goto L4
    }
}
