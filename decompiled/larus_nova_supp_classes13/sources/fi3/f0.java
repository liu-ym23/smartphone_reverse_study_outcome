package fi3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lfi3/f0;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "entranceInfo", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("entrance_info")
    private final String entranceInfo;

    @SerializedName("url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public f0() {
        this(null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f0) == false) goto L10;
        f0 r4 = (f0) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.entranceInfo, r4.entranceInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.entranceInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPTradeInClickParams(url=" + this.url + ", entranceInfo=" + this.entranceInfo + ")";
    }

    public final String a() {
        return this.entranceInfo;
    }

    public final String b() {
        return this.url;
    }

    public f0(String r1, String r2) {
        this.url = r1;
        this.entranceInfo = r2;
    }
}
