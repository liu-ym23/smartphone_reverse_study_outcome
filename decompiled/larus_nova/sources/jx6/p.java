package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Ljx6/p;", "", "", "type", "I", "getType", "()I", "Ljx6/o;", "itemData", "Ljx6/o;", "b", "()Ljx6/o;", "Ljx6/b;", "actionInfo", "Ljx6/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/b;", "", "", "trackingParams", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "tabKey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tabName", "d", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("actionInfo")
    private final b actionInfo;

    @SerializedName("itemData")
    private final o itemData;

    @SerializedName("tabKey")
    private final String tabKey;

    @SerializedName("tabName")
    private final String tabName;

    @SerializedName("trackingParams")
    private final Map<String, Object> trackingParams;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemData, r101.itemData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionInfo, r101.actionInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabKey, r101.tabKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.type * 31) + this.itemData.hashCode()) * 31;
        b r101 = this.actionInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, Object> r105 = this.trackingParams;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.tabKey;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.tabName;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ItemInfo(type=" + this.type + ", itemData=" + this.itemData + ", actionInfo=" + this.actionInfo + ", trackingParams=" + this.trackingParams + ", tabKey=" + this.tabKey + ", tabName=" + this.tabName + ')';
    }

    public final b a() {
        return this.actionInfo;
    }

    public final o b() {
        return this.itemData;
    }

    public final String c() {
        return this.tabKey;
    }

    public final String d() {
        return this.tabName;
    }

    public final Map<String, Object> e() {
        return this.trackingParams;
    }

    public final int getType() {
        return this.type;
    }
}
