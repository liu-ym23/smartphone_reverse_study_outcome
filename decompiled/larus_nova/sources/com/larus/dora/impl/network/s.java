package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/network/NLAppInfo;", "", "appName", "", "appIconUrl", com.heytap.mcssdk.constant.b.f276355e, "appStatus", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppIconUrl", "setAppIconUrl", "getAppPackage", "setAppPackage", "getAppStatus", "()I", "setAppStatus", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("notification_app_icon_url")
    private String appIconUrl;

    @SerializedName("notification_app_name")
    private String appName;

    @SerializedName("notification_app_package")
    private String appPackage;

    @SerializedName("notification_app_status")
    private int appStatus;

    public static final class a {
    }

    static {
    }

    public s() {
        this(null, null, null, 2);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appIconUrl, r101.appIconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appPackage, r101.appPackage) == true) goto L18;
        return false;
    L18:
        if (this.appStatus == r101.appStatus) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.appName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.appIconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appPackage;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.appStatus;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NLAppInfo(appName=" + this.appName + ", appIconUrl=" + this.appIconUrl + ", appPackage=" + this.appPackage + ", appStatus=" + this.appStatus + ')';
    }

    public final String b() {
        return this.appIconUrl;
    }

    public final String c() {
        return this.appName;
    }

    public final String d() {
        return this.appPackage;
    }

    public final int e() {
        return this.appStatus;
    }

    public static s a(s r100) {
        String r101 = r100.appName;
        String r102 = r100.appIconUrl;
        String r103 = r100.appPackage;
        int r104 = r100.appStatus;
        r100.getClass();
        return new s(r101, r102, r103, r104);
    }

    public final void f(int r100) {
        this.appStatus = r100;
    }

    public s(String r100, String r101, String r102, int r103) {
        this.appName = r100;
        this.appIconUrl = r101;
        this.appPackage = r102;
        this.appStatus = r103;
    }
}
