package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ t a;

    public w(t r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        EdgeGradientFrameLayout r0 = this.a.a;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 != null) goto L10;
        r2 = new ViewGroup.MarginLayoutParams(-2, -2);
    L10:
        r2.bottomMargin = r5.intValue();
        Unit r6 = Unit.INSTANCE;
        r0.setLayoutParams(r2);
        return;
    }
}
