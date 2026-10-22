package vq;

import android.graphics.LinearGradient;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556754a = 0;

    static {
    }

    public static LinearGradient a(Rect r110, b r210) {
        float r100 = r210.f556749a;
        int r101 = c.f556751a;
        Point r102 = new Point(r110.width() / 2, r110.height() / 2);
        float r103 = 90 + r100;
    L3:
        float r104 = 0;
        if (r103 >= r104) goto L6;
        r103 = r103 + 360;
        goto L3
    L6:
        float r105 = 360;
        float r106 = r103 % r105;
        if (r106 < 88.0f) goto L12;
        if (r106 > 91.0f) goto L12;
        r106 = 90.0f;
    L17:
        if (r106 != 90.0f) goto L19;
    L36:
        a r107 = new a(1, 0, -r102.x);
    L37:
        int r108 = r107.f556746a;
        int r111 = r107.f556747b;
        int r109 = r107.f556748c;
        List<d> r112 = r210.f556750b;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
        int r115 = 0;
    L39:
        if (r114.hasNext() == false) goto L51;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        d r118 = (d) r116;
        d r119 = (d) CollectionsKt.getOrNull(r113, r115 - 1);
        if (r119 == null) goto L48;
        int r120 = r118.f556753b;
        int r121 = r119.f556753b;
        if (r120 >= r121) goto L48;
        r113.add(d.a(r118, r121));
    L49:
        r115 = r117;
    L48:
        r113.add(r118);
        goto L49
    L51:
        if (r113.isEmpty() == false) goto L54;
        List r122 = CollectionsKt.listOf(new d[]{new d(-1, 0), new d(-1, 1)});
    L63:
        d r123 = (d) CollectionsKt.first(r122);
        d r124 = (d) CollectionsKt.last(r122);
        int r125 = c.f556751a;
        Point r126 = new Point(r110.left, r110.top);
        Point r127 = new Point(r110.right, r110.top);
        Point r128 = new Point(r110.left, r110.bottom);
        Point r129 = new Point(r110.right, r110.bottom);
        Point r130 = c.a(r108, r111, r109, r126);
        Point r131 = c.a(r108, r111, r109, r127);
        Point r132 = c.a(r108, r111, r109, r128);
        Point r133 = c.a(r108, r111, r109, r129);
    L65:
        if (r100 >= r104) goto L67;
        r100 = r100 + r105;
        goto L65
    L67:
        float r134 = r100 % r105;
        if (r134 < 0.0f) goto L73;
        if (r134 > 90.0f) goto L73;
        Point r135 = r132;
    L83:
        if (r134 < 0.0f) goto L87;
        float r136 = 90.0f;
        if (r134 > 90.0f) goto L89;
        r130 = r131;
    L98:
        int r137 = r123.f556753b;
        int r138 = r124.f556753b;
        int r139 = r130.x;
        int r140 = r135.x;
        double r141 = 100;
        double r142 = ((double) r137) / r141;
        double r143 = r139 - r140;
        double r144 = r130.y - r135.y;
        Point r145 = new Point(Math.round((float) (((double) r140) + (r143 * r142))), Math.round((float) (((double) r135.y) + (r142 * r144))));
        double r146 = ((double) (r138 - 100)) / r141;
        Point r147 = new Point(Math.round((float) (((double) r130.x) + (r143 * r146))), Math.round((float) (((double) r130.y) + (r144 * r146))));
        int r148 = ((d) CollectionsKt.first(r122)).f556753b;
        int r149 = ((d) CollectionsKt.last(r122)).f556753b - r148;
        List r150 = r122;
        ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
        Iterator r152 = r150.iterator();
    L100:
        if (r152.hasNext() == false) goto L102;
        d r153 = (d) r152.next();
        r151.add(d.a(r153, Math.round((float) ((((double) (r153.f556753b - r148)) / ((double) r149)) * r141))));
        goto L100
    L102:
        float r154 = r145.x;
        float r155 = r145.y;
        float r156 = r147.x;
        float r157 = r147.y;
        ArrayList r158 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r151, 10));
        Iterator r159 = r151.iterator();
    L104:
        if (r159.hasNext() == false) goto L106;
        r158.add(Integer.valueOf(((d) r159.next()).f556752a));
        goto L104
    L106:
        int[] r160 = CollectionsKt.toIntArray(r158);
        ArrayList r161 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r151, 10));
        Iterator r162 = r151.iterator();
    L108:
        if (r162.hasNext() == false) goto L111;
        r161.add(Float.valueOf(((d) r162.next()).f556753b / 100));
        goto L108
    L111:
        return new LinearGradient(r154, r155, r156, r157, r160, CollectionsKt.toFloatArray(r161), Shader.TileMode.CLAMP);
    L89:
        if (r134 < r136) goto L94;
        if (r134 > 180.0f) goto L94;
        r130 = r133;
    L94:
        if (r134 < 180.0f) goto L98;
        if (r134 > 270.0f) goto L98;
        r130 = r132;
        goto L98
    L87:
        r136 = 90.0f;
    L73:
        if (r134 < 90.0f) goto L78;
        if (r134 > 180.0f) goto L78;
        r135 = r130;
    L78:
        if (r134 >= 180.0f) goto L80;
    L82:
        r135 = r133;
        goto L83
    L80:
        if (r134 > 270.0f) goto L82;
        r135 = r131;
        goto L83
    L54:
        if (r113.size() != 1) goto L56;
        d r163 = (d) CollectionsKt.first(r113);
        r122 = CollectionsKt.listOf(new d[]{d.a(r163, 0), d.a(r163, 100)});
        goto L63
    L56:
        d r164 = (d) CollectionsKt.first(r113);
        d r165 = (d) CollectionsKt.last(r113);
        List r166 = CollectionsKt.toMutableList(r113);
        if (r164.f556753b <= 0) goto L60;
        ListProtector.add(r166, 0, d.a(r164, 0));
    L60:
        if (r165.f556753b >= 100) goto L62;
        r166.add(d.a(r165, 100));
    L62:
        r122 = r166;
        goto L63
    L19:
        if (r106 == 270.0f) goto L36;
        double r167 = Math.tan(Math.toRadians(r106)) * (-1.0d);
        double r168 = (-(((double) r102.x) * r167)) - (((double) r102.y) * 1.0d);
        double r169 = 10;
        int r170 = MathKt.roundToInt(r167 * r169);
        int r171 = MathKt.roundToInt(1.0d * r169);
        int r172 = MathKt.roundToInt(r168 * r169);
        ArrayList r173 = new ArrayList();
        int r174 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r170, r171), r172);
        int r175 = 1;
    L22:
        if (r175 >= r174) goto L31;
        if ((r170 % r175) != 0) goto L30;
        if ((r171 % r175) != 0) goto L30;
        if ((r172 % r175) != 0) goto L30;
        r173.add(Integer.valueOf(r175));
    L30:
        r175 = r175 + 1;
        goto L22
    L31:
        Iterator r176 = r173.iterator();
        int r177 = 1;
    L33:
        if (r176.hasNext() == false) goto L35;
        r177 = ((Number) r176.next()).intValue() * 1;
        goto L33
    L35:
        r107 = new a(r170 / r177, r171 / r177, r172 / r177);
    L12:
        if (r106 < 269.0f) goto L17;
        if (r106 > 271.0f) goto L17;
        r106 = 270.0f;
        goto L17
    }
}
