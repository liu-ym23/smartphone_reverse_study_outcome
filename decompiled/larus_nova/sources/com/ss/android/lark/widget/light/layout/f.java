package com.ss.android.lark.widget.light.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends Layout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f446156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextLayoutBuilder.a f446157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Layout f446158c;

    public static final class a {
    }

    static {
    }

    public final Layout a() {
    L18:
        TextLayoutBuilder.a r100 = this.f446157b;     // Catch: IndexOutOfBoundsException -> L13
        if (r100.f446144m == false) goto L6;
        int r110 = 1;
    L7:
        int r101 = r100.f446143l;     // Catch: IndexOutOfBoundsException -> L13
        if (r101 > 0) goto L10;
        r101 = this.f446156a;     // Catch: IndexOutOfBoundsException -> L13
    L10:
        CharSequence r102 = r100.f446135d;     // Catch: IndexOutOfBoundsException -> L13
        int r103 = r102.length();     // Catch: IndexOutOfBoundsException -> L13
        TextLayoutBuilder.a r104 = this.f446157b;     // Catch: IndexOutOfBoundsException -> L13
        TextPaint r105 = r104.f446132a;     // Catch: IndexOutOfBoundsException -> L13
        int r106 = this.f446156a;     // Catch: IndexOutOfBoundsException -> L13
        Layout.Alignment r107 = r104.f446146o;     // Catch: IndexOutOfBoundsException -> L13
        float r108 = r104.f446136e;     // Catch: IndexOutOfBoundsException -> L13
        float r109 = r104.f446137f;     // Catch: IndexOutOfBoundsException -> L13
        boolean r111 = r104.f446139h;     // Catch: IndexOutOfBoundsException -> L13
        TextUtils.TruncateAt r112 = r104.f446142k;     // Catch: IndexOutOfBoundsException -> L13
        TextDirectionHeuristicCompat r113 = r104.f446147p;     // Catch: IndexOutOfBoundsException -> L13
        int r114 = r104.f446148q;     // Catch: IndexOutOfBoundsException -> L13
        r104.getClass();     // Catch: IndexOutOfBoundsException -> L13
        this.f446157b.getClass();     // Catch: IndexOutOfBoundsException -> L13
        this.f446157b.getClass();     // Catch: IndexOutOfBoundsException -> L13
        StaticLayout r115 = g.b(r102, r103, r105, r106, r107, r108, r109, r111, r112, r101, r110, r113, r114, this.f446157b.f446140i);     // Catch: IndexOutOfBoundsException -> L13
        increaseWidthTo(r115.getWidth());
        return r115;
    L6:
        r110 = r100.f446145n;     // Catch: IndexOutOfBoundsException -> L13
    L13:
        e = move-exception;
        if ((this.f446157b.f446135d instanceof String) == true) goto L17;
        Log.e("LightDynamicLayout", "Hit bug #35412, retrying with Spannables removed", e);
        TextLayoutBuilder.a r116 = this.f446157b;
        r116.f446135d = r116.f446135d.toString();
        goto L18
    L17:
        throw e;
    }

    @Override // android.text.Layout
    public final int getBottomPadding() {
        return this.f446158c.getBottomPadding();
    }

    @Override // android.text.Layout
    public final int getLineCount() {
        return this.f446158c.getLineCount();
    }

    @Override // android.text.Layout
    public final int getTopPadding() {
        return this.f446158c.getTopPadding();
    }

    @Override // android.text.Layout
    public final void draw(Canvas r100) {
        this.f446158c.draw(r100);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        Log.e("LightDynamicLayout", "occurs span null " + e.getMessage(), e, true);
    }

    @Override // android.text.Layout
    public final void drawBackground(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (Build.VERSION.SDK_INT < 34) goto L11;
        this.f446158c.drawBackground(r100);     // Catch: NullPointerException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("LightDynamicLayout", "occurs span null " + e.getMessage(), e, true);
        return;
    }

    @Override // android.text.Layout
    public final void drawText(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (Build.VERSION.SDK_INT < 34) goto L11;
        this.f446158c.drawText(r100);     // Catch: NullPointerException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("LightDynamicLayout", "occurs span null " + e.getMessage(), e, true);
        return;
    }

    @Override // android.text.Layout
    public final int getEllipsisCount(int r100) {
        return this.f446158c.getEllipsisCount(r100);
    }

    @Override // android.text.Layout
    public final int getEllipsisStart(int r100) {
        return this.f446158c.getEllipsisStart(r100);
    }

    @Override // android.text.Layout
    public final boolean getLineContainsTab(int r100) {
        return this.f446158c.getLineContainsTab(r100);
    }

    @Override // android.text.Layout
    public final int getLineDescent(int r100) {
        return this.f446158c.getLineDescent(r100);
    }

    @Override // android.text.Layout
    public final Layout.Directions getLineDirections(int r100) {
        return this.f446158c.getLineDirections(r100);
    }

    @Override // android.text.Layout
    public final int getLineStart(int r100) {
        return this.f446158c.getLineStart(r100);
    }

    @Override // android.text.Layout
    public final int getLineTop(int r100) {
        return this.f446158c.getLineTop(r100);
    }

    @Override // android.text.Layout
    public final int getParagraphDirection(int r100) {
        return this.f446158c.getParagraphDirection(r100);
    }

    public f(int r100, TextLayoutBuilder.a r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        super(r110.f446135d, r110.f446132a, 0, r110.f446146o, r110.f446136e, r110.f446137f);
        this.f446156a = r100;
        this.f446157b = r110;
        this.f446158c = a();
    }

    @Override // android.text.Layout
    public final void draw(Canvas r100, Path r101, Paint r102, int r103) {
        this.f446158c.draw(r100, r101, r102, r103);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        Log.e("LightDynamicLayout", "occurs span null " + e.getMessage(), e, true);
    }

    @Override // android.text.Layout
    public final void draw(Canvas r110, List<Path> r111, List<Paint> r112, Path r113, Paint r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (Build.VERSION.SDK_INT < 34) goto L11;
        this.f446158c.draw(r110, r111, r112, r113, r114, r115);     // Catch: NullPointerException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("LightDynamicLayout", "occurs span null " + e.getMessage(), e, true);
        return;
    }
}
