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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final void a(RoundFrameLayout r1, int r2, Function1<? super Integer, Integer> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$setHeight");
        Intrinsics.checkNotNullParameter(r3, "toSlcDp");
        if (r2 != SliceHeight.MATCH_PARENT.getHeight()) goto L6;
        r1.getLayoutParams().height = -1;
        return;
    L6:
        if (r2 != SliceHeight.WRAP_CONTENT.getHeight()) goto L8;
        r1.getLayoutParams().height = -2;
        return;
    L8:
        if (r2 <= 0) goto L13;
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        r4.height = ((Number) r3.invoke(Integer.valueOf(r2))).intValue();
        return;
    }

    public static final void b(View r5, Object r6, Function1<? super Integer, Integer> r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$setMargins");
        Intrinsics.checkNotNullParameter(r7, "toSlcDp");
        ViewGroup.LayoutParams r0 = null;
        int r1 = 0;
        if (r6 != null) goto L5;
    L55:
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L59;
        r0 = r8;
    L59:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r0;
        if (r2 == null) goto L69;
        r2.topMargin = 0;
        r2.rightMargin = 0;
        r2.bottomMargin = 0;
        r2.leftMargin = 0;
        r5.setLayoutParams(r2);
        return;
    L69:
        return;
    L5:
        if ((r6 instanceof List) == false) goto L55;
        List<Integer> r9 = a.f((List) r6);
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((Number) r7.invoke(Integer.valueOf(((Number) r10.next()).intValue()))).intValue()));
        goto L9
    L11:
        int r11 = r3.size();
        if (r11 != 1) goto L14;
        Integer r12 = (Integer) CollectionsKt.getOrNull(r3, 0);
        if (r12 == null) goto L47;
        r1 = r12.intValue();
    L47:
        ViewGroup.LayoutParams r13 = r5.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r0 = r13;
    L51:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r0;
        if (r4 == null) goto L68;
        r4.topMargin = r1;
        r4.rightMargin = r1;
        r4.bottomMargin = r1;
        r4.leftMargin = r1;
        r5.setLayoutParams(r4);
        return;
    L68:
        return;
    L14:
        if (r11 == 4) goto L22;
        ViewGroup.LayoutParams r14 = r5.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r0 = r14;
    L19:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r0;
        if (r15 == null) goto L64;
        r15.topMargin = 0;
        r15.rightMargin = 0;
        r15.bottomMargin = 0;
        r15.leftMargin = 0;
        r5.setLayoutParams(r15);
        return;
    L64:
        return;
    L22:
        Integer r16 = (Integer) CollectionsKt.getOrNull(r3, 0);
        if (r16 == null) goto L25;
        int r17 = r16.intValue();
    L26:
        Integer r18 = (Integer) CollectionsKt.getOrNull(r3, 1);
        if (r18 == null) goto L29;
        int r19 = r18.intValue();
    L30:
        Integer r20 = (Integer) CollectionsKt.getOrNull(r3, 2);
        if (r20 == null) goto L33;
        int r21 = r20.intValue();
    L34:
        Integer r22 = (Integer) CollectionsKt.getOrNull(r3, 3);
        if (r22 == null) goto L37;
        r1 = r22.intValue();
    L37:
        ViewGroup.LayoutParams r23 = r5.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L41;
        r0 = r23;
    L41:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r0;
        if (r24 == null) goto L66;
        r24.topMargin = r17;
        r24.rightMargin = r19;
        r24.bottomMargin = r21;
        r24.leftMargin = r1;
        r5.setLayoutParams(r24);
        return;
    L66:
        return;
    L33:
        r21 = 0;
        goto L34
    L29:
        r19 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    }

    public static final void c(View r4, Object r5, Function1<? super Integer, Integer> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$setPaddings");
        Intrinsics.checkNotNullParameter(r6, "toSlcDp");
        int r0 = 0;
        if (r5 != null) goto L5;
    L37:
        r4.setPadding(0, 0, 0, 0);
        return;
    L5:
        if ((r5 instanceof List) == false) goto L37;
        List<Integer> r7 = a.f((List) r5);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = ((ArrayList) r7).iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        r1.add(Integer.valueOf(((Number) r6.invoke(Integer.valueOf(((Number) r8.next()).intValue()))).intValue()));
        goto L9
    L11:
        int r9 = r1.size();
        if (r9 != 1) goto L14;
        Integer r10 = (Integer) CollectionsKt.getOrNull(r1, 0);
        if (r10 == null) goto L35;
        r0 = r10.intValue();
    L35:
        r4.setPadding(r0, r0, r0, r0);
        return;
    L14:
        if (r9 == 4) goto L16;
        r4.setPadding(0, 0, 0, 0);
        return;
    L16:
        Integer r11 = (Integer) CollectionsKt.getOrNull(r1, 0);
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
    L20:
        Integer r13 = (Integer) CollectionsKt.getOrNull(r1, 1);
        if (r13 == null) goto L23;
        int r14 = r13.intValue();
    L24:
        Integer r2 = (Integer) CollectionsKt.getOrNull(r1, 2);
        if (r2 == null) goto L27;
        int r3 = r2.intValue();
    L28:
        Integer r15 = (Integer) CollectionsKt.getOrNull(r1, 3);
        if (r15 == null) goto L31;
        r0 = r15.intValue();
    L31:
        r4.setPadding(r0, r12, r14, r3);
        return;
    L27:
        r3 = 0;
        goto L28
    L23:
        r14 = 0;
        goto L24
    L19:
        r12 = 0;
        goto L20
    }
}
