package nsc;

import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.OrderedSymbol;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.q;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.u;
import org.commonmark.node.BlockQuote;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f520445c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f520446d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f520447e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f520448f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListMarginInfo f520449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListStyle f520450b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes41.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f520451a = null;

        static {
            int[] r100 = new int[OrderedSymbol.values().length];
            r100[OrderedSymbol.DECIMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[OrderedSymbol.LOWERCASE_ALPHABET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[OrderedSymbol.LOWERCASE_ROMAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f520451a = r100;
        }
    }

    public j() {
        this(null, null);
    }

    static {
        f520445c = new String[]{"", "M", "MM", "MMM"};
        f520446d = new String[]{"", "C", PromotionCrossBorderStruct.CLEAR_CC_TYPE, "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        f520447e = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        f520448f = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    }

    private static int c(t r100) {
        u r101 = (u) r100;
        int r102 = ((Number) r101.b(CoreProps.f492261c, -1)).intValue();
        if (r102 == 0) goto L7;
        if (r102 == (-1)) goto L7;
        return r102;
    L7:
        return CoreProps.f492260b.b(r101).intValue();
    }

    public j(ListMarginInfo r100, ListStyle r101) {
        this.f520449a = r100;
        this.f520450b = r101;
    }

    @Override // nsc.k, lsc.x
    public final Object a(lsc.h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        return d(r100, r101, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.noties.markwon.core.spans.q] */
    /* JADX WARN: Type inference failed for: r1v15, types: [io.noties.markwon.core.spans.c] */
    public final Object d(lsc.h r110, t r111, lw8.a r112, uvc.b r113) {
        Intrinsics.checkNotNullParameter(r110, "configuration");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        ListStyle r100 = this.f520450b;
        int r101 = 0;
        if (r100 != null) goto L5;
        r100 = new ListStyle(null, false, 3, null);
    L5:
        int r102 = k.b(r110, r111, this.f520449a);
        boolean r103 = CoreProps.f492263e.b(r111).booleanValue();
        boolean r114 = true;
        if (CoreProps.ListItemType.BULLET != CoreProps.f492259a.b(r111)) goto L25;
        Object r104 = new io.noties.markwon.core.spans.c(r110.f510591a, this.f520449a, c(r111), r102, r103);
        r104.f492322j = r100.getSymbolStrategy();
        if (r113 != null) goto L11;
    L9:
        r114 = false;
    L19:
        if (r114 == false) goto L61;
        if (r112 == null) goto L24;
        Integer r115 = r112.f511053h;
        if (r115 == null) goto L24;
        r101 = r115.intValue();
    L24:
        r104.f492321i = r101;
    L61:
        return r104;
    L11:
        if ((r113 instanceof BlockQuote) == true) goto L19;
        uvc.b r116 = r113.f551900a;
    L14:
        if (r116 == null) goto L9;
        if ((r116 instanceof BlockQuote) == true) goto L19;
        r116 = r116.f551900a;
        goto L14
    L25:
        lw8.j r105 = r100.getSymbolStrategy();
        c(r111);
        OrderedSymbol r106 = r105.a();
        int r117 = CoreProps.f492262d.b(r111).intValue();
        int r107 = b.f520451a[r106.ordinal()];
        if (r107 != 1) goto L28;
        Object r118 = Integer.valueOf(r117);
    L43:
        r104 = new q(r110.f510591a, this.f520449a, r118 + ". ", r102, r103);
        if (r113 != null) goto L47;
    L45:
        r114 = false;
    L55:
        if (r114 == false) goto L61;
        if (r112 == null) goto L60;
        Integer r119 = r112.f511052g;
        if (r119 == null) goto L60;
        r101 = r119.intValue();
    L60:
        r104.f492362j = r101;
        goto L61
    L47:
        if ((r113 instanceof BlockQuote) == true) goto L55;
        uvc.b r120 = r113.f551900a;
    L50:
        if (r120 == null) goto L45;
        if ((r120 instanceof BlockQuote) == true) goto L55;
        r120 = r120.f551900a;
        goto L50
    L28:
        if (r107 == 2) goto L38;
        if (r107 == 3) goto L31;
        r118 = Integer.valueOf(r117);
        goto L43
    L31:
        if (r117 != 0) goto L33;
        r118 = "";
        goto L43
    L33:
        String r121 = f520445c[r117 / 1000] + f520446d[(r117 % 1000) / 100] + f520447e[(r117 % 100) / 10] + f520448f[r117 % 10];
        Locale r108 = Locale.getDefault();
        if (r121 == null) goto L37;
        r118 = r121.toLowerCase(r108);
        goto L43
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L38:
        StringBuilder r109 = new StringBuilder();
        int r122 = Math.max(1, r117);
    L39:
        if (r122 <= 0) goto L41;
        int r123 = r122 - 1;
        r109.insert(0, String.valueOf((char) (((r123 % 26) + 1) + 96)));
        r122 = r123 / 26;
        goto L39
    L41:
        r118 = r109.toString();
        goto L43
    }
}
