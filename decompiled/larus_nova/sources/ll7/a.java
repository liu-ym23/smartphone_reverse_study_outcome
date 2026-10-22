package ll7;

import com.bytedance.ug.sdk.luckydog.api.window.CleanCacheSPInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0007j\b\u0012\u0004\u0012\u00020\u000f`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lll7/a;", "", "", "clearId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearModels", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "clearPaths", "c", "Lcom/bytedance/ug/sdk/luckydog/api/window/CleanCacheSPInfo;", "clearSPInfo", "d", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("clear_id")
    private final String clearId;

    @SerializedName("android_clear_models")
    private final ArrayList<String> clearModels;

    @SerializedName("android_cache_sp_name")
    private final ArrayList<String> clearPaths;

    @SerializedName("android_cache_sp_key")
    private final ArrayList<CleanCacheSPInfo> clearSPInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.clearId, r101.clearId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clearModels, r101.clearModels) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clearPaths, r101.clearPaths) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clearSPInfo, r101.clearSPInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.clearId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ArrayList<String> r104 = this.clearModels;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.clearPaths;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ArrayList<CleanCacheSPInfo> r110 = this.clearSPInfo;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "CleanCacheModel(clearId=" + this.clearId + ", clearModels=" + this.clearModels + ", clearPaths=" + this.clearPaths + ", clearSPInfo=" + this.clearSPInfo + ")";
    }

    public final String a() {
        return this.clearId;
    }

    public final ArrayList<String> b() {
        return this.clearModels;
    }

    public final ArrayList<String> c() {
        return this.clearPaths;
    }

    public final ArrayList<CleanCacheSPInfo> d() {
        return this.clearSPInfo;
    }
}
