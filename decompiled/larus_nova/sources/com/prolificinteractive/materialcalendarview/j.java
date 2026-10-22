package com.prolificinteractive.materialcalendarview;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.widget.ImageView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends ImageView {
    public j(Context r100) {
        super(r100);
        int r101 = r100.getResources().getIdentifier("selectableItemBackgroundBorderless", SlcElement.KEY_ATTR, r100.getPackageName());
        if (r101 != 0) goto L5;
        r101 = R.attr.selectableItemBackgroundBorderless;
    L5:
        TypedValue r102 = new TypedValue();
        r100.getTheme().resolveAttribute(r101, r102, true);
        setBackgroundResource(r102.resourceId);
    }

    @Override // android.view.View
    public final void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.1f;
        goto L6
    }
}
