package com.obric.assistant.interaction.impl.essentialtask.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "", "isSuccess", "", "errorInfo", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getErrorInfo", "()Ljava/lang/String;", "Succeed", "Failed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ExecuteResult {
    private final String errorInfo;
    private final boolean isSuccess;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult$Failed;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "errorInfo", "", "<init>", "(Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Failed extends ExecuteResult {
        public Failed(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            super(false, r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult$Succeed;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Succeed extends ExecuteResult {
        /* JADX WARN: Multi-variable type inference failed */
        public Succeed() {
            boolean r100 = true;
            super(r100, null, 2, 0 == true ? 1 : 0);
        }
    }

    public final String getErrorInfo() {
        return this.errorInfo;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public ExecuteResult(boolean r100, String r101) {
        this.isSuccess = r100;
        this.errorInfo = r101;
    }

    public /* synthetic */ ExecuteResult(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
