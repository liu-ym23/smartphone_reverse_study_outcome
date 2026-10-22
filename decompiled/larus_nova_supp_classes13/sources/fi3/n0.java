package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lfi3/n0;", "", "", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "lynxData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "duration", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "extractPath", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("extract_path")
    private final String extractPath;

    @SerializedName("lynx_data")
    private final Map<String, Object> lynxData;

    @SerializedName("url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public n0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L14;
        n0 r4 = (n0) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxData, r4.lynxData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.duration, r4.duration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extractPath, r4.extractPath) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.lynxData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.duration;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.extractPath;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpLynxToastParams(url=" + this.url + ", lynxData=" + this.lynxData + ", duration=" + this.duration + ", extractPath=" + this.extractPath + ")";
    }

    public final Long a() {
        return this.duration;
    }

    public final String b() {
        return this.extractPath;
    }

    public final Map<String, Object> c() {
        return this.lynxData;
    }

    public final String d() {
        return this.url;
    }

    public n0(String r1, Map<String, Object> r2, Long r3, String r4) {
        this.url = r1;
        this.lynxData = r2;
        this.duration = r3;
        this.extractPath = r4;
    }
}
