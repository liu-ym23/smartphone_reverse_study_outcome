package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.s;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.u;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends FrameLayout {
    public Map<Integer, View> a;
    public final Lazy b;
    public u c;
    public final SlcTemplateContext d;
    public final Function0<Set<Pair<String, String>>> e;
    public final b0 f;

    public o() {
        throw null;
    }

    private final CartViewModel getCartViewModel() {
        return (CartViewModel) this.b.getValue();
    }

    public final b0 getActions() {
        return this.f;
    }

    public final u getCurrentTabItem() {
        return this.c;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.d;
    }

    public final Function0<Set<Pair<String, String>>> getTabTipShowedGetter() {
        return this.e;
    }

    public static final /* synthetic */ CartViewModel b(o r0) {
        return r0.getCartViewModel();
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setCurrentTabItem(u r1) {
        this.c = r1;
    }

    public final void c(u r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "tabColor");
        this.c = r9;
        ((TextView) a(2131388056)).setText(r9.e());
        ((TextView) a(2131368004)).setText(String.valueOf(r9.b()));
        if (r9.b() > 0) goto L5;
        a(2131368004).setVisibility(8);
    L6:
        Context r0 = getContext();
        GradientDrawable r1 = new GradientDrawable();
        boolean r5 = true;
        LayerDrawable r4 = new LayerDrawable(new GradientDrawable[]{r1});
        if (Build.VERSION.SDK_INT < 23) goto L64;
        r4.setLayerGravity(0, 17);
    L64:
        r1.setCornerRadius(r0.getResources().getDimensionPixelSize(2131166382));     // Catch: Exception -> L11
        r1.setColor(Color.parseColor(r10));     // Catch: Exception -> L11
    L13:
        a(2131388019).setBackground(r4);
        a(2131388019).setVisibility(8);
        ((TextView) a(2131388021)).setBackground(r4);
        a(2131388021).setVisibility(8);
        a(2131388020).setVisibility(8);
        com.bytedance.android.shopping.new_cart.slice.viewmanagers.a r2 = r9.a();
        if (r2 == null) goto L38;
        int r6 = r2.c();
        if (r6 != 1) goto L18;
        a(2131388019).setVisibility(0);
        goto L38
    L18:
        if (r6 != 2) goto L20;
    L34:
        String r11 = r2.b();
        if (r11 == null) goto L38;
        ((TextView) a(2131388021)).setText(r11);
        a(2131388021).setVisibility(0);
        goto L38
    L20:
        if (r6 == 3) goto L34;
        if (r6 != 4) goto L38;
        s r12 = r2.a();
        s r3 = r2.a();
        if (r3 == null) goto L27;
        String r7 = r3.b();
    L28:
        if (r12 == null) goto L38;
        if (r7 == null) goto L38;
        a(2131388020).setImageURI(r7);
        wg.a.d(a(2131388020), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r12.a())));
        View r8 = a(2131388020);
        int r13 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r12.c()));
        Intrinsics.checkNotNullParameter(r8, "$this$setWidth");
        ViewGroup.LayoutParams r14 = r8.getLayoutParams();
        if (r14 == null) goto L33;
        r14.width = r13;
    L33:
        r8.setLayoutParams(r14);
        a(2131388020).setVisibility(0);
        goto L38
    L27:
        r7 = null;
    L38:
        String r15 = r9.c();
        if (r15 != null) goto L41;
    L44:
        if (r5 == false) goto L47;
        return;
    L47:
        if (((Set) this.e.invoke()).contains(new Pair(r9.d(), r9.c())) == true) goto L70;
        ((Set) this.e.invoke()).add(new Pair(r9.d(), r9.c()));
        ECSettingKeys.j.getClass();
        int r16 = p.a;
        int r17 = com.bytedance.android.ec.core.abtest.e.a;
        Object r18 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L54
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L54
        Object r110 = jj4.a.a("yata_cart_tab_tip_enable", Boolean.class, r18, false);     // Catch: Throwable -> L54
        if (r110 != null) goto L61;
        Intrinsics.throwNpe();     // Catch: Throwable -> L54
    L61:
        if (((Boolean) r110).booleanValue() == false) goto L68;
        post(new n(this, r9));
        return;
    L68:
        return;
    L54:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Object r111 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r111) == true) goto L59;
        r18 = r111;
    L59:
        r110 = r18;
        goto L61
    L70:
        return;
    L41:
        if (r15.length() == 0) goto L44;
        r5 = false;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    L5:
        ((TextView) a(2131368004)).setVisibility(0);
        goto L6
    }

    public final void d(boolean r8, BaseSlcViewManager r9) {
        if (r8 == true) goto L5;
        ((TextView) a(2131388056)).setTextColor(ContextCompat.getColor(getContext(), 2131101518));
        CartViewExtentionsKt.e((TextView) a(2131388056), 400);
        CartViewExtentionsKt.e((TextView) a(2131368004), 400);
        ((TextView) a(2131368004)).setTextColor(ContextCompat.getColor(getContext(), 2131101518));
        return;
    L5:
        b0 r10 = this.f;
        if (r10 == null) goto L14;
        Function1<String, Unit> r11 = r10.c;
        if (r11 == null) goto L14;
        u r2 = this.c;
        if (r2 == null) goto L12;
        String r3 = r2.d();
    L13:
        Unit r12 = (Unit) r11.invoke(r3);
        goto L14
    L12:
        r3 = null;
    L14:
        CartViewExtentionsKt.e((TextView) a(2131388056), 500);
        CartViewExtentionsKt.e((TextView) a(2131368004), 500);
        ((TextView) a(2131388056)).setTextColor(ContextCompat.getColor(getContext(), 2131101519));
        ((TextView) a(2131368004)).setTextColor(ContextCompat.getColor(getContext(), 2131101519));
        if (r9 == null) goto L24;
        HashMap r13 = new HashMap();
        u r0 = this.c;
        if (r0 == null) goto L20;
        String r1 = r0.d();
        if (r1 == null) goto L20;
    L21:
        r13.put("tab_type", r1);
        Unit r4 = Unit.INSTANCE;
        SlcCommonAction r5 = new SlcCommonAction("changeTab", r13);
        r9.a.d(r5, this, r9.l(), null, null);
        return;
    L20:
        r1 = "";
        goto L21
    }

    public o(Context r3, SlcTemplateContext r4, Function0 r5, b0 r6, final CartObjectContainer r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        Intrinsics.checkNotNullParameter(r5, "tabTipShowedGetter");
        super(r3, null, 0);
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = new LinkedHashMap();
        LayoutInflater.from(r3).inflate(2131559264, this, true);
        ((TextView) a(2131388056)).setTextSize(0, SlcDimensExtensionsKt.e(16, r4.m()));
        ((TextView) a(2131368004)).setTextSize(0, SlcDimensExtensionsKt.e(16, r4.m()));
        ((TextView) a(2131388021)).setTextSize(0, SlcDimensExtensionsKt.e(10, r4.m()));
        this.b = LazyKt.lazy(new SingleTabView$cartViewModel$2(r7));
    }
}
