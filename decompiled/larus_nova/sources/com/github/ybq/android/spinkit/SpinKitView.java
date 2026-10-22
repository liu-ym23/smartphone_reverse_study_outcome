package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.larus.nova.R;
import tu7.a;
import wu7.f;
import xu7.b;
import xu7.c;
import xu7.d;
import xu7.e;
import xu7.g;
import xu7.h;
import xu7.i;
import xu7.j;
import xu7.k;
import xu7.l;
import xu7.m;
import xu7.n;
import xu7.o;

/* JADX INFO: loaded from: classes23.dex */
public class SpinKitView extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f274341b;

    @Override // android.widget.ProgressBar
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public f getIndeterminateDrawable() {
        return this.f274341b;
    }

    public SpinKitView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onScreenStateChanged(int r100) {
        super.onScreenStateChanged(r100);
        if (r100 != 0) goto L8;
        f r101 = this.f274341b;
        if (r101 == null) goto L9;
        r101.stop();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f274341b != null) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L12;
        this.f274341b.start();
        return;
    }

    public void setColor(int r100) {
        this.f274340a = r100;
        f r101 = this.f274341b;
        if (r101 == null) goto L5;
        r101.e(r100);
    L5:
        invalidate();
    }

    public void setIndeterminateDrawable(f r100) {
        super.setIndeterminateDrawable(r100);
        this.f274341b = r100;
        if (r100.c() != 0) goto L5;
        this.f274341b.e(this.f274340a);
    L5:
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() != 0) goto L9;
        this.f274341b.start();
        return;
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable r100) {
        super.unscheduleDrawable(r100);
        if ((r100 instanceof f) == false) goto L6;
        ((f) r100).stop();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable r100) {
        if ((r100 instanceof f) == false) goto L7;
        setIndeterminateDrawable((f) r100);
        return;
    L7:
        throw new IllegalArgumentException("this d must be instanceof Sprite");
    }

    public SpinKitView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.SpinKitViewStyle);
    }

    public SpinKitView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, R.style.SpinKitView);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.SpinKit_Color, R.attr.SpinKit_Style}, r102, R.style.SpinKitView);
        Style r104 = Style.values()[r103.getInt(1, 0)];
        this.f274340a = r103.getColor(0, -1);
        r103.recycle();
        switch(a.f547639a[r104.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L4;
        };
    L4:
        f r105 = null;
    L20:
        r105.e(this.f274340a);
        setIndeterminateDrawable(r105);
        setIndeterminate(true);
        return;
    L5:
        r105 = new h();
        goto L20
    L6:
        r105 = new j();
        goto L20
    L7:
        r105 = new g();
        goto L20
    L8:
        r105 = new k();
        goto L20
    L9:
        r105 = new xu7.f();
        goto L20
    L10:
        r105 = new e();
        goto L20
    L11:
        r105 = new c();
        goto L20
    L12:
        r105 = new b();
        goto L20
    L13:
        r105 = new m();
        goto L20
    L14:
        r105 = new xu7.a();
        goto L20
    L15:
        r105 = new i();
        goto L20
    L16:
        r105 = new n();
        goto L20
    L17:
        r105 = new o();
        goto L20
    L18:
        r105 = new d();
        goto L20
    L19:
        r105 = new l();
        goto L20
    }
}
