package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\u0013\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016¨\u00066"}, d2 = {"Lcom/larus/platform/model/FlowMarkdownSettings;", "", "markdownLatexPatternStrategy", "", "markdownFixHopForFormula", "isMarkdownListBlockOptimized", "", "enableNewQuoteStyle", "enablePhoneHighlight", "phoneNumberRegex", "", "refineBoldForPairedSymbolLeft", "refineBoldForPairedSymbolRight", "refineFormulaForRedundantSlashList", "refineFormulaForRedundantSlashInFormula", "refineTableInList", "enableDoubleDollarStrict", "<init>", "(IIZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getMarkdownLatexPatternStrategy", "()I", "getMarkdownFixHopForFormula", "()Z", "getEnableNewQuoteStyle", "getEnablePhoneHighlight", "getPhoneNumberRegex", "()Ljava/lang/String;", "getRefineBoldForPairedSymbolLeft", "getRefineBoldForPairedSymbolRight", "getRefineFormulaForRedundantSlashList", "getRefineFormulaForRedundantSlashInFormula", "getRefineTableInList", "getEnableDoubleDollarStrict", "addCmarkParserConfigParams", "", "config", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMarkdownSettings {

    @SerializedName("enable_double_dollar_strict")
    private final boolean enableDoubleDollarStrict;

    @SerializedName("enable_new_quote_style")
    private final boolean enableNewQuoteStyle;

    @SerializedName("enable_phone_highlight")
    private final boolean enablePhoneHighlight;

    @SerializedName("markdown_list_block_optimized")
    private final boolean isMarkdownListBlockOptimized;

    @SerializedName("markdown_fix_hop_for_formula")
    private final int markdownFixHopForFormula;

    @SerializedName("markdown_latex_pattern_strategy")
    private final int markdownLatexPatternStrategy;

    @SerializedName("phone_number_regex")
    private final String phoneNumberRegex;

    @SerializedName("refine_bold_for_paired_symbol_left")
    private final String refineBoldForPairedSymbolLeft;

    @SerializedName("refine_bold_for_paired_symbol_right")
    private final String refineBoldForPairedSymbolRight;

    @SerializedName("refine_formula_for_redundant_slash_in_formula")
    private final boolean refineFormulaForRedundantSlashInFormula;

    @SerializedName("refine_formula_for_redundant_slash_list")
    private final String refineFormulaForRedundantSlashList;

    @SerializedName("refine_table_in_list")
    private final boolean refineTableInList;

    public FlowMarkdownSettings() {
        this(0, 0, false, false, false, null, null, null, null, false, false, false, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ FlowMarkdownSettings copy$default(FlowMarkdownSettings r110, int r111, int r112, boolean r113, boolean r114, boolean r115, String r116, String r210, String r211, String r212, boolean r213, boolean r214, boolean r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = r110.markdownLatexPatternStrategy;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.markdownFixHopForFormula;
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r102 = r110.isMarkdownListBlockOptimized;
    L15:
        if ((r216 & 8) == 0) goto L17;
        boolean r103 = r110.enableNewQuoteStyle;
    L19:
        if ((r216 & 16) == 0) goto L21;
        boolean r104 = r110.enablePhoneHighlight;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.phoneNumberRegex;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.refineBoldForPairedSymbolLeft;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.refineBoldForPairedSymbolRight;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.refineFormulaForRedundantSlashList;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r118 = r110.refineFormulaForRedundantSlashInFormula;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        boolean r119 = r110.refineTableInList;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        boolean r108 = r110.enableDoubleDollarStrict;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    public final int component1() {
        return this.markdownLatexPatternStrategy;
    }

    public final boolean component10() {
        return this.refineFormulaForRedundantSlashInFormula;
    }

    public final boolean component11() {
        return this.refineTableInList;
    }

    public final boolean component12() {
        return this.enableDoubleDollarStrict;
    }

    public final int component2() {
        return this.markdownFixHopForFormula;
    }

    public final boolean component3() {
        return this.isMarkdownListBlockOptimized;
    }

    public final boolean component4() {
        return this.enableNewQuoteStyle;
    }

    public final boolean component5() {
        return this.enablePhoneHighlight;
    }

    public final String component6() {
        return this.phoneNumberRegex;
    }

    public final String component7() {
        return this.refineBoldForPairedSymbolLeft;
    }

    public final String component8() {
        return this.refineBoldForPairedSymbolRight;
    }

    public final String component9() {
        return this.refineFormulaForRedundantSlashList;
    }

    public final FlowMarkdownSettings copy(int r110, int r111, boolean r112, boolean r113, boolean r114, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216) {
        return new FlowMarkdownSettings(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowMarkdownSettings) == true) goto L8;
        return false;
    L8:
        FlowMarkdownSettings r101 = (FlowMarkdownSettings) r100;
        if (this.markdownLatexPatternStrategy == r101.markdownLatexPatternStrategy) goto L12;
        return false;
    L12:
        if (this.markdownFixHopForFormula == r101.markdownFixHopForFormula) goto L15;
        return false;
    L15:
        if (this.isMarkdownListBlockOptimized == r101.isMarkdownListBlockOptimized) goto L18;
        return false;
    L18:
        if (this.enableNewQuoteStyle == r101.enableNewQuoteStyle) goto L21;
        return false;
    L21:
        if (this.enablePhoneHighlight == r101.enablePhoneHighlight) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.phoneNumberRegex, r101.phoneNumberRegex) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refineBoldForPairedSymbolLeft, r101.refineBoldForPairedSymbolLeft) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.refineBoldForPairedSymbolRight, r101.refineBoldForPairedSymbolRight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.refineFormulaForRedundantSlashList, r101.refineFormulaForRedundantSlashList) == true) goto L36;
        return false;
    L36:
        if (this.refineFormulaForRedundantSlashInFormula == r101.refineFormulaForRedundantSlashInFormula) goto L39;
        return false;
    L39:
        if (this.refineTableInList == r101.refineTableInList) goto L42;
        return false;
    L42:
        if (this.enableDoubleDollarStrict == r101.enableDoubleDollarStrict) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.markdownLatexPatternStrategy * 31) + this.markdownFixHopForFormula) * 31;
        int r101 = 1231;
        if (this.isMarkdownListBlockOptimized == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.enableNewQuoteStyle == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.enablePhoneHighlight == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        String r108 = this.phoneNumberRegex;
        int r109 = 0;
        if (r108 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r107 + r110) * 31;
        String r112 = this.refineBoldForPairedSymbolLeft;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.refineBoldForPairedSymbolRight;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.refineFormulaForRedundantSlashList;
        if (r118 == null) goto L30;
        r109 = r118.hashCode();
    L30:
        int r119 = (r117 + r109) * 31;
        if (this.refineFormulaForRedundantSlashInFormula == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.refineTableInList == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.enableDoubleDollarStrict == true) goto L43;
        r101 = 1237;
    L43:
        return r123 + r101;
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r108.hashCode();
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "FlowMarkdownSettings(markdownLatexPatternStrategy=" + this.markdownLatexPatternStrategy + ", markdownFixHopForFormula=" + this.markdownFixHopForFormula + ", isMarkdownListBlockOptimized=" + this.isMarkdownListBlockOptimized + ", enableNewQuoteStyle=" + this.enableNewQuoteStyle + ", enablePhoneHighlight=" + this.enablePhoneHighlight + ", phoneNumberRegex=" + this.phoneNumberRegex + ", refineBoldForPairedSymbolLeft=" + this.refineBoldForPairedSymbolLeft + ", refineBoldForPairedSymbolRight=" + this.refineBoldForPairedSymbolRight + ", refineFormulaForRedundantSlashList=" + this.refineFormulaForRedundantSlashList + ", refineFormulaForRedundantSlashInFormula=" + this.refineFormulaForRedundantSlashInFormula + ", refineTableInList=" + this.refineTableInList + ", enableDoubleDollarStrict=" + this.enableDoubleDollarStrict + ')';
    }

    public final boolean getEnableDoubleDollarStrict() {
        return this.enableDoubleDollarStrict;
    }

    public final boolean getEnableNewQuoteStyle() {
        return this.enableNewQuoteStyle;
    }

    public final boolean getEnablePhoneHighlight() {
        return this.enablePhoneHighlight;
    }

    public final int getMarkdownFixHopForFormula() {
        return this.markdownFixHopForFormula;
    }

    public final int getMarkdownLatexPatternStrategy() {
        return this.markdownLatexPatternStrategy;
    }

    public final String getPhoneNumberRegex() {
        return this.phoneNumberRegex;
    }

    public final String getRefineBoldForPairedSymbolLeft() {
        return this.refineBoldForPairedSymbolLeft;
    }

    public final String getRefineBoldForPairedSymbolRight() {
        return this.refineBoldForPairedSymbolRight;
    }

    public final boolean getRefineFormulaForRedundantSlashInFormula() {
        return this.refineFormulaForRedundantSlashInFormula;
    }

    public final String getRefineFormulaForRedundantSlashList() {
        return this.refineFormulaForRedundantSlashList;
    }

    public final boolean getRefineTableInList() {
        return this.refineTableInList;
    }

    public final boolean isMarkdownListBlockOptimized() {
        return this.isMarkdownListBlockOptimized;
    }

    public final void addCmarkParserConfigParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        String r101 = this.refineBoldForPairedSymbolLeft;
        if (r101 == null) goto L5;
        r100.put("refine_bold_for_paired_symbol_left", r101);
    L5:
        String r102 = this.refineBoldForPairedSymbolRight;
        if (r102 == null) goto L8;
        r100.put("refine_bold_for_paired_symbol_right", r102);
    L8:
        String r103 = this.refineFormulaForRedundantSlashList;
        if (r103 == null) goto L12;
        r100.put("refine_formula_for_redundant_slash_list", r103);
        return;
    }

    public FlowMarkdownSettings(int r100, int r101, boolean r102, boolean r103, boolean r104, String r105, String r106, String r107, String r108, boolean r110, boolean r111, boolean r112) {
        this.markdownLatexPatternStrategy = r100;
        this.markdownFixHopForFormula = r101;
        this.isMarkdownListBlockOptimized = r102;
        this.enableNewQuoteStyle = r103;
        this.enablePhoneHighlight = r104;
        this.phoneNumberRegex = r105;
        this.refineBoldForPairedSymbolLeft = r106;
        this.refineBoldForPairedSymbolRight = r107;
        this.refineFormulaForRedundantSlashList = r108;
        this.refineFormulaForRedundantSlashInFormula = r110;
        this.refineTableInList = r111;
        this.enableDoubleDollarStrict = r112;
    }

    public /* synthetic */ FlowMarkdownSettings(int r110, int r111, boolean r112, boolean r113, boolean r114, String r115, String r210, String r211, String r212, boolean r213, boolean r214, boolean r215, int r216, DefaultConstructorMarker r217) {
        boolean r100 = false;
        if ((r216 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r216 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r216 & 16) == 0) goto L21;
        boolean r105 = false;
    L22:
        String r106 = null;
        if ((r216 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r216 & 256) != 0) goto L39;
        r106 = r212;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r117 = false;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        boolean r118 = false;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r107, r108, r116, r106, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L33:
        r116 = r211;
        goto L35
    L29:
        r108 = r210;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
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
