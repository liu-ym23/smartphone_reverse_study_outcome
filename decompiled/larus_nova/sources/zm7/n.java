package zm7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R\u001a\u0010$\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 R\u001c\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010R\u001c\u0010.\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010R(\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000200\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b2\u0010\fR\u001a\u00103\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 R\u001a\u00106\u001a\u0002058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u0002058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lzm7/n;", "", "", "", InvRouter.SCENES, "Ljava/util/List;", ce.f26395j, "()Ljava/util/List;", "", "pendantRules", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "pendantStyle", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "Lzm7/o;", "position", "Lzm7/o;", RXScreenCaptureService.KEY_INDEX, "()Lzm7/o;", "pendantSize", "getPendantSize", "iconSize", "getIconSize", "tabBg", "l", "", "hasBorder", "Z", "e", "()Z", "borderColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "borderWidth", "D", "b", "()D", "processBarEnable", "getProcessBarEnable", "processBarColor", "getProcessBarColor", "processBarBackgroundColor", "getProcessBarBackgroundColor", "textColor", "m", "Lzm7/p;", "stateContents", ce.f26396k, "needLoginGuide", "f", "", "fullDisplayDuration", "I", "d", "()I", "exitDuration", "c", "Lzm7/r;", "tipConf", "Lzm7/r;", "getTipConf", "()Lzm7/r;", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class n {

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_width")
    private final double borderWidth;

    @SerializedName("exit_duration")
    private final int exitDuration;

    @SerializedName("full_display_duration")
    private final int fullDisplayDuration;

    @SerializedName("has_border")
    private final boolean hasBorder;

    @SerializedName("icon_size")
    private final String iconSize;

    @SerializedName("need_login_guide")
    private final boolean needLoginGuide;

    @SerializedName("pendant_rules")
    private final Map<String, List<String>> pendantRules;

    @SerializedName("pendant_size")
    private final String pendantSize;

    @SerializedName("pendant_style")
    private final String pendantStyle;

    @SerializedName("position")
    private final o position;

    @SerializedName("process_bar_background_color")
    private final String processBarBackgroundColor;

    @SerializedName("process_bar_color")
    private final String processBarColor;

    @SerializedName("process_bar_enable")
    private final boolean processBarEnable;

    @SerializedName(InvRouter.SCENES)
    private final List<String> scenes;

    @SerializedName("state_contents")
    private final Map<String, p> stateContents;

    @SerializedName("tab_bg")
    private final List<String> tabBg;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("tip_conf")
    private final r tipConf;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L61:
        return true;
    L5:
        if ((r100 instanceof n) == false) goto L60;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.scenes, r101.scenes) == false) goto L60;
        if (Intrinsics.areEqual(this.pendantRules, r101.pendantRules) == false) goto L60;
        if (Intrinsics.areEqual(this.pendantStyle, r101.pendantStyle) == false) goto L60;
        if (Intrinsics.areEqual(this.position, r101.position) == false) goto L60;
        if (Intrinsics.areEqual(this.pendantSize, r101.pendantSize) == false) goto L60;
        if (Intrinsics.areEqual(this.iconSize, r101.iconSize) == false) goto L60;
        if (Intrinsics.areEqual(this.tabBg, r101.tabBg) == false) goto L60;
        if (this.hasBorder != r101.hasBorder) goto L23;
        boolean r102 = true;
    L24:
        if (r102 == false) goto L60;
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == false) goto L60;
        if (Double.compare(this.borderWidth, r101.borderWidth) != 0) goto L60;
        if (this.processBarEnable != r101.processBarEnable) goto L32;
        boolean r103 = true;
    L33:
        if (r103 == false) goto L60;
        if (Intrinsics.areEqual(this.processBarColor, r101.processBarColor) == false) goto L60;
        if (Intrinsics.areEqual(this.processBarBackgroundColor, r101.processBarBackgroundColor) == false) goto L60;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == false) goto L60;
        if (Intrinsics.areEqual(this.stateContents, r101.stateContents) == false) goto L60;
        if (this.needLoginGuide != r101.needLoginGuide) goto L45;
        boolean r104 = true;
    L46:
        if (r104 == false) goto L60;
        if (this.fullDisplayDuration != r101.fullDisplayDuration) goto L50;
        boolean r105 = true;
    L51:
        if (r105 == false) goto L60;
        if (this.exitDuration != r101.exitDuration) goto L55;
        boolean r106 = true;
    L56:
        if (r106 == false) goto L60;
        if (Intrinsics.areEqual(this.tipConf, r101.tipConf) == false) goto L60;
    L55:
        r106 = false;
        goto L56
    L50:
        r105 = false;
        goto L51
    L45:
        r104 = false;
        goto L46
    L32:
        r103 = false;
        goto L33
    L23:
        r102 = false;
    L60:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<String> r100 = this.scenes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.pendantRules;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pendantStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        o r110 = this.position;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.pendantSize;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.iconSize;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.tabBg;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.hasBorder;
        ?? r123 = 1;
        ?? r124 = r122;
        if (r122 == false) goto L33;
        r124 = 1;
    L33:
        int r125 = (r121 + r124) * 31;
        String r126 = this.borderColor;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        long r128 = Double.doubleToLongBits(this.borderWidth);
        int r129 = (((r125 + r127) * 31) + ((int) (r128 ^ (r128 >>> 32)))) * 31;
        boolean r130 = this.processBarEnable;
        ?? r131 = r130;
        if (r130 == false) goto L40;
        r131 = 1;
    L40:
        int r132 = (r129 + r131) * 31;
        String r133 = this.processBarColor;
        if (r133 == null) goto L43;
        int r134 = r133.hashCode();
    L44:
        int r135 = (r132 + r134) * 31;
        String r136 = this.processBarBackgroundColor;
        if (r136 == null) goto L47;
        int r137 = r136.hashCode();
    L48:
        int r138 = (r135 + r137) * 31;
        String r139 = this.textColor;
        if (r139 == null) goto L51;
        int r140 = r139.hashCode();
    L52:
        int r141 = (r138 + r140) * 31;
        Map<String, p> r142 = this.stateContents;
        if (r142 == null) goto L55;
        int r143 = r142.hashCode();
    L56:
        int r144 = (r141 + r143) * 31;
        boolean r145 = this.needLoginGuide;
        if (r145 == true) goto L60;
        r123 = r145;
    L60:
        int r146 = (((((r144 + r123) * 31) + this.fullDisplayDuration) * 31) + this.exitDuration) * 31;
        r r147 = this.tipConf;
        if (r147 == null) goto L64;
        r101 = r147.hashCode();
    L64:
        return r146 + r101;
    L55:
        r143 = 0;
        goto L56
    L51:
        r140 = 0;
        goto L52
    L47:
        r137 = 0;
        goto L48
    L43:
        r134 = 0;
        goto L44
    L36:
        r127 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PendantConfig(scenes=" + this.scenes + ", pendantRules=" + this.pendantRules + ", pendantStyle=" + this.pendantStyle + ", position=" + this.position + ", pendantSize=" + this.pendantSize + ", iconSize=" + this.iconSize + ", tabBg=" + this.tabBg + ", hasBorder=" + this.hasBorder + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", processBarEnable=" + this.processBarEnable + ", processBarColor=" + this.processBarColor + ", processBarBackgroundColor=" + this.processBarBackgroundColor + ", textColor=" + this.textColor + ", stateContents=" + this.stateContents + ", needLoginGuide=" + this.needLoginGuide + ", fullDisplayDuration=" + this.fullDisplayDuration + ", exitDuration=" + this.exitDuration + ", tipConf=" + this.tipConf + ")";
    }

    public final String a() {
        return this.borderColor;
    }

    public final double b() {
        return this.borderWidth;
    }

    public final int c() {
        return this.exitDuration;
    }

    public final int d() {
        return this.fullDisplayDuration;
    }

    public final boolean e() {
        return this.hasBorder;
    }

    public final boolean f() {
        return this.needLoginGuide;
    }

    public final Map<String, List<String>> g() {
        return this.pendantRules;
    }

    public final String h() {
        return this.pendantStyle;
    }

    public final o i() {
        return this.position;
    }

    public final List<String> j() {
        return this.scenes;
    }

    public final Map<String, p> k() {
        return this.stateContents;
    }

    public final List<String> l() {
        return this.tabBg;
    }

    public final String m() {
        return this.textColor;
    }
}
