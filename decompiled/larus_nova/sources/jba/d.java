package jba;

import android.graphics.Rect;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498050a = 0;

    static {
    }

    public static a a(int r100, Integer r101, f r102) {
        if (r100 != 2) goto L31;
        if (r101 == null) goto L31;
        if (r101.intValue() != 0) goto L31;
        if (r102 == null) goto L29;
        if (r102.f498061e == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L29;
        if (Intrinsics.areEqual(r102.f498062f, RootDescription.ROOT_ELEMENT) == false) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == false) goto L25;
        int r104 = 0;
    L27:
        return new a(RangesKt.coerceAtLeast(r102.f498059c, 0), r104);
    L25:
        r104 = RangesKt.coerceAtLeast(r102.f498060d, 0);
        goto L27
    L19:
        if (Intrinsics.areEqual(r102.f498062f, "metrics") == true) goto L22;
        r103 = false;
    L29:
        return new a(0, 0);
    L31:
        return new a(0, 0);
    }

    public static f e(int r100, Integer r101, f r102, f r110) {
        if (r100 != 2) goto L48;
        if (r101 != null) goto L7;
        return r102;
    L7:
        if (r101.intValue() == 0) goto L10;
        return r102;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        boolean r103 = false;
        if (StringsKt.startsWith$default(r102.f498062f, "listener", false, 2, null) == true) goto L15;
        return r102;
    L15:
        if (r102.f498061e == false) goto L54;
        if (r110 != null) goto L20;
        return r102;
    L20:
        if (StringsKt.startsWith$default(r110.f498062f, "listener", false, 2, null) == true) goto L22;
        return r102;
    L22:
        if (r110.f498061e == false) goto L55;
        int r104 = r102.f498059c;
        if (r104 <= 0) goto L27;
    L30:
        boolean r105 = true;
    L31:
        int r106 = r110.f498059c;
        if (r106 <= 0) goto L34;
    L37:
        boolean r107 = true;
    L38:
        if (r104 == 0) goto L40;
    L43:
        if (r105 == true) goto L45;
        if (r107 == false) goto L45;
    L46:
        String r108 = r102.f498062f + "-stable";
        int r109 = r110.f498057a;
        int r111 = r110.f498058b;
        int r112 = r110.f498059c;
        int r113 = r110.f498060d;
        boolean r114 = r110.f498061e;
        Intrinsics.checkNotNullParameter(r108, "source");
        return new f(r109, r111, r112, r113, r114, r108);
    L45:
        if (r103 == true) goto L46;
        return r102;
    L40:
        if (r102.f498060d <= 0) goto L43;
        if (r106 <= 0) goto L43;
        r103 = true;
        goto L43
    L34:
        if (r110.f498060d > 0) goto L37;
        r107 = false;
        goto L38
    L27:
        if (r102.f498060d > 0) goto L30;
        r105 = false;
        goto L31
    L55:
        return r102;
    L54:
        return r102;
    L48:
        return r102;
    }

    public static c b(float r100, float r101, float r102, float r103, float r104, float r105) {
        float r106 = RangesKt.coerceAtLeast(r100, 0.0f);
        float r107 = RangesKt.coerceAtLeast(r101, 0.0f);
        return new c(Math.max(r106, RangesKt.coerceAtLeast(r102, 0.0f) - r107), Math.max(r106, RangesKt.coerceAtLeast(r103, 0.0f) - r107), Math.max(r106, RangesKt.coerceAtLeast(r104, 0.0f) - r107), Math.max(r106, RangesKt.coerceAtLeast(r105, 0.0f) - r107));
    }

    public static b c(int r100, int r101, int r102, int r103, List r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r104, "boundingRects");
        if (r100 < 28) goto L34;
        if (r101 <= 0) goto L34;
        int r107 = RangesKt.coerceIn(Math.max(r102, r105), 0, r101);
        int r108 = RangesKt.coerceIn(Math.max(r103, r106), 0, r101);
        boolean r109 = true;
        if (r107 != 0) goto L9;
        boolean r110 = true;
    L10:
        if (r108 == 0) goto L13;
        r109 = false;
    L13:
        Iterator r111 = r104.iterator();
    L15:
        if (r111.hasNext() == false) goto L32;
        Rect r112 = (Rect) r111.next();
        if (r112.isEmpty() == true) goto L15;
        if (r110 == true) goto L21;
    L25:
        if (r109 == false) goto L15;
        if (r112.right < r101) goto L15;
        int r113 = r112.left;
        if (r113 >= r101) goto L15;
        r108 = Math.max(r108, RangesKt.coerceIn(r101 - r113, 0, r101));
        goto L15
    L21:
        if (r112.left > 0) goto L25;
        int r114 = r112.right;
        if (r114 <= 0) goto L25;
        r107 = Math.max(r107, RangesKt.coerceIn(r114, 0, r101));
        goto L25
    L32:
        return new b(r107, r108);
    L9:
        r110 = false;
    L34:
        return new b(0, 0);
    }

    public static e d(int r100, int r101, int r110, b r111, int r112, int r113, a r114) {
        Intrinsics.checkNotNullParameter(r111, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r114, "consumedNavigationBarInsets");
        if (r100 != 2) goto L5;
        Integer r102 = Integer.valueOf(Math.min(r101, r110));
        if (r102.intValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        int r104 = -1;
        if (r102 == null) goto L16;
        int r105 = r102.intValue();
    L17:
        if (r101 <= 0) goto L20;
        if (r105 <= 0) goto L20;
        int r106 = RangesKt.coerceAtLeast(r101 - r105, 0);
    L21:
        int r107 = RangesKt.coerceAtMost((RangesKt.coerceAtLeast(r111.f498045b, 0) + RangesKt.coerceAtLeast(r112, 0)) + RangesKt.coerceAtLeast(r114.f498042a, 0), r106);
        if (r110 <= 0) goto L24;
        int r108 = RangesKt.coerceIn(r113, 0, r110 / 2);
    L25:
        if (r110 <= 0) goto L28;
        int r109 = r110 - r108;
        r104 = RangesKt.coerceAtLeast(r109 - (RangesKt.coerceAtLeast(r114.f498043b, 0) + r108), 1);
    L28:
        return new e(r105, r104, 53, r107, r108, true);
    L24:
        r108 = 0;
    L20:
        r106 = 0;
        goto L21
    L16:
        r105 = -1;
        goto L17
    L9:
        r103 = false;
        goto L10
    L5:
        return new e(-1, -1, 8388659, 0, 0, false);
    }
}
