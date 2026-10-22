package com.ss.android.lark.todo.impl.features.common.richtext2;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends ArrowKeyMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MovementMethod f442466a;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "buffer");
        Intrinsics.checkNotNullParameter(r102, "event");
        boolean r103 = false;
        if (r102.getAction() != 1) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L46;
        int r105 = (int) r102.getX();
        int r106 = (int) r102.getY();
        int r107 = r105 - r100.getTotalPaddingLeft();
        int r108 = r106 - r100.getTotalPaddingTop();
        int r109 = r107 + r100.getScrollX();
        int r110 = r108 + r100.getScrollY();
        Layout r111 = r100.getLayout();
        if (r111 != null) goto L10;
        return false;
    L10:
        int r112 = r111.getOffsetForHorizontal(r111.getLineForVertical(r110), r109);
        ClickableSpan[] r113 = (ClickableSpan[]) r101.getSpans(r112, r112, ClickableSpan.class);
        ClickableSpan r114 = null;
        if (r113 == null) goto L13;
        ClickableSpan r115 = (ClickableSpan) ArraysKt.getOrNull(r113, 0);
    L14:
        if (r115 != null) goto L16;
    L39:
        ClickableSpan[] r116 = (ClickableSpan[]) r101.getSpans(r112, r112, ClickableSpan.class);
        if (r116 == null) goto L42;
        r114 = (ClickableSpan) ArraysKt.getOrNull(r116, 0);
    L42:
        if (r114 == null) goto L46;
        r114.onClick(r100);
        return true;
    L16:
        if ((r115 instanceof e) == false) goto L32;
        ImageSpan[] r117 = (ImageSpan[]) r101.getSpans(r112, r112, ImageSpan.class);
        if (r117 == null) goto L20;
        ImageSpan r118 = (ImageSpan) ArraysKt.getOrNull(r117, 0);
    L21:
        if (r118 == null) goto L39;
        Rect r119 = new com.ss.android.lark.widget.span.m(r118).a(r100);
        if (r102.getRawX() >= r119.left) goto L25;
    L31:
        return true;
    L25:
        if (r102.getRawX() > r119.right) goto L31;
        if (r102.getRawY() < r119.top) goto L31;
        if (r102.getRawY() > r119.bottom) goto L31;
        ((e) r115).onClick(r100);
        goto L31
    L20:
        r118 = null;
        goto L21
    L32:
        int r120 = r101.getSpanStart(r115);
        int r121 = r101.getSpanEnd(r115);
        if ((r120 + 1) > r112) goto L36;
        if (r112 >= r121) goto L36;
        r103 = true;
    L36:
        if (r103 == false) goto L38;
        r115.onClick(r100);
    L38:
        return true;
    L13:
        r115 = null;
    L46:
        return super.onTouchEvent(r100, r101, r102);
    L5:
        r104 = false;
        goto L6
    }
}
