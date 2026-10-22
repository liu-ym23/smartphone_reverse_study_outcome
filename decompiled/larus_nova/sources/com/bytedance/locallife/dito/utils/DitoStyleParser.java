package com.bytedance.locallife.dito.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.baseview.RoundFrameLayout;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoStyleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f258679a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f258680a = null;

        static {
            int[] r100 = new int[LinearOrientation.values().length];
            r100[LinearOrientation.ORIENTATION_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[LinearOrientation.ORIENTATION_TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[LinearOrientation.ORIENTATION_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[LinearOrientation.ORIENTATION_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[LinearOrientation.ORIENTATION_RIGHT_BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[LinearOrientation.ORIENTATION_RIGHT_TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[LinearOrientation.ORIENTATION_LEFT_BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[LinearOrientation.ORIENTATION_LEFT_TOP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f258680a = r100;
        }
    }

    static {
    }

    public DitoStyleParser() {
    }

    public static Integer e(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L15;
    L12:
        return null;
    L15:
        return Integer.valueOf(Color.parseColor(r100));
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static float[] c(float[] r100, float[] r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L18;
        List r104 = ArraysKt.toList(r101);
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L31;
        r105.add(Float.valueOf(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(((Number) r106.next()).floatValue() / 100, 1.0f), 0.0f)));
        goto L15
    L31:
        return CollectionsKt.toFloatArray(r105);
    L18:
        if (r100 != null) goto L20;
    L26:
        if (r102 == true) goto L32;
        return null;
    L32:
        return new float[r100.length];
    L20:
        if (r100.length != 0) goto L22;
        boolean r107 = true;
    L24:
        if ((!r107) != true) goto L26;
        r102 = true;
        goto L26
    L22:
        r107 = false;
        goto L24
    L5:
        if (r101.length != 0) goto L7;
        boolean r108 = true;
    L9:
        if ((!r108) != true) goto L11;
        r103 = true;
        goto L12
    L7:
        r108 = false;
        goto L9
    }

    public static final Bitmap a(Bitmap r100, float r101, DitoViewModel r102) {
        if (r100 == null) goto L31;
        RecyclerView r103 = r102.f258035a.f257790l;
        if (r103 == null) goto L8;
        Integer r104 = Integer.valueOf(r103.getWidth());
    L9:
        if (r104 != null) goto L11;
    L12:
        DitoFragment r105 = r102.f258035a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        RoundFrameLayout r106 = r105.ya0();
        if (r106 == null) goto L15;
        r104 = Integer.valueOf(r106.getWidth());
    L16:
        if (r104 != null) goto L18;
        return null;
    L18:
        if (r104.intValue() != 0) goto L21;
        return null;
    L21:
        if (r100.getWidth() == r104.intValue()) goto L29;
        if (r101 != 0.0f) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == true) goto L29;
        r100 = Bitmap.createScaledBitmap(r100, r104.intValue(), (int) (r104.intValue() / r101), true);
        goto L29
    L25:
        r107 = false;
    L29:
        return r100;
    L15:
        r104 = null;
        goto L16
    L11:
        if (r104.intValue() != 0) goto L16;
    L8:
        r104 = null;
        goto L9
    L31:
        return null;
    }

    public static LayerDrawable b(Drawable r100, Drawable r101, Drawable r102) {
        ArrayList r103 = new ArrayList();
        if (r100 == null) goto L5;
        r103.add(r100);
    L5:
        if (r101 == null) goto L7;
        r103.add(r101);
    L7:
        if (r102 == null) goto L10;
        r103.add(r102);
    L10:
        if ((!r103.isEmpty()) == false) goto L16;
        Object[] r104 = r103.toArray(new Drawable[0]);
        if (r104 == null) goto L15;
        return new LayerDrawable((Drawable[]) r104);
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        return null;
    }

    public static com.bytedance.locallife.dito.data.q h(DitoStyle r100, final DitoViewModel r101, com.bytedance.locallife.dito.data.q r110) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        final com.bytedance.locallife.dito.data.q r102 = new com.bytedance.locallife.dito.data.q();
        Integer r103 = e(DitoExtKt.d(r100.getNodeBackgroundColor(), r101.f258035a.getContext(), r101.c()));
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
        Paint r105 = new Paint();
        r105.setColor(r104);
        r105.setAntiAlias(true);
        r102.f258233a = r105;
    L5:
        String r106 = r100.getImageUrl();
        r102.f258234b = r106;
        Context r107 = r101.f258035a.getContext();
        Function1<Bitmap, Unit> r108 = new DitoStyleParser$toGroupBackgroundData$1$1$2(r102, r101);
        if (r106 != null) goto L8;
    L11:
        boolean r109 = true;
    L12:
        ArrayList r111 = null;
        if (r109 == true) goto L25;
        if (r107 == null) goto L25;
        if (r110 != null) goto L18;
    L22:
        Dito r112 = Dito.f257280a;
        lp6.d r113 = (lp6.d) Dito.a().a(lp6.d.class);
        if (r113 == null) goto L26;
        r113.a(r106, r107, new m(r108));
    L26:
        g(r100.getLinearGradient(), r101.f258035a.getContext(), r101.c(), new DitoStyleParser$toGroupBackgroundData$1$1$3(r102));
        List<Float> r114 = r100.getCornerRadius();
        if (r114 != null) goto L29;
    L32:
        float[] r115 = null;
    L33:
        r102.f258248p = r115;
        f(r100.getBorder(), r101.f258035a.getContext(), r101.c(), new DitoStyleParser$toGroupBackgroundData$1$1$4(r102));
        List<Float> r116 = r100.getMargin();
        if (r116 == null) goto L39;
        List<Float> r117 = r116;
        r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r118 = r117.iterator();
    L37:
        if (r118.hasNext() == false) goto L39;
        r111.add(Integer.valueOf(e.b(Float.valueOf(((Number) r118.next()).floatValue()))));
    L39:
        r102.f258252t = r111;
        return r102;
    L29:
        if (r114.size() != 4) goto L32;
        r115 = new float[]{e.b((Number) ListProtector.get(r114, 0)), e.b((Number) ListProtector.get(r114, 0)), e.b((Number) ListProtector.get(r114, 1)), e.b((Number) ListProtector.get(r114, 1)), e.b((Number) ListProtector.get(r114, 2)), e.b((Number) ListProtector.get(r114, 2)), e.b((Number) ListProtector.get(r114, 3)), e.b((Number) ListProtector.get(r114, 3))};
        goto L33
    L18:
        if (Intrinsics.areEqual(r106, r110.f258234b) == false) goto L22;
        Bitmap r119 = r110.f258235c;
        if (r119 == null) goto L22;
        r108.invoke(r119);
    L25:
        r108.invoke(null);
        goto L26
    L8:
        if (r106.length() == 0) goto L11;
        r109 = false;
        goto L12
    }

    public static void f(String r100, Context r101, Map r110, Function2 r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r100 == null) goto L22;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L23;
        String r103 = new Regex("\\s+").replace(r102, " ");
        if (r103 == null) goto L24;
        List r104 = StringsKt.split$default(r103, new String[]{" "}, false, 0, 6, null);
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.size() != 2) goto L26;
        String r105 = (String) ListProtector.get(r104, 0);
        if (r105 == null) goto L19;
        String r106 = StringsKt.removeSuffix(r105, GXTemplateKey.GAIAX_PX);
        if (r106 == null) goto L19;
        Float r107 = StringsKt.toFloatOrNull(r106);
        if (r107 == null) goto L19;
        Float r108 = Float.valueOf(e.b(r107));
    L20:
        r111.invoke(e(DitoExtKt.d((String) ListProtector.get(r104, 1), r101, r110)), r108);
        return;
    L19:
        r108 = null;
        goto L20
    L26:
        return;
    L24:
        return;
    L23:
        return;
    }

    public static void g(String r210, Context r211, Map r212, Function4 r213) {
        Intrinsics.checkNotNullParameter(r213, "result");
        int r100 = 1;
        if (r210 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (StringsKt.startsWith(r210, "linear-gradient", true) == true) goto L14;
        return;
    L14:
        LinearOrientation r110 = LinearOrientation.ORIENTATION_BOTTOM;
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        int r102 = StringsKt.indexOf$default(r210, "(", 0, false, 6, null) + 1;
        int r103 = StringsKt.indexOf$default(r210, ")", 0, false, 6, null);
        float[] r104 = null;
        if (r210 == null) goto L35;
        String r105 = r210.substring(r102, r103);     // Catch: IndexOutOfBoundsException -> L36
        if (r105 == null) goto L33;
        List r106 = StringsKt.split$default(StringsKt.trim(r105).toString(), new String[]{","}, false, 0, 6, null);     // Catch: IndexOutOfBoundsException -> L36
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: IndexOutOfBoundsException -> L36
        Iterator r108 = r106.iterator();     // Catch: IndexOutOfBoundsException -> L36
    L21:
        if (r108.hasNext() == false) goto L27;
        String r109 = new Regex("\\s+").replace((String) r108.next(), " ");     // Catch: IndexOutOfBoundsException -> L36
        if (r109 == null) goto L26;
        r107.add(StringsKt.trim(r109).toString());     // Catch: IndexOutOfBoundsException -> L36
        goto L21
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: IndexOutOfBoundsException -> L36
    L27:
        Object[] r114 = r107.toArray(new String[0]);     // Catch: IndexOutOfBoundsException -> L36
        if (r114 == null) goto L31;
        String[] r115 = (String[]) r114;     // Catch: IndexOutOfBoundsException -> L36
    L37:
        if (r115 == null) goto L84;
        int r116 = r115.length;
        int r117 = 0;
        int r118 = 0;
    L39:
        if (r117 >= r116) goto L84;
        String r119 = r115[r117];
        int r120 = r118 + 1;
        if (r118 == 0) goto L43;
    L53:
        List r121 = StringsKt.split$default(r119, new String[]{" "}, false, 0, 6, null);
        if (((r121.isEmpty() ? 1 : 0) ^ r100) == 0) goto L82;
        Integer r122 = e(DitoExtKt.d((String) ListProtector.get(r121, 0), r211, r212));
        if (r122 == null) goto L59;
        r111.add(Integer.valueOf(r122.intValue()));
    L59:
        if (r121.size() <= r100) goto L82;
        String r123 = (String) ListProtector.get(r121, r100);
        String[] r214 = r115;
        if (StringsKt.endsWith$default(r123, GXTemplateKey.GAIAX_PX, false, 2, null) == false) goto L72;
        if (r123 == null) goto L68;
        String r124 = StringsKt.removeSuffix(r123, GXTemplateKey.GAIAX_PX);
        if (r124 == null) goto L68;
        Float r125 = StringsKt.toFloatOrNull(r124);
        if (r125 == null) goto L68;
        Float r126 = Float.valueOf(e.b(r125));
    L69:
        if (r126 == null) goto L71;
        r112.add(Float.valueOf(r126.floatValue()));
    L71:
        float[] r127 = null;
    L83:
        r117 = r117 + 1;
        r115 = r214;
        r118 = r120;
        r104 = r127;
        r100 = 1;
    L68:
        r126 = null;
        goto L69
    L72:
        r127 = null;
        if (StringsKt.endsWith$default(r123, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L83;
        if (r123 == null) goto L78;
        String r128 = StringsKt.removeSuffix(r123, GXTemplateKey.GAIAX_PE);
        if (r128 == null) goto L78;
        Float r129 = StringsKt.toFloatOrNull(r128);
    L79:
        if (r129 == null) goto L83;
        r113.add(Float.valueOf(r129.floatValue()));
    L78:
        r129 = null;
    L82:
        r214 = r115;
        goto L71
    L43:
        if (StringsKt.startsWith$default(r119, RemoteMessageConst.TO, false, 2, r104) == false) goto L53;
        LinearOrientation[] r130 = LinearOrientation.values();
        int r131 = r130.length;
        int r132 = 0;
    L45:
        if (r132 >= r131) goto L50;
        LinearOrientation r133 = r130[r132];
        if (Intrinsics.areEqual(r133.getOrientation(), r119) == true) goto L48;
        r132 = r132 + 1;
        goto L45
    L48:
        r110 = r133;
    L51:
        if (r110 != null) goto L82;
        r110 = LinearOrientation.ORIENTATION_BOTTOM;
        goto L82
    L50:
        r110 = null;
    L84:
        float[] r134 = r104;
        int[] r135 = CollectionsKt.toIntArray(r111);
        if (r111.size() == r112.size()) goto L87;
        float[] r136 = r134;
    L89:
        if (r111.size() == r113.size()) goto L91;
        float[] r137 = r134;
    L92:
        r213.invoke(r110, r135, r136, r137);
        return;
    L91:
        r137 = CollectionsKt.toFloatArray(r113);
        goto L92
    L87:
        r136 = CollectionsKt.toFloatArray(r112);
        goto L89
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: IndexOutOfBoundsException -> L36
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: IndexOutOfBoundsException -> L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: IndexOutOfBoundsException -> L36
    L36:
        r115 = null;
        goto L37
    L5:
        if (r210.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LinearGradient d(final LinearOrientation r100, final Rect r110, final int[] r111, final float[] r112, final float[] r113) {
        Intrinsics.checkNotNullParameter(r110, "boundsRect");
        Intrinsics.checkNotNullParameter(r111, "colors");
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        Function4<Float, Float, Float, Float, Unit> r102 = new DitoStyleParser$getLinearGradient$1(r101, r111, r100, r112, r113, r110);
        if (r100 != null) goto L5;
        int r103 = -1;
    L6:
        switch(r103) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        float r104 = r110.left;
        float r114 = r110.top;
        int r115 = r110.bottom;
    L18:
        float r116 = r115;
        float r117 = r104;
    L19:
        r102.invoke(Float.valueOf(r104), Float.valueOf(r114), Float.valueOf(r117), Float.valueOf(r116));
        return (LinearGradient) r101.element;
    L8:
        r104 = r110.right;
        r114 = r110.bottom;
        r117 = r110.left;
        int r118 = r110.top;
    L12:
        r116 = r118;
        goto L19
    L9:
        r104 = r110.right;
        r114 = r110.top;
        r117 = r110.left;
        r118 = r110.bottom;
        goto L12
    L10:
        r104 = r110.left;
        r114 = r110.bottom;
        r117 = r110.right;
        r118 = r110.top;
        goto L12
    L11:
        r104 = r110.left;
        r114 = r110.top;
        r117 = r110.right;
        r118 = r110.bottom;
        goto L12
    L13:
        r104 = r110.right;
        r114 = r110.top;
        int r119 = r110.left;
    L15:
        r117 = r119;
        r116 = r114;
        goto L19
    L14:
        r104 = r110.left;
        r114 = r110.top;
        r119 = r110.right;
        goto L15
    L16:
        r104 = r110.left;
        r114 = r110.bottom;
        r115 = r110.top;
        goto L18
    L17:
        r104 = r110.left;
        r114 = r110.top;
        r115 = r110.bottom;
        goto L18
    L5:
        r103 = a.f258680a[r100.ordinal()];
        goto L6
    }
}
