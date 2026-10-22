package kma;

import android.graphics.Color;
import android.util.StateSet;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f504112b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f504113a;

    /* JADX INFO: renamed from: kma.a$a, reason: collision with other inner class name */
    public static final class C6574a {
        public C6574a() {
        }

        @JvmStatic
        public static a c(com.obric.oui.color.a[] r100) {
            Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
            com.obric.oui.color.b[] r101 = com.obric.oui.color.c.b(r100);
            return new a(new b(new int[][]{b.f504114d}, new com.obric.oui.color.b[][]{r101}, r101));
        }

        @JvmStatic
        public static com.obric.oui.color.a[] a(com.obric.oui.color.a[] r110, com.obric.oui.color.a[] r111, float r112) {
            Intrinsics.checkNotNullParameter(r110, "fromConfigs");
            Intrinsics.checkNotNullParameter(r111, "toConfigs");
            com.obric.oui.color.b[] r100 = com.obric.oui.color.c.b(r110);
            com.obric.oui.color.b[] r101 = com.obric.oui.color.c.b(r111);
            int[] r102 = b.f504114d;
            float r103 = 1.0f;
            float r104 = 0.0f;
            float r105 = Math.max(0.0f, Math.min(1.0f, r112));
            int r106 = 0;
            if (r105 > 0.0f) goto L9;
            com.obric.oui.color.b[] r107 = new com.obric.oui.color.b[r100.length];
        L6:
            if (r106 >= r100.length) goto L51;
            com.obric.oui.color.b r108 = r100[r106];
            r107[r106] = new com.obric.oui.color.b(r108.f399491a, r108.f399492b);
            r106 = r106 + 1;
        L51:
            return com.obric.oui.color.c.a(r107);
        L9:
            if (r105 < 1.0f) goto L15;
            com.obric.oui.color.b[] r109 = new com.obric.oui.color.b[r101.length];
        L12:
            if (r106 >= r101.length) goto L14;
            com.obric.oui.color.b r113 = r101[r106];
            r109[r106] = new com.obric.oui.color.b(r113.f399491a, r113.f399492b);
            r106 = r106 + 1;
            goto L12
        L14:
            r107 = r109;
            goto L51
        L15:
            int r114 = Math.max(r100.length, r101.length);
            if (r114 != 0) goto L19;
            r107 = new com.obric.oui.color.b[0];
            goto L51
        L19:
            if (r100.length == r114) goto L26;
            com.obric.oui.color.b[] r115 = (com.obric.oui.color.b[]) Arrays.copyOf(r100, r114);
            int r116 = r100.length;
        L22:
            if (r116 >= r114) goto L24;
            r115[r116] = new com.obric.oui.color.b(0, BlendMode.SRC_OVER);
            r116 = r116 + 1;
            goto L22
        L24:
            r100 = r115;
        L26:
            if (r101.length == r114) goto L32;
            com.obric.oui.color.b[] r117 = (com.obric.oui.color.b[]) Arrays.copyOf(r101, r114);
            int r118 = r101.length;
        L29:
            if (r118 >= r114) goto L31;
            r117[r118] = new com.obric.oui.color.b(0, BlendMode.SRC_OVER);
            r118 = r118 + 1;
            goto L29
        L31:
            r101 = r117;
        L32:
            com.obric.oui.color.b[] r119 = new com.obric.oui.color.b[r114];
        L33:
            if (r106 >= r114) goto L49;
            com.obric.oui.color.b r120 = r100[r106];
            com.obric.oui.color.b r121 = r101[r106];
            float r122 = Math.max(r104, Math.min(r103, r105));
            if (r122 > r104) goto L38;
            com.obric.oui.color.b r123 = new com.obric.oui.color.b(r120.f399491a, r120.f399492b);
        L48:
            r119[r106] = r123;
            r106 = r106 + 1;
            r103 = 1.0f;
            r104 = 0.0f;
            goto L33
        L38:
            if (r122 < r103) goto L40;
            r123 = new com.obric.oui.color.b(r121.f399491a, r121.f399492b);
            goto L48
        L40:
            int r124 = r120.f399491a;
            int r125 = r121.f399491a;
            float r126 = r103 - r122;
            int r127 = Color.argb((int) ((Color.alpha(r124) * r126) + (Color.alpha(r125) * r122)), (int) ((Color.red(r124) * r126) + (Color.red(r125) * r122)), (int) ((Color.green(r124) * r126) + (Color.green(r125) * r122)), (int) ((Color.blue(r124) * r126) + (Color.blue(r125) * r122)));
            int r128 = r120.f399492b;
            int r129 = r121.f399492b;
            if (r128 != r129) goto L44;
        L47:
            r123 = new com.obric.oui.color.b(r127, r128);
            goto L48
        L44:
            if (r122 < 0.5f) goto L47;
            r128 = r129;
            goto L47
        L49:
            r107 = r119;
            goto L51
        }

        public static a b(com.obric.oui.color.a[] r100, com.obric.oui.color.a r110, com.obric.oui.color.a r111, int r112) {
            int r101 = a.f504112b;
            if ((r112 & 1) == 0) goto L5;
            r100 = new com.obric.oui.color.a[]{com.obric.oui.color.a.f399487c};
        L5:
            com.obric.oui.color.a r102 = null;
            if ((r112 & 2) == 0) goto L8;
            com.obric.oui.color.a[] r103 = r100;
        L10:
            if ((r112 & 4) == 0) goto L13;
            r110 = com.obric.oui.color.a.f399487c;
        L13:
            if ((r112 & 8) == 0) goto L15;
            com.obric.oui.color.a r104 = com.obric.oui.color.a.f399487c;
        L17:
            if ((r112 & 16) == 0) goto L20;
            r111 = com.obric.oui.color.a.f399487c;
        L20:
            if ((r112 & 32) == 0) goto L22;
            r102 = r111;
        L22:
            Intrinsics.checkNotNullParameter(r100, "normal");
            Intrinsics.checkNotNullParameter(r103, "disabled");
            Intrinsics.checkNotNullParameter(r110, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r104, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r111, "activatedOverlay");
            Intrinsics.checkNotNullParameter(r102, "checkedOverlay");
            com.obric.oui.color.b[] r105 = com.obric.oui.color.c.b(r100);
            com.obric.oui.color.b[] r106 = com.obric.oui.color.c.b(r103);
            r110.getClass();
            com.obric.oui.color.b r107 = new com.obric.oui.color.b(r110.f399488a, r110.f399489b);
            r104.getClass();
            com.obric.oui.color.b r108 = new com.obric.oui.color.b(r104.f399488a, r104.f399489b);
            r111.getClass();
            com.obric.oui.color.b r109 = new com.obric.oui.color.b(r111.f399488a, r111.f399489b);
            r102.getClass();
            return new a(b.d(r105, r106, r107, r108, r109, new com.obric.oui.color.b(r102.f399488a, r102.f399489b)));
        L15:
            r104 = null;
            goto L17
        L8:
            r103 = null;
            goto L10
        }
    }

    static {
        new C6574a();
    }

    public a(b r100) {
        this.f504113a = r100;
    }

    public static com.obric.oui.color.a[] a(a r100, int[] r101) {
        com.obric.oui.color.a[] r102 = com.obric.oui.color.c.a(r100.f504113a.f504118c);
        Intrinsics.checkNotNullParameter(r101, "stateSet");
        Intrinsics.checkNotNullParameter(r102, "defaultConfig");
        b r103 = r100.f504113a;
        com.obric.oui.color.b[] r104 = com.obric.oui.color.c.b(r102);
        int r105 = 0;
    L3:
        int[][] r106 = r103.f504116a;
        if (r105 >= r106.length) goto L10;
        if (StateSet.stateSetMatches(r106[r105], r101) == true) goto L7;
        r105 = r105 + 1;
        goto L3
    L7:
        r104 = r103.f504117b[r105];
    L10:
        return com.obric.oui.color.c.a(r104);
    }
}
