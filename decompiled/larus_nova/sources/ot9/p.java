package ot9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J«\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006<"}, d2 = {"Lcom/larus/settings/opt/MarkdownOptimizeConfig;", "", "preheatMarkdown", "", "isDisableLatexSplit", "isLatexSplitOptimize", "markdownDrawableLruCacheSize", "", "texIconReuseEnable", "botAutoLinkMaxLimit", "userAutoLinkMaxLimit", "markdownCodeRenderAsync", "htmlNameEntityOptimize", "enableMarkdownCodeDefaultScroll", "enableUseLatexBitmapCache", "latexBitmapCacheSize", "enableOptimizeWidgetCompare", "isDisableMentionLinkify", "enableIncrementalTextNode", "incrementalNodeSyntaxChars", "", "<init>", "(ZZZIZIIZZZZIZZZLjava/lang/String;)V", "getPreheatMarkdown", "()Z", "getMarkdownDrawableLruCacheSize", "()I", "getTexIconReuseEnable", "getBotAutoLinkMaxLimit", "getUserAutoLinkMaxLimit", "getMarkdownCodeRenderAsync", "getHtmlNameEntityOptimize", "getEnableMarkdownCodeDefaultScroll", "getEnableUseLatexBitmapCache", "getLatexBitmapCacheSize", "getEnableOptimizeWidgetCompare", "getEnableIncrementalTextNode", "getIncrementalNodeSyntaxChars", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("bot_auto_link_max_limit")
    private final int botAutoLinkMaxLimit;

    @SerializedName("enable_incremental_text_node")
    private final boolean enableIncrementalTextNode;

    @SerializedName("enable_markdown_code_default_scroll")
    private final boolean enableMarkdownCodeDefaultScroll;

    @SerializedName("enable_optimize_widget_compare")
    private final boolean enableOptimizeWidgetCompare;

    @SerializedName("enable_use_latex_bitmap_cache")
    private final boolean enableUseLatexBitmapCache;

    @SerializedName("html_name_entity_optimize")
    private final boolean htmlNameEntityOptimize;

    @SerializedName("incremental_node_syntax_chars")
    private final String incrementalNodeSyntaxChars;

    @SerializedName("is_disable_latex_split")
    private final boolean isDisableLatexSplit;

    @SerializedName("is_disable_mention_linkify")
    private final boolean isDisableMentionLinkify;

    @SerializedName("is_latex_split_optimize")
    private final boolean isLatexSplitOptimize;

    @SerializedName("latex_bitmap_cache_size")
    private final int latexBitmapCacheSize;

    @SerializedName("markdown_code_render_async")
    private final boolean markdownCodeRenderAsync;

    @SerializedName("markdown_drawable_lru_cache_size")
    private final int markdownDrawableLruCacheSize;

    @SerializedName("preheat_markdown")
    private final boolean preheatMarkdown;

    @SerializedName("tex_icon_reuse_enable")
    private final boolean texIconReuseEnable;

    @SerializedName("user_auto_link_max_limit")
    private final int userAutoLinkMaxLimit;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.preheatMarkdown == r101.preheatMarkdown) goto L12;
        return false;
    L12:
        if (this.isDisableLatexSplit == r101.isDisableLatexSplit) goto L15;
        return false;
    L15:
        if (this.isLatexSplitOptimize == r101.isLatexSplitOptimize) goto L18;
        return false;
    L18:
        if (this.markdownDrawableLruCacheSize == r101.markdownDrawableLruCacheSize) goto L21;
        return false;
    L21:
        if (this.texIconReuseEnable == r101.texIconReuseEnable) goto L24;
        return false;
    L24:
        if (this.botAutoLinkMaxLimit == r101.botAutoLinkMaxLimit) goto L27;
        return false;
    L27:
        if (this.userAutoLinkMaxLimit == r101.userAutoLinkMaxLimit) goto L30;
        return false;
    L30:
        if (this.markdownCodeRenderAsync == r101.markdownCodeRenderAsync) goto L33;
        return false;
    L33:
        if (this.htmlNameEntityOptimize == r101.htmlNameEntityOptimize) goto L36;
        return false;
    L36:
        if (this.enableMarkdownCodeDefaultScroll == r101.enableMarkdownCodeDefaultScroll) goto L39;
        return false;
    L39:
        if (this.enableUseLatexBitmapCache == r101.enableUseLatexBitmapCache) goto L42;
        return false;
    L42:
        if (this.latexBitmapCacheSize == r101.latexBitmapCacheSize) goto L45;
        return false;
    L45:
        if (this.enableOptimizeWidgetCompare == r101.enableOptimizeWidgetCompare) goto L48;
        return false;
    L48:
        if (this.isDisableMentionLinkify == r101.isDisableMentionLinkify) goto L51;
        return false;
    L51:
        if (this.enableIncrementalTextNode == r101.enableIncrementalTextNode) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.incrementalNodeSyntaxChars, r101.incrementalNodeSyntaxChars) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.preheatMarkdown == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isDisableLatexSplit == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isLatexSplitOptimize == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.markdownDrawableLruCacheSize) * 31;
        if (this.texIconReuseEnable == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((((r106 + r107) * 31) + this.botAutoLinkMaxLimit) * 31) + this.userAutoLinkMaxLimit) * 31;
        if (this.markdownCodeRenderAsync == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.htmlNameEntityOptimize == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.enableMarkdownCodeDefaultScroll == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.enableUseLatexBitmapCache == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (((r114 + r115) * 31) + this.latexBitmapCacheSize) * 31;
        if (this.enableOptimizeWidgetCompare == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.isDisableMentionLinkify == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.enableIncrementalTextNode == true) goto L46;
        r100 = 1237;
    L46:
        int r121 = (r120 + r100) * 31;
        String r122 = this.incrementalNodeSyntaxChars;
        if (r122 != null) goto L49;
        int r123 = 0;
    L51:
        return r121 + r123;
    L49:
        r123 = r122.hashCode();
        goto L51
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownOptimizeConfig(preheatMarkdown=" + this.preheatMarkdown + ", isDisableLatexSplit=" + this.isDisableLatexSplit + ", isLatexSplitOptimize=" + this.isLatexSplitOptimize + ", markdownDrawableLruCacheSize=" + this.markdownDrawableLruCacheSize + ", texIconReuseEnable=" + this.texIconReuseEnable + ", botAutoLinkMaxLimit=" + this.botAutoLinkMaxLimit + ", userAutoLinkMaxLimit=" + this.userAutoLinkMaxLimit + ", markdownCodeRenderAsync=" + this.markdownCodeRenderAsync + ", htmlNameEntityOptimize=" + this.htmlNameEntityOptimize + ", enableMarkdownCodeDefaultScroll=" + this.enableMarkdownCodeDefaultScroll + ", enableUseLatexBitmapCache=" + this.enableUseLatexBitmapCache + ", latexBitmapCacheSize=" + this.latexBitmapCacheSize + ", enableOptimizeWidgetCompare=" + this.enableOptimizeWidgetCompare + ", isDisableMentionLinkify=" + this.isDisableMentionLinkify + ", enableIncrementalTextNode=" + this.enableIncrementalTextNode + ", incrementalNodeSyntaxChars=" + this.incrementalNodeSyntaxChars + ')';
    }

    public final int a() {
        return this.botAutoLinkMaxLimit;
    }

    public final boolean b() {
        return this.enableIncrementalTextNode;
    }

    public final boolean c() {
        return this.enableMarkdownCodeDefaultScroll;
    }

    public final boolean d() {
        return this.enableOptimizeWidgetCompare;
    }

    public final boolean e() {
        return this.enableUseLatexBitmapCache;
    }

    public final boolean f() {
        return this.htmlNameEntityOptimize;
    }

    public final String g() {
        return this.incrementalNodeSyntaxChars;
    }

    public final int h() {
        return this.latexBitmapCacheSize;
    }

    public final boolean i() {
        return this.markdownCodeRenderAsync;
    }

    public final int j() {
        return this.markdownDrawableLruCacheSize;
    }

    public final int k() {
        return this.userAutoLinkMaxLimit;
    }

    public final boolean l() {
        return this.isDisableLatexSplit;
    }

    public final boolean m() {
        return this.isDisableMentionLinkify;
    }

    public final boolean n() {
        return this.isLatexSplitOptimize;
    }

    public p(int r100) {
        this.preheatMarkdown = true;
        this.isDisableLatexSplit = false;
        this.isLatexSplitOptimize = true;
        this.markdownDrawableLruCacheSize = 20;
        this.texIconReuseEnable = true;
        this.botAutoLinkMaxLimit = 800;
        this.userAutoLinkMaxLimit = 800;
        this.markdownCodeRenderAsync = false;
        this.htmlNameEntityOptimize = true;
        this.enableMarkdownCodeDefaultScroll = false;
        this.enableUseLatexBitmapCache = false;
        this.latexBitmapCacheSize = 0;
        this.enableOptimizeWidgetCompare = false;
        this.isDisableMentionLinkify = true;
        this.enableIncrementalTextNode = false;
        this.incrementalNodeSyntaxChars = null;
    }
}
