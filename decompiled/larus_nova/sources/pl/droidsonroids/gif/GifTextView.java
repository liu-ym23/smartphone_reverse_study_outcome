package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes41.dex */
public class GifTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i.b f529689a;

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        Drawable[] r100 = new Drawable[7];
        if (this.f529689a.f529736a == false) goto L6;
        Drawable[] r101 = getCompoundDrawables();
        System.arraycopy(r101, 0, r100, 0, r101.length);
        Drawable[] r102 = getCompoundDrawablesRelative();
        r100[4] = r102[0];
        r100[5] = r102[2];
        r100[6] = getBackground();
    L6:
        return new GifViewSavedState(super.onSaveInstanceState(), r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    public GifTextView(Context r100) {
        super(r100);
    }

    private void setCompoundDrawablesVisible(boolean r100) {
        Drawable[] r101 = getCompoundDrawables();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Drawable r104 = r101[r103];
        if (r104 == null) goto L7;
        r104.setVisible(r100, false);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        Drawable[] r105 = getCompoundDrawablesRelative();
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L14;
        Drawable r108 = r105[r107];
        if (r108 == null) goto L13;
        r108.setVisible(r100, false);
    L13:
        r107 = r107 + 1;
        goto L9
    }

    public final Drawable a(int r100) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        Resources r101 = getResources();
        String r102 = r101.getResourceTypeName(r100);
        if (isInEditMode() == true) goto L12;
        if (i.f529733a.contains(r102) == false) goto L12;
        return new d(r101, r100);
    L12:
        return r101.getDrawable(r100, getContext().getTheme());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof GifViewSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        GifViewSavedState r101 = (GifViewSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        Drawable[] r102 = getCompoundDrawables();
        r101.a(r102[0], 0);
        r101.a(r102[1], 1);
        r101.a(r102[2], 2);
        r101.a(r102[3], 3);
        Drawable[] r103 = getCompoundDrawablesRelative();
        r101.a(r103[0], 4);
        r101.a(r103[2], 5);
        r101.a(getBackground(), 6);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        setBackground(a(r100));
    }

    public void setFreezesAnimation(boolean r100) {
        this.f529689a.f529736a = r100;
    }

    public GifTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r101, 0);
    }

    public final void b(AttributeSet r110, int r111) {
        if (r110 == null) goto L28;
        int r100 = 0;
        Drawable r101 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
        Drawable r102 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
        Drawable r103 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
        Drawable r104 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
        Drawable r105 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
        Drawable r106 = a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
        if (getLayoutDirection() != 0) goto L11;
        if (r105 == null) goto L8;
        r101 = r105;
    L8:
        if (r106 == null) goto L18;
        r103 = r106;
    L18:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r101, r102, r103, r104);
        setBackground(a(r110.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
        i.b r107 = new i.b(this, r110, r111);
        this.f529689a = r107;
        if (r107.f529737b < 0) goto L28;
        Drawable[] r112 = getCompoundDrawables();
        int r113 = r112.length;
        int r108 = 0;
    L22:
        if (r108 >= r113) goto L24;
        Drawable r109 = r112[r108];
        i.a(this.f529689a.f529737b, r109);
        r108 = r108 + 1;
        goto L22
    L24:
        Drawable[] r114 = getCompoundDrawablesRelative();
        int r115 = r114.length;
    L25:
        if (r100 >= r115) goto L27;
        Drawable r116 = r114[r100];
        i.a(this.f529689a.f529737b, r116);
        r100 = r100 + 1;
        goto L25
    L27:
        i.a(this.f529689a.f529737b, getBackground());
        goto L28
    L11:
        if (r105 == null) goto L14;
        r103 = r105;
    L14:
        if (r106 == null) goto L17;
        r101 = r106;
    L17:
        Drawable r117 = r103;
        r103 = r101;
        r101 = r117;
    L28:
        this.f529689a = new i.b();
    }

    public GifTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r101, r102);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(r100), a(r101), a(r102), a(r103));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        setCompoundDrawablesWithIntrinsicBounds(a(r100), a(r101), a(r102), a(r103));
    }
}
