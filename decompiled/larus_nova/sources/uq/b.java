package uq;

import android.graphics.Color;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.text.StringsKt;
import vq.d;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551169a = 0;

    static {
    }

    @JvmStatic
    public static final vq.b b(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L30;
        Float r101 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r100.get("degree"));
        if (r101 == null) goto L30;
        float r102 = r101.floatValue();
        Object r103 = r100.get("colors");
        if ((r103 instanceof List) == true) goto L9;
        r103 = null;
    L9:
        List r104 = (List) r103;
        if (r104 == null) goto L30;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L13:
        if (r107.hasNext() == false) goto L20;
        Map r108 = (Map) r107.next();
        Integer r109 = com.bytedance.android.ecom.arch.slice.render.util.b.g(com.bytedance.android.ecom.arch.slice.render.util.b.r(r108.get("color")));
        if (r109 == null) goto L19;
        int r110 = r109.intValue();
        Float r111 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r108.get("location"));
        if (r111 == null) goto L19;
        r106.add(new d(r110, Math.round(r111.floatValue() * 100)));
    L19:
        return null;
    L20:
        boolean r112 = true;
        if (r106.size() > 1) goto L24;
        r112 = false;
    L24:
        if (r112 == true) goto L27;
        r106 = null;
    L27:
        if (r106 == null) goto L30;
        return new vq.b(r102, r106);
    L30:
        return null;
    }

    public static float e(List r100) {
        if (r100 == null) goto L4;
        Object r101 = CollectionsKt.getOrNull(r100, 0);
    L6:
        return a(com.bytedance.android.ecom.arch.slice.render.util.b.c(r101, 1.0f), 1.0f);
    L4:
        r101 = null;
        goto L6
    }

    public static /* synthetic */ float g(List r100) {
        return f(r100, 1.0f);
    }

    @JvmStatic
    public static final Integer h(String r110) {
        if (r110 == null) goto L54;
        String r111 = r110.trim();
        int r100 = 1;
        if (r111.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L28;
        if (r111.length() < 7) goto L20;
        return Integer.valueOf(ColorProtector.parseColor(r111));
    L20:
        if (r111.length() != 4) goto L26;
        StringBuilder r103 = new StringBuilder("#");
        int r104 = r111.length();
    L22:
        if (r100 >= r104) goto L25;
        char r105 = r111.charAt(r100);
        r103.append(r105);
        r103.append(r105);
        r100 = r100 + 1;
        goto L22
    L25:
        return Integer.valueOf(ColorProtector.parseColor(r103.toString()));
    L26:
        return null;
    L28:
        if (r111.startsWith("rgb") == false) goto L54;
        int r106 = r111.indexOf(40, 3);
        if (r106 != (-1)) goto L32;
        return null;
    L32:
        int r107 = r111.lastIndexOf(41);
        if (r107 != (-1)) goto L35;
        return null;
    L35:
        int r108 = r106 + 1;
        if (r108 < r107) goto L38;
        return null;
    L38:
        String r112 = r111.substring(r108, r107);
        if (r112 == null) goto L53;
        List r113 = StringsKt.split$default(r112.trim(), new char[]{','}, false, 0, 6, null);
        if (r113.size() >= 3) goto L43;
    L51:
        return null;
    L43:
        if (r113.size() > 4) goto L51;
        int r109 = i((String) ListProtector.get(r113, 0), false);
        int r114 = i((String) ListProtector.get(r113, 1), false);
        int r115 = i((String) ListProtector.get(r113, 2), false);
        if (r113.size() <= 3) goto L48;
        int r116 = i((String) ListProtector.get(r113, 3), true);
    L50:
        return Integer.valueOf(Color.argb(r116, r109, r114, r115));
    L48:
        r116 = 255;
        goto L50
    L53:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L10:
        if (r111.charAt(0) != '#') goto L12;
        r102 = true;
        goto L14
    L7:
        r101 = false;
    L54:
        return null;
    }

    @JvmStatic
    public static final float a(float r100, float r101) {
        FloatCompanionObject r102 = FloatCompanionObject.INSTANCE;
        if (r100 > (-r102.getMAX_VALUE())) goto L5;
    L14:
        return r101;
    L5:
        if (r100 == r102.getNEGATIVE_INFINITY()) goto L14;
        if (r100 >= r102.getMAX_VALUE()) goto L14;
        if (r100 == r102.getPOSITIVE_INFINITY()) goto L14;
        if (Float.isNaN(r100) == true) goto L14;
        return r100;
    }

    @JvmStatic
    public static final a c(com.bytedance.android.ecom.arch.slice.render.context.b r100, String r101) {
    L16:
        a r102 = null;
    L17:
        if (r102 == null) goto L20;
        return r102;
    L20:
        return new a(0.0f, 0);
    L4:
        if ("auto".equals(r101) == false) goto L6;
        r102 = new a(0.0f, 0);     // Catch: Throwable -> L16
        goto L17
    L6:
        int r103 = r101.length();     // Catch: Throwable -> L16
        if (r103 > 1) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        a r105 = new a(CastFloatProtector.parseFloat(r101.substring(0, r101.length() - 1)), 2);     // Catch: Throwable -> L16
    L15:
        r102 = r105;
        goto L17
    L14:
        r105 = new a(SlcDimensExtensionsKt.c(Float.valueOf(CastFloatProtector.parseFloat(r101)), r100), 1);     // Catch: Throwable -> L16
        goto L15
    L9:
        if (r101.charAt(r103 - 1) != '%') goto L11;
        r104 = true;
        goto L12
    }

    @JvmStatic
    public static final a d(SlcTemplateContext r100, Object r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof Number) == false) goto L10;
        return new a(SlcDimensExtensionsKt.c((Number) r101, r100.m()), 1);
    L10:
        if ((r101 instanceof String) == true) goto L12;
        return null;
    L12:
        return c(r100.m(), (String) r101);
    }

    @JvmStatic
    public static final float f(List<?> r100, float r101) {
        List<?> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return r101;
    L12:
        if (r100.size() != 1) goto L14;
        float r104 = com.bytedance.android.ecom.arch.slice.render.util.b.c(ListProtector.get(r100, 0), r101);
    L16:
        return a(r104, r101);
    L14:
        r104 = com.bytedance.android.ecom.arch.slice.render.util.b.c(ListProtector.get(r100, 1), r101);
        goto L16
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @JvmStatic
    public static final int i(String r100, boolean r101) {
        if (r100 == null) goto L31;
        String r102 = r100.trim();
        if (r102.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        return 0;
    L9:
        int r104 = r102.length();
        if (r104 > 1) goto L12;
    L14:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        float r106 = CastFloatProtector.parseFloat(r102.substring(0, r102.length() - 1));
        float r107 = 2.55f;
    L21:
        r106 = r106 * r107;
    L23:
        if (r106 >= 0) goto L26;
        r106 = 0.0f;
    L29:
        return Math.round(r106);
    L26:
        if (r106 <= 255) goto L29;
        r106 = 255.0f;
        goto L29
    L18:
        r106 = CastFloatProtector.parseFloat(r102);
        if (r101 == false) goto L23;
        r107 = 255;
        goto L21
    L12:
        if (r102.charAt(r104 - 1) != '%') goto L14;
        r105 = true;
        goto L16
    L6:
        r103 = false;
        goto L7
    L31:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
