package lhc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Llhc/b;", "", "", "pageClassName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "isPageUrlInExtra", "Z", "c", "()Z", "enableUploadExtra", "getEnableUploadExtra", "pageUrlValueInExtraKeyName", "b", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("enable_upload_extra")
    private final boolean enableUploadExtra;

    @SerializedName("is_page_url_in_extra")
    private final boolean isPageUrlInExtra;

    @SerializedName("page_class_name")
    private final String pageClassName;

    @SerializedName("page_url_value_in_extra_key_name")
    private final String pageUrlValueInExtraKeyName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.pageClassName, r101.pageClassName) == true) goto L8;
        return false;
    L8:
        if (this.isPageUrlInExtra == r101.isPageUrlInExtra) goto L10;
        return false;
    L10:
        if (this.enableUploadExtra == r101.enableUploadExtra) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageUrlValueInExtraKeyName, r101.pageUrlValueInExtraKeyName) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.pageClassName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.isPageUrlInExtra;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.enableUploadExtra;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (r107 + r105) * 31;
        String r110 = this.pageUrlValueInExtraKeyName;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PageReportConfig(pageClassName=" + this.pageClassName + ", isPageUrlInExtra=" + this.isPageUrlInExtra + ", enableUploadExtra=" + this.enableUploadExtra + ", pageUrlValueInExtraKeyName=" + this.pageUrlValueInExtraKeyName + ")";
    }

    public final String a() {
        return this.pageClassName;
    }

    public final String b() {
        return this.pageUrlValueInExtraKeyName;
    }

    public final boolean c() {
        return this.isPageUrlInExtra;
    }
}
