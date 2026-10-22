package ma0;

import androidx.core.app.NotificationCompat;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.LinkedHashMap;
import java.util.Stack;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public a() {
    }

    public static String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "str");
        Stack r100 = new Stack();
        int r101 = r110.length();
        String r102 = "";
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r101) goto L51;
        if (r104 == false) goto L6;
        r104 = false;
    L49:
        r103 = r103 + 1;
        goto L3
    L6:
        char r105 = r110.charAt(r103);
        if (r105 == '&') goto L34;
        if (r105 == '|') goto L24;
        if (r105 != '(') goto L11;
        r100.push(Character.valueOf(r105));
        goto L49
    L11:
        if (r105 == ')') goto L14;
        r102 = r102 + r105;
    L14:
        if (r100.empty() == true) goto L49;
        Character r106 = (Character) r100.pop();
        if (r106 == null) goto L21;
        if (r106.charValue() == '(') goto L49;
    L21:
        r102 = r102 + r106;
    L24:
        if (r100.isEmpty() == true) goto L25;
        Character r107 = (Character) r100.pop();
        if (r107 == null) goto L32;
        if (r107.charValue() != '(') goto L32;
        r100.push(r107);
        r100.push(Character.valueOf(r105));
    L48:
        r104 = true;
    L32:
        r102 = r102 + r107;
        goto L24
    L25:
        r100.push(Character.valueOf(r105));
    L34:
        if (r100.isEmpty() == true) goto L35;
        Character r108 = (Character) r100.peek();
        if (r108 != null) goto L40;
    L41:
        if (r108 == null) goto L46;
        if (r108.charValue() != '|') goto L46;
    L47:
        r100.push(Character.valueOf(r105));
    L46:
        r100.pop();
        r102 = r102 + r108;
        goto L34
    L40:
        if (r108.charValue() == '(') goto L47;
    L35:
        r100.push(Character.valueOf(r105));
    L51:
        if (r100.empty() == true) goto L54;
        r102 = r102 + ((Character) r100.pop());
        goto L51
    L54:
        return new Regex("\\s").replace(r102, "");
    }

    public static boolean b(String r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "suffix");
        Intrinsics.checkNotNullParameter(r111, NotificationCompat.CATEGORY_CALL);
        Stack r100 = new Stack();
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = r110.length();     // Catch: Exception -> L120
        int r103 = 0;
    L4:
        boolean r104 = true;
        if (r103 >= r102) goto L111;
        char r105 = r110.charAt(r103);     // Catch: Exception -> L120
        if (r105 != '&') goto L9;
        String r106 = (String) r100.pop();     // Catch: Exception -> L120
        String r107 = (String) r100.pop();     // Catch: Exception -> L120
        if (r101.containsKey(r106) == false) goto L81;
        if (r101.containsKey(r107) == false) goto L71;
        Boolean r108 = (Boolean) r101.get(r106);     // Catch: Exception -> L120
        Boolean r112 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r109 = Intrinsics.areEqual(r108, r112);     // Catch: Exception -> L120
        boolean r113 = Intrinsics.areEqual((Boolean) r101.get(r107), r112);     // Catch: Exception -> L120
        String r114 = r106 + "and" + r107;     // Catch: Exception -> L120
        if (r109 == false) goto L69;
        if (r113 == false) goto L69;
    L70:
        r101.put(r114, Boolean.valueOf(r104));     // Catch: Exception -> L120
    L108:
        r100.push(r106 + "and" + r107);     // Catch: Exception -> L120
    L109:
        r103 = r103 + 1;     // Catch: Exception -> L120
    L69:
        r104 = false;
        goto L70
    L71:
        boolean r115 = Intrinsics.areEqual((Boolean) r101.get(r106), Boolean.TRUE);     // Catch: Exception -> L120
        if (r115 == false) goto L79;
        boolean r116 = ((Boolean) r111.invoke(r107)).booleanValue();     // Catch: Exception -> L120
        String r117 = r106 + "and" + r107;     // Catch: Exception -> L120
        if (r115 == false) goto L77;
        if (r116 == false) goto L77;
    L78:
        r101.put(r117, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r107, Boolean.valueOf(r116));     // Catch: Exception -> L120
    L77:
        r104 = false;
        goto L78
    L79:
        r101.put(r106 + "and" + r107, Boolean.valueOf(r115));     // Catch: Exception -> L120
        goto L108
    L81:
        if (r101.containsKey(r107) == true) goto L83;
        boolean r118 = ((Boolean) r111.invoke(r106)).booleanValue();     // Catch: Exception -> L120
        r101.put(r106, Boolean.valueOf(r118));     // Catch: Exception -> L120
        if (r118 == false) goto L107;
        boolean r119 = ((Boolean) r111.invoke(r107)).booleanValue();     // Catch: Exception -> L120
        String r120 = r106 + "and" + r107;     // Catch: Exception -> L120
        if (r118 == false) goto L105;
        if (r119 == false) goto L105;
    L106:
        r101.put(r120, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r107, Boolean.valueOf(r119));     // Catch: Exception -> L120
    L105:
        r104 = false;
        goto L106
    L107:
        r101.put(r106 + "and" + r107, Boolean.valueOf(r118));     // Catch: Exception -> L120
        goto L108
    L83:
        if (r101.containsKey(r106) == false) goto L90;
        Boolean r121 = (Boolean) r101.get(r106);     // Catch: Exception -> L120
        Boolean r122 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r123 = Intrinsics.areEqual(r121, r122);     // Catch: Exception -> L120
        boolean r124 = Intrinsics.areEqual((Boolean) r101.get(r107), r122);     // Catch: Exception -> L120
        String r125 = r106 + "and" + r107;     // Catch: Exception -> L120
        if (r123 == false) goto L88;
        if (r124 == false) goto L88;
    L89:
        r101.put(r125, Boolean.valueOf(r104));     // Catch: Exception -> L120
    L88:
        r104 = false;
        goto L89
    L90:
        boolean r126 = Intrinsics.areEqual((Boolean) r101.get(r107), Boolean.TRUE);     // Catch: Exception -> L120
        if (r126 == false) goto L98;
        boolean r127 = ((Boolean) r111.invoke(r106)).booleanValue();     // Catch: Exception -> L120
        String r128 = r106 + "and" + r107;     // Catch: Exception -> L120
        if (r127 == false) goto L96;
        if (r126 == false) goto L96;
    L97:
        r101.put(r128, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r106, Boolean.valueOf(r127));     // Catch: Exception -> L120
    L96:
        r104 = false;
        goto L97
    L98:
        r101.put(r106 + "and" + r107, Boolean.valueOf(r126));     // Catch: Exception -> L120
        goto L108
    L9:
        if (r105 == '|') goto L11;
        r100.push(String.valueOf(r105));     // Catch: Exception -> L120
        goto L109
    L11:
        String r129 = (String) r100.pop();     // Catch: Exception -> L120
        String r130 = (String) r100.pop();     // Catch: Exception -> L120
        if (r101.containsKey(r129) == false) goto L32;
        if (r101.containsKey(r130) == false) goto L22;
        Boolean r131 = (Boolean) r101.get(r129);     // Catch: Exception -> L120
        Boolean r132 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r133 = Intrinsics.areEqual(r131, r132);     // Catch: Exception -> L120
        boolean r134 = Intrinsics.areEqual((Boolean) r101.get(r130), r132);     // Catch: Exception -> L120
        String r135 = r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130;     // Catch: Exception -> L120
        if (r133 == true) goto L21;
        if (r134 == true) goto L21;
        r104 = false;
    L21:
        r101.put(r135, Boolean.valueOf(r104));     // Catch: Exception -> L120
    L59:
        r100.push(r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130);     // Catch: Exception -> L120
        goto L109
    L22:
        boolean r136 = Intrinsics.areEqual((Boolean) r101.get(r129), Boolean.TRUE);     // Catch: Exception -> L120
        if (r136 == false) goto L25;
        r101.put(r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130, Boolean.valueOf(r136));     // Catch: Exception -> L120
        goto L59
    L25:
        boolean r137 = ((Boolean) r111.invoke(r130)).booleanValue();     // Catch: Exception -> L120
        String r138 = r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130;     // Catch: Exception -> L120
        if (r136 == true) goto L30;
        if (r137 == true) goto L30;
        r104 = false;
    L30:
        r101.put(r138, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r130, Boolean.valueOf(r137));     // Catch: Exception -> L120
        goto L59
    L32:
        if (r101.containsKey(r130) == true) goto L34;
        boolean r139 = ((Boolean) r111.invoke(r129)).booleanValue();     // Catch: Exception -> L120
        r101.put(r129, Boolean.valueOf(r139));     // Catch: Exception -> L120
        if (r139 == false) goto L53;
        r101.put(r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130, Boolean.valueOf(r139));     // Catch: Exception -> L120
        goto L59
    L53:
        boolean r140 = ((Boolean) r111.invoke(r130)).booleanValue();     // Catch: Exception -> L120
        String r141 = r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130;     // Catch: Exception -> L120
        if (r139 == true) goto L58;
        if (r140 == true) goto L58;
        r104 = false;
    L58:
        r101.put(r141, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r130, Boolean.valueOf(r140));     // Catch: Exception -> L120
        goto L59
    L34:
        if (r101.containsKey(r129) == false) goto L41;
        Boolean r142 = (Boolean) r101.get(r129);     // Catch: Exception -> L120
        Boolean r143 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r144 = Intrinsics.areEqual(r142, r143);     // Catch: Exception -> L120
        boolean r145 = Intrinsics.areEqual((Boolean) r101.get(r130), r143);     // Catch: Exception -> L120
        String r146 = r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130;     // Catch: Exception -> L120
        if (r144 == true) goto L40;
        if (r145 == true) goto L40;
        r104 = false;
    L40:
        r101.put(r146, Boolean.valueOf(r104));     // Catch: Exception -> L120
        goto L59
    L41:
        boolean r147 = Intrinsics.areEqual((Boolean) r101.get(r130), Boolean.TRUE);     // Catch: Exception -> L120
        if (r147 == false) goto L44;
        r101.put(r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130, Boolean.valueOf(r147));     // Catch: Exception -> L120
        goto L59
    L44:
        boolean r148 = ((Boolean) r111.invoke(r129)).booleanValue();     // Catch: Exception -> L120
        String r149 = r129 + SRStrategy.KEY_ORIGIN_RESOLUTION + r130;     // Catch: Exception -> L120
        if (r148 == true) goto L49;
        if (r147 == true) goto L49;
        r104 = false;
    L49:
        r101.put(r149, Boolean.valueOf(r104));     // Catch: Exception -> L120
        r101.put(r129, Boolean.valueOf(r148));     // Catch: Exception -> L120
        goto L59
    L111:
        if (r100.empty() == false) goto L113;
        return false;
    L113:
        if (r100.size() > 1) goto L127;
        String r150 = (String) r100.pop();     // Catch: Exception -> L120
        if (r101.containsKey(r150) == false) goto L119;
        return Intrinsics.areEqual((Boolean) r101.get(r150), Boolean.TRUE);
    L119:
        return ((Boolean) r111.invoke(r150)).booleanValue();
    L127:
        return false;
    L129:
        return false;
    }
}
