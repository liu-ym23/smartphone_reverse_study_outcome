package lq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/ContinuousTalkLeftIconConfig;", "", "enableMainBotCallIcon", "", "enableMultiBotCallIcon", "<init>", "(ZZ)V", "getEnableMainBotCallIcon", "()Z", "getEnableMultiBotCallIcon", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("enable_main_bot_continuous_speak_call_icon")
    private final boolean enableMainBotCallIcon;

    @SerializedName("enable_multi_bot_continuous_speak_call_icon")
    private final boolean enableMultiBotCallIcon;

    public l() {
        this(false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.enableMainBotCallIcon == r101.enableMainBotCallIcon) goto L12;
        return false;
    L12:
        if (this.enableMultiBotCallIcon == r101.enableMultiBotCallIcon) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableMainBotCallIcon == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMultiBotCallIcon == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContinuousTalkLeftIconConfig(enableMainBotCallIcon=" + this.enableMainBotCallIcon + ", enableMultiBotCallIcon=" + this.enableMultiBotCallIcon + ')';
    }

    public final boolean a() {
        return this.enableMainBotCallIcon;
    }

    public final boolean b() {
        return this.enableMultiBotCallIcon;
    }

    public l(boolean r100, boolean r101) {
        this.enableMainBotCallIcon = r100;
        this.enableMultiBotCallIcon = r101;
    }
}
