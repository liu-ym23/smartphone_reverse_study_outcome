package com.ss.android.lark.chat.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.chat.utils.s0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f415087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f415088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC4854a f415089c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.drawable.a$a, reason: collision with other inner class name */
    public interface InterfaceC4854a {
        float a();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f415089c.a();
        Drawable r102 = this.f415087a;
        if (r102 == null) goto L5;
        r102.setBounds(0, 0, getBounds().width(), (int) r101);
    L5:
        Drawable r103 = this.f415087a;
        if (r103 == null) goto L9;
        r103.draw(r100);
    L9:
        if (this.f415088b == null) goto L12;
        r100.save();
        r100.translate(0.0f, r101);
        this.f415088b.setBounds(0, 0, getBounds().width(), getBounds().height() - ((int) r101));
        this.f415088b.draw(r100);
        r100.restore();
        return;
    }

    public a(Drawable r100, RoundedDrawable r101, s0 r102) {
        Intrinsics.checkNotNullParameter(r102, "mDivideYProvider");
        this.f415087a = r100;
        this.f415088b = r101;
        this.f415089c = r102;
    }
}
