package com.obric.update.bean;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rHÆ\u0003Jj\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/obric/update/bean/ObricUpdateAvailableStatus;", "", "isUpdateAvailable", "", "packageName", "", "packageSize", "", "packageVersionName", "packageLog", "resultBundle", "Landroid/os/Bundle;", "ext", "", "<init>", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "()Z", "getPackageName", "()Ljava/lang/String;", "getPackageSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPackageVersionName", "getPackageLog", "getResultBundle", "()Landroid/os/Bundle;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)Lcom/obric/update/bean/ObricUpdateAvailableStatus;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateAvailableStatus {
    private final Map<String, Object> ext;
    private final boolean isUpdateAvailable;
    private final String packageLog;
    private final String packageName;
    private final Long packageSize;
    private final String packageVersionName;
    private final Bundle resultBundle;

    public ObricUpdateAvailableStatus() {
        this(false, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricUpdateAvailableStatus copy$default(ObricUpdateAvailableStatus r100, boolean r101, String r102, Long r103, String r104, String r110, Bundle r111, Map r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.isUpdateAvailable;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.packageName;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.packageSize;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.packageVersionName;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.packageLog;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.resultBundle;
    L20:
        Bundle r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.ext;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.isUpdateAvailable;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Long component3() {
        return this.packageSize;
    }

    public final String component4() {
        return this.packageVersionName;
    }

    public final String component5() {
        return this.packageLog;
    }

    public final Bundle component6() {
        return this.resultBundle;
    }

    public final Map<String, Object> component7() {
        return this.ext;
    }

    public final ObricUpdateAvailableStatus copy(boolean r110, String r111, Long r112, String r113, String r114, Bundle r115, Map<String, ? extends Object> r116) {
        Intrinsics.checkNotNullParameter(r116, "ext");
        return new ObricUpdateAvailableStatus(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricUpdateAvailableStatus) == true) goto L8;
        return false;
    L8:
        ObricUpdateAvailableStatus r101 = (ObricUpdateAvailableStatus) r100;
        if (this.isUpdateAvailable == r101.isUpdateAvailable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageSize, r101.packageSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.packageVersionName, r101.packageVersionName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.packageLog, r101.packageLog) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resultBundle, r101.resultBundle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        if (this.isUpdateAvailable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.packageName;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.packageSize;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.packageVersionName;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.packageLog;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Bundle r115 = this.resultBundle;
        if (r115 == null) goto L27;
        r103 = r115.hashCode();
    L27:
        return ((r114 + r103) * 31) + this.ext.hashCode();
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
        return "ObricUpdateAvailableStatus(isUpdateAvailable=" + this.isUpdateAvailable + ", packageName=" + this.packageName + ", packageSize=" + this.packageSize + ", packageVersionName=" + this.packageVersionName + ", packageLog=" + this.packageLog + ", resultBundle=" + this.resultBundle + ", ext=" + this.ext + ')';
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final String getPackageLog() {
        return this.packageLog;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Long getPackageSize() {
        return this.packageSize;
    }

    public final String getPackageVersionName() {
        return this.packageVersionName;
    }

    public final Bundle getResultBundle() {
        return this.resultBundle;
    }

    public final boolean isUpdateAvailable() {
        return this.isUpdateAvailable;
    }

    public ObricUpdateAvailableStatus(boolean r100, String r101, Long r102, String r103, String r104, Bundle r105, Map<String, ? extends Object> r106) {
        Intrinsics.checkNotNullParameter(r106, "ext");
        this.isUpdateAvailable = r100;
        this.packageName = r101;
        this.packageSize = r102;
        this.packageVersionName = r103;
        this.packageLog = r104;
        this.resultBundle = r105;
        this.ext = r106;
    }

    public /* synthetic */ ObricUpdateAvailableStatus(boolean r100, String r101, Long r102, String r103, String r110, Bundle r111, Map r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = false;
    L5:
        Bundle r104 = null;
        if ((r113 & 2) == 0) goto L8;
        String r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        Long r105 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r107 = null;
    L22:
        if ((r113 & 32) != 0) goto L26;
        r104 = r111;
    L26:
        if ((r113 & 64) == 0) goto L28;
        r112 = MapsKt.emptyMap();
    L28:
        this(r100, r115, r105, r106, r107, r104, r112);
        return;
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
