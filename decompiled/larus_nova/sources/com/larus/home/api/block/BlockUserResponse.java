package com.larus.home.api.block;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/home/api/block/BlockUserResponse;", "", "botIds", "", "", "conversationIds", "blockUserId", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBotIds", "()Ljava/util/List;", "getConversationIds", "getBlockUserId", "()Ljava/lang/String;", "setBlockUserId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockUserResponse {
    private transient String blockUserId;

    @SerializedName("deleted_bot_id_list")
    private final List<String> botIds;

    @SerializedName("deleted_conversation_id_list")
    private final List<String> conversationIds;

    public BlockUserResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlockUserResponse copy$default(BlockUserResponse r100, List r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.botIds;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.conversationIds;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.blockUserId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<String> component1() {
        return this.botIds;
    }

    public final List<String> component2() {
        return this.conversationIds;
    }

    public final String component3() {
        return this.blockUserId;
    }

    public final BlockUserResponse copy(List<String> r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "blockUserId");
        return new BlockUserResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockUserResponse) == true) goto L8;
        return false;
    L8:
        BlockUserResponse r101 = (BlockUserResponse) r100;
        if (Intrinsics.areEqual(this.botIds, r101.botIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationIds, r101.conversationIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.blockUserId, r101.blockUserId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.botIds;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.conversationIds;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.blockUserId.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockUserResponse(botIds=" + this.botIds + ", conversationIds=" + this.conversationIds + ", blockUserId=" + this.blockUserId + ')';
    }

    public final String getBlockUserId() {
        return this.blockUserId;
    }

    public final List<String> getBotIds() {
        return this.botIds;
    }

    public final List<String> getConversationIds() {
        return this.conversationIds;
    }

    public final void setBlockUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blockUserId = r100;
    }

    public BlockUserResponse(List<String> r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "blockUserId");
        this.botIds = r100;
        this.conversationIds = r101;
        this.blockUserId = r102;
    }

    public /* synthetic */ BlockUserResponse(List r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
