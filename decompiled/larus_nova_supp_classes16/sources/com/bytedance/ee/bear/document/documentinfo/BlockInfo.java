package com.bytedance.ee.bear.document.documentinfo;

import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0000J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ$\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "", "token", "", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;)V", "()V", "getToken", "()Ljava/lang/String;", "setToken", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "creatorTenantId", "getCreatorTenantId", "setCreatorTenantId", "encryptId", "getEncryptId", "setEncryptId", "ownerUserId", "getOwnerUserId", "setOwnerUserId", "update", "", "block", "toString", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "equals", "", "other", "hashCode", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockInfo {
    private String creatorTenantId;
    private String encryptId;
    private String ownerUserId;
    private String token;
    private Integer type;

    public static /* synthetic */ BlockInfo copy$default(BlockInfo r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.token;
    }

    public final Integer component2() {
        return this.type;
    }

    public final BlockInfo copy(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "token");
        return new BlockInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockInfo) == true) goto L8;
        return false;
    L8:
        BlockInfo r6 = (BlockInfo) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.token.hashCode() * 31;
        Integer r1 = this.type;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
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

    public BlockInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        this(r2, null);
    }

    public final void setCreatorTenantId(String r1) {
        this.creatorTenantId = r1;
    }

    public final void setEncryptId(String r1) {
        this.encryptId = r1;
    }

    public final void setOwnerUserId(String r1) {
        this.ownerUserId = r1;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    public final void update(BlockInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Integer r0 = r2.type;
        if (r0 != null) goto L5;
        r0 = this.type;
    L5:
        this.type = r0;
        String r1 = r2.creatorTenantId;
        if (r1 != null) goto L8;
        r1 = this.creatorTenantId;
    L8:
        this.creatorTenantId = r1;
        String r3 = r2.encryptId;
        if (r3 != null) goto L11;
        r3 = this.encryptId;
    L11:
        this.encryptId = r3;
        String r4 = r2.ownerUserId;
        if (r4 != null) goto L14;
        r4 = this.ownerUserId;
    L14:
        this.ownerUserId = r4;
    }

    public BlockInfo(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "token");
        this.token = r2;
        this.type = r3;
    }

    public /* synthetic */ BlockInfo(String r1, Integer r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
