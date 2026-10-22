package com.bytedance.android.shopping.card_list.slice.widgets;

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
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends FrameLayout {
    public Map<Integer, View> a;
    public com.bytedance.android.shopping.card_list.slice.viewmanagers.i b;
    public final Lazy c;
    public final Lazy d;
    public final SlcTemplateContext e;
    public final Function0<Set<Pair<String, String>>> f;
    public final s g;
    public final CardListObjectContainer h;

    public m() {
        throw null;
    }

    private final String getMonitorId() {
        return (String) this.d.getValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.c.getValue();
    }

    public final s getActions() {
        return this.g;
    }

    public final com.bytedance.android.shopping.card_list.slice.viewmanagers.i getCurrentTabItem() {
        return this.b;
    }

    public final CardListObjectContainer getObjectContainer() {
        return this.h;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.e;
    }

    public final Function0<Set<Pair<String, String>>> getTabTipShowedGetter() {
        return this.f;
    }

    public static final /* synthetic */ String b(m r0) {
        return r0.getMonitorId();
    }

    public static final /* synthetic */ CardListTrackerComponent c(m r0) {
        return r0.getTrackerComponent();
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

    public final void setCurrentTabItem(com.bytedance.android.shopping.card_list.slice.viewmanagers.i r1) {
        this.b = r1;
    }

    public final void d(final com.bytedance.android.shopping.card_list.slice.viewmanagers.i r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "tabColor");
        this.b = r9;
        ((TextView) a(2131388056)).setText(r9.e());
        ((TextView) a(2131368004)).setText(String.valueOf(r9.b()));
        boolean r3 = false;
        if (r9.b() > 0) goto L5;
        a(2131368004).setVisibility(8);
    L6:
        Context r0 = getContext();
        GradientDrawable r1 = new GradientDrawable();
        LayerDrawable r4 = new LayerDrawable(new GradientDrawable[]{r1});
        if (Build.VERSION.SDK_INT < 23) goto L50;
        r4.setLayerGravity(0, 17);
    L50:
        r1.setCornerRadius(r0.getResources().getDimensionPixelSize(2131165482));     // Catch: Exception -> L11
        r1.setColor(Color.parseColor(r10));     // Catch: Exception -> L11
    L13:
        a(2131388019).setBackground(r4);
        a(2131388019).setVisibility(8);
        ((TextView) a(2131388021)).setBackground(r4);
        a(2131388021).setVisibility(8);
        a(2131388020).setVisibility(8);
        com.bytedance.android.shopping.card_list.slice.viewmanagers.a r2 = r9.a();
        if (r2 == null) goto L38;
        int r5 = r2.c();
        if (r5 != 1) goto L18;
        a(2131388019).setVisibility(0);
        goto L38
    L18:
        if (r5 != 2) goto L20;
    L34:
        String r11 = r2.b();
        if (r11 == null) goto L38;
        ((TextView) a(2131388021)).setText(r11);
        a(2131388021).setVisibility(0);
        goto L38
    L20:
        if (r5 == 3) goto L34;
        if (r5 != 4) goto L38;
        com.bytedance.android.shopping.card_list.slice.viewmanagers.g r12 = r2.a();
        com.bytedance.android.shopping.card_list.slice.viewmanagers.g r6 = r2.a();
        if (r6 == null) goto L27;
        String r7 = r6.b();
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
    L42:
        r3 = true;
    L43:
        if (r3 == false) goto L46;
        return;
    L46:
        if (((Set) this.f.invoke()).contains(new Pair(r9.d(), r9.c())) == true) goto L53;
        ((Set) this.f.invoke()).add(new Pair(r9.d(), r9.c()));
        post(new SingleTabView$updateTip$1(this, r9));
        return;
    L53:
        return;
    L41:
        if (r15.length() != 0) goto L43;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    L5:
        ((TextView) a(2131368004)).setVisibility(0);
        goto L6
    }

    public final void e(boolean r8, BaseSlcViewManager r9) {
        if (r8 == true) goto L5;
        ((TextView) a(2131388056)).setTextColor(ContextCompat.getColor(getContext(), 2131100764));
        CardListExtentionsKt.j((TextView) a(2131388056), 400);
        CardListExtentionsKt.j((TextView) a(2131368004), 400);
        ((TextView) a(2131368004)).setTextColor(ContextCompat.getColor(getContext(), 2131100764));
        return;
    L5:
        s r10 = this.g;
        if (r10 == null) goto L14;
        Function1<String, Unit> r11 = r10.c;
        if (r11 == null) goto L14;
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r2 = this.b;
        if (r2 == null) goto L12;
        String r3 = r2.d();
    L13:
        Unit r12 = (Unit) r11.invoke(r3);
        goto L14
    L12:
        r3 = null;
    L14:
        CardListExtentionsKt.j((TextView) a(2131388056), 500);
        CardListExtentionsKt.j((TextView) a(2131368004), 500);
        ((TextView) a(2131388056)).setTextColor(ContextCompat.getColor(getContext(), 2131100765));
        ((TextView) a(2131368004)).setTextColor(ContextCompat.getColor(getContext(), 2131100765));
        if (r9 == null) goto L24;
        HashMap r13 = new HashMap();
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r0 = this.b;
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

    public m(Context r3, SlcTemplateContext r4, Function0 r5, s r6, CardListObjectContainer r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        Intrinsics.checkNotNullParameter(r5, "tabTipShowedGetter");
        super(r3, null, 0);
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.a = new LinkedHashMap();
        LayoutInflater.from(r3).inflate(2131559257, this, true);
        ((TextView) a(2131388056)).setTextSize(0, SlcDimensExtensionsKt.e(16, r4.m()));
        ((TextView) a(2131368004)).setTextSize(0, SlcDimensExtensionsKt.e(16, r4.m()));
        ((TextView) a(2131388021)).setTextSize(0, SlcDimensExtensionsKt.e(10, r4.m()));
        this.c = LazyKt.lazy(new SingleTabView$trackerComponent$2(this));
        this.d = LazyKt.lazy(new SingleTabView$monitorId$2(this));
    }
}
