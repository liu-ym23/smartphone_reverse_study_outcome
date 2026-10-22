package com.bytedance.android.shopping.api.mall.common.widget;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final String d;
    public final Function0<Unit> e;

    public static final class a {
    }

    static {
    }

    public final Function0<Unit> getClickListener() {
        return this.e;
    }

    public final String getEnterFrom() {
        return this.d;
    }

    public b(Context r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "clickListener");
        super(r3, null, 0);
        this.d = null;
        this.e = r4;
        FrameLayout.inflate(r3, 2131564813, this);
        this.a = (TextView) findViewById(2131386300);
        this.b = (TextView) findViewById(2131386298);
        Button r5 = (Button) findViewById(2131386297);
        this.c = (ImageView) findViewById(2131386299);
        r5.setOnClickListener(new com.bytedance.android.shopping.api.mall.common.widget.a(this, r3));
    }
}
