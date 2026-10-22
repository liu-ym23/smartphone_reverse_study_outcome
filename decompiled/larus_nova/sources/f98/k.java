package f98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/e/model/EndVisionSceneResponse;", "", "code", "", "msg", "", "data", "Lcom/larus/avlink/e/model/EndVisionSceneData;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/avlink/e/model/EndVisionSceneData;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/avlink/e/model/EndVisionSceneData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/avlink/e/model/EndVisionSceneData;)Lcom/larus/avlink/e/model/EndVisionSceneResponse;", "equals", "", "other", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("code")
    private final Long code;

    @SerializedName("data")
    private final i data;

    @SerializedName("msg")
    private final String msg;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.code;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        String r103 = this.msg;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + 0;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EndVisionSceneResponse(code=" + this.code + ", msg=" + this.msg + ", data=null)";
    }

    public k() {
        this.code = null;
        this.msg = null;
    }
}
