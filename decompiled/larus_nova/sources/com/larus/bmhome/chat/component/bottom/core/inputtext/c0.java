package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f298711a;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public c0(b0 r100) {
        this.f298711a = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        b0 r101 = this.f298711a;
        b0.a r102 = r101.f298700e;
        if (r102 != null) goto L5;
        return;
    L5:
        r101.f298699d.set(r101.f298696a.getPaint());
        b0 r103 = this.f298711a;
        Paint r104 = r103.f298699d;
        ColorStateList r105 = r103.f298701f;
        if (r105 == null) goto L12;
        int[] r106 = r103.f298696a.getDrawableState();
        ColorStateList r107 = this.f298711a.f298701f;
        if (r107 == null) goto L10;
        int r108 = r107.getDefaultColor();
    L11:
        int r109 = r105.getColorForState(r106, r108);
    L13:
        r104.setColor(r109);
        if (r102.f298707d == false) goto L16;
        float r110 = r102.f298705b;
        b0 r111 = this.f298711a;
        float r112 = r110 - r111.f298699d.measureText(r111.f298698c);
    L17:
        int r113 = r100.save();
        r100.translate(this.f298711a.f298696a.getScrollX(), this.f298711a.f298696a.getScrollY());
        r100.clipRect(this.f298711a.f298696a.getTotalPaddingLeft(), this.f298711a.f298696a.getExtendedPaddingTop(), this.f298711a.f298696a.getWidth() - this.f298711a.f298696a.getTotalPaddingRight(), this.f298711a.f298696a.getHeight() - this.f298711a.f298696a.getExtendedPaddingBottom());
        b0 r114 = this.f298711a;
        r100.drawText(r114.f298698c, r112, r102.f298706c, r114.f298699d);
        r100.restoreToCount(r113);
        return;
    L16:
        r112 = r102.f298705b;
        goto L17
    L10:
        r108 = FakePickerAvatarCreator.GRAY;
        goto L11
    L12:
        r109 = r103.f298696a.getCurrentHintTextColor();
        goto L13
    }
}
