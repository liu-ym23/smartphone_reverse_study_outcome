package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements fk5.b {
    public d() {
    }

    @Override // fk5.b
    public final void a(CommonMenu r1, fk5.a r2, View r3, Function1<? super fk5.a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r4, "listener");
    }

    @Override // fk5.b
    public void update(fk5.a r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fk5.b
    public final View b(CommonMenu r3, int r4, int r5, fk5.a r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "item");
        if ((r6 instanceof c) == true) goto L5;
        return null;
    L5:
        if (r4 <= 0) goto L25;
        int r0 = -1;
        if ((r5 - 1) == r4) goto L25;
        c r7 = (c) r6;
        if (r7.e <= 0) goto L25;
        FrameLayout r8 = new FrameLayout(r3.getContext());
        int r9 = r7.f;
        if (r9 <= 0) goto L14;
        r0 = r9;
    L14:
        r8.setLayoutParams(new LinearLayoutCompat.LayoutParams(r0, r7.e));
        r8.setPadding(k.a(r8.getContext(), 16), r8.getPaddingTop(), k.a(r8.getContext(), 16), r8.getPaddingBottom());
        int r10 = r7.b;
        if (r10 == 0) goto L18;
        r8.setBackgroundColor(r10);
    L24:
        return r8;
    L18:
        if (r7.c == 0) goto L20;
        r8.setBackground(ContextCompat.getDrawable(r8.getContext(), r7.c));
        goto L24
    L20:
        Drawable r11 = r7.d;
        if (r11 == null) goto L23;
        r8.setBackground(r11);
        goto L24
    L23:
        r8.setBackgroundResource(2131244664);
    L25:
        return null;
    }
}
