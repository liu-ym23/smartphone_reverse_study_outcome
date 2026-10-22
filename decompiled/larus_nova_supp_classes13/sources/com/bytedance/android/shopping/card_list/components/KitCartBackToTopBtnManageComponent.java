package com.bytedance.android.shopping.card_list.components;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class KitCartBackToTopBtnManageComponent extends com.bytedance.android.shopping.card_list.components.b {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final CardListObjectContainer h;
    public final View i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ KitCartBackToTopBtnManageComponent b;

        public a(View r1, KitCartBackToTopBtnManageComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CardListTrackerComponent r5 = (CardListTrackerComponent) this.b.f.getValue();
            if (r5 == null) goto L5;
            CardListTrackerComponent.h(r5, this.b.h.f.getStandardClickEventName(), MapsKt.mapOf(TuplesKt.to("tab_name", "back_to_top_button")), 4);
        L5:
            ExtensionsKt.gone(this.a);
            CardListBodyComponent r6 = (CardListBodyComponent) this.b.d.getValue();
            if (r6 == null) goto L9;
            r6.m.d.d.setValue(Unit.INSTANCE);
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ KitCartBackToTopBtnManageComponent a;

        public b(KitCartBackToTopBtnManageComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardListTrackerComponent r0 = (CardListTrackerComponent) this.a.f.getValue();     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            CardListTrackerComponent.h(r0, this.a.h.f.getStandardShowEventName(), MapsKt.mapOf(TuplesKt.to("tab_name", "back_to_top_button")), 4);     // Catch: Throwable -> L7
        L5:
            ExtensionsKt.visible(this.a.i);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        View r0 = this.i;
        if (r0 == null) goto L38;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r1 = ((AndroidYaTaInstance) this.h.e.c.invoke()).p;
        if (r1 == null) goto L7;
        int r2 = com.bytedance.android.shopping.card_list.utils.h.a;
        Intrinsics.checkNotNullParameter(r1, "renderinfo");
        float r3 = r1.b.f.a;
    L8:
        int r4 = (int) (40 * r3);
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if (r5 == null) goto L33;
        r5.height = r4;
        r5.width = r4;
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L13;
        int r6 = 8;
    L14:
        int r7 = (int) (r6 * r3);
        Float r8 = ECAppInfoService.e.getCurrentFontScale();
        if (r8 == null) goto L17;
        float r9 = r8.floatValue();
    L18:
        boolean r10 = r5 instanceof ViewGroup.MarginLayoutParams;
        ViewGroup.LayoutParams r11 = null;
        if (r10 == true) goto L21;
        ViewGroup.LayoutParams r12 = null;
    L22:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L25;
        r13.setMarginEnd(r7);
    L25:
        if (r10 == false) goto L28;
        r11 = r5;
    L28:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r11;
        if (r14 == null) goto L31;
        r14.bottomMargin = (int) ((60 * r9) * r3);
    L31:
        r0.setLayoutParams(r5);
        goto L33
    L21:
        r12 = r5;
        goto L22
    L17:
        r9 = 1.0f;
        goto L18
    L13:
        r6 = 13;
    L33:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L35;
        int r15 = g1.a;
        Drawable r16 = g1.a.b(r0.getContext(), 2131232513);
    L36:
        r0.setBackground(r16);
        r0.setOnClickListener(new a(r0, this));
        return;
    L35:
        int r17 = g1.a;
        r16 = g1.a.b(r0.getContext(), 2131233379);
        goto L36
    L7:
        Resources r18 = Resources.getSystem();
        r3 = WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).density;
        goto L8
    }

    public final void g(boolean r2) {
        if (r2 == false) goto L6;
        View r3 = this.i;
        if (r3 == null) goto L10;
        r3.post(new b(this));
        return;
    L10:
        return;
    L6:
        View r4 = this.i;
        if (r4 == null) goto L12;
        ExtensionsKt.gone(r4);
        return;
    }

    public KitCartBackToTopBtnManageComponent(CardListObjectContainer r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.h = r2;
        this.i = r3;
        this.d = LazyKt.lazy(new KitCartBackToTopBtnManageComponent$bodyComponent$2(this));
        this.e = LazyKt.lazy(new KitCartBackToTopBtnManageComponent$enableNps$2(this));
        this.f = LazyKt.lazy(new KitCartBackToTopBtnManageComponent$trackerComponent$2(this));
        this.g = LazyKt.lazy(new KitCartBackToTopBtnManageComponent$splitMode$2(this));
    }
}
