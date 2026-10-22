package com.bytedance.kmp.ec.yata.view.render.delegate;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public static final ba6.d a(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r r101 = r100.f50217e;
        if (r101 == null) goto L5;
        Map<String, ? extends Object> r102 = r101.f50699a;
    L6:
        if (r102 == null) goto L8;
        Object r103 = r102.get("SliceEventPosterKEY");
    L10:
        if ((r103 instanceof ba6.d) == true) goto L12;
        return null;
    L12:
        return (ba6.d) r103;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
