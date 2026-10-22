package t88;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/aiproactive/model/ParseUserAonTaskDraftRequest;", "", "doraSubBiz", "", "rawText", "", "imuCapability", "Lcom/larus/avlink/aiproactive/model/ImuCapability;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/avlink/aiproactive/model/ImuCapability;)V", "getDoraSubBiz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRawText", "()Ljava/lang/String;", "getImuCapability", "()Lcom/larus/avlink/aiproactive/model/ImuCapability;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/avlink/aiproactive/model/ImuCapability;)Lcom/larus/avlink/aiproactive/model/ParseUserAonTaskDraftRequest;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName("dora_sub_biz")
    private final Integer doraSubBiz;

    @SerializedName("imu_capability")
    private final l imuCapability;

    @SerializedName("raw_text")
    private final String rawText;

    public m() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.doraSubBiz, r101.doraSubBiz) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawText, r101.rawText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imuCapability, r101.imuCapability) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.doraSubBiz;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rawText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.imuCapability;
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
        return "ParseUserAonTaskDraftRequest(doraSubBiz=" + this.doraSubBiz + ", rawText=" + this.rawText + ", imuCapability=" + this.imuCapability + ')';
    }

    public m(String r100, l r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        Integer r103 = 3;
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        this.doraSubBiz = r103;
        this.rawText = r100;
        this.imuCapability = r101;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
