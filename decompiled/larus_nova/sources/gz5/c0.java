package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lgz5/c0;", "", "", "rawTypeName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ownerTypeName", "b", "", "argumentTypeNames", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class c0 {

    @SerializedName("argument_type_names")
    private final List<c0> argumentTypeNames;

    @SerializedName("owner_type_name")
    private final String ownerTypeName;

    @SerializedName("raw_type_name")
    private final String rawTypeName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L12;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.rawTypeName, r101.rawTypeName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ownerTypeName, r101.ownerTypeName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.argumentTypeNames, r101.argumentTypeNames) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.rawTypeName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.ownerTypeName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<c0> r107 = this.argumentTypeNames;
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
        return "TypeInfo(rawTypeName=" + this.rawTypeName + ", ownerTypeName=" + this.ownerTypeName + ", argumentTypeNames=" + this.argumentTypeNames + ")";
    }

    public c0() {
        this.rawTypeName = "";
        this.ownerTypeName = null;
        this.argumentTypeNames = null;
    }

    public final List<c0> a() {
        return this.argumentTypeNames;
    }

    public final String b() {
        return this.ownerTypeName;
    }

    public final String c() {
        return this.rawTypeName;
    }
}
