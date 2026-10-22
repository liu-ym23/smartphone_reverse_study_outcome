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

/* JADX INFO: loaded from: classes16.dex */
public final class WebFollowCursorManagerImplV2 implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f216495g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f216496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bizwidget.magicshare.cursor.a f216497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f216499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f216500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f216501f;

    public static final class a {
    }

    public static final class b implements WebFollowCursorDispatcher.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFollowCursorManagerImplV2 f216502a;

        public b(WebFollowCursorManagerImplV2 r100) {
            this.f216502a = r100;
        }

        @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.WebFollowCursorDispatcher.a
        public final void a(CursorPosData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            WebFollowCursorManagerImplV2.a(this.f216502a, r100);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.f("WebFollowCursorManager", e, false);
        }
    }

    static {
        f216495g = n.d(20);
    }

    public final void b() {
        Drawable r100 = (Drawable) this.f216500e.getValue();     // Catch: Exception -> L12
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = this.f216499d.get();     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        ViewOverlay r102 = r101.getOverlay();     // Catch: Exception -> L12
        if (r102 == null) goto L10;
        r102.remove(r100);     // Catch: Exception -> L12
    L10:
        this.f216499d = new WeakReference(null);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.f("WebFollowCursorManager", e, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void hide() {
        ArrayList<WebFollowCursorDispatcher.a> r100 = WebFollowCursorDispatcher.f216493a;
        b r101 = this.f216501f;
        Intrinsics.checkNotNullParameter(r101, "listener");
        WebFollowCursorDispatcher.f216493a.remove(r101);
        b();
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.b
    public final void show() {
        ArrayList<WebFollowCursorDispatcher.a> r100 = WebFollowCursorDispatcher.f216493a;
        WebFollowCursorDispatcher.a(this.f216501f);
    }

    public final Activity getActivity() {
        return this.f216496a;
    }

    public static final void a(WebFollowCursorManagerImplV2 r100, CursorPosData r101) {
        r100.getClass();
        if (r101.getClose() == false) goto L5;
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData, data.close is true");
        r100.b();
        return;
    L5:
        Float r102 = r101.getX();
        Float r103 = r101.getY();
        if (r102 == null) goto L38;
        if (r103 == null) goto L38;
        View r104 = r100.f216497b.o0();
        RectF r105 = r100.f216497b.p0();
        boolean r106 = false;
        if (r104 == null) goto L30;
        if (r105 == null) goto L30;
        float r107 = r105.left + (r105.width() * r102.floatValue());
        float r108 = r105.top + (r105.height() * r103.floatValue());
        if (r107 >= 0.0f) goto L16;
    L29:
        r100.b();
        return;
    L16:
        if (r107 > r104.getMeasuredWidth()) goto L29;
        if (r108 < 0.0f) goto L29;
        if (r108 > r104.getMeasuredHeight()) goto L29;
        r100.b();     // Catch: Exception -> L27
        Drawable r109 = (Drawable) r100.f216500e.getValue();     // Catch: Exception -> L27
        if (r109 != null) goto L25;
        tt5.a.h("WebFollowCursorManager", "updateCursorView: cursorDrawable is null");     // Catch: Exception -> L27
    L40:
        return;
    L25:
        float r110 = r100.f216498c;     // Catch: Exception -> L27
        int r111 = (int) (r107 - r110);     // Catch: Exception -> L27
        int r112 = (int) (r108 - r110);     // Catch: Exception -> L27
        int r113 = f216495g;     // Catch: Exception -> L27
        r109.setBounds(r111, r112, r111 + r113, r113 + r112);     // Catch: Exception -> L27
        r104.getOverlay().add(r109);     // Catch: Exception -> L27
        r100.f216499d = new WeakReference(r104);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        tt5.a.f("WebFollowCursorManager", e, false);
        return;
    L30:
        StringBuilder r114 = new StringBuilder("anchorView is null ? ");
        if (r104 != null) goto L33;
        boolean r115 = true;
    L34:
        r114.append(r115);
        r114.append(", imageDisplayRect is null ? ");
        if (r105 != null) goto L37;
        r106 = true;
    L37:
        r114.append(r106);
        tt5.a.k("WebFollowCursorManager", r114.toString());
        r100.b();
        return;
    L33:
        r115 = false;
    L38:
        tt5.a.h("WebFollowCursorManager", "applyCursorPosData: data = " + r101);
    }

    public WebFollowCursorManagerImplV2(Activity r100, com.bytedance.ee.bear.bizwidget.magicshare.cursor.a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f216496a = r100;
        this.f216497b = r101;
        this.f216498c = r102;
        this.f216499d = new WeakReference(null);
        this.f216500e = LazyKt.lazy(new WebFollowCursorManagerImplV2$cursorDrawable$2(this));
        this.f216501f = new b(this);
    }
}
