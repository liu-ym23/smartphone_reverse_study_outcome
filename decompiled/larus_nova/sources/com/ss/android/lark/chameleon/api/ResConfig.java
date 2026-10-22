package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ResConfig;", "Ljava/io/Serializable;", "resVersion", "", "offlineZipName", "rootPath", "geckoConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;)V", "getGeckoConfig", "()Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;", "setGeckoConfig", "(Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;)V", "getOfflineZipName", "()Ljava/lang/String;", "setOfflineZipName", "(Ljava/lang/String;)V", "getResVersion", "setResVersion", "getRootPath", "setRootPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResConfig implements Serializable {
    private ChameleonGeckoConfig geckoConfig;
    private String offlineZipName;
    private String resVersion;
    private String rootPath;

    public ResConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResConfig copy$default(ResConfig r100, String r101, String r102, String r103, ChameleonGeckoConfig r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.resVersion;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.offlineZipName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rootPath;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.geckoConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.resVersion;
    }

    public final String component2() {
        return this.offlineZipName;
    }

    public final String component3() {
        return this.rootPath;
    }

    public final ChameleonGeckoConfig component4() {
        return this.geckoConfig;
    }

    public final ResConfig copy(String r100, String r101, String r102, ChameleonGeckoConfig r103) {
        return new ResConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResConfig) == true) goto L8;
        return false;
    L8:
        ResConfig r101 = (ResConfig) r100;
        if (Intrinsics.areEqual(this.resVersion, r101.resVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offlineZipName, r101.offlineZipName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootPath, r101.rootPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.geckoConfig, r101.geckoConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.resVersion;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.offlineZipName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.rootPath;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ChameleonGeckoConfig r110 = this.geckoConfig;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ResConfig(resVersion=" + this.resVersion + ", offlineZipName=" + this.offlineZipName + ", rootPath=" + this.rootPath + ", geckoConfig=" + this.geckoConfig + ')';
    }

    public final ChameleonGeckoConfig getGeckoConfig() {
        return this.geckoConfig;
    }

    public final String getOfflineZipName() {
        return this.offlineZipName;
    }

    public final String getResVersion() {
        return this.resVersion;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final void setGeckoConfig(ChameleonGeckoConfig r100) {
        this.geckoConfig = r100;
    }

    public final void setOfflineZipName(String r100) {
        this.offlineZipName = r100;
    }

    public final void setResVersion(String r100) {
        this.resVersion = r100;
    }

    public final void setRootPath(String r100) {
        this.rootPath = r100;
    }

    public ResConfig(String r100, String r101, String r102, ChameleonGeckoConfig r103) {
        this.resVersion = r100;
        this.offlineZipName = r101;
        this.rootPath = r102;
        this.geckoConfig = r103;
    }

    public /* synthetic */ ResConfig(String r100, String r101, String r102, ChameleonGeckoConfig r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
