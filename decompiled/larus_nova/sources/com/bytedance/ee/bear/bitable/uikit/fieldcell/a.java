package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements MutilCellLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<h0> f216156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f216157b;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final Drawable a() {
        return this.f216156a.e(this.f216157b);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final boolean b() {
        iv4.b r100 = this.f216156a.f216158a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f495938a;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final int getTextColor() {
        iv4.b r100 = this.f216156a.f216158a;
        if (r100 == null) goto L8;
        Integer r101 = r100.c(this.f216157b);
        if (r101 == null) goto L8;
        return r101.intValue();
    L8:
        return ResourcesCompat.getColor(this.f216157b.getResources(), R.color.text_caption, this.f216157b.getTheme());
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
    public final float getTextSize() {
        iv4.b r100 = this.f216156a.f216158a;
        if (r100 != null) goto L7;
        return 12.0f;
    L7:
        return r100.f495939b - 2;
    }

    public a(b<h0> r100, Context r101) {
        this.f216156a = r100;
        this.f216157b = r101;
    }
}
