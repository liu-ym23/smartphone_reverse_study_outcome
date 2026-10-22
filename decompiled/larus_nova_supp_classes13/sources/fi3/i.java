package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lfi3/i;", "", "", "urlPath", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "usePost", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "", "params", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "disableUpdate", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {
    public static final /* synthetic */ int a = 0;

    @SerializedName("disable_update")
    private final Boolean disableUpdate;

    @SerializedName("params")
    private final Map<String, String> params;

    @SerializedName("url_path")
    private final String urlPath;

    @SerializedName("use_post")
    private final Boolean usePost;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.urlPath, r4.urlPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.usePost, r4.usePost) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disableUpdate, r4.disableUpdate) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
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
        Boolean r10 = this.disableUpdate;
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
        return "FetchDataParams(urlPath=" + this.urlPath + ", usePost=" + this.usePost + ", params=" + this.params + ", disableUpdate=" + this.disableUpdate + ")";
    }

    public i() {
        Boolean r0 = Boolean.FALSE;
        this(null, r0, null, r0);
    }

    public final Boolean a() {
        return this.disableUpdate;
    }

    public final Map<String, String> b() {
        return this.params;
    }

    public final String c() {
        return this.urlPath;
    }

    public final Boolean d() {
        return this.usePost;
    }

    public i(String r1, Boolean r2, Map<String, String> r3, Boolean r4) {
        this.urlPath = r1;
        this.usePost = r2;
        this.params = r3;
        this.disableUpdate = r4;
    }
}
