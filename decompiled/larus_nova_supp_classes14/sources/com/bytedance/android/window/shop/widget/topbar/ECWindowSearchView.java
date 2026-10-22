package com.bytedance.android.window.shop.widget.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/widget/topbar/ECWindowSearchView;", "Landroid/widget/FrameLayout;", "", "progress", "", "update", "Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "value", "a", "Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "getMinMode", "()Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "setMinMode", "(Lcom/bytedance/android/window/shop/widget/topbar/MinMode;)V", "minMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchView extends FrameLayout {
    public MinMode a;
    public int b;
    public int c;
    public float d;
    public final int e;
    public final View f;
    public final View g;
    public final View h;

    public final MinMode getMinMode() {
        return this.a;
    }

    public final void a(Integer r2) {
        if (r2 == null) goto L4;
        this.c = r2.intValue();
        update(this.d);
        return;
    L4:
        if (this.c != 0) goto L8;
        TextView r3 = (TextView) findViewById(2131371334);
        this.c = r3.getRight() - r3.getLeft();
        update(0.0f);
        return;
    }

    public final void setMinMode(MinMode r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
        if (r2 != MinMode.ICON) goto L5;
        a(Integer.valueOf(this.e));
    L5:
        update(0.0f);
    }

    public final void update(float r8) {
        if (Float.isNaN(r8) == false) goto L5;
        float r9 = 1.0f;
    L6:
        this.d = r9;
        MinMode r0 = this.a;
        MinMode r2 = MinMode.ICON;
        if (r0 != r2) goto L9;
        this.h.setAlpha(r9);
    L11:
        if (this.a != MinMode.TEXT) goto L14;
        this.g.setVisibility(0);
    L18:
        if (this.a != r2) goto L20;
        float r1 = 1 - (0.33f * r9);
        this.f.setScaleX(r1);
        this.f.setScaleY(r1);
    L21:
        int r3 = this.c;
        if (r3 > 0) goto L24;
        return;
    L24:
        if (this.a != r2) goto L26;
        int r4 = this.e;
    L27:
        int r5 = RangesKt.coerceAtLeast(this.b, this.c);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        r6.width = (int) (r4 + ((r5 - r4) * r9));
        Unit r10 = Unit.INSTANCE;
        setLayoutParams(r6);
        return;
    L26:
        r4 = RangesKt.coerceAtLeast(r3, this.e);
        goto L27
    L20:
        this.f.setScaleX(0.66999996f);
        this.f.setScaleY(0.66999996f);
        goto L21
    L14:
        if (r9 >= 0.1d) goto L16;
        this.g.setVisibility(8);
        goto L18
    L16:
        this.g.setVisibility(0);
        goto L18
    L9:
        this.h.setAlpha(1.0f);
        goto L11
    L5:
        r9 = RangesKt.coerceIn(r8, 0.0f, 1.0f);
        goto L6
    }

    public ECWindowSearchView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        super(r3, r4);
        LayoutInflater.from(r3).inflate(2131561056, this, true);
        this.a = MinMode.TEXT;
        this.e = r3.getResources().getDimensionPixelSize(2131166474);
        r3.getResources().getDimensionPixelSize(2131166472);
        this.f = findViewById(2131371333);
        this.g = findViewById(2131371334);
        this.h = findViewById(2131371332);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        a(null);
    }
}
