package com.larus.business.markdown.api.model;

import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b>\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010@\u001a\u00020\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u001aHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0084\u0002\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00032\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0005HÖ\u0001J\t\u0010W\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b7\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b8\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b;\u0010\u001f¨\u0006X"}, d2 = {"Lcom/larus/business/markdown/api/model/TableConfig;", "", "enableTableHeader", "", "tableTitleBgColor", "", "tableTextSize", "", "tableBorderWidth", "tableBorderColor", "tableTextColor", "bottomRoundCornerRadius", "topRoundCornerRadius", "tableWidth", "cellMaxWidth", "cellVerticalPadding", "cellHorizontalPadding", "tableTitle", "", "tableTitleSize", "enableCopyButton", "copyExcelStyle", "enableDownloadButton", "enableFullScreenButton", "enableTableWidthMatchParent", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "tableOddRowBackgroundColor", "tableHeaderRowBackgroundColor", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomRoundCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCellHorizontalPadding", "getCellMaxWidth", "getCellVerticalPadding", "getCopyExcelStyle", "()Z", "getEnableCopyButton", "getEnableDownloadButton", "getEnableFullScreenButton", "getEnableTableHeader", "getEnableTableWidthMatchParent", "getTableBorderColor", "getTableBorderWidth", "getTableHeaderRowBackgroundColor", "getTableOddRowBackgroundColor", "getTableTextColor", "getTableTextSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTableTitle", "()Ljava/lang/String;", "getTableTitleBgColor", "()I", "getTableTitleSize", "getTableWidth", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "getTopRoundCornerRadius", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/TableConfig;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableConfig {
    private final Integer bottomRoundCornerRadius;
    private final Integer cellHorizontalPadding;
    private final Integer cellMaxWidth;
    private final Integer cellVerticalPadding;
    private final boolean copyExcelStyle;
    private final boolean enableCopyButton;
    private final boolean enableDownloadButton;
    private final boolean enableFullScreenButton;
    private final boolean enableTableHeader;
    private final boolean enableTableWidthMatchParent;
    private final Integer tableBorderColor;
    private final Integer tableBorderWidth;
    private final Integer tableHeaderRowBackgroundColor;
    private final Integer tableOddRowBackgroundColor;
    private final Integer tableTextColor;
    private final Float tableTextSize;
    private final String tableTitle;
    private final int tableTitleBgColor;
    private final Integer tableTitleSize;
    private final Integer tableWidth;
    private final TitleStyle titleStyle;
    private final Integer topRoundCornerRadius;

    public TableConfig() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, false, null, null, null, 4194303, null);
    }

    public static /* synthetic */ TableConfig copy$default(TableConfig r110, boolean r111, int r112, Float r210, Integer r211, Integer r212, Integer r213, Integer r214, Integer r215, Integer r216, Integer r217, Integer r218, Integer r219, String r310, Integer r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, TitleStyle r317, Integer r318, Integer r319, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        boolean r100 = r110.enableTableHeader;
    L7:
        if ((r410 & 2) == 0) goto L9;
        int r101 = r110.tableTitleBgColor;
    L11:
        if ((r410 & 4) == 0) goto L13;
        Float r102 = r110.tableTextSize;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Integer r103 = r110.tableBorderWidth;
    L19:
        if ((r410 & 16) == 0) goto L21;
        Integer r104 = r110.tableBorderColor;
    L23:
        if ((r410 & 32) == 0) goto L25;
        Integer r105 = r110.tableTextColor;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Integer r106 = r110.bottomRoundCornerRadius;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Integer r107 = r110.topRoundCornerRadius;
    L35:
        if ((r410 & 256) == 0) goto L37;
        Integer r113 = r110.tableWidth;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Integer r114 = r110.cellMaxWidth;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Integer r115 = r110.cellVerticalPadding;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Integer r116 = r110.cellHorizontalPadding;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r117 = r110.tableTitle;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        Integer r118 = r110.tableTitleSize;
    L58:
        Integer r320 = r118;
        if ((r410 & 16384) == 0) goto L61;
        boolean r119 = r110.enableCopyButton;
    L62:
        boolean r321 = r119;
        if ((r410 & 32768) == 0) goto L65;
        boolean r120 = r110.copyExcelStyle;
    L66:
        boolean r322 = r120;
        if ((r410 & 65536) == 0) goto L69;
        boolean r121 = r110.enableDownloadButton;
    L70:
        boolean r323 = r121;
        if ((r410 & 131072) == 0) goto L73;
        boolean r122 = r110.enableFullScreenButton;
    L74:
        boolean r324 = r122;
        if ((r410 & 262144) == 0) goto L77;
        boolean r123 = r110.enableTableWidthMatchParent;
    L78:
        boolean r325 = r123;
        if ((r410 & 524288) == 0) goto L81;
        TitleStyle r124 = r110.titleStyle;
    L82:
        TitleStyle r326 = r124;
        if ((r410 & 1048576) == 0) goto L85;
        Integer r125 = r110.tableOddRowBackgroundColor;
    L87:
        if ((r410 & 2097152) == 0) goto L89;
        Integer r108 = r110.tableHeaderRowBackgroundColor;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r125, r108);
    L89:
        r108 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.enableTableHeader;
    }

    public final Integer component10() {
        return this.cellMaxWidth;
    }

    public final Integer component11() {
        return this.cellVerticalPadding;
    }

    public final Integer component12() {
        return this.cellHorizontalPadding;
    }

    public final String component13() {
        return this.tableTitle;
    }

    public final Integer component14() {
        return this.tableTitleSize;
    }

    public final boolean component15() {
        return this.enableCopyButton;
    }

    public final boolean component16() {
        return this.copyExcelStyle;
    }

    public final boolean component17() {
        return this.enableDownloadButton;
    }

    public final boolean component18() {
        return this.enableFullScreenButton;
    }

    public final boolean component19() {
        return this.enableTableWidthMatchParent;
    }

    public final int component2() {
        return this.tableTitleBgColor;
    }

    public final TitleStyle component20() {
        return this.titleStyle;
    }

    public final Integer component21() {
        return this.tableOddRowBackgroundColor;
    }

    public final Integer component22() {
        return this.tableHeaderRowBackgroundColor;
    }

    public final Float component3() {
        return this.tableTextSize;
    }

    public final Integer component4() {
        return this.tableBorderWidth;
    }

    public final Integer component5() {
        return this.tableBorderColor;
    }

    public final Integer component6() {
        return this.tableTextColor;
    }

    public final Integer component7() {
        return this.bottomRoundCornerRadius;
    }

    public final Integer component8() {
        return this.topRoundCornerRadius;
    }

    public final Integer component9() {
        return this.tableWidth;
    }

    public final TableConfig copy(boolean r210, int r211, Float r212, Integer r213, Integer r214, Integer r310, Integer r311, Integer r312, Integer r313, Integer r314, Integer r315, Integer r316, String r317, Integer r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, TitleStyle r414, Integer r415, Integer r416) {
        Intrinsics.checkNotNullParameter(r317, "tableTitle");
        Intrinsics.checkNotNullParameter(r414, "titleStyle");
        return new TableConfig(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TableConfig) == true) goto L8;
        return false;
    L8:
        TableConfig r101 = (TableConfig) r100;
        if (this.enableTableHeader == r101.enableTableHeader) goto L12;
        return false;
    L12:
        if (this.tableTitleBgColor == r101.tableTitleBgColor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tableTextSize, r101.tableTextSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tableBorderWidth, r101.tableBorderWidth) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tableBorderColor, r101.tableBorderColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tableTextColor, r101.tableTextColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bottomRoundCornerRadius, r101.bottomRoundCornerRadius) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topRoundCornerRadius, r101.topRoundCornerRadius) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tableWidth, r101.tableWidth) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cellMaxWidth, r101.cellMaxWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cellVerticalPadding, r101.cellVerticalPadding) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.cellHorizontalPadding, r101.cellHorizontalPadding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tableTitle, r101.tableTitle) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tableTitleSize, r101.tableTitleSize) == true) goto L51;
        return false;
    L51:
        if (this.enableCopyButton == r101.enableCopyButton) goto L54;
        return false;
    L54:
        if (this.copyExcelStyle == r101.copyExcelStyle) goto L57;
        return false;
    L57:
        if (this.enableDownloadButton == r101.enableDownloadButton) goto L60;
        return false;
    L60:
        if (this.enableFullScreenButton == r101.enableFullScreenButton) goto L63;
        return false;
    L63:
        if (this.enableTableWidthMatchParent == r101.enableTableWidthMatchParent) goto L66;
        return false;
    L66:
        if (this.titleStyle == r101.titleStyle) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.tableOddRowBackgroundColor, r101.tableOddRowBackgroundColor) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.tableHeaderRowBackgroundColor, r101.tableHeaderRowBackgroundColor) == true) goto L74;
        return false;
    L74:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    public int hashCode() {
        boolean r100 = this.enableTableHeader;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.tableTitleBgColor) * 31;
        Float r104 = this.tableTextSize;
        int r105 = 0;
        if (r104 != null) goto L8;
        int r106 = 0;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.tableBorderWidth;
        if (r108 != null) goto L12;
        int r109 = 0;
    L13:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.tableBorderColor;
        if (r111 != null) goto L16;
        int r112 = 0;
    L17:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.tableTextColor;
        if (r114 != null) goto L20;
        int r115 = 0;
    L21:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.bottomRoundCornerRadius;
        if (r117 != null) goto L24;
        int r118 = 0;
    L25:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.topRoundCornerRadius;
        if (r120 != null) goto L28;
        int r121 = 0;
    L29:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.tableWidth;
        if (r123 != null) goto L32;
        int r124 = 0;
    L33:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.cellMaxWidth;
        if (r126 != null) goto L36;
        int r127 = 0;
    L37:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.cellVerticalPadding;
        if (r129 != null) goto L40;
        int r130 = 0;
    L41:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.cellHorizontalPadding;
        if (r132 != null) goto L44;
        int r133 = 0;
    L45:
        int r134 = (((r131 + r133) * 31) + this.tableTitle.hashCode()) * 31;
        Integer r135 = this.tableTitleSize;
        if (r135 != null) goto L48;
        int r136 = 0;
    L49:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.enableCopyButton;
        ?? r139 = r138;
        if (r138 == false) goto L52;
        r139 = 1;
    L52:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.copyExcelStyle;
        ?? r142 = r141;
        if (r141 == false) goto L55;
        r142 = 1;
    L55:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.enableDownloadButton;
        ?? r145 = r144;
        if (r144 == false) goto L58;
        r145 = 1;
    L58:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.enableFullScreenButton;
        ?? r148 = r147;
        if (r147 == false) goto L61;
        r148 = 1;
    L61:
        int r149 = (r146 + r148) * 31;
        boolean r150 = this.enableTableWidthMatchParent;
        if (r150 == true) goto L65;
        r101 = r150;
    L65:
        int r151 = (((r149 + r101) * 31) + this.titleStyle.hashCode()) * 31;
        Integer r152 = this.tableOddRowBackgroundColor;
        if (r152 != null) goto L68;
        int r153 = 0;
    L69:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.tableHeaderRowBackgroundColor;
        if (r155 == null) goto L74;
        r105 = r155.hashCode();
    L74:
        return r154 + r105;
    L68:
        r153 = r152.hashCode();
        goto L69
    L48:
        r136 = r135.hashCode();
        goto L49
    L44:
        r133 = r132.hashCode();
        goto L45
    L40:
        r130 = r129.hashCode();
        goto L41
    L36:
        r127 = r126.hashCode();
        goto L37
    L32:
        r124 = r123.hashCode();
        goto L33
    L28:
        r121 = r120.hashCode();
        goto L29
    L24:
        r118 = r117.hashCode();
        goto L25
    L20:
        r115 = r114.hashCode();
        goto L21
    L16:
        r112 = r111.hashCode();
        goto L17
    L12:
        r109 = r108.hashCode();
        goto L13
    L8:
        r106 = r104.hashCode();
        goto L9
    }

    public String toString() {
        return "TableConfig(enableTableHeader=" + this.enableTableHeader + ", tableTitleBgColor=" + this.tableTitleBgColor + ", tableTextSize=" + this.tableTextSize + ", tableBorderWidth=" + this.tableBorderWidth + ", tableBorderColor=" + this.tableBorderColor + ", tableTextColor=" + this.tableTextColor + ", bottomRoundCornerRadius=" + this.bottomRoundCornerRadius + ", topRoundCornerRadius=" + this.topRoundCornerRadius + ", tableWidth=" + this.tableWidth + ", cellMaxWidth=" + this.cellMaxWidth + ", cellVerticalPadding=" + this.cellVerticalPadding + ", cellHorizontalPadding=" + this.cellHorizontalPadding + ", tableTitle=" + this.tableTitle + ", tableTitleSize=" + this.tableTitleSize + ", enableCopyButton=" + this.enableCopyButton + ", copyExcelStyle=" + this.copyExcelStyle + ", enableDownloadButton=" + this.enableDownloadButton + ", enableFullScreenButton=" + this.enableFullScreenButton + ", enableTableWidthMatchParent=" + this.enableTableWidthMatchParent + ", titleStyle=" + this.titleStyle + ", tableOddRowBackgroundColor=" + this.tableOddRowBackgroundColor + ", tableHeaderRowBackgroundColor=" + this.tableHeaderRowBackgroundColor + ')';
    }

    public final Integer getBottomRoundCornerRadius() {
        return this.bottomRoundCornerRadius;
    }

    public final Integer getCellHorizontalPadding() {
        return this.cellHorizontalPadding;
    }

    public final Integer getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    public final Integer getCellVerticalPadding() {
        return this.cellVerticalPadding;
    }

    public final boolean getCopyExcelStyle() {
        return this.copyExcelStyle;
    }

    public final boolean getEnableCopyButton() {
        return this.enableCopyButton;
    }

    public final boolean getEnableDownloadButton() {
        return this.enableDownloadButton;
    }

    public final boolean getEnableFullScreenButton() {
        return this.enableFullScreenButton;
    }

    public final boolean getEnableTableHeader() {
        return this.enableTableHeader;
    }

    public final boolean getEnableTableWidthMatchParent() {
        return this.enableTableWidthMatchParent;
    }

    public final Integer getTableBorderColor() {
        return this.tableBorderColor;
    }

    public final Integer getTableBorderWidth() {
        return this.tableBorderWidth;
    }

    public final Integer getTableHeaderRowBackgroundColor() {
        return this.tableHeaderRowBackgroundColor;
    }

    public final Integer getTableOddRowBackgroundColor() {
        return this.tableOddRowBackgroundColor;
    }

    public final Integer getTableTextColor() {
        return this.tableTextColor;
    }

    public final Float getTableTextSize() {
        return this.tableTextSize;
    }

    public final String getTableTitle() {
        return this.tableTitle;
    }

    public final int getTableTitleBgColor() {
        return this.tableTitleBgColor;
    }

    public final Integer getTableTitleSize() {
        return this.tableTitleSize;
    }

    public final Integer getTableWidth() {
        return this.tableWidth;
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final Integer getTopRoundCornerRadius() {
        return this.topRoundCornerRadius;
    }

    public TableConfig(boolean r100, int r101, Float r102, Integer r103, Integer r104, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, String r117, Integer r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213, TitleStyle r214, Integer r215, Integer r216) {
        Intrinsics.checkNotNullParameter(r117, "tableTitle");
        Intrinsics.checkNotNullParameter(r214, "titleStyle");
        this.enableTableHeader = r100;
        this.tableTitleBgColor = r101;
        this.tableTextSize = r102;
        this.tableBorderWidth = r103;
        this.tableBorderColor = r104;
        this.tableTextColor = r110;
        this.bottomRoundCornerRadius = r111;
        this.topRoundCornerRadius = r112;
        this.tableWidth = r113;
        this.cellMaxWidth = r114;
        this.cellVerticalPadding = r115;
        this.cellHorizontalPadding = r116;
        this.tableTitle = r117;
        this.tableTitleSize = r118;
        this.enableCopyButton = r119;
        this.copyExcelStyle = r210;
        this.enableDownloadButton = r211;
        this.enableFullScreenButton = r212;
        this.enableTableWidthMatchParent = r213;
        this.titleStyle = r214;
        this.tableOddRowBackgroundColor = r215;
        this.tableHeaderRowBackgroundColor = r216;
    }

    public /* synthetic */ TableConfig(boolean r210, int r211, Float r212, Integer r213, Integer r214, Integer r215, Integer r310, Integer r311, Integer r312, Integer r313, Integer r314, Integer r315, String r316, Integer r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, TitleStyle r413, Integer r414, Integer r415, int r416, DefaultConstructorMarker r417) {
        if ((r416 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r416 & 2) == 0) goto L9;
        int r101 = FakePickerAvatarCreator.GRAY;
    L11:
        if ((r416 & 4) == 0) goto L13;
        Float r102 = null;
    L15:
        if ((r416 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r416 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r416 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r416 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r416 & 256) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r416 & 512) == 0) goto L41;
        Integer r112 = null;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        Integer r114 = null;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r416 & 8192) == 0) goto L57;
        Integer r107 = null;
    L59:
        if ((r416 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r416 & 32768) == 0) goto L65;
        boolean r116 = false;
    L66:
        boolean r117 = true;
        if ((r416 & 65536) == 0) goto L69;
        boolean r118 = true;
    L71:
        if ((r416 & 131072) == 0) goto L73;
        boolean r119 = false;
    L75:
        if ((r416 & 262144) != 0) goto L79;
        r117 = r412;
    L79:
        if ((r416 & 524288) == 0) goto L81;
        TitleStyle r216 = TitleStyle.LARGE;
    L83:
        if ((r416 & 1048576) == 0) goto L85;
        Integer r217 = null;
    L87:
        if ((r416 & 2097152) == 0) goto L89;
        Integer r109 = null;
    L90:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r118, r119, r117, r216, r217, r109);
        return;
    L89:
        r109 = r415;
        goto L90
    L85:
        r217 = r414;
        goto L87
    L81:
        r216 = r413;
        goto L83
    L73:
        r119 = r411;
        goto L75
    L69:
        r118 = r410;
        goto L71
    L65:
        r116 = r319;
        goto L66
    L61:
        r108 = r318;
        goto L63
    L57:
        r107 = r317;
        goto L59
    L53:
        r115 = r316;
        goto L55
    L49:
        r114 = r315;
        goto L51
    L45:
        r113 = r314;
        goto L47
    L41:
        r112 = r313;
        goto L43
    L37:
        r111 = r312;
        goto L39
    L33:
        r110 = r311;
        goto L35
    L29:
        r106 = r310;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
