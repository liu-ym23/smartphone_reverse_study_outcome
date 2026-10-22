package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u009e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001e¨\u00064"}, d2 = {"Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "", "crashType", "", "threadName", "clazzName", "methodName", "throwableClassName", "detailMessage", "signalAndCodeString", "abortMessage", "stackItem", "appVersion", "updateVersion", "", "osVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCrashType", "()Ljava/lang/String;", "getThreadName", "getClazzName", "getMethodName", "getThrowableClassName", "getDetailMessage", "getSignalAndCodeString", "getAbortMessage", "getStackItem", "getAppVersion", "getUpdateVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOsVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CrashPortrait {

    @SerializedName("abort_message")
    private final String abortMessage;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("class_name")
    private final String clazzName;

    @SerializedName("crash_type")
    private final String crashType;

    @SerializedName("message")
    private final String detailMessage;

    @SerializedName("method_name")
    private final String methodName;

    @SerializedName("os_version")
    private final Integer osVersion;

    @SerializedName("signal_and_code_string")
    private final String signalAndCodeString;

    @SerializedName("stack_item")
    private final String stackItem;

    @SerializedName("thread_name")
    private final String threadName;

    @SerializedName("throwable_class_name")
    private final String throwableClassName;

    @SerializedName("update_version")
    private final Integer updateVersion;

    public CrashPortrait() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ CrashPortrait copy$default(CrashPortrait r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, Integer r214, Integer r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.crashType;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.threadName;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.clazzName;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.methodName;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.throwableClassName;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.detailMessage;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.signalAndCodeString;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.abortMessage;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.stackItem;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.appVersion;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r119 = r110.updateVersion;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Integer r108 = r110.osVersion;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.crashType;
    }

    public final String component10() {
        return this.appVersion;
    }

    public final Integer component11() {
        return this.updateVersion;
    }

    public final Integer component12() {
        return this.osVersion;
    }

    public final String component2() {
        return this.threadName;
    }

    public final String component3() {
        return this.clazzName;
    }

    public final String component4() {
        return this.methodName;
    }

    public final String component5() {
        return this.throwableClassName;
    }

    public final String component6() {
        return this.detailMessage;
    }

    public final String component7() {
        return this.signalAndCodeString;
    }

    public final String component8() {
        return this.abortMessage;
    }

    public final String component9() {
        return this.stackItem;
    }

    public final CrashPortrait copy(String r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, Integer r215, Integer r216) {
        return new CrashPortrait(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CrashPortrait) == true) goto L8;
        return false;
    L8:
        CrashPortrait r101 = (CrashPortrait) r100;
        if (Intrinsics.areEqual(this.crashType, r101.crashType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadName, r101.threadName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clazzName, r101.clazzName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.methodName, r101.methodName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.throwableClassName, r101.throwableClassName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.detailMessage, r101.detailMessage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.signalAndCodeString, r101.signalAndCodeString) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.abortMessage, r101.abortMessage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.stackItem, r101.stackItem) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.updateVersion, r101.updateVersion) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.osVersion, r101.osVersion) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.crashType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.threadName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.clazzName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.methodName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.throwableClassName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.detailMessage;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.signalAndCodeString;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.abortMessage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.stackItem;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.appVersion;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.updateVersion;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.osVersion;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CrashPortrait(crashType=" + this.crashType + ", threadName=" + this.threadName + ", clazzName=" + this.clazzName + ", methodName=" + this.methodName + ", throwableClassName=" + this.throwableClassName + ", detailMessage=" + this.detailMessage + ", signalAndCodeString=" + this.signalAndCodeString + ", abortMessage=" + this.abortMessage + ", stackItem=" + this.stackItem + ", appVersion=" + this.appVersion + ", updateVersion=" + this.updateVersion + ", osVersion=" + this.osVersion + ')';
    }

    public final String getAbortMessage() {
        return this.abortMessage;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getClazzName() {
        return this.clazzName;
    }

    public final String getCrashType() {
        return this.crashType;
    }

    public final String getDetailMessage() {
        return this.detailMessage;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Integer getOsVersion() {
        return this.osVersion;
    }

    public final String getSignalAndCodeString() {
        return this.signalAndCodeString;
    }

    public final String getStackItem() {
        return this.stackItem;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public final String getThrowableClassName() {
        return this.throwableClassName;
    }

    public final Integer getUpdateVersion() {
        return this.updateVersion;
    }

    public CrashPortrait(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, Integer r111, Integer r112) {
        this.crashType = r100;
        this.threadName = r101;
        this.clazzName = r102;
        this.methodName = r103;
        this.throwableClassName = r104;
        this.detailMessage = r105;
        this.signalAndCodeString = r106;
        this.abortMessage = r107;
        this.stackItem = r108;
        this.appVersion = r110;
        this.updateVersion = r111;
        this.osVersion = r112;
    }

    public /* synthetic */ CrashPortrait(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, Integer r214, Integer r215, int r216, DefaultConstructorMarker r217) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = "";
    L39:
        if ((r216 & 512) != 0) goto L43;
        r100 = r213;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r117 = 0;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Integer r109 = 0;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r100, r117, r109);
        return;
    L49:
        r109 = r215;
        goto L50
    L45:
        r117 = r214;
        goto L47
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
