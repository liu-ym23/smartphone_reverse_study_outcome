package com.bytedance.kmp.ec.yata.view.render.delegate;

import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final b a(SlcRenderContext r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.g("__ISliceYataService");
        if ((r101 instanceof b) == true) goto L7;
        return null;
    L7:
        return (b) r101;
    }
}
