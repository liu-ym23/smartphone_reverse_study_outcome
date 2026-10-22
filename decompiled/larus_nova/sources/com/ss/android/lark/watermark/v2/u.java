package com.ss.android.lark.watermark.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u extends LayerDrawable {
    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return 0;
    }

    public u(v r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable[] r100 = new Drawable[2];
        Resources r101 = r111.getResources();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r101, "res");
        Bitmap r102 = r110.f445557b;
        if (r102 != null) goto L5;
        Drawable r103 = new ColorDrawable(0);
    L6:
        r100[0] = r103;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100[1] = new d(r111, r110.f445556a, r110.f445558c, r110.f445559d, r110.f445560e, r110.f445561f, r110.f445562g, r110.f445563h);
        super(r100);
        setId(0, 0);
        setId(1, 1);
        return;
    L5:
        r103 = new s(r101, r102);
        goto L6
    }
}
