package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/ModelFilingInfoConfig;", "", "enabled", "", "manufacturerAllowList", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getManufacturerAllowList", "()Ljava/util/List;", "shouldShowForDevice", "manufacturer", "brand", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/model/ModelFilingInfoConfig;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h3 {

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("manufacturer_allow_list")
    private final List<String> manufacturerAllowList;

    public h3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r101 = (h3) r100;
        if (Intrinsics.areEqual(this.enabled, r101.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.manufacturerAllowList, r101.manufacturerAllowList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enabled;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.manufacturerAllowList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModelFilingInfoConfig(enabled=" + this.enabled + ", manufacturerAllowList=" + this.manufacturerAllowList + ')';
    }

    public h3(Object r100) {
        Boolean r101 = Boolean.TRUE;
        List<String> r102 = CollectionsKt.listOf(new String[]{"OPPO", "OnePlus", "realme"});
        this.enabled = r101;
        this.manufacturerAllowList = r102;
    }

    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manufacturer");
        Intrinsics.checkNotNullParameter(r101, "brand");
        if (Intrinsics.areEqual(this.enabled, Boolean.TRUE) == true) goto L6;
        return true;
    L6:
        if (StringsKt.isBlank(r100) == true) goto L8;
    L10:
        List<String> r102 = this.manufacturerAllowList;
        if (r102 == null) goto L13;
        List r103 = CollectionsKt.filterNotNull(r102);
    L14:
        if (r103 != null) goto L16;
        r103 = CollectionsKt.emptyList();
    L16:
        List r104 = r103;
        if ((r104 instanceof Collection) == true) goto L19;
    L21:
        Iterator r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L36;
        String r106 = (String) r105.next();
        if (StringsKt.isBlank(r100) == true) goto L29;
        if (StringsKt.equals(r106, r100, true) == false) goto L29;
    L32:
        boolean r107 = true;
    L34:
        if (r107 == false) goto L23;
        return true;
    L29:
        if (StringsKt.isBlank(r101) == false) goto L31;
    L33:
        r107 = false;
        goto L34
    L31:
        if (StringsKt.equals(r106, r101, true) == false) goto L33;
    L36:
        return false;
    L19:
        if (r104.isEmpty() == false) goto L21;
    L13:
        r103 = null;
        goto L14
    L8:
        if (StringsKt.isBlank(r101) == false) goto L10;
        return false;
    }
}
