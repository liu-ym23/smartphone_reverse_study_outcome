package mr9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f514989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f514990c;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f514988a, r101.f514988a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514989b, r101.f514989b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514990c, r101.f514990c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f514988a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f514989b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f514990c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageInstantUploadPolicy(family=" + this.f514988a + ", schemaVersion=" + this.f514989b + ", stableItems=" + this.f514990c + ')';
    }

    public /* synthetic */ c(String r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, null, r101);
    }

    public c(String r100, Integer r101, Map<String, String> r102) {
        this.f514988a = r100;
        this.f514989b = r101;
        this.f514990c = r102;
    }
}
