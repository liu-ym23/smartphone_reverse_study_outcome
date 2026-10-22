package com.bytedance.ee.bear.search;

import com.ss.android.lark.picker.statistics.PickerStatistics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/search/SelectFolderConfig;", "Ljava/io/Serializable;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "useDefaultClick", "", "titleName", "", "isMultipleSelect", "isEnableMulti2Single", "<init>", "(Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;ZLjava/lang/String;ZZ)V", "getScene", "()Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "setScene", "(Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;)V", "getUseDefaultClick", "()Z", "getTitleName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "contentmanager-search-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectFolderConfig implements Serializable {
    private final boolean isEnableMulti2Single;
    private final boolean isMultipleSelect;
    private PickerStatistics.Scene scene;
    private final String titleName;
    private final boolean useDefaultClick;

    public SelectFolderConfig() {
        this(null, false, null, false, false, 31, null);
    }

    public static /* synthetic */ SelectFolderConfig copy$default(SelectFolderConfig r100, PickerStatistics.Scene r101, boolean r102, String r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.useDefaultClick;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.titleName;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isMultipleSelect;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isEnableMulti2Single;
    L17:
        PickerStatistics.Scene r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final PickerStatistics.Scene component1() {
        return this.scene;
    }

    public final boolean component2() {
        return this.useDefaultClick;
    }

    public final String component3() {
        return this.titleName;
    }

    public final boolean component4() {
        return this.isMultipleSelect;
    }

    public final boolean component5() {
        return this.isEnableMulti2Single;
    }

    public final SelectFolderConfig copy(PickerStatistics.Scene r100, boolean r101, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r110, "titleName");
        return new SelectFolderConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectFolderConfig) == true) goto L8;
        return false;
    L8:
        SelectFolderConfig r101 = (SelectFolderConfig) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (this.useDefaultClick == r101.useDefaultClick) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.titleName, r101.titleName) == true) goto L18;
        return false;
    L18:
        if (this.isMultipleSelect == r101.isMultipleSelect) goto L21;
        return false;
    L21:
        if (this.isEnableMulti2Single == r101.isEnableMulti2Single) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.scene.hashCode() * 31;
        int r101 = 1231;
        if (this.useDefaultClick == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.titleName.hashCode()) * 31;
        if (this.isMultipleSelect == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.isEnableMulti2Single == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "SelectFolderConfig(scene=" + this.scene + ", useDefaultClick=" + this.useDefaultClick + ", titleName=" + this.titleName + ", isMultipleSelect=" + this.isMultipleSelect + ", isEnableMulti2Single=" + this.isEnableMulti2Single + ')';
    }

    public final PickerStatistics.Scene getScene() {
        return this.scene;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final boolean getUseDefaultClick() {
        return this.useDefaultClick;
    }

    public final boolean isEnableMulti2Single() {
        return this.isEnableMulti2Single;
    }

    public final boolean isMultipleSelect() {
        return this.isMultipleSelect;
    }

    public final void setScene(PickerStatistics.Scene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public SelectFolderConfig(PickerStatistics.Scene r100, boolean r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "titleName");
        this.scene = r100;
        this.useDefaultClick = r101;
        this.titleName = r102;
        this.isMultipleSelect = r103;
        this.isEnableMulti2Single = r104;
    }

    public /* synthetic */ SelectFolderConfig(PickerStatistics.Scene r100, boolean r101, String r102, boolean r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = PickerStatistics.Scene.Unknown;
    L5:
        boolean r106 = true;
        if ((r105 & 2) == 0) goto L8;
        boolean r111 = true;
    L10:
        if ((r105 & 4) == 0) goto L12;
        r102 = "";
    L12:
        String r107 = r102;
        if ((r105 & 8) != 0) goto L17;
        r106 = r103;
    L17:
        if ((r105 & 16) == 0) goto L19;
        boolean r108 = false;
    L20:
        this(r100, r111, r107, r106, r108);
        return;
    L19:
        r108 = r104;
        goto L20
    L8:
        r111 = r101;
        goto L10
    }
}
