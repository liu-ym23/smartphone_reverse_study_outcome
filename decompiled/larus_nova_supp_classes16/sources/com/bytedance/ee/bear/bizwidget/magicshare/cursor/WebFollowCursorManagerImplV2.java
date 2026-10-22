package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import android.app.Activity;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import com.bytedance.ee.util.ui.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WebFollowCursorManagerImplV2 implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.b {
    public static final int g = 0;
    public final Activity a;
    public final com.bytedance.ee.bear.bizwidget.magicshare.cursor.a b;
    public final int c;
    public WeakReference<View> d;
    public final Lazy e;
    public final b f;

    public static final class a {
    }

    public static final class b implements WebFollowCursorDispatcher.a {
        public final /* synthetic */ WebFollowCursorManagerImplV2 a;

        public b(WebFollowCursorManagerImplV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.WebFollowCursorDispatcher.a
        public final void a(CursorPosData r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            WebFollowCursorManagerImplV2.a(this.a, r3);     // Catch: Exception -> L5
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
        Drawable r0 = (Drawable) this.e.getValue();     // Catch: Exception -> L12
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.d.get();     // Catch: Exception -> L12
        if (r1 == null) goto L10;
        ViewOverlay r2 = r1.getOverlay();     // Catch: Exception -> L12
        if (r2 == null) goto L10;
        r2.remove(r0);     // Catch: Exception -> L12
    L10:
        this.d = new WeakReference(null);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.f("WebFollowCursorManager", e, false);
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

    public static final void a(WebFollowCursorManagerImplV2 r7, CursorPosData r8) {
        r7.getClass();
        if (r8.getClose() == false) goto L5;
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData, data.close is true");
        r7.b();
        return;
    L5:
        Float r0 = r8.getX();
        Float r2 = r8.getY();
        if (r0 == null) goto L38;
        if (r2 == null) goto L38;
        View r9 = r7.b.o0();
        RectF r3 = r7.b.p0();
        boolean r4 = false;
        if (r9 == null) goto L30;
        if (r3 == null) goto L30;
        float r5 = r3.left + (r3.width() * r0.floatValue());
        float r1 = r3.top + (r3.height() * r2.floatValue());
        if (r5 >= 0.0f) goto L16;
    L29:
        r7.b();
        return;
    L16:
        if (r5 > r9.getMeasuredWidth()) goto L29;
        if (r1 < 0.0f) goto L29;
        if (r1 > r9.getMeasuredHeight()) goto L29;
        r7.b();     // Catch: Exception -> L27
        Drawable r6 = (Drawable) r7.e.getValue();     // Catch: Exception -> L27
        if (r6 != null) goto L25;
        tt5.a.h("WebFollowCursorManager", "updateCursorView: cursorDrawable is null");     // Catch: Exception -> L27
    L40:
        return;
    L25:
        float r10 = r7.c;     // Catch: Exception -> L27
        int r11 = (int) (r5 - r10);     // Catch: Exception -> L27
        int r12 = (int) (r1 - r10);     // Catch: Exception -> L27
        int r13 = g;     // Catch: Exception -> L27
        r6.setBounds(r11, r12, r11 + r13, r13 + r12);     // Catch: Exception -> L27
        r9.getOverlay().add(r6);     // Catch: Exception -> L27
        r7.d = new WeakReference(r9);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        tt5.a.f("WebFollowCursorManager", e, false);
        return;
    L30:
        StringBuilder r14 = new StringBuilder("anchorView is null ? ");
        if (r9 != null) goto L33;
        boolean r16 = true;
    L34:
        r14.append(r16);
        r14.append(", imageDisplayRect is null ? ");
        if (r3 != null) goto L37;
        r4 = true;
    L37:
        r14.append(r4);
        tt5.a.k("WebFollowCursorManager", r14.toString());
        r7.b();
        return;
    L33:
        r16 = false;
    L38:
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData: data = " + r8);
    }

    public WebFollowCursorManagerImplV2(Activity r2, com.bytedance.ee.bear.bizwidget.magicshare.cursor.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new WeakReference(null);
        this.e = LazyKt.lazy(new WebFollowCursorManagerImplV2$cursorDrawable$2(this));
        this.f = new b(this);
    }
}
