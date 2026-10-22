package l3;

import com.google.gson.JsonObject;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f507197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f507198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f507199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f507200e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f507196a, r101.f507196a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507197b, r101.f507197b) == true) goto L15;
        return false;
    L15:
        if (this.f507198c == r101.f507198c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f507196a.hashCode() * 31;
        JsonObject r101 = this.f507197b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f507198c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIBridgeEvent(eventName=" + this.f507196a + ", params=" + this.f507197b + ", timestamp=" + this.f507198c + ')';
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        long r102 = this.f507198c;
        if (r102 != r101.f507198c) goto L7;
        return -1;
    L7:
        return ComparisonsKt.compareValues(Long.valueOf(r102), Long.valueOf(r101.f507198c));
    }

    public /* synthetic */ a(String r100, JsonObject r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        long r103 = System.currentTimeMillis();
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    public a(String r100, JsonObject r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f507196a = r100;
        this.f507197b = r101;
        this.f507198c = r102;
    }
}
