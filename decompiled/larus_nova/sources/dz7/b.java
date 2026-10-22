package dz7;

import com.larksuite.component.card.protocol.CardActionDataSource;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f470595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f470598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f470599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OPTrace f470600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f470601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f470602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f470603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f470604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CardActionDataSource f470605l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f470594a, r101.f470594a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470595b, r101.f470595b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470596c, r101.f470596c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470597d, r101.f470597d) == true) goto L21;
        return false;
    L21:
        if (this.f470598e == r101.f470598e) goto L24;
        return false;
    L24:
        if (this.f470599f == r101.f470599f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f470600g, r101.f470600g) == true) goto L30;
        return false;
    L30:
        if (this.f470601h == r101.f470601h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f470602i, r101.f470602i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f470603j, r101.f470603j) == true) goto L39;
        return false;
    L39:
        if (this.f470604k == r101.f470604k) goto L42;
        return false;
    L42:
        if (this.f470605l == r101.f470605l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f470594a.hashCode() * 31) + this.f470595b.hashCode()) * 31) + this.f470596c.hashCode()) * 31;
        String r101 = this.f470597d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f470598e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f470599f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((((r107 + r108) * 31) + this.f470600g.hashCode()) * 31) + this.f470601h) * 31;
        String r110 = this.f470602i;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f470603j;
        if (r113 == null) goto L22;
        r102 = r113.hashCode();
    L22:
        int r114 = (r112 + r102) * 31;
        if (this.f470604k == true) goto L27;
        r105 = 1237;
    L27:
        return ((r114 + r105) * 31) + this.f470605l.hashCode();
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardActionRequestParams(cardID=" + this.f470594a + ", params=" + this.f470595b + ", actionId=" + this.f470596c + ", contentVersion=" + this.f470597d + ", isEphemeral=" + this.f470598e + ", isMultiAction=" + this.f470599f + ", actionTrace=" + this.f470600g + ", sourceType=" + this.f470601h + ", sourceId=" + this.f470602i + ", requestVersion=" + this.f470603j + ", isStreamingMode=" + this.f470604k + ", actionDataSource=" + this.f470605l + ')';
    }

    public b(String r100, Map<String, String> r101, String r102, String r103, boolean r104, boolean r105, OPTrace r106, int r107, String r110, String r111, boolean r112, CardActionDataSource r113) {
        Intrinsics.checkNotNullParameter(r100, "cardID");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "actionId");
        Intrinsics.checkNotNullParameter(r106, "actionTrace");
        Intrinsics.checkNotNullParameter(r113, "actionDataSource");
        this.f470594a = r100;
        this.f470595b = r101;
        this.f470596c = r102;
        this.f470597d = r103;
        this.f470598e = r104;
        this.f470599f = r105;
        this.f470600g = r106;
        this.f470601h = r107;
        this.f470602i = r110;
        this.f470603j = r111;
        this.f470604k = r112;
        this.f470605l = r113;
    }
}
