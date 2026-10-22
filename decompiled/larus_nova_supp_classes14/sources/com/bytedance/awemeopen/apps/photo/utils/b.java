package com.bytedance.awemeopen.apps.photo.utils;

import android.content.Context;
import android.util.Size;
import androidx.core.math.MathUtils;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c {
    public b() {
    }

    @Override // com.bytedance.awemeopen.apps.photo.utils.c
    public final Size a(r14.c r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "aweme");
        Intrinsics.checkNotNullParameter(r4, "context");
        List r5 = r3.v();
        int r0 = 0;
        if (r5 == null) goto L5;
        y r6 = (y) CollectionsKt.getOrNull(r5, 0);
    L6:
        if (r6 == null) goto L8;
        int r1 = r6.d();
    L9:
        if (r6 == null) goto L11;
        r0 = r6.a();
    L11:
        if (r0 != 0) goto L13;
        float r7 = 1.0f;
    L14:
        int r8 = d0.d(r4);
        return new Size(r8, (int) (r8 / MathUtils.clamp(r7, 0.75f, 1.3333334f)));
    L13:
        r7 = r1 / r0;
        goto L14
    L8:
        r1 = 0;
        goto L9
    L5:
        r6 = null;
        goto L6
    }
}
