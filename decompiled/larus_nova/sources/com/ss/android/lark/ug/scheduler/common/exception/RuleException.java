package com.ss.android.lark.ug.scheduler.common.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/common/exception/RuleException;", "Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerException;", "errorInfo", "Lcom/ss/android/lark/ug/scheduler/common/exception/RuleMetricErrorInfo;", "cause", "", "<init>", "(Lcom/ss/android/lark/ug/scheduler/common/exception/RuleMetricErrorInfo;Ljava/lang/Throwable;)V", "getMetricKey", "", "Companion", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RuleException extends SchedulerException {
    public static final a Companion = null;
    public static final String METRIC_KEY = "ug_reach_local_rule_error";
    public static final String VALUE_KEY = "value";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.ug.scheduler.common.exception.SchedulerException
    public String getMetricKey() {
        return METRIC_KEY;
    }

    public RuleException(RuleMetricErrorInfo r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        super(r100, r101, null, 4, null);
    }

    public /* synthetic */ RuleException(RuleMetricErrorInfo r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
