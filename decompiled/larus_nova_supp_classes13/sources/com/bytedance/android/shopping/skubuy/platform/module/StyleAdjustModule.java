package com.bytedance.android.shopping.skubuy.platform.module;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.platform.slice.PlatformSliceSDK;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import com.bytedance.android.shopping.anchorv4.helper.a0;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j43.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n33.f;
import nj.d;
import s33.b;
import w33.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class StyleAdjustModule<STATE extends g> extends b<STATE, yh3.a> {
    public boolean b;
    public final String c;
    public final Lazy d;

    public static float B(float r2) {
        if (r2 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r2 <= 1.0f) goto L10;
        return 1.0f;
    L10:
        return r2;
    }

    public final void A() {
        int r0 = h43.a.a;
        Intrinsics.checkNotNullParameter((StyleAdjustModule$orientationListener$2.a) this.d.getValue(), "listener");
        d r1 = h43.a.b();
        if (r1 == null) goto L5;
        r1.e();
    L5:
        l33.b r2 = ((b) this).a;
        if (((yh3.a) r2.c).f.c == false) goto L12;
        int r3 = c.a;
        Object r4 = r2.f.Lw();
        if ((r4 instanceof Fragment) == true) goto L10;
        r4 = null;
    L10:
        c.a(false, (Fragment) r4);
        return;
    }

    public final void C() {
        float r3 = 0.5f;
        Object r4 = null;
        if (((u33.a) ((yh3.a) ((b) this).a.c)).a.getInSplitScreen() == false) goto L23;
        l33.b r0 = ((b) this).a;
        yh3.a r5 = (yh3.a) r0.c;
        if (r5.j == false) goto L16;
        Float r1 = r5.f.b;
        if (r1 == null) goto L9;
        r3 = B(r1.floatValue());
    L9:
        int r2 = ai3.d.a;
        int r6 = ColorUtils.setAlphaComponent(ColorProtector.parseColor("#80000000"), (int) (r3 * 255));
        Object r7 = ((b) this).a.e.g.get(WidgetName.MASK_BACKGROUND.getValue());
        if ((r7 instanceof bi3.g) == false) goto L13;
        r4 = r7;
    L13:
        bi3.g r8 = (bi3.g) r4;
        if (r8 == null) goto L34;
        ((k43.c) r8).a.setBackgroundColor(r6);
        return;
    L34:
        return;
    L16:
        Object r9 = r0.e.g.get(WidgetName.MASK_BACKGROUND.getValue());
        if ((r9 instanceof bi3.g) == false) goto L20;
        r4 = r9;
    L20:
        bi3.g r10 = (bi3.g) r4;
        if (r10 == null) goto L36;
        ((k43.c) r10).a.setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        return;
    L36:
        return;
    L23:
        Float r11 = ((yh3.a) ((b) this).a.c).f.b;
        if (r11 == null) goto L26;
        r3 = B(r11.floatValue());
    L26:
        int r12 = ai3.d.a;
        int r13 = ColorUtils.setAlphaComponent(ColorProtector.parseColor("#80000000"), (int) (r3 * 255));
        Object r14 = ((b) this).a.e.g.get(WidgetName.MASK_BACKGROUND.getValue());
        if ((r14 instanceof bi3.g) == false) goto L30;
        r4 = r14;
    L30:
        bi3.g r15 = (bi3.g) r4;
        if (r15 == null) goto L38;
        r15.f(r13);
        return;
    }

    public final void D() {
        if (this.b == true) goto L26;
        this.b = true;
        Object r1 = ((b) this).a.e.g.get(WidgetName.GLOBAL_LOADING.getValue());
        Object r3 = null;
        if ((r1 instanceof k43.c) == true) goto L7;
        r1 = null;
    L7:
        k43.c r2 = (k43.c) r1;
        if (r2 == null) goto L10;
        r2.e(new y33.a(false));
    L10:
        Object r4 = ((b) this).a.e.g.get(WidgetName.MASK_BACKGROUND.getValue());
        if ((r4 instanceof bi3.g) == true) goto L13;
        r4 = null;
    L13:
        bi3.g r5 = (bi3.g) r4;
        if (r5 == null) goto L20;
        Float r6 = ((yh3.a) ((b) this).a.c).f.b;
        if (r6 == null) goto L18;
        float r7 = B(r6.floatValue());
    L19:
        int r8 = ai3.d.a;
        r5.f(ColorUtils.setAlphaComponent(ColorProtector.parseColor("#80000000"), (int) (r7 * 255)));
        goto L20
    L18:
        r7 = 0.5f;
    L20:
        E();
        int r9 = c.a;
        Object r10 = ((b) this).a.f.Lw();
        if ((r10 instanceof Fragment) == false) goto L24;
        r3 = r10;
    L24:
        c.a(true, (Fragment) r3);
        return;
    }

    public final void E() {
        Object r0 = ((b) this).a.e.g.get(WidgetName.PANEL_CONTAINER.getValue());
        if ((r0 instanceof bi3.a) == true) goto L5;
        r0 = null;
    L5:
        bi3.a r1 = (bi3.a) r0;
        if (r1 == null) goto L9;
        r1.e(new y33.a(true));
        TranslateAnimation r2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r2.setDuration(390);
        r2.setInterpolator(new a0());
        ((k43.c) r1).a.startAnimation(r2);
        return;
    }

    public final com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a k() {
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(!this.b);
    }

    public final void y() {
        if (((u33.a) ((yh3.a) ((b) this).a.c)).a.getInSplitScreen() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Object r3 = null;
        if (r0 == false) goto L16;
        Object r1 = ((b) this).a.e.g.get(WidgetName.CONTENT.getValue());
        if ((r1 instanceof bi3.b) == true) goto L13;
        r1 = null;
    L13:
        bi3.b r2 = (bi3.b) r1;
        if (r2 == null) goto L22;
        ConstraintLayout r5 = ((b) this).a.f.getRootView();
        Intrinsics.checkNotNullParameter(r5, "rootView");
        int r4 = PlatformSliceSDK.a;
        float r6 = PlatformSliceSDK.a(com.bytedance.android.shopping.skubuy.platform.helper.b.b(true)).a;
        Resources r7 = Resources.getSystem();
        float r8 = r6 / WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density;
        View r9 = ((k43.c) r2).a;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        int r11 = com.bytedance.android.shopping.buynow.utils.g.a;
        r10.height = (int) ((((com.bytedance.android.shopping.buynow.utils.g.a(r5.getContext()).b - k1.q()) - k1.g()) - com.bytedance.android.shopping.extensions.b.b(26)) - (com.bytedance.android.shopping.extensions.b.b(21) * r8));
        Unit r12 = Unit.INSTANCE;
        r9.setLayoutParams(r10);
    L22:
        ConcurrentHashMap r13 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("legou_sku_buy_layout_opt"), 1) == false) goto L35;
        Object r14 = ((b) this).a.e.g.get(WidgetName.CONTENT.getValue());
        if ((r14 instanceof bi3.b) == true) goto L27;
        r14 = null;
    L27:
        bi3.b r15 = (bi3.b) r14;
        if (r15 == null) goto L35;
        Drawable r16 = ((k43.c) r15).a.getBackground();
        if ((r16 instanceof BackgroundDrawable) == true) goto L32;
        r16 = null;
    L32:
        BackgroundDrawable r17 = (BackgroundDrawable) r16;
        if (r17 == null) goto L35;
        r17.setBgColor(ContextCompat.getColor(((k43.c) r15).a.getContext(), 2131101837));
        r17.invalidate();
    L35:
        int r18 = h43.a.a;
        Intrinsics.checkNotNullParameter((StyleAdjustModule$orientationListener$2.a) this.d.getValue(), "listener");
        d r19 = h43.a.b();
        if (r19 == null) goto L38;
        r19.b();
    L38:
        yh3.a r20 = (yh3.a) ((b) this).a.c;
        if (r20.f.c == false) goto L62;
        Lazy r21 = SkuBuyResponseCacheHelper.a;
        ISchemaModel r22 = ((u33.a) r20).a.getSchemaModel();
        Intrinsics.checkNotNullParameter(r22, "schemaModel");
        if (SkuBuyResponseCacheHelper.b(SkuBuyResponseCacheHelper.a(r22)) != null) goto L56;
        Object r23 = ((b) this).a.e.g.get(WidgetName.PANEL_CONTAINER.getValue());
        if ((r23 instanceof bi3.a) == true) goto L45;
        r23 = null;
    L45:
        bi3.a r24 = (bi3.a) r23;
        if (r24 == null) goto L48;
        ((k43.c) r24).a.setVisibility(4);
    L48:
        this.b = false;
        Object r25 = ((b) this).a.e.g.get(WidgetName.GLOBAL_LOADING.getValue());
        if ((r25 instanceof k43.c) == false) goto L52;
        r3 = r25;
    L52:
        k43.c r26 = (k43.c) r3;
        if (r26 == null) goto L55;
        r26.e(new y33.a(true));
    L55:
        ((b) this).a.d.e().a(1500, new StyleAdjustModule$hidePanelAndShowLoading$1(this));
        return;
    L56:
        C();
        E();
        int r27 = c.a;
        Object r28 = ((b) this).a.f.Lw();
        if ((r28 instanceof Fragment) == false) goto L60;
        r3 = r28;
    L60:
        c.a(true, (Fragment) r3);
        return;
    L62:
        if (((u33.a) r20).a.getInSplitScreen() == false) goto L64;
        C();
        return;
    L64:
        C();
        E();
        return;
    L16:
        float r29 = B(((yh3.a) ((b) this).a.c).f.a);
        Object r30 = ((b) this).a.e.g.get(WidgetName.CONTENT.getValue());
        if ((r30 instanceof bi3.b) == true) goto L19;
        r30 = null;
    L19:
        bi3.b r31 = (bi3.b) r30;
        if (r31 == null) goto L22;
        ConstraintLayout r32 = ((b) this).a.f.getRootView();
        Intrinsics.checkNotNullParameter(r32, "rootView");
        int r33 = com.bytedance.android.shopping.buynow.utils.g.a;
        int r34 = (int) (com.bytedance.android.shopping.buynow.utils.g.a(r32.getContext()).b * r29);
        View r35 = ((k43.c) r31).a;
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
        r36.height = r34;
        Unit r37 = Unit.INSTANCE;
        r35.setLayoutParams(r36);
        goto L22
    L5:
        if (((yh3.a) ((b) this).a.c).j == true) goto L7;
        r0 = true;
        goto L8
    }

    public final String j() {
        return this.c;
    }

    public StyleAdjustModule(final l33.b<STATE, yh3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = true;
        this.c = "ContainerAdjustModule";
        this.d = LazyKt.lazy(new StyleAdjustModule$orientationListener$2(this, r2));
    }

    public final void e(n33.c r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        if (((yh3.a) ((b) this).a.c).f.c == false) goto L6;
        D();
        return;
    }

    public final void f(f r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        if (((yh3.a) ((b) this).a.c).f.c == false) goto L6;
        D();
        return;
    }
}
