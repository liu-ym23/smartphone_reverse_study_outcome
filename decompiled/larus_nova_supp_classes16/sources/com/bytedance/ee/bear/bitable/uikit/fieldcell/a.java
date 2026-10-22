package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements MutilCellLayout.a {
    public final /* synthetic */ b<h0> a;
    public final /* synthetic */ Context b;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final Drawable a() {
        return this.a.e(this.b);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final boolean b() {
        iv4.b r0 = this.a.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final int getTextColor() {
        iv4.b r0 = this.a.a;
        if (r0 == null) goto L8;
        Integer r1 = r0.c(this.b);
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return ResourcesCompat.getColor(this.b.getResources(), 2131106607, this.b.getTheme());
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final float getTextSize() {
        iv4.b r0 = this.a.a;
        if (r0 != null) goto L7;
        return 12.0f;
    L7:
        return r0.b - 2;
    }

    public a(b<h0> r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
