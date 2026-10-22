package p43;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f527651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f527652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f527653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f527654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f527655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f527656f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527651a, r101.f527651a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527652b, r101.f527652b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527653c, r101.f527653c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527654d, r101.f527654d) == true) goto L14;
        return false;
    L14:
        if (this.f527655e == r101.f527655e) goto L16;
        return false;
    L16:
        if (this.f527656f == r101.f527656f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        b r100 = this.f527651a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f527652b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f527653c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f527654d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f527655e;
        ?? r113 = 1;
        ?? r114 = r112;
        if (r112 == false) goto L20;
        r114 = 1;
    L20:
        int r115 = (r111 + r114) * 31;
        boolean r116 = this.f527656f;
        if (r116 == true) goto L25;
        r113 = r116;
    L25:
        return r115 + r113;
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
        return "CheckInfo(checkPayStatusParams=" + this.f527651a + ", payCode=" + this.f527652b + ", orderPayType=" + this.f527653c + ", payParams=" + this.f527654d + ", payWithWechatOrAlipay=" + this.f527655e + ", isAppPay=" + this.f527656f + ")";
    }

    public a(b r100, Integer r101, Integer r102, Map<String, ? extends Object> r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "checkPayStatusParams");
        this.f527651a = r100;
        this.f527652b = r101;
        this.f527653c = r102;
        this.f527654d = r103;
        this.f527655e = r104;
        this.f527656f = r105;
    }
}
