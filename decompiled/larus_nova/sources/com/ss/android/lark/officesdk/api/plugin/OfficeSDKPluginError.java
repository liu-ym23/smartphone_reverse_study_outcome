package com.ss.android.lark.officesdk.api.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "", "stage", "Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;", "code", "", "message", "", "hostCode", "cause", "", "<init>", "(Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "getStage", "()Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getHostCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "equals", "", "other", "hashCode", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKPluginError {
    private final Throwable cause;
    private final int code;
    private final Integer hostCode;
    private final String message;
    private final OfficeSDKPluginStage stage;

    public static /* synthetic */ OfficeSDKPluginError copy$default(OfficeSDKPluginError r100, OfficeSDKPluginStage r101, int r102, String r103, Integer r104, Throwable r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.stage;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.code;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.message;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hostCode;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.cause;
    L17:
        OfficeSDKPluginStage r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final OfficeSDKPluginStage component1() {
        return this.stage;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final Integer component4() {
        return this.hostCode;
    }

    public final Throwable component5() {
        return this.cause;
    }

    public final OfficeSDKPluginError copy(OfficeSDKPluginStage r100, int r101, String r110, Integer r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r110, "message");
        return new OfficeSDKPluginError(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSDKPluginError) == true) goto L8;
        return false;
    L8:
        OfficeSDKPluginError r101 = (OfficeSDKPluginError) r100;
        if (this.stage == r101.stage) goto L12;
        return false;
    L12:
        if (this.code == r101.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostCode, r101.hostCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cause, r101.cause) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.stage.hashCode() * 31) + this.code) * 31) + this.message.hashCode()) * 31;
        Integer r101 = this.hostCode;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.cause;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSDKPluginError(stage=" + this.stage + ", code=" + this.code + ", message=" + this.message + ", hostCode=" + this.hostCode + ", cause=" + this.cause + ')';
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final int getCode() {
        return this.code;
    }

    public final Integer getHostCode() {
        return this.hostCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final OfficeSDKPluginStage getStage() {
        return this.stage;
    }

    public OfficeSDKPluginError(OfficeSDKPluginStage r100, int r101, String r102, Integer r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.stage = r100;
        this.code = r101;
        this.message = r102;
        this.hostCode = r103;
        this.cause = r104;
    }

    public /* synthetic */ OfficeSDKPluginError(OfficeSDKPluginStage r100, int r101, String r110, Integer r111, Throwable r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        Integer r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        Throwable r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
