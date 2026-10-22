package com.larus.network.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/network/config/BackgroundNetworkModeConfig;", "", "mode", "", "disconnectFrontier", "", "disablePreconnect", "clearPool", "strictGraceMs", "", "<init>", "(IZZZJ)V", "getMode", "()I", "getDisconnectFrontier", "()Z", "getDisablePreconnect", "getClearPool", "getStrictGraceMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackgroundNetworkModeConfig {
    public static final a Companion = null;
    public static final int MODE_LOOSE = 1;
    public static final int MODE_OFF = 0;
    public static final int MODE_STRICT = 2;

    @SerializedName("clear_pool")
    private final boolean clearPool;

    @SerializedName("disable_preconnect")
    private final boolean disablePreconnect;

    @SerializedName("disconnect_frontier")
    private final boolean disconnectFrontier;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("strict_grace_ms")
    private final long strictGraceMs;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BackgroundNetworkModeConfig() {
        this(0, false, false, false, 0, 31, null);
    }

    public static /* synthetic */ BackgroundNetworkModeConfig copy$default(BackgroundNetworkModeConfig r100, int r101, boolean r102, boolean r103, boolean r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.mode;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.disconnectFrontier;
    L8:
        boolean r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.disablePreconnect;
    L11:
        boolean r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.clearPool;
    L14:
        boolean r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.strictGraceMs;
    L17:
        int r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final int component1() {
        return this.mode;
    }

    public final boolean component2() {
        return this.disconnectFrontier;
    }

    public final boolean component3() {
        return this.disablePreconnect;
    }

    public final boolean component4() {
        return this.clearPool;
    }

    public final long component5() {
        return this.strictGraceMs;
    }

    public final BackgroundNetworkModeConfig copy(int r100, boolean r110, boolean r111, boolean r112, long r113) {
        return new BackgroundNetworkModeConfig(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackgroundNetworkModeConfig) == true) goto L8;
        return false;
    L8:
        BackgroundNetworkModeConfig r101 = (BackgroundNetworkModeConfig) r100;
        if (this.mode == r101.mode) goto L12;
        return false;
    L12:
        if (this.disconnectFrontier == r101.disconnectFrontier) goto L15;
        return false;
    L15:
        if (this.disablePreconnect == r101.disablePreconnect) goto L18;
        return false;
    L18:
        if (this.clearPool == r101.clearPool) goto L21;
        return false;
    L21:
        if (this.strictGraceMs == r101.strictGraceMs) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.mode * 31;
        int r101 = 1231;
        if (this.disconnectFrontier == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.disablePreconnect == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.clearPool == true) goto L14;
        r101 = 1237;
    L14:
        long r106 = this.strictGraceMs;
        return ((r105 + r101) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "BackgroundNetworkModeConfig(mode=" + this.mode + ", disconnectFrontier=" + this.disconnectFrontier + ", disablePreconnect=" + this.disablePreconnect + ", clearPool=" + this.clearPool + ", strictGraceMs=" + this.strictGraceMs + ')';
    }

    public final boolean getClearPool() {
        return this.clearPool;
    }

    public final boolean getDisablePreconnect() {
        return this.disablePreconnect;
    }

    public final boolean getDisconnectFrontier() {
        return this.disconnectFrontier;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getStrictGraceMs() {
        return this.strictGraceMs;
    }

    public BackgroundNetworkModeConfig(int r100, boolean r101, boolean r102, boolean r103, long r104) {
        this.mode = r100;
        this.disconnectFrontier = r101;
        this.disablePreconnect = r102;
        this.clearPool = r103;
        this.strictGraceMs = r104;
    }

    public /* synthetic */ BackgroundNetworkModeConfig(int r100, boolean r101, boolean r102, boolean r103, long r104, int r110, DefaultConstructorMarker r111) {
        boolean r105 = true;
        if ((r110 & 1) == 0) goto L5;
        int r112 = 1;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r106 = true;
    L11:
        if ((r110 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        r104 = 0;
    L21:
        long r108 = r104;
        this(r112, r106, r105, r107, r108);
        return;
    L17:
        r107 = r103;
        goto L19
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
