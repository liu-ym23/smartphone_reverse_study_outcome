package ot9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\tHÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006>"}, d2 = {"Lcom/larus/settings/opt/MarkdownCodeRenderConfig;", "", "enableMarkdownCodeRender", "", "canPreviewLanguage", "", "", "enableCodeRenderWebviewPreload", "appPreviewImageWidth", "", "appPreviewImageHeight", "padPreviewImageWidth", "padPreviewImageHeight", "previewLynxviewTemplateUrl", "canPreviewInLynxviewLanguage", "normalHtmlCodeOptimize", "renderHtmlCodeOptimize", "mindmapCodeOptimize", "mermaidCodeOptimize", "svgCodeOptimize", "echartCodeOptimize", "<init>", "(ZLjava/util/List;ZIIIILjava/lang/String;Ljava/util/List;ZZZZZZ)V", "getEnableMarkdownCodeRender", "()Z", "getCanPreviewLanguage", "()Ljava/util/List;", "getEnableCodeRenderWebviewPreload", "getAppPreviewImageWidth", "()I", "getAppPreviewImageHeight", "getPadPreviewImageWidth", "getPadPreviewImageHeight", "getPreviewLynxviewTemplateUrl", "()Ljava/lang/String;", "getCanPreviewInLynxviewLanguage", "getNormalHtmlCodeOptimize", "getRenderHtmlCodeOptimize", "getMindmapCodeOptimize", "getMermaidCodeOptimize", "getSvgCodeOptimize", "getEchartCodeOptimize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("app_preview_image_height")
    private final int appPreviewImageHeight;

    @SerializedName("app_preview_image_width")
    private final int appPreviewImageWidth;

    @SerializedName("can_preview_in_lynxview_language")
    private final List<String> canPreviewInLynxviewLanguage;

    @SerializedName("can_preview_language")
    private final List<String> canPreviewLanguage;

    @SerializedName("echart_code_optimize")
    private final boolean echartCodeOptimize;

    @SerializedName("enable_code_render_webview_preload")
    private final boolean enableCodeRenderWebviewPreload;

    @SerializedName("enable_markdown_code_render")
    private final boolean enableMarkdownCodeRender;

    @SerializedName("mermaid_code_optimize")
    private final boolean mermaidCodeOptimize;

    @SerializedName("mindmap_code_optimize")
    private final boolean mindmapCodeOptimize;

    @SerializedName("normal_html_code_optimize")
    private final boolean normalHtmlCodeOptimize;

    @SerializedName("pad_preview_image_height")
    private final int padPreviewImageHeight;

    @SerializedName("pad_preview_image_width")
    private final int padPreviewImageWidth;

    @SerializedName("preview_lynxview_template_url")
    private final String previewLynxviewTemplateUrl;

    @SerializedName("render_html_code_optimize")
    private final boolean renderHtmlCodeOptimize;

    @SerializedName("svg_code_optimize")
    private final boolean svgCodeOptimize;

    public o() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.enableMarkdownCodeRender == r101.enableMarkdownCodeRender) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canPreviewLanguage, r101.canPreviewLanguage) == true) goto L15;
        return false;
    L15:
        if (this.enableCodeRenderWebviewPreload == r101.enableCodeRenderWebviewPreload) goto L18;
        return false;
    L18:
        if (this.appPreviewImageWidth == r101.appPreviewImageWidth) goto L21;
        return false;
    L21:
        if (this.appPreviewImageHeight == r101.appPreviewImageHeight) goto L24;
        return false;
    L24:
        if (this.padPreviewImageWidth == r101.padPreviewImageWidth) goto L27;
        return false;
    L27:
        if (this.padPreviewImageHeight == r101.padPreviewImageHeight) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previewLynxviewTemplateUrl, r101.previewLynxviewTemplateUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.canPreviewInLynxviewLanguage, r101.canPreviewInLynxviewLanguage) == true) goto L36;
        return false;
    L36:
        if (this.normalHtmlCodeOptimize == r101.normalHtmlCodeOptimize) goto L39;
        return false;
    L39:
        if (this.renderHtmlCodeOptimize == r101.renderHtmlCodeOptimize) goto L42;
        return false;
    L42:
        if (this.mindmapCodeOptimize == r101.mindmapCodeOptimize) goto L45;
        return false;
    L45:
        if (this.mermaidCodeOptimize == r101.mermaidCodeOptimize) goto L48;
        return false;
    L48:
        if (this.svgCodeOptimize == r101.svgCodeOptimize) goto L51;
        return false;
    L51:
        if (this.echartCodeOptimize == r101.echartCodeOptimize) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableMarkdownCodeRender == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.canPreviewLanguage;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.enableCodeRenderWebviewPreload == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((((((((r106 + r107) * 31) + this.appPreviewImageWidth) * 31) + this.appPreviewImageHeight) * 31) + this.padPreviewImageWidth) * 31) + this.padPreviewImageHeight) * 31;
        String r109 = this.previewLynxviewTemplateUrl;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.canPreviewInLynxviewLanguage;
        if (r112 == null) goto L22;
        r104 = r112.hashCode();
    L22:
        int r113 = (r111 + r104) * 31;
        if (this.normalHtmlCodeOptimize == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.renderHtmlCodeOptimize == false) goto L29;
        int r116 = 1231;
    L30:
        int r117 = (r115 + r116) * 31;
        if (this.mindmapCodeOptimize == false) goto L33;
        int r118 = 1231;
    L34:
        int r119 = (r117 + r118) * 31;
        if (this.mermaidCodeOptimize == false) goto L37;
        int r120 = 1231;
    L38:
        int r121 = (r119 + r120) * 31;
        if (this.svgCodeOptimize == false) goto L41;
        int r122 = 1231;
    L42:
        int r123 = (r121 + r122) * 31;
        if (this.echartCodeOptimize == true) goto L47;
        r100 = 1237;
    L47:
        return r123 + r100;
    L41:
        r122 = 1237;
        goto L42
    L37:
        r120 = 1237;
        goto L38
    L33:
        r118 = 1237;
        goto L34
    L29:
        r116 = 1237;
        goto L30
    L25:
        r114 = 1237;
        goto L26
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownCodeRenderConfig(enableMarkdownCodeRender=" + this.enableMarkdownCodeRender + ", canPreviewLanguage=" + this.canPreviewLanguage + ", enableCodeRenderWebviewPreload=" + this.enableCodeRenderWebviewPreload + ", appPreviewImageWidth=" + this.appPreviewImageWidth + ", appPreviewImageHeight=" + this.appPreviewImageHeight + ", padPreviewImageWidth=" + this.padPreviewImageWidth + ", padPreviewImageHeight=" + this.padPreviewImageHeight + ", previewLynxviewTemplateUrl=" + this.previewLynxviewTemplateUrl + ", canPreviewInLynxviewLanguage=" + this.canPreviewInLynxviewLanguage + ", normalHtmlCodeOptimize=" + this.normalHtmlCodeOptimize + ", renderHtmlCodeOptimize=" + this.renderHtmlCodeOptimize + ", mindmapCodeOptimize=" + this.mindmapCodeOptimize + ", mermaidCodeOptimize=" + this.mermaidCodeOptimize + ", svgCodeOptimize=" + this.svgCodeOptimize + ", echartCodeOptimize=" + this.echartCodeOptimize + ')';
    }

    public final int a() {
        return this.appPreviewImageHeight;
    }

    public final int b() {
        return this.appPreviewImageWidth;
    }

    public final List<String> c() {
        return this.canPreviewInLynxviewLanguage;
    }

    public final List<String> d() {
        return this.canPreviewLanguage;
    }

    public final boolean e() {
        return this.echartCodeOptimize;
    }

    public final boolean f() {
        return this.enableCodeRenderWebviewPreload;
    }

    public final boolean g() {
        return this.enableMarkdownCodeRender;
    }

    public final boolean h() {
        return this.mermaidCodeOptimize;
    }

    public final boolean i() {
        return this.mindmapCodeOptimize;
    }

    public final boolean j() {
        return this.normalHtmlCodeOptimize;
    }

    public final int k() {
        return this.padPreviewImageHeight;
    }

    public final int l() {
        return this.padPreviewImageWidth;
    }

    public final String m() {
        return this.previewLynxviewTemplateUrl;
    }

    public final boolean n() {
        return this.renderHtmlCodeOptimize;
    }

    public final boolean o() {
        return this.svgCodeOptimize;
    }

    public o(Object r100) {
        List<String> r101 = CollectionsKt.listOf("");
        this.enableMarkdownCodeRender = false;
        this.canPreviewLanguage = null;
        this.enableCodeRenderWebviewPreload = false;
        this.appPreviewImageWidth = 480;
        this.appPreviewImageHeight = 480;
        this.padPreviewImageWidth = 800;
        this.padPreviewImageHeight = 800;
        this.previewLynxviewTemplateUrl = "sslocal://lynxview?url=https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F11517%2Fgecko%2Fresource%2Fflow_lynx_code_renderer_template%2Ftemplate.js&trans_status_bar=1&hide_nav_bar=1&loader_name=forest&mix_container_type=anniex&enable_canvas=1&group=-1";
        this.canPreviewInLynxviewLanguage = r101;
        this.normalHtmlCodeOptimize = false;
        this.renderHtmlCodeOptimize = false;
        this.mindmapCodeOptimize = false;
        this.mermaidCodeOptimize = false;
        this.svgCodeOptimize = false;
        this.echartCodeOptimize = false;
    }
}
