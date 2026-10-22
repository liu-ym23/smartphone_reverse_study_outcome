package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public PopupWindow a;
    public View b;
    public final a c;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopupWindow r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            PopupWindowLancet.handleDismissBeforeOrigin(r0);     // Catch: Throwable -> L6
            r0.dismiss();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a() {
        View r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.c);
    L5:
        PopupWindow r1 = this.a;
        if (r1 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        return;
    }

    public e() {
        this.c = new a(this);
    }

    public final boolean b(View r11, Activity r12, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "onClick");
        if (r11 == null) goto L41;
        if (r12 == null) goto L41;
        int r1 = pi3.a.a;
        com.bytedance.android.ec.sdk.helper.q r2 = com.bytedance.android.ec.sdk.helper.q.a;
        long r3 = r2.getLong("anchor_v4_find_similar_bubble_last_show_time", -1);
        long r5 = System.currentTimeMillis() / ((long) 1000);
        if (r3 <= 0) goto L12;
        long r4 = r5 - r3;
        int r7 = i.a;
        if (r4 >= 7776000) goto L12;
        return false;
    L12:
        if (r13 != null) goto L14;
    L16:
        r2.e("anchor_v4_find_similar_bubble_last_show_time", r5);
        this.b = LayoutInflater.from(r12).inflate(2131560494, null);
        PopupWindow r15 = new PopupWindow(this.b, -2, -2, true);
        this.a = r15;
        r15.setTouchable(true);
        PopupWindow r16 = this.a;
        if (r16 == null) goto L19;
        r16.setFocusable(false);
    L19:
        PopupWindow r17 = this.a;
        if (r17 == null) goto L22;
        r17.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        PopupWindow r18 = this.a;
        if (r18 == null) goto L28;
        int r19 = -com.bytedance.android.shopping.extensions.b.a(79);
        OverlaySource r6 = PopupWindowLancet.resolveSource(r11);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r18, r11, r6) == true) goto L28;
        r18.showAsDropDown(r11, r19, 0);
        PopupWindowLancet.trackAfterShow(r18, r6, r11);
    L28:
        PopupWindow r110 = this.a;
        if (r110 == null) goto L31;
        r110.setOutsideTouchable(true);
    L31:
        PopupWindow r111 = this.a;
        if (r111 == null) goto L34;
        r111.setOnDismissListener(new f(this));
    L34:
        View r112 = this.b;
        if (r112 == null) goto L37;
        r112.postDelayed(this.c, 3000);
    L37:
        View r113 = this.b;
        if (r113 == null) goto L40;
        r113.setOnClickListener(new g(this, r14));
    L40:
        return true;
    L14:
        if (r13.ey(com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.y) != true) goto L16;
        return false;
    L41:
        return false;
    }
}
