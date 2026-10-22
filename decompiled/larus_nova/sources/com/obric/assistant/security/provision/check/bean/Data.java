package com.obric.assistant.security.provision.check.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/security/provision/check/bean/Data;", "", "code", "", "logId", "", "message", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getLogId", "()Ljava/lang/String;", "getMessage", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Data {
    private final int code;
    private final String logId;
    private final String message;

    public static /* synthetic */ Data copy$default(Data r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.logId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.message;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.logId;
    }

    public final String component3() {
        return this.message;
    }

    public final Data copy(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        Intrinsics.checkNotNullParameter(r102, "message");
        return new Data(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Data) == true) goto L8;
        return false;
    L8:
        Data r101 = (Data) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.code * 31) + this.logId.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "{code=" + this.code + ", logId=" + this.logId + ", message=" + this.message + '}';
    }

    public final int getCode() {
        return this.code;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public Data(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.code = r100;
        this.logId = r101;
        this.message = r102;
    }
}
