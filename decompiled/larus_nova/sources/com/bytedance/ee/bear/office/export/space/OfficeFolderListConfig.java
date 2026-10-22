package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderListConfig;", "Ljava/io/Serializable;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "enableMultiSelect", "", "disableInternalFolderFallback", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZ)V", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getEnableMultiSelect", "()Z", "getDisableInternalFolderFallback", "toOfficeListConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderListConfig implements Serializable {
    private final boolean disableInternalFolderFallback;
    private final OfficeListDisplayMode displayMode;
    private final boolean enableMultiSelect;

    public OfficeFolderListConfig() {
        this(null, false, false, 7, null);
    }

    public static /* synthetic */ OfficeFolderListConfig copy$default(OfficeFolderListConfig r100, OfficeListDisplayMode r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.displayMode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enableMultiSelect;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.disableInternalFolderFallback;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final OfficeListDisplayMode component1() {
        return this.displayMode;
    }

    public final boolean component2() {
        return this.enableMultiSelect;
    }

    public final boolean component3() {
        return this.disableInternalFolderFallback;
    }

    public final OfficeFolderListConfig copy(OfficeListDisplayMode r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        return new OfficeFolderListConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeFolderListConfig) == true) goto L8;
        return false;
    L8:
        OfficeFolderListConfig r101 = (OfficeFolderListConfig) r100;
        if (this.displayMode == r101.displayMode) goto L12;
        return false;
    L12:
        if (this.enableMultiSelect == r101.enableMultiSelect) goto L15;
        return false;
    L15:
        if (this.disableInternalFolderFallback == r101.disableInternalFolderFallback) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.displayMode.hashCode() * 31;
        int r101 = 1231;
        if (this.enableMultiSelect == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.disableInternalFolderFallback == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeFolderListConfig(displayMode=" + this.displayMode + ", enableMultiSelect=" + this.enableMultiSelect + ", disableInternalFolderFallback=" + this.disableInternalFolderFallback + ')';
    }

    public final OfficeListConfig toOfficeListConfig() {
        return new OfficeListConfig(this.displayMode, false, this.enableMultiSelect, this.disableInternalFolderFallback, null, null, 50, null);
    }

    public final boolean getDisableInternalFolderFallback() {
        return this.disableInternalFolderFallback;
    }

    public final OfficeListDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final boolean getEnableMultiSelect() {
        return this.enableMultiSelect;
    }

    public OfficeFolderListConfig(OfficeListDisplayMode r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        this.displayMode = r100;
        this.enableMultiSelect = r101;
        this.disableInternalFolderFallback = r102;
    }

    public /* synthetic */ OfficeFolderListConfig(OfficeListDisplayMode r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = OfficeListDisplayMode.FLOW;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
