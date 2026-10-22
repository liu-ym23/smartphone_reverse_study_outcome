package com.bytedance.ee.bear.search;

import com.ss.android.lark.picker.statistics.PickerStatistics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003JO\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/search/SelectPickerConfig;", "Ljava/io/Serializable;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "useDefaultClick", "", "isEnableCancelBtn", "useFilter", "selectWikiConfig", "Lcom/bytedance/ee/bear/search/SelectWikiConfig;", "selectTitleConfig", "Lcom/bytedance/ee/bear/search/SelectTitleConfig;", "selectTabConfig", "Lcom/bytedance/ee/bear/search/SelectTabConfig;", "<init>", "(Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;ZZZLcom/bytedance/ee/bear/search/SelectWikiConfig;Lcom/bytedance/ee/bear/search/SelectTitleConfig;Lcom/bytedance/ee/bear/search/SelectTabConfig;)V", "getScene", "()Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "setScene", "(Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;)V", "getUseDefaultClick", "()Z", "getUseFilter", "getSelectWikiConfig", "()Lcom/bytedance/ee/bear/search/SelectWikiConfig;", "setSelectWikiConfig", "(Lcom/bytedance/ee/bear/search/SelectWikiConfig;)V", "getSelectTitleConfig", "()Lcom/bytedance/ee/bear/search/SelectTitleConfig;", "setSelectTitleConfig", "(Lcom/bytedance/ee/bear/search/SelectTitleConfig;)V", "getSelectTabConfig", "()Lcom/bytedance/ee/bear/search/SelectTabConfig;", "setSelectTabConfig", "(Lcom/bytedance/ee/bear/search/SelectTabConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "contentmanager-search-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectPickerConfig implements Serializable {
    private final boolean isEnableCancelBtn;
    private PickerStatistics.Scene scene;
    private SelectTabConfig selectTabConfig;
    private SelectTitleConfig selectTitleConfig;
    private SelectWikiConfig selectWikiConfig;
    private final boolean useDefaultClick;
    private final boolean useFilter;

    public SelectPickerConfig() {
        this(null, false, false, false, null, null, null, 127, null);
    }

    public static /* synthetic */ SelectPickerConfig copy$default(SelectPickerConfig r100, PickerStatistics.Scene r101, boolean r102, boolean r103, boolean r104, SelectWikiConfig r110, SelectTitleConfig r111, SelectTabConfig r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.useDefaultClick;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.isEnableCancelBtn;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.useFilter;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.selectWikiConfig;
    L17:
        SelectWikiConfig r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.selectTitleConfig;
    L20:
        SelectTitleConfig r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.selectTabConfig;
    L23:
        PickerStatistics.Scene r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final PickerStatistics.Scene component1() {
        return this.scene;
    }

    public final boolean component2() {
        return this.useDefaultClick;
    }

    public final boolean component3() {
        return this.isEnableCancelBtn;
    }

    public final boolean component4() {
        return this.useFilter;
    }

    public final SelectWikiConfig component5() {
        return this.selectWikiConfig;
    }

    public final SelectTitleConfig component6() {
        return this.selectTitleConfig;
    }

    public final SelectTabConfig component7() {
        return this.selectTabConfig;
    }

    public final SelectPickerConfig copy(PickerStatistics.Scene r110, boolean r111, boolean r112, boolean r113, SelectWikiConfig r114, SelectTitleConfig r115, SelectTabConfig r116) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r114, "selectWikiConfig");
        Intrinsics.checkNotNullParameter(r115, "selectTitleConfig");
        Intrinsics.checkNotNullParameter(r116, "selectTabConfig");
        return new SelectPickerConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectPickerConfig) == true) goto L8;
        return false;
    L8:
        SelectPickerConfig r101 = (SelectPickerConfig) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (this.useDefaultClick == r101.useDefaultClick) goto L15;
        return false;
    L15:
        if (this.isEnableCancelBtn == r101.isEnableCancelBtn) goto L18;
        return false;
    L18:
        if (this.useFilter == r101.useFilter) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectWikiConfig, r101.selectWikiConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectTitleConfig, r101.selectTitleConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectTabConfig, r101.selectTabConfig) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.scene.hashCode() * 31;
        int r101 = 1231;
        if (this.useDefaultClick == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isEnableCancelBtn == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.useFilter == true) goto L15;
        r101 = 1237;
    L15:
        return ((((((r105 + r101) * 31) + this.selectWikiConfig.hashCode()) * 31) + this.selectTitleConfig.hashCode()) * 31) + this.selectTabConfig.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "SelectPickerConfig(scene=" + this.scene + ", useDefaultClick=" + this.useDefaultClick + ", isEnableCancelBtn=" + this.isEnableCancelBtn + ", useFilter=" + this.useFilter + ", selectWikiConfig=" + this.selectWikiConfig + ", selectTitleConfig=" + this.selectTitleConfig + ", selectTabConfig=" + this.selectTabConfig + ')';
    }

    public final PickerStatistics.Scene getScene() {
        return this.scene;
    }

    public final SelectTabConfig getSelectTabConfig() {
        return this.selectTabConfig;
    }

    public final SelectTitleConfig getSelectTitleConfig() {
        return this.selectTitleConfig;
    }

    public final SelectWikiConfig getSelectWikiConfig() {
        return this.selectWikiConfig;
    }

    public final boolean getUseDefaultClick() {
        return this.useDefaultClick;
    }

    public final boolean getUseFilter() {
        return this.useFilter;
    }

    public final boolean isEnableCancelBtn() {
        return this.isEnableCancelBtn;
    }

    public final void setScene(PickerStatistics.Scene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setSelectTabConfig(SelectTabConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectTabConfig = r100;
    }

    public final void setSelectTitleConfig(SelectTitleConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectTitleConfig = r100;
    }

    public final void setSelectWikiConfig(SelectWikiConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectWikiConfig = r100;
    }

    public SelectPickerConfig(PickerStatistics.Scene r100, boolean r101, boolean r102, boolean r103, SelectWikiConfig r104, SelectTitleConfig r105, SelectTabConfig r106) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r104, "selectWikiConfig");
        Intrinsics.checkNotNullParameter(r105, "selectTitleConfig");
        Intrinsics.checkNotNullParameter(r106, "selectTabConfig");
        this.scene = r100;
        this.useDefaultClick = r101;
        this.isEnableCancelBtn = r102;
        this.useFilter = r103;
        this.selectWikiConfig = r104;
        this.selectTitleConfig = r105;
        this.selectTabConfig = r106;
    }

    public /* synthetic */ SelectPickerConfig(PickerStatistics.Scene r100, boolean r101, boolean r102, boolean r103, SelectWikiConfig r110, SelectTitleConfig r111, SelectTabConfig r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = PickerStatistics.Scene.Unknown;
    L6:
        if ((r113 & 2) == 0) goto L8;
        boolean r115 = true;
    L10:
        if ((r113 & 4) == 0) goto L12;
        boolean r104 = true;
    L14:
        if ((r113 & 8) == 0) goto L16;
        boolean r105 = true;
    L18:
        if ((r113 & 16) == 0) goto L20;
        r110 = new SelectWikiConfig(false, 1, null);
    L20:
        SelectWikiConfig r106 = r110;
        if ((r113 & 32) == 0) goto L23;
        r111 = new SelectTitleConfig(false, null, 3, null);
    L23:
        SelectTitleConfig r107 = r111;
        if ((r113 & 64) == 0) goto L26;
        SelectTabConfig r108 = new SelectTabConfig(false, false, false, 7, null);
    L27:
        this(r100, r115, r104, r105, r106, r107, r108);
        return;
    L26:
        r108 = r112;
        goto L27
    L16:
        r105 = r103;
        goto L18
    L12:
        r104 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
