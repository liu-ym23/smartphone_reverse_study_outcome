package com.ss.android.lark.widget.photo.preview.ocr;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.SelectionGranularity;
import com.larksuite.common_selection.o;
import com.larksuite.common_selection.p;
import com.larksuite.common_selection.s;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements s {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f447089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f447090b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f447089a == r101.f447089a) goto L12;
            return false;
        L12:
            if (this.f447090b == r101.f447090b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f447089a * 31) + this.f447090b;
        }

        public final String toString() {
            return "LocalIndex(graphicIndex=" + this.f447089a + ", charIndex=" + this.f447090b + ')';
        }

        public a(int r100, int r101) {
            this.f447089a = r100;
            this.f447090b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f447091a = null;

        static {
            int[] r100 = new int[SelectionGranularity.values().length];
            r100[SelectionGranularity.WORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f447091a = r100;
        }
    }

    public e() {
    }

    @Override // com.larksuite.common_selection.s
    public final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof TextGraphicOverlay) == true) goto L7;
        return 0;
    L7:
        return ((TextGraphicOverlay) r100).getVirtualText().length();
    }

    @Override // com.larksuite.common_selection.s
    public final boolean h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100 instanceof TextGraphicOverlay;
    }

    @Override // com.larksuite.common_selection.s
    public final float j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        View r101 = r100.f282908a;
        if ((r101 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r102 = (TextGraphicOverlay) r101;
    L7:
        if (r102 != null) goto L9;
        return 0.0f;
    L9:
        a r103 = n(r102, r100.f282909b);
        if (r103 != null) goto L13;
        return 0.0f;
    L13:
        if (r103.f447089a < r102.getGraphics().size()) goto L16;
        return 0.0f;
    L16:
        return ((d) ListProtector.get(r102.getGraphics(), r103.f447089a)).f447086g;
    L5:
        r102 = null;
        goto L7
    }

    public static float k(d r100, int r101) {
        if (r101 > 0) goto L5;
        return 0.0f;
    L5:
        String r102 = r100.f447080a.f447077a;
        int r103 = RangesKt.coerceAtMost(r101, r102.length());
        Paint r104 = r100.f447082c;
        float r105 = r100.f447085f;
        String r106 = r102.substring(0, r103);
        float r107 = r104.measureText(r106, 0, r106.length());
        if (r103 <= 0) goto L9;
        r107 = r107 + (r105 * (r103 - 1));
    L9:
        return Math.max(0.0f, r107);
    }

    public static int m(d r100, float r101) {
        String r102 = r100.f447080a.f447077a;
        Paint r103 = r100.f447082c;
        float r104 = r100.f447085f;
        int r105 = r102.length();
        float r106 = 0.0f;
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L9;
        int r108 = r107 + 1;
        float r109 = r103.measureText(r102, r107, r108);
        if (r101 < ((r109 / 2) + r106)) goto L6;
        r106 = r106 + (r109 + r104);
        r107 = r108;
        goto L3
    L6:
        return r107;
    L9:
        return r102.length();
    }

    @Override // com.larksuite.common_selection.s
    public final Point d(o r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        View r102 = r100.f282908a;
        if ((r102 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r103 = (TextGraphicOverlay) r102;
    L7:
        if (r103 == null) goto L9;
        a r104 = n(r103, r100.f282909b);
        if (r104 != null) goto L15;
        return new Point(0, 0);
    L15:
        if (r104.f447089a >= r103.getGraphics().size()) goto L17;
        d r105 = (d) ListProtector.get(r103.getGraphics(), r104.f447089a);
        c r106 = r105.f447080a;
        List<Point> r107 = r106.f447079c;
        int r108 = r103.getLeft();
        int r109 = r103.getTop();
        if (r107.size() >= 4) goto L22;
        RectF r110 = TextGraphicOverlay.a(r106.f447078b);
        r110.offset(r105.f447083d, r105.f447084e);
        float r111 = k(r105, r104.f447090b);
        return new Point(r108 + ((int) (r110.left + r111)), r109 + ((int) r110.bottom));
    L22:
        PointF r112 = q(r103, (Point) ListProtector.get(r107, 3), r105);
        PointF r113 = q(r103, (Point) ListProtector.get(r107, 2), r105);
        float r114 = k(r105, r106.f447077a.length());
        if (r114 > 0.0f) goto L25;
        r114 = 1.0f;
    L25:
        float r115 = k(r105, r104.f447090b) / r114;
        float r116 = r112.x;
        float r117 = r116 + ((r113.x - r116) * r115);
        float r118 = r112.y;
        float r119 = r118 + (r115 * (r113.y - r118));
        return new Point(r108 + ((int) r117), r109 + ((int) r119));
    L17:
        return new Point(0, 0);
    L9:
        return new Point(0, 0);
    L5:
        r103 = null;
        goto L7
    }

    public final a n(TextGraphicOverlay r100, int r101) {
        List<TextGraphicOverlay.d> r102 = r100.getGraphicInfo();
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L16;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextGraphicOverlay.d r107 = (TextGraphicOverlay.d) r105;
        int r108 = r107.f447071b;
        if (r101 < r108) goto L14;
        if (r101 >= (r107.f447072c + r108)) goto L14;
        return new a(r104, r101 - r108);
    L14:
        r104 = r106;
        goto L4
    L16:
        if ((!r102.isEmpty()) == true) goto L18;
        return null;
    L18:
        if (r101 == a(r100)) goto L20;
        return null;
    L20:
        return new a(r102.size() - 1, ((TextGraphicOverlay.d) CollectionsKt.last(r102)).f447070a.f447080a.f447077a.length());
    }

    public static double l(PointF r100, PointF r101, PointF r110) {
        double r102 = 2;
        float r103 = ((float) Math.pow(r101.x - r110.x, r102)) + ((float) Math.pow(r101.y - r110.y, r102));
        if (r103 != 0.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        float r111 = (float) Math.pow(r100.x - r101.x, r102);
        double r105 = Math.pow(r100.y - r101.y, r102);
    L10:
        return r111 + ((float) r105);
    L8:
        float r106 = r100.x;
        float r107 = r101.x;
        float r108 = (r106 - r107) * (r110.x - r107);
        float r109 = r100.y;
        float r112 = r101.y;
        float r113 = RangesKt.coerceIn((r108 + ((r109 - r112) * (r110.y - r112))) / r103, 0.0f, 1.0f);
        float r114 = r101.x;
        float r115 = r114 + ((r110.x - r114) * r113);
        float r116 = r101.y;
        float r117 = r116 + (r113 * (r110.y - r116));
        r111 = (float) Math.pow(r100.x - r115, r102);
        r105 = Math.pow(r100.y - r117, r102);
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public static int p(TextGraphicOverlay r100, int r101, int r102) {
        List<TextGraphicOverlay.d> r103 = r100.getGraphicInfo();
        if (r101 < r103.size()) goto L7;
        return -1;
    L7:
        return ((TextGraphicOverlay.d) ListProtector.get(r103, r101)).f447071b + r102;
    }

    public static PointF q(TextGraphicOverlay r100, Point r101, d r102) {
        float r103 = r100.getPivotX();
        float r104 = r100.getPivotY();
        float r105 = r100.getScaleX();
        float r106 = r100.getScaleY();
        float r107 = r100.getTranslationX();
        float r108 = r100.getTranslationY();
        return new PointF(((((r101.x + r102.f447083d) - r103) * r105) + r103) + r107, ((((r101.y + r102.f447084e) - r104) * r106) + r104) + r108);
    }

    @Override // com.larksuite.common_selection.s
    public final p b(View r100, o r101, SelectionGranularity r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "point");
        Intrinsics.checkNotNullParameter(r102, "granularity");
        if ((r100 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r103 = (TextGraphicOverlay) r100;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        boolean r104 = false;
        if (b.f447091a[r102.ordinal()] != 1) goto L33;
        TextGraphicOverlay r105 = (TextGraphicOverlay) r100;
        a r106 = n(r105, r101.f282909b);
        if (r106 != null) goto L13;
        return null;
    L13:
        d r107 = (d) CollectionsKt.getOrNull(r103.getGraphics(), r106.f447089a);
        if (r107 != null) goto L16;
        return null;
    L16:
        String r108 = r107.f447080a.f447077a;
        int r109 = r106.f447090b;
        if (r109 >= 0) goto L19;
    L21:
        if (r104 == true) goto L23;
        return null;
    L23:
        BreakIterator r110 = BreakIterator.getWordInstance(Locale.getDefault());
        r110.setText(r108);
        int r111 = r110.following(r109);
        if (r111 != (-1)) goto L26;
        return null;
    L26:
        int r112 = r110.previous();
        if (r112 != (-1)) goto L29;
        return null;
    L29:
        if (r111 > r109) goto L34;
        return null;
    L34:
        return new p(new o(r100, p(r105, r106.f447089a, r112)), new o(r100, p(r105, r106.f447089a, r111)));
    L19:
        if (r109 >= r108.length()) goto L21;
        r104 = true;
        goto L21
    L33:
        return new p(new o(r100, 0), new o(r100, a(r100)));
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final com.larksuite.common_selection.e c(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof TextGraphicOverlay) == true) goto L5;
        return null;
    L5:
        CharSequence r103 = ((TextGraphicOverlay) r100).getVirtualText();
        if (r101 >= 0) goto L8;
        return null;
    L8:
        if (r102 > r103.length()) goto L13;
        if (r101 <= r102) goto L11;
        return null;
    L11:
        return new com.larksuite.common_selection.e(r103.subSequence(r101, r102).toString());
    L13:
        return null;
    }

    @Override // com.larksuite.common_selection.s
    public final o g(View r210, float r211, float r212) {
        Intrinsics.checkNotNullParameter(r210, "view");
        if ((r210 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r100 = (TextGraphicOverlay) r210;
    L7:
        if (r100 == null) goto L9;
        List<d> r101 = r100.getGraphics();
        if (r101.isEmpty() == true) goto L13;
        PointF r102 = new PointF(r211, r212);
        Iterator r103 = r101.iterator();
        int r104 = 0;
        double r110 = Double.MAX_VALUE;
        int r111 = -1;
        int r112 = 0;
    L16:
        if (r103.hasNext() == false) goto L39;
        Object r113 = r103.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        d r115 = (d) r113;
        if ((r115 instanceof d) == true) goto L24;
        r115 = null;
    L24:
        if (r115 != null) goto L26;
        Iterator r213 = r103;
        r111 = r111;
    L36:
        r111 = r111;
    L37:
        r112 = r114;
        r103 = r213;
        r104 = 0;
        goto L16
    L26:
        List<Point> r105 = r115.f447080a.f447079c;
        if (r105.size() < 4) goto L32;
        PointF r116 = q(r100, (Point) ListProtector.get(r105, r104), r115);
        PointF r106 = q(r100, (Point) ListProtector.get(r105, 1), r115);
        PointF r107 = q(r100, (Point) ListProtector.get(r105, 2), r115);
        r213 = r103;
        PointF r108 = q(r100, (Point) ListProtector.get(r105, 3), r115);
        PointF[] r117 = {r116, r106, r107, r108};
        if (o(r102, r116, r106, r107, r108) == false) goto L31;
        double r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L34:
        if (r109 >= r110) goto L36;
        r110 = r109;
        r111 = r112;
        goto L37
    L31:
        r109 = Math.min(Math.min(l(r102, r117[0], r117[1]), l(r102, r117[1], r117[2])), Math.min(l(r102, r117[2], r117[3]), l(r102, r117[3], r117[0])));
        goto L34
    L32:
        r213 = r103;
        RectF r118 = TextGraphicOverlay.a(r115.f447080a.f447078b);
        r118.offset(r115.f447083d, r115.f447084e);
        float r119 = Math.max(0.0f, Math.max(r118.left - r211, r211 - r118.right));
        float r120 = Math.max(0.0f, Math.max(r118.top - r212, r212 - r118.bottom));
        r109 = (r119 * r119) + (r120 * r120);
        goto L34
    L39:
        if (r111 == (-1)) goto L41;
        d r121 = (d) ListProtector.get(r101, r111);
        c r122 = r121.f447080a;
        List<Point> r123 = r122.f447079c;
        if (r123.size() < 4) goto L51;
        PointF r124 = q(r100, (Point) ListProtector.get(r123, 2), r121);
        PointF r125 = q(r100, (Point) ListProtector.get(r123, 3), r121);
        float r126 = r124.x;
        float r127 = r125.x;
        float r128 = r126 - r127;
        float r129 = r124.y;
        float r130 = r125.y;
        float r131 = r129 - r130;
        float r132 = r102.x - r127;
        float r133 = r102.y - r130;
        float r134 = (r128 * r128) + (r131 * r131);
        if (r134 != 0.0f) goto L47;
        boolean r135 = true;
    L48:
        if (r135 == false) goto L50;
        int r136 = 0;
    L53:
        return new o(r210, p((TextGraphicOverlay) r210, r111, r136));
    L50:
        r136 = m(r121, RangesKt.coerceIn(((r132 * r128) + (r133 * r131)) / r134, 0.0f, 1.0f) * k(r121, r122.f447077a.length()));
        goto L53
    L47:
        r135 = false;
        goto L48
    L51:
        RectF r137 = TextGraphicOverlay.a(r122.f447078b);
        r137.offset(r121.f447083d, r121.f447084e);
        r136 = m(r121, RangesKt.coerceIn(r211, r137.left, r137.right) - r137.left);
        goto L53
    L41:
        return new o(r210, -1);
    L13:
        return new o(r210, -1);
    L9:
        return new o(r210, -1);
    L5:
        r100 = null;
        goto L7
    }

    @Override // com.larksuite.common_selection.s
    public final boolean i(View r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if ((r110 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r113 = (TextGraphicOverlay) r110;
    L7:
        if (r113 != null) goto L9;
        return false;
    L9:
        List<d> r100 = r113.getGraphics();
        if (r100.isEmpty() == false) goto L12;
        return false;
    L12:
        PointF r101 = new PointF(r111, r112);
        Iterator<d> r114 = r100.iterator();
    L14:
        if (r114.hasNext() == false) goto L26;
        d r115 = r114.next();
        if ((r115 instanceof d) == true) goto L19;
        r115 = null;
    L19:
        if (r115 == null) goto L14;
        List<Point> r102 = r115.f447080a.f447079c;
        if (r102.size() < 4) goto L14;
        if (o(r101, q(r113, (Point) ListProtector.get(r102, 0), r115), q(r113, (Point) ListProtector.get(r102, 1), r115), q(r113, (Point) ListProtector.get(r102, 2), r115), q(r113, (Point) ListProtector.get(r102, 3), r115)) == false) goto L14;
        return true;
    L26:
        return false;
    L5:
        r113 = null;
        goto L7
    }

    @Override // com.larksuite.common_selection.s
    public final void e(View r110, int r111, int r210, Path r211) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r211, "outPath");
        r211.reset();
        if ((r110 instanceof TextGraphicOverlay) == false) goto L5;
        TextGraphicOverlay r100 = (TextGraphicOverlay) r110;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r111 < r210) goto L10;
        return;
    L10:
        a r101 = n(r100, r111);
        if (r101 != null) goto L13;
        return;
    L13:
        a r102 = n(r100, r210);
        if (r102 != null) goto L16;
        return;
    L16:
        List<d> r103 = r100.getGraphics();
        int r104 = r101.f447089a;
        int r105 = r102.f447089a;
        if (r104 <= r105) goto L19;
        return;
    L19:
        if (r104 >= r103.size()) goto L39;
        d r106 = (d) CollectionsKt.getOrNull(r103, r104);
        if (r106 == null) goto L39;
        c r107 = r106.f447080a;
        List<Point> r112 = r107.f447079c;
        if (r112.size() < 4) goto L39;
        PointF r113 = q(r100, (Point) ListProtector.get(r112, 0), r106);
        PointF r114 = q(r100, (Point) ListProtector.get(r112, 1), r106);
        PointF r115 = q(r100, (Point) ListProtector.get(r112, 2), r106);
        PointF r116 = q(r100, (Point) ListProtector.get(r112, 3), r106);
        float r108 = k(r106, r107.f447077a.length());
        float r117 = 0.0f;
        if (r108 > 0.0f) goto L29;
        r108 = 1.0f;
    L29:
        if (r104 != r101.f447089a) goto L32;
        r117 = k(r106, r101.f447090b) / r108;
    L32:
        if (r104 != r102.f447089a) goto L34;
        float r118 = k(r106, r102.f447090b) / r108;
    L36:
        if (r117 >= r118) goto L39;
        float r109 = r113.x;
        float r119 = r114.x - r109;
        float r120 = r109 + (r119 * r117);
        float r121 = r113.y;
        float r122 = r114.y - r121;
        float r123 = r121 + (r122 * r117);
        float r124 = r109 + (r119 * r118);
        float r125 = r121 + (r122 * r118);
        float r126 = r116.x;
        float r127 = r115.x - r126;
        float r128 = r126 + (r127 * r118);
        float r129 = r116.y;
        float r130 = r115.y - r129;
        float r131 = (r118 * r130) + r129;
        r211.moveTo(r120, r123);
        r211.lineTo(r124, r125);
        r211.lineTo(r128, r131);
        r211.lineTo(r126 + (r127 * r117), r129 + (r117 * r130));
        r211.close();
        goto L39
    L34:
        r118 = 1.0f;
    L39:
        if (r104 == r105) goto L43;
        r104 = r104 + 1;
        r100 = r100;
        r101 = r101;
        goto L19
    L43:
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final float f(View r100, float r101, float r102, o r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "point");
        Point r104 = d(r103, false);
        float r105 = r100.getX() + r101;
        float r106 = r100.getY() + r102;
        float r107 = r105 - r104.x;
        float r108 = r106 - r104.y;
        return (float) Math.sqrt((r107 * r107) + (r108 * r108));
    }

    public static boolean o(PointF r100, PointF r101, PointF r102, PointF r110, PointF r111) {
        float r103 = r102.x;
        float r104 = r101.x;
        float r105 = r100.y;
        float r106 = r101.y;
        float r107 = r102.y;
        float r108 = r100.x;
        float r109 = ((r103 - r104) * (r105 - r106)) - ((r107 - r106) * (r108 - r104));
        float r112 = r110.x;
        float r113 = r110.y;
        float r114 = ((r112 - r103) * (r105 - r107)) - ((r113 - r107) * (r108 - r103));
        float r115 = r111.x;
        float r116 = r111.y;
        float r117 = ((r115 - r112) * (r105 - r113)) - ((r116 - r113) * (r108 - r112));
        float r118 = ((r104 - r115) * (r105 - r116)) - ((r106 - r116) * (r108 - r115));
        if (r109 >= 0.0f) goto L5;
    L12:
        boolean r119 = true;
    L14:
        if (r109 <= 0.0f) goto L16;
    L23:
        boolean r120 = true;
    L24:
        if (r119 == false) goto L29;
        if (r120 == false) goto L30;
        return false;
    L30:
        return true;
    L29:
        return true;
    L16:
        if (r114 > 0.0f) goto L23;
        if (r117 > 0.0f) goto L23;
        if (r118 > 0.0f) goto L23;
        r120 = false;
        goto L24
    L5:
        if (r114 < 0.0f) goto L12;
        if (r117 < 0.0f) goto L12;
        if (r118 < 0.0f) goto L12;
        r119 = false;
        goto L14
    }
}
