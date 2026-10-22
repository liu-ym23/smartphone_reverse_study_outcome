package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import android.app.Activity;
import android.graphics.RectF;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f216503g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f216504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bizwidget.magicshare.cursor.a f216505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f216507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f216508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f216509f;

    public static final class a {
    }

    public static final class b implements WebFollowCursorDispatcher.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f216510a;

        public b(c r100) {
            this.f216510a = r100;
        }

        @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.WebFollowCursorDispatcher.a
        public final void a(CursorPosData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            c.a(this.f216510a, r100);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.f("WebFollowCursorManager", e, false);
        }
    }

    static {
        f216503g = n.d(20);
    }

    public final void b() {
        if (this.f216507d == false) goto L5;
        this.f216504a.getWindow().getWindowManager().removeView(this.f216508e);
    L5:
        this.f216507d = false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void hide() {
        ArrayList<WebFollowCursorDispatcher.a> r100 = WebFollowCursorDispatcher.f216493a;
        b r101 = this.f216509f;
        Intrinsics.checkNotNullParameter(r101, "listener");
        WebFollowCursorDispatcher.f216493a.remove(r101);
        b();
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void show() {
        ArrayList<WebFollowCursorDispatcher.a> r100 = WebFollowCursorDispatcher.f216493a;
        WebFollowCursorDispatcher.a(this.f216509f);
    }

    public final Activity getActivity() {
        return this.f216504a;
    }

    public static final void a(c r110, CursorPosData r111) {
        r110.getClass();
        if (r111.getClose() == false) goto L5;
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData, data.close is true");
        r110.b();
        return;
    L5:
        Float r100 = r111.getX();
        Float r101 = r111.getY();
        if (r100 == null) goto L40;
        if (r101 == null) goto L40;
        View r112 = r110.f216505b.o0();
        RectF r102 = r110.f216505b.p0();
        boolean r103 = true;
        int r104 = 0;
        if (r112 == null) goto L31;
        if (r102 == null) goto L31;
        int[] r105 = new int[2];
        r112.getLocationInWindow(r105);
        float r106 = r105[0];
        RectF r107 = new RectF(r106, r105[1], r112.getMeasuredWidth() + r106, r105[1] + r112.getMeasuredHeight());
        float r113 = r102.left + (r102.width() * r100.floatValue());
        float r108 = r102.top + (r102.height() * r101.floatValue());
        float r109 = r107.left;
        float r114 = r113 + r109;
        float r115 = r107.top;
        float r116 = r108 + r115;
        if (r114 >= r109) goto L16;
    L30:
        r110.b();
        return;
    L16:
        if (r114 > r107.right) goto L30;
        if (r116 < r115) goto L30;
        if (r116 > r107.bottom) goto L30;
        WindowManager.LayoutParams r117 = new WindowManager.LayoutParams();
        int r118 = f216503g;
        r117.width = r118;
        r117.height = r118;
        r117.gravity = 51;
        r117.format = -2;
        r117.flags = 8;
        int r119 = r110.f216506c;
        r117.x = ((int) r114) - r119;
        int r120 = ((int) r116) - r119;
        if (k.g(r110.f216504a) == false) goto L25;
        r104 = k.e(r110.f216504a);
    L25:
        r117.y = r120 - r104;
        if (r110.f216507d == false) goto L28;
        r110.f216504a.getWindow().getWindowManager().updateViewLayout(r110.f216508e, r117);
    L29:
        r110.f216507d = true;
        return;
    L28:
        WindowManager r121 = r110.f216504a.getWindow().getWindowManager();
        ImageView r122 = r110.f216508e;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r122, r117);
        r121.addView(r122, r117);
    L31:
        StringBuilder r123 = new StringBuilder("anchorView is null ? ");
        if (r112 != null) goto L34;
        boolean r124 = true;
    L35:
        r123.append(r124);
        r123.append(", imageDisplayRect is null ? ");
        if (r102 == null) goto L39;
        r103 = false;
    L39:
        r123.append(r103);
        tt5.a.k("WebFollowCursorManager", r123.toString());
        r110.b();
        return;
    L34:
        r124 = false;
    L40:
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData: data = " + r111);
    }

    public c(Activity r100, com.bytedance.ee.bear.bizwidget.magicshare.cursor.a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f216504a = r100;
        this.f216505b = r101;
        this.f216506c = r102;
        ImageView r103 = new ImageView(r100);
        r103.setImageResource(R.drawable.icon_ms_cursor_colorful);
        this.f216508e = r103;
        this.f216509f = new b(this);
    }
}
