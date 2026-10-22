package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lyw6/e;", "", "", "statusCode", "I", "d", "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "hasGrouponTab", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "hasDiamondCollectEntry", "b", "collectEduStyle", "Ljava/lang/Integer;", "getCollectEduStyle", "()Ljava/lang/Integer;", "Lyw6/j;", "diamondCollectEntryEduSchema", "Lyw6/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lyw6/j;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("collect_edu_style")
    private final Integer collectEduStyle;

    @SerializedName("diamond_collect_entry_edu_schema")
    private final j diamondCollectEntryEduSchema;

    @SerializedName("has_diamond_collect_entry")
    private final Boolean hasDiamondCollectEntry;

    @SerializedName("has_groupon_tab")
    private final Boolean hasGrouponTab;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasGrouponTab, r101.hasGrouponTab) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hasDiamondCollectEntry, r101.hasDiamondCollectEntry) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.collectEduStyle, r101.collectEduStyle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.diamondCollectEntryEduSchema, r101.diamondCollectEntryEduSchema) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.statusMsg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.hasGrouponTab;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.hasDiamondCollectEntry;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.collectEduStyle;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        j r114 = this.diamondCollectEntryEduSchema;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "CollectResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", hasGrouponTab=" + this.hasGrouponTab + ", hasDiamondCollectEntry=" + this.hasDiamondCollectEntry + ", collectEduStyle=" + this.collectEduStyle + ", diamondCollectEntryEduSchema=" + this.diamondCollectEntryEduSchema + ')';
    }

    public e() {
        this.statusCode = 0;
        this.statusMsg = null;
        this.hasGrouponTab = null;
        this.hasDiamondCollectEntry = null;
        this.collectEduStyle = null;
        this.diamondCollectEntryEduSchema = null;
    }

    public final j a() {
        return this.diamondCollectEntryEduSchema;
    }

    public final Boolean b() {
        return this.hasDiamondCollectEntry;
    }

    public final Boolean c() {
        return this.hasGrouponTab;
    }

    public final int d() {
        return this.statusCode;
    }

    public final String e() {
        return this.statusMsg;
    }
}
