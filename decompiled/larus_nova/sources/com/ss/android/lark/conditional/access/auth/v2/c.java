package com.ss.android.lark.conditional.access.auth.v2;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u00101\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0000J\u0010\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0002J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0003J\u0081\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\"\"\u0004\b%\u0010$R\u001e\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b&\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R \u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 ¨\u0006C"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/FilePolicyResult;", "", "resultType", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "resultSource", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", SlcCommonAction.KEY_ACTIONS, "", "Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "needDelete", "", "isValid", "isImShareValid", "pointKey", "", "cacheHitTaskId", "cacheType", "validateLogInfos", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateLogInfo;", "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getResultType", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "setResultType", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;)V", "getResultSource", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "setResultSource", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getNeedDelete", "()Z", "setNeedDelete", "(Z)V", "setValid", "setImShareValid", "getPointKey", "()Ljava/lang/String;", "setPointKey", "(Ljava/lang/String;)V", "getCacheHitTaskId", "setCacheHitTaskId", "getCacheType", "setCacheType", "getValidateLogInfos", "setValidateLogInfos", "compareTo", "other", "compareWithPriority", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "hashCode", "", "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("action")
    private List<DecisionData.Action> actions;

    @SerializedName("cacheHitTaskId")
    private String cacheHitTaskId;

    @SerializedName("cacheType")
    private String cacheType;

    @SerializedName("isImShareValid")
    private boolean isImShareValid;

    @SerializedName("isValid")
    private boolean isValid;

    @SerializedName("needDelete")
    private boolean needDelete;

    @SerializedName("pointKey")
    private String pointKey;

    @SerializedName("resultSource")
    private ValidateResultSource resultSource;

    @SerializedName("resultType")
    private ResultType resultType;

    @SerializedName("policySetKeys")
    private List<ValidateLogInfo> validateLogInfos;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.resultType == r101.resultType) goto L12;
        return false;
    L12:
        if (this.resultSource == r101.resultSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L18;
        return false;
    L18:
        if (this.needDelete == r101.needDelete) goto L21;
        return false;
    L21:
        if (this.isValid == r101.isValid) goto L24;
        return false;
    L24:
        if (this.isImShareValid == r101.isImShareValid) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pointKey, r101.pointKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cacheHitTaskId, r101.cacheHitTaskId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cacheType, r101.cacheType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.validateLogInfos, r101.validateLogInfos) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.resultType.hashCode() * 31) + this.resultSource.hashCode()) * 31;
        List<DecisionData.Action> r101 = this.actions;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.needDelete == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.isValid == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.isImShareValid == true) goto L18;
        r105 = 1237;
    L18:
        int r110 = (r109 + r105) * 31;
        String r111 = this.pointKey;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.cacheHitTaskId;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.cacheType;
        if (r117 == null) goto L31;
        r102 = r117.hashCode();
    L31:
        return ((r116 + r102) * 31) + this.validateLogInfos.hashCode();
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final void o() {
        this.isImShareValid = false;
    }

    public final String toString() {
        return "FilePolicyResult(resultType=" + this.resultType + ", resultSource=" + this.resultSource + ", actions=" + this.actions + ", needDelete=" + this.needDelete + ", isValid=" + this.isValid + ", isImShareValid=" + this.isImShareValid + ", pointKey=" + this.pointKey + ", cacheHitTaskId=" + this.cacheHitTaskId + ", cacheType=" + this.cacheType + ", validateLogInfos=" + this.validateLogInfos + ')';
    }

    public final List<DecisionData.Action> b() {
        return this.actions;
    }

    public final String c() {
        return this.cacheHitTaskId;
    }

    public final String d() {
        return this.cacheType;
    }

    public final boolean e() {
        return this.needDelete;
    }

    public final String f() {
        return this.pointKey;
    }

    public final ValidateResultSource g() {
        return this.resultSource;
    }

    public final ResultType h() {
        return this.resultType;
    }

    public final List<ValidateLogInfo> i() {
        return this.validateLogInfos;
    }

    public final boolean j() {
        return this.isImShareValid;
    }

    public final boolean k() {
        return this.isValid;
    }

    public final c a(c r100) {
        if (w4c.c.a().E() == false) goto L11;
        ArrayList r101 = new ArrayList();
        r101.addAll(this.validateLogInfos);
        if (r100 == null) goto L9;
        List<ValidateLogInfo> r102 = r100.validateLogInfos;
        if (r102 == null) goto L9;
    L10:
        r101.addAll(r102);
        List<ValidateLogInfo> r103 = r101;
    L15:
        if (r100 != null) goto L18;
    L16:
        r100 = this;
    L59:
        r100.validateLogInfos = r103;
        return r100;
    L18:
        if (this.resultType.ordinal() < r100.resultType.ordinal()) goto L16;
        if (this.resultType.ordinal() > r100.resultType.ordinal()) goto L59;
        List<DecisionData.Action> r104 = this.actions;
        String r105 = AccountType.OTHERS;
        if (r104 == null) goto L29;
        DecisionData.Action r106 = (DecisionData.Action) CollectionsKt.firstOrNull(r104);
        if (r106 == null) goto L29;
        String r107 = r106.getName();
        if (r107 == null) goto L29;
    L30:
        List<DecisionData.Action> r108 = r100.actions;
        if (r108 == null) goto L38;
        DecisionData.Action r109 = (DecisionData.Action) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L38;
        String r110 = r109.getName();
        if (r110 == null) goto L38;
        r105 = r110;
    L38:
        Map<String, Integer> r111 = g.f417797a;
        Integer r112 = r111.get(r107);
        int r113 = 0;
        if (r112 == null) goto L41;
        int r114 = r112.intValue();
    L42:
        Integer r115 = r111.get(r105);
        if (r115 == null) goto L45;
        r113 = r115.intValue();
    L45:
        if (r114 > r113) goto L16;
        if (r114 < r113) goto L59;
        if (this.resultSource.ordinal() < r100.resultSource.ordinal()) goto L59;
        if (this.resultSource.ordinal() > r100.resultSource.ordinal()) goto L16;
        if (g.c(this) == false) goto L16;
        if (g.c(r100) == true) goto L16;
    L41:
        r114 = 0;
    L29:
        r107 = AccountType.OTHERS;
    L9:
        r102 = CollectionsKt.emptyList();
        goto L10
    L11:
        if (r100 == null) goto L14;
        List<ValidateLogInfo> r116 = r100.validateLogInfos;
        r103 = r116;
        if (r116 != null) goto L15;
    L14:
        r103 = CollectionsKt.emptyList();
        goto L15
    }

    public final void l(List<DecisionData.Action> r100) {
        this.actions = r100;
    }

    public final void m(String r100) {
        this.cacheHitTaskId = r100;
    }

    public final void n(String r100) {
        this.cacheType = r100;
    }

    public final void p(boolean r100) {
        this.needDelete = r100;
    }

    public final void q(String r100) {
        this.pointKey = r100;
    }

    public final void r(ValidateResultSource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultSource = r100;
    }

    public final void s(ResultType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultType = r100;
    }

    public final void t(boolean r100) {
        this.isValid = r100;
    }

    public final void u(List<ValidateLogInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.validateLogInfos = r100;
    }

    public c(ResultType r100, ValidateResultSource r101, List r102, List r103, int r104) {
        boolean r105 = true;
        if ((r104 & 16) == 0) goto L5;
        boolean r106 = true;
    L7:
        if ((r104 & 32) != 0) goto L11;
        r105 = false;
    L11:
        if ((r104 & 512) == 0) goto L13;
        r103 = CollectionsKt.emptyList();
    L13:
        Intrinsics.checkNotNullParameter(r100, "resultType");
        Intrinsics.checkNotNullParameter(r101, "resultSource");
        Intrinsics.checkNotNullParameter(r103, "validateLogInfos");
        this.resultType = r100;
        this.resultSource = r101;
        this.actions = r102;
        this.needDelete = false;
        this.isValid = r106;
        this.isImShareValid = r105;
        this.pointKey = null;
        this.cacheHitTaskId = null;
        this.cacheType = null;
        this.validateLogInfos = r103;
        return;
    L5:
        r106 = false;
        goto L7
    }
}
