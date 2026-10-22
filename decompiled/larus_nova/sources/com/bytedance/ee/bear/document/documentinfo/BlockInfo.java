package com.bytedance.ee.bear.document.documentinfo;

import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0000J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ$\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "", "token", "", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;)V", "()V", "getToken", "()Ljava/lang/String;", "setToken", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "creatorTenantId", "getCreatorTenantId", "setCreatorTenantId", "encryptId", "getEncryptId", "setEncryptId", "ownerUserId", "getOwnerUserId", "setOwnerUserId", "update", "", "block", "toString", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "equals", "", "other", "hashCode", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockInfo {
    private String creatorTenantId;
    private String encryptId;
    private String ownerUserId;
    private String token;
    private Integer type;

    public static /* synthetic */ BlockInfo copy$default(BlockInfo r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.token;
    }

    public final Integer component2() {
        return this.type;
    }

    public final BlockInfo copy(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new BlockInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockInfo) == true) goto L8;
        return false;
    L8:
        BlockInfo r101 = (BlockInfo) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.token.hashCode() * 31;
        Integer r101 = this.type;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public BlockInfo() {
        this("", null);
    }

    public String toString() {
        return "BlockInfo(token='" + b.i(this.token) + "', type=" + this.type + ", creatorTenantId=" + this.creatorTenantId + ')';
    }

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final String getEncryptId() {
        return this.encryptId;
    }

    public final String getOwnerUserId() {
        return this.ownerUserId;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getType() {
        return this.type;
    }

    public BlockInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this(r100, null);
    }

    public final void setCreatorTenantId(String r100) {
        this.creatorTenantId = r100;
    }

    public final void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public final void setOwnerUserId(String r100) {
        this.ownerUserId = r100;
    }

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void update(BlockInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Integer r101 = r100.type;
        if (r101 != null) goto L5;
        r101 = this.type;
    L5:
        this.type = r101;
        String r102 = r100.creatorTenantId;
        if (r102 != null) goto L8;
        r102 = this.creatorTenantId;
    L8:
        this.creatorTenantId = r102;
        String r103 = r100.encryptId;
        if (r103 != null) goto L11;
        r103 = this.encryptId;
    L11:
        this.encryptId = r103;
        String r104 = r100.ownerUserId;
        if (r104 != null) goto L14;
        r104 = this.ownerUserId;
    L14:
        this.ownerUserId = r104;
    }

    public BlockInfo(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.token = r100;
        this.type = r101;
    }

    public /* synthetic */ BlockInfo(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
