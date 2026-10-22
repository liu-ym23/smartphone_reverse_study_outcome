package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\b\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020+R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "Ljava/io/Serializable;", "result", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;)V", "()V", "getResult", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "setResult", "resultPolicy", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileAuthResultFrom;", "getResultPolicy", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileAuthResultFrom;", "setResultPolicy", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileAuthResultFrom;)V", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "", "getErrorReason", "()I", "setErrorReason", "(I)V", "policyMethod", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "getPolicyMethod", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "setPolicyMethod", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;)V", "isCredible", "", "()Z", "setCredible", "(Z)V", "validateResultExtra", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult$ValidateResultExtra;", "getValidateResultExtra", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult$ValidateResultExtra;", "setValidateResultExtra", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult$ValidateResultExtra;)V", "reportUserOperate", "", "handleAction", "toString", "", "toJsonString", "ValidateResultExtra", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValidateResult implements Serializable {
    private int errorReason;
    private boolean isCredible;
    private ValidateResultSource policyMethod;
    private ResultType result;
    private FileAuthResultFrom resultPolicy;
    private ValidateResultExtra validateResultExtra;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR(\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006'"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult$ValidateResultExtra;", "Ljava/io/Serializable;", "<init>", "()V", "rawActions", "", "getRawActions", "()Ljava/lang/String;", "setRawActions", "(Ljava/lang/String;)V", "resultLogs", "", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateLogInfo;", "getResultLogs", "()Ljava/util/List;", "setResultLogs", "(Ljava/util/List;)V", "interactionType", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/InteractionType;", "getInteractionType", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/InteractionType;", "setInteractionType", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/InteractionType;)V", "pointKey", "getPointKey", "setPointKey", "cacheHitTaskId", "getCacheHitTaskId", "setCacheHitTaskId", "cacheType", "getCacheType", "setCacheType", "traceId", "getTraceId", "setTraceId", "value", "cacheHitIdentifier", "getCacheHitIdentifier", "setCacheHitIdentifier", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ValidateResultExtra implements Serializable {
        private String cacheHitTaskId;
        private String cacheType;
        private InteractionType interactionType;
        private String pointKey;
        private String rawActions;
        private List<ValidateLogInfo> resultLogs;
        private String traceId;

        public ValidateResultExtra() {
            this.rawActions = "";
            this.resultLogs = CollectionsKt.emptyList();
            this.interactionType = InteractionType.DEFAULT;
            this.traceId = "";
        }

        public final String getCacheHitIdentifier() {
            return this.cacheType;
        }

        public final String getCacheHitTaskId() {
            return this.cacheHitTaskId;
        }

        public final String getCacheType() {
            return this.cacheType;
        }

        public final InteractionType getInteractionType() {
            return this.interactionType;
        }

        public final String getPointKey() {
            return this.pointKey;
        }

        public final String getRawActions() {
            return this.rawActions;
        }

        public final List<ValidateLogInfo> getResultLogs() {
            return this.resultLogs;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final void setCacheHitIdentifier(String r100) {
            this.cacheType = r100;
        }

        public final void setCacheHitTaskId(String r100) {
            this.cacheHitTaskId = r100;
        }

        public final void setCacheType(String r100) {
            this.cacheType = r100;
        }

        public final void setInteractionType(InteractionType r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.interactionType = r100;
        }

        public final void setPointKey(String r100) {
            this.pointKey = r100;
        }

        public final void setRawActions(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.rawActions = r100;
        }

        public final void setResultLogs(List<ValidateLogInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.resultLogs = r100;
        }

        public final void setTraceId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.traceId = r100;
        }
    }

    public ValidateResult() {
        this(ResultType.ALLOW);
    }

    public final void handleAction() {
        ValidateResultExtra r100 = this.validateResultExtra;
        if (r100 == null) goto L13;
        SecurityActionHandleContext r101 = new SecurityActionHandleContext(r100.getPointKey(), r100.getCacheHitTaskId(), r100.getCacheType());
        final SecurityAction r102 = new SecurityAction(r100.getRawActions(), r100.getTraceId(), 0, 0, 12, null);
        r102.setHandleContext(r101);
        Function0<Unit> r103 = new ValidateResult$handleAction$1$callApi$1(r102);
        if (Intrinsics.areEqual(qqb.a.d(), "") == true) goto L14;
        r103.invoke();
        return;
    L14:
        qqb.a.h("ValidateResult.handleAction()");     // Catch: Throwable -> L10
        r103.invoke();     // Catch: Throwable -> L10
        qqb.a.a();
        return;
    L10:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void reportUserOperate() {
        ValidateResultExtra r100 = this.validateResultExtra;
        if (r100 == null) goto L6;
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).k(r100.getResultLogs());
        return;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("result=");
        r100.append(this.result.name());
        r100.append(",resultPolicy=");
        r100.append(this.resultPolicy.name());
        r100.append(",policyMethod=");
        r100.append(this.policyMethod.name());
        r100.append(",isCredible=");
        r100.append(this.isCredible);
        r100.append(",errorReason=");
        r100.append(this.errorReason);
        r100.append(",interactionType=");
        ValidateResultExtra r101 = this.validateResultExtra;
        String r102 = null;
        if (r101 == null) goto L5;
        InteractionType r103 = r101.getInteractionType();
    L6:
        r100.append(r103);
        r100.append(",pointKey=");
        ValidateResultExtra r104 = this.validateResultExtra;
        if (r104 == null) goto L9;
        String r105 = r104.getPointKey();
    L10:
        r100.append(r105);
        r100.append(",cacheType=");
        ValidateResultExtra r106 = this.validateResultExtra;
        if (r106 == null) goto L13;
        String r107 = r106.getCacheType();
    L14:
        r100.append(r107);
        r100.append(",traceId=");
        ValidateResultExtra r108 = this.validateResultExtra;
        if (r108 == null) goto L17;
        r102 = r108.getTraceId();
    L17:
        r100.append(r102);
        return r100.toString();
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final String toJsonString() {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this);
    }

    public final int getErrorReason() {
        return this.errorReason;
    }

    public final ValidateResultSource getPolicyMethod() {
        return this.policyMethod;
    }

    public final ResultType getResult() {
        return this.result;
    }

    public final FileAuthResultFrom getResultPolicy() {
        return this.resultPolicy;
    }

    public final ValidateResultExtra getValidateResultExtra() {
        return this.validateResultExtra;
    }

    public final boolean isCredible() {
        return this.isCredible;
    }

    public ValidateResult(ResultType r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.result = r100;
        this.resultPolicy = FileAuthResultFrom.COME_FROM_UNKNOWN;
        this.policyMethod = ValidateResultSource.OTHERS;
        this.isCredible = true;
    }

    public final void setCredible(boolean r100) {
        this.isCredible = r100;
    }

    public final void setErrorReason(int r100) {
        this.errorReason = r100;
    }

    public final void setPolicyMethod(ValidateResultSource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.policyMethod = r100;
    }

    public final void setResult(ResultType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.result = r100;
    }

    public final void setResultPolicy(FileAuthResultFrom r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultPolicy = r100;
    }

    public final void setValidateResultExtra(ValidateResultExtra r100) {
        this.validateResultExtra = r100;
    }
}
