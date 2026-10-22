package com.bytedance.dux.filter;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import em4.g;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes15.dex */
public class CenterIconButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f205046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205050e;

    private int getTextWidth() {
        if (this.f205046a != null) goto L5;
        this.f205046a = new Rect();
    L5:
        TextPaint r100 = getPaint();
        String r101 = getText().toString();
        if (r101.isEmpty() == false) goto L8;
        String r102 = "";
    L28:
        r100.getTextBounds(r102, 0, r102.length(), this.f205046a);
        this.f205046a.height();
        return this.f205046a.width();
    L8:
        ArrayList r103 = new ArrayList();
        StringTokenizer r104 = new StringTokenizer(r101, "\n", false);
    L10:
        if (r104.hasMoreTokens() == false) goto L13;
        r103.add(r104.nextToken());
        goto L10
    L13:
        if (r103.size() == 1) goto L15;
        r102 = (String) ListProtector.get(r103, 0);
        int r105 = 0;
    L20:
        if (r105 >= (r103.size() - 1)) goto L26;
        int r106 = r105 + 1;
        if (((String) ListProtector.get(r103, r106)).length() <= ((String) ListProtector.get(r103, r105)).length()) goto L24;
        r102 = (String) ListProtector.get(r103, r106);
    L24:
        r105 = r106;
        goto L20
    L26:
        if (isAllCaps() == false) goto L28;
        r102 = r102.toUpperCase();
        goto L28
    L15:
        if (isAllCaps() == false) goto L17;
        r102 = ((String) ListProtector.get(r103, 0)).toUpperCase();
        goto L28
    L17:
        r102 = (String) ListProtector.get(r103, 0);
        goto L28
    }

    @Override // android.widget.TextView
    public final boolean isAllCaps() {
        TransformationMethod r100 = getTransformationMethod();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    public CenterIconButton(Context r100) {
        super(r100);
        this.f205047b = 0;
        a(r100, null);
    }

    public final void b(int r110) {
        if (r110 != 0) goto L4;
        return;
    L4:
        Drawable[] r100 = getCompoundDrawables();
        if (r100.length == 4) goto L7;
        return;
    L7:
        Drawable r101 = r100[0];
        Drawable r102 = r100[2];
        if (r101 != null) goto L11;
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = getTextWidth();
        int r104 = Math.max(getCompoundDrawablePadding(), 1);
        if (r101 != null) goto L14;
        int r105 = 0;
    L15:
        if (r102 != null) goto L17;
        int r106 = 0;
    L18:
        if (r101 == null) goto L21;
        if (r102 == null) goto L21;
        int r111 = ((((r110 - r105) - r106) - r103) - (r104 * 4)) / 2;
    L24:
        setIncludeFontPadding(false);
        Math.max(this.f205048c, r111);
        getPaddingTop();
        Math.max(r111, this.f205049d);
        getPaddingBottom();
        super.setPadding(Math.max(this.f205048c, r111), getPaddingTop(), Math.max(r111, this.f205049d), getPaddingBottom());
        return;
    L21:
        if (r101 == null) goto L23;
        r111 = (((r110 - r105) - r104) - r103) / 2;
        goto L24
    L23:
        r111 = (((r110 - r106) - r104) - r103) / 2;
        goto L24
    L17:
        r106 = r102.getBounds().width();
        goto L18
    L14:
        r105 = r101.getBounds().width();
        goto L15
    }

    public CenterIconButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f205047b = 0;
        a(r100, r101);
    }

    public final void a(Context r110, AttributeSet r111) {
        if (r111 == null) goto L27;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.drawablePadding, com.larus.nova.R.attr.drawableSize, com.larus.nova.R.attr.drawableTint});
        this.f205047b = r112.getColor(2, 0);
        this.f205050e = r112.getDimensionPixelSize(1, g.c(12));
        setCompoundDrawablePadding((int) r112.getDimension(0, g.c(4)));
        if (this.f205047b == 0) goto L6;
    L7:
        Drawable[] r100 = getCompoundDrawables();
        if (r100.length != 4) goto L26;
        Drawable[] r101 = new Drawable[4];
        int r102 = 0;
    L11:
        if (r102 >= 4) goto L23;
        Drawable r103 = r100[r102];
        if (r103 == null) goto L21;
        if (this.f205047b == 0) goto L18;
        r103 = DrawableCompat.wrap(r103).mutate();
        DrawableCompat.setTint(r103, this.f205047b);
    L18:
        if (this.f205050e <= 0) goto L20;
        Rect r104 = r103.getBounds();
        int r105 = this.f205050e;
        r104.set(0, 0, r105, r105);
    L20:
        r101[r102] = r103;
    L21:
        r102 = r102 + 1;
        goto L11
    L23:
        if (this.f205050e <= 0) goto L25;
        setCompoundDrawables(r101[0], r101[1], r101[2], r101[3]);
        goto L26
    L25:
        setCompoundDrawablesWithIntrinsicBounds(r101[0], r101[1], r101[2], r101[3]);
    L26:
        r112.recycle();
        goto L27
    L6:
        if (this.f205050e == (-1)) goto L26;
    L27:
        this.f205048c = getPaddingLeft();
        this.f205049d = getPaddingRight();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
        b(getMeasuredWidth());
    }

    public CenterIconButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f205047b = 0;
        a(r100, r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b(r100);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawables(r100, r101, r102, r103);
        b(getMeasuredWidth());
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesWithIntrinsicBounds(r100, r101, r102, r103);
        b(getMeasuredWidth());
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        this.f205048c = r100;
        this.f205049d = r102;
        b(getMeasuredWidth());
    }
}
