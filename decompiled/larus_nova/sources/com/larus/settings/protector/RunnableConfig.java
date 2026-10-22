package com.larus.settings.protector;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/protector/RunnableConfig;", "", "exceptionType", "", "exceptionMessage", "stackClassName", "stackMethodName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExceptionType", "()Ljava/lang/String;", "getExceptionMessage", "getStackClassName", "getStackMethodName", "isValid", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RunnableConfig {

    @SerializedName("exceptionMessage")
    private final String exceptionMessage;

    @SerializedName("exceptionType")
    private final String exceptionType;

    @SerializedName("stackClassName")
    private final String stackClassName;

    @SerializedName("stackMethodName")
    private final String stackMethodName;

    public RunnableConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RunnableConfig copy$default(RunnableConfig r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.exceptionType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.exceptionMessage;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.stackClassName;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.stackMethodName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.exceptionType;
    }

    public final String component2() {
        return this.exceptionMessage;
    }

    public final String component3() {
        return this.stackClassName;
    }

    public final String component4() {
        return this.stackMethodName;
    }

    public final RunnableConfig copy(String r100, String r101, String r102, String r103) {
        return new RunnableConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RunnableConfig) == true) goto L8;
        return false;
    L8:
        RunnableConfig r101 = (RunnableConfig) r100;
        if (Intrinsics.areEqual(this.exceptionType, r101.exceptionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exceptionMessage, r101.exceptionMessage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stackClassName, r101.stackClassName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.stackMethodName, r101.stackMethodName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.exceptionType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.exceptionMessage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.stackClassName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.stackMethodName;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RunnableConfig(exceptionType=" + this.exceptionType + ", exceptionMessage=" + this.exceptionMessage + ", stackClassName=" + this.stackClassName + ", stackMethodName=" + this.stackMethodName + ')';
    }

    public final boolean isValid() {
        String r100 = this.exceptionType;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L36;
        String r102 = this.exceptionMessage;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L37;
        String r104 = this.stackClassName;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == true) goto L38;
        String r106 = this.stackMethodName;
        if (r106 != null) goto L29;
    L32:
        boolean r107 = true;
    L33:
        if (r107 == true) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (r106.length() == 0) goto L32;
        r107 = false;
        goto L33
    L38:
        return false;
    L21:
        if (r104.length() == 0) goto L24;
        r105 = false;
        goto L25
    L37:
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L36:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public final String getExceptionType() {
        return this.exceptionType;
    }

    public final String getStackClassName() {
        return this.stackClassName;
    }

    public final String getStackMethodName() {
        return this.stackMethodName;
    }

    public RunnableConfig(String r100, String r101, String r102, String r103) {
        this.exceptionType = r100;
        this.exceptionMessage = r101;
        this.stackClassName = r102;
        this.stackMethodName = r103;
    }

    public /* synthetic */ RunnableConfig(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
