package mrb;

import com.larksuite.component.card.protocol.CardActionDataSource;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f515044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f515046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f515047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OPTrace f515048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Object> f515049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f515050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f515051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f515052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f515053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f515054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f515055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CardActionDataSource f515056o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f515042a, r101.f515042a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515043b, r101.f515043b) == true) goto L15;
        return false;
    L15:
        if (this.f515044c == r101.f515044c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515045d, r101.f515045d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515046e, r101.f515046e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f515047f, r101.f515047f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f515048g, r101.f515048g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515049h, r101.f515049h) == true) goto L33;
        return false;
    L33:
        if (this.f515050i == r101.f515050i) goto L36;
        return false;
    L36:
        if (this.f515051j == r101.f515051j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f515052k, r101.f515052k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f515053l, r101.f515053l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f515054m, r101.f515054m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f515055n, r101.f515055n) == true) goto L51;
        return false;
    L51:
        if (this.f515056o == r101.f515056o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f515042a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f515043b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f515044c) * 31) + this.f515045d.hashCode()) * 31;
        Map<String, String> r107 = this.f515046e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f515047f.hashCode()) * 31;
        OPTrace r110 = this.f515048g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        HashMap<String, Object> r113 = this.f515049h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f515050i == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f515051j == true) goto L30;
        r116 = 1237;
    L30:
        int r119 = (((((((r118 + r116) * 31) + this.f515052k.hashCode()) * 31) + this.f515053l.hashCode()) * 31) + this.f515054m.hashCode()) * 31;
        String r120 = this.f515055n;
        if (r120 == null) goto L35;
        r101 = r120.hashCode();
    L35:
        return ((r119 + r101) * 31) + this.f515056o.hashCode();
    L25:
        r117 = 1237;
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
        return "LynxCardActionRequestEntity(msgId=" + this.f515042a + ", actionId=" + this.f515043b + ", contentVersion=" + this.f515044c + ", traceId=" + this.f515045d + ", params=" + this.f515046e + ", callbackEventName=" + this.f515047f + ", mActionTrace=" + this.f515048g + ", sendLynxParams=" + this.f515049h + ", isMultiAction=" + this.f515050i + ", messageIsEphemeral=" + this.f515051j + ", scene=" + this.f515052k + ", renderBusinessType=" + this.f515053l + ", componentTag=" + this.f515054m + ", requestVersion=" + this.f515055n + ", actionDataSource=" + this.f515056o + ')';
    }

    public a(String r100, String r101, int r102, Map r103, OPTrace r104, HashMap r105, boolean r110, boolean r111, String r112, CardActionDataSource r113) {
        Intrinsics.checkNotNullParameter("", "traceId");
        Intrinsics.checkNotNullParameter("updateCardState", "callbackEventName");
        Intrinsics.checkNotNullParameter("", "scene");
        Intrinsics.checkNotNullParameter("", "renderBusinessType");
        Intrinsics.checkNotNullParameter("", "componentTag");
        Intrinsics.checkNotNullParameter(r113, "actionDataSource");
        this.f515042a = r100;
        this.f515043b = r101;
        this.f515044c = r102;
        this.f515045d = "";
        this.f515046e = r103;
        this.f515047f = "updateCardState";
        this.f515048g = r104;
        this.f515049h = r105;
        this.f515050i = r110;
        this.f515051j = r111;
        this.f515052k = "";
        this.f515053l = "";
        this.f515054m = "";
        this.f515055n = r112;
        this.f515056o = r113;
    }
}
