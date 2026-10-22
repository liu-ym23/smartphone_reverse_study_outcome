package com.bytedance.ee.bear.profile;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.facade.common.widget.d {
    public final ArrayList<View> s;

    public final int b() {
        return ((com.bytedance.ee.bear.facade.common.widget.d) this).e.getHeight() - ((int) ((com.bytedance.ee.bear.facade.common.widget.d) this).e.getTranslationY());
    }

    public final void o() {
        View r0 = ((com.bytedance.ee.bear.facade.common.widget.d) this).e;
        r0.setTranslationY(r0.getHeight() - 1);
        p();
    }

    public final void p() {
        ArrayList<View> r0 = this.s;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((View) r1.next()).setTranslationY(((com.bytedance.ee.bear.facade.common.widget.d) this).e.getTranslationY());
        goto L6
    L10:
        return;
    }

    public final int c() {
        return b();
    }

    public final void l(float r3) {
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        float r0 = ((com.bytedance.ee.bear.facade.common.widget.d) this).e.getHeight() - r3;
        if (r0 != ((com.bytedance.ee.bear.facade.common.widget.d) this).e.getTranslationY()) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ((com.bytedance.ee.bear.facade.common.widget.d) this).e.setTranslationY(r0);
        p();
        d((int) r3);
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final void m(float r1, float r2, float r3) {
        super.m(r1, r2, r3);
    }

    public j(Context r7, VerticalScrollInterceptLayout r8, float r9, float r10, ArrayList r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "contentView");
        Intrinsics.checkNotNullParameter(r11, "followViews");
        super(r7, r8, 0.0f, r9, r10);
        this.s = r11;
    }
}
