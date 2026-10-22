package yl3;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wl3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final Map<Integer, String> a = null;
    public static final Map<Integer, String> b = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(-2, "wrap_content"), TuplesKt.to(-1, "match_parent")});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, "layout_above"), TuplesKt.to(4, "layout_alignBaseline"), TuplesKt.to(8, "layout_alignBottom"), TuplesKt.to(5, "layout_alignLeft"), TuplesKt.to(12, "layout_alignParentBottom"), TuplesKt.to(9, "layout_alignParentLeft"), TuplesKt.to(11, "layout_alignParentRight"), TuplesKt.to(10, "layout_alignParentTop"), TuplesKt.to(7, "layout_alignRight"), TuplesKt.to(6, "layout_alignTop"), TuplesKt.to(3, "layout_below"), TuplesKt.to(14, "layout_centerHorizontal"), TuplesKt.to(13, "layout_center"), TuplesKt.to(15, "layout_centerVertical"), TuplesKt.to(0, "layout_toLeftOf"), TuplesKt.to(1, "layout_toRightOf"), TuplesKt.to(18, "layout_alignStart"), TuplesKt.to(19, "layout_alignEnd"), TuplesKt.to(20, "layout_alignParentStart"), TuplesKt.to(21, "layout_alignParentEnd"), TuplesKt.to(16, "layout_toStartOf"), TuplesKt.to(17, "layout_toEndOf")});
    }

    public static List c(ViewGroup.MarginLayoutParams r7) {
        ArrayList r0 = new ArrayList();
        r0.addAll(d(r7));
        int r1 = r7.leftMargin;
        if (r1 != 0) goto L5;
    L12:
        Integer r2 = Integer.valueOf(r1);
        boolean r3 = false;
        if (r2.intValue() == 0) goto L15;
        boolean r4 = true;
    L16:
        Integer r5 = null;
        if (r4 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L22;
        e(r2.intValue());
        r0.add(new f("layout_marginLeft"));
    L22:
        Integer r6 = Integer.valueOf(r7.topMargin);
        if (r6.intValue() == 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L29;
        r6 = null;
    L29:
        if (r6 == null) goto L31;
        e(r6.intValue());
        r0.add(new f("layout_marginTop"));
    L31:
        Integer r9 = Integer.valueOf(r7.rightMargin);
        if (r9.intValue() == 0) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == true) goto L38;
        r9 = null;
    L38:
        if (r9 == null) goto L40;
        e(r9.intValue());
        r0.add(new f("layout_marginRight"));
    L40:
        Integer r11 = Integer.valueOf(r7.bottomMargin);
        if (r11.intValue() == 0) goto L43;
        r3 = true;
    L43:
        if (r3 == false) goto L45;
        r5 = r11;
    L45:
        if (r5 == null) goto L47;
        e(r5.intValue());
        r0.add(new f("layout_marginBottom"));
    L47:
        return r0;
    L34:
        r10 = false;
        goto L35
    L25:
        r8 = false;
        goto L26
    L15:
        r4 = false;
        goto L16
    L5:
        if (r1 != r7.topMargin) goto L12;
        if (r1 != r7.bottomMargin) goto L12;
        if (r1 != r7.rightMargin) goto L12;
        e(r7.leftMargin);
        r0.add(new f("layout_margin"));
        return r0;
    }

    public static List d(ViewGroup.LayoutParams r5) {
        ArrayList r0 = new ArrayList();
        Map<Integer, String> r1 = a;
        if (r1.get(Integer.valueOf(r5.width)) == null) goto L5;
        r0.add(new f("layout_width"));
    L7:
        if (r1.get(Integer.valueOf(r5.height)) == null) goto L9;
        r0.add(new f("layout_height"));
    L10:
        return r0;
    L9:
        e(r5.height);
        r0.add(new f("layout_height"));
        goto L10
    L5:
        e(r5.width);
        r0.add(new f("layout_width"));
        goto L7
    }

    public static int e(int r2) {
        Resources r0 = Resources.getSystem();
        return (int) (r2 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public static void a(int[] r1, int r2, ArrayList r3) {
        if (r1[r2] != (-1)) goto L9;
        String r4 = b.get(Integer.valueOf(r2));
        if (r4 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r3.add(new f(r4));
        return;
    }

    public static void b(Context r1, int[] r2, int r3, ArrayList r4) {
        int r5 = r2[r3];
        if (r5 == 0) goto L9;
        int r0 = d.a;
        d.a(r5, r1.getResources());
        String r6 = b.get(Integer.valueOf(r3));
        if (r6 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r4.add(new f(r6));
        return;
    }
}
