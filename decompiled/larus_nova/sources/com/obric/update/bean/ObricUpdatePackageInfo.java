package com.obric.update.bean;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010HÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010HÆ\u0003J\u0092\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#¨\u00065"}, d2 = {"Lcom/obric/update/bean/ObricUpdatePackageInfo;", "", "needUpdate", "", "availablePackage", "", "", "availableScene", "Lcom/obric/update/bean/ObricUpdateAvailableScene;", "totalSize", "", "versionName", "checkUpdateResultBundleForAgent", "Landroid/os/Bundle;", "checkUpdateResultBundleForDoubao", "bundleExt", "", "ext", "<init>", "(ZLjava/util/List;Lcom/obric/update/bean/ObricUpdateAvailableScene;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/util/Map;Ljava/util/Map;)V", "getNeedUpdate", "()Z", "getAvailablePackage", "()Ljava/util/List;", "getAvailableScene", "()Lcom/obric/update/bean/ObricUpdateAvailableScene;", "getTotalSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVersionName", "()Ljava/lang/String;", "getCheckUpdateResultBundleForAgent", "()Landroid/os/Bundle;", "getCheckUpdateResultBundleForDoubao", "getBundleExt", "()Ljava/util/Map;", "getExt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/util/List;Lcom/obric/update/bean/ObricUpdateAvailableScene;Ljava/lang/Long;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/util/Map;Ljava/util/Map;)Lcom/obric/update/bean/ObricUpdatePackageInfo;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdatePackageInfo {
    private final List<String> availablePackage;
    private final ObricUpdateAvailableScene availableScene;
    private final Map<String, Object> bundleExt;
    private final Bundle checkUpdateResultBundleForAgent;
    private final Bundle checkUpdateResultBundleForDoubao;
    private final Map<String, Object> ext;
    private final boolean needUpdate;
    private final Long totalSize;
    private final String versionName;

    public ObricUpdatePackageInfo() {
        this(false, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricUpdatePackageInfo copy$default(ObricUpdatePackageInfo r110, boolean r111, List r112, ObricUpdateAvailableScene r113, Long r114, String r115, Bundle r116, Bundle r117, Map r118, Map r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.needUpdate;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r101 = r110.availablePackage;
    L11:
        if ((r210 & 4) == 0) goto L13;
        ObricUpdateAvailableScene r102 = r110.availableScene;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Long r103 = r110.totalSize;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.versionName;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Bundle r105 = r110.checkUpdateResultBundleForAgent;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Bundle r106 = r110.checkUpdateResultBundleForDoubao;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.bundleExt;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Map r108 = r110.ext;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
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

    public final boolean component1() {
        return this.needUpdate;
    }

    public final List<String> component2() {
        return this.availablePackage;
    }

    public final ObricUpdateAvailableScene component3() {
        return this.availableScene;
    }

    public final Long component4() {
        return this.totalSize;
    }

    public final String component5() {
        return this.versionName;
    }

    public final Bundle component6() {
        return this.checkUpdateResultBundleForAgent;
    }

    public final Bundle component7() {
        return this.checkUpdateResultBundleForDoubao;
    }

    public final Map<String, Object> component8() {
        return this.bundleExt;
    }

    public final Map<String, Object> component9() {
        return this.ext;
    }

    public final ObricUpdatePackageInfo copy(boolean r110, List<String> r111, ObricUpdateAvailableScene r112, Long r113, String r114, Bundle r115, Bundle r116, Map<String, ? extends Object> r117, Map<String, ? extends Object> r210) {
        Intrinsics.checkNotNullParameter(r112, "availableScene");
        Intrinsics.checkNotNullParameter(r117, "bundleExt");
        Intrinsics.checkNotNullParameter(r210, "ext");
        return new ObricUpdatePackageInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricUpdatePackageInfo) == true) goto L8;
        return false;
    L8:
        ObricUpdatePackageInfo r101 = (ObricUpdatePackageInfo) r100;
        if (this.needUpdate == r101.needUpdate) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.availablePackage, r101.availablePackage) == true) goto L15;
        return false;
    L15:
        if (this.availableScene == r101.availableScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.totalSize, r101.totalSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.versionName, r101.versionName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.checkUpdateResultBundleForAgent, r101.checkUpdateResultBundleForAgent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.checkUpdateResultBundleForDoubao, r101.checkUpdateResultBundleForDoubao) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bundleExt, r101.bundleExt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        if (this.needUpdate == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.availablePackage;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((r101 + r104) * 31) + this.availableScene.hashCode()) * 31;
        Long r106 = this.totalSize;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.versionName;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Bundle r112 = this.checkUpdateResultBundleForAgent;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Bundle r115 = this.checkUpdateResultBundleForDoubao;
        if (r115 == null) goto L27;
        r103 = r115.hashCode();
    L27:
        return ((((r114 + r103) * 31) + this.bundleExt.hashCode()) * 31) + this.ext.hashCode();
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricUpdatePackageInfo(needUpdate=" + this.needUpdate + ", availablePackage=" + this.availablePackage + ", availableScene=" + this.availableScene + ", totalSize=" + this.totalSize + ", versionName=" + this.versionName + ", checkUpdateResultBundleForAgent=" + this.checkUpdateResultBundleForAgent + ", checkUpdateResultBundleForDoubao=" + this.checkUpdateResultBundleForDoubao + ", bundleExt=" + this.bundleExt + ", ext=" + this.ext + ')';
    }

    public final List<String> getAvailablePackage() {
        return this.availablePackage;
    }

    public final ObricUpdateAvailableScene getAvailableScene() {
        return this.availableScene;
    }

    public final Map<String, Object> getBundleExt() {
        return this.bundleExt;
    }

    public final Bundle getCheckUpdateResultBundleForAgent() {
        return this.checkUpdateResultBundleForAgent;
    }

    public final Bundle getCheckUpdateResultBundleForDoubao() {
        return this.checkUpdateResultBundleForDoubao;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final Long getTotalSize() {
        return this.totalSize;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public ObricUpdatePackageInfo(boolean r100, List<String> r101, ObricUpdateAvailableScene r102, Long r103, String r104, Bundle r105, Bundle r106, Map<String, ? extends Object> r107, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r102, "availableScene");
        Intrinsics.checkNotNullParameter(r107, "bundleExt");
        Intrinsics.checkNotNullParameter(r110, "ext");
        this.needUpdate = r100;
        this.availablePackage = r101;
        this.availableScene = r102;
        this.totalSize = r103;
        this.versionName = r104;
        this.checkUpdateResultBundleForAgent = r105;
        this.checkUpdateResultBundleForDoubao = r106;
        this.bundleExt = r107;
        this.ext = r110;
    }

    public /* synthetic */ ObricUpdatePackageInfo(boolean r110, List r111, ObricUpdateAvailableScene r112, Long r113, String r114, Bundle r115, Bundle r116, Map r117, Map r118, int r119, DefaultConstructorMarker r210) {
        if ((r119 & 1) == 0) goto L5;
        boolean r100 = false;
    L6:
        Bundle r101 = null;
        if ((r119 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r119 & 4) == 0) goto L13;
        ObricUpdateAvailableScene r103 = ObricUpdateAvailableScene.NONE;
    L15:
        if ((r119 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r119 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r119 & 32) == 0) goto L25;
        Bundle r106 = null;
    L27:
        if ((r119 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r119 & 128) == 0) goto L33;
        Map r107 = MapsKt.emptyMap();
    L35:
        if ((r119 & 256) == 0) goto L37;
        Map r108 = MapsKt.emptyMap();
    L38:
        this(r100, r102, r103, r104, r105, r106, r101, r107, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L33:
        r107 = r117;
        goto L35
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
        r100 = r110;
        goto L6
    }
}
