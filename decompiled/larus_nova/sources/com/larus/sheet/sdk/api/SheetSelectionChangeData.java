package com.larus.sheet.sdk.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/sheet/sdk/api/SheetSelectionChangeData;", "", "spreadsheetVersion", "", "spreadsheetToken", "", "selected", "Lcom/larus/sheet/sdk/api/SheetUserSelection;", "<init>", "(ILjava/lang/String;Lcom/larus/sheet/sdk/api/SheetUserSelection;)V", "getSpreadsheetVersion", "()I", "getSpreadsheetToken", "()Ljava/lang/String;", "getSelected", "()Lcom/larus/sheet/sdk/api/SheetUserSelection;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetSelectionChangeData {

    @SerializedName("selected")
    private final SheetUserSelection selected;

    @SerializedName("spreadsheet_token")
    private final String spreadsheetToken;

    @SerializedName("spreadsheet_version")
    private final int spreadsheetVersion;

    public SheetSelectionChangeData() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ SheetSelectionChangeData copy$default(SheetSelectionChangeData r100, int r101, String r102, SheetUserSelection r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.spreadsheetVersion;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.spreadsheetToken;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.selected;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.spreadsheetVersion;
    }

    public final String component2() {
        return this.spreadsheetToken;
    }

    public final SheetUserSelection component3() {
        return this.selected;
    }

    public final SheetSelectionChangeData copy(int r100, String r101, SheetUserSelection r102) {
        return new SheetSelectionChangeData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SheetSelectionChangeData) == true) goto L8;
        return false;
    L8:
        SheetSelectionChangeData r101 = (SheetSelectionChangeData) r100;
        if (this.spreadsheetVersion == r101.spreadsheetVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spreadsheetToken, r101.spreadsheetToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selected, r101.selected) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.spreadsheetVersion * 31;
        String r101 = this.spreadsheetToken;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        SheetUserSelection r105 = this.selected;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "SheetSelectionChangeData(spreadsheetVersion=" + this.spreadsheetVersion + ", spreadsheetToken=" + this.spreadsheetToken + ", selected=" + this.selected + ')';
    }

    public final SheetUserSelection getSelected() {
        return this.selected;
    }

    public final String getSpreadsheetToken() {
        return this.spreadsheetToken;
    }

    public final int getSpreadsheetVersion() {
        return this.spreadsheetVersion;
    }

    public SheetSelectionChangeData(int r100, String r101, SheetUserSelection r102) {
        this.spreadsheetVersion = r100;
        this.spreadsheetToken = r101;
        this.selected = r102;
    }

    public /* synthetic */ SheetSelectionChangeData(int r100, String r101, SheetUserSelection r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
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
