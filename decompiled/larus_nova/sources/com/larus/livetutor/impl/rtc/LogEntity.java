package com.larus.livetutor.impl.rtc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/livetutor/impl/rtc/LogEntity;", "", "tag", "", "msg", "status", "Lcom/larus/livetutor/impl/rtc/LogStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/livetutor/impl/rtc/LogStatus;)V", "getTag", "()Ljava/lang/String;", "getMsg", "getStatus", "()Lcom/larus/livetutor/impl/rtc/LogStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogEntity {
    private final String msg;
    private final LogStatus status;
    private final String tag;

    public static /* synthetic */ LogEntity copy$default(LogEntity r100, String r101, String r102, LogStatus r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tag;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.msg;
    }

    public final LogStatus component3() {
        return this.status;
    }

    public final LogEntity copy(String r100, String r101, LogStatus r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "status");
        return new LogEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LogEntity) == true) goto L8;
        return false;
    L8:
        LogEntity r101 = (LogEntity) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (this.status == r101.status) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.tag.hashCode() * 31) + this.msg.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "LogEntity(tag=" + this.tag + ", msg=" + this.msg + ", status=" + this.status + ')';
    }

    public final String getMsg() {
        return this.msg;
    }

    public final LogStatus getStatus() {
        return this.status;
    }

    public final String getTag() {
        return this.tag;
    }

    public LogEntity(String r100, String r101, LogStatus r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "status");
        this.tag = r100;
        this.msg = r101;
        this.status = r102;
    }

    public /* synthetic */ LogEntity(String r100, String r101, LogStatus r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = LogStatus.Normal;
    L5:
        this(r100, r101, r102);
    }
}
