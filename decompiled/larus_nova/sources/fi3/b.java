package fi3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lfi3/b;", "", "", "urlPath", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "usePost", "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "", "params", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "extra", "c", "useCache", "f", "cacheId", "b", "allowDuplicate", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477243a = 0;

    @SerializedName("allow_duplicate")
    private final Boolean allowDuplicate;

    @SerializedName("cache_id")
    private final String cacheId;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("params")
    private final Map<String, String> params;

    @SerializedName("url_path")
    private final String urlPath;

    @SerializedName("use_cache")
    private final Boolean useCache;

    @SerializedName("use_post")
    private final Boolean usePost;

    public static final class a {
    }

    static {
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        this(null, r100, null, null, r100, null, r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.urlPath, r101.urlPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.usePost, r101.usePost) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.useCache, r101.useCache) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cacheId, r101.cacheId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.allowDuplicate, r101.allowDuplicate) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.urlPath;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.usePost;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.params;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.extra;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.useCache;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.cacheId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.allowDuplicate;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "AsyncFetchDataParams(urlPath=" + this.urlPath + ", usePost=" + this.usePost + ", params=" + this.params + ", extra=" + this.extra + ", useCache=" + this.useCache + ", cacheId=" + this.cacheId + ", allowDuplicate=" + this.allowDuplicate + ")";
    }

    public final Boolean a() {
        return this.allowDuplicate;
    }

    public final String b() {
        return this.cacheId;
    }

    public final Map<String, String> c() {
        return this.extra;
    }

    public final Map<String, String> d() {
        return this.params;
    }

    public final String e() {
        return this.urlPath;
    }

    public final Boolean f() {
        return this.useCache;
    }

    public final Boolean g() {
        return this.usePost;
    }

    public b(String r100, Boolean r101, Map<String, String> r102, Map<String, String> r103, Boolean r104, String r105, Boolean r106) {
        this.urlPath = r100;
        this.usePost = r101;
        this.params = r102;
        this.extra = r103;
        this.useCache = r104;
        this.cacheId = r105;
        this.allowDuplicate = r106;
    }
}
