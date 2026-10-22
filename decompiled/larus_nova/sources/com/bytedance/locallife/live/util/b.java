package com.bytedance.locallife.live.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static int a(String r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        String r100 = StringsKt.trim(r210).toString();
        Integer r110 = null;
        if (StringsKt.contains$default(r100, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L8;
        List r101 = StringsKt.split$default(r100, new String[]{" "}, false, 0, 6, null);
        if (r101.size() != 2) goto L8;
        r100 = (String) ListProtector.get(r101, 0);
    L8:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L10;
        Integer r102 = null;
    L22:
        if (r102 != null) goto L119;
        if (StringsKt.startsWith$default(r100, "rgba(", false, 2, null) == true) goto L27;
    L49:
        r102 = null;
    L50:
        if (r102 != null) goto L119;
        if (StringsKt.startsWith$default(r100, "rgb(", false, 2, null) == true) goto L55;
    L73:
        r102 = null;
    L74:
        if (r102 != null) goto L119;
        if (StringsKt.equals(r100, "BLACK", true) == false) goto L80;
        r110 = -16777216;
    L112:
        if (r110 != null) goto L114;
        return 0;
    L114:
        return r110.intValue();
    L80:
        if (StringsKt.equals(r100, "DKGRAY", true) == false) goto L83;
        r110 = Integer.valueOf(FakePickerAvatarCreator.DKGRAY);
        goto L112
    L83:
        if (StringsKt.equals(r100, "GRAY", true) == false) goto L86;
        r110 = Integer.valueOf(FakePickerAvatarCreator.GRAY);
        goto L112
    L86:
        if (StringsKt.equals(r100, "LTGRAY", true) == false) goto L89;
        r110 = Integer.valueOf(FakePickerAvatarCreator.LTGRAY);
        goto L112
    L89:
        if (StringsKt.equals(r100, "WHITE", true) == false) goto L92;
        r110 = -1;
        goto L112
    L92:
        if (StringsKt.equals(r100, "RED", true) == false) goto L95;
        r110 = -65536;
        goto L112
    L95:
        if (StringsKt.equals(r100, "GREEN", true) == false) goto L98;
        r110 = Integer.valueOf(FakePickerAvatarCreator.GREEN);
        goto L112
    L98:
        if (StringsKt.equals(r100, "BLUE", true) == false) goto L101;
        r110 = Integer.valueOf(FakePickerAvatarCreator.BLUE);
        goto L112
    L101:
        if (StringsKt.equals(r100, "YELLOW", true) == false) goto L104;
        r110 = -256;
        goto L112
    L104:
        if (StringsKt.equals(r100, "CYAN", true) == false) goto L107;
        r110 = Integer.valueOf(FakePickerAvatarCreator.CYAN);
        goto L112
    L107:
        if (StringsKt.equals(r100, "MAGENTA", true) == false) goto L110;
        r110 = Integer.valueOf(FakePickerAvatarCreator.MAGENTA);
        goto L112
    L110:
        if (StringsKt.equals(r100, "TRANSPARENT", true) == false) goto L112;
        r110 = 0;
        goto L112
    L55:
        if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L73;
        int r103 = StringsKt.lastIndexOf$default(r100, ")", 0, false, 6, null);
        if (r100 == null) goto L72;
        List r104 = StringsKt.split$default(r100.substring(4, r103), new String[]{","}, false, 0, 6, null);
        String r105 = (String) ListProtector.get(r104, 0);
        if (r105 == null) goto L70;
        int r106 = CastIntegerProtector.parseInt(StringsKt.trim(r105).toString());
        String r107 = (String) ListProtector.get(r104, 1);
        if (r107 == null) goto L68;
        int r108 = CastIntegerProtector.parseInt(StringsKt.trim(r107).toString());
        String r109 = (String) ListProtector.get(r104, 2);
        if (r109 == null) goto L66;
        r102 = Integer.valueOf(Color.rgb(r106, r108, CastIntegerProtector.parseInt(StringsKt.trim(r109).toString())));
        goto L74
    L66:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L68:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L72:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L49;
        int r111 = StringsKt.lastIndexOf$default(r100, ")", 0, false, 6, null);
        if (r100 == null) goto L48;
        List r112 = StringsKt.split$default(r100.substring(5, r111), new String[]{","}, false, 0, 6, null);
        String r113 = (String) ListProtector.get(r112, 3);
        if (r113 == null) goto L46;
        int r114 = (int) (CastFloatProtector.parseFloat(StringsKt.trim(r113).toString()) * 255);
        String r115 = (String) ListProtector.get(r112, 0);
        if (r115 == null) goto L44;
        int r116 = CastIntegerProtector.parseInt(StringsKt.trim(r115).toString());
        String r117 = (String) ListProtector.get(r112, 1);
        if (r117 == null) goto L42;
        int r118 = CastIntegerProtector.parseInt(StringsKt.trim(r117).toString());
        String r119 = (String) ListProtector.get(r112, 2);
        if (r119 == null) goto L40;
        r102 = Integer.valueOf(Color.argb(r114, r116, r118, CastIntegerProtector.parseInt(StringsKt.trim(r119).toString())));
        goto L50
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L48:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L119:
        return r102.intValue();
    L10:
        if (r100.length() != 9) goto L16;
        String r120 = "#" + r100.substring(7, r100.length()) + r100.substring(1, r100.length() - 2);
        Intrinsics.checkNotNullParameter(r120, "<this>");
        int r121 = Color.parseColor(r120);     // Catch: Throwable -> L14
    L15:
        r102 = Integer.valueOf(r121);
    L14:
        r121 = 0;
        goto L15
    L16:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r122 = Color.parseColor(r100);     // Catch: Throwable -> L19
    L20:
        r102 = Integer.valueOf(r122);
    L19:
        r122 = 0;
        goto L20
    }

    public static final GradientDrawable b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (StringsKt.startsWith$default(r110, "linear-gradient", false, 2, null) == false) goto L173;
        ArrayList r100 = new ArrayList();
        int r101 = StringsKt.indexOf$default(r110, "(", 0, false, 6, null) + 1;     // Catch: Exception -> L56
        int r102 = StringsKt.lastIndexOf$default(r110, ")", 0, false, 6, null);     // Catch: Exception -> L56
        if (r110 == null) goto L55;
        String r103 = r110.substring(r101, r102);     // Catch: Exception -> L56
        if (StringsKt.contains$default(r103, "rgba", false, 2, null) == false) goto L28;
        Iterator r111 = StringsKt.split$default(r103, new String[]{"rgba"}, false, 0, 6, null).iterator();     // Catch: Exception -> L56
        int r104 = 0;
    L12:
        if (r111.hasNext() == false) goto L58;
        Object r105 = r111.next();     // Catch: Exception -> L56
        int r106 = r104 + 1;     // Catch: Exception -> L56
        if (r104 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L56
    L16:
        String r107 = (String) r105;     // Catch: Exception -> L56
        if (r107 == null) goto L26;
        String r108 = StringsKt.trim(r107).toString();     // Catch: Exception -> L56
        if (StringsKt.endsWith$default(r108, ",", false, 2, null) == false) goto L21;
        r108 = r108.substring(0, r108.length() - 1);     // Catch: Exception -> L56
    L21:
        if (r104 <= 0) goto L23;
        r100.add("rgba" + r108);     // Catch: Exception -> L56
    L24:
        r104 = r106;
        goto L12
    L23:
        r100.add(r108);     // Catch: Exception -> L56
        goto L24
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L56
    L58:
        Intrinsics.checkNotNullParameter(r100, "linear");
        ArrayList r112 = new ArrayList();
        Iterator r109 = r100.iterator();
    L60:
        if (r109.hasNext() == false) goto L64;
        String r113 = (String) r109.next();
        if (StringsKt.startsWith$default(r113, RemoteMessageConst.TO, false, 2, null) == true) goto L60;
        r112.add(r113);
        goto L60
    L64:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r112.iterator();
    L66:
        if (r115.hasNext() == false) goto L69;
        r114.add(Integer.valueOf(a((String) r115.next())));
        goto L66
    L69:
        if ((!r100.isEmpty()) == false) goto L170;
        String r116 = (String) ListProtector.get(r100, 0);
        switch(r116.hashCode()) {
            case -2080783504: goto L166;
            case -1849920841: goto L162;
            case -1507310228: goto L158;
            case -1486250643: goto L154;
            case -1359525897: goto L150;
            case -1352032154: goto L146;
            case -1213049204: goto L142;
            case -1137407871: goto L138;
            case -1033506462: goto L134;
            case -870406608: goto L130;
            case -868157182: goto L126;
            case -172068863: goto L122;
            case 1529302: goto L118;
            case 49701349: goto L114;
            case 54169999: goto L110;
            case 110550266: goto L106;
            case 810031148: goto L102;
            case 1055841335: goto L98;
            case 1176531318: goto L94;
            case 1451606227: goto L90;
            case 1456074877: goto L86;
            case 1479311857: goto L82;
            case 1483780507: goto L78;
            case 1507017487: goto L74;
            default: goto L169;
        };
    L169:
        GradientDrawable.Orientation r117 = GradientDrawable.Orientation.TOP_BOTTOM;
    L191:
        return c(r117, r114);
    L74:
        if (r116.equals("315deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.TR_BL;
        goto L191
    L78:
        if (r116.equals("270deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L191
    L82:
        if (r116.equals("225deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.BR_TL;
        goto L191
    L86:
        if (r116.equals("180deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L191
    L90:
        if (r116.equals("135deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.TL_BR;
        goto L191
    L94:
        if (r116.equals("tobottomright") == false) goto L169;
        r117 = GradientDrawable.Orientation.TL_BR;
        goto L191
    L98:
        if (r116.equals("to right") == false) goto L169;
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L191
    L102:
        if (r116.equals("to top right") == false) goto L169;
        r117 = GradientDrawable.Orientation.BL_TR;
        goto L191
    L106:
        if (r116.equals("totop") == false) goto L169;
        r117 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L191
    L110:
        if (r116.equals("90deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L191
    L114:
        if (r116.equals("45deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.BL_TR;
        goto L191
    L118:
        if (r116.equals("0deg") == false) goto L169;
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L191
    L122:
        if (r116.equals("totopleft") == false) goto L169;
        r117 = GradientDrawable.Orientation.BR_TL;
        goto L191
    L126:
        if (r116.equals("toleft") == false) goto L169;
        r117 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L191
    L130:
        if (r116.equals("to top") == false) goto L169;
        r117 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L191
    L134:
        if (r116.equals("totopright") == false) goto L169;
        r117 = GradientDrawable.Orientation.BL_TR;
        goto L191
    L138:
        if (r116.equals("toright") == false) goto L169;
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L191
    L142:
        if (r116.equals("to left") == false) goto L169;
        r117 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L191
    L146:
        if (r116.equals("tobottom") == false) goto L169;
        r117 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L191
    L150:
        if (r116.equals("to top left") == false) goto L169;
        r117 = GradientDrawable.Orientation.BR_TL;
        goto L191
    L154:
        if (r116.equals("tobottomleft") == false) goto L169;
        r117 = GradientDrawable.Orientation.TR_BL;
        goto L191
    L158:
        if (r116.equals("to bottom right") == false) goto L169;
        r117 = GradientDrawable.Orientation.TL_BR;
        goto L191
    L162:
        if (r116.equals("to bottom left") == false) goto L169;
        r117 = GradientDrawable.Orientation.TR_BL;
        goto L191
    L166:
        if (r116.equals("to bottom") == false) goto L169;
        r117 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L191
    L170:
        r117 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L191
    L28:
        if (StringsKt.contains$default(r103, "rgb", false, 2, null) == false) goto L46;
        Iterator r118 = StringsKt.split$default(r103, new String[]{"rgb"}, false, 0, 6, null).iterator();     // Catch: Exception -> L56
        int r119 = 0;
    L31:
        if (r118.hasNext() == false) goto L58;
        Object r120 = r118.next();     // Catch: Exception -> L56
        int r121 = r119 + 1;     // Catch: Exception -> L56
        if (r119 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L56
    L35:
        String r122 = (String) r120;     // Catch: Exception -> L56
        if (r122 == null) goto L45;
        String r123 = StringsKt.trim(r122).toString();     // Catch: Exception -> L56
        if (StringsKt.endsWith$default(r123, ",", false, 2, null) == false) goto L40;
        r123 = r123.substring(0, r123.length() - 1);     // Catch: Exception -> L56
    L40:
        if (r119 <= 0) goto L42;
        r100.add("rgb" + r123);     // Catch: Exception -> L56
    L43:
        r119 = r121;
        goto L31
    L42:
        r100.add(r123);     // Catch: Exception -> L56
        goto L43
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L56
    L46:
        Iterator r124 = StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null).iterator();     // Catch: Exception -> L56
    L48:
        if (r124.hasNext() == false) goto L58;
        String r125 = (String) r124.next();     // Catch: Exception -> L56
        if (r125 == null) goto L53;
        r100.add(StringsKt.trim(r125).toString());     // Catch: Exception -> L56
        goto L48
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L56
    L55:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L173:
        return c(GradientDrawable.Orientation.LEFT_RIGHT, CollectionsKt.listOf(Integer.valueOf(a(r110))));
    }

    public static final GradientDrawable c(GradientDrawable.Orientation r100, List<Integer> r101) {
        int r102 = 0;
        if (r101.size() != 1) goto L5;
        int r103 = ((Number) ListProtector.get(r101, 0)).intValue();
        return new GradientDrawable(r100, new int[]{r103, r103});
    L5:
        int[] r104 = new int[r101.size()];
        Iterator<T> r105 = r101.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        int r107 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r104[r102] = ((Number) r106).intValue();
        r102 = r107;
        goto L7
    L13:
        return new GradientDrawable(r100, r104);
    }
}
