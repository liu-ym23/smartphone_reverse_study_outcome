package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Paths;", "Lcom/bytedance/ee/util/io/NonProguard;", "desktop", "", "downloads", "home", "temp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesktop", "()Ljava/lang/String;", "getDownloads", "getHome", "getTemp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISystem$Internal$Paths implements NonProguard {
    private final String desktop;
    private final String downloads;
    private final String home;
    private final String temp;

    public static /* synthetic */ ISystem$Internal$Paths copy$default(ISystem$Internal$Paths r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.desktop;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.downloads;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.home;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.temp;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.desktop;
    }

    public final String component2() {
        return this.downloads;
    }

    public final String component3() {
        return this.home;
    }

    public final String component4() {
        return this.temp;
    }

    public final ISystem$Internal$Paths copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "desktop");
        Intrinsics.checkNotNullParameter(r101, "downloads");
        Intrinsics.checkNotNullParameter(r102, "home");
        Intrinsics.checkNotNullParameter(r103, "temp");
        return new ISystem$Internal$Paths(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ISystem$Internal$Paths) == true) goto L8;
        return false;
    L8:
        ISystem$Internal$Paths r101 = (ISystem$Internal$Paths) r100;
        if (Intrinsics.areEqual(this.desktop, r101.desktop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloads, r101.downloads) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.home, r101.home) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.temp, r101.temp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.desktop.hashCode() * 31) + this.downloads.hashCode()) * 31) + this.home.hashCode()) * 31) + this.temp.hashCode();
    }

    public String toString() {
        return "Paths(desktop=" + this.desktop + ", downloads=" + this.downloads + ", home=" + this.home + ", temp=" + this.temp + ')';
    }

    public final String getDesktop() {
        return this.desktop;
    }

    public final String getDownloads() {
        return this.downloads;
    }

    public final String getHome() {
        return this.home;
    }

    public final String getTemp() {
        return this.temp;
    }

    public ISystem$Internal$Paths(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "desktop");
        Intrinsics.checkNotNullParameter(r101, "downloads");
        Intrinsics.checkNotNullParameter(r102, "home");
        Intrinsics.checkNotNullParameter(r103, "temp");
        this.desktop = r100;
        this.downloads = r101;
        this.home = r102;
        this.temp = r103;
    }
}
