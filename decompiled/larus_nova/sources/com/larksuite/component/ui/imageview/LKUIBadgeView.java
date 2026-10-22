package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIBadgeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284166a;

    public final void a() {
        a r100 = this.f284166a;
        boolean r101 = true;
        if (r100.f284175h == false) goto L9;
        r100.a();
        if (r100.getCallback() == null) goto L7;
        r100.getCallback().invalidateDrawable(r100);
    L7:
        r100.f284175h = false;
        r100.f284176i = false;
    L12:
        if (r101 == false) goto L14;
        requestLayout();
        return;
    L14:
        invalidate();
        return;
    L9:
        if (r100.f284176i == false) goto L11;
        r100.f284176i = false;
        r100.invalidateSelf();
        goto L12
    L11:
        r101 = false;
        goto L12
    }

    public LKUIBadgeView(Context r100) {
        this(r100, null);
    }

    public final void b(int r100) {
        if (r100 != 0) goto L4;
        Drawable r101 = null;
    L5:
        a r102 = this.f284166a;
        if (r102.f284170c == r101) goto L9;
        r102.f284170c = r101;
        r102.f284175h = true;
        return;
    L9:
        return;
    L4:
        r101 = AppCompatResources.getDrawable(getContext(), r100);
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.translate((getWidth() - this.f284166a.f284177j) / 2, (getHeight() - this.f284166a.f284178k) / 2);
        this.f284166a.draw(r100);
    }

    public LKUIBadgeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(Math.max(this.f284166a.f284177j, getMinimumWidth()), Math.max(this.f284166a.f284178k, getMeasuredHeight()));
    }

    public LKUIBadgeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.badgeBackground, R.attr.badgeIcon, R.attr.badgePadding, R.attr.badgeRadius, R.attr.text, R.attr.textColor, R.attr.textSize}, r102, 0);
        Drawable r104 = r103.getDrawable(0);
        r103.getDimensionPixelSize(3, 0);
        Drawable r105 = r103.getDrawable(1);
        int r106 = r103.getDimensionPixelSize(2, 0);
        int r107 = r103.getColor(5, -1);
        int r108 = r103.getDimensionPixelSize(6, (int) j08.b.a(r100, 12.0f));
        CharSequence r109 = r103.getText(4);
        r103.recycle();
        a.C3912a r110 = new a.C3912a(r100);
        r110.f284182c = r104;
        r110.f284184e = r105;
        r110.f284185f = r106;
        r110.f284180a = r109;
        r110.f284183d = r107;
        r110.f284181b = r108;
        this.f284166a = new a(r110);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        a r105 = this.f284166a;
        r105.setBounds(0, 0, r105.f284177j, r105.f284178k);
    }
}
