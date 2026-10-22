package kg6;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f503382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f503384d;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f503381a == r101.f503381a) goto L8;
        return false;
    L8:
        if (this.f503382b == r101.f503382b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f503383c, r101.f503383c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503384d, r101.f503384d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.f503381a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f503382b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.f503383c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        Map<String, Object> r110 = this.f503384d;
        if (r110 == null) goto L17;
        r107 = r110.hashCode();
    L17:
        return r109 + r107;
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "AudioUnMuteContext(needStartCapture=" + this.f503381a + ", needPublishStream=" + this.f503382b + ", reason=" + this.f503383c + ", monitorParams=" + this.f503384d + ")";
    }

    public d(boolean r100, boolean r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 8) == 0) goto L11;
        LinkedHashMap r104 = new LinkedHashMap();
    L12:
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r104, "monitorParams");
        this.f503381a = r100;
        this.f503382b = r101;
        this.f503383c = r102;
        this.f503384d = r104;
        return;
    L11:
        r104 = null;
        goto L12
    }
}
