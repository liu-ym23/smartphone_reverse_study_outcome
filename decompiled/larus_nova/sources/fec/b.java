package fec;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.utils.c;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.PrefixSpanStyle;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f476640a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f476641b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f476642c = null;

        static {
            int[] r100 = new int[RichTextElement.OLProperty.Type.values().length];
            f476642c = r100;
            r100[RichTextElement.OLProperty.Type.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L65:
            f476642c[RichTextElement.OLProperty.Type.LOWERCASE_A.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L51:
            f476642c[RichTextElement.OLProperty.Type.UPPERCASE_A.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L61:
            f476642c[RichTextElement.OLProperty.Type.LOWERCASE_ROMAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L67:
            f476642c[RichTextElement.OLProperty.Type.UPPERCASE_ROMAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L53:
            f476642c[RichTextElement.OLProperty.Type.NONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L14:
            int[] r101 = new int[PrefixSpan.Type.values().length];
            f476641b = r101;
            r101[PrefixSpan.Type.FILL_CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L73:
            f476641b[PrefixSpan.Type.HOLLOW_CIRCLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L47:
            f476641b[PrefixSpan.Type.FILL_RECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L69:
            f476641b[PrefixSpan.Type.HOLLOW_RECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L77:
            f476641b[PrefixSpan.Type.LIST_NUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L45:
            f476641b[PrefixSpan.Type.QUOTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L55:
            f476641b[PrefixSpan.Type.NONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L22:
            int[] r102 = new int[RichTextElement.ULProperty.Type.values().length];
            f476640a = r102;
            r102[RichTextElement.ULProperty.Type.DISC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L57:
            f476640a[RichTextElement.ULProperty.Type.CIRCLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L63:
            f476640a[RichTextElement.ULProperty.Type.SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L75:
            f476640a[RichTextElement.ULProperty.Type.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
            return;
        }
    }

    public static float a(PrefixSpan.Type r100) {
        int r101 = a.f476641b[r100.ordinal()];
        if (r101 == 2) goto L8;
        if (r101 == 4) goto L8;
        return 0.0f;
    L8:
        return UIHelper.getContext().getResources().getDimension(R.dimen.li_prefix_mark_border_width);
    }

    public static float b(PrefixSpan.Type r100) {
        int r101 = a.f476641b[r100.ordinal()];
        if (r101 != 1) goto L5;
    L14:
        int r102 = UIHelper.getDimens(R.dimen.li_prefix_mark_common_width);
    L16:
        return r102;
    L5:
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L14;
        if (r101 == 4) goto L14;
        if (r101 == 6) goto L13;
        r102 = 0;
        goto L16
    L13:
        r102 = UIHelper.getDimens(R.dimen.li_prefix_quote_width);
        goto L16
    }

    public static float c(int r100, PrefixSpan.Type r101) {
        int r102 = a.f476641b[r101.ordinal()];
        if (r102 != 1) goto L5;
    L14:
        int r103 = UIHelper.getDimens(R.dimen.li_prefix_mark_ul_left_margin);
    L16:
        return (r100 * UIHelper.getDimens(R.dimen.li_prefix_floor_left_margin)) + r103;
    L5:
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L14;
        if (r102 == 4) goto L14;
        if (r102 == 5) goto L13;
        r103 = 0;
        goto L16
    L13:
        r103 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
        goto L16
    }

    public static float d(String r100, int r101) {
        Paint r102 = c.f448389a;
        r102.reset();
        r102.setAntiAlias(true);
        r102.setTypeface(Typeface.MONOSPACE);
        r102.setTextSize(r101);
        return r102.measureText(r100);
    }

    public static String e(RichTextElement.OLProperty.Type r100, int r101) {
        int r102 = a.f476642c[r100.ordinal()];
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        if (r102 == 4) goto L17;
        if (r102 == 5) goto L15;
        return "";
    L15:
        return g(r101, false) + ".";
    L17:
        return g(r101, true) + ".";
    L19:
        return ((char) (r101 + 64)) + ".";
    L21:
        return ((char) (r101 + 96)) + ".";
    L23:
        return r101 + ".";
    }

    public static float f(PrefixSpan.Type r100, PrefixSpanStyle r101) {
        switch(a.f476641b[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        int r102 = 0;
    L22:
        return r102;
    L5:
        r102 = UIHelper.getDimens(R.dimen.li_prefix_circle_right_margin);
        goto L22
    L6:
        r102 = UIHelper.getDimens(R.dimen.li_prefix_quote_right_margin);
        goto L22
    L7:
        if (r101 != null) goto L9;
        r102 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
        goto L22
    L9:
        if (r101 != PrefixSpanStyle.FULL_SCREEN) goto L11;
        r102 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin_right_full);
        goto L22
    L11:
        r102 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
        goto L22
    L13:
        Paint r103 = c.f448389a;
        r103.reset();
        r103.setAntiAlias(true);
        r103.setTypeface(Typeface.MONOSPACE);
        r103.setTextSize(UIHelper.getDimens(R.dimen.local_font_size_default));
        int r104 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
        if (r101 != null) goto L16;
        int r105 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
    L20:
        int r106 = UIHelper.getDimens(R.dimen.li_prefix_mark_common_width);
        r102 = Math.round((((r103.measureText("a.") + r104) + r105) - r106) - UIHelper.getDimens(R.dimen.li_prefix_mark_ul_left_margin));
        goto L22
    L16:
        if (r101 != PrefixSpanStyle.FULL_SCREEN) goto L18;
        r105 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin_right_full);
        goto L20
    L18:
        r105 = UIHelper.getDimens(R.dimen.li_prefix_mark_num_margin);
        goto L20
    }

    public static String g(int r110, boolean r111) {
        if (r110 != 0) goto L5;
        return "";
    L5:
        String r112 = new String[]{"", "M", "MM", "MMM"}[r110 / 1000] + new String[]{"", "C", PromotionCrossBorderStruct.CLEAR_CC_TYPE, "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}[(r110 % 1000) / 100] + new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}[(r110 % 100) / 10] + new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}[r110 % 10];
        if (r111 == true) goto L8;
        return r112;
    L8:
        return r112.toLowerCase();
    }
}
