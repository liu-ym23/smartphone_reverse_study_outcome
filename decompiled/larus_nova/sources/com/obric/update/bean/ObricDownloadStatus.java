package com.obric.update.bean;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rHÆ\u0003J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/obric/update/bean/ObricDownloadStatus;", "", "isDownloading", "", "packageName", "", "packageSize", "", "downloadProgress", "", "resultBundle", "Landroid/os/Bundle;", "ext", "", "<init>", "(ZLjava/lang/String;Ljava/lang/Long;ILandroid/os/Bundle;Ljava/util/Map;)V", "()Z", "getPackageName", "()Ljava/lang/String;", "getPackageSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDownloadProgress", "()I", "getResultBundle", "()Landroid/os/Bundle;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/Long;ILandroid/os/Bundle;Ljava/util/Map;)Lcom/obric/update/bean/ObricDownloadStatus;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDownloadStatus {
    private final int downloadProgress;
    private final Map<String, Object> ext;
    private final boolean isDownloading;
    private final String packageName;
    private final Long packageSize;
    private final Bundle resultBundle;

    public ObricDownloadStatus() {
        this(false, null, null, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricDownloadStatus copy$default(ObricDownloadStatus r100, boolean r101, String r102, Long r103, int r104, Bundle r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.isDownloading;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.packageName;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.packageSize;
    L11:
        Long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.downloadProgress;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.resultBundle;
    L17:
        Bundle r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.ext;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.isDownloading;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Long component3() {
        return this.packageSize;
    }

    public final int component4() {
        return this.downloadProgress;
    }

    public final Bundle component5() {
        return this.resultBundle;
    }

    public final Map<String, Object> component6() {
        return this.ext;
    }

    public final ObricDownloadStatus copy(boolean r100, String r110, Long r111, int r112, Bundle r113, Map<String, ? extends Object> r114) {
        Intrinsics.checkNotNullParameter(r114, "ext");
        return new ObricDownloadStatus(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricDownloadStatus) == true) goto L8;
        return false;
    L8:
        ObricDownloadStatus r101 = (ObricDownloadStatus) r100;
        if (this.isDownloading == r101.isDownloading) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageSize, r101.packageSize) == true) goto L18;
        return false;
    L18:
        if (this.downloadProgress == r101.downloadProgress) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resultBundle, r101.resultBundle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.isDownloading == false) goto L5;
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
        int r108 = (((r105 + r107) * 31) + this.downloadProgress) * 31;
        Bundle r109 = this.resultBundle;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return ((r108 + r103) * 31) + this.ext.hashCode();
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
        return "ObricDownloadStatus(isDownloading=" + this.isDownloading + ", packageName=" + this.packageName + ", packageSize=" + this.packageSize + ", downloadProgress=" + this.downloadProgress + ", resultBundle=" + this.resultBundle + ", ext=" + this.ext + ')';
    }

    public final int getDownloadProgress() {
        return this.downloadProgress;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Long getPackageSize() {
        return this.packageSize;
    }

    public final Bundle getResultBundle() {
        return this.resultBundle;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public ObricDownloadStatus(boolean r100, String r101, Long r102, int r103, Bundle r104, Map<String, ? extends Object> r105) {
        Intrinsics.checkNotNullParameter(r105, "ext");
        this.isDownloading = r100;
        this.packageName = r101;
        this.packageSize = r102;
        this.downloadProgress = r103;
        this.resultBundle = r104;
        this.ext = r105;
    }

    public /* synthetic */ ObricDownloadStatus(boolean r100, String r101, Long r102, int r103, Bundle r104, Map r110, int r111, DefaultConstructorMarker r112) {
        int r105 = 0;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L6:
        Bundle r106 = null;
        if ((r111 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Long r108 = null;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r106 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = MapsKt.emptyMap();
    L25:
        this(r113, r107, r108, r105, r106, r110);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L6
    }
}
