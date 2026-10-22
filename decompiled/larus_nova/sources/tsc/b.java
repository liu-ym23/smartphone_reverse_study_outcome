package tsc;

import android.os.Build;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547432a = 0;

    static {
    }

    public static int b(String r100) {
        int r101 = r100.length();
        if (r101 == 7) goto L10;
        if (r101 != 9) goto L8;
        String r102 = r100.substring(1, 7);
        return ColorProtector.parseColor("#" + r100.substring(7, 9) + r102);
    L8:
        throw new IllegalArgumentException("Unknown color");
    L10:
        return ColorProtector.parseColor(r100);
    }

    public static Object[] a(l r110, Map r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        String r100 = r110.b().get("style");
        String r101 = r110.b().get("class");
        StyleSpan r102 = null;
        if (r211 == false) goto L8;
        if (r210 == null) goto L12;
        kw8.a r103 = (kw8.a) r210.get(r101);
        if (r103 == null) goto L12;
        kw8.b r104 = r103.f506407b;
    L13:
        int r105 = 1;
        if (r100 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        if (r104 != null) goto L23;
        return null;
    L23:
        ArrayList r107 = new ArrayList();
        if (r104 == null) goto L28;
        String r108 = r104.f506408a;
        if (r108 == null) goto L28;
    L29:
        if (r104 == null) goto L33;
        String r109 = r104.f506409b;
        if (r109 == null) goto L33;
    L34:
        if (r104 == null) goto L38;
        String r111 = r104.f506410c;
        if (r111 == null) goto L38;
    L39:
        if (r104 == null) goto L43;
        String r112 = r104.f506411d;
        if (r112 == null) goto L43;
        String r113 = r112;
    L163:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L95
        if (r100 != null) goto L47;
    L50:
        boolean r115 = true;
    L51:
        if (r115 == false) goto L53;
        String r116 = null;
        String r117 = null;
    L91:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L93
    L99:
        if (r108 != null) goto L167;
    L110:
        if (r109 == null) goto L126;
        int r118 = b(r109);     // Catch: Throwable -> L117
        int r119 = dtc.a.f470019a;     // Catch: Throwable -> L117
        if (Build.VERSION.SDK_INT < 29) goto L114;
        ParagraphStyle r120 = new LineBackgroundSpan.Standard(r118);     // Catch: Throwable -> L117
    L115:
        Object r121 = Result.m9449constructorimpl(Boolean.valueOf(r107.add(r120)));     // Catch: Throwable -> L117
    L119:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L124;
        com.larus.business.markdown.api.depend.d r123 = IMarkdownLoggerKt.a();
        if (r123 == null) goto L124;
        r123.e("MD_CSS", "unsupported color: " + r122);
    L124:
        Result.m9448boximpl(r121);
        goto L126
    L114:
        r120 = new dtc.b(r118);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L126:
        if (r116 == null) goto L131;
        Integer r125 = StringsKt.toIntOrNull(StringsKt.substringBefore(r116, GXTemplateKey.GAIAX_PX, r116));
        if (r125 == null) goto L131;
        r107.add(new AbsoluteSizeSpan(r125.intValue(), true));
    L131:
        if (r111 == null) goto L137;
        boolean r126 = Intrinsics.areEqual(r111, "italic");
        if (r126 == false) goto L135;
        int r127 = 2;
    L136:
        StyleSpan r128 = new StyleSpan(r127);
        r107.add(r128);
        boolean r129 = r126;
        r102 = r128;
    L138:
        if (r113 == null) goto L151;
        boolean r130 = Intrinsics.areEqual(r113, CommodityText.BOLD);
        if (r102 == null) goto L142;
        r107.remove(r102);
    L142:
        if (r130 == false) goto L145;
        if (r129 == false) goto L145;
        r105 = 3;
    L150:
        r107.add(new StyleSpan(r105));
    L145:
        if (r130 == true) goto L150;
        if (r129 == false) goto L149;
        r105 = 2;
        goto L150
    L149:
        r105 = 0;
    L151:
        if (r117 == null) goto L157;
        Integer r131 = StringsKt.toIntOrNull(StringsKt.substringBefore(r117, GXTemplateKey.GAIAX_PX, r117));
        if (r131 == null) goto L157;
        if (r131.intValue() <= 0) goto L157;
        int r132 = dtc.a.f470019a;
        r107.add(dtc.a.a(com.larus.business.markdown.impl.common.utils.d.a(r131)));
    L157:
        Object[] r133 = r107.toArray(new Object[0]);
        if (r133 == null) goto L161;
        return r133;
    L161:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L135:
        r127 = 0;
        goto L136
    L137:
        r129 = false;
        goto L138
    L167:
        Object r134 = Result.m9449constructorimpl(Boolean.valueOf(r107.add(new ForegroundColorSpan(b(r108)))));     // Catch: Throwable -> L102
    L104:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);
        if (r135 == null) goto L109;
        com.larus.business.markdown.api.depend.d r136 = IMarkdownLoggerKt.a();
        if (r136 == null) goto L109;
        r136.e("MD_CSS", "unsupported color: " + r135);
    L109:
        Result.m9448boximpl(r134);
    L102:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L104
    L53:
        c.a.C7768a.C7769a r138 = new c.a.C7768a.C7769a(new c.a.C7768a(r100));     // Catch: Throwable -> L95
        r116 = null;
        r117 = null;
    L162:
    L93:
        th = th;
    L97:
        Result.Companion r139 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L99
    L56:
        if (r138.hasNext() == false) goto L91;
        d r140 = (d) r138.next();     // Catch: Throwable -> L93
        String r141 = r140.f547441a;     // Catch: Throwable -> L93
        String r142 = StringsKt.replace$default(r140.f547442b, "!important", "", false, 4, null);     // Catch: Throwable -> L93
        if (r142 == null) goto L90;
        String r143 = StringsKt.trim(r142).toString();     // Catch: Throwable -> L93
        switch(r141.hashCode()) {
            case -1923578189: goto L86;
            case -1586082113: goto L82;
            case -1221029593: goto L78;
            case -1215680224: goto L75;
            case 94842723: goto L71;
            case 598800822: goto L67;
            case 605322756: goto L63;
            default: goto L162;
        };     // Catch: Throwable -> L93
    L63:
        if (r141.equals(GXTemplateKey.STYLE_BACKGROUND_COLOR) == false) goto L162;
        r109 = r143;
        goto L162
    L67:
        if (r141.equals(GXTemplateKey.STYLE_FONT_WEIGHT) == false) goto L162;
        r113 = r143;
        goto L162
    L71:
        if (r141.equals("color") == false) goto L162;
        r108 = r143;
        goto L162
    L75:
        if (r141.equals(GXTemplateKey.STYLE_FONT_LINE_HEIGHT) == false) goto L162;
    L80:
        r117 = r143;
        goto L162
    L78:
        if (r141.equals("height") == true) goto L80;
    L82:
        if (r141.equals(GXTemplateKey.STYLE_FONT_SIZE) == false) goto L162;
        r116 = r143;
        goto L162
    L86:
        if (r141.equals("font-style") == false) goto L162;
        r111 = r143;
        goto L162
    L90:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L93
    L47:
        if (r100.length() == 0) goto L50;
        r115 = false;
    L95:
        th = th;
        r116 = null;
        r117 = null;
    L43:
        r113 = null;
    L38:
        r111 = null;
    L33:
        r109 = null;
    L28:
        r108 = null;
        goto L29
    L16:
        if (r100.length() == 0) goto L19;
        r106 = false;
    L12:
        r104 = null;
        goto L13
    L8:
        if (r210 == null) goto L12;
        kw8.a r144 = (kw8.a) r210.get(r101);
        if (r144 == null) goto L12;
        r104 = r144.f506406a;
        goto L13
    }
}
