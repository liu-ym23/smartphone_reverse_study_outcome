package com.bytedance.ee.bear.bitable.common.widgets;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends ColorDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f209887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f209889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f209890d;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        String r101 = this.f209887a;
        if (r101 == null) goto L5;
        this.f209890d.setColor(ColorUtils.h(r101));
        this.f209890d.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.drawRect(getBounds(), this.f209890d);
    L8:
        String r102 = this.f209888b;
        if (r102 == null) goto L12;
        this.f209890d.setColor(ColorUtils.h(r102));
        this.f209890d.setStyle(Paint.Style.STROKE);
        this.f209890d.setStrokeWidth(10.0f);
        r100.drawRect(getBounds(), this.f209890d);
        return;
    L12:
        return;
    L5:
        String r103 = this.f209889c;
        if (r103 == null) goto L8;
        this.f209890d.setColor(ColorUtils.h(r103));
        this.f209890d.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.drawRect(getBounds(), this.f209890d);
        goto L8
    }

    public c(String r100, String r101) {
        this.f209887a = r100;
        this.f209888b = r101;
        this.f209889c = null;
        this.f209890d = new Paint(1);
    }
}
