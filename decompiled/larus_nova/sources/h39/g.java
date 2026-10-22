package h39;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JD\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/doc/impl/chat/data/GetSubConversationRequestV2;", "", "resourceIds", "", "resourceType", "", "sourceType", "needCurrentVersion", "", "fillMessageId", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;ZZ)V", "getResourceIds", "()Ljava/lang/String;", "getResourceType", "()I", "getSourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNeedCurrentVersion", "()Z", "getFillMessageId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/Integer;ZZ)Lcom/larus/doc/impl/chat/data/GetSubConversationRequestV2;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("try_fill_answer_message_id")
    private final boolean fillMessageId;

    @SerializedName("need_current_version")
    private final boolean needCurrentVersion;

    @SerializedName("resource_id")
    private final String resourceIds;

    @SerializedName("resource_type")
    private final int resourceType;

    @SerializedName("source_type")
    private final Integer sourceType;

    public g() {
        this(null, 0, null, true, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L12;
        return false;
    L12:
        if (this.resourceType == r101.resourceType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L18;
        return false;
    L18:
        if (this.needCurrentVersion == r101.needCurrentVersion) goto L21;
        return false;
    L21:
        if (this.fillMessageId == r101.fillMessageId) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.resourceIds;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.resourceType) * 31;
        Integer r104 = this.sourceType;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.needCurrentVersion == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.fillMessageId == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetSubConversationRequestV2(resourceIds=" + this.resourceIds + ", resourceType=" + this.resourceType + ", sourceType=" + this.sourceType + ", needCurrentVersion=" + this.needCurrentVersion + ", fillMessageId=" + this.fillMessageId + ')';
    }

    public g(String r100, int r101, Integer r102, boolean r103, boolean r104) {
        this.resourceIds = r100;
        this.resourceType = r101;
        this.sourceType = r102;
        this.needCurrentVersion = r103;
        this.fillMessageId = r104;
    }
}
