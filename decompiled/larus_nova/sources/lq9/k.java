package lq9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "", "enableContinueTalkV2", "", "enableMainBotEntranceIntercept", "enableUgcBotEntranceIntercept", "enableEnterCallByAsrSlide", "enableToggleContinueTalkTts", "enablePseudoConnected", "<init>", "(ZZZZZZ)V", "getEnableContinueTalkV2", "()Z", "getEnableMainBotEntranceIntercept", "getEnableUgcBotEntranceIntercept", "getEnableEnterCallByAsrSlide", "getEnableToggleContinueTalkTts", "getEnablePseudoConnected", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("enable_continue_talk")
    private final boolean enableContinueTalkV2;

    @SerializedName("enable_enter_call_by_asr_slide")
    private final boolean enableEnterCallByAsrSlide;

    @SerializedName("enable_main_bot_entrance_intercept")
    private final boolean enableMainBotEntranceIntercept;

    @SerializedName("enable_pseudo_connected")
    private final boolean enablePseudoConnected;

    @SerializedName("enable_toggle_continue_talk_tts")
    private final boolean enableToggleContinueTalkTts;

    @SerializedName("enable_ugc_bot_entrance_intercept")
    private final boolean enableUgcBotEntranceIntercept;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.enableContinueTalkV2 == r101.enableContinueTalkV2) goto L12;
        return false;
    L12:
        if (this.enableMainBotEntranceIntercept == r101.enableMainBotEntranceIntercept) goto L15;
        return false;
    L15:
        if (this.enableUgcBotEntranceIntercept == r101.enableUgcBotEntranceIntercept) goto L18;
        return false;
    L18:
        if (this.enableEnterCallByAsrSlide == r101.enableEnterCallByAsrSlide) goto L21;
        return false;
    L21:
        if (this.enableToggleContinueTalkTts == r101.enableToggleContinueTalkTts) goto L24;
        return false;
    L24:
        if (this.enablePseudoConnected == r101.enablePseudoConnected) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableContinueTalkV2 == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMainBotEntranceIntercept == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableUgcBotEntranceIntercept == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableEnterCallByAsrSlide == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableToggleContinueTalkTts == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.enablePseudoConnected == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
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
        return "ContinueTalkV2Config(enableContinueTalkV2=" + this.enableContinueTalkV2 + ", enableMainBotEntranceIntercept=" + this.enableMainBotEntranceIntercept + ", enableUgcBotEntranceIntercept=" + this.enableUgcBotEntranceIntercept + ", enableEnterCallByAsrSlide=" + this.enableEnterCallByAsrSlide + ", enableToggleContinueTalkTts=" + this.enableToggleContinueTalkTts + ", enablePseudoConnected=" + this.enablePseudoConnected + ')';
    }

    public final boolean a() {
        return this.enableContinueTalkV2;
    }

    public final boolean b() {
        return this.enableEnterCallByAsrSlide;
    }

    public final boolean c() {
        return this.enableMainBotEntranceIntercept;
    }

    public final boolean d() {
        return this.enablePseudoConnected;
    }

    public final boolean e() {
        return this.enableToggleContinueTalkTts;
    }

    public final boolean f() {
        return this.enableUgcBotEntranceIntercept;
    }

    public k(int r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        boolean r102 = r101.isDebug();
        boolean r103 = r101.isDebug();
        this.enableContinueTalkV2 = r102;
        this.enableMainBotEntranceIntercept = r103;
        this.enableUgcBotEntranceIntercept = false;
        this.enableEnterCallByAsrSlide = false;
        this.enableToggleContinueTalkTts = false;
        this.enablePseudoConnected = false;
    }
}
