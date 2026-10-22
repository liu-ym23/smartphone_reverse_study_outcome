package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lfi3/b;", "", "", "urlPath", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "usePost", "Ljava/lang/Boolean;", "g", "()Ljava/lang/Boolean;", "", "params", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "extra", "c", "useCache", "f", "cacheId", "b", "allowDuplicate", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {
    public static final /* synthetic */ int a = 0;

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
        Boolean r7 = Boolean.FALSE;
        this(null, r7, null, null, r7, null, r7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L20;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.urlPath, r4.urlPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.usePost, r4.usePost) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.useCache, r4.useCache) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cacheId, r4.cacheId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.allowDuplicate, r4.allowDuplicate) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.urlPath;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.usePost;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.params;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.extra;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.useCache;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.cacheId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.allowDuplicate;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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

    public b(String r1, Boolean r2, Map<String, String> r3, Map<String, String> r4, Boolean r5, String r6, Boolean r7) {
        this.urlPath = r1;
        this.usePost = r2;
        this.params = r3;
        this.extra = r4;
        this.useCache = r5;
        this.cacheId = r6;
        this.allowDuplicate = r7;
    }
}
