package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00062"}, d2 = {"Lcom/larus/settings/provider/InputAnrOptStrategyConfig;", "", "anrBombDisposalEnable", "", "otherTimeoutMs", "", "startTimeoutMs", "priority", "getFdRetry", "enableInputStuckOpt", "enableHighFrequentMessageOpt", "messageCountThreshold", "checkIntervalMs", "enableTimeoutResend", "enableJavaStuckOpt", "otherOpt", "<init>", "(ZIIIZZZIIZZZ)V", "getAnrBombDisposalEnable", "()Z", "getOtherTimeoutMs", "()I", "getStartTimeoutMs", "getPriority", "getGetFdRetry", "getEnableInputStuckOpt", "getEnableHighFrequentMessageOpt", "getMessageCountThreshold", "getCheckIntervalMs", "getEnableTimeoutResend", "getEnableJavaStuckOpt", "getOtherOpt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z1 {

    @SerializedName("anrBombDisposalenable")
    private final boolean anrBombDisposalEnable;

    @SerializedName("checkIntervalMs")
    private final int checkIntervalMs;

    @SerializedName("enableHighFrequentMessageOpt")
    private final boolean enableHighFrequentMessageOpt;

    @SerializedName("enableInputStuckOpt")
    private final boolean enableInputStuckOpt;

    @SerializedName("enableJavaStuckOpt")
    private final boolean enableJavaStuckOpt;

    @SerializedName("enableTimeoutResend")
    private final boolean enableTimeoutResend;

    @SerializedName("getFdRetry")
    private final boolean getFdRetry;

    @SerializedName("messageCountThreshold")
    private final int messageCountThreshold;

    @SerializedName("otherOpt")
    private final boolean otherOpt;

    @SerializedName("otherTimeoutMs")
    private final int otherTimeoutMs;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("startTimeoutMs")
    private final int startTimeoutMs;

    public z1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (this.anrBombDisposalEnable == r101.anrBombDisposalEnable) goto L12;
        return false;
    L12:
        if (this.otherTimeoutMs == r101.otherTimeoutMs) goto L15;
        return false;
    L15:
        if (this.startTimeoutMs == r101.startTimeoutMs) goto L18;
        return false;
    L18:
        if (this.priority == r101.priority) goto L21;
        return false;
    L21:
        if (this.getFdRetry == r101.getFdRetry) goto L24;
        return false;
    L24:
        if (this.enableInputStuckOpt == r101.enableInputStuckOpt) goto L27;
        return false;
    L27:
        if (this.enableHighFrequentMessageOpt == r101.enableHighFrequentMessageOpt) goto L30;
        return false;
    L30:
        if (this.messageCountThreshold == r101.messageCountThreshold) goto L33;
        return false;
    L33:
        if (this.checkIntervalMs == r101.checkIntervalMs) goto L36;
        return false;
    L36:
        if (this.enableTimeoutResend == r101.enableTimeoutResend) goto L39;
        return false;
    L39:
        if (this.enableJavaStuckOpt == r101.enableJavaStuckOpt) goto L42;
        return false;
    L42:
        if (this.otherOpt == r101.otherOpt) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.anrBombDisposalEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((r101 * 31) + this.otherTimeoutMs) * 31) + this.startTimeoutMs) * 31) + this.priority) * 31;
        if (this.getFdRetry == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableInputStuckOpt == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableHighFrequentMessageOpt == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((((r106 + r107) * 31) + this.messageCountThreshold) * 31) + this.checkIntervalMs) * 31;
        if (this.enableTimeoutResend == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.enableJavaStuckOpt == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.otherOpt == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputAnrOptStrategyConfig(anrBombDisposalEnable=" + this.anrBombDisposalEnable + ", otherTimeoutMs=" + this.otherTimeoutMs + ", startTimeoutMs=" + this.startTimeoutMs + ", priority=" + this.priority + ", getFdRetry=" + this.getFdRetry + ", enableInputStuckOpt=" + this.enableInputStuckOpt + ", enableHighFrequentMessageOpt=" + this.enableHighFrequentMessageOpt + ", messageCountThreshold=" + this.messageCountThreshold + ", checkIntervalMs=" + this.checkIntervalMs + ", enableTimeoutResend=" + this.enableTimeoutResend + ", enableJavaStuckOpt=" + this.enableJavaStuckOpt + ", otherOpt=" + this.otherOpt + ')';
    }

    public final boolean a() {
        return this.anrBombDisposalEnable;
    }

    public final int b() {
        return this.checkIntervalMs;
    }

    public final boolean c() {
        return this.enableHighFrequentMessageOpt;
    }

    public final boolean d() {
        return this.enableInputStuckOpt;
    }

    public final boolean e() {
        return this.enableJavaStuckOpt;
    }

    public final boolean f() {
        return this.enableTimeoutResend;
    }

    public final boolean g() {
        return this.getFdRetry;
    }

    public final int h() {
        return this.messageCountThreshold;
    }

    public final int i() {
        return this.otherTimeoutMs;
    }

    public final int j() {
        return this.priority;
    }

    public final int k() {
        return this.startTimeoutMs;
    }

    public z1(int r100) {
        this.anrBombDisposalEnable = false;
        this.otherTimeoutMs = 2000;
        this.startTimeoutMs = 2000;
        this.priority = 0;
        this.getFdRetry = true;
        this.enableInputStuckOpt = false;
        this.enableHighFrequentMessageOpt = false;
        this.messageCountThreshold = 0;
        this.checkIntervalMs = 0;
        this.enableTimeoutResend = false;
        this.enableJavaStuckOpt = false;
        this.otherOpt = false;
    }
}
