package com.larus.im.internal.jni;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/im/internal/jni/OmniCreateParam;", "", "userName", "", "senderId", "secUid", "dbName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserName", "()Ljava/lang/String;", "getSenderId", "getSecUid", "getDbName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniCreateParam {
    private final String dbName;
    private final String secUid;
    private final String senderId;
    private final String userName;

    public static /* synthetic */ OmniCreateParam copy$default(OmniCreateParam r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.userName;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.senderId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.secUid;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.dbName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.senderId;
    }

    public final String component3() {
        return this.secUid;
    }

    public final String component4() {
        return this.dbName;
    }

    public final OmniCreateParam copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "senderId");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        Intrinsics.checkNotNullParameter(r103, "dbName");
        return new OmniCreateParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniCreateParam) == true) goto L8;
        return false;
    L8:
        OmniCreateParam r101 = (OmniCreateParam) r100;
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dbName, r101.dbName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.userName.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.secUid.hashCode()) * 31) + this.dbName.hashCode();
    }

    public String toString() {
        return "OmniCreateParam(userName=" + this.userName + ", senderId=" + this.senderId + ", secUid=" + this.secUid + ", dbName=" + this.dbName + ')';
    }

    public final String getDbName() {
        return this.dbName;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public OmniCreateParam(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "senderId");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        Intrinsics.checkNotNullParameter(r103, "dbName");
        this.userName = r100;
        this.senderId = r101;
        this.secUid = r102;
        this.dbName = r103;
    }
}
