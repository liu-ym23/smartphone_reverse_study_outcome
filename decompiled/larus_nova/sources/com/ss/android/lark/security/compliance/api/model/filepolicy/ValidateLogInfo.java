package com.ss.android.lark.security.compliance.api.model.filepolicy;

import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateLogInfo;", "Ljava/io/Serializable;", "uk", "", "policySetKeys", "Ljava/util/LinkedList;", "<init>", "(Ljava/lang/String;Ljava/util/LinkedList;)V", "getUk", "()Ljava/lang/String;", "setUk", "(Ljava/lang/String;)V", "getPolicySetKeys", "()Ljava/util/LinkedList;", "setPolicySetKeys", "(Ljava/util/LinkedList;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValidateLogInfo implements Serializable {
    private LinkedList<String> policySetKeys;

    /* JADX INFO: renamed from: uk, reason: collision with root package name */
    private String f440395uk;

    /* JADX WARN: Multi-variable type inference failed */
    public ValidateLogInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValidateLogInfo copy$default(ValidateLogInfo r100, String r101, LinkedList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f440395uk;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.policySetKeys;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f440395uk;
    }

    public final LinkedList<String> component2() {
        return this.policySetKeys;
    }

    public final ValidateLogInfo copy(String r100, LinkedList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "uk");
        Intrinsics.checkNotNullParameter(r101, "policySetKeys");
        return new ValidateLogInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ValidateLogInfo) == true) goto L8;
        return false;
    L8:
        ValidateLogInfo r101 = (ValidateLogInfo) r100;
        if (Intrinsics.areEqual(this.f440395uk, r101.f440395uk) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policySetKeys, r101.policySetKeys) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f440395uk.hashCode() * 31) + this.policySetKeys.hashCode();
    }

    public String toString() {
        return "ValidateLogInfo(uk=" + this.f440395uk + ", policySetKeys=" + this.policySetKeys + ')';
    }

    public final LinkedList<String> getPolicySetKeys() {
        return this.policySetKeys;
    }

    public final String getUk() {
        return this.f440395uk;
    }

    public final void setPolicySetKeys(LinkedList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.policySetKeys = r100;
    }

    public final void setUk(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440395uk = r100;
    }

    public ValidateLogInfo(String r100, LinkedList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "uk");
        Intrinsics.checkNotNullParameter(r101, "policySetKeys");
        this.f440395uk = r100;
        this.policySetKeys = r101;
    }

    public /* synthetic */ ValidateLogInfo(String r100, LinkedList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new LinkedList();
    L8:
        this(r100, r101);
    }
}
