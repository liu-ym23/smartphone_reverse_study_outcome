package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes23.dex */
public final class u0 {
    public static final String e(String r100) {
        String r101 = f(r100);
        return new Regex("\\s+").replace(r101, " ");
    }

    public static final String f(String r110) {
        if (StringsKt.contains$default(r110, "&", false, 2, null) == true) goto L5;
        String r100 = r110;
    L7:
        return StringsKt.replace$default(StringsKt.trim(r100).toString(), InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "", false, 4, null);
    L5:
        r100 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "&amp;", "&", false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&apos;", "'", false, 4, null), "&nbsp;", " ", false, 4, null);
        goto L7
    }

    public static final List a(List r100, String... r101) {
        ArrayList r102 = new ArrayList();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        Iterator r103 = r100.iterator();
    L6:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L22;
        String r105 = StringsKt.trim((String) r103.next()).toString();
        if ((!StringsKt.isBlank(r105)) == false) goto L6;
        if (r102.isEmpty() == true) goto L19;
        Iterator r106 = r102.iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        if (StringsKt.equals((String) r106.next(), r105, true) == false) goto L15;
    L20:
        if (r104 == false) goto L6;
        r102.add(r105);
    L19:
        r104 = true;
        goto L20
    L22:
        int r107 = r101.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L45;
        String r109 = r101[r108];
        if (r109 == null) goto L27;
        String r110 = StringsKt.trim(r109).toString();
    L28:
        if (r110 != null) goto L31;
        r110 = "";
    L31:
        if ((!StringsKt.isBlank(r110)) == false) goto L44;
        if (r102.isEmpty() == true) goto L41;
        Iterator r111 = r102.iterator();
    L37:
        if (r111.hasNext() == false) goto L41;
        if (StringsKt.equals((String) r111.next(), r110, true) == false) goto L37;
        boolean r112 = false;
    L42:
        if (r112 == false) goto L44;
        r102.add(r110);
    L41:
        r112 = true;
    L44:
        r108 = r108 + 1;
        goto L23
    L27:
        r110 = null;
        goto L28
    L45:
        return r102;
    }

    public static final IntRange d(String r100, String r101) {
        Locale r102 = Locale.ROOT;
        int r103 = StringsKt.indexOf$default(r100.toLowerCase(r102), r101.toLowerCase(r102), 0, false, 6, null);
        if (r103 >= 0) goto L7;
        return null;
    L7:
        return RangesKt.until(r103, r101.length() + r103);
    }

