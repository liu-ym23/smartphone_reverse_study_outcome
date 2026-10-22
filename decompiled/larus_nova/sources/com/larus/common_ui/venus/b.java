package com.larus.common_ui.venus;

import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final void a(View r100, a.C4189a r101) {
        a r102 = new a(r101);
        LayerDrawable r103 = new LayerDrawable(new a[]{r102});
        r103.setLayerInset(0, (int) r102.f327953b, (int) r102.f327955d, (int) r102.f327954c, (int) r102.f327956e);
        r100.setBackground(r103);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return;
    L5:
        if (r102.getPaint() == null) goto L9;
        r100.setLayerType(1, r102.getPaint());
        return;
    }
}
