package com.story.ai.biz.comment.view;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<View, MotionEvent, Unit> f459956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f459957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f459958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f459959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f459960e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.story.ai.biz.comment.view.a] */
    public b(Function2<? super View, ? super MotionEvent, Unit> r100) {
        this.f459956a = r100;
        this.f459957b = -1;
        this.f459959d = new Handler(Looper.getMainLooper());
        this.f459960e = new a(this);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "event");
        int r100 = r111.getAction();
        TextView r101 = (TextView) r110;
        CharSequence r102 = r101.getText();
        if (r100 == 2) goto L5;
        this.f459959d.removeCallbacksAndMessages(null);
    L5:
        long r103 = System.currentTimeMillis();
        boolean r104 = false;
        if (r100 == 0) goto L37;
        if (r100 == 1) goto L11;
        Function2<View, MotionEvent, Unit> r105 = this.f459956a;
        if (r105 == null) goto L49;
        r105.invoke(r110, r111);
    L49:
        return true;
    L11:
        FLogger.f375446a.d("ClickSpanConflictTouchListener", "onTouch:" + r111);
        if ((r102 instanceof Spanned) == false) goto L30;
        int r106 = (int) r111.getX();
        int r107 = (int) r111.getY();
        int r108 = r106 - r101.getTotalPaddingLeft();
        int r109 = r107 - r101.getTotalPaddingTop();
        int r112 = r108 + r101.getScrollX();
        int r113 = r109 + r101.getScrollY();
        Layout r114 = r101.getLayout();
        int r115 = r114.getOffsetForHorizontal(r114.getLineForVertical(r113), r112);
        ClickableSpan[] r116 = (ClickableSpan[]) ((Spanned) r102).getSpans(r115, r115, ClickableSpan.class);
        if ((r103 - this.f459957b) < ViewConfiguration.getLongPressTimeout()) goto L16;
        boolean r117 = true;
    L17:
        Intrinsics.checkNotNull(r116);
        if (r116.length != 0) goto L20;
        boolean r118 = true;
    L22:
        if ((!r118) == false) goto L25;
        if (r117 == true) goto L49;
        r116[0].onClick(r101);
        goto L49
    L25:
        Function2<View, MotionEvent, Unit> r119 = this.f459956a;
        if (r119 == null) goto L28;
        r119.invoke(r110, r111);
    L28:
        if (r117 == true) goto L49;
        r110.performClick();
        goto L49
    L20:
        r118 = false;
        goto L22
    L16:
        r117 = false;
        goto L17
    L30:
        Function2<View, MotionEvent, Unit> r120 = this.f459956a;
        if (r120 == null) goto L34;
        r120.invoke(r110, r111);
    L34:
        if ((r103 - this.f459957b) >= ViewConfiguration.getLongPressTimeout()) goto L49;
        r110.performClick();
        goto L49
    L37:
        if ((r102 instanceof Spanned) == false) goto L45;
        int r121 = (int) r111.getX();
        int r122 = (int) r111.getY();
        int r123 = r121 - r101.getTotalPaddingLeft();
        int r124 = r122 - r101.getTotalPaddingTop();
        int r125 = r123 + r101.getScrollX();
        int r126 = r124 + r101.getScrollY();
        Layout r127 = r101.getLayout();
        int r128 = r127.getOffsetForHorizontal(r127.getLineForVertical(r126), r125);
        ClickableSpan[] r129 = (ClickableSpan[]) ((Spanned) r102).getSpans(r128, r128, ClickableSpan.class);
        Intrinsics.checkNotNull(r129);
        if (r129.length != 0) goto L41;
        r104 = true;
    L41:
        if (r104 == false) goto L48;
        Function2<View, MotionEvent, Unit> r130 = this.f459956a;
        if (r130 == null) goto L48;
        r130.invoke(r110, r111);
    L48:
        this.f459957b = System.currentTimeMillis();
        this.f459958c = r110;
        this.f459959d.postDelayed(this.f459960e, ViewConfiguration.getLongPressTimeout());
        goto L49
    L45:
        Function2<View, MotionEvent, Unit> r131 = this.f459956a;
        if (r131 == null) goto L48;
        r131.invoke(r110, r111);
        goto L48
    }
}
