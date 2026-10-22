package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateConfig;", "", "<init>", "()V", "ignoreSecurityOperate", "", "getIgnoreSecurityOperate", "()Z", "setIgnoreSecurityOperate", "(Z)V", "ignoreReportUserOperate", "getIgnoreReportUserOperate", "setIgnoreReportUserOperate", "checkPriority", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CheckPriority;", "getCheckPriority", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CheckPriority;", "setCheckPriority", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CheckPriority;)V", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValidateConfig {
    private CheckPriority checkPriority;
    private boolean ignoreReportUserOperate;
    private boolean ignoreSecurityOperate;

    public ValidateConfig() {
        this.checkPriority = CheckPriority.CacheFirst;
    }

    public final CheckPriority getCheckPriority() {
        return this.checkPriority;
    }

    public final boolean getIgnoreReportUserOperate() {
        return this.ignoreReportUserOperate;
    }

    public final boolean getIgnoreSecurityOperate() {
        return this.ignoreSecurityOperate;
    }

    public final void setCheckPriority(CheckPriority r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.checkPriority = r100;
    }

    public final void setIgnoreReportUserOperate(boolean r100) {
        this.ignoreReportUserOperate = r100;
    }

    public final void setIgnoreSecurityOperate(boolean r100) {
        this.ignoreSecurityOperate = r100;
    }
}
