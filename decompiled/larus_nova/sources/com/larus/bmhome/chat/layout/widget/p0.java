package com.larus.bmhome.chat.layout.widget;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f305241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f305242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o0 f305243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f305244d;

    public static final class a {
    }

    static {
    }

    public p0(Function0<Unit> r100) {
        this.f305241a = r100;
        this.f305244d = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.larus.bmhome.chat.layout.widget.o0, java.lang.Runnable] */
    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r100, Spannable r101, MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "buffer");
        Intrinsics.checkNotNullParameter(r110, "event");
        FLogger.f375446a.i("LinkMovementLongClickMethod", "onTouchEvent event=" + r110.getAction());
        int r102 = r110.getAction();
        if (r102 == 1) goto L7;
        if (r102 == 0) goto L7;
        if (r102 == 3) goto L7;
        if (r102 == 2) goto L7;
    L38:
        return super.onTouchEvent(r100, r101, r110);
    L7:
        float r103 = (r110.getX() - r100.getTotalPaddingLeft()) + r100.getScrollX();
        float r104 = (r110.getY() - r100.getTotalPaddingTop()) + r100.getScrollY();
        Layout r105 = r100.getLayout();
        int r106 = r105.getOffsetForHorizontal(r105.getLineForVertical((int) r104), r103);
        final ClickableSpan[] r107 = (ClickableSpan[]) r101.getSpans(r106, r106, ClickableSpan.class);
        if (r107 != null) goto L10;
    L12:
        boolean r108 = false;
    L13:
        if (r108 == true) goto L38;
        if (r102 != 1) goto L26;
        o0 r109 = this.f305243c;
        if (r109 == null) goto L19;
        this.f305244d.removeCallbacks(r109);
    L19:
        if ((System.currentTimeMillis() - this.f305242b) >= ViewConfiguration.getLongPressTimeout()) goto L36;
        Function0<Unit> r111 = this.f305241a;
        if (r111 == null) goto L23;
        r111.invoke();
    L23:
        Intrinsics.checkNotNull(r107);
        ClickableSpan r112 = (ClickableSpan) ArraysKt.getOrNull(r107, 0);
        if (r112 == null) goto L36;
        r112.onClick(r100);
    L36:
        return true;
    L26:
        if (r102 != 0) goto L28;
        Selection.setSelection(r101, r101.getSpanStart(r107[0]), r101.getSpanEnd(r107[0]));
        this.f305242b = System.currentTimeMillis();
        ?? r113 = new o0(r107, r100);
        this.f305243c = r113;
        this.f305244d.postDelayed(r113, ViewConfiguration.getLongPressTimeout());
        goto L36
    L28:
        if (r102 != 3) goto L32;
        o0 r114 = this.f305243c;
        if (r114 == null) goto L36;
        this.f305244d.removeCallbacks(r114);
        goto L36
    L32:
        if (r102 == 2) goto L36;
        o0 r115 = this.f305243c;
        if (r115 == null) goto L36;
        this.f305244d.removeCallbacks(r115);
        goto L36
    L10:
        if (r107.length != 0) goto L12;
        r108 = true;
        goto L13
    }
}
