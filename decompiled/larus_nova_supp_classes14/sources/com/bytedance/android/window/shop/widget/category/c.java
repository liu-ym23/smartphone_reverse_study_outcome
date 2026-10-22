package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends LinearLayout implements com.bytedance.android.window.shop.widget.category.a {
    public static final int i = 0;
    public final int a;
    public final int b;
    public final GradientDrawable c;
    public final TextView d;
    public final ECDraweeView e;
    public boolean f;
    public final WindowProductCategoryVODeprecated.d g;
    public final Function3<WindowProductCategoryVODeprecated.a, Integer, Integer, Unit> h;

    public static final class a {
    }

    static {
        i = Color.argb(128, 255, 59, 82);
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void u() {
        this.d.setTextColor(this.a);
        f.e(this.d, 500);
        h0.d(this.e, m974getCategory().h, null, null, null, null, null, 120);
        Integer r0 = m974getCategory().i;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        this.c.setColor(r1);
    L5:
        this.c.setStroke(RangesKt.coerceAtLeast(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), 1), i);
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void w() {
        this.d.setTextColor(this.b);
        f.e(this.d, 400);
        h0.d(this.e, m974getCategory().h, null, null, null, null, null, 120);
        this.c.setColor(-855310);
        this.c.setStroke(0, i);
    }

    public /* bridge */ /* synthetic */ WindowProductCategoryVODeprecated.a getCategory() {
        return m974getCategory();
    }

    public boolean getLastChosen() {
        return this.f;
    }

    /* JADX INFO: renamed from: getCategory, reason: collision with other method in class */
    public WindowProductCategoryVODeprecated.d m974getCategory() {
        return this.g;
    }

    public void setLastChosen(boolean r1) {
        this.f = r1;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [android.view.View, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
    public c(WindowProductCategoryVODeprecated.d r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "category");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.g = r9;
        this.h = null;
        Integer r11 = m974getCategory().e;
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
    L6:
        this.a = r12;
        Integer r13 = m974getCategory().f;
        if (r13 == null) goto L9;
        int r14 = r13.intValue();
    L10:
        this.b = r14;
        GradientDrawable r15 = new GradientDrawable();
        r15.setCornerRadius(q.a(14));
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r15);
        Unit r0 = Unit.INSTANCE;
        this.c = r15;
        setGravity(17);
        setOrientation(0);
        setPadding(com.bytedance.android.shopping.extensions.b.b(16), 0, com.bytedance.android.shopping.extensions.b.b(16), 0);
        LayoutInflater.from(r10).inflate(2131561040, this);
        TextView r16 = (TextView) findViewById(2131393303);
        this.d = r16;
        ?? r1 = (ECDraweeView) findViewById(2131393302);
        this.e = r1;
        r16.setText(m974getCategory().b);
        if (m974getCategory().g != null) goto L13;
    L16:
        ExtensionsKt.gone(r1);
        return;
    L13:
        if (m974getCategory().h == null) goto L16;
        ExtensionsKt.visible(r1);
        h0.d(r1, m974getCategory().h, null, null, null, null, null, 120);
        return;
    L9:
        r14 = (int) 2568362019L;
        goto L10
    L5:
        r12 = (int) 4279638051L;
        goto L6
    }
}
