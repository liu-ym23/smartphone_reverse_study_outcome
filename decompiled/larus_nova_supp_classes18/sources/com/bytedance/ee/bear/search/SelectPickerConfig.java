package com.bytedance.ee.bear.search;

import com.ss.android.lark.picker.statistics.PickerStatistics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public static /* synthetic */ SelectPickerConfig copy$default(SelectPickerConfig r5, PickerStatistics.Scene r6, boolean r7, boolean r8, boolean r9, SelectWikiConfig r10, SelectTitleConfig r11, SelectTabConfig r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.scene;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.useDefaultClick;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.isEnableCancelBtn;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.useFilter;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.selectWikiConfig;
    L17:
        SelectWikiConfig r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.selectTitleConfig;
    L20:
        SelectTitleConfig r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.selectTabConfig;
    L23:
        PickerStatistics.Scene r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
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

    public final SelectPickerConfig copy(PickerStatistics.Scene r10, boolean r11, boolean r12, boolean r13, SelectWikiConfig r14, SelectTitleConfig r15, SelectTabConfig r16) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r14, "selectWikiConfig");
        Intrinsics.checkNotNullParameter(r15, "selectTitleConfig");
        Intrinsics.checkNotNullParameter(r16, "selectTabConfig");
        return new SelectPickerConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectPickerConfig) == true) goto L8;
        return false;
    L8:
        SelectPickerConfig r6 = (SelectPickerConfig) r5;
        if (this.scene == r6.scene) goto L12;
        return false;
    L12:
        if (this.useDefaultClick == r6.useDefaultClick) goto L15;
        return false;
    L15:
        if (this.isEnableCancelBtn == r6.isEnableCancelBtn) goto L18;
        return false;
    L18:
        if (this.useFilter == r6.useFilter) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectWikiConfig, r6.selectWikiConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectTitleConfig, r6.selectTitleConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectTabConfig, r6.selectTabConfig) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.scene.hashCode() * 31;
        int r2 = 1231;
        if (this.useDefaultClick == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isEnableCancelBtn == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.useFilter == true) goto L15;
        r2 = 1237;
    L15:
        return ((((((r5 + r2) * 31) + this.selectWikiConfig.hashCode()) * 31) + this.selectTitleConfig.hashCode()) * 31) + this.selectTabConfig.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
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

    public final void setScene(PickerStatistics.Scene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public final void setSelectTabConfig(SelectTabConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectTabConfig = r2;
    }

    public final void setSelectTitleConfig(SelectTitleConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectTitleConfig = r2;
    }

    public final void setSelectWikiConfig(SelectWikiConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectWikiConfig = r2;
    }

    public SelectPickerConfig(PickerStatistics.Scene r2, boolean r3, boolean r4, boolean r5, SelectWikiConfig r6, SelectTitleConfig r7, SelectTabConfig r8) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r6, "selectWikiConfig");
        Intrinsics.checkNotNullParameter(r7, "selectTitleConfig");
        Intrinsics.checkNotNullParameter(r8, "selectTabConfig");
        this.scene = r2;
        this.useDefaultClick = r3;
        this.isEnableCancelBtn = r4;
        this.useFilter = r5;
        this.selectWikiConfig = r6;
        this.selectTitleConfig = r7;
        this.selectTabConfig = r8;
    }

    public /* synthetic */ SelectPickerConfig(PickerStatistics.Scene r6, boolean r7, boolean r8, boolean r9, SelectWikiConfig r10, SelectTitleConfig r11, SelectTabConfig r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = PickerStatistics.Scene.Unknown;
    L6:
        if ((r13 & 2) == 0) goto L8;
        boolean r15 = true;
    L10:
        if ((r13 & 4) == 0) goto L12;
        boolean r1 = true;
    L14:
        if ((r13 & 8) == 0) goto L16;
        boolean r2 = true;
    L18:
        if ((r13 & 16) == 0) goto L20;
        r10 = new SelectWikiConfig(false, 1, null);
    L20:
        SelectWikiConfig r0 = r10;
        if ((r13 & 32) == 0) goto L23;
        r11 = new SelectTitleConfig(false, null, 3, null);
    L23:
        SelectTitleConfig r3 = r11;
        if ((r13 & 64) == 0) goto L26;
        SelectTabConfig r4 = new SelectTabConfig(false, false, false, 7, null);
    L27:
        this(r6, r15, r1, r2, r0, r3, r4);
        return;
    L26:
        r4 = r12;
        goto L27
    L16:
        r2 = r9;
        goto L18
    L12:
        r1 = r8;
        goto L14
    L8:
        r15 = r7;
        goto L10
    }
}
