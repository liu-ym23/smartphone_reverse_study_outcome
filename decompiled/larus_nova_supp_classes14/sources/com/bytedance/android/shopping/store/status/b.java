package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends LinearLayout {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ECShopEmptyPageType d;
    public boolean e;

    public final void a() {
        if (this.e == false) goto L5;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setBackgroundColor(ColorProtector.parseColor("#FFFFFF"));
        setPadding(0, 0, 0, 0);
        ImageView r0 = this.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = o.a(120);
        r1.width = o.a(120);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        this.b.setTextSize(2, 17.0f);
        TextView r2 = this.b;
        int r4 = c.a;
        d2.f(r2, c.d(8));
        this.c.setTextSize(2, 14.0f);
        d2.f(this.c, c.d(8));
        return;
    L5:
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int r5 = c.a;
        setPadding(0, c.d(40), 0, c.d(40));
        ImageView r6 = this.a;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = o.a(80);
        r7.width = o.a(80);
        Unit r8 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        this.b.setTextSize(2, 15.0f);
        d2.f(this.b, c.d(6));
        this.c.setTextSize(2, 13.0f);
        d2.f(this.c, c.d(6));
    }

    public final ECShopEmptyPageType getPageType() {
        return this.d;
    }

    public final void setBigSize(boolean r1) {
        this.e = r1;
    }

    public b(Context r4, ECShopEmptyPageType r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "pageType");
        super(r4, null, 0);
        this.d = r5;
        this.e = r6;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560849, this, true);
        setGravity(17);
        setOrientation(1);
        ImageView r7 = (ImageView) findViewById(2131370868);
        this.a = r7;
        TextView r8 = (TextView) findViewById(2131370870);
        this.b = r8;
        TextView r1 = (TextView) findViewById(2131370869);
        this.c = r1;
        int r9 = a.a[r5.ordinal()];
        if (r9 == 1) goto L9;
        if (r9 != 2) goto L13;
        r7.setImageResource(2131234751);
        r8.setText(th.a.g(getContext(), 2131896811));
        r1.setText(th.a.g(getContext(), 2131896810));
    L13:
        a();
        return;
    L9:
        if (com.bytedance.android.shopping.store.settings.a.a() == false) goto L11;
        r7.setImageResource(2131234703);
    L12:
        r8.setText(th.a.g(getContext(), 2131896748));
        r1.setText(th.a.g(getContext(), 2131896747));
        goto L13
    L11:
        r7.setImageResource(2131234702);
        goto L12
    }
}
