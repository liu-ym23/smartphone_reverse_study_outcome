package q99;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f532144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f532146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f532148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f532149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f532150g;

    public e() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f532144a, r101.f532144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532145b, r101.f532145b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532146c, r101.f532146c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f532147d, r101.f532147d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f532148e, r101.f532148e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f532149f, r101.f532149f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f532150g, r101.f532150g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f532144a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f532145b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f532146c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f532147d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f532148e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        d r116 = this.f532149f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.f532150g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowFeedbackDelivery(conversationId=" + this.f532144a + ", messageId=" + this.f532145b + ", feedbackScene=" + this.f532146c + ", feedbackSceneName=" + this.f532147d + ", logId=" + this.f532148e + ", model=" + this.f532149f + ", metricsInfo=" + this.f532150g + ')';
    }

    public static e a(e r100, String r101, String r110, d r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f532144a;
    L5:
        String r102 = r101;
        if ((r112 & 2) == 0) goto L8;
        r110 = r100.f532145b;
    L8:
        String r103 = r110;
        if ((r112 & 4) == 0) goto L11;
        Integer r104 = r100.f532146c;
    L13:
        if ((r112 & 8) == 0) goto L15;
        String r105 = r100.f532147d;
    L17:
        if ((r112 & 16) == 0) goto L19;
        String r106 = r100.f532148e;
    L21:
        if ((r112 & 32) == 0) goto L23;
        r111 = r100.f532149f;
    L23:
        d r107 = r111;
        if ((r112 & 64) == 0) goto L26;
        Map<String, String> r108 = r100.f532150g;
    L27:
        r100.getClass();
        return new e(r102, r103, r104, r105, r106, r107, r108);
    L26:
        r108 = null;
        goto L27
    L19:
        r106 = null;
        goto L21
    L15:
        r105 = null;
        goto L17
    L11:
        r104 = null;
        goto L13
    }

    public /* synthetic */ e(String r100, Integer r110, String r111, d r112, Map r113, int r114) {
        if ((r114 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 4) == 0) goto L8;
        Integer r101 = null;
    L10:
        if ((r114 & 8) == 0) goto L12;
        String r102 = null;
    L14:
        if ((r114 & 32) == 0) goto L16;
        d r103 = null;
    L18:
        if ((r114 & 64) == 0) goto L20;
        Map r104 = null;
    L21:
        this(null, r100, r101, r102, null, r103, r104);
        return;
    L20:
        r104 = r113;
        goto L21
    L16:
        r103 = r112;
        goto L18
    L12:
        r102 = r111;
        goto L14
    L8:
        r101 = r110;
        goto L10
    }

    public e(String r100, String r101, Integer r102, String r103, String r104, d r105, Map<String, String> r106) {
        this.f532144a = r100;
        this.f532145b = r101;
        this.f532146c = r102;
        this.f532147d = r103;
        this.f532148e = r104;
        this.f532149f = r105;
        this.f532150g = r106;
    }
}
