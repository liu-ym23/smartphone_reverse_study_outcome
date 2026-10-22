package com.larus.canvas.service.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0003J\u0086\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 ¨\u00064"}, d2 = {"Lcom/larus/canvas/service/bean/InstructionTab;", "", "tabLabel", "", "tabName", "tabType", "", "extra", "Lcom/larus/canvas/service/bean/TabExtra;", "icon", "Lcom/larus/canvas/service/bean/Icon;", "darkModeIcon", "optionList", "", "Lcom/larus/canvas/service/bean/OptionItem;", "singleOption", "featureOptionPanelList", "Lcom/larus/canvas/service/bean/FeatureOptionPanelItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/TabExtra;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Ljava/util/List;Lcom/larus/canvas/service/bean/OptionItem;Ljava/util/List;)V", "getTabLabel", "()Ljava/lang/String;", "getTabName", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtra", "()Lcom/larus/canvas/service/bean/TabExtra;", "getIcon", "()Lcom/larus/canvas/service/bean/Icon;", "getDarkModeIcon", "getOptionList", "()Ljava/util/List;", "getSingleOption", "()Lcom/larus/canvas/service/bean/OptionItem;", "getFeatureOptionPanelList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/TabExtra;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Ljava/util/List;Lcom/larus/canvas/service/bean/OptionItem;Ljava/util/List;)Lcom/larus/canvas/service/bean/InstructionTab;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionTab {

    @SerializedName("dark_mode_icon")
    private final Icon darkModeIcon;

    @SerializedName("extra")
    private final TabExtra extra;

    @SerializedName("feature_option_panel_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FeatureOptionPanelItem> featureOptionPanelList;

    @SerializedName("icon")
    private final Icon icon;

    @SerializedName("option_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OptionItem> optionList;

    @SerializedName("single_option")
    private final OptionItem singleOption;

    @SerializedName("tab_label")
    private final String tabLabel;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("tab_type")
    private final Integer tabType;

    public InstructionTab() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstructionTab copy$default(InstructionTab r110, String r111, String r112, Integer r113, TabExtra r114, Icon r115, Icon r116, List r117, OptionItem r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.tabLabel;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.tabName;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.tabType;
    L15:
        if ((r210 & 8) == 0) goto L17;
        TabExtra r103 = r110.extra;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Icon r104 = r110.icon;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Icon r105 = r110.darkModeIcon;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.optionList;
    L31:
        if ((r210 & 128) == 0) goto L33;
        OptionItem r107 = r110.singleOption;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.featureOptionPanelList;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.tabLabel;
    }

    public final String component2() {
        return this.tabName;
    }

    public final Integer component3() {
        return this.tabType;
    }

    public final TabExtra component4() {
        return this.extra;
    }

    public final Icon component5() {
        return this.icon;
    }

    public final Icon component6() {
        return this.darkModeIcon;
    }

    public final List<OptionItem> component7() {
        return this.optionList;
    }

    public final OptionItem component8() {
        return this.singleOption;
    }

    public final List<FeatureOptionPanelItem> component9() {
        return this.featureOptionPanelList;
    }

    public final InstructionTab copy(String r110, String r111, Integer r112, TabExtra r113, Icon r114, Icon r115, List<OptionItem> r116, OptionItem r117, List<FeatureOptionPanelItem> r210) {
        return new InstructionTab(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InstructionTab) == true) goto L8;
        return false;
    L8:
        InstructionTab r101 = (InstructionTab) r100;
        if (Intrinsics.areEqual(this.tabLabel, r101.tabLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.optionList, r101.optionList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.singleOption, r101.singleOption) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.featureOptionPanelList, r101.featureOptionPanelList) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.tabLabel;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.tabType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TabExtra r110 = this.extra;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Icon r113 = this.icon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Icon r116 = this.darkModeIcon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<OptionItem> r119 = this.optionList;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        OptionItem r122 = this.singleOption;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<FeatureOptionPanelItem> r125 = this.featureOptionPanelList;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "InstructionTab(tabLabel=" + this.tabLabel + ", tabName=" + this.tabName + ", tabType=" + this.tabType + ", extra=" + this.extra + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", optionList=" + this.optionList + ", singleOption=" + this.singleOption + ", featureOptionPanelList=" + this.featureOptionPanelList + ')';
    }

    public final Icon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final TabExtra getExtra() {
        return this.extra;
    }

    public final List<FeatureOptionPanelItem> getFeatureOptionPanelList() {
        return this.featureOptionPanelList;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final List<OptionItem> getOptionList() {
        return this.optionList;
    }

    public final OptionItem getSingleOption() {
        return this.singleOption;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public InstructionTab(String r100, String r101, Integer r102, TabExtra r103, Icon r104, Icon r105, List<OptionItem> r106, OptionItem r107, List<FeatureOptionPanelItem> r108) {
        this.tabLabel = r100;
        this.tabName = r101;
        this.tabType = r102;
        this.extra = r103;
        this.icon = r104;
        this.darkModeIcon = r105;
        this.optionList = r106;
        this.singleOption = r107;
        this.featureOptionPanelList = r108;
    }

    public /* synthetic */ InstructionTab(String r110, String r111, Integer r112, TabExtra r113, Icon r114, Icon r115, List r116, OptionItem r117, List r118, int r210, DefaultConstructorMarker r211) {
        List r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        TabExtra r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Icon r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Icon r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        OptionItem r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
