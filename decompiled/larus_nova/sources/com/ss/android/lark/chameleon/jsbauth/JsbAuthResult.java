package com.ss.android.lark.chameleon.jsbauth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0013H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleon/jsbauth/JsbAuthResult;", "", "passed", "", "errorCode", "Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;", "successCode", "Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;", "<init>", "(ZLcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;)V", "(Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;)V", "(Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;)V", "getPassed", "()Z", "getErrorCode", "()Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;", "getSuccessCode", "()Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;", "status", "", "getStatus", "()Ljava/lang/String;", "obtainStatue", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JsbAuthResult {
    private final AuthErrorCode errorCode;
    private final boolean passed;
    private final AuthSuccessCode successCode;

    public static /* synthetic */ JsbAuthResult copy$default(JsbAuthResult r100, boolean r101, AuthErrorCode r102, AuthSuccessCode r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.passed;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.successCode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.passed;
    }

    public final AuthErrorCode component2() {
        return this.errorCode;
    }

    public final AuthSuccessCode component3() {
        return this.successCode;
    }

    public final JsbAuthResult copy(boolean r100, AuthErrorCode r101, AuthSuccessCode r102) {
        return new JsbAuthResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JsbAuthResult) == true) goto L8;
        return false;
    L8:
        JsbAuthResult r101 = (JsbAuthResult) r100;
        if (this.passed == r101.passed) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.successCode, r101.successCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.passed == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        AuthErrorCode r102 = this.errorCode;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        AuthSuccessCode r106 = this.successCode;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "JsbAuthResult(passed=" + this.passed + ", errorCode=" + this.errorCode + ", successCode=" + this.successCode + ')';
    }

    private final String obtainStatue() {
        AuthSuccessCode r100 = this.successCode;
        if (r100 != null) goto L5;
        AuthErrorCode r101 = this.errorCode;
        if (r101 == null) goto L11;
        return "{ passed: " + this.passed + " errorCode: " + r101.getCode() + ", msg: " + r101.getMsg() + '}';
    L11:
        return "{passed: " + this.passed + '}';
    L5:
        return "{ passed: " + this.passed + " successCode: " + r100.getCode() + ", msg: " + r100.getMsg() + '}';
    }

    public final String getStatus() {
        return obtainStatue();
    }

    public final AuthErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final boolean getPassed() {
        return this.passed;
    }

    public final AuthSuccessCode getSuccessCode() {
        return this.successCode;
    }

    public JsbAuthResult(AuthErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        this(false, r100, null, 4, null);
    }

    public JsbAuthResult(AuthSuccessCode r100) {
        Intrinsics.checkNotNullParameter(r100, "successCode");
        this(true, null, r100, 2, null);
    }

    private JsbAuthResult(boolean r100, AuthErrorCode r101, AuthSuccessCode r102) {
        this.passed = r100;
        this.errorCode = r101;
        this.successCode = r102;
    }

    public /* synthetic */ JsbAuthResult(boolean r100, AuthErrorCode r101, AuthSuccessCode r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
