package nc3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.commentv3.data.SliceHeight;
import com.bytedance.android.shopping.commentv3.view.RoundFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final void a(RoundFrameLayout r100, int r101, Function1<? super Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setHeight");
        Intrinsics.checkNotNullParameter(r102, "toSlcDp");
        if (r101 != SliceHeight.MATCH_PARENT.getHeight()) goto L6;
        r100.getLayoutParams().height = -1;
        return;
    L6:
        if (r101 != SliceHeight.WRAP_CONTENT.getHeight()) goto L8;
        r100.getLayoutParams().height = -2;
        return;
    L8:
        if (r101 <= 0) goto L13;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.height = r102.invoke(Integer.valueOf(r101)).intValue();
        return;
    }

    public static final void b(View r100, Object r101, Function1<? super Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setMargins");
        Intrinsics.checkNotNullParameter(r102, "toSlcDp");
        ViewGroup.LayoutParams r103 = null;
        int r104 = 0;
        if (r101 != null) goto L5;
    L55:
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L59;
        r103 = r105;
    L59:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r103;
        if (r106 == null) goto L69;
        r106.topMargin = 0;
        r106.rightMargin = 0;
        r106.bottomMargin = 0;
        r106.leftMargin = 0;
        r100.setLayoutParams(r106);
        return;
    L69:
        return;
    L5:
        if ((r101 instanceof List) == false) goto L55;
        List<Integer> r107 = a.f((List) r101);
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L9:
        if (r109.hasNext() == false) goto L11;
        r108.add(Integer.valueOf(r102.invoke(Integer.valueOf(((Number) r109.next()).intValue())).intValue()));
        goto L9
    L11:
        int r110 = r108.size();
        if (r110 != 1) goto L14;
        Integer r111 = (Integer) CollectionsKt.getOrNull(r108, 0);
        if (r111 == null) goto L47;
        r104 = r111.intValue();
    L47:
        ViewGroup.LayoutParams r112 = r100.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r103 = r112;
    L51:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r103;
        if (r113 == null) goto L68;
        r113.topMargin = r104;
        r113.rightMargin = r104;
        r113.bottomMargin = r104;
        r113.leftMargin = r104;
        r100.setLayoutParams(r113);
        return;
    L68:
        return;
    L14:
        if (r110 == 4) goto L22;
        ViewGroup.LayoutParams r114 = r100.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r103 = r114;
    L19:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r103;
        if (r115 == null) goto L64;
        r115.topMargin = 0;
        r115.rightMargin = 0;
        r115.bottomMargin = 0;
        r115.leftMargin = 0;
        r100.setLayoutParams(r115);
        return;
    L64:
        return;
    L22:
        Integer r116 = (Integer) CollectionsKt.getOrNull(r108, 0);
        if (r116 == null) goto L25;
        int r117 = r116.intValue();
    L26:
        Integer r118 = (Integer) CollectionsKt.getOrNull(r108, 1);
        if (r118 == null) goto L29;
        int r119 = r118.intValue();
    L30:
        Integer r120 = (Integer) CollectionsKt.getOrNull(r108, 2);
        if (r120 == null) goto L33;
        int r121 = r120.intValue();
    L34:
        Integer r122 = (Integer) CollectionsKt.getOrNull(r108, 3);
        if (r122 == null) goto L37;
        r104 = r122.intValue();
    L37:
        ViewGroup.LayoutParams r123 = r100.getLayoutParams();
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == false) goto L41;
        r103 = r123;
    L41:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r103;
        if (r124 == null) goto L66;
        r124.topMargin = r117;
        r124.rightMargin = r119;
        r124.bottomMargin = r121;
        r124.leftMargin = r104;
        r100.setLayoutParams(r124);
        return;
    L66:
        return;
    L33:
        r121 = 0;
        goto L34
    L29:
        r119 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    }

    public static final void c(View r100, Object r101, Function1<? super Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setPaddings");
        Intrinsics.checkNotNullParameter(r102, "toSlcDp");
        int r103 = 0;
        if (r101 != null) goto L5;
    L37:
        r100.setPadding(0, 0, 0, 0);
        return;
    L5:
        if ((r101 instanceof List) == false) goto L37;
        List<Integer> r104 = a.f((List) r101);
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = ((ArrayList) r104).iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        r105.add(Integer.valueOf(r102.invoke(Integer.valueOf(((Number) r106.next()).intValue())).intValue()));
        goto L9
    L11:
        int r107 = r105.size();
        if (r107 != 1) goto L14;
        Integer r108 = (Integer) CollectionsKt.getOrNull(r105, 0);
        if (r108 == null) goto L35;
        r103 = r108.intValue();
    L35:
        r100.setPadding(r103, r103, r103, r103);
        return;
    L14:
        if (r107 == 4) goto L16;
        r100.setPadding(0, 0, 0, 0);
        return;
    L16:
        Integer r109 = (Integer) CollectionsKt.getOrNull(r105, 0);
        if (r109 == null) goto L19;
        int r110 = r109.intValue();
    L20:
        Integer r111 = (Integer) CollectionsKt.getOrNull(r105, 1);
        if (r111 == null) goto L23;
        int r112 = r111.intValue();
    L24:
        Integer r113 = (Integer) CollectionsKt.getOrNull(r105, 2);
        if (r113 == null) goto L27;
        int r114 = r113.intValue();
    L28:
        Integer r115 = (Integer) CollectionsKt.getOrNull(r105, 3);
        if (r115 == null) goto L31;
        r103 = r115.intValue();
    L31:
        r100.setPadding(r103, r110, r112, r114);
        return;
    L27:
        r114 = 0;
        goto L28
    L23:
        r112 = 0;
        goto L24
    L19:
        r110 = 0;
        goto L20
    }
}
