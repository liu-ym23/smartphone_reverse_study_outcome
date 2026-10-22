package fi3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lfi3/n0;", "", "", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "lynxData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "duration", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "extractPath", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477293a = 0;

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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L14;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extractPath, r101.extractPath) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.lynxData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.duration;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.extractPath;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public n0(String r100, Map<String, Object> r101, Long r102, String r103) {
        this.url = r100;
        this.lynxData = r101;
        this.duration = r102;
        this.extractPath = r103;
    }
}
