package com.bytedance.ee.docsdk.impl.base;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J$\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\b\u0010\"\u001a\u00020\u0003H\u0016J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0004R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/base/BlockInfo;", "", ResourceData.KEY_TOKEN, "", "(Ljava/lang/String;)V", "()V", ResourceData.KEY_TYPE, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "creatorTenantId", "getCreatorTenantId", "()Ljava/lang/String;", "setCreatorTenantId", "encryptId", "getEncryptId", "setEncryptId", "ownerUserId", "getOwnerUserId", "setOwnerUserId", "getToken", "setToken", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/docsdk/impl/base/BlockInfo;", "equals", "", "other", "hashCode", "toString", "update", "", "block", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
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
        return "BlockInfo(token='" + EncriptUtils.maskObjToken(this.token) + "', type=" + this.type + ", creatorTenantId=" + this.creatorTenantId + ')';
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
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
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
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
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