    public static final String b(String r110, String r111, String r210, float r211, Function1<? super String, Float> r212) {
        int r100 = 0;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        return "";
    L10:
        if (r212.invoke(r111 + r110).floatValue() > r211) goto L13;
        return r110;
    L13:
        if (r210.length() != 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L19;
        return "";
    L19:
        if (r212.invoke(r111 + r210).floatValue() < r211) goto L21;
        return r210;
    L21:
        List r103 = StringsKt.toList(r110);
        int r104 = r103.size();
    L22:
        if (r100 >= r104) goto L28;
        int r105 = r104 - ((r104 - r100) >> 1);
        if (r212.invoke(r111 + CollectionsKt.joinToString$default(CollectionsKt.take(r103, r105), "", null, null, 0, null, null, 62, null) + r210).floatValue() <= r211) goto L25;
        r104 = r105 - 1;
        goto L22
    L25:
        r100 = r105;
        goto L22
    L28:
        return CollectionsKt.joinToString$default(CollectionsKt.take(r103, r100), "", null, null, 0, null, null, 62, null) + r210;
    L15:
        r102 = false;
        goto L16
    L5:
        r101 = false;
        goto L7
    }

    public static CharSequence c(String r210, List r211, int r212, boolean r310, int r311, Function1 r312, int r313) {
        if ((r313 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r313 & 16) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r313 & 32) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r313 & 64) == 0) goto L17;
        final Function1 r103 = null;
    L18:
        char r104 = '\n';
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r211, 10));
        Iterator r106 = r211.iterator();
    L20:
        if (r106.hasNext() == false) goto L22;
        r105.add(e((String) r106.next()));
        goto L20
    L22:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r105.iterator();
    L24:
        if (r108.hasNext() == false) goto L28;
        Object r110 = r108.next();
        if ((!StringsKt.isBlank((String) r110)) == false) goto L24;
        r107.add(r110);
        goto L24
    L28:
        ArrayList r109 = new ArrayList();
        Iterator r111 = r107.iterator();
    L30:
        if (r111.hasNext() == false) goto L44;
        String r112 = (String) r111.next();
        if (r109.isEmpty() == true) goto L40;
        Iterator r113 = r109.iterator();
    L36:
        if (r113.hasNext() == false) goto L40;
        if (StringsKt.equals((String) r113.next(), r112, true) == false) goto L36;
        boolean r114 = false;
    L41:
        if (r114 == false) goto L30;
        r109.add(r112);
    L40:
        r114 = true;
        goto L41
    L44:
        if (r109.isEmpty() == true) goto L154;
        if (StringsKt.isBlank(r210) == true) goto L154;
        String r115 = e((String) CollectionsKt.first(r109));
        if (StringsKt.isBlank(r115) == true) goto L154;
        String r116 = f(r210);
        IntRange r117 = d(r116, r115);
        if (r117 == null) goto L154;
        String r118 = r116.substring(0, r117.getFirst());
        int r119 = r118.length() - 1;
        if (r119 < 0) goto L68;
    L56:
        int r120 = r119 - 1;
        char r121 = r118.charAt(r119);
        if (r121 != r104) goto L59;
    L62:
        boolean r122 = true;
    L63:
        if (r122 == true) goto L64;
        if (r120 < 0) goto L68;
        r119 = r120;
        r104 = '\n';
        goto L56
    L64:
        int r123 = r119;
    L69:
        String r124 = "...";
        if (r123 < 0) goto L74;
        r116 = "..." + r116.substring(r123 + 1, r117.getFirst()) + r116.substring(r117.getFirst());
        if (d(r116, r115) == null) goto L154;
    L74:
        String r125 = e(r116);
        IntRange r126 = d(r125, r115);
        if (r126 == null) goto L154;
        if (r101 == false) goto L81;
        if (r102 <= 0) goto L81;
        if (r103 == null) goto L81;
        boolean r127 = true;
    L83:
        if (r127 == false) goto L133;
        float r128 = r102;
        if (((Number) r103.invoke(r125)).floatValue() <= r128) goto L133;
        float r129 = ((Number) r103.invoke(r115)).floatValue();
        float r130 = ((Number) r103.invoke("...")).floatValue();
        String r131 = r125.substring(0, r126.getFirst());
        String r132 = r125.substring(r126.getLast() + 1);
        if (r131.length() <= 0) goto L89;
        boolean r133 = true;
    L91:
        if (r132.length() <= 0) goto L93;
        boolean r134 = true;
    L94:
        String r135 = "";
        if (r133 == false) goto L97;
        String r136 = "...";
    L98:
        if (r134 == true) goto L102;
        r124 = "";
    L102:
        if (r133 == false) goto L104;
        float r137 = r130;
    L105:
        if (r134 == true) goto L108;
        r130 = 0.0f;
    L108:
        float r138 = ((Number) r103.invoke(r131)).floatValue();
        float r139 = ((Number) r103.invoke(r132)).floatValue();
        if (((r138 + r129) + r130) > r128) goto L111;
        String r140 = r131.concat(r115);
        String r141 = r140 + b(r132, r140, r124, r128, r103);
    L143:
        r125 = r141;
    L144:
        String r142 = r125.toLowerCase(Locale.ROOT);
        SpannableString r143 = new SpannableString(r125);
        Iterator r144 = r109.iterator();
    L146:
        if (r144.hasNext() == false) goto L183;
        String r145 = e((String) r144.next());
        if (StringsKt.isBlank(r145) == true) goto L146;
        String r146 = r145.toLowerCase(Locale.ROOT);
        int r147 = StringsKt.indexOf$default(r142, r146, 0, false, 6, null);
    L150:
        if (r147 < 0) goto L146;
        int r148 = r145.length() + r147;
        r143.setSpan(new ForegroundColorSpan(r212), r147, r148, 33);
        r147 = StringsKt.indexOf$default(r142, r146, r148, false, 4, null);
        goto L150
    L183:
        return r143;
    L111:
        float r149 = (r128 - r129) - r137;
        float r150 = RangesKt.coerceAtLeast((r149 - r130) - 15.0f, 0.0f);
        float r151 = RangesKt.coerceAtLeast(((r149 - r139) - r130) + 15.0f, 0.0f);
        final List r152 = StringsKt.toList(r131);
        Function1 r153 = new t0(r103, r152);
        int r154 = r152.size();
        int r155 = 0;
    L112:
        if (r155 >= r154) goto L119;
        int r156 = ((r155 + r154) + 1) / 2;
        if (((Number) r103.invoke(CollectionsKt.joinToString$default(CollectionsKt.takeLast(r152, r156), "", null, null, 0, null, null, 62, null))).floatValue() > r150) goto L116;
        r155 = r156;
        goto L112
    L116:
        r154 = r156 - 1;
        goto L112
    L119:
        if (r151 <= 0.0f) goto L127;
        if (r155 <= 0) goto L127;
        float r157 = RangesKt.coerceAtMost(r151, ((Number) r153.invoke(Integer.valueOf(r155))).floatValue());
        int r158 = r155;
        int r159 = 1;
    L122:
        if (r159 >= r158) goto L128;
        int r160 = (r159 + r158) / 2;
        if (((Number) r153.invoke(Integer.valueOf(r160))).floatValue() >= r157) goto L125;
        r159 = r160 + 1;
        goto L122
    L125:
        r158 = r160;
    L128:
        if (r155 < r159) goto L130;
        r155 = (r159 + r155) / 2;
    L130:
        if (r155 <= 0) goto L132;
        r135 = CollectionsKt.joinToString$default(CollectionsKt.takeLast(r152, r155), "", null, null, 0, null, null, 62, null);
    L132:
        String r161 = r136 + r135 + r115;
        r141 = r161 + b(r132, r161, r124, r128, r103);
    L127:
        r159 = 0;
        goto L128
    L104:
        r137 = 0.0f;
        goto L105
    L97:
        r136 = "";
        goto L98
    L93:
        r134 = false;
        goto L94
    L89:
        r133 = false;
    L133:
        if (r127 == true) goto L144;
        if (r100 == false) goto L144;
        if (r126.getFirst() <= 0) goto L144;
        int r162 = r126.getFirst();
        if (StringsKt.startsWith$default(r125, "...", false, 2, null) == true) goto L140;
    L142:
        r141 = "..." + r125.substring(r162);
        goto L143
    L140:
        if (r162 > 3) goto L142;
    L81:
        r127 = false;
        goto L83
    L59:
        if (r121 == '\r') goto L62;
        r122 = false;
    L68:
        r123 = -1;
    L154:
        return r210;
    L17:
        r103 = r312;
        goto L18
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
