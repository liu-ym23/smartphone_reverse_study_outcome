package nec;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static PrefixSpan a(ElementExtra.FloorInfo r100, lec.b r101) {
        RichTextElement.RichTextProperty r102 = r100.getFloorProperty();
        int r103 = 1;
        if ((r102 instanceof RichTextElement.ULProperty) == false) goto L15;
        RichTextElement.ULProperty.Type r104 = ((RichTextElement.ULProperty) r102).getType();
        int r105 = fec.b.a.f476640a[r104.ordinal()];
        if (r105 != 1) goto L7;
        PrefixSpan.Type r106 = PrefixSpan.Type.FILL_CIRCLE;
    L21:
        PrefixSpanStyle r107 = null;
        if (r106 != null) goto L24;
        return null;
    L24:
        float r108 = fec.b.c(r100.floor, r106);
        float r109 = fec.b.a(r106);
        if (r101 == null) goto L28;
        r107 = r101.f508997p;
    L28:
        float r110 = fec.b.f(r106, r107);
        int r111 = UIHelper.getColor(R.color.lkui_B500);
        PrefixSpan.b r112 = new PrefixSpan.b();
        r112.f448586a = r106;
        r112.f448587b = r100.isNeedDrawPrefix;
        r112.f448588c = r108;
        r112.f448590e = r109;
        r112.f448591f = r110;
        r112.f448593h = r111;
        r112.f448595j = r100.floor;
        if (r106 != PrefixSpan.Type.LIST_NUM) goto L38;
        RichTextElement.OLProperty r113 = (RichTextElement.OLProperty) r102;
        int r114 = r100.index;
        RichTextElement.OLProperty.Type r115 = r113.getType();
        int r116 = r113.getStart();
        if (r116 > 0) goto L33;
        r116 = 1;
    L33:
        r112.f448592g = fec.b.e(r115, r116 + r114);
        r112.f448596k = r113.getStart();
        r112.f448597l = PrefixSpan.ListType.from(r113.getType().getType());
        int r117 = r100.index;
        RichTextElement.OLProperty.Type r118 = r113.getType();
        int r119 = r113.getStart();
        if (r119 <= 0) goto L37;
        r103 = r119;
    L37:
        float r120 = fec.b.d(fec.b.e(r118, r103 + r117), UIHelper.getDimens(R.dimen.local_font_size_default));
    L39:
        r112.f448589d = r120;
        return new PrefixSpan(r112);
    L38:
        r120 = fec.b.b(r106);
        goto L39
    L7:
        if (r105 != 2) goto L9;
        r106 = PrefixSpan.Type.HOLLOW_CIRCLE;
        goto L21
    L9:
        if (r105 == 3) goto L11;
        r106 = PrefixSpan.Type.NONE;
        goto L21
    L11:
        r106 = PrefixSpan.Type.FILL_RECT;
        goto L21
    L15:
        if ((r102 instanceof RichTextElement.OLProperty) == false) goto L18;
        r106 = PrefixSpan.Type.LIST_NUM;
        goto L21
    L18:
        if ((r102 instanceof RichTextElement.QuoteProperty) == false) goto L20;
        r106 = PrefixSpan.Type.QUOTE;
        goto L21
    L20:
        r106 = PrefixSpan.Type.NONE;
        goto L21
    }

    public static boolean b(ElementExtra r100, Map<String, RichTextElement> r101) {
        RichTextElement r102 = r101.get(r100.getParentId());
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.getTag() != RichTextElement.RichTextTag.LI) goto L9;
        return true;
    L9:
        return b(r102.getElementExtra(), r101);
    }
}
