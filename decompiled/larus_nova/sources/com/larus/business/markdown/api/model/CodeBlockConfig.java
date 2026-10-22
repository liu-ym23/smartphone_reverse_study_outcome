package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bV\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J¶\u0002\u0010`\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u00062\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b'\u0010#R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b*\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u00105R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b@\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bA\u0010#R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bB\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006f"}, d2 = {"Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "", "cornerRadius", "", "titleBgColor", "enableTitleBottomLine", "", "titleBottomLineColor", "codeTitleSize", "codeContentSize", "enableCodeFullScreenButton", "codeCopyTitle", "", "enablePreviewButton", "enableCodeCopyButton", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "enableCodeHeader", "backgroundColor", "blockBackgroundColor", "codeTextColor", "blockMargin", "enableScroll", "enableLineNumber", "lineNumberColor", "enableBlockBackground", "codeBlockTextColor", "blockBorderColor", "blockBorderWidth", "enableSyntaxHighlight", "disableReplacementSpan", "enableCodeBlockStroke", "enableCodeBlockHeaderBackground", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockBackgroundColor", "getBlockBorderColor", "getBlockBorderWidth", "getBlockMargin", "getCodeBlockTextColor", "getCodeContentSize", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTextColor", "getCodeTitleSize", "()I", "getCornerRadius", "getDisableReplacementSpan", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableBlockBackground", "()Z", "getEnableCodeBlockHeaderBackground", "getEnableCodeBlockStroke", "getEnableCodeCopyButton", "getEnableCodeFullScreenButton", "getEnableCodeHeader", "getEnableLineNumber", "getEnablePreviewButton", "getEnableScroll", "getEnableSyntaxHighlight", "getEnableTitleBottomLine", "getLineNumberColor", "getTitleBgColor", "getTitleBottomLineColor", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeBlockConfig {
    private final Integer backgroundColor;
    private final Integer blockBackgroundColor;
    private final Integer blockBorderColor;
    private final Integer blockBorderWidth;
    private final Integer blockMargin;
    private final Integer codeBlockTextColor;
    private final Integer codeContentSize;
    private final String codeCopyTitle;
    private final Integer codeTextColor;
    private final int codeTitleSize;
    private final Integer cornerRadius;
    private final Boolean disableReplacementSpan;
    private final boolean enableBlockBackground;
    private final boolean enableCodeBlockHeaderBackground;
    private final boolean enableCodeBlockStroke;
    private final boolean enableCodeCopyButton;
    private final boolean enableCodeFullScreenButton;
    private final boolean enableCodeHeader;
    private final boolean enableLineNumber;
    private final boolean enablePreviewButton;
    private final boolean enableScroll;
    private final boolean enableSyntaxHighlight;
    private final boolean enableTitleBottomLine;
    private final Integer lineNumberColor;
    private final Integer titleBgColor;
    private final Integer titleBottomLineColor;
    private final TitleStyle titleStyle;

    public CodeBlockConfig() {
        this(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, false, false, 134217727, null);
    }

    public static /* synthetic */ CodeBlockConfig copy$default(CodeBlockConfig r110, Integer r111, Integer r112, boolean r210, Integer r211, int r212, Integer r213, boolean r214, String r215, boolean r216, boolean r217, TitleStyle r218, boolean r219, Integer r310, Integer r311, Integer r312, Integer r313, boolean r314, boolean r315, Integer r316, boolean r317, Integer r318, Integer r319, Integer r410, boolean r411, Boolean r412, boolean r413, boolean r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        Integer r100 = r110.cornerRadius;
    L7:
        if ((r415 & 2) == 0) goto L9;
        Integer r101 = r110.titleBgColor;
    L11:
        if ((r415 & 4) == 0) goto L13;
        boolean r102 = r110.enableTitleBottomLine;
    L15:
        if ((r415 & 8) == 0) goto L17;
        Integer r103 = r110.titleBottomLineColor;
    L19:
        if ((r415 & 16) == 0) goto L21;
        int r104 = r110.codeTitleSize;
    L23:
        if ((r415 & 32) == 0) goto L25;
        Integer r105 = r110.codeContentSize;
    L27:
        if ((r415 & 64) == 0) goto L29;
        boolean r106 = r110.enableCodeFullScreenButton;
    L31:
        if ((r415 & 128) == 0) goto L33;
        String r107 = r110.codeCopyTitle;
    L35:
        if ((r415 & 256) == 0) goto L37;
        boolean r113 = r110.enablePreviewButton;
    L39:
        if ((r415 & 512) == 0) goto L41;
        boolean r114 = r110.enableCodeCopyButton;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        TitleStyle r115 = r110.titleStyle;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        boolean r116 = r110.enableCodeHeader;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        Integer r117 = r110.backgroundColor;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        Integer r118 = r110.blockBackgroundColor;
    L58:
        Integer r320 = r118;
        if ((r415 & 16384) == 0) goto L61;
        Integer r119 = r110.codeTextColor;
    L62:
        Integer r321 = r119;
        if ((r415 & 32768) == 0) goto L65;
        Integer r120 = r110.blockMargin;
    L66:
        Integer r322 = r120;
        if ((r415 & 65536) == 0) goto L69;
        boolean r121 = r110.enableScroll;
    L70:
        boolean r323 = r121;
        if ((r415 & 131072) == 0) goto L73;
        boolean r122 = r110.enableLineNumber;
    L74:
        boolean r324 = r122;
        if ((r415 & 262144) == 0) goto L77;
        Integer r123 = r110.lineNumberColor;
    L78:
        Integer r325 = r123;
        if ((r415 & 524288) == 0) goto L81;
        boolean r124 = r110.enableBlockBackground;
    L82:
        boolean r326 = r124;
        if ((r415 & 1048576) == 0) goto L85;
        Integer r125 = r110.codeBlockTextColor;
    L86:
        Integer r327 = r125;
        if ((r415 & 2097152) == 0) goto L89;
        Integer r126 = r110.blockBorderColor;
    L90:
        Integer r328 = r126;
        if ((r415 & 4194304) == 0) goto L93;
        Integer r127 = r110.blockBorderWidth;
    L94:
        Integer r417 = r127;
        if ((r415 & 8388608) == 0) goto L97;
        boolean r128 = r110.enableSyntaxHighlight;
    L98:
        boolean r418 = r128;
        if ((r415 & 16777216) == 0) goto L101;
        Boolean r129 = r110.disableReplacementSpan;
    L102:
        Boolean r419 = r129;
        if ((r415 & 33554432) == 0) goto L105;
        boolean r130 = r110.enableCodeBlockStroke;
    L107:
        if ((r415 & 67108864) == 0) goto L109;
        boolean r108 = r110.enableCodeBlockHeaderBackground;
    L111:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r417, r418, r419, r130, r108);
    L109:
        r108 = r414;
        goto L111
    L105:
        r130 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
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

    public final Integer component1() {
        return this.cornerRadius;
    }

    public final boolean component10() {
        return this.enableCodeCopyButton;
    }

    public final TitleStyle component11() {
        return this.titleStyle;
    }

    public final boolean component12() {
        return this.enableCodeHeader;
    }

    public final Integer component13() {
        return this.backgroundColor;
    }

    public final Integer component14() {
        return this.blockBackgroundColor;
    }

    public final Integer component15() {
        return this.codeTextColor;
    }

    public final Integer component16() {
        return this.blockMargin;
    }

    public final boolean component17() {
        return this.enableScroll;
    }

    public final boolean component18() {
        return this.enableLineNumber;
    }

    public final Integer component19() {
        return this.lineNumberColor;
    }

    public final Integer component2() {
        return this.titleBgColor;
    }

    public final boolean component20() {
        return this.enableBlockBackground;
    }

    public final Integer component21() {
        return this.codeBlockTextColor;
    }

    public final Integer component22() {
        return this.blockBorderColor;
    }

    public final Integer component23() {
        return this.blockBorderWidth;
    }

    public final boolean component24() {
        return this.enableSyntaxHighlight;
    }

    public final Boolean component25() {
        return this.disableReplacementSpan;
    }

    public final boolean component26() {
        return this.enableCodeBlockStroke;
    }

    public final boolean component27() {
        return this.enableCodeBlockHeaderBackground;
    }

    public final boolean component3() {
        return this.enableTitleBottomLine;
    }

    public final Integer component4() {
        return this.titleBottomLineColor;
    }

    public final int component5() {
        return this.codeTitleSize;
    }

    public final Integer component6() {
        return this.codeContentSize;
    }

    public final boolean component7() {
        return this.enableCodeFullScreenButton;
    }

    public final String component8() {
        return this.codeCopyTitle;
    }

    public final boolean component9() {
        return this.enablePreviewButton;
    }

    public final CodeBlockConfig copy(Integer r310, Integer r311, boolean r312, Integer r313, int r314, Integer r315, boolean r316, String r317, boolean r318, boolean r319, TitleStyle r410, boolean r411, Integer r412, Integer r413, Integer r414, Integer r415, boolean r416, boolean r417, Integer r418, boolean r419, Integer r510, Integer r511, Integer r512, boolean r513, Boolean r514, boolean r515, boolean r516) {
        Intrinsics.checkNotNullParameter(r317, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r410, "titleStyle");
        return new CodeBlockConfig(r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockConfig) == true) goto L8;
        return false;
    L8:
        CodeBlockConfig r101 = (CodeBlockConfig) r100;
        if (Intrinsics.areEqual(this.cornerRadius, r101.cornerRadius) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleBgColor, r101.titleBgColor) == true) goto L15;
        return false;
    L15:
        if (this.enableTitleBottomLine == r101.enableTitleBottomLine) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleBottomLineColor, r101.titleBottomLineColor) == true) goto L21;
        return false;
    L21:
        if (this.codeTitleSize == r101.codeTitleSize) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.codeContentSize, r101.codeContentSize) == true) goto L27;
        return false;
    L27:
        if (this.enableCodeFullScreenButton == r101.enableCodeFullScreenButton) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.codeCopyTitle, r101.codeCopyTitle) == true) goto L33;
        return false;
    L33:
        if (this.enablePreviewButton == r101.enablePreviewButton) goto L36;
        return false;
    L36:
        if (this.enableCodeCopyButton == r101.enableCodeCopyButton) goto L39;
        return false;
    L39:
        if (this.titleStyle == r101.titleStyle) goto L42;
        return false;
    L42:
        if (this.enableCodeHeader == r101.enableCodeHeader) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.blockBackgroundColor, r101.blockBackgroundColor) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.codeTextColor, r101.codeTextColor) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.blockMargin, r101.blockMargin) == true) goto L57;
        return false;
    L57:
        if (this.enableScroll == r101.enableScroll) goto L60;
        return false;
    L60:
        if (this.enableLineNumber == r101.enableLineNumber) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.lineNumberColor, r101.lineNumberColor) == true) goto L66;
        return false;
    L66:
        if (this.enableBlockBackground == r101.enableBlockBackground) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.codeBlockTextColor, r101.codeBlockTextColor) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.blockBorderColor, r101.blockBorderColor) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.blockBorderWidth, r101.blockBorderWidth) == true) goto L78;
        return false;
    L78:
        if (this.enableSyntaxHighlight == r101.enableSyntaxHighlight) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.disableReplacementSpan, r101.disableReplacementSpan) == true) goto L84;
        return false;
    L84:
        if (this.enableCodeBlockStroke == r101.enableCodeBlockStroke) goto L87;
        return false;
    L87:
        if (this.enableCodeBlockHeaderBackground == r101.enableCodeBlockHeaderBackground) goto L89;
        return false;
    L89:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52, types: [int] */
    /* JADX WARN: Type inference failed for: r0v54, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer r100 = this.cornerRadius;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.titleBgColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enableTitleBottomLine;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        Integer r111 = this.titleBottomLineColor;
        if (r111 != null) goto L16;
        int r112 = 0;
    L17:
        int r113 = (((r110 + r112) * 31) + this.codeTitleSize) * 31;
        Integer r114 = this.codeContentSize;
        if (r114 != null) goto L20;
        int r115 = 0;
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.enableCodeFullScreenButton;
        ?? r118 = r117;
        if (r117 == false) goto L24;
        r118 = 1;
    L24:
        int r119 = (((r116 + r118) * 31) + this.codeCopyTitle.hashCode()) * 31;
        boolean r120 = this.enablePreviewButton;
        ?? r121 = r120;
        if (r120 == false) goto L27;
        r121 = 1;
    L27:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.enableCodeCopyButton;
        ?? r124 = r123;
        if (r123 == false) goto L30;
        r124 = 1;
    L30:
        int r125 = (((r122 + r124) * 31) + this.titleStyle.hashCode()) * 31;
        boolean r126 = this.enableCodeHeader;
        ?? r127 = r126;
        if (r126 == false) goto L33;
        r127 = 1;
    L33:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.backgroundColor;
        if (r129 != null) goto L36;
        int r130 = 0;
    L37:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.blockBackgroundColor;
        if (r132 != null) goto L40;
        int r133 = 0;
    L41:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.codeTextColor;
        if (r135 != null) goto L44;
        int r136 = 0;
    L45:
        int r137 = (r134 + r136) * 31;
        Integer r138 = this.blockMargin;
        if (r138 != null) goto L48;
        int r139 = 0;
    L49:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.enableScroll;
        ?? r142 = r141;
        if (r141 == false) goto L52;
        r142 = 1;
    L52:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.enableLineNumber;
        ?? r145 = r144;
        if (r144 == false) goto L55;
        r145 = 1;
    L55:
        int r146 = (r143 + r145) * 31;
        Integer r147 = this.lineNumberColor;
        if (r147 != null) goto L58;
        int r148 = 0;
    L59:
        int r149 = (r146 + r148) * 31;
        boolean r150 = this.enableBlockBackground;
        ?? r151 = r150;
        if (r150 == false) goto L62;
        r151 = 1;
    L62:
        int r152 = (r149 + r151) * 31;
        Integer r153 = this.codeBlockTextColor;
        if (r153 != null) goto L65;
        int r154 = 0;
    L66:
        int r155 = (r152 + r154) * 31;
        Integer r156 = this.blockBorderColor;
        if (r156 != null) goto L69;
        int r157 = 0;
    L70:
        int r158 = (r155 + r157) * 31;
        Integer r159 = this.blockBorderWidth;
        if (r159 != null) goto L73;
        int r160 = 0;
    L74:
        int r161 = (r158 + r160) * 31;
        boolean r162 = this.enableSyntaxHighlight;
        ?? r163 = r162;
        if (r162 == false) goto L77;
        r163 = 1;
    L77:
        int r164 = (r161 + r163) * 31;
        Boolean r165 = this.disableReplacementSpan;
        if (r165 == null) goto L81;
        r101 = r165.hashCode();
    L81:
        int r166 = (r164 + r101) * 31;
        boolean r167 = this.enableCodeBlockStroke;
        ?? r168 = r167;
        if (r167 == false) goto L84;
        r168 = 1;
    L84:
        int r169 = (r166 + r168) * 31;
        boolean r170 = this.enableCodeBlockHeaderBackground;
        if (r170 == true) goto L89;
        r108 = r170;
    L89:
        return r169 + r108;
    L73:
        r160 = r159.hashCode();
        goto L74
    L69:
        r157 = r156.hashCode();
        goto L70
    L65:
        r154 = r153.hashCode();
        goto L66
    L58:
        r148 = r147.hashCode();
        goto L59
    L48:
        r139 = r138.hashCode();
        goto L49
    L44:
        r136 = r135.hashCode();
        goto L45
    L40:
        r133 = r132.hashCode();
        goto L41
    L36:
        r130 = r129.hashCode();
        goto L37
    L20:
        r115 = r114.hashCode();
        goto L21
    L16:
        r112 = r111.hashCode();
        goto L17
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CodeBlockConfig(cornerRadius=" + this.cornerRadius + ", titleBgColor=" + this.titleBgColor + ", enableTitleBottomLine=" + this.enableTitleBottomLine + ", titleBottomLineColor=" + this.titleBottomLineColor + ", codeTitleSize=" + this.codeTitleSize + ", codeContentSize=" + this.codeContentSize + ", enableCodeFullScreenButton=" + this.enableCodeFullScreenButton + ", codeCopyTitle=" + this.codeCopyTitle + ", enablePreviewButton=" + this.enablePreviewButton + ", enableCodeCopyButton=" + this.enableCodeCopyButton + ", titleStyle=" + this.titleStyle + ", enableCodeHeader=" + this.enableCodeHeader + ", backgroundColor=" + this.backgroundColor + ", blockBackgroundColor=" + this.blockBackgroundColor + ", codeTextColor=" + this.codeTextColor + ", blockMargin=" + this.blockMargin + ", enableScroll=" + this.enableScroll + ", enableLineNumber=" + this.enableLineNumber + ", lineNumberColor=" + this.lineNumberColor + ", enableBlockBackground=" + this.enableBlockBackground + ", codeBlockTextColor=" + this.codeBlockTextColor + ", blockBorderColor=" + this.blockBorderColor + ", blockBorderWidth=" + this.blockBorderWidth + ", enableSyntaxHighlight=" + this.enableSyntaxHighlight + ", disableReplacementSpan=" + this.disableReplacementSpan + ", enableCodeBlockStroke=" + this.enableCodeBlockStroke + ", enableCodeBlockHeaderBackground=" + this.enableCodeBlockHeaderBackground + ')';
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Integer getBlockBackgroundColor() {
        return this.blockBackgroundColor;
    }

    public final Integer getBlockBorderColor() {
        return this.blockBorderColor;
    }

    public final Integer getBlockBorderWidth() {
        return this.blockBorderWidth;
    }

    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    public final Integer getCodeBlockTextColor() {
        return this.codeBlockTextColor;
    }

    public final Integer getCodeContentSize() {
        return this.codeContentSize;
    }

    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    public final Integer getCodeTextColor() {
        return this.codeTextColor;
    }

    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Boolean getDisableReplacementSpan() {
        return this.disableReplacementSpan;
    }

    public final boolean getEnableBlockBackground() {
        return this.enableBlockBackground;
    }

    public final boolean getEnableCodeBlockHeaderBackground() {
        return this.enableCodeBlockHeaderBackground;
    }

    public final boolean getEnableCodeBlockStroke() {
        return this.enableCodeBlockStroke;
    }

    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    public final boolean getEnableCodeFullScreenButton() {
        return this.enableCodeFullScreenButton;
    }

    public final boolean getEnableCodeHeader() {
        return this.enableCodeHeader;
    }

    public final boolean getEnableLineNumber() {
        return this.enableLineNumber;
    }

    public final boolean getEnablePreviewButton() {
        return this.enablePreviewButton;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final boolean getEnableSyntaxHighlight() {
        return this.enableSyntaxHighlight;
    }

    public final boolean getEnableTitleBottomLine() {
        return this.enableTitleBottomLine;
    }

    public final Integer getLineNumberColor() {
        return this.lineNumberColor;
    }

    public final Integer getTitleBgColor() {
        return this.titleBgColor;
    }

    public final Integer getTitleBottomLineColor() {
        return this.titleBottomLineColor;
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public CodeBlockConfig(Integer r100, Integer r101, boolean r102, Integer r103, int r104, Integer r110, boolean r111, String r112, boolean r113, boolean r114, TitleStyle r115, boolean r116, Integer r117, Integer r118, Integer r119, Integer r210, boolean r211, boolean r212, Integer r213, boolean r214, Integer r215, Integer r216, Integer r217, boolean r218, Boolean r219, boolean r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r112, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r115, "titleStyle");
        this.cornerRadius = r100;
        this.titleBgColor = r101;
        this.enableTitleBottomLine = r102;
        this.titleBottomLineColor = r103;
        this.codeTitleSize = r104;
        this.codeContentSize = r110;
        this.enableCodeFullScreenButton = r111;
        this.codeCopyTitle = r112;
        this.enablePreviewButton = r113;
        this.enableCodeCopyButton = r114;
        this.titleStyle = r115;
        this.enableCodeHeader = r116;
        this.backgroundColor = r117;
        this.blockBackgroundColor = r118;
        this.codeTextColor = r119;
        this.blockMargin = r210;
        this.enableScroll = r211;
        this.enableLineNumber = r212;
        this.lineNumberColor = r213;
        this.enableBlockBackground = r214;
        this.codeBlockTextColor = r215;
        this.blockBorderColor = r216;
        this.blockBorderWidth = r217;
        this.enableSyntaxHighlight = r218;
        this.disableReplacementSpan = r219;
        this.enableCodeBlockStroke = r310;
        this.enableCodeBlockHeaderBackground = r311;
    }

    public /* synthetic */ CodeBlockConfig(Integer r210, Integer r310, boolean r311, Integer r312, int r313, Integer r314, boolean r315, String r316, boolean r317, boolean r318, TitleStyle r319, boolean r410, Integer r411, Integer r412, Integer r413, Integer r414, boolean r415, boolean r416, Integer r417, boolean r418, Integer r419, Integer r510, Integer r511, boolean r512, Boolean r513, boolean r514, boolean r515, int r516, DefaultConstructorMarker r517) {
        if ((r516 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r516 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r516 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r516 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r516 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r516 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r516 & 64) == 0) goto L29;
        boolean r106 = true;
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r516 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r516 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        TitleStyle r113 = TitleStyle.NORMAL;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        boolean r114 = true;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        Integer r107 = null;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        Integer r108 = null;
    L59:
        if ((r516 & 16384) == 0) goto L61;
        Integer r115 = null;
    L63:
        if ((r516 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r516 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r516 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r516 & 262144) == 0) goto L77;
        Integer r119 = null;
    L79:
        if ((r516 & 524288) == 0) goto L81;
        boolean r211 = true;
    L83:
        if ((r516 & 1048576) == 0) goto L85;
        Integer r212 = null;
    L87:
        if ((r516 & 2097152) == 0) goto L89;
        Integer r213 = null;
    L91:
        if ((r516 & 4194304) == 0) goto L93;
        Integer r214 = null;
    L95:
        if ((r516 & 8388608) == 0) goto L97;
        boolean r215 = true;
    L99:
        if ((r516 & 16777216) == 0) goto L101;
        Boolean r216 = Boolean.FALSE;
    L103:
        if ((r516 & 33554432) == 0) goto L105;
        boolean r217 = false;
    L107:
        if ((r516 & 67108864) == 0) goto L109;
        boolean r109 = false;
    L110:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r108, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r109);
        return;
    L109:
        r109 = r515;
        goto L110
    L105:
        r217 = r514;
        goto L107
    L101:
        r216 = r513;
        goto L103
    L97:
        r215 = r512;
        goto L99
    L93:
        r214 = r511;
        goto L95
    L89:
        r213 = r510;
        goto L91
    L85:
        r212 = r419;
        goto L87
    L81:
        r211 = r418;
        goto L83
    L77:
        r119 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r115 = r413;
        goto L63
    L57:
        r108 = r412;
        goto L59
    L53:
        r107 = r411;
        goto L55
    L49:
        r114 = r410;
        goto L51
    L45:
        r113 = r319;
        goto L47
    L41:
        r112 = r318;
        goto L43
    L37:
        r111 = r317;
        goto L39
    L33:
        r110 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
