package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0000J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleon/ResConfig;", "Ljava/io/Serializable;", "resVersion", "", "offlineZipName", "geckoConfig", "Lcom/ss/android/lark/chameleon/ResGeckoConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/ResGeckoConfig;)V", "getResVersion", "()Ljava/lang/String;", "setResVersion", "(Ljava/lang/String;)V", "getOfflineZipName", "setOfflineZipName", "getGeckoConfig", "()Lcom/ss/android/lark/chameleon/ResGeckoConfig;", "setGeckoConfig", "(Lcom/ss/android/lark/chameleon/ResGeckoConfig;)V", "copy", "toString", "component1", "component2", "component3", "equals", "", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResConfig implements Serializable {
    private ResGeckoConfig geckoConfig;
    private String offlineZipName;
    private String resVersion;

    public ResConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ResConfig copy$default(ResConfig r100, String r101, String r102, ResGeckoConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.resVersion;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.offlineZipName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.geckoConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.resVersion;
    }

    public final String component2() {
        return this.offlineZipName;
    }

    public final ResGeckoConfig component3() {
        return this.geckoConfig;
    }

    public final ResConfig copy(String r100, String r101, ResGeckoConfig r102) {
        return new ResConfig(r100, r101, r102);
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
        if (Intrinsics.areEqual(this.geckoConfig, r101.geckoConfig) == true) goto L17;
        return false;
    L17:
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
        ResGeckoConfig r107 = this.geckoConfig;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final ResConfig copy() {
        String r100 = this.resVersion;
        String r101 = this.offlineZipName;
        ResGeckoConfig r102 = this.geckoConfig;
        if (r102 == null) goto L5;
        ResGeckoConfig r103 = r102.copy();
    L7:
        return new ResConfig(r100, r101, r103);
    L5:
        r103 = null;
        goto L7
    }

    public String toString() {
        return "ResConfig(resVersion=" + this.resVersion + ", offlineZipName=" + this.offlineZipName + ", geckoConfig=" + this.geckoConfig + ')';
    }

    public final ResGeckoConfig getGeckoConfig() {
        return this.geckoConfig;
    }

    public final String getOfflineZipName() {
        return this.offlineZipName;
    }

    public final String getResVersion() {
        return this.resVersion;
    }

    public final void setGeckoConfig(ResGeckoConfig r100) {
        this.geckoConfig = r100;
    }

    public final void setOfflineZipName(String r100) {
        this.offlineZipName = r100;
    }

    public final void setResVersion(String r100) {
        this.resVersion = r100;
    }

    public ResConfig(String r100, String r101, ResGeckoConfig r102) {
        this.resVersion = r100;
        this.offlineZipName = r101;
        this.geckoConfig = r102;
    }

    public /* synthetic */ ResConfig(String r100, String r101, ResGeckoConfig r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
