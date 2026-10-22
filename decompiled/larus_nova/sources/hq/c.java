package hq;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lhq/c;", "", "", "url", "Ljava/lang/String;", "f", "()Ljava/lang/String;", ce.f26391f, "(Ljava/lang/String;)V", "btmId", "c", "Lhq/a;", "btmFields", "Lhq/a;", "b", "()Lhq/a;", "extractPath", "d", "extractTo", "e", "", "addTimestampOnClick", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f486492a = 0;

    @SerializedName("add_timestamp_on_click")
    private final boolean addTimestampOnClick;

    @SerializedName("btm_fields")
    private final hq.a btmFields;

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName("extract_path")
    private final String extractPath;

    @SerializedName("extract_to")
    private final String extractTo;

    @SerializedName("schema")
    private String url;

    public static final class a {
        public static c a(Map r100) {
            Object r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            Object r102 = r100.get("schema");
            if ((r102 instanceof String) == true) goto L8;
            r102 = null;
        L8:
            String r103 = (String) r102;
            Object r104 = r100.get("btm_id");
            if ((r104 instanceof String) == true) goto L11;
            r104 = null;
        L11:
            String r105 = (String) r104;
            Object r106 = r100.get("btm_fields");
            if ((r106 instanceof Map) == true) goto L14;
            r106 = null;
        L14:
            Map r107 = (Map) r106;
            if (r107 == null) goto L23;
            Intrinsics.checkNotNullParameter(r107, "$this$buildBTMFields");
            Object r108 = r107.get("btm_code");
            if ((r108 instanceof String) == true) goto L19;
            r108 = null;
        L19:
            String r109 = (String) r108;
            Object r110 = r107.get("bcm_context");
            if ((r110 instanceof Map) == true) goto L22;
            r110 = null;
        L22:
            hq.a r111 = new hq.a(r109, (Map) r110);
        L24:
            Object r112 = r100.get("extract_path");
            if ((r112 instanceof String) == true) goto L27;
            r112 = null;
        L27:
            String r113 = (String) r112;
            Object r114 = r100.get("extract_to");
            if ((r114 instanceof String) == true) goto L30;
            r114 = null;
        L30:
            String r115 = (String) r114;
            Object r116 = r100.get("add_timestamp_on_click");
            if ((r116 instanceof Boolean) == false) goto L35;
            r101 = r116;
        L35:
            return new c(r103, r105, r111, r113, r115, Intrinsics.areEqual((Boolean) r101, Boolean.TRUE));
        L23:
            r111 = null;
            goto L24
        }
    }

    static {
    }

    public c() {
        this(null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.btmId, r101.btmId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extractPath, r101.extractPath) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extractTo, r101.extractTo) == true) goto L16;
        return false;
    L16:
        if (this.addTimestampOnClick == r101.addTimestampOnClick) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.btmId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        hq.a r107 = this.btmFields;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.extractPath;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.extractTo;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.addTimestampOnClick;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
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
        return "SchemaParams(url=" + this.url + ", btmId=" + this.btmId + ", btmFields=" + this.btmFields + ", extractPath=" + this.extractPath + ", extractTo=" + this.extractTo + ", addTimestampOnClick=" + this.addTimestampOnClick + ")";
    }

    public final boolean a() {
        return this.addTimestampOnClick;
    }

    public final hq.a b() {
        return this.btmFields;
    }

    public final String c() {
        return this.btmId;
    }

    public final String d() {
        return this.extractPath;
    }

    public final String e() {
        return this.extractTo;
    }

    public final String f() {
        return this.url;
    }

    public final void g(String r100) {
        this.url = r100;
    }

    public /* synthetic */ c(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null, null, false);
    }

    public c(String r100, String r101, hq.a r102, String r103, String r104, boolean r105) {
        this.url = r100;
        this.btmId = r101;
        this.btmFields = r102;
        this.extractPath = r103;
        this.extractTo = r104;
        this.addTimestampOnClick = r105;
    }
}
