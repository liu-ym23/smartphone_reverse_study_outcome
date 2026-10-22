package com.larus.audio.call.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n {
    public static final <T> T a(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
        return null;
    L5:
        if (r101 < r100.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r100, r101);
    }
}
