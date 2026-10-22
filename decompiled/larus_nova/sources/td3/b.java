package td3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltd3/b;", "", "", "groupId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "authorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "triggerMode", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("trigger_mode")
    private final Integer triggerMode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.triggerMode, r101.triggerMode) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.groupId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.authorId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.triggerMode;
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
        return "PitayaInflowAutoExpandModel(groupId=" + this.groupId + ", authorId=" + this.authorId + ", triggerMode=" + this.triggerMode + ")";
    }

    public b() {
        this.groupId = null;
        this.authorId = null;
        this.triggerMode = null;
    }

    public final String a() {
        return this.authorId;
    }

    public final String b() {
        return this.groupId;
    }

    public final Integer c() {
        return this.triggerMode;
    }
}
