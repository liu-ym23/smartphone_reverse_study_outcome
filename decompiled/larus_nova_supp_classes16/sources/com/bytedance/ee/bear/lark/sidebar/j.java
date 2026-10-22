package com.bytedance.ee.bear.lark.sidebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends xc5.b {
    public final Context f;
    public final List<ad5.e> g;

    public static final class a extends jp5.a {
        public a(Context r1) {
            super(r1);
        }

        public final void onDraw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            r5.drawRoundRect(((jp5.a) this).l, getRoundRadius(), getRoundRadius(), ((jp5.a) this).i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onPageScrolled(int r2, float r3, int r4) {
            super.onPageScrolled(r2, r3, r4);
            List r5 = ((jp5.a) this).j;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.isEmpty() == true) goto L10;
            zuc.a r6 = tuc.a.a(((jp5.a) this).j, r2);
            int r7 = r6.d;
            int r8 = r6.e;
            int r9 = (r7 + r8) / 2;
            ((jp5.a) this).l.left = r9 - n.d(10);
            ((jp5.a) this).l.right = r9 + n.d(10);
            invalidate();
            return;
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.b {
        public final Typeface c;
        public final Typeface d;

        public final Typeface getBoldTypeface() {
            return this.d;
        }

        public final Typeface getNormalTypeface() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(int r1, int r2) {
            super.a(r1, r2);
            if (Intrinsics.areEqual(getTypeface(), this.d) == true) goto L6;
            setTypeface(this.d);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(int r1, int r2) {
            super.b(r1, r2);
            if (Intrinsics.areEqual(getTypeface(), this.c) == true) goto L6;
            setTypeface(this.c);
            return;
        }

        public b(Context r1, int r2, int r3, String r4, c r5) {
            Intrinsics.checkNotNull(r4);
            super(r1, r2, r3, r4, r5);
            this.c = h18.e.b(r1, 0);
            this.d = h18.e.b(r1, 1);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ j a;
        public final /* synthetic */ int b;

        public c(j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.f(this.b);
        }
    }

    public final Context getContext() {
        return this.f;
    }

    public final xuc.c b(Context r5) {
        if (r5 == null) goto L9;
        a r0 = new a(r5);
        r0.setMode(1);
        Integer[] r1 = new Integer[1];
        Resources r6 = r5.getResources();
        if (r6 == null) goto L6;
        int r7 = r6.getColor(2131105548);
    L7:
        r1[0] = Integer.valueOf(r7);
        r0.setColors(r1);
        r0.setLineHeight(n.d(3));
        r0.setXOffset(n.d(3));
        r0.setRoundRadius(n.d(4));
        return r0;
    L6:
        r7 = 0;
        goto L7
    L9:
        return null;
    }

    public final int d(Context r2) {
        if (r2 == null) goto L6;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L6;
        return r3.getColor(2131106622);
    L6:
        return 0;
    }

    public final int e(Context r2) {
        if (r2 == null) goto L6;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L6;
        return r3.getColor(2131106620);
    L6:
        return 0;
    }

    public final xuc.d c(Context r7, int r8) {
        if (r7 == null) goto L5;
        com.bytedance.ee.bear.widgets.b r9 = new b(r7, d(r7), e(r7), r7.getString(((ad5.e) ListProtector.get(this.g, r8)).b), new c(this, r8));
        r9.setMaxLines(1);
        r9.setTextSize(2, 17.0f);
        r9.setPadding(n.d(17), 0, n.d(17), 0);
        return r9;
    L5:
        return null;
    }

    public j(Context r2, MagicIndicator r3, List r4, com.bytedance.ee.bear.lark.sidebar.a r5) {
        Intrinsics.checkNotNullParameter(r4, "tabInfoList");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r2, r3, r4, r5);
        this.f = r2;
        this.g = r4;
    }
}
