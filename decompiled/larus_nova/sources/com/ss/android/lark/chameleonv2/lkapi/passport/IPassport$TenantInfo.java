package com.ss.android.lark.chameleonv2.lkapi.passport;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003Ja\u0010\u001b\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "i18nNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "id", "name", "tenantBrand", MapBundleKey.MapObjKey.OBJ_GEO, "iconUrl", "<init>", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getI18nNames", "()Ljava/util/HashMap;", "getId", "()Ljava/lang/String;", "getName", "getTenantBrand", "getGeo", "getIconUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPassport$TenantInfo implements NonProguard {
    private final String geo;
    private final HashMap<String, String> i18nNames;
    private final String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f411441id;
    private final String name;
    private final String tenantBrand;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IPassport$TenantInfo copy$default(IPassport$TenantInfo r100, HashMap r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.i18nNames;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f411441id;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.name;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.tenantBrand;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.geo;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.iconUrl;
    L20:
        HashMap r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final HashMap<String, String> component1() {
        return this.i18nNames;
    }

    public final String component2() {
        return this.f411441id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.tenantBrand;
    }

    public final String component5() {
        return this.geo;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final IPassport$TenantInfo copy(HashMap<String, String> r100, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "i18nNames");
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "tenantBrand");
        Intrinsics.checkNotNullParameter(r113, MapBundleKey.MapObjKey.OBJ_GEO);
        Intrinsics.checkNotNullParameter(r114, "iconUrl");
        return new IPassport$TenantInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IPassport$TenantInfo) == true) goto L8;
        return false;
    L8:
        IPassport$TenantInfo r101 = (IPassport$TenantInfo) r100;
        if (Intrinsics.areEqual(this.i18nNames, r101.i18nNames) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411441id, r101.f411441id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tenantBrand, r101.tenantBrand) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.geo, r101.geo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.i18nNames.hashCode() * 31) + this.f411441id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.tenantBrand.hashCode()) * 31) + this.geo.hashCode()) * 31) + this.iconUrl.hashCode();
    }

    public String toString() {
        return "TenantInfo(i18nNames=" + this.i18nNames + ", id=" + this.f411441id + ", name=" + this.name + ", tenantBrand=" + this.tenantBrand + ", geo=" + this.geo + ", iconUrl=" + this.iconUrl + ')';
    }

    public final String getGeo() {
        return this.geo;
    }

    public final HashMap<String, String> getI18nNames() {
        return this.i18nNames;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.f411441id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTenantBrand() {
        return this.tenantBrand;
    }

    public IPassport$TenantInfo(HashMap<String, String> r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "i18nNames");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "tenantBrand");
        Intrinsics.checkNotNullParameter(r104, MapBundleKey.MapObjKey.OBJ_GEO);
        Intrinsics.checkNotNullParameter(r105, "iconUrl");
        this.i18nNames = r100;
        this.f411441id = r101;
        this.name = r102;
        this.tenantBrand = r103;
        this.geo = r104;
        this.iconUrl = r105;
    }
}
