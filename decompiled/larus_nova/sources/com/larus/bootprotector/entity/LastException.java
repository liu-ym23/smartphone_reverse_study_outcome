package com.larus.bootprotector.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BQ\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/bootprotector/entity/LastException;", "Lcom/larus/bootprotector/entity/BaseExceptionInfo;", "exceptionStackTrace", "", "exceptionTime", "", "type", "Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;", "appVersion", "updateVersion", "", "osVersion", "processName", "threadName", "<init>", "(Ljava/lang/String;JLcom/larus/bootprotector/entity/BaseExceptionInfo$Type;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getExceptionStackTrace", "()Ljava/lang/String;", "setExceptionStackTrace", "(Ljava/lang/String;)V", "getExceptionTime", "()J", "setExceptionTime", "(J)V", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LastException extends BaseExceptionInfo {
    private String exceptionStackTrace;
    private long exceptionTime;

    public String toString() {
        StringBuilder r100 = new StringBuilder("exceptionStackTrace=");
        String r101 = this.exceptionStackTrace;
        if (r101 == null) goto L5;
        String r102 = StringsKt.take(r101, 200);
    L6:
        r100.append(r102);
        r100.append(",exceptionTime=");
        r100.append(this.exceptionTime);
        r100.append(",type=");
        r100.append(getCrashType());
        r100.append(",appVersion=");
        r100.append(getAppVersion());
        r100.append(",updateVersion=");
        r100.append(getUpdateVersion());
        r100.append(",osVersion=");
        r100.append(getOsVersion());
        r100.append(",processName=");
        r100.append(getProcessName());
        r100.append(",threadName=");
        r100.append(getThreadName());
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final String getExceptionStackTrace() {
        return this.exceptionStackTrace;
    }

    public final long getExceptionTime() {
        return this.exceptionTime;
    }

    public final void setExceptionStackTrace(String r100) {
        this.exceptionStackTrace = r100;
    }

    public final void setExceptionTime(long r100) {
        this.exceptionTime = r100;
    }

    public LastException(String r100, long r110, BaseExceptionInfo.Type r111, String r112, int r113, int r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r111, "type");
        super(r111, r112, r113, r114, r115, r116);
        this.exceptionStackTrace = r100;
        this.exceptionTime = r110;
    }
}
