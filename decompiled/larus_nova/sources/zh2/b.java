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
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECPromotionHeaderLayoutControl f572183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f572184b;

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
        this.f572184b = MapsKt.mapOf(new Pair[]{TuplesKt.to("entry", Integer.valueOf(R.id.list_entry)), TuplesKt.to("shop_info", Integer.valueOf(R.id.area_shop_info)), TuplesKt.to(PickerReporterConstants.VALUE.CLICK.BAR, Integer.valueOf(R.id.search_bar)), TuplesKt.to("parent", 0)});
    }

    public final zh2.a a(String r210) {
        Lazy r100 = ECLiveDynamicLayoutHelper.f149065a;
        ECPromotionHeaderLayoutControl r101 = this.f572183a;
        if (r101 == null) goto L5;
        int r102 = r101.getHeaderStyle();
    L6:
        Intrinsics.checkNotNullParameter(r210, "elementName");
        DynamicLayoutDTO r103 = (DynamicLayoutDTO) ECLiveDynamicLayoutHelper.f149065a.getValue();
        if (r103 != null) goto L9;
    L49:
        ConstraintLayoutParams r104 = null;
    L50:
        Map<String, Integer> r105 = this.f572184b;
        Intrinsics.checkNotNullParameter(r105, "convertMap");
        if (r104 == null) goto L63;
        Integer r106 = r104.getWidth();
        Integer r107 = r104.getHeight();
        Integer r108 = r105.get(r104.getCenterX());
        Integer r110 = r105.get(r104.getCenterY());
        Integer r211 = r104.getLeftMargin();
        Integer r212 = r104.getRightMargin();
        Integer r111 = r104.getTopMargin();
        Integer r112 = r104.getBottomMargin();
        Integer r213 = r104.getLeftPadding();
        Integer r214 = r104.getRightPadding();
        return new zh2.a(r106, r107, r108, r110, r105.get(r104.getTopToTop()), r105.get(r104.getTopToBottom()), r111, r104.getTopPadding(), r105.get(r104.getBottomToTop()), r105.get(r104.getBottomToBottom()), r112, r104.getBottomPadding(), r105.get(r104.getLeftToLeft()), r105.get(r104.getLeftToRight()), r211, r213, r105.get(r104.getRightToLeft()), r105.get(r104.getRightToRight()), r212, r214);
    L63:
        return null;
    L9:
        if (Intrinsics.areEqual(r103.getLayoutType(), "constraint") == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L49;
        List<DynamicLayoutParams> r109 = r103.getLayoutParams();
        if (r109 == null) goto L49;
        Iterator<T> r113 = r109.iterator();
    L17:
        if (r113.hasNext() == false) goto L30;
        Object r114 = r113.next();
        DynamicLayoutParams r115 = (DynamicLayoutParams) r114;
        if (r115 == null) goto L21;
        Integer r116 = r115.getStyle();
    L22:
        if (r116 != null) goto L25;
    L27:
        boolean r117 = false;
    L28:
        if (r117 == false) goto L17;
    L31:
        DynamicLayoutParams r118 = (DynamicLayoutParams) r114;
        if (r118 == null) goto L49;
        List<DynamicElementLayoutParams> r119 = r118.getElements();
        if (r119 == null) goto L49;
        Iterator<T> r120 = r119.iterator();
    L37:
        if (r120.hasNext() == false) goto L45;
        Object r121 = r120.next();
        DynamicElementLayoutParams r122 = (DynamicElementLayoutParams) r121;
        if (r122 == null) goto L41;
        String r123 = r122.getName();
    L43:
        if (Intrinsics.areEqual(r123, r210) == false) goto L37;
    L46:
        DynamicElementLayoutParams r124 = (DynamicElementLayoutParams) r121;
        if (r124 == null) goto L49;
        r104 = r124.getStyles();
        goto L50
    L41:
        r123 = null;
        goto L43
    L45:
        r121 = null;
        goto L46
    L25:
        if (r116.intValue() != r102) goto L27;
        r117 = true;
        goto L28
    L21:
        r116 = null;
        goto L22
    L30:
        r114 = null;
        goto L31
    L5:
        r102 = 0;
        goto L6
    }

    public final zh2.a c(com.bytedance.android.livesdk.livecommerce.largemode.b r210) {
        zh2.a r100 = a(PickerReporterConstants.VALUE.CLICK.BAR);
        if (r210 == null) goto L72;
        ComponentLargeModeConfig r101 = r210.b("List", "List.Header.SearchBar");
        if (r101 == null) goto L73;
        int r102 = LargeModeConfigHelper.f149249a;
        Intrinsics.checkNotNullParameter(r101, "largeConfig");
        LayoutSizeLargeModeConfig r103 = null;
        if (r100 == null) goto L71;
        LayoutLargeModeConfig r104 = r101.getLayoutConfig();
        if (r104 == null) goto L18;
        LayoutSizeLargeModeConfig r105 = r104.getWidthConfig();
        if (r105 == null) goto L18;
        if (Boolean.valueOf(Intrinsics.areEqual(r105.getType(), "offset")).booleanValue() == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L18;
        Integer r106 = Integer.valueOf((int) r105.getValue());
    L19:
        Integer r107 = r106;
        LayoutLargeModeConfig r108 = r101.getLayoutConfig();
        if (r108 == null) goto L28;
        LayoutSizeLargeModeConfig r109 = r108.getHeightConfig();
        if (r109 == null) goto L28;
        if (Intrinsics.areEqual(r109.getType(), "offset") == false) goto L26;
        r103 = r109;
    L26:
        if (r103 == null) goto L28;
        Integer r110 = Integer.valueOf((int) r103.getValue());
    L29:
        Integer r111 = r110;
        LayoutLargeModeConfig r112 = r101.getLayoutConfig();
        if (r112 == null) goto L33;
        Integer r113 = r112.getTopMargin();
        if (r113 == null) goto L33;
    L34:
        Integer r114 = r113;
        LayoutLargeModeConfig r115 = r101.getLayoutConfig();
        if (r115 == null) goto L38;
        Integer r116 = r115.getBottomMargin();
        if (r116 == null) goto L38;
    L39:
        Integer r117 = r116;
        LayoutLargeModeConfig r118 = r101.getLayoutConfig();
        if (r118 == null) goto L43;
        Integer r119 = r118.getLeftMargin();
        if (r119 == null) goto L43;
    L44:
        Integer r211 = r119;
        LayoutLargeModeConfig r120 = r101.getLayoutConfig();
        if (r120 == null) goto L48;
        Integer r121 = r120.getRightMargin();
        if (r121 == null) goto L48;
    L49:
        Integer r212 = r121;
        LayoutLargeModeConfig r122 = r101.getLayoutConfig();
        if (r122 == null) goto L53;
        Integer r123 = r122.getTopPadding();
        if (r123 == null) goto L53;
    L54:
        Integer r124 = r123;
        LayoutLargeModeConfig r125 = r101.getLayoutConfig();
        if (r125 == null) goto L58;
        Integer r126 = r125.getBottomPadding();
        if (r126 == null) goto L58;
    L59:
        Integer r127 = r126;
        LayoutLargeModeConfig r128 = r101.getLayoutConfig();
        if (r128 == null) goto L63;
        Integer r129 = r128.getLeftPadding();
        if (r129 == null) goto L63;
    L64:
        Integer r213 = r129;
        LayoutLargeModeConfig r130 = r101.getLayoutConfig();
        if (r130 == null) goto L68;
        Integer r131 = r130.getRightPadding();
        if (r131 == null) goto L68;
    L74:
        return new zh2.a(r107, r111, r100.f572165c, r100.f572166d, r100.f572167e, r100.f572168f, r114, r124, r100.f572171i, r100.f572172j, r117, r127, r100.f572175m, r100.f572176n, r211, r213, r100.f572179q, r100.f572180r, r212, r131);
    L68:
        r131 = r100.f572182t;
    L63:
        r129 = r100.f572178p;
    L58:
        r126 = r100.f572174l;
    L53:
        r123 = r100.f572170h;
    L48:
        r121 = r100.f572181s;
    L43:
        r119 = r100.f572177o;
    L38:
        r116 = r100.f572173k;
    L33:
        r113 = r100.f572169g;
    L28:
        r110 = r100.f572164b;
    L18:
        r106 = r100.f572163a;
        goto L19
    L71:
        return null;
    L73:
        return r100;
    L72:
        return r100;
    }
}
