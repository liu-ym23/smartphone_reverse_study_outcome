package com.ss.android.lark.passport.flow.mfa;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JR\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "Ljava/io/Serializable;", "category", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "message", "", "cause", "", "stepName", "serverCode", "", "logId", "<init>", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCategory", "()Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "getStepName", "getServerCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLogId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "equals", "", "other", "", "hashCode", "toString", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMfaError implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final FlowMfaErrorCategory category;
    private final Throwable cause;
    private final String logId;
    private final String message;
    private final Integer serverCode;
    private final String stepName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ FlowMfaError copy$default(FlowMfaError r100, FlowMfaErrorCategory r101, String r102, Throwable r103, String r104, Integer r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.category;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.message;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.cause;
    L11:
        Throwable r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.stepName;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.serverCode;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.logId;
    L20:
        FlowMfaErrorCategory r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final FlowMfaErrorCategory component1() {
        return this.category;
    }

    public final String component2() {
        return this.message;
    }

    public final Throwable component3() {
        return this.cause;
    }

    public final String component4() {
        return this.stepName;
    }

    public final Integer component5() {
        return this.serverCode;
    }

    public final String component6() {
        return this.logId;
    }

    public final FlowMfaError copy(FlowMfaErrorCategory r100, String r110, Throwable r111, String r112, Integer r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r110, "message");
        return new FlowMfaError(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowMfaError) == true) goto L8;
        return false;
    L8:
        FlowMfaError r101 = (FlowMfaError) r100;
        if (this.category == r101.category) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cause, r101.cause) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.stepName, r101.stepName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serverCode, r101.serverCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.category.hashCode() * 31) + this.message.hashCode()) * 31;
        Throwable r101 = this.cause;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.stepName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.serverCode;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.logId;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "FlowMfaError(category=" + this.category + ", message=" + this.message + ", cause=" + this.cause + ", stepName=" + this.stepName + ", serverCode=" + this.serverCode + ", logId=" + this.logId + ')';
    }

    public final FlowMfaErrorCategory getCategory() {
        return this.category;
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getServerCode() {
        return this.serverCode;
    }

    public final String getStepName() {
        return this.stepName;
    }

    public FlowMfaError(FlowMfaErrorCategory r100, String r101, Throwable r102, String r103, Integer r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.category = r100;
        this.message = r101;
        this.cause = r102;
        this.stepName = r103;
        this.serverCode = r104;
        this.logId = r105;
    }

    public /* synthetic */ FlowMfaError(FlowMfaErrorCategory r110, String r111, Throwable r112, String r113, Integer r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        Throwable r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r116 & 32) == 0) goto L17;
        String r103 = null;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
