package fl7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R,\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lfl7/a;", "", "", "schema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "extra", "d", "setExtra", "", "expireAt", "J", "c", "()J", "setExpireAt", "(J)V", "", "restrictionMode", "I", "e", "()I", "setRestrictionMode", "(I)V", "", "allowPages", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setAllowPages", "(Ljava/util/List;)V", "blockPages", "b", "setBlockPages", "", "enableFeedShow", "Z", "getEnableFeedShow", "()Z", "setEnableFeedShow", "(Z)V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("allow_pages")
    private List<String> allowPages;

    @SerializedName("block_pages")
    private List<String> blockPages;

    @SerializedName("is_android_feed_enabled")
    private boolean enableFeedShow;

    @SerializedName("expire_at")
    private long expireAt;

    @SerializedName("extra")
    private String extra;

    @SerializedName("restriction_mode")
    private int restrictionMode;

    @SerializedName("schema")
    private String schema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L31:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == false) goto L30;
        if (Intrinsics.areEqual(this.extra, r101.extra) == false) goto L30;
        if (this.expireAt != r101.expireAt) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L30;
        if (this.restrictionMode != r101.restrictionMode) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L30;
        if (Intrinsics.areEqual(this.allowPages, r101.allowPages) == false) goto L30;
        if (Intrinsics.areEqual(this.blockPages, r101.blockPages) == false) goto L30;
        if (this.enableFeedShow != r101.enableFeedShow) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L30;
    L27:
        r104 = false;
        goto L28
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.extra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.expireAt;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.restrictionMode) * 31;
        List<String> r109 = this.allowPages;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.blockPages;
        if (r112 == null) goto L17;
        r101 = r112.hashCode();
    L17:
        int r113 = (r111 + r101) * 31;
        boolean r114 = this.enableFeedShow;
        ?? r115 = r114;
        if (r114 == false) goto L21;
        r115 = 1;
    L21:
        return r113 + r115;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RedirecttoModel(schema=" + this.schema + ", extra=" + this.extra + ", expireAt=" + this.expireAt + ", restrictionMode=" + this.restrictionMode + ", allowPages=" + this.allowPages + ", blockPages=" + this.blockPages + ", enableFeedShow=" + this.enableFeedShow + ")";
    }

    public a() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        this.schema = "";
        this.extra = "";
        this.expireAt = -1;
        this.restrictionMode = 0;
        this.allowPages = r100;
        this.blockPages = r101;
        this.enableFeedShow = false;
    }

    public final List<String> a() {
        return this.allowPages;
    }

    public final List<String> b() {
        return this.blockPages;
    }

    public final long c() {
        return this.expireAt;
    }

    public final String d() {
        return this.extra;
    }

    public final int e() {
        return this.restrictionMode;
    }

    public final String f() {
        return this.schema;
    }
}
