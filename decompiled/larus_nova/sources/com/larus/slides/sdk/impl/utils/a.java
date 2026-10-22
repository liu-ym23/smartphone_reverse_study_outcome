package com.larus.slides.sdk.impl.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f369785a = 0;

    static {
    }

    public static Map a(String r110) {
        HashMap r100 = new HashMap();
        if (r110 == null) goto L116;
        int r101 = r110.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L6:
        if (r102 > r101) goto L22;
        if (r103 == true) goto L9;
        int r104 = r102;
    L11:
        if (Intrinsics.compare(r110.charAt(r104), 32) > 0) goto L13;
        boolean r105 = true;
    L14:
        if (r103 == false) goto L15;
        if (r105 == false) goto L22;
        r101 = r101 - 1;
        goto L6
    L15:
        if (r105 == false) goto L16;
        r102 = r102 + 1;
        goto L6
    L16:
        r103 = true;
        goto L6
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = r101;
    L22:
        if (r110.subSequence(r102, r101 + 1).toString().length() != 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L116;
        List<String> r111 = new Regex("; ").split(r110, 0);
        if (r111.isEmpty() == true) goto L38;
        ListIterator<String> r107 = r111.listIterator(r111.size());
    L31:
        if (r107.hasPrevious() == false) goto L38;
        if (r107.previous().length() != 0) goto L35;
        boolean r108 = true;
    L36:
        if (r108 == true) goto L31;
        List r112 = CollectionsKt.take(r111, r107.nextIndex() + 1);
    L39:
        String[] r113 = (String[]) r112.toArray(new String[0]);
        int r109 = r113.length;
        int r114 = 0;
    L40:
        if (r114 >= r109) goto L116;
        String r115 = r113[r114];
        int r116 = r115.length() - 1;
        int r117 = 0;
        boolean r118 = false;
    L42:
        if (r117 > r116) goto L58;
        if (r118 == true) goto L45;
        int r119 = r117;
    L47:
        if (Intrinsics.compare(r115.charAt(r119), 32) > 0) goto L49;
        boolean r120 = true;
    L50:
        if (r118 == false) goto L51;
        if (r120 == false) goto L58;
        r116 = r116 - 1;
        goto L42
    L51:
        if (r120 == false) goto L52;
        r117 = r117 + 1;
        goto L42
    L52:
        r118 = true;
        goto L42
    L49:
        r120 = false;
        goto L50
    L45:
        r119 = r116;
    L58:
        if (r115.subSequence(r117, r116 + 1).toString().length() != 0) goto L60;
        boolean r121 = true;
    L61:
        if (r121 == true) goto L115;
        int r122 = StringsKt.indexOf$default(r115, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);
        if (r122 != (-1)) goto L82;
        int r123 = r115.length() - 1;
        int r124 = 0;
        boolean r125 = false;
    L66:
        if (r124 > r123) goto L81;
        if (r125 == true) goto L69;
        int r126 = r124;
    L71:
        if (Intrinsics.compare(r115.charAt(r126), 32) > 0) goto L73;
        boolean r127 = true;
    L74:
        if (r125 == false) goto L75;
        if (r127 == false) goto L81;
        r123 = r123 - 1;
        goto L66
    L75:
        if (r127 == false) goto L76;
        r124 = r124 + 1;
        goto L66
    L76:
        r125 = true;
        goto L66
    L73:
        r127 = false;
        goto L74
    L69:
        r126 = r123;
    L81:
        r100.put(r115.subSequence(r124, r123 + 1).toString(), "");
        goto L115
    L82:
        String r128 = r115.substring(0, r122);
        int r129 = r128.length() - 1;
        int r130 = 0;
        boolean r131 = false;
    L83:
        if (r130 > r129) goto L98;
        if (r131 == true) goto L86;
        int r132 = r130;
    L88:
        if (Intrinsics.compare(r128.charAt(r132), 32) > 0) goto L90;
        boolean r133 = true;
    L91:
        if (r131 == false) goto L92;
        if (r133 == false) goto L98;
        r129 = r129 - 1;
        goto L83
    L92:
        if (r133 == false) goto L93;
        r130 = r130 + 1;
        goto L83
    L93:
        r131 = true;
        goto L83
    L90:
        r133 = false;
        goto L91
    L86:
        r132 = r129;
    L98:
        String r134 = r128.subSequence(r130, r129 + 1).toString();
        String r135 = r115.substring(r122 + 1);
        int r136 = r135.length() - 1;
        int r137 = 0;
        boolean r138 = false;
    L99:
        if (r137 > r136) goto L114;
        if (r138 == true) goto L102;
        int r139 = r137;
    L104:
        if (Intrinsics.compare(r135.charAt(r139), 32) > 0) goto L106;
        boolean r140 = true;
    L107:
        if (r138 == false) goto L108;
        if (r140 == false) goto L114;
        r136 = r136 - 1;
        goto L99
    L108:
        if (r140 == false) goto L109;
        r137 = r137 + 1;
        goto L99
    L109:
        r138 = true;
        goto L99
    L106:
        r140 = false;
        goto L107
    L102:
        r139 = r136;
    L114:
        r100.put(r134, r135.subSequence(r137, r136 + 1).toString());
    L115:
        r114 = r114 + 1;
        goto L40
    L60:
        r121 = false;
        goto L61
    L35:
        r108 = false;
    L38:
        r112 = CollectionsKt.emptyList();
        goto L39
    L24:
        r106 = false;
    L116:
        return r100;
    }
}
