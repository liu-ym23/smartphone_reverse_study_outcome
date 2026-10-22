package com.larus.home.api.block;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/home/api/block/BlockUserListResponse;", "", "blockUserInfo", "", "Lcom/larus/home/api/block/BlockUserInfo;", "hasMore", "", "<init>", "(Ljava/util/List;Z)V", "getBlockUserInfo", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockUserListResponse {

    @SerializedName("blocklist_users")
    private final List<BlockUserInfo> blockUserInfo;

    @SerializedName("has_more")
    private final boolean hasMore;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockUserListResponse() {
        List r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlockUserListResponse copy$default(BlockUserListResponse r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.blockUserInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<BlockUserInfo> component1() {
        return this.blockUserInfo;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final BlockUserListResponse copy(List<BlockUserInfo> r100, boolean r101) {
        return new BlockUserListResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockUserListResponse) == true) goto L8;
        return false;
    L8:
        BlockUserListResponse r101 = (BlockUserListResponse) r100;
        if (Intrinsics.areEqual(this.blockUserInfo, r101.blockUserInfo) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<BlockUserInfo> r100 = this.blockUserInfo;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.hasMore == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockUserListResponse(blockUserInfo=" + this.blockUserInfo + ", hasMore=" + this.hasMore + ')';
    }

    public final List<BlockUserInfo> getBlockUserInfo() {
        return this.blockUserInfo;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public BlockUserListResponse(List<BlockUserInfo> r100, boolean r101) {
        this.blockUserInfo = r100;
        this.hasMore = r101;
    }

    public /* synthetic */ BlockUserListResponse(List r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
