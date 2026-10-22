package sq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/creation/ToolPresentationBySource;", "", "userSend", "Lcom/larus/platform/model/creation/ToolPresentationConfig;", "botResp", "creationCard", "creationRecord", "<init>", "(Lcom/larus/platform/model/creation/ToolPresentationConfig;Lcom/larus/platform/model/creation/ToolPresentationConfig;Lcom/larus/platform/model/creation/ToolPresentationConfig;Lcom/larus/platform/model/creation/ToolPresentationConfig;)V", "getUserSend", "()Lcom/larus/platform/model/creation/ToolPresentationConfig;", "getBotResp", "getCreationCard", "getCreationRecord", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    @SerializedName("botResp")
    private final a0 botResp;

    @SerializedName("creationCard")
    private final a0 creationCard;

    @SerializedName("creationRecord")
    private final a0 creationRecord;

    @SerializedName("userSend")
    private final a0 userSend;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.userSend, r101.userSend) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botResp, r101.botResp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationCard, r101.creationCard) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationRecord, r101.creationRecord) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        a0 r100 = this.userSend;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a0 r104 = this.botResp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a0 r107 = this.creationCard;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a0 r110 = this.creationRecord;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolPresentationBySource(userSend=" + this.userSend + ", botResp=" + this.botResp + ", creationCard=" + this.creationCard + ", creationRecord=" + this.creationRecord + ')';
    }

    public z() {
        this.userSend = null;
        this.botResp = null;
        this.creationCard = null;
        this.creationRecord = null;
    }

    public final a0 a() {
        return this.botResp;
    }

    public final a0 b() {
        return this.creationCard;
    }

    public final a0 c() {
        return this.creationRecord;
    }

    public final a0 d() {
        return this.userSend;
    }
}
