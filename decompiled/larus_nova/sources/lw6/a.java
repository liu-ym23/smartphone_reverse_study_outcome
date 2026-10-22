package lw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Llw6/a;", "", "", "", "v1SchemaList", "Ljava/util/List;", "b", "()Ljava/util/List;", "v2SchemaList", "c", "", "usingNewUpdateApi", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("usingNewUpdateApi")
    private final Boolean usingNewUpdateApi;

    @SerializedName("v1SchemaList")
    private final List<String> v1SchemaList;

    @SerializedName("v2SchemaList")
    private final List<String> v2SchemaList;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.v1SchemaList, r101.v1SchemaList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.v2SchemaList, r101.v2SchemaList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.usingNewUpdateApi, r101.usingNewUpdateApi) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.v1SchemaList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.v2SchemaList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.usingNewUpdateApi;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreloadV2Config(v1SchemaList=" + this.v1SchemaList + ", v2SchemaList=" + this.v2SchemaList + ", usingNewUpdateApi=" + this.usingNewUpdateApi + ')';
    }

    public final Boolean a() {
        return this.usingNewUpdateApi;
    }

    public final List<String> b() {
        return this.v1SchemaList;
    }

    public final List<String> c() {
        return this.v2SchemaList;
    }

    public a(Object r100) {
        this.v1SchemaList = null;
        this.v2SchemaList = null;
        this.usingNewUpdateApi = null;
    }
}
