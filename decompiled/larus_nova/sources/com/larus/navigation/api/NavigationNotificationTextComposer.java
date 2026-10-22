package com.larus.navigation.api;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class NavigationNotificationTextComposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359619a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/navigation/api/NavigationNotificationTextComposer$SpecialRoad;", "", "<init>", "(Ljava/lang/String;I)V", "INTERSECTION", "PEDESTRIAN_BRIDGE", "UNDERPASS", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SpecialRoad extends Enum<SpecialRoad> {
        public static final SpecialRoad INTERSECTION = null;
        public static final SpecialRoad PEDESTRIAN_BRIDGE = null;
        public static final SpecialRoad UNDERPASS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SpecialRoad[] f359620a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359621b = null;

        public static EnumEntries<SpecialRoad> getEntries() {
            return f359621b;
        }

        static {
            SpecialRoad r100 = new SpecialRoad("INTERSECTION", 0);
            INTERSECTION = r100;
            SpecialRoad r101 = new SpecialRoad("PEDESTRIAN_BRIDGE", 1);
            PEDESTRIAN_BRIDGE = r101;
            SpecialRoad r102 = new SpecialRoad("UNDERPASS", 2);
            UNDERPASS = r102;
            SpecialRoad[] r103 = {r100, r101, r102};
            f359620a = r103;
            f359621b = EnumEntriesKt.enumEntries(r103);
        }

        public static SpecialRoad[] values() {
            return (SpecialRoad[]) f359620a.clone();
        }

        public static SpecialRoad valueOf(String r100) {
            return (SpecialRoad) r27.a.a(SpecialRoad.class, r100);
        }

        public SpecialRoad(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f359622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f359623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f359624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f359625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f359626e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f359622a, r101.f359622a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359623b, r101.f359623b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f359624c, r101.f359624c) == true) goto L18;
            return false;
        L18:
            if (this.f359625d == r101.f359625d) goto L21;
            return false;
        L21:
            if (this.f359626e == r101.f359626e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f359622a.hashCode() * 31) + this.f359623b.hashCode()) * 31) + this.f359624c.hashCode()) * 31) + this.f359625d) * 31;
            if (this.f359626e == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "NaviText(title=" + this.f359622a + ", content=" + this.f359623b + ", speech=" + this.f359624c + ", iconTurnKind=" + this.f359625d + ", isArrival=" + this.f359626e + ')';
        }

        public /* synthetic */ a(String r100, String r101, String r102) {
            this(r100, r101, r102, -1, false);
        }

        public static a a(a r100, int r101, boolean r110, int r111) {
            String r102 = null;
            if ((r111 & 1) == 0) goto L5;
            String r103 = r100.f359622a;
        L7:
            if ((r111 & 2) == 0) goto L9;
            String r104 = r100.f359623b;
        L11:
            if ((r111 & 4) == 0) goto L13;
            r102 = r100.f359624c;
        L13:
            String r105 = r102;
            if ((r111 & 8) == 0) goto L16;
            r101 = r100.f359625d;
        L16:
            int r106 = r101;
            if ((r111 & 16) == 0) goto L19;
            r110 = r100.f359626e;
        L19:
            Intrinsics.checkNotNullParameter(r103, "title");
            Intrinsics.checkNotNullParameter(r104, "content");
            Intrinsics.checkNotNullParameter(r105, "speech");
            return new a(r103, r104, r105, r106, r110);
        L9:
            r104 = null;
            goto L11
        L5:
            r103 = null;
            goto L7
        }

        public a(String r100, String r101, String r102, int r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r102, "speech");
            this.f359622a = r100;
            this.f359623b = r101;
            this.f359624c = r102;
            this.f359625d = r103;
            this.f359626e = r104;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359627a = null;

        static {
            int[] r100 = new int[SpecialRoad.values().length];
            r100[SpecialRoad.INTERSECTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SpecialRoad.PEDESTRIAN_BRIDGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SpecialRoad.UNDERPASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f359627a = r100;
        }
    }

    static {
    }

    public static String b(int r100) {
        if (r100 >= 1000) goto L7;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(31859);
        return r101.toString();
    L7:
        return String.format(Locale.ROOT, "%.1f公里", Arrays.copyOf(new Object[]{Double.valueOf(((double) r100) / 1000.0d)}, 1));
    }

    public static a a(int r110, int r111, String r210, int r211, int r212) {
        SpecialRoad r100 = null;
        if (r210 != null) goto L5;
    L7:
        String r101 = null;
    L8:
        String r102 = "";
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        if (r101.length() != 0) goto L14;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
    L27:
        SpecialRoad r104 = r100;
        String r105 = b(r110);
        if (r212 < 0) goto L31;
        if (r212 >= 11) goto L31;
        boolean r112 = true;
    L32:
        String r113 = "到达目的地";
        if (r112 == false) goto L49;
        if (r212 > 5) goto L36;
        a r106 = new a(r113, r102, r113);
    L44:
        if (r211 != 2) goto L46;
        int r114 = 37;
    L47:
        a r107 = a.a(r106, r114, true, 7);
        c("arrival", r110, r111, r210, r211, r212, r104, r107);
        return r107;
    L46:
        r114 = 1;
        goto L47
    L36:
        String r108 = b(r212);
        if (r101.length() <= 0) goto L39;
        boolean r115 = true;
    L40:
        if (r115 == false) goto L42;
        String r109 = "沿" + r101 + "直行" + r108;
    L43:
        r106 = new a(r109, r113, r109 + "后到达目的地");
        goto L44
    L42:
        r109 = "直行" + r108;
        goto L43
    L39:
        r115 = false;
        goto L40
    L49:
        if (r211 != 0) goto L51;
        int r116 = 50;
    L52:
        if (r111 <= 0) goto L59;
        if (r111 == 1) goto L59;
        if (r110 > r116) goto L59;
        boolean r117 = false;
    L60:
        String r118 = "沿当前道路";
        if (r117 == false) goto L75;
        if (r101.length() <= 0) goto L65;
        boolean r119 = true;
    L67:
        if (r119 == false) goto L69;
        r118 = "沿".concat(r101);
    L69:
        String r120 = r118;
        String r121 = "直行" + r105;
        if (r119 == false) goto L72;
        String r122 = "沿" + r101 + "直行" + r105;
    L73:
        a r123 = new a(r120, r121, r122);
        int r124 = 1;
    L233:
        if (r117 == true) goto L236;
        r124 = r111;
    L236:
        a r125 = a.a(r123, r124, false, 23);
        if (r117 == false) goto L239;
        String r126 = "straight";
    L240:
        c(r126, r110, r111, r210, r211, r212, r104, r125);
        return r125;
    L239:
        r126 = "turn";
        goto L240
    L72:
        r122 = "直行" + r105;
        goto L73
    L65:
        r119 = false;
        goto L67
    L75:
        if (r211 != 2) goto L81;
        if (r111 == 5) goto L195;
        if (r111 == 6) goto L92;
        if (r111 == 7) goto L94;
        if (r111 != 8) goto L81;
    L96:
        r113 = "左前方转弯";
    L197:
        String r127 = r105 + 21518 + r113;
        if (r104 != null) goto L200;
        int r128 = -1;
    L201:
        if (r128 == (-1)) goto L212;
        r124 = 1;
        if (r128 == 1) goto L211;
        if (r128 != 2) goto L206;
        r102 = "上过街天桥";
    L219:
        if (r102.length() != 0) goto L221;
        boolean r129 = true;
    L222:
        if (r129 == false) goto L224;
        String r130 = "沿当前道路";
    L226:
        if (r102.length() != 0) goto L228;
        boolean r131 = true;
    L229:
        if (r131 == false) goto L231;
        String r132 = r127;
    L232:
        r123 = new a(r130, r127, r132);
        goto L233
    L231:
        r132 = r127 + r102;
        goto L232
    L228:
        r131 = false;
        goto L229
    L224:
        r130 = r102;
        goto L226
    L221:
        r129 = false;
        goto L222
    L206:
        if (r128 != 3) goto L209;
        r102 = "进入地下通道";
        goto L219
    L209:
        throw new NoWhenBranchMatchedException();
    L211:
        r102 = "离开路口";
        goto L219
    L212:
        r124 = 1;
        if (r101.length() <= 0) goto L215;
        boolean r133 = true;
    L216:
        if (r133 == false) goto L219;
        r102 = "进入".concat(r101);
        goto L219
    L215:
        r133 = false;
        goto L216
    L200:
        r128 = b.f359627a[r104.ordinal()];
    L94:
        r113 = "左转";
    L92:
        r113 = "左后方转弯";
    L195:
        r113 = "掉头";
    L81:
        if (r111 != 1) goto L83;
        r113 = "直行";
        goto L197
    L83:
        if (r111 != 2) goto L86;
        r113 = "右前方转弯";
        goto L197
    L86:
        if (r111 != 3) goto L89;
        r113 = "右转";
        goto L197
    L89:
        if (r111 != 4) goto L91;
        r113 = "右后方转弯";
        goto L197
    L91:
        if (r111 == 5) goto L92;
        if (r111 == 6) goto L94;
        if (r111 == 7) goto L96;
        if (r111 != 8) goto L101;
        r113 = "右前方直行";
        goto L197
    L101:
        if (r111 != 9) goto L104;
        r113 = "左前方直行";
        goto L197
    L104:
        if (r111 != 10) goto L106;
    L196:
        r113 = "通过路口直行";
        goto L197
    L106:
        if (r111 == 11) goto L196;
        if (r111 == 12) goto L195;
        if (r111 == 30) goto L195;
        if (r111 != 13) goto L116;
    L194:
        r113 = "右侧掉头";
        goto L197
    L116:
        if (r111 == 31) goto L194;
        if (r111 != 14) goto L121;
    L193:
        r113 = "通过路口右转";
        goto L197
    L121:
        if (r111 == 22) goto L193;
        if (r111 == 24) goto L193;
        if (r111 != 15) goto L128;
    L192:
        r113 = "通过路口右前方转弯";
        goto L197
    L128:
        if (r111 == 21) goto L192;
        if (r111 == 23) goto L192;
        if (r111 != 16) goto L135;
    L191:
        r113 = "通过路口左前方转弯";
        goto L197
    L135:
        if (r111 == 18) goto L191;
        if (r111 != 17) goto L140;
    L190:
        r113 = "通过路口左转";
        goto L197
    L140:
        if (r111 == 20) goto L190;
        if (r111 == 26) goto L190;
        if (r111 != 19) goto L148;
        r113 = "通过路口左后方转弯";
        goto L197
    L148:
        if (r111 != 25) goto L151;
        r113 = "通过路口右后方转弯";
        goto L197
    L151:
        if (r111 != 27) goto L154;
        r113 = "通过路口";
        goto L197
    L154:
        if (r111 != 28) goto L157;
        r113 = "进入环岛";
        goto L197
    L157:
        if (r111 != 29) goto L159;
    L189:
        r113 = "沿环岛继续行驶";
        goto L197
    L159:
        if (r111 == 32) goto L189;
        if (r111 == 33) goto L189;
        if (r111 == 34) goto L189;
        if (r111 == 35) goto L189;
        if (r111 == 36) goto L189;
        if (r111 == 37) goto L197;
        if (r111 != 38) goto L176;
        r113 = "经过途径点";
        goto L197
    L176:
        if (r111 != 39) goto L179;
        r113 = "驶入轮渡";
        goto L197
    L179:
        if (r111 != 40) goto L181;
        r113 = "通过收费站";
        goto L197
    L181:
        if (33 <= r111) goto L183;
    L185:
        boolean r134 = false;
    L186:
        if (r134 == false) goto L188;
        r113 = "前方多分叉路口";
        goto L197
    L188:
        r113 = "继续前进";
        goto L197
    L183:
        if (r111 >= 48) goto L185;
        r134 = true;
    L59:
        r117 = true;
        goto L60
    L51:
        r116 = 100;
    L31:
        r112 = false;
        goto L32
    L19:
        if (StringsKt.contains$default(r101, "过街天桥", false, 2, null) == false) goto L22;
        r100 = SpecialRoad.PEDESTRIAN_BRIDGE;
        goto L27
    L22:
        if (StringsKt.contains$default(r101, "地下通道", false, 2, null) == false) goto L25;
        r100 = SpecialRoad.UNDERPASS;
        goto L27
    L25:
        if (StringsKt.contains$default(r101, "路口", false, 2, null) == false) goto L27;
        r100 = SpecialRoad.INTERSECTION;
        goto L27
    L14:
        r103 = false;
        goto L16
    L5:
        if ((!StringsKt.isBlank(r210)) == false) goto L7;
        r101 = r210;
        goto L8
    }

    public static void c(String r100, int r101, int r102, String r103, int r104, int r105, SpecialRoad r106, a r107) {
        int r108 = c.f359656a;
        StringBuilder r109 = new StringBuilder("scene=");
        r109.append(r100);
        r109.append(" d2c=");
        r109.append(r101);
        r109.append(" turnKind=");
        r109.append(r102);
        r109.append(" road='");
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r109.append(r103);
        r109.append("' mode=");
        r109.append(r104);
        r109.append(" remain=");
        r109.append(r105);
        r109.append(" special=");
        if (r106 == null) goto L9;
        String r110 = r106.name();
        if (r110 == null) goto L9;
    L10:
        r109.append(r110);
        r109.append(" → title='");
        r109.append(r107.f359622a);
        r109.append("' content='");
        r109.append(r107.f359623b);
        r109.append("' speech='");
        r109.append(StringsKt.take(r107.f359624c, 60));
        r109.append('\'');
        c.d("nav_text_composer", r109.toString());
        return;
    L9:
        r110 = "-";
        goto L10
    }
}
