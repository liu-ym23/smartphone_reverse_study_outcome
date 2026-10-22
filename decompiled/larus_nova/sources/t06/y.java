package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lt06/y;", "", "", "enableInjectAllExternHost", "Z", "c", "()Z", "", "", "enableInjectScenes", "Ljava/util/List;", "d", "()Ljava/util/List;", "enableInjectUrlHostList", "e", "enableInjectUrlRegList", "f", "disableInjectUrlHostList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "disableInjectUrlRegList", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("disable_url_host")
    private final List<String> disableInjectUrlHostList;

    @SerializedName("disable_url_reg")
    private final List<String> disableInjectUrlRegList;

    @SerializedName("all_extern_host")
    private final boolean enableInjectAllExternHost;

    @SerializedName("enable_scenes")
    private final List<String> enableInjectScenes;

    @SerializedName("enable_url_host")
    private final List<String> enableInjectUrlHostList;

    @SerializedName("enable_url_reg")
    private final List<String> enableInjectUrlRegList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.enableInjectAllExternHost == r101.enableInjectAllExternHost) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableInjectScenes, r101.enableInjectScenes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableInjectUrlHostList, r101.enableInjectUrlHostList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableInjectUrlRegList, r101.enableInjectUrlRegList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disableInjectUrlHostList, r101.disableInjectUrlHostList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.disableInjectUrlRegList, r101.disableInjectUrlRegList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.enableInjectAllExternHost == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.enableInjectScenes;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.enableInjectUrlHostList;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        List<String> r109 = this.enableInjectUrlRegList;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.disableInjectUrlHostList;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = this.disableInjectUrlRegList;
        if (r115 == null) goto L27;
        r103 = r115.hashCode();
    L27:
        return r114 + r103;
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

    public final String toString() {
        return "WebInjectJSEnableRule(enableInjectAllExternHost=" + this.enableInjectAllExternHost + ", enableInjectScenes=" + this.enableInjectScenes + ", enableInjectUrlHostList=" + this.enableInjectUrlHostList + ", enableInjectUrlRegList=" + this.enableInjectUrlRegList + ", disableInjectUrlHostList=" + this.disableInjectUrlHostList + ", disableInjectUrlRegList=" + this.disableInjectUrlRegList + ')';
    }

    public y() {
        this.enableInjectAllExternHost = false;
        this.enableInjectScenes = null;
        this.enableInjectUrlHostList = null;
        this.enableInjectUrlRegList = null;
        this.disableInjectUrlHostList = null;
        this.disableInjectUrlRegList = null;
    }

    public final List<String> a() {
        return this.disableInjectUrlHostList;
    }

    public final List<String> b() {
        return this.disableInjectUrlRegList;
    }

    public final boolean c() {
        return this.enableInjectAllExternHost;
    }

    public final List<String> d() {
        return this.enableInjectScenes;
    }

    public final List<String> e() {
        return this.enableInjectUrlHostList;
    }

    public final List<String> f() {
        return this.enableInjectUrlRegList;
    }
}
