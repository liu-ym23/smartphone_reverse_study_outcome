package com.larksuite.component.universe_design.menu;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.menu.a$a, reason: collision with other inner class name */
    public static final class C3917a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f285067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RectF f285068b;

        public b() {
        }

        public final void setResult(RectF r100) {
            this.f285068b = r100;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285069a = null;

        static {
            int[] r100 = new int[PositionAlign.values().length];
            r100[PositionAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PositionAlign.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PositionAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f285069a = r100;
        }
    }

    static {
    }

    public static RectF a(com.larksuite.component.universe_design.menu.b r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Display r100 = r110.f285071b.getDisplay();
        if (r100 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "display");
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getMetrics(r101);
        RectF r102 = new RectF();
        r102.left = 0.0f;
        r102.top = 0.0f;
        r102.right = r101.widthPixels;
        r102.bottom = r101.heightPixels;
        View r103 = r110.f285070a;
        Intrinsics.checkNotNullParameter(r103, "uiView");
        int r104 = h18.g.f483541a;
        if (r103 == null) goto L8;
        r103.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r105 = r103.getMeasuredWidth();
    L9:
        float r106 = r105;
        if (r103 == null) goto L12;
        r103.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r107 = r103.getMeasuredHeight();
    L13:
        RectF r108 = new RectF();
        r108.left = 0.0f;
        r108.top = 0.0f;
        r108.right = r106;
        r108.bottom = r107;
        View r109 = r110.f285071b;
        Intrinsics.checkNotNullParameter(r109, "anchorView");
        int[] r111 = new int[2];
        r109.getLocationInWindow(r111);
        float r112 = r109.getWidth();
        float r113 = r109.getHeight();
        RectF r114 = new RectF();
        float r115 = r111[0];
        r114.left = r115;
        float r116 = r111[1];
        r114.top = r116;
        r114.right = r115 + r112;
        r114.bottom = r116 + r113;
        RectF r117 = new RectF(r108);
        int r118 = r110.f285072c;
        float r119 = r110.f285074e;
        Intrinsics.checkNotNullParameter(r117, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r114, "anchorViewRectF");
        RectF r120 = new RectF(r117);
        PointF r121 = new PointF();
        r121.x = r114.centerX();
        r121.y = r114.centerY();
        if (r118 == 48) goto L24;
        if (r118 != 80) goto L17;
        r121.x = r114.centerX();
        float r122 = 2;
        r121.y = r114.centerY() + (((r114.height() / r122) + r119) + (r117.height() / r122));
    L25:
        float r123 = r121.x - r117.centerX();
        float r124 = r121.y - r117.centerY();
        r120.left += r123;
        r120.right += r123;
        r120.top += r124;
        r120.bottom += r124;
        int r125 = r110.f285072c;
        PositionAlign r126 = r110.f285073d;
        Intrinsics.checkNotNullParameter(r120, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r114, "anchorViewRectF");
        Intrinsics.checkNotNullParameter(r126, "anchorAlign");
        RectF r127 = new RectF(r120);
        if (r125 == 3) goto L39;
        if (r125 == 5) goto L39;
        if (r125 == 48) goto L31;
        if (r125 == 80) goto L31;
    L47:
        int r128 = r110.f285072c;
        Intrinsics.checkNotNullParameter(r127, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r114, "anchorViewRectF");
        Intrinsics.checkNotNullParameter(r102, "boundaryRectF");
        RectF r129 = new RectF(r127);
        if (r127.width() <= r102.width()) goto L50;
    L94:
        b r130 = new b();
        r130.f285067a = -1;
    L96:
        if (r130.f285067a != 0) goto L100;
        RectF r131 = r130.f285068b;
        if (r131 == null) goto L100;
        return r131;
    L100:
        return null;
    L50:
        if (r127.height() > r102.height()) goto L94;
        if (r128 == 3) goto L75;
        if (r128 == 5) goto L75;
        if (r128 == 48) goto L57;
        if (r128 == 80) goto L57;
    L92:
        r130 = new b();
        r130.setResult(r129);
    L57:
        float r132 = r127.left;
        float r133 = r102.left;
        if (r132 < r133) goto L62;
        r132 = r127.right;
        r133 = r102.right;
        if (r132 > r133) goto L62;
        float r134 = 0.0f;
    L64:
        r129.left += r134;
        r129.right += r134;
        if (r127.top >= r102.top) goto L67;
    L68:
        float r135 = (r114.centerY() - r127.centerY()) * 2;
        float r136 = r127.top + r135;
        float r137 = r127.bottom + r135;
        if (r136 >= r102.top) goto L71;
    L74:
        r130 = new b();
        r130.f285067a = -1;
        goto L96
    L71:
        if (r137 > r102.bottom) goto L74;
        r129.top += r135;
        r129.bottom += r135;
        goto L92
    L67:
        if (r127.bottom <= r102.bottom) goto L92;
    L62:
        r134 = r133 - r132;
    L75:
        float r138 = r127.top;
        float r139 = r102.top;
        if (r138 < r139) goto L80;
        r138 = r127.bottom;
        r139 = r102.bottom;
        if (r138 > r139) goto L80;
        float r140 = 0.0f;
    L82:
        r129.top += r140;
        r129.bottom += r140;
        if (r127.left >= r102.left) goto L85;
    L86:
        float r141 = (r114.centerX() - r127.centerX()) * 2;
        float r142 = r127.left + r141;
        float r143 = r127.right + r141;
        if (r142 >= r102.left) goto L89;
    L93:
        r130 = new b();
        r130.f285067a = -1;
        goto L96
    L89:
        if (r143 > r102.right) goto L93;
        r129.left += r141;
        r129.right += r141;
        goto L92
    L85:
        if (r127.right <= r102.right) goto L92;
    L80:
        r140 = r139 - r138;
    L31:
        int r144 = c.f285069a[r126.ordinal()];
        if (r144 == 1) goto L38;
        if (r144 == 2) goto L47;
        if (r144 != 3) goto L37;
        float r145 = r114.right - r120.right;
        r127.left += r145;
        r127.right += r145;
        goto L47
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        float r146 = r114.left - r120.left;
        r127.left += r146;
        r127.right += r146;
    L39:
        int r147 = c.f285069a[r126.ordinal()];
        if (r147 == 1) goto L46;
        if (r147 == 2) goto L47;
        if (r147 != 3) goto L45;
        float r148 = r114.bottom - r120.bottom;
        r127.top += r148;
        r127.bottom += r148;
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();
    L46:
        float r149 = r114.top - r120.top;
        r127.top += r149;
        r127.bottom += r149;
        goto L47
    L17:
        if (r118 != 8388611) goto L19;
        float r150 = 2;
        r121.x = r114.centerX() - (((r114.width() / r150) + r119) + (r117.width() / r150));
        r121.y = r114.centerY();
        goto L25
    L19:
        if (r118 != 8388613) goto L25;
        float r151 = 2;
        r121.x = r114.centerX() - (((r114.width() / r151) + r119) + (r117.width() / r151));
        r121.y = r114.centerY();
        goto L25
    L24:
        r121.x = r114.centerX();
        float r152 = 2;
        r121.y = r114.centerY() - (((r114.height() / r152) + r119) + (r117.height() / r152));
        goto L25
    L12:
        r107 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }
}
