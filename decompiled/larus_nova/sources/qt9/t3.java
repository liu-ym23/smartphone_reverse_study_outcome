package qt9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/provider/ProactiveFetchPatchConfig;", "", "updateVersionCode", "", "patchIdList", "", "", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "getUpdateVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPatchIdList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/larus/settings/provider/ProactiveFetchPatchConfig;", "equals", "", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t3 {

    @SerializedName("patch_id_list")
    private final List<String> patchIdList;

    @SerializedName("update_version_code")
    private final Long updateVersionCode;

    public t3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t3) == true) goto L8;
        return false;
    L8:
        t3 r101 = (t3) r100;
        if (Intrinsics.areEqual(this.updateVersionCode, r101.updateVersionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.patchIdList, r101.patchIdList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.updateVersionCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.patchIdList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveFetchPatchConfig(updateVersionCode=" + this.updateVersionCode + ", patchIdList=" + this.patchIdList + ')';
    }

    public final List<String> a() {
        return this.patchIdList;
    }

    public final Long b() {
        return this.updateVersionCode;
    }

    public t3(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        this.updateVersionCode = 0L;
        this.patchIdList = r101;
    }
}
