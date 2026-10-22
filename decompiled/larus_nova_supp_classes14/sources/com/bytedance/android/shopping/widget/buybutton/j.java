package com.bytedance.android.shopping.widget.buybutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends LinearLayout {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;

    public final TextView getBuyText() {
        return this.c;
    }

    public final View getBuyTextContainer() {
        return this.b;
    }

    public final View getProductButtonContainer() {
        return this.a;
    }

    public final TextView getSubBuyText() {
        return this.d;
    }

    public final View getSubBuyTextContainer() {
        return this.e;
    }

    public final View getTriangleView() {
        return this.f;
    }

    public final void setBuyText(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setBuyTextContainer(View r1) {
        this.b = r1;
    }

    public final void setProductButtonContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setSubBuyText(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setSubBuyTextContainer(View r1) {
        this.e = r1;
    }

    public final void setTriangleView(View r1) {
        this.f = r1;
    }

    public j(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        if (r4 == false) goto L5;
        LayoutInflater.from(r3).inflate(2131564815, this);
    L6:
        View r0 = findViewById(2131383105);
        this.a = r0;
        if (r4 == false) goto L9;
        int r5 = g1.a;
        r0.setBackgroundColor(g1.a.a(r3, 2131106133));
    L9:
        this.b = findViewById(2131372691);
        this.c = (TextView) findViewById(2131390261);
        this.d = (TextView) findViewById(2131390258);
        this.e = findViewById(2131372690);
        this.f = findViewById(2131389384);
        return;
    L5:
        LayoutInflater.from(r3).inflate(2131564618, this);
        goto L6
    }
}
