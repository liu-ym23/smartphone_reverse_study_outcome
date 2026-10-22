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
import com.larus.nova.R;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements com.ss.android.lark.coremd.base.parse.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f232350b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f232351a;

    public static final class a extends y9b.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f232352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f232353e;

        public a() {
            CommonPrefixSpan.c r100 = new CommonPrefixSpan.c();
            r100.f419939b = true;
            super(r100);
            this.f232352d = new Paint();
            i(CommonPrefixSpan.Type.LIST_NUM);
        }

        @Override // com.ss.android.lark.coremd.span.CommonPrefixSpan, android.text.style.LeadingMarginSpan
        public final int getLeadingMargin(boolean r100) {
            CommonPrefixSpan.c r101 = this.f419934a;
            return (int) (((r101.f419940c + r101.f419941d) + r101.f419942e) + 0.5f);
        }

        @Override // com.ss.android.lark.coremd.span.CommonPrefixSpan, android.text.style.LeadingMarginSpan
        public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "p");
            Intrinsics.checkNotNullParameter(r107, "text");
            Intrinsics.checkNotNullParameter(r112, "layout");
            String r113 = null;
            if ((r107 instanceof Spanned) == false) goto L5;
            Spanned r109 = (Spanned) r107;
        L6:
            if (r109 != null) goto L9;
            return;
        L9:
            if (this.f419934a.f419939b == true) goto L11;
            return;
        L11:
            if (r109.getSpanStart(this) != r108) goto L42;
            String r114 = this.f419934a.f419943f;
            if (r114 != null) goto L16;
            return;
        L16:
            if (r114.length() <= 0) goto L18;
            boolean r115 = true;
        L19:
            if (r115 == false) goto L21;
            r113 = r114;
        L21:
            if (r113 == null) goto L43;
            this.f232352d.set(r101);
            this.f232352d.setAntiAlias(true);
            this.f232352d.setColor(this.f419934a.f419944g);
            this.f232352d.setTypeface(Typeface.MONOSPACE);
            this.f232352d.setTextSize(this.f419934a.f419947j);
            float r116 = this.f232352d.measureText(r113);
            CommonPrefixSpan.c r117 = this.f419934a;
            float r118 = r102 + (r103 * r117.f419940c);
            if (r103 < 0) goto L30;
            if (this.f232353e == true) goto L34;
            r118 = r118 + r117.f419941d;
        L33:
            r118 = r118 - r116;
        L34:
            Paint.FontMetricsInt r119 = this.f232352d.getFontMetricsInt();
            if ((r106 - r104) <= ((r119.bottom - r119.top) * 2)) goto L37;
            Rect r120 = new Rect();
            this.f232352d.getTextBounds(r113, 0, r113.length(), r120);
            float r121 = (r104 + r120.height()) + ((r119.ascent - r119.top) * 2);
        L38:
            r100.drawText(r113, r118, r121, this.f232352d);
            return;
        L37:
            r121 = r105;
            goto L38
        L30:
            if (this.f232353e == true) goto L33;
            r116 = r117.f419941d;
            goto L33
        L43:
            return;
        L18:
            r115 = false;
            goto L19
        L42:
            return;
        L5:
            r109 = null;
            goto L6
        }
    }

    public static final class b {
    }

    static {
        f232350b = CollectionsKt.listOf(new String[]{"•", "◦", "▪"});
    }

    public m() {
        this.f232351a = new Paint();
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.c.class, new o(this));
        r100.a(v7b.u.class, new p(this));
        r100.a(v7b.q.class, new q(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.q.class, new n(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    public static final void f(m r100, com.ss.android.lark.coremd.impl.parse.k r101) {
        r100.getClass();
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.c(r101.getTheme()).l() == false) goto L7;
        e0.a(r101.f419905g, r101.f419902d);
        int r102 = r101.f419905g.length();
        r101.f419904f.c(r101.f419902d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r101.f419905g, r102, 0, 6);
        return;
    }

    public static final a e(m r100, String r101, v7b.q r102, Context r103, com.ss.android.lark.coremd.base.parse.j r104, int r110, boolean r111) {
        r100.getClass();
        ListThemeData r105 = com.ss.android.lark.coremd.base.parse.k.f419543b.c(r104);
        int r106 = com.ss.android.lark.coremd.utils.a.f419964a;
        int r107 = com.ss.android.lark.coremd.utils.a.a(r103, r105.h(), r110);
        float r108 = UIUtils.sp2px(r103, r105.j());
        v7b.s r109 = (v7b.a) r102.f553568d;
    L4:
        if (r109 == null) goto L9;
        if ((r109 instanceof v7b.i) == true) goto L7;
        r109 = r109.i();
        goto L4
    L7:
        int r112 = ((v7b.i) r109).f553557j;
    L10:
        if (r112 <= 0) goto L12;
        r108 = r108 * ((Number) ListProtector.get(com.ss.android.lark.coremd.base.parse.k.f419543b.e(r104).h(), r112 - 1)).floatValue();
    L12:
        a r113 = new a();
        r113.f(r110);
        r113.f419934a.f419947j = r108;
        r113.f419934a.f419944g = UIUtils.getColor(r103, r105.i());
        Intrinsics.checkNotNullParameter(r101, "value");
        r113.f419934a.f419943f = r101;
        Paint r114 = r100.f232351a;
        r114.setTypeface(Typeface.MONOSPACE);
        r114.setTextSize(r108);
        r113.f419934a.f419941d = r114.measureText(r101);
        r113.f419934a.f419942e = UIUtils.dp2px(r103, r105.k());
        if (r111 == false) goto L15;
        int r115 = R.dimen.li_prefix_mark_num_margin;
    L16:
        r113.f419934a.f419940c = UIUtils.getDimens(r103, r115) + r107;
        r113.f232353e = r111;
        return r113;
    L15:
        r115 = R.dimen.li_prefix_mark_ul_left_margin;
        goto L16
    L9:
        r112 = -1;
        goto L10
    }
}
