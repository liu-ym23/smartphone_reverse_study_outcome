package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import uuc.a;

/* JADX INFO: loaded from: classes42.dex */
public class MagicIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f518940a;

    public a getNavigator() {
        return this.f518940a;
    }

    public MagicIndicator(Context r100) {
        super(r100);
    }

    public final void b(int r100) {
        a r101 = this.f518940a;
        if (r101 == null) goto L6;
        r101.onPageSelected(r100);
        return;
    }

    public void setNavigator(a r100) {
        a r101 = this.f518940a;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        r101.b();
    L7:
        this.f518940a = r100;
        removeAllViews();
        if ((this.f518940a instanceof View) == false) goto L11;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        addView((View) this.f518940a, r102);
        this.f518940a.a();
        return;
    }

    public MagicIndicator(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final void a(int r100, float r101, int r102) {
        a r103 = this.f518940a;
        if (r103 == null) goto L6;
        r103.onPageScrolled(r100, r101, r102);
        return;
    }
}
