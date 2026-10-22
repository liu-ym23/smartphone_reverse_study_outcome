package hd6;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wy0.h;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f484601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, h<Object, Object>> f484602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, g<Object, Object>> f484603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f484604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f484605f;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f484600a, r101.f484600a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484601b, r101.f484601b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f484602c, r101.f484602c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484603d, r101.f484603d) == true) goto L14;
        return false;
    L14:
        if (this.f484604e == r101.f484604e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f484605f, r101.f484605f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        String r100 = this.f484600a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f484601b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, h<Object, Object>> r107 = this.f484602c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, g<Object, Object>> r110 = this.f484603d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f484604e;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        a r116 = this.f484605f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxViewParam(schema=" + this.f484600a + ", schemaParams=" + this.f484601b + ", jsbMethods=" + this.f484602c + ", jsbStatelessMethods=" + this.f484603d + ", enableCanvas=" + this.f484604e + ", callback=" + this.f484605f + ")";
    }

    public b(String r100, Map r101, com.bytedance.kmp.livesdk.gift.platform.effect.g.b r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f484600a = r100;
        this.f484601b = r101;
        this.f484602c = null;
        this.f484603d = null;
        this.f484604e = true;
        this.f484605f = r102;
    }
}
