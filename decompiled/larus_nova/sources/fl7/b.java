package fl7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ll7.f;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lfl7/b;", "", "", "resourceType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setResourceType", "(Ljava/lang/String;)V", "Lll7/f;", "popupModel", "Lll7/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lll7/f;", "setPopupModel", "(Lll7/f;)V", "Lfl7/a;", "redirecttoModel", "Lfl7/a;", "b", "()Lfl7/a;", "setRedirecttoModel", "(Lfl7/a;)V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("popup")
    private f popupModel;

    @SerializedName("redirectto")
    private a redirecttoModel;

    @SerializedName("resource_type")
    private String resourceType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.resourceType, r101.resourceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupModel, r101.popupModel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.redirecttoModel, r101.redirecttoModel) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.resourceType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f r104 = this.popupModel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.redirecttoModel;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResourceLaunchModel(resourceType=" + this.resourceType + ", popupModel=" + this.popupModel + ", redirecttoModel=" + this.redirecttoModel + ")";
    }

    public final f a() {
        return this.popupModel;
    }

    public final a b() {
        return this.redirecttoModel;
    }

    public final String c() {
        return this.resourceType;
    }
}
