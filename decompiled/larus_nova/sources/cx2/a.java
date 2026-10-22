package cx2;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f465678a = null;

    /* JADX INFO: renamed from: cx2.a$a, reason: collision with other inner class name */
    public static final class C5599a {
        public static float c(float r100, float r101, float r102) {
            if (r102 >= 0.0f) goto L6;
            r102 = r102 + 6.0f;
        L6:
            if (r102 < 6.0f) goto L9;
            r102 = r102 - 6.0f;
        L9:
            if (r102 >= 1.0f) goto L12;
            float r103 = (r101 - r100) * r102;
        L18:
            return r100 + r103;
        L12:
            if (r102 >= 3.0f) goto L15;
            return r101;
        L15:
            if (r102 >= 4.0f) goto L20;
            r103 = (r101 - r100) * (4.0f - r102);
            goto L18
        L20:
            return r100;
        }

        public static int a(float r100) {
            if (r100 >= 0.0f) goto L6;
            return 0;
        L6:
            if (r100 <= 255.0f) goto L9;
            return 255;
        L9:
            return Math.round(r100);
        }

        public static int d(String r110) {
            Intrinsics.checkNotNullParameter(r110, "value");
            if (r110.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            int r101 = -16777216;
            if (r100 == false) goto L9;
            return -16777216;
        L9:
            int r102 = 4;
            Pair r103 = null;
            if (r110.charAt(0) != '#') goto L54;
            int r104 = c.f465684a;
            int r105 = r110.length();
            Intrinsics.checkNotNullParameter(r110, "input");
            if (1 >= r105) goto L39;
            long r106 = 0;
            int r107 = 1;
        L15:
            if (r107 >= r105) goto L36;
            char r108 = r110.charAt(r107);
            if (Intrinsics.compare(r108, 48) < 0) goto L22;
            if (Intrinsics.compare(r108, 57) > 0) goto L22;
            long r109 = r106 * ((long) 16);
            int r111 = r108 - '0';
        L32:
            r106 = r109 + ((long) r111);
            if (r106 > BodyPartID.bodyIdMax) goto L39;
            r107 = r107 + 1;
        L22:
            if (Intrinsics.compare(r108, 65) < 0) goto L27;
            if (Intrinsics.compare(r108, 70) > 0) goto L27;
            long r112 = r106 * ((long) 16);
            int r113 = r108 - 'A';
        L31:
            r109 = r112 + ((long) r113);
            r111 = 10;
        L27:
            if (Intrinsics.compare(r108, 97) < 0) goto L36;
            if (Intrinsics.compare(r108, 102) > 0) goto L36;
            r112 = r106 * ((long) 16);
            r113 = r108 - 'a';
        L36:
            if (r107 == 1) goto L39;
            r103 = new Pair(Integer.valueOf((int) r106), Integer.valueOf(r107));
        L39:
            if (r103 == null) goto L126;
            int r114 = ((Number) r103.getFirst()).intValue();
            int r115 = ((Number) r103.getSecond()).intValue();
            if (r115 == 4) goto L51;
            if (r115 != 5) goto L45;
            int r116 = 61440 & r114;
            int r117 = r114 & 3840;
            int r118 = r114 & 240;
            int r119 = r114 & 15;
            return (((((((r119 << 24) | (r119 << 28)) | (r116 << 8)) | (r116 << 4)) | (r117 << 4)) | r117) | r118) | (r118 >> 4);
        L45:
            if (r115 == 7) goto L53;
            if (r115 == 9) goto L124;
            return -16777216;
        L124:
            return (r114 | (r114 << 24)) >>> 8;
        L53:
            return r101 | r114;
        L51:
            int r120 = r114 & 3840;
            int r121 = r114 & 240;
            r114 = r114 & 15;
            r101 = ((((r120 << 8) | ((r120 << 12) | (-16777216))) | (r121 << 8)) | (r121 << 4)) | (r114 << 4);
            goto L53
        L126:
            return -16777216;
        L54:
            String r122 = r110.toLowerCase(Locale.US);
            boolean r123 = StringsKt.startsWith$default(r122, "rgba(", false, 2, null);
            boolean r124 = StringsKt.startsWith$default(r122, "rgb(", false, 2, null);
            boolean r125 = StringsKt.startsWith$default(r122, "hsla(", false, 2, null);
            boolean r126 = StringsKt.startsWith$default(r122, "hsl", false, 2, null);
            if (r123 == true) goto L89;
            if (r124 == true) goto L89;
            if (r126 == true) goto L66;
            if (r125 == true) goto L66;
            Integer r127 = (Integer) ((HashMap) a.f465678a).get(r110);
            if (r127 != null) goto L64;
            return -16777216;
        L64:
            return r127.intValue();
        L66:
            if (r125 == false) goto L68;
            r102 = 5;
        L68:
            e r128 = new e(r122.substring(r102));
            r128.d();
            float r129 = r128.c();
            float r130 = r128.a(r129);
            if (Float.isNaN(r130) == true) goto L71;
            r128.b('%');
        L71:
            float r131 = r128.a(r130);
            if (Float.isNaN(r131) == true) goto L74;
            r128.b('%');
        L74:
            if (r125 == false) goto L81;
            float r132 = r128.a(r131);
            r128.d();
            if (Float.isNaN(r132) == false) goto L78;
            return -16777216;
        L78:
            if (r128.b(')') == true) goto L130;
            return -16777216;
        L130:
            return b(r129, r130, r131) | (a(r132 * 256) << 24);
        L81:
            r128.d();
            if (Float.isNaN(r131) == false) goto L84;
            return -16777216;
        L84:
            if (r128.b(')') == true) goto L87;
            return -16777216;
        L87:
            return (-16777216) | b(r129, r130, r131);
        L89:
            if (r123 == false) goto L91;
            r102 = 5;
        L91:
            e r133 = new e(r110.substring(r102));
            r133.d();
            float r134 = r133.c();
            if (Float.isNaN(r134) == false) goto L94;
        L96:
            float r135 = r133.a(r134);
            if (Float.isNaN(r135) == false) goto L99;
        L101:
            float r136 = r133.a(r135);
            if (Float.isNaN(r136) == false) goto L104;
        L106:
            if (r123 == false) goto L112;
            float r137 = r133.a(r136);
            r133.d();
            if (Float.isNaN(r136) == false) goto L110;
            return -16777216;
        L110:
            if (r133.b(')') == false) goto L135;
            int r138 = ((a(r134) << 16) | (a(r137 * 256) << 24)) | (a(r135) << 8);
            int r139 = a(r136);
        L119:
            return r138 | r139;
        L135:
            return -16777216;
        L112:
            r133.d();
            if (Float.isNaN(r136) == false) goto L115;
            return -16777216;
        L115:
            if (r133.b(')') == false) goto L137;
            r138 = ((a(r134) << 16) | (-16777216)) | (a(r135) << 8);
            r139 = a(r136);
            goto L119
        L137:
            return -16777216;
        L104:
            if (r133.b('%') == false) goto L106;
            r136 = (r136 * 256) / 100;
            goto L106
        L99:
            if (r133.b('%') == false) goto L101;
            r135 = (r135 * 256) / 100;
            goto L101
        L94:
            if (r133.b('%') == false) goto L96;
            r134 = (r134 * 256) / 100;
            goto L96
        L5:
            r100 = false;
            goto L6
        }

        public static int b(float r100, float r101, float r102) {
            float r103 = 0.0f;
            float r104 = r100 % 360.0f;
            if (r100 >= 0.0f) goto L6;
            r104 = r104 + 360.0f;
        L6:
            float r105 = r104 / 60.0f;
            float r106 = r101 / 100.0f;
            float r107 = r102 / 100.0f;
            if (r106 >= 0.0f) goto L10;
            r106 = 0.0f;
        L13:
            if (r107 < 0.0f) goto L20;
            if (r107 <= 1.0f) goto L18;
            r103 = 1.0f;
            goto L20
        L18:
            r103 = r107;
        L20:
            if (r103 > 0.5f) goto L22;
            float r108 = (r106 + 1.0f) * r103;
        L23:
            float r109 = (r103 * 2.0f) - r108;
            float r110 = c(r109, r108, r105 + 2.0f);
            float r111 = c(r109, r108, r105);
            float r112 = c(r109, r108, r105 - 2.0f);
            int r113 = (a(r110 * 256.0f) << 16) | (a(r111 * 256.0f) << 8);
            return a(r112 * 256.0f) | r113;
        L22:
            r108 = (r103 + r106) - (r106 * r103);
            goto L23
        L10:
            if (r106 <= 1.0f) goto L13;
            r106 = 1.0f;
            goto L13
        }
    }

    static {
        HashMap r100 = new HashMap(47);
        f465678a = r100;
        r100.put("aliceblue", -984833);
        r100.put("antiquewhite", -332841);
        Integer r101 = Integer.valueOf(FakePickerAvatarCreator.CYAN);
        r100.put("aqua", r101);
        r100.put("aquamarine", -8388652);
        r100.put("azure", -983041);
        r100.put("beige", -657956);
        r100.put("bisque", -6972);
        r100.put("black", -16777216);
        r100.put("blanchedalmond", -5171);
        r100.put("blue", Integer.valueOf(FakePickerAvatarCreator.BLUE));
        r100.put("blueviolet", -7722014);
        r100.put("brown", -5952982);
        r100.put("burlywood", -2180985);
        r100.put("cadetblue", -10510688);
        r100.put("chartreuse", -8388864);
        r100.put("chocolate", -2987746);
        r100.put("coral", -32944);
        r100.put("cornflowerblue", -10185235);
        r100.put("cornsilk", -1828);
        r100.put("crimson", -2354116);
        r100.put("cyan", r101);
        r100.put("darkblue", -16777077);
        r100.put("darkcyan", -16741493);
        r100.put("darkgoldenrod", -4684277);
        r100.put("darkgray", -5658199);
        r100.put("darkgreen", -16751616);
        r100.put("darkgrey", -5658199);
        r100.put("darkkhaki", -4343957);
        r100.put("darkmagenta", -7667573);
        r100.put("darkolivegreen", -11179217);
        r100.put("darkorange", -29696);
        r100.put("darkorchid", -6737204);
        r100.put("darkred", -7667712);
        r100.put("darksalmon", -1468806);
        r100.put("darkseagreen", -7357297);
        r100.put("darkslateblue", -12042869);
        r100.put("darkslategray", -13676721);
        r100.put("darkslategrey", -13676721);
        r100.put("darkturquoise", -16724271);
        r100.put("darkviolet", -7077677);
        r100.put("deeppink", -60269);
        r100.put("deepskyblue", -16728065);
        r100.put("dimgray", -9868951);
        r100.put("dimgrey", -9868951);
        r100.put("dodgerblue", -14774017);
        r100.put("firebrick", -5103070);
        r100.put("floralwhite", -1296);
        r100.put("forestgreen", -14513374);
        Integer r102 = Integer.valueOf(FakePickerAvatarCreator.MAGENTA);
        r100.put("fuchsia", r102);
        r100.put("gainsboro", -2302756);
        r100.put("ghostwhite", -460545);
        r100.put("gold", -10496);
        r100.put("goldenrod", -2448096);
        r100.put("gray", -8355712);
        r100.put("green", -16744448);
        r100.put("greenyellow", -5374161);
        r100.put("grey", -8355712);
        r100.put("honeydew", -983056);
        r100.put("hotpink", -38476);
        r100.put("indianred", -3318692);
        r100.put("indigo", -11861886);
        r100.put("ivory", -16);
        r100.put("khaki", -989556);
        r100.put("lavender", -1644806);
        r100.put("lavenderblush", -3851);
        r100.put("lawngreen", -8586240);
        r100.put("lemonchiffon", -1331);
        r100.put("lightblue", -5383962);
        r100.put("lightcoral", -1015680);
        r100.put("lightcyan", -2031617);
        r100.put("lightgoldenrodyellow", -329006);
        r100.put("lightgray", -2894893);
        r100.put("lightgreen", -7278960);
        r100.put("lightgrey", -2894893);
        r100.put("lightpink", -18751);
        r100.put("lightsalmon", -24454);
        r100.put("lightseagreen", -14634326);
        r100.put("lightskyblue", -7876870);
        r100.put("lightslategray", -8943463);
        r100.put("lightslategrey", -8943463);
        r100.put("lightsteelblue", -5192482);
        r100.put("lightyellow", -32);
        r100.put("lime", Integer.valueOf(FakePickerAvatarCreator.GREEN));
        r100.put("limegreen", -13447886);
        r100.put("linen", -331546);
        r100.put("magenta", r102);
        r100.put("maroon", -8388608);
        r100.put("mediumaquamarine", -10039894);
        r100.put("mediumblue", -16777011);
        r100.put("mediumorchid", -4565549);
        r100.put("mediumpurple", -7114533);
        r100.put("mediumseagreen", -12799119);
        r100.put("mediumslateblue", -8689426);
        r100.put("mediumspringgreen", -16713062);
        r100.put("mediumturquoise", -12004916);
        r100.put("mediumvioletred", -3730043);
        r100.put("midnightblue", -15132304);
        r100.put("mintcream", -655366);
        r100.put("mistyrose", -6943);
        r100.put("moccasin", -6987);
        r100.put("navajowhite", -8531);
        r100.put("navy", -16777088);
        r100.put("oldlace", -133658);
        r100.put("olive", -8355840);
        r100.put("olivedrab", -9728477);
        r100.put("orange", -23296);
        r100.put("orangered", -47872);
        r100.put("orchid", -2461482);
        r100.put("palegoldenrod", -1120086);
        r100.put("palegreen", -6751336);
        r100.put("paleturquoise", -5247250);
        r100.put("palevioletred", -2396013);
        r100.put("papayawhip", -4139);
        r100.put("peachpuff", -9543);
        r100.put("peru", -3308225);
        r100.put("pink", -16181);
        r100.put("plum", -2252579);
        r100.put("powderblue", -5185306);
        r100.put("purple", -8388480);
        r100.put("rebeccapurple", -10079335);
        r100.put("red", -65536);
        r100.put("rosybrown", -4419697);
        r100.put("royalblue", -12490271);
        r100.put("saddlebrown", -7650029);
        r100.put("salmon", -360334);
        r100.put("sandybrown", -744352);
        r100.put("seagreen", -13726889);
        r100.put("seashell", -2578);
        r100.put("sienna", -6270419);
        r100.put("silver", -4144960);
        r100.put("skyblue", -7876885);
        r100.put("slateblue", -9807155);
        r100.put("slategray", -9404272);
        r100.put("slategrey", -9404272);
        r100.put("snow", -1286);
        r100.put("springgreen", -16711809);
        r100.put("steelblue", -12156236);
        r100.put("tan", -2968436);
        r100.put("teal", -16744320);
        r100.put("thistle", -2572328);
        r100.put("tomato", -40121);
        r100.put("turquoise", -12525360);
        r100.put("violet", -1146130);
        r100.put("wheat", -663885);
        r100.put("white", -1);
        r100.put("whitesmoke", -657931);
        r100.put("yellow", -256);
        r100.put("yellowgreen", -6632142);
        r100.put(ECPromotion.TRANSPARENT_BOTTON_ICON, 0);
    }
}
