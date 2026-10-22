package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.security.android.aopcheck.utils.StackTraceUtil;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/AOPReportEvent;", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", ReportConstant.COMMON_ACTION_TYPE, "", "timestamp", "", "content", ReportConstant.COMMON_BACKTRACE, "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "getBacktrace", "setBacktrace", "getContent", "setContent", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "setThrowable", "", LynxError.LYNX_THROWABLE, "", "toString", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class AOPReportEvent implements IEvent {
    private String actionType;
    private String backtrace;
    private String content;
    private long timestamp;

    public AOPReportEvent() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ AOPReportEvent copy$default(AOPReportEvent r100, String r101, long r102, String r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actionType;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.timestamp;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.backtrace;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.actionType;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.backtrace;
    }

    public final AOPReportEvent copy(String r100, long r101, String r110, String r111) {
        return new AOPReportEvent(r100, r101, r110, r111);
    }

    public int hashCode() {
        int r100 = this.actionType.hashCode() * 31;
        long r101 = this.timestamp;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.content.hashCode()) * 31) + this.backtrace.hashCode();
    }

    public String toString() {
        return "AOPReportEvent(actionType='" + this.actionType + "', timestamp=" + this.timestamp + ", content='" + this.content + "', backtrace='" + this.backtrace + '\'';
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getBacktrace() {
        return this.backtrace;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        AOPReportEvent r101 = (AOPReportEvent) r100;
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backtrace, r101.backtrace) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public final void setActionType(String r100) {
        this.actionType = r100;
    }

    public final void setBacktrace(String r100) {
        this.backtrace = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setThrowable(Throwable r100) {
        if (r100 == null) goto L5;
        this.backtrace = StackTraceUtil.INSTANCE.getRawStack(r100);
        return;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public AOPReportEvent(String r100, long r101, String r102, String r103) {
        this.actionType = r100;
        this.timestamp = r101;
        this.content = r102;
        this.backtrace = r103;
    }

    public /* synthetic */ AOPReportEvent(String r100, long r101, String r102, String r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r105 = "";
    L14:
        if ((r110 & 8) == 0) goto L16;
        String r113 = "";
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L12:
        r105 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
