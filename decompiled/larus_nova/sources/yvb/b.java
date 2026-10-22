package yvb;

import android.app.Application;
import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.RichTextInlineTagData;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.f;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f569318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, a> f569319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SpannableStringBuilder f569320c;

    public b() {
        d r100 = d.f569321f;
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f569318a = r100;
        this.f569319b = new HashMap();
        this.f569320c = new SpannableStringBuilder();
    }

    private final Application getContext() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r210) {
        b r100 = this;
        Intrinsics.checkNotNullParameter(r210, "text");
        boolean r101 = r100.f569318a.f569326e;
        Intrinsics.checkNotNullParameter(r210, "text");
        r100.f569319b.clear();
        r100.f569320c.clear();
        List r102 = StringsKt.split$default(r210, new String[]{"\n"}, false, 0, 6, null);
        int r103 = r102.size();
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L141;
        Integer r110 = Integer.valueOf(r104);
        HashMap<Integer, a> r111 = r100.f569319b;
        a r112 = new a((String) ListProtector.get(r102, r104), r100.f569318a);
        int r105 = r112.f569312a.length();
        String r106 = "";
        int r113 = 0;
        boolean r114 = false;
        int r115 = 0;
    L7:
        if (r113 >= r105) goto L66;
        char r107 = r112.f569312a.charAt(r113);
        if (r107 != ' ') goto L41;
        if (r114 == true) goto L11;
        List r116 = r102;
        int r117 = r103;
        r101 = r101;
        r115 = r115 + 1;
    L65:
        r113 = r113 + 1;
        r102 = r116;
        r103 = r117;
        r101 = r101;
        goto L7
    L11:
        r112.f569315d = (r115 / 4) + 1;
        if (new Regex("\\d+\\.").matches(r106) == false) goto L30;
        int r108 = r112.f569315d;
        List<SpanInfo> r109 = r112.f569314c;
        int r118 = e.f569330a;
        int r119 = r112.b().length();
        String r120 = r112.b();
        r116 = r102;
        d r121 = r112.f569313b;
        Intrinsics.checkNotNullParameter(r120, "text");
        r117 = r103;
        Intrinsics.checkNotNullParameter(r106, "prefix");
        Intrinsics.checkNotNullParameter(r121, "style");
        r121.getClass();
        if (r108 >= 1) goto L16;
    L19:
        d.b r122 = null;
    L20:
        PrefixSpan.b r123 = new PrefixSpan.b();
        r123.f448587b = true;
        r123.f448588c = UIHelper.dp2px(((r108 - 1) * 24.0f) + 2.0f);
        r123.f448591f = UIHelper.dp2px(10.0f);
        r123.f448589d = UIHelper.dp2px(14.0f);
        if (r122 == null) goto L25;
        Integer r124 = r122.f569329c;
        if (r124 == null) goto L25;
    L27:
        int r125 = r124.intValue();
    L29:
        r123.f448593h = r125;
        r123.f448586a = PrefixSpan.Type.LIST_NUM;
        r123.f448592g = r106;
        PrefixInfo r126 = new PrefixInfo(r123);
        r126.type = 12;
        r126.start = 0;
        r126.end = r119;
        r126.text = r120;
        ((ArrayList) r109).add(r126);
    L36:
        boolean r127 = true;
    L38:
        if (r127 == false) goto L67;
        int r128 = r113 + 1;
    L68:
        r112.f569312a = r112.f569312a.substring(r128);
    L69:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r129 = new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a(r112.f569312a);
        r112.f569316e = r129;
        String r130 = r129.f435763a;
        int r131 = 0;
        int r132 = 0;
    L71:
        if (r131 >= r130.length()) goto L120;
        char r133 = r130.charAt(r131);
        int r134 = r132 + 1;
        r129.f435766d.put(Integer.valueOf(r132), new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a(r133));
        if (r133 != '*') goto L119;
        int r135 = r132 - 1;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r136 = r129.f435766d.get(Integer.valueOf(r135));
        if (r136 != null) goto L77;
    L79:
        boolean r137 = false;
    L80:
        if (r137 == false) goto L119;
        if (r136 != null) goto L83;
    L85:
        boolean r138 = false;
    L86:
        if (r138 == false) goto L119;
        boolean r139 = true;
        RichTextInlineTagData r140 = new RichTextInlineTagData(CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(r135), Integer.valueOf(r132)}), RichTextInlineTagData.Style.BOLD);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r141 = r129.f435766d.get(Integer.valueOf(r135));
        if (r141 == null) goto L90;
        r141.f435772c = true;
    L90:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r142 = r129.f435766d.get(Integer.valueOf(r132));
        if (r142 == null) goto L93;
        r142.f435772c = true;
    L93:
        int r143 = r129.f435765c;
        if (r143 > 0) goto L96;
        r129.f435765c = r143 + 1;
        ((ArrayList) r129.f435764b).add(r140);
    L96:
        if ((((ArrayList) r129.f435764b).isEmpty() ^ r139) == false) goto L119;
        List<RichTextInlineTagData> r144 = r129.f435764b;
        RichTextInlineTagData r145 = (RichTextInlineTagData) ListProtector.remove(r144, CollectionsKt.getLastIndex(r144));
        if (r145.f435760b == r140.f435760b) goto L99;
        r139 = true;
        goto L96
    L99:
        Iterator<T> r146 = r145.f435759a.iterator();
    L101:
        if (r146.hasNext() == false) goto L105;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r147 = r129.f435766d.get(Integer.valueOf(((Number) r146.next()).intValue()));
        if (r147 == null) goto L101;
        r147.f435771b = false;
        goto L101
    L105:
        Iterator<T> r148 = r140.f435759a.iterator();
    L107:
        if (r148.hasNext() == false) goto L111;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r149 = r129.f435766d.get(Integer.valueOf(((Number) r148.next()).intValue()));
        if (r149 == null) goto L107;
        r149.f435771b = false;
        goto L107
    L111:
        int r150 = e.f569330a;
        int r151 = ((Number) CollectionsKt.last(r145.f435759a)).intValue() + 1;
        int r152 = ((Number) CollectionsKt.first(r140.f435759a)).intValue();
        Intrinsics.checkNotNullParameter("", "text");
        TextStyleInfo r153 = new TextStyleInfo();
        r153.type = 4;
        r153.start = r151;
        r153.end = r152;
        r153.text = "";
        r153.isBold = true;
        if (r151 >= r152) goto L114;
        ((ArrayList) r129.f435769g).add(r153);
    L115:
        r129.f435765c--;
        goto L119
    L114:
        int r154 = bwb.b.f21271a;
        bwb.b.h(MmUiLogScene.SUMMARY, "onFoundPairedBoldStyle", "onFoundPairedBoldStyle start " + r153.start + " end " + r153.end + " skip", null);
        goto L115
    L83:
        if (r136.f435772c == true) goto L85;
        r138 = true;
        goto L86
    L77:
        if (r136.f435770a != '*') goto L79;
        r137 = true;
    L119:
        r131 = r131 + 1;
        r132 = r134;
        goto L71
    L120:
        int r155 = r129.f435768f.length();
        int r156 = r129.f435763a.length();
        int r157 = 0;
    L121:
        if (r157 >= r156) goto L128;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C5197a r158 = r129.f435766d.get(Integer.valueOf(r157));
        if (r158 == null) goto L127;
        if (r158.f435771b == false) goto L127;
        r129.f435767e.put(Integer.valueOf(r157), Integer.valueOf(r155));
        r129.f435768f.append(r158.f435770a);
        r155 = r155 + 1;
    L127:
        r157 = r157 + 1;
        goto L121
    L128:
        ArrayList r159 = new ArrayList();
        Iterator r160 = ((ArrayList) r129.f435769g).iterator();
    L130:
        if (r160.hasNext() == false) goto L140;
        SpanInfo r161 = (SpanInfo) r160.next();
        int r162 = r161.end;
        int r163 = r161.start;
        int r164 = r162 - r163;
        Integer r165 = r129.f435767e.get(Integer.valueOf(r163));
        if (r165 == null) goto L134;
        int r166 = r165.intValue();
    L135:
        r161.start = r166;
        int r167 = r164 + r166;
        r161.end = r167;
        r161.text = r129.f435768f.substring(r166, r167);     // Catch: Exception -> L138
        r159.add(r161);     // Catch: Exception -> L138
    L138:
        e = move-exception;
        int r168 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.SUMMARY, "generateNewContent", "generateNewContent origin start " + r163 + " new start " + r161.start + " origin end " + r161.end + " text length " + r129.f435768f.length() + ' ' + e, null);
        goto L130
    L134:
        r166 = r161.start;
        goto L135
    L140:
        r129.f435769g = r159;
        ((ArrayList) r129.f435764b).clear();
        r129.f435766d.clear();
        r111.put(r110, r112);
        r104 = r104 + 1;
        r100 = this;
        r102 = r116;
        r103 = r117;
        r101 = r101;
    L67:
        r128 = 0;
    L25:
        r124 = r121.f569324c;
        if (r124 != null) goto L27;
        LarkAppContext.Companion.getClass();
        r125 = UDColorUtils.getColor(LarkAppContext.access$getInstance$cp().getContext(), R.color.text_title);
        goto L29
    L16:
        if (r108 > 3) goto L19;
        r122 = r121.f569325d.get(Integer.valueOf(r108));
        goto L20
    L30:
        r116 = r102;
        r117 = r103;
        r101 = r101;
        if (Intrinsics.areEqual("*", r106) == false) goto L34;
        r112.a(r112.f569315d);
        goto L36
    L34:
        if (Intrinsics.areEqual("-", r106) == false) goto L37;
        r112.a(r112.f569315d);
        goto L36
    L37:
        r127 = false;
        goto L38
    L41:
        r116 = r102;
        r117 = r103;
        r101 = r101;
        if (r107 != '*') goto L48;
        if (r114 == true) goto L69;
        String r169 = r106 + r107;
    L46:
        r106 = r169;
        r114 = true;
        goto L65
    L48:
        if (r107 != '-') goto L53;
        if (r114 == true) goto L69;
        r169 = r106 + r107;
        goto L46
    L53:
        if (r107 != '.') goto L57;
        if (r114 == false) goto L69;
        r106 = r106 + r107;
        goto L65
    L57:
        if ('0' <= r107) goto L59;
    L61:
        boolean r170 = false;
    L62:
        if (r170 == false) goto L69;
        r169 = r106 + r107;
        goto L46
    L59:
        if (r107 >= ':') goto L61;
        r170 = true;
        goto L62
    L66:
        r116 = r102;
        r117 = r103;
        r101 = r101;
        goto L67
    L141:
        boolean r211 = r101;
        com.ss.android.lark.widget.light.e.a r171 = new com.ss.android.lark.widget.light.e.a(getContext());
        r171.f446016g = (int) UIHelper.sp2px(this.f569318a.f569322a);
        com.ss.android.lark.widget.light.e r172 = new com.ss.android.lark.widget.light.e(r171);
        int r173 = 0;
    L143:
        if (this.f569319b.get(Integer.valueOf(r173)) == null) goto L205;
        a r174 = this.f569319b.get(Integer.valueOf(r173));
        if (r174 == null) goto L204;
        List<SpanInfo> r175 = r174.f569314c;
        if (r175 == null) goto L204;
        SpanInfo r176 = (SpanInfo) CollectionsKt.firstOrNull(r175);
        if (r176 == null) goto L204;
        if ((r176 instanceof PrefixInfo) == false) goto L153;
        PrefixInfo r177 = (PrefixInfo) r176;
    L154:
        if (r177 == null) goto L204;
        if (r177.prefixParams.getType() != PrefixSpan.Type.LIST_NUM) goto L204;
        int r178 = CastIntegerProtector.parseInt(StringsKt.dropLast(r177.prefixParams.f448592g, 1));     // Catch: NumberFormatException -> L159
        PrefixSpan.Type r179 = null;
    L161:
        PrefixSpan.b r180 = r177.prefixParams;
        StringBuilder r181 = new StringBuilder();
        r181.append((r173 - r173) + r178);
        r181.append('.');
        r180.f448592g = r181.toString();
        c.a(r177.prefixParams);
        int r182 = r174.f569315d;
        int r183 = r173;
    L162:
        int r184 = r183 + 1;
        a r185 = this.f569319b.get(Integer.valueOf(r184));
        if (r185 == null) goto L176;
        List<SpanInfo> r186 = r185.f569314c;
        if (r186 == null) goto L176;
        SpanInfo r187 = (SpanInfo) CollectionsKt.firstOrNull(r186);
        if (r187 == null) goto L176;
        if ((r187 instanceof PrefixInfo) == false) goto L171;
        PrefixInfo r188 = (PrefixInfo) r187;
    L172:
        if (r188 == 0) goto L176;
        PrefixSpan.b r189 = r188.prefixParams;
        if (r189 == null) goto L176;
        PrefixSpan.Type r190 = r189.getType();
    L178:
        if (r190 != PrefixSpan.Type.LIST_NUM) goto L202;
        a r191 = this.f569319b.get(Integer.valueOf(r184));
        if (r191 != null) goto L182;
    L184:
        boolean r192 = false;
    L185:
        if (r192 == false) goto L202;
        a r193 = this.f569319b.get(Integer.valueOf(r184));
        if (r193 == null) goto L201;
        List<SpanInfo> r194 = r193.f569314c;
        if (r194 == null) goto L201;
        SpanInfo r195 = (SpanInfo) CollectionsKt.firstOrNull(r194);
        if (r195 == null) goto L201;
        if ((r195 instanceof PrefixInfo) == false) goto L195;
        PrefixInfo r196 = (PrefixInfo) r195;
    L196:
        if (r196 == 0) goto L201;
        PrefixSpan.b r197 = r196.prefixParams;
        if (r197 == null) goto L201;
        StringBuilder r198 = new StringBuilder();
        r198.append((r184 - r173) + r178);
        r198.append('.');
        r197.f448592g = r198.toString();
        c.a(r197);
        goto L201
    L195:
        r196 = r179;
    L201:
        r183 = r184;
        goto L162
    L182:
        if (r191.f569315d != r182) goto L184;
        r192 = true;
    L202:
        r173 = r183;
        goto L204
    L171:
        r188 = r179;
    L176:
        r190 = r179;
    L159:
        e = move-exception;
        int r199 = bwb.b.f21271a;
        r179 = null;
        bwb.b.b(MmUiLogScene.SUMMARY, "parseBlocks", "Integer.parseInt " + r177.prefixParams.f448592g + " error " + e, null, 8);
        r178 = 1;
        goto L161
    L153:
        r177 = null;
    L204:
        r173 = r173 + 1;
        goto L143
    L205:
        int r200 = 0;
    L207:
        if (this.f569319b.get(Integer.valueOf(r200)) == null) goto L233;
        a r201 = this.f569319b.get(Integer.valueOf(r200));
        if (r201 == null) goto L232;
        if (r201.b().length() <= 0) goto L213;
        boolean r202 = true;
    L214:
        if (r202 == true) goto L218;
        if ((!((ArrayList) r201.f569314c).isEmpty()) == false) goto L232;
    L218:
        if (r201.f569317f == true) goto L224;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r203 = r201.f569316e;
        if (r203 == null) goto L223;
        ((ArrayList) r201.f569314c).addAll(r203.f435769g);
    L223:
        r201.f569317f = true;
    L224:
        String r204 = r201.b();
        if (this.f569319b.get(Integer.valueOf(r200 + 1)) == null) goto L230;
        String r205 = r204 + '\n';
        if (r211 == false) goto L229;
        r204 = r205 + '\n';
        goto L230
    L229:
        r204 = r205;
    L230:
        this.f569320c.append(f.a.f446037a.b(getContext(), r204, r201.f569314c, r172));
        goto L232
    L213:
        r202 = false;
    L232:
        r200 = r200 + 1;
        goto L207
    }
}
