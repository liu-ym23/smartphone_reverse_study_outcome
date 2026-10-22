package com.bytedance.ee.bear.bitable.common.widgets;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import com.bytedance.ee.util.ui.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends ColorDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HighlightModel f209931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f209933c;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        HighlightModel r101 = this.f209931a;
        if (r101 == null) goto L10;
        ArrayList<String> r102 = r101.getColorList();
        if (r102 == null) goto L10;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        this.f209933c.setColor(ColorUtils.h(r104));
        this.f209933c.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.drawRect(getBounds(), this.f209933c);
    L10:
        String r105 = this.f209932b;
        if (r105 == null) goto L15;
        this.f209933c.setColor(ColorUtils.h(r105));
        this.f209933c.setStyle(Paint.Style.STROKE);
        this.f209933c.setStrokeWidth(10.0f);
        r100.drawRect(getBounds(), this.f209933c);
        return;
    }

    public d(HighlightModel r100, String r101) {
        this.f209931a = r100;
        this.f209932b = r101;
        this.f209933c = new Paint(1);
    }
}
