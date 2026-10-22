package zh2;

import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.ConstraintLayoutParams;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.DynamicElementLayoutParams;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.DynamicLayoutDTO;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.DynamicLayoutParams;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.ECLiveDynamicLayoutHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public ECPromotionHeaderLayoutControl a;
    public final Map<String, Integer> b;

    public static final class a {
    }

    static {
    }

    public final zh2.a b() {
        return a("entry");
    }

    public final zh2.a d() {
        return a("shop_info");
    }

    public b() {
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("entry", 2131378091), TuplesKt.to("shop_info", 2131363230), TuplesKt.to("search_bar", 2131385326), TuplesKt.to("parent", 0)});
    }

    public final zh2.a a(String r28) {
        Lazy r2 = ECLiveDynamicLayoutHelper.a;
        ECPromotionHeaderLayoutControl r3 = this.a;
        if (r3 == null) goto L5;
        int r4 = r3.getHeaderStyle();
    L6:
        Intrinsics.checkNotNullParameter(r28, "elementName");
        DynamicLayoutDTO r5 = (DynamicLayoutDTO) ECLiveDynamicLayoutHelper.a.getValue();
        if (r5 != null) goto L9;
    L49:
        ConstraintLayoutParams r1 = null;
    L50:
        Map<String, Integer> r6 = this.b;
        Intrinsics.checkNotNullParameter(r6, "convertMap");
        if (r1 == null) goto L63;
        Integer r7 = r1.getWidth();
        Integer r8 = r1.getHeight();
        Integer r9 = r6.get(r1.getCenterX());
        Integer r10 = r6.get(r1.getCenterY());
        Integer r21 = r1.getLeftMargin();
        Integer r25 = r1.getRightMargin();
        Integer r13 = r1.getTopMargin();
        Integer r17 = r1.getBottomMargin();
        Integer r22 = r1.getLeftPadding();
        Integer r26 = r1.getRightPadding();
        return new zh2.a(r7, r8, r9, r10, r6.get(r1.getTopToTop()), r6.get(r1.getTopToBottom()), r13, r1.getTopPadding(), r6.get(r1.getBottomToTop()), r6.get(r1.getBottomToBottom()), r17, r1.getBottomPadding(), r6.get(r1.getLeftToLeft()), r6.get(r1.getLeftToRight()), r21, r22, r6.get(r1.getRightToLeft()), r6.get(r1.getRightToRight()), r25, r26);
    L63:
        return null;
    L9:
        if (Intrinsics.areEqual(r5.getLayoutType(), "constraint") == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L49;
        List<DynamicLayoutParams> r11 = r5.getLayoutParams();
        if (r11 == null) goto L49;
        Iterator<T> r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L30;
        Object r14 = r12.next();
        DynamicLayoutParams r15 = (DynamicLayoutParams) r14;
        if (r15 == null) goto L21;
        Integer r16 = r15.getStyle();
    L22:
        if (r16 != null) goto L25;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == false) goto L17;
    L31:
        DynamicLayoutParams r19 = (DynamicLayoutParams) r14;
        if (r19 == null) goto L49;
        List<DynamicElementLayoutParams> r20 = r19.getElements();
        if (r20 == null) goto L49;
        Iterator<T> r23 = r20.iterator();
    L37:
        if (r23.hasNext() == false) goto L45;
        Object r24 = r23.next();
        DynamicElementLayoutParams r27 = (DynamicElementLayoutParams) r24;
        if (r27 == null) goto L41;
        String r29 = r27.getName();
    L43:
        if (Intrinsics.areEqual(r29, r28) == false) goto L37;
    L46:
        DynamicElementLayoutParams r30 = (DynamicElementLayoutParams) r24;
        if (r30 == null) goto L49;
        r1 = r30.getStyles();
        goto L50
    L41:
        r29 = null;
        goto L43
    L45:
        r24 = null;
        goto L46
    L25:
        if (r16.intValue() != r4) goto L27;
        r18 = true;
        goto L28
    L21:
        r16 = null;
        goto L22
    L30:
        r14 = null;
        goto L31
    L5:
        r4 = 0;
        goto L6
    }

    public final zh2.a c(com.bytedance.android.livesdk.livecommerce.largemode.b r28) {
        zh2.a r1 = a("search_bar");
        if (r28 == null) goto L72;
        ComponentLargeModeConfig r0 = r28.b("List", "List.Header.SearchBar");
        if (r0 == null) goto L73;
        int r3 = LargeModeConfigHelper.a;
        Intrinsics.checkNotNullParameter(r0, "largeConfig");
        LayoutSizeLargeModeConfig r4 = null;
        if (r1 == null) goto L71;
        LayoutLargeModeConfig r5 = r0.getLayoutConfig();
        if (r5 == null) goto L18;
        LayoutSizeLargeModeConfig r6 = r5.getWidthConfig();
        if (r6 == null) goto L18;
        if (Boolean.valueOf(Intrinsics.areEqual(r6.getType(), LayoutSizeLargeModeConfig.TYPE_SIZE_DP)).booleanValue() == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L18;
        Integer r7 = Integer.valueOf((int) r6.getValue());
    L19:
        Integer r8 = r7;
        LayoutLargeModeConfig r9 = r0.getLayoutConfig();
        if (r9 == null) goto L28;
        LayoutSizeLargeModeConfig r10 = r9.getHeightConfig();
        if (r10 == null) goto L28;
        if (Intrinsics.areEqual(r10.getType(), LayoutSizeLargeModeConfig.TYPE_SIZE_DP) == false) goto L26;
        r4 = r10;
    L26:
        if (r4 == null) goto L28;
        Integer r11 = Integer.valueOf((int) r4.getValue());
    L29:
        Integer r12 = r11;
        LayoutLargeModeConfig r13 = r0.getLayoutConfig();
        if (r13 == null) goto L33;
        Integer r14 = r13.getTopMargin();
        if (r14 == null) goto L33;
    L34:
        Integer r15 = r14;
        LayoutLargeModeConfig r16 = r0.getLayoutConfig();
        if (r16 == null) goto L38;
        Integer r17 = r16.getBottomMargin();
        if (r17 == null) goto L38;
    L39:
        Integer r18 = r17;
        LayoutLargeModeConfig r19 = r0.getLayoutConfig();
        if (r19 == null) goto L43;
        Integer r20 = r19.getLeftMargin();
        if (r20 == null) goto L43;
    L44:
        Integer r21 = r20;
        LayoutLargeModeConfig r22 = r0.getLayoutConfig();
        if (r22 == null) goto L48;
        Integer r23 = r22.getRightMargin();
        if (r23 == null) goto L48;
    L49:
        Integer r25 = r23;
        LayoutLargeModeConfig r24 = r0.getLayoutConfig();
        if (r24 == null) goto L53;
        Integer r26 = r24.getTopPadding();
        if (r26 == null) goto L53;
    L54:
        Integer r110 = r26;
        LayoutLargeModeConfig r27 = r0.getLayoutConfig();
        if (r27 == null) goto L58;
        Integer r29 = r27.getBottomPadding();
        if (r29 == null) goto L58;
    L59:
        Integer r111 = r29;
        LayoutLargeModeConfig r30 = r0.getLayoutConfig();
        if (r30 == null) goto L63;
        Integer r31 = r30.getLeftPadding();
        if (r31 == null) goto L63;
    L64:
        Integer r210 = r31;
        LayoutLargeModeConfig r2 = r0.getLayoutConfig();
        if (r2 == null) goto L68;
        Integer r32 = r2.getRightPadding();
        if (r32 == null) goto L68;
    L74:
        return new zh2.a(r8, r12, r1.c, r1.d, r1.e, r1.f, r15, r110, r1.i, r1.j, r18, r111, r1.m, r1.n, r21, r210, r1.q, r1.r, r25, r32);
    L68:
        r32 = r1.t;
    L63:
        r31 = r1.p;
    L58:
        r29 = r1.l;
    L53:
        r26 = r1.h;
    L48:
        r23 = r1.s;
    L43:
        r20 = r1.o;
    L38:
        r17 = r1.k;
    L33:
        r14 = r1.g;
    L28:
        r11 = r1.b;
    L18:
        r7 = r1.a;
        goto L19
    L71:
        return null;
    L73:
        return r1;
    L72:
        return r1;
    }
}
