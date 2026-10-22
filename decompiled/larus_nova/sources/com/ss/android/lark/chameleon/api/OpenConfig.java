package com.ss.android.lark.chameleon.api;

import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\b\u00101\u001a\u000202H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/ss/android/lark/chameleon/api/OpenConfig;", "Ljava/io/Serializable;", "titlebarConfig", "Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", DyPayConstant.KEY_SHOW_LOADING, "", "hideLoadingByJS", "statisticsByJS", "loadingTimeout", "", "isColdLaunch", "openTimestamp", "hitWebViewCache", "(Lcom/ss/android/lark/chameleon/api/TitlebarConfig;ZZZJZJZ)V", "getHideLoadingByJS", "()Z", "setHideLoadingByJS", "(Z)V", "getHitWebViewCache", "setHitWebViewCache", "setColdLaunch", "getLoadingTimeout", "()J", "setLoadingTimeout", "(J)V", "getOpenTimestamp", "setOpenTimestamp", "getShowLoading", "setShowLoading", "getStatisticsByJS", "setStatisticsByJS", "getTitlebarConfig", "()Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", "setTitlebarConfig", "(Lcom/ss/android/lark/chameleon/api/TitlebarConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OpenConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_LOADING_TIMEOUT = 10000;
    private boolean hideLoadingByJS;
    private boolean hitWebViewCache;
    private boolean isColdLaunch;
    private long loadingTimeout;
    private long openTimestamp;
    private boolean showLoading;
    private boolean statisticsByJS;
    private TitlebarConfig titlebarConfig;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/OpenConfig$Companion;", "", "()V", "DEFAULT_LOADING_TIMEOUT", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OpenConfig() {
        this(null, false, false, false, 0, false, 0, false, 255, null);
    }

    public static /* synthetic */ OpenConfig copy$default(OpenConfig r110, TitlebarConfig r111, boolean r112, boolean r113, boolean r114, long r115, boolean r116, long r117, boolean r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        TitlebarConfig r100 = r110.titlebarConfig;
    L7:
        if ((r211 & 2) == 0) goto L9;
        boolean r101 = r110.showLoading;
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r102 = r110.hideLoadingByJS;
    L15:
        if ((r211 & 8) == 0) goto L17;
        boolean r103 = r110.statisticsByJS;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r104 = r110.loadingTimeout;
    L23:
        if ((r211 & 32) == 0) goto L25;
        boolean r105 = r110.isColdLaunch;
    L27:
        if ((r211 & 64) == 0) goto L29;
        long r106 = r110.openTimestamp;
    L31:
        if ((r211 & 128) == 0) goto L33;
        boolean r107 = r110.hitWebViewCache;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
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

    public final TitlebarConfig component1() {
        return this.titlebarConfig;
    }

    public final boolean component2() {
        return this.showLoading;
    }

    public final boolean component3() {
        return this.hideLoadingByJS;
    }

    public final boolean component4() {
        return this.statisticsByJS;
    }

    public final long component5() {
        return this.loadingTimeout;
    }

    public final boolean component6() {
        return this.isColdLaunch;
    }

    public final long component7() {
        return this.openTimestamp;
    }

    public final boolean component8() {
        return this.hitWebViewCache;
    }

    public final OpenConfig copy(TitlebarConfig r110, boolean r111, boolean r112, boolean r113, long r114, boolean r115, long r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "titlebarConfig");
        return new OpenConfig(r110, r111, r112, r113, r114, r115, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenConfig) == true) goto L8;
        return false;
    L8:
        OpenConfig r101 = (OpenConfig) r100;
        if (Intrinsics.areEqual(this.titlebarConfig, r101.titlebarConfig) == true) goto L12;
        return false;
    L12:
        if (this.showLoading == r101.showLoading) goto L15;
        return false;
    L15:
        if (this.hideLoadingByJS == r101.hideLoadingByJS) goto L18;
        return false;
    L18:
        if (this.statisticsByJS == r101.statisticsByJS) goto L21;
        return false;
    L21:
        if (this.loadingTimeout == r101.loadingTimeout) goto L24;
        return false;
    L24:
        if (this.isColdLaunch == r101.isColdLaunch) goto L27;
        return false;
    L27:
        if (this.openTimestamp == r101.openTimestamp) goto L30;
        return false;
    L30:
        if (this.hitWebViewCache == r101.hitWebViewCache) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public int hashCode() {
        int r100 = this.titlebarConfig.hashCode() * 31;
        boolean r101 = this.showLoading;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.hideLoadingByJS;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.statisticsByJS;
        ?? r109 = r108;
        if (r108 == false) goto L11;
        r109 = 1;
    L11:
        long r110 = this.loadingTimeout;
        int r111 = (((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        boolean r112 = this.isColdLaunch;
        ?? r113 = r112;
        if (r112 == false) goto L14;
        r113 = 1;
    L14:
        int r114 = (r111 + r113) * 31;
        long r115 = this.openTimestamp;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        boolean r117 = this.hitWebViewCache;
        if (r117 == true) goto L19;
        r102 = r117;
    L19:
        return r116 + r102;
    }

    public String toString() {
        return "OpenConfig(titlebarConfig=" + this.titlebarConfig + ", showLoading=" + this.showLoading + ", hideLoadingByJS=" + this.hideLoadingByJS + ", loadingTimeout=" + this.loadingTimeout + ')';
    }

    public final boolean getHideLoadingByJS() {
        return this.hideLoadingByJS;
    }

    public final boolean getHitWebViewCache() {
        return this.hitWebViewCache;
    }

    public final long getLoadingTimeout() {
        return this.loadingTimeout;
    }

    public final long getOpenTimestamp() {
        return this.openTimestamp;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getStatisticsByJS() {
        return this.statisticsByJS;
    }

    public final TitlebarConfig getTitlebarConfig() {
        return this.titlebarConfig;
    }

    public final boolean isColdLaunch() {
        return this.isColdLaunch;
    }

    public final void setColdLaunch(boolean r100) {
        this.isColdLaunch = r100;
    }

    public final void setHideLoadingByJS(boolean r100) {
        this.hideLoadingByJS = r100;
    }

    public final void setHitWebViewCache(boolean r100) {
        this.hitWebViewCache = r100;
    }

    public final void setLoadingTimeout(long r100) {
        this.loadingTimeout = r100;
    }

    public final void setOpenTimestamp(long r100) {
        this.openTimestamp = r100;
    }

    public final void setShowLoading(boolean r100) {
        this.showLoading = r100;
    }

    public final void setStatisticsByJS(boolean r100) {
        this.statisticsByJS = r100;
    }

    public final void setTitlebarConfig(TitlebarConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.titlebarConfig = r100;
    }

    public OpenConfig(TitlebarConfig r100, boolean r101, boolean r102, boolean r103, long r104, boolean r105, long r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "titlebarConfig");
        this.titlebarConfig = r100;
        this.showLoading = r101;
        this.hideLoadingByJS = r102;
        this.statisticsByJS = r103;
        this.loadingTimeout = r104;
        this.isColdLaunch = r105;
        this.openTimestamp = r106;
        this.hitWebViewCache = r110;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ OpenConfig(TitlebarConfig r110, boolean r111, boolean r112, boolean r113, long r114, boolean r115, long r116, boolean r210, int r211, DefaultConstructorMarker r212) {
        boolean r100 = true;
        if ((r211 & 1) == 0) goto L5;
        TitlebarConfig r101 = new TitlebarConfig(r100, null, 2, 0 == true ? 1 : 0);
    L6:
        boolean r102 = false;
        if ((r211 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r211 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r105 = 10000;
    L23:
        if ((r211 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r211 & 64) == 0) goto L29;
        long r107 = System.currentTimeMillis();
    L31:
        if ((r211 & 128) != 0) goto L34;
        r100 = r210;
    L34:
        this(r101, r103, r104, r102, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
