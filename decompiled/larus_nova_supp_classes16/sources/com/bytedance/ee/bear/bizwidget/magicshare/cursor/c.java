package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import android.app.Activity;
import android.graphics.RectF;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.b {
    public static final int g = 0;
    public final Activity a;
    public final com.bytedance.ee.bear.bizwidget.magicshare.cursor.a b;
    public final int c;
    public boolean d;
    public final ImageView e;
    public final b f;

    public static final class a {
    }

    public static final class b implements WebFollowCursorDispatcher.a {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.WebFollowCursorDispatcher.a
        public final void a(CursorPosData r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            c.a(this.a, r3);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.f("WebFollowCursorManager", e, false);
        }
    }

    static {
        g = n.d(20);
    }

    public final void b() {
        if (this.d == false) goto L5;
        this.a.getWindow().getWindowManager().removeView(this.e);
    L5:
        this.d = false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void hide() {
        ArrayList<WebFollowCursorDispatcher.a> r0 = WebFollowCursorDispatcher.a;
        b r1 = this.f;
        Intrinsics.checkNotNullParameter(r1, "listener");
        WebFollowCursorDispatcher.a.remove(r1);
        b();
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void show() {
        ArrayList<WebFollowCursorDispatcher.a> r0 = WebFollowCursorDispatcher.a;
        WebFollowCursorDispatcher.a(this.f);
    }

    public final Activity getActivity() {
        return this.a;
    }

    public static final void a(c r10, CursorPosData r11) {
        r10.getClass();
        if (r11.getClose() == false) goto L5;
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData, data.close is true");
        r10.b();
        return;
    L5:
        Float r0 = r11.getX();
        Float r2 = r11.getY();
        if (r0 == null) goto L40;
        if (r2 == null) goto L40;
        View r12 = r10.b.o0();
        RectF r3 = r10.b.p0();
        boolean r4 = true;
        int r5 = 0;
        if (r12 == null) goto L31;
        if (r3 == null) goto L31;
        int[] r1 = new int[2];
        r12.getLocationInWindow(r1);
        float r7 = r1[0];
        RectF r6 = new RectF(r7, r1[1], r12.getMeasuredWidth() + r7, r1[1] + r12.getMeasuredHeight());
        float r13 = r3.left + (r3.width() * r0.floatValue());
        float r8 = r3.top + (r3.height() * r2.floatValue());
        float r9 = r6.left;
        float r14 = r13 + r9;
        float r16 = r6.top;
        float r17 = r8 + r16;
        if (r14 >= r9) goto L16;
    L30:
        r10.b();
        return;
    L16:
        if (r14 > r6.right) goto L30;
        if (r17 < r16) goto L30;
        if (r17 > r6.bottom) goto L30;
        WindowManager.LayoutParams r18 = new WindowManager.LayoutParams();
        int r19 = g;
        r18.width = r19;
        r18.height = r19;
        r18.gravity = 51;
        r18.format = -2;
        r18.flags = 8;
        int r20 = r10.c;
        r18.x = ((int) r14) - r20;
        int r21 = ((int) r17) - r20;
        if (k.g(r10.a) == false) goto L25;
        r5 = k.e(r10.a);
    L25:
        r18.y = r21 - r5;
        if (r10.d == false) goto L28;
        r10.a.getWindow().getWindowManager().updateViewLayout(r10.e, r18);
    L29:
        r10.d = true;
        return;
    L28:
        WindowManager r110 = r10.a.getWindow().getWindowManager();
        ImageView r22 = r10.e;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r22, r18);
        r110.addView(r22, r18);
    L31:
        StringBuilder r23 = new StringBuilder("anchorView is null ? ");
        if (r12 != null) goto L34;
        boolean r111 = true;
    L35:
        r23.append(r111);
        r23.append(", imageDisplayRect is null ? ");
        if (r3 == null) goto L39;
        r4 = false;
    L39:
        r23.append(r4);
        tt5.a.k("WebFollowCursorManager", r23.toString());
        r10.b();
        return;
    L34:
        r111 = false;
    L40:
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData: data = " + r11);
    }

    public c(Activity r2, com.bytedance.ee.bear.bizwidget.magicshare.cursor.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        ImageView r5 = new ImageView(r2);
        r5.setImageResource(2131238008);
        this.e = r5;
        this.f = new b(this);
    }
}
