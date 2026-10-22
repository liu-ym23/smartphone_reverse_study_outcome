package com.bytedance.locallife.poi.newdetail;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.bytedance.locallife.dito.core.BaseDitoView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class t {
    public static final Activity a(BaseDitoView<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100.getContext();
        Activity r102 = null;
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r101;
    L6:
        if (r103 != null) goto L19;
        Context r104 = r100.getContext();
        if ((r104 instanceof ContextThemeWrapper) == false) goto L10;
        ContextThemeWrapper r105 = (ContextThemeWrapper) r104;
    L11:
        if (r105 == null) goto L13;
        Context r106 = r105.getBaseContext();
    L15:
        if ((r106 instanceof Activity) == false) goto L18;
        r102 = (Activity) r106;
    L18:
        return r102;
    L13:
        r106 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L19:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public static final void b(BaseDitoView<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = com.bytedance.locallife.biz.fmp.a.f256694b;
        r100.setTag(com.bytedance.locallife.biz.fmp.a.f256694b, Boolean.TRUE);
    }
}
