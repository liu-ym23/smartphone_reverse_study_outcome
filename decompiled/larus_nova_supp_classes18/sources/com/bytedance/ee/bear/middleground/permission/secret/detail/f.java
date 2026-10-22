package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final Context a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public c h;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = 47;
        this.c = 14;
        this.d = 73;
        this.e = 12;
        this.f = 18;
        this.g = 2;
    }

    public final int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        Rect r0 = new Rect();
        Paint r1 = new Paint();
        r1.setTextSize(n.G(this.c));
        r1.getTextBounds(r5, 0, r5.length(), r0);
        float r6 = (float) Math.ceil(r0.width() / (n.d(this.d) - (n.d(this.e) * this.g)));
        float r2 = r0.height() * r6;
        int r3 = n.d(this.f);
        int r4 = this.g;
        return (int) ((r2 + (r3 * r4)) + ((r6 - 1) * n.d(r4)));
    }
}
