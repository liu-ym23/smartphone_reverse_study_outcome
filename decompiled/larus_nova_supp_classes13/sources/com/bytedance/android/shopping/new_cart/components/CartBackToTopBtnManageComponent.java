package com.bytedance.android.shopping.new_cart.components;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartBackToTopBtnManageComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final CartObjectContainer e;
    public final View f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ CartBackToTopBtnManageComponent b;

        public a(View r1, CartBackToTopBtnManageComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CartViewModel.doEventAction$default(this.b.a.d, "cart_list_tab_click", MapsKt.mapOf(TuplesKt.to("tab_name", "back_to_top_button")), null, 4, null);
            ExtensionsKt.gone(this.a);
            CartBodyComponent r8 = (CartBodyComponent) this.b.b.getValue();
            if (r8 == null) goto L6;
            r8.s();
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CartBackToTopBtnManageComponent a;

        public b(CartBackToTopBtnManageComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel.doEventAction$default(this.a.a.d, "cart_list_tab_show", MapsKt.mapOf(TuplesKt.to("tab_name", "back_to_top_button")), null, 4, null);     // Catch: Throwable -> L4
            ExtensionsKt.visible(this.a.f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        View r0 = this.f;
        if (r0 == null) goto L36;
        int r1 = s.a;
        float r2 = s.a(Boolean.valueOf(((Boolean) this.d.getValue()).booleanValue())).a;
        int r3 = (int) (40 * r2);
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        if (r4 == null) goto L31;
        r4.height = r3;
        r4.width = r3;
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L9;
        int r5 = 8;
    L10:
        int r6 = (int) (r5 * r2);
        if (CartSettingUtils.b() == false) goto L15;
        Float r7 = ECAppInfoService.e.getCurrentFontScale();
        if (r7 == null) goto L15;
        float r8 = r7.floatValue();
    L16:
        boolean r9 = r4 instanceof ViewGroup.MarginLayoutParams;
        ViewGroup.LayoutParams r10 = null;
        if (r9 == true) goto L19;
        ViewGroup.LayoutParams r11 = null;
    L20:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L23;
        r12.setMarginEnd(r6);
    L23:
        if (r9 == false) goto L26;
        r10 = r4;
    L26:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r10;
        if (r13 == null) goto L29;
        r13.bottomMargin = (int) ((60 * r8) * r2);
    L29:
        r0.setLayoutParams(r4);
        goto L31
    L19:
        r11 = r4;
    L15:
        r8 = 1.0f;
        goto L16
    L9:
        r5 = 13;
    L31:
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L33;
        int r14 = g1.a;
        Drawable r15 = g1.a.b(r0.getContext(), 2131234309);
    L34:
        r0.setBackground(r15);
        r0.setOnClickListener(new a(r0, this));
        return;
    L33:
        int r16 = g1.a;
        r15 = g1.a.b(r0.getContext(), 2131233379);
        goto L34
    }

    public final void n(boolean r2) {
        if (r2 == false) goto L6;
        View r3 = this.f;
        if (r3 == null) goto L10;
        r3.post(new b(this));
        return;
    L10:
        return;
    L6:
        View r4 = this.f;
        if (r4 == null) goto L12;
        ExtensionsKt.gone(r4);
        return;
    }

    public CartBackToTopBtnManageComponent(CartObjectContainer r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.b = LazyKt.lazy(new CartBackToTopBtnManageComponent$bodyComponent$2(this));
        this.c = LazyKt.lazy(new CartBackToTopBtnManageComponent$enableNps$2(this));
        this.d = LazyKt.lazy(new CartBackToTopBtnManageComponent$splitMode$2(this));
    }
}
