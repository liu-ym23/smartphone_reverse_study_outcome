package com.ss.android.lark.ug.scheduler.common.exception;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r9c.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b \u0018\u00002\u00060\u0001j\u0002`\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\tH&J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorInfo", "Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerMetricInfo;", "cause", "", "extraInfo", "", "", "<init>", "(Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerMetricInfo;Ljava/lang/Throwable;Ljava/util/Map;)V", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "getMetricKey", "getErrorCode", "getErrorMessage", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SchedulerException extends Exception {
    private final a errorInfo;
    private Map<String, String> extraInfo;

    public abstract String getMetricKey();

    public final String getErrorCode() {
        return this.errorInfo.getErrorCode();
    }

    public final String getErrorMessage() {
        return this.errorInfo.getErrorMessage();
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        this.extraInfo = r100;
    }

    public SchedulerException(a r100, Throwable r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        super(r100.getErrorMessage(), r101);
        this.errorInfo = r100;
        this.extraInfo = r102;
    }

    public /* synthetic */ SchedulerException(a r100, Throwable r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
