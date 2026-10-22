package com.larus.office.plugins.aiedit;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/office/plugins/aiedit/SheetUserSelection;", "", "sheets", "", "Lcom/larus/office/plugins/aiedit/SheetSelection;", "activeSheetName", "", "activeSheetId", "plainText", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSheets", "()Ljava/util/List;", "getActiveSheetName", "()Ljava/lang/String;", "getActiveSheetId", "getPlainText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetUserSelection {

    @SerializedName("active_sheet_id")
    private final String activeSheetId;

    @SerializedName("active_sheet_name")
    private final String activeSheetName;

    @SerializedName("plain_text")
    private final String plainText;

    @SerializedName("sheets")
    private final List<SheetSelection> sheets;

    public SheetUserSelection() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SheetUserSelection copy$default(SheetUserSelection r100, List r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.sheets;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.activeSheetName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.activeSheetId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.plainText;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<SheetSelection> component1() {
        return this.sheets;
    }

    public final String component2() {
        return this.activeSheetName;
    }

    public final String component3() {
        return this.activeSheetId;
    }

    public final String component4() {
        return this.plainText;
    }

    public final SheetUserSelection copy(List<SheetSelection> r100, String r101, String r102, String r103) {
        return new SheetUserSelection(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SheetUserSelection) == true) goto L8;
        return false;
    L8:
        SheetUserSelection r101 = (SheetUserSelection) r100;
        if (Intrinsics.areEqual(this.sheets, r101.sheets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activeSheetName, r101.activeSheetName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activeSheetId, r101.activeSheetId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.plainText, r101.plainText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<SheetSelection> r100 = this.sheets;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.activeSheetName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.activeSheetId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.plainText;
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
        return "SheetUserSelection(sheets=" + this.sheets + ", activeSheetName=" + this.activeSheetName + ", activeSheetId=" + this.activeSheetId + ", plainText=" + this.plainText + ')';
    }

    public final String getActiveSheetId() {
        return this.activeSheetId;
    }

    public final String getActiveSheetName() {
        return this.activeSheetName;
    }

    public final String getPlainText() {
        return this.plainText;
    }

    public final List<SheetSelection> getSheets() {
        return this.sheets;
    }

    public SheetUserSelection(List<SheetSelection> r100, String r101, String r102, String r103) {
        this.sheets = r100;
        this.activeSheetName = r101;
        this.activeSheetId = r102;
        this.plainText = r103;
    }

    public /* synthetic */ SheetUserSelection(List r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
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
