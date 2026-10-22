package lec;

import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.theme.CustomStrikethroughSpan;
import com.ss.android.lark.widget.codeblock.theme.CustomStyleSpan;
import com.ss.android.lark.widget.codeblock.theme.CustomUnderlineSpan;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class g {
    public static List<RichTextElement> b(Spannable r110) {
        ArrayList r100 = new ArrayList();
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return r100;
    L5:
        int[] r101 = new int[r110.length()];
        int r102 = 0;
        h[] r103 = (h[]) r110.getSpans(0, r110.length(), h.class);
        x9b.h[] r104 = (x9b.h[]) r110.getSpans(0, r110.length(), x9b.h.class);
        int r105 = r103.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L27;
        h r107 = r103[r106];
        int r108 = r110.getSpanStart(r107);
        int r111 = r110.getSpanEnd(r107);
        if (r108 == (-1)) goto L26;
        if (r111 == (-1)) goto L26;
    L12:
        if (r108 >= r111) goto L26;
        TextStyleInfo r109 = r107.f518743a;
        if (r109.isBold == false) goto L17;
        r101[r108] = r101[r108] | 1;
    L17:
        if (r109.isItalic == false) goto L20;
        r101[r108] = r101[r108] | 2;
    L20:
        if (r109.isStrikeThruText == false) goto L23;
        r101[r108] = r101[r108] | 8;
    L23:
        if (r109.isUnderlineText == false) goto L25;
        r101[r108] = r101[r108] | 4;
    L25:
        r108 = r108 + 1;
    L26:
        r106 = r106 + 1;
        goto L7
    L27:
        int r112 = r104.length;
    L28:
        if (r102 >= r112) goto L48;
        x9b.h r113 = r104[r102];
        int r114 = r110.getSpanStart(r113);
        int r115 = r110.getSpanEnd(r113);
        if (r114 == (-1)) goto L47;
        if (r115 == (-1)) goto L47;
    L33:
        if (r114 >= r115) goto L47;
        if (r113.f563010a == false) goto L38;
        r101[r114] = r101[r114] | 1;
    L38:
        if (r113.f563011b == false) goto L41;
        r101[r114] = r101[r114] | 2;
    L41:
        if (r113.f563013d == false) goto L44;
        r101[r114] = r101[r114] | 8;
    L44:
        if (r113.f563012c == false) goto L46;
        r101[r114] = r101[r114] | 4;
    L46:
        r114 = r114 + 1;
    L47:
        r102 = r102 + 1;
        goto L28
    L48:
        c(r110, r101, r100);
        return r100;
    }

    public static Map<String, String> d(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L29:
        return null;
    L5:
        if ((r100 instanceof Spannable) == false) goto L29;
        int r101 = 0;
        h[] r102 = (h[]) ((Spannable) r100).getSpans(0, r100.length(), h.class);
        if (r102 == null) goto L29;
        if (r102.length == 0) goto L29;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r101 >= r103) goto L28;
        TextStyleInfo r105 = r102[r101].f518743a;
        if (r105.isBold == false) goto L18;
        r104 = r104 | 1;
    L18:
        if (r105.isItalic == false) goto L21;
        r104 = r104 | 2;
    L21:
        if (r105.isStrikeThruText == false) goto L24;
        r104 = r104 | 8;
    L24:
        if (r105.isUnderlineText == false) goto L26;
        r104 = r104 | 4;
    L26:
        r101 = r101 + 1;
        goto L13
    L28:
        return e(r104);
    }

    public static Map<String, String> e(int r100) {
        HashMap r101 = new HashMap();
        boolean r102 = false;
        if ((r100 & 1) != 1) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        r101.put("fontWeight", UIHelper.getString(R.string.remote_font_weight_bold));
    L9:
        if ((r100 & 2) != 2) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        r101.put("fontStyle", UIHelper.getString(R.string.remote_font_style_italic));
    L15:
        if ((r100 & 4) != 4) goto L17;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L22;
        r101.put("-lark-textDecoration", UIHelper.getString(R.string.remote_text_lark_decoration_underline));
    L22:
        if ((r100 & 8) != 8) goto L24;
        r102 = true;
    L24:
        if (r102 == false) goto L29;
        String r106 = (String) r101.get("-lark-textDecoration");
        String r107 = UIHelper.getString(R.string.remote_text_lark_decoration_line_through);
        if (TextUtils.isEmpty(r106) == false) goto L28;
        r101.put("-lark-textDecoration", r107);
        goto L29
    L28:
        r101.put("-lark-textDecoration", r106 + " " + r107);
    L29:
        return r101;
    L17:
        r105 = false;
        goto L19
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    public static void a(CharacterStyle[] r100, Spannable r110, int[] r111) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L34;
        CharacterStyle r103 = r100[r102];
        int r104 = r110.getSpanStart(r103);
        int r105 = r110.getSpanEnd(r103);
        if (r104 == (-1)) goto L33;
        if (r105 == (-1)) goto L33;
    L8:
        if (r104 >= r105) goto L33;
        boolean r106 = r103 instanceof CustomStyleSpan;
        if (r106 == false) goto L16;
        CustomStyleSpan r107 = (CustomStyleSpan) r103;
        if (r107.getStyle() != 1) goto L16;
        if (r107.f445720a == false) goto L16;
        r111[r104] = r111[r104] | 1;
    L16:
        if (r106 == false) goto L23;
        CustomStyleSpan r108 = (CustomStyleSpan) r103;
        if (r108.getStyle() != 2) goto L23;
        if (r108.f445720a == false) goto L23;
        r111[r104] = r111[r104] | 2;
    L23:
        if ((r103 instanceof CustomStrikethroughSpan) == false) goto L28;
        if (((CustomStrikethroughSpan) r103).f445719a == false) goto L28;
        r111[r104] = r111[r104] | 8;
    L28:
        if ((r103 instanceof CustomUnderlineSpan) == false) goto L32;
        if (((CustomUnderlineSpan) r103).f445721a == false) goto L32;
        r111[r104] = r111[r104] | 4;
    L32:
        r104 = r104 + 1;
    L33:
        r102 = r102 + 1;
        goto L3
    }

    public static void c(Spannable r100, int[] r101, List<RichTextElement> r102) {
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r101.length) goto L12;
        if (r101[r104] == r101[r103]) goto L9;
        RichTextElement r105 = RichTextElementCreator.e(r100.subSequence(r104, r103).toString());
        r105.setStyle(e(r101[r104]));
        ((ArrayList) r102).add(r105);
        r104 = r103;
    L9:
        if (r103 != (r101.length - 1)) goto L11;
        RichTextElement r106 = RichTextElementCreator.e(r100.subSequence(r104, r103 + 1).toString());
        r106.setStyle(e(r101[r104]));
        ((ArrayList) r102).add(r106);
    L11:
        r103 = r103 + 1;
        goto L4
    }
}
