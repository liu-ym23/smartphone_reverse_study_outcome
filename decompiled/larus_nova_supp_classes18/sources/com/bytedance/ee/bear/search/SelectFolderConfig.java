package com.bytedance.ee.bear.search;

import com.ss.android.lark.picker.statistics.PickerStatistics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public static /* synthetic */ SelectFolderConfig copy$default(SelectFolderConfig r3, PickerStatistics.Scene r4, boolean r5, String r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.scene;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.useDefaultClick;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.titleName;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isMultipleSelect;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isEnableMulti2Single;
    L17:
        PickerStatistics.Scene r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
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

    public final SelectFolderConfig copy(PickerStatistics.Scene r8, boolean r9, String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r10, "titleName");
        return new SelectFolderConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectFolderConfig) == true) goto L8;
        return false;
    L8:
        SelectFolderConfig r6 = (SelectFolderConfig) r5;
        if (this.scene == r6.scene) goto L12;
        return false;
    L12:
        if (this.useDefaultClick == r6.useDefaultClick) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.titleName, r6.titleName) == true) goto L18;
        return false;
    L18:
        if (this.isMultipleSelect == r6.isMultipleSelect) goto L21;
        return false;
    L21:
        if (this.isEnableMulti2Single == r6.isEnableMulti2Single) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.scene.hashCode() * 31;
        int r2 = 1231;
        if (this.useDefaultClick == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.titleName.hashCode()) * 31;
        if (this.isMultipleSelect == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.isEnableMulti2Single == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
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

    public final void setScene(PickerStatistics.Scene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public SelectFolderConfig(PickerStatistics.Scene r2, boolean r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "titleName");
        this.scene = r2;
        this.useDefaultClick = r3;
        this.titleName = r4;
        this.isMultipleSelect = r5;
        this.isEnableMulti2Single = r6;
    }

    public /* synthetic */ SelectFolderConfig(PickerStatistics.Scene r4, boolean r5, String r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = PickerStatistics.Scene.Unknown;
    L5:
        boolean r0 = true;
        if ((r9 & 2) == 0) goto L8;
        boolean r11 = true;
    L10:
        if ((r9 & 4) == 0) goto L12;
        r6 = "";
    L12:
        String r1 = r6;
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        boolean r2 = false;
    L20:
        this(r4, r11, r1, r0, r2);
        return;
    L19:
        r2 = r8;
        goto L20
    L8:
        r11 = r5;
        goto L10
    }
}
