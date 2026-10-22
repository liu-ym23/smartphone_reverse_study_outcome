package nt2;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lnt2/b;", "", "", "testDataUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mockType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "path", "b", "", "useDialog", "Z", "d", "()Z", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(BasicTestActionHandler.MOCK_TYPE)
    private final String mockType;

    @SerializedName("path")
    private final String path;

    @SerializedName("data_url")
    private final String testDataUrl;

    @SerializedName(BasicTestActionHandler.USE_DIALOG)
    private final boolean useDialog;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.testDataUrl, r101.testDataUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mockType, r101.mockType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (this.useDialog == r101.useDialog) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.testDataUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mockType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.path;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.useDialog;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiMockPath(testDataUrl=" + this.testDataUrl + ", mockType=" + this.mockType + ", path=" + this.path + ", useDialog=" + this.useDialog + ")";
    }

    public final String a() {
        return this.mockType;
    }

    public final String b() {
        return this.path;
    }

    public final String c() {
        return this.testDataUrl;
    }

    public final boolean d() {
        return this.useDialog;
    }
}
