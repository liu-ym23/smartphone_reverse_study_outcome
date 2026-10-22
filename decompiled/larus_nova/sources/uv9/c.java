package uv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010#J\u0098\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lcom/larus/settings/provider/publishtest/PublishTestSupportConfig;", "", "crashType", "", "crashStack", "testTriggerDelay", "", "testTriggerProbability", "", "testTriggerRange", "crashMsg", "logType", "appLogEvent", "apmEvent", "apmEventKV", "drillPath", "syncWithException", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCrashType", "()Ljava/lang/String;", "getCrashStack", "getTestTriggerDelay", "()J", "getTestTriggerProbability", "()I", "getTestTriggerRange", "getCrashMsg", "getLogType", "getAppLogEvent", "getApmEvent", "getApmEventKV", "getDrillPath", "getSyncWithException", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/settings/provider/publishtest/PublishTestSupportConfig;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("apmEvent")
    private final String apmEvent;

    @SerializedName("apmEventKV")
    private final String apmEventKV;

    @SerializedName("appLogEvent")
    private final String appLogEvent;

    @SerializedName("crashMsg")
    private final String crashMsg;

    @SerializedName("crashStack")
    private final String crashStack;

    @SerializedName("crashType")
    private final String crashType;

    @SerializedName("drillPath")
    private final String drillPath;

    @SerializedName("logType")
    private final String logType;

    @SerializedName("syncWithException")
    private final Boolean syncWithException;

    @SerializedName("testTriggerDelay")
    private final long testTriggerDelay;

    @SerializedName("testTriggerProbability")
    private final int testTriggerProbability;

    @SerializedName("testTriggerRange")
    private final int testTriggerRange;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.crashType, r101.crashType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.crashStack, r101.crashStack) == true) goto L15;
        return false;
    L15:
        if (this.testTriggerDelay == r101.testTriggerDelay) goto L18;
        return false;
    L18:
        if (this.testTriggerProbability == r101.testTriggerProbability) goto L21;
        return false;
    L21:
        if (this.testTriggerRange == r101.testTriggerRange) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.crashMsg, r101.crashMsg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.logType, r101.logType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appLogEvent, r101.appLogEvent) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.apmEvent, r101.apmEvent) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.apmEventKV, r101.apmEventKV) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.drillPath, r101.drillPath) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.syncWithException, r101.syncWithException) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.crashType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.crashStack;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.testTriggerDelay;
        int r108 = (((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.testTriggerProbability) * 31) + this.testTriggerRange) * 31;
        String r109 = this.crashMsg;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.logType;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.appLogEvent;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.apmEvent;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.apmEventKV;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.drillPath;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        Boolean r127 = this.syncWithException;
        if (r127 == null) goto L39;
        r101 = r127.hashCode();
    L39:
        return r126 + r101;
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishTestSupportConfig(crashType=" + this.crashType + ", crashStack=" + this.crashStack + ", testTriggerDelay=" + this.testTriggerDelay + ", testTriggerProbability=" + this.testTriggerProbability + ", testTriggerRange=" + this.testTriggerRange + ", crashMsg=" + this.crashMsg + ", logType=" + this.logType + ", appLogEvent=" + this.appLogEvent + ", apmEvent=" + this.apmEvent + ", apmEventKV=" + this.apmEventKV + ", drillPath=" + this.drillPath + ", syncWithException=" + this.syncWithException + ')';
    }

    public final String b() {
        return this.apmEvent;
    }

    public final String c() {
        return this.apmEventKV;
    }

    public final String d() {
        return this.appLogEvent;
    }

    public final String e() {
        return this.crashMsg;
    }

    public final String f() {
        return this.crashStack;
    }

    public final String g() {
        return this.crashType;
    }

    public final String h() {
        return this.drillPath;
    }

    public final String i() {
        return this.logType;
    }

    public final Boolean j() {
        return this.syncWithException;
    }

    public final long k() {
        return this.testTriggerDelay;
    }

    public final int l() {
        return this.testTriggerProbability;
    }

    public final int m() {
        return this.testTriggerRange;
    }

    public /* synthetic */ c(int r110) {
        this("java", "", -1, 0, 0, "PUBLISH_FUSED_TEST_EXCEPTION", "LOG_TYPE_PUBLISH_FUSED_TEST", "", "", "", "", Boolean.TRUE);
    }

    public static c a(c r110, int r111, String r210, int r211) {
        Boolean r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = r110.crashType;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r102 = r110.crashStack;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r103 = r110.testTriggerDelay;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r104 = r110.testTriggerProbability;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r112 = r110.testTriggerRange;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r113 = r110.crashMsg;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r114 = r110.logType;
    L31:
        if ((r211 & 128) == 0) goto L33;
        String r115 = r110.appLogEvent;
    L35:
        if ((r211 & 256) == 0) goto L37;
        String r116 = r110.apmEvent;
    L39:
        if ((r211 & 512) == 0) goto L41;
        String r117 = r110.apmEventKV;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        String r118 = r110.drillPath;
    L47:
        if ((r211 & 2048) == 0) goto L50;
        r100 = r110.syncWithException;
    L50:
        return new c(r101, r102, r103, r104, r112, r113, r114, r115, r116, r117, r118, r100);
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = r210;
        goto L27
    L21:
        r112 = r111;
        goto L23
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = 0;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public c(String r100, String r101, long r102, int r103, int r104, String r105, String r106, String r107, String r110, String r111, String r112, Boolean r113) {
        this.crashType = r100;
        this.crashStack = r101;
        this.testTriggerDelay = r102;
        this.testTriggerProbability = r103;
        this.testTriggerRange = r104;
        this.crashMsg = r105;
        this.logType = r106;
        this.appLogEvent = r107;
        this.apmEvent = r110;
        this.apmEventKV = r111;
        this.drillPath = r112;
        this.syncWithException = r113;
    }
}
