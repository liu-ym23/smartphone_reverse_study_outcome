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

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f568314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f568315b = null;

    static {
        f568314a = MapsKt.mapOf(new Pair[]{TuplesKt.to(-2, "wrap_content"), TuplesKt.to(-1, "match_parent")});
        f568315b = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, "layout_above"), TuplesKt.to(4, "layout_alignBaseline"), TuplesKt.to(8, "layout_alignBottom"), TuplesKt.to(5, "layout_alignLeft"), TuplesKt.to(12, "layout_alignParentBottom"), TuplesKt.to(9, "layout_alignParentLeft"), TuplesKt.to(11, "layout_alignParentRight"), TuplesKt.to(10, "layout_alignParentTop"), TuplesKt.to(7, "layout_alignRight"), TuplesKt.to(6, "layout_alignTop"), TuplesKt.to(3, "layout_below"), TuplesKt.to(14, "layout_centerHorizontal"), TuplesKt.to(13, "layout_center"), TuplesKt.to(15, "layout_centerVertical"), TuplesKt.to(0, "layout_toLeftOf"), TuplesKt.to(1, "layout_toRightOf"), TuplesKt.to(18, "layout_alignStart"), TuplesKt.to(19, "layout_alignEnd"), TuplesKt.to(20, "layout_alignParentStart"), TuplesKt.to(21, "layout_alignParentEnd"), TuplesKt.to(16, "layout_toStartOf"), TuplesKt.to(17, "layout_toEndOf")});
    }

    public static List c(ViewGroup.MarginLayoutParams r100) {
        ArrayList r101 = new ArrayList();
        r101.addAll(d(r100));
        int r102 = r100.leftMargin;
        if (r102 != 0) goto L5;
    L12:
        Integer r103 = Integer.valueOf(r102);
        boolean r104 = false;
        if (r103.intValue() == 0) goto L15;
        boolean r105 = true;
    L16:
        Integer r106 = null;
        if (r105 == true) goto L20;
        r103 = null;
    L20:
        if (r103 == null) goto L22;
        e(r103.intValue());
        r101.add(new f("layout_marginLeft"));
    L22:
        Integer r107 = Integer.valueOf(r100.topMargin);
        if (r107.intValue() == 0) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L31;
        e(r107.intValue());
        r101.add(new f("layout_marginTop"));
    L31:
        Integer r109 = Integer.valueOf(r100.rightMargin);
        if (r109.intValue() == 0) goto L34;
        boolean r110 = true;
    L35:
        if (r110 == true) goto L38;
        r109 = null;
    L38:
        if (r109 == null) goto L40;
        e(r109.intValue());
        r101.add(new f("layout_marginRight"));
    L40:
        Integer r111 = Integer.valueOf(r100.bottomMargin);
        if (r111.intValue() == 0) goto L43;
        r104 = true;
    L43:
        if (r104 == false) goto L45;
        r106 = r111;
    L45:
        if (r106 == null) goto L47;
        e(r106.intValue());
        r101.add(new f("layout_marginBottom"));
    L47:
        return r101;
    L34:
        r110 = false;
        goto L35
    L25:
        r108 = false;
        goto L26
    L15:
        r105 = false;
        goto L16
    L5:
        if (r102 != r100.topMargin) goto L12;
        if (r102 != r100.bottomMargin) goto L12;
        if (r102 != r100.rightMargin) goto L12;
        e(r100.leftMargin);
        r101.add(new f("layout_margin"));
        return r101;
    }

    public static List d(ViewGroup.LayoutParams r100) {
        ArrayList r101 = new ArrayList();
        Map<Integer, String> r102 = f568314a;
        if (r102.get(Integer.valueOf(r100.width)) == null) goto L5;
        r101.add(new f("layout_width"));
    L7:
        if (r102.get(Integer.valueOf(r100.height)) == null) goto L9;
        r101.add(new f("layout_height"));
    L10:
        return r101;
    L9:
        e(r100.height);
        r101.add(new f("layout_height"));
        goto L10
    L5:
        e(r100.width);
        r101.add(new f("layout_width"));
        goto L7
    }

    public static int e(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public static void a(int[] r100, int r101, ArrayList r102) {
        if (r100[r101] != (-1)) goto L9;
        String r103 = f568315b.get(Integer.valueOf(r101));
        if (r103 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r102.add(new f(r103));
        return;
    }

    public static void b(Context r100, int[] r101, int r102, ArrayList r103) {
        int r104 = r101[r102];
        if (r104 == 0) goto L9;
        int r105 = d.f568316a;
        d.a(r104, r100.getResources());
        String r106 = f568315b.get(Integer.valueOf(r102));
        if (r106 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r103.add(new f(r106));
        return;
    }
}
