package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/LarkMixedFeedConfig;", "", "useMigrationFinished", "", "redDotIgnoreMessage", "disablePresetBotReq", "enableEmptyCellCollapse", "recentLoadedCacheLruSize", "", "<init>", "(ZZZZI)V", "getUseMigrationFinished", "()Z", "getRedDotIgnoreMessage", "getDisablePresetBotReq", "getEnableEmptyCellCollapse", "getRecentLoadedCacheLruSize", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i2 {

    @SerializedName("disable_preset_bot_req")
    private final boolean disablePresetBotReq;

    @SerializedName("enable_empty_cell_collapse")
    private final boolean enableEmptyCellCollapse;

    @SerializedName("recent_loaded_cache_lru_size")
    private final int recentLoadedCacheLruSize;

    @SerializedName("red_dot_ignore_message")
    private final boolean redDotIgnoreMessage;

    @SerializedName("use_migration_finished")
    private final boolean useMigrationFinished;

    public i2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i2) == true) goto L8;
        return false;
    L8:
        i2 r101 = (i2) r100;
        if (this.useMigrationFinished == r101.useMigrationFinished) goto L12;
        return false;
    L12:
        if (this.redDotIgnoreMessage == r101.redDotIgnoreMessage) goto L15;
        return false;
    L15:
        if (this.disablePresetBotReq == r101.disablePresetBotReq) goto L18;
        return false;
    L18:
        if (this.enableEmptyCellCollapse == r101.enableEmptyCellCollapse) goto L21;
        return false;
    L21:
        if (this.recentLoadedCacheLruSize == r101.recentLoadedCacheLruSize) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.useMigrationFinished == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.redDotIgnoreMessage == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.disablePresetBotReq == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableEmptyCellCollapse == true) goto L19;
        r100 = 1237;
    L19:
        return ((r106 + r100) * 31) + this.recentLoadedCacheLruSize;
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
        return "LarkMixedFeedConfig(useMigrationFinished=" + this.useMigrationFinished + ", redDotIgnoreMessage=" + this.redDotIgnoreMessage + ", disablePresetBotReq=" + this.disablePresetBotReq + ", enableEmptyCellCollapse=" + this.enableEmptyCellCollapse + ", recentLoadedCacheLruSize=" + this.recentLoadedCacheLruSize + ')';
    }

    public final boolean a() {
        return this.disablePresetBotReq;
    }

    public final boolean b() {
        return this.enableEmptyCellCollapse;
    }

    public final int c() {
        return this.recentLoadedCacheLruSize;
    }

    public final boolean d() {
        return this.redDotIgnoreMessage;
    }

    public final boolean e() {
        return this.useMigrationFinished;
    }

    public i2(int r100) {
        this.useMigrationFinished = true;
        this.redDotIgnoreMessage = true;
        this.disablePresetBotReq = true;
        this.enableEmptyCellCollapse = false;
        this.recentLoadedCacheLruSize = 512;
    }
}
