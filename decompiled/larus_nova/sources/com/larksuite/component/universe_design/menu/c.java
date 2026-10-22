package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f285075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PositionAlign f285076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f285077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f285078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f285079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC3918c f285080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f285081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<PopupWindow> f285082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<View> f285083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<View> f285084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f285085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f285086l;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.menu.c$c, reason: collision with other inner class name */
    public interface InterfaceC3918c {
        void a(PopupWindow r100);
    }

    public static abstract class d<T extends d<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PositionAlign f285087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f285088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f285089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f285090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public InterfaceC3918c f285091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f285092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f285093g;

        public d() {
        }

        public final c a() {
            c r100 = new c();
            g r101 = this.f285089c;
            if (r101 == null) goto L5;
            Intrinsics.checkNotNullParameter(r101, "viewCreator");
            r100.f285075a = r101;
        L5:
            PositionAlign r102 = this.f285087a;
            if (r102 == null) goto L8;
            Intrinsics.checkNotNullParameter(r102, "align");
            r100.f285076b = r102;
        L8:
            Integer r103 = this.f285088b;
            if (r103 == null) goto L11;
            r100.f285077c = r103.intValue();
        L11:
            Boolean r104 = this.f285090d;
            if (r104 == null) goto L14;
            r100.f285079e = r104.booleanValue();
        L14:
            InterfaceC3918c r105 = this.f285091e;
            if (r105 == null) goto L17;
            Intrinsics.checkNotNullParameter(r105, "listener");
            r100.f285080f = r105;
        L17:
            b r106 = this.f285092f;
            if (r106 == null) goto L20;
            Intrinsics.checkNotNullParameter(r106, "listener");
            r100.f285081g = r106;
        L20:
            r100.f285085k = this.f285093g;
            return r100;
        }

        public final void e() {
            this.f285090d = Boolean.TRUE;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void b(PositionAlign r100) {
            Intrinsics.checkNotNullParameter(r100, "align");
            this.f285087a = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void c(int r100) {
            this.f285088b = Integer.valueOf(r100);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void d(b r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f285092f = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }
    }

    public static final class e extends d<e> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public UDDimension f285094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public UDDimension f285095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public UDDimension f285096j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public UDDimension f285097k;

        public e() {
            this.f285094h = new UDDimension.Dp(16.0f);
            this.f285095i = new UDDimension.Dp(16.0f);
            this.f285096j = new UDDimension.Dp(16.0f);
            this.f285097k = new UDDimension.Dp(16.0f);
        }

        public final void f(View r100) {
            Intrinsics.checkNotNullParameter(r100, "customView");
            this.f285089c = new com.larksuite.component.universe_design.menu.d(r100, this);
        }

        public final void g(UDDimension.Dp r100, UDDimension.Dp r101, UDDimension.Dp r102, UDDimension.Dp r103) {
            Intrinsics.checkNotNullParameter(r100, "leftPadding");
            Intrinsics.checkNotNullParameter(r101, "topPadding");
            Intrinsics.checkNotNullParameter(r102, "rightPadding");
            Intrinsics.checkNotNullParameter(r103, "bottomPadding");
            this.f285094h = r100;
            this.f285095i = r101;
            this.f285096j = r102;
            this.f285097k = r103;
        }
    }

    public static final class f extends d<f> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<Integer> f285098h;

        public f() {
            this.f285093g = true;
            this.f285098h = new ArrayList();
        }

        public final void f(List r100) {
            Intrinsics.checkNotNullParameter(r100, "menuItems");
            this.f285089c = new com.larksuite.component.universe_design.menu.e(r100, this);
        }
    }

    public interface g {
        ViewGroup create(Context r100);
    }

    public static final class h implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f285099a;

        public h(c r100) {
            this.f285099a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110) {
            c r108 = this.f285099a;
            WeakReference<View> r109 = r108.f285084j;
            if (r109 == null) goto L37;
            View r111 = r109.get();
            if (r111 == null) goto L42;
            WeakReference<View> r112 = r108.f285083i;
            if (r112 == null) goto L38;
            View r113 = r112.get();
            if (r113 == null) goto L43;
            WeakReference<PopupWindow> r114 = r108.f285082h;
            if (r114 == null) goto L39;
            PopupWindow r115 = r114.get();
            if (r115 != null) goto L17;
            return;
        L17:
            if (r115.isShowing() == false) goto L44;
            RectF r116 = com.larksuite.component.universe_design.menu.a.a(new com.larksuite.component.universe_design.menu.b(r111, r113, r108.f285077c, r108.f285076b, h18.d.a(r113.getContext(), r108.f285078d)));
            if (r116 == null) goto L45;
            int r117 = (int) r116.left;
            Context r118 = r113.getContext();
            int r119 = 0;
            if (r108.f285085k == false) goto L25;
            int r120 = -((int) new UDDimension.Dp(16).toPixels(r118));
        L26:
            int r121 = r117 + r120;
            int r122 = (int) r116.top;
            Context r123 = r113.getContext();
            if (r108.f285085k == false) goto L29;
            r119 = -((int) new UDDimension.Dp(10).toPixels(r123));
        L29:
            int r124 = r122 + r119;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r115) == false) goto L33;
            r115.update(r121, r124, -1, -1);
            return;
        L33:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r115, r121, r124, -1, -1) == true) goto L46;
            r115.update(r121, r124, -1, -1);
            return;
        L46:
            return;
        L25:
            r120 = 0;
            goto L26
        L45:
            return;
        L44:
            return;
        L39:
            return;
        L43:
            return;
        L38:
            return;
        L42:
            return;
        }
    }

    public static final class i implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f285100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f285101b;

        public i(c r100, j r101) {
            this.f285100a = r100;
            this.f285101b = r101;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            b r100 = this.f285100a.f285081g;
            if (r100 == null) goto L5;
            r100.onDismiss();
        L5:
            this.f285101b.run();
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f285102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f285103b;

        public j(c r100, View r101) {
            this.f285102a = r100;
            this.f285103b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f285102a;     // Catch: Throwable -> L4
            this.f285103b.removeOnLayoutChangeListener(r100.f285086l);     // Catch: Throwable -> L4
            c r101 = this.f285102a;     // Catch: Throwable -> L4
            r101.f285082h = null;     // Catch: Throwable -> L4
            r101.f285084j = null;     // Catch: Throwable -> L4
            r101.f285083i = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        WeakReference<PopupWindow> r100 = this.f285082h;
        if (r100 == null) goto L13;
        PopupWindow r101 = r100.get();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isShowing() == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    L15:
        return;
    }

    public c() {
        this.f285076b = PositionAlign.CENTER;
        this.f285077c = 80;
        this.f285078d = 4.0f;
        this.f285079e = true;
        this.f285086l = new h(this);
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        c(r100);
    }

    public final boolean c(View r110) {
        WeakReference<PopupWindow> r100 = this.f285082h;
        if (r100 == null) goto L13;
        PopupWindow r101 = r100.get();
        if (r101 == null) goto L13;
        if (r101.isShowing() == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L13;
        return false;
    L13:
        if (r110.isAttachedToWindow() == true) goto L15;
        r110.addOnAttachStateChangeListener(new com.larksuite.component.universe_design.menu.f(this, r110));
    L15:
        g r102 = this.f285075a;
        if (r102 == null) goto L53;
        ViewGroup r103 = r102.create(r110.getContext());
        if (r103 == null) goto L53;
        RectF r104 = com.larksuite.component.universe_design.menu.a.a(new com.larksuite.component.universe_design.menu.b(r103, r110, this.f285077c, this.f285076b, h18.d.a(r110.getContext(), this.f285078d)));
        if (r104 != null) goto L22;
        return false;
    L22:
        int r105 = (int) r104.left;
        Context r106 = r110.getContext();
        if (this.f285085k == false) goto L25;
        int r107 = -((int) new UDDimension.Dp(16).toPixels(r106));
    L26:
        int r108 = r105 + r107;
        int r109 = (int) r104.top;
        Context r111 = r110.getContext();
        if (this.f285085k == false) goto L29;
        int r112 = -((int) new UDDimension.Dp(10).toPixels(r111));
    L30:
        int r113 = r109 + r112;
        if (this.f285085k == false) goto L33;
        Context r114 = r103.getContext();
        Intrinsics.checkNotNull(r114);
        UDShadowLayout r115 = new UDShadowLayout(r114);
        r115.c(R.style.UDShadow_S4_Down);
        r115.addView(r103, -1, -1);
        View r116 = r115;
    L34:
        PopupWindow r117 = new PopupWindow(r116, -2, -2);
        r117.setOutsideTouchable(this.f285079e);
        r117.setFocusable(true);
        if (PopupWindowLancet.hasSubWindowToken(r110) == false) goto L38;
    L44:
        j r118 = new j(this, r110);
        if (r117.isShowing() == false) goto L50;
        this.f285082h = new WeakReference(r117);
        this.f285084j = new WeakReference(r103);
        this.f285083i = new WeakReference(r110);
        InterfaceC3918c r119 = this.f285080f;
        if (r119 == null) goto L49;
        r119.a(r117);
    L49:
        r117.setOnDismissListener(new i(this, r118));
        return true;
    L50:
        r118.run();
        return false;
    L38:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r117) == false) goto L40;
        r117.showAtLocation(r110, 8388659, r108, r113);
        goto L44
    L40:
        OverlaySource r120 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r117, r110, r120, 8388659, r108, r113) == true) goto L44;
        r117.showAtLocation(r110, 8388659, r108, r113);
        PopupWindowLancet.trackAfterShow(r117, r120, r110);
        goto L44
    L33:
        r116 = r103;
        goto L34
    L29:
        r112 = 0;
        goto L30
    L25:
        r107 = 0;
    L53:
        throw new IllegalArgumentException("viewCreator is null, please set UDMenuViewCreator first.");
    }
}
