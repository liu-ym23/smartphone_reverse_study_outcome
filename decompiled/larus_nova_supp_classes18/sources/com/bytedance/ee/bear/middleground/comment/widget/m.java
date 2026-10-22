package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements com.ss.android.lark.coremd.base.parse.g {
    public static final List<String> b = null;
    public final Paint a;

    public static final class a extends y9b.a {
        public final Paint d;
        public boolean e;

        public a() {
            CommonPrefixSpan.c r0 = new CommonPrefixSpan.c();
            r0.b = true;
            super(r0);
            this.d = new Paint();
            i(CommonPrefixSpan.Type.LIST_NUM);
        }

        public final int getLeadingMargin(boolean r3) {
            CommonPrefixSpan.c r4 = ((CommonPrefixSpan) this).a;
            return (int) (((r4.c + r4.d) + r4.e) + 0.5f);
        }

        public final void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
            Intrinsics.checkNotNullParameter(r1, "c");
            Intrinsics.checkNotNullParameter(r2, "p");
            Intrinsics.checkNotNullParameter(r8, "text");
            Intrinsics.checkNotNullParameter(r12, "layout");
            String r13 = null;
            if ((r8 instanceof Spanned) == false) goto L5;
            Spanned r14 = (Spanned) r8;
        L6:
            if (r14 != null) goto L9;
            return;
        L9:
            if (((CommonPrefixSpan) this).a.b == true) goto L11;
            return;
        L11:
            if (r14.getSpanStart(this) != r9) goto L42;
            String r15 = ((CommonPrefixSpan) this).a.f;
            if (r15 != null) goto L16;
            return;
        L16:
            if (r15.length() <= 0) goto L18;
            boolean r16 = true;
        L19:
            if (r16 == false) goto L21;
            r13 = r15;
        L21:
            if (r13 == null) goto L43;
            this.d.set(r2);
            this.d.setAntiAlias(true);
            this.d.setColor(((CommonPrefixSpan) this).a.g);
            this.d.setTypeface(Typeface.MONOSPACE);
            this.d.setTextSize(((CommonPrefixSpan) this).a.j);
            float r17 = this.d.measureText(r13);
            CommonPrefixSpan.c r18 = ((CommonPrefixSpan) this).a;
            float r19 = r3 + (r4 * r18.c);
            if (r4 < 0) goto L30;
            if (this.e == true) goto L34;
            r19 = r19 + r18.d;
        L33:
            r19 = r19 - r17;
        L34:
            Paint.FontMetricsInt r20 = this.d.getFontMetricsInt();
            if ((r7 - r5) <= ((r20.bottom - r20.top) * 2)) goto L37;
            Rect r21 = new Rect();
            this.d.getTextBounds(r13, 0, r13.length(), r21);
            float r22 = (r5 + r21.height()) + ((r20.ascent - r20.top) * 2);
        L38:
            r1.drawText(r13, r19, r22, this.d);
            return;
        L37:
            r22 = r6;
            goto L38
        L30:
            if (this.e == true) goto L33;
            r17 = r18.d;
            goto L33
        L43:
            return;
        L18:
            r16 = false;
            goto L19
        L42:
            return;
        L5:
            r14 = null;
            goto L6
        }
    }

    public static final class b {
    }

    static {
        b = CollectionsKt.listOf(new String[]{"•", "◦", "▪"});
    }

    public m() {
        this.a = new Paint();
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.c.class, new o(this));
        r3.a(v7b.u.class, new p(this));
        r3.a(v7b.q.class, new q(this));
    }

    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.q.class, new n(this));
    }

    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public static final void f(m r2, com.ss.android.lark.coremd.impl.parse.k r3) {
        r2.getClass();
        if (com.ss.android.lark.coremd.base.parse.k.b.c(r3.getTheme()).l() == false) goto L7;
        e0.a(r3.g, r3.d);
        int r4 = r3.g.length();
        r3.f.c(r3.d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r3.g, r4, 0, 6);
        return;
    }

    public static final a e(m r5, String r6, v7b.q r7, Context r8, com.ss.android.lark.coremd.base.parse.j r9, int r10, boolean r11) {
        r5.getClass();
        ListThemeData r0 = com.ss.android.lark.coremd.base.parse.k.b.c(r9);
        int r1 = com.ss.android.lark.coremd.utils.a.a;
        int r2 = com.ss.android.lark.coremd.utils.a.a(r8, r0.h(), r10);
        float r3 = UIUtils.sp2px(r8, r0.j());
        v7b.s r12 = (v7b.a) ((v7b.s) r7).d;
    L4:
        if (r12 == null) goto L9;
        if ((r12 instanceof v7b.i) == true) goto L7;
        r12 = r12.i();
        goto L4
    L7:
        int r13 = ((v7b.i) r12).j;
    L10:
        if (r13 <= 0) goto L12;
        r3 = r3 * ((Number) ListProtector.get(com.ss.android.lark.coremd.base.parse.k.b.e(r9).h(), r13 - 1)).floatValue();
    L12:
        a r14 = new a();
        r14.f(r10);
        ((CommonPrefixSpan) r14).a.j = r3;
        ((CommonPrefixSpan) r14).a.g = UIUtils.getColor(r8, r0.i());
        Intrinsics.checkNotNullParameter(r6, "value");
        ((CommonPrefixSpan) r14).a.f = r6;
        Paint r15 = r5.a;
        r15.setTypeface(Typeface.MONOSPACE);
        r15.setTextSize(r3);
        ((CommonPrefixSpan) r14).a.d = r15.measureText(r6);
        ((CommonPrefixSpan) r14).a.e = UIUtils.dp2px(r8, r0.k());
        if (r11 == false) goto L15;
        int r16 = 2131167697;
    L16:
        ((CommonPrefixSpan) r14).a.c = UIUtils.getDimens(r8, r16) + r2;
        r14.e = r11;
        return r14;
    L15:
        r16 = 2131167699;
        goto L16
    L9:
        r13 = -1;
        goto L10
    }
}
