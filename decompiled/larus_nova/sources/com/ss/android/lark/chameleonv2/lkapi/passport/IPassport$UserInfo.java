package com.ss.android.lark.chameleonv2.lkapi.passport;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J%\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Ju\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$UserInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "avatarKey", "", "avatarUrl", MapBundleKey.MapObjKey.OBJ_GEO, "i18nNames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "id", "name", "tenant", "Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;", Scraps.INNER_UNIT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getAvatarUrl", "getGeo", "getI18nNames", "()Ljava/util/HashMap;", "getId", "getName", "getTenant", "()Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$TenantInfo;", "getUnit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPassport$UserInfo implements NonProguard {
    private final String avatarKey;
    private final String avatarUrl;
    private final String geo;
    private final HashMap<String, String> i18nNames;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f411442id;
    private final String name;
    private final IPassport$TenantInfo tenant;
    private final String unit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IPassport$UserInfo copy$default(IPassport$UserInfo r100, String r110, String r111, String r112, HashMap r113, String r114, String r115, IPassport$TenantInfo r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.avatarKey;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.avatarUrl;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.geo;
    L15:
        if ((r118 & 8) == 0) goto L17;
        HashMap r104 = r100.i18nNames;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.f411442id;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.name;
    L27:
        if ((r118 & 64) == 0) goto L29;
        IPassport$TenantInfo r107 = r100.tenant;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.unit;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
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
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final String component3() {
        return this.geo;
    }

    public final HashMap<String, String> component4() {
        return this.i18nNames;
    }

    public final String component5() {
        return this.f411442id;
    }

    public final String component6() {
        return this.name;
    }

    public final IPassport$TenantInfo component7() {
        return this.tenant;
    }

    public final String component8() {
        return this.unit;
    }

    public final IPassport$UserInfo copy(String r110, String r111, String r112, HashMap<String, String> r113, String r114, String r115, IPassport$TenantInfo r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "avatarKey");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        Intrinsics.checkNotNullParameter(r112, MapBundleKey.MapObjKey.OBJ_GEO);
        Intrinsics.checkNotNullParameter(r113, "i18nNames");
        Intrinsics.checkNotNullParameter(r114, "id");
        Intrinsics.checkNotNullParameter(r115, "name");
        Intrinsics.checkNotNullParameter(r116, "tenant");
        Intrinsics.checkNotNullParameter(r117, Scraps.INNER_UNIT);
        return new IPassport$UserInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IPassport$UserInfo) == true) goto L8;
        return false;
    L8:
        IPassport$UserInfo r101 = (IPassport$UserInfo) r100;
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.geo, r101.geo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nNames, r101.i18nNames) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f411442id, r101.f411442id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tenant, r101.tenant) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.unit, r101.unit) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.avatarKey.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.geo.hashCode()) * 31) + this.i18nNames.hashCode()) * 31) + this.f411442id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.tenant.hashCode()) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "UserInfo(avatarKey=" + this.avatarKey + ", avatarUrl=" + this.avatarUrl + ", geo=" + this.geo + ", i18nNames=" + this.i18nNames + ", id=" + this.f411442id + ", name=" + this.name + ", tenant=" + this.tenant + ", unit=" + this.unit + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getGeo() {
        return this.geo;
    }

    public final HashMap<String, String> getI18nNames() {
        return this.i18nNames;
    }

    public final String getId() {
        return this.f411442id;
    }

    public final String getName() {
        return this.name;
    }

    public final IPassport$TenantInfo getTenant() {
        return this.tenant;
    }

    public final String getUnit() {
        return this.unit;
    }

    public IPassport$UserInfo(String r100, String r101, String r102, HashMap<String, String> r103, String r104, String r105, IPassport$TenantInfo r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_GEO);
        Intrinsics.checkNotNullParameter(r103, "i18nNames");
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter(r105, "name");
        Intrinsics.checkNotNullParameter(r106, "tenant");
        Intrinsics.checkNotNullParameter(r107, Scraps.INNER_UNIT);
        this.avatarKey = r100;
        this.avatarUrl = r101;
        this.geo = r102;
        this.i18nNames = r103;
        this.f411442id = r104;
        this.name = r105;
        this.tenant = r106;
        this.unit = r107;
    }
}
