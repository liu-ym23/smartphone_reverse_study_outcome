package nn1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lnn1/e;", "", "", "tagId", "J", "b", "()J", "", "tagName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "level", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("level")
    private final long level;

    @SerializedName("tag_id")
    private final long tagId;

    @SerializedName("tag_name")
    private final String tagName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (this.tagId == r101.tagId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tagName, r101.tagName) == true) goto L10;
        return false;
    L10:
        if (this.level == r101.level) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.tagId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.tagName;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        long r104 = this.level;
        return ((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomTagV4(tagId=" + this.tagId + ", tagName=" + this.tagName + ", level=" + this.level + ")";
    }

    public final long a() {
        return this.level;
    }

    public final long b() {
        return this.tagId;
    }

    public final String c() {
        return this.tagName;
    }
}
