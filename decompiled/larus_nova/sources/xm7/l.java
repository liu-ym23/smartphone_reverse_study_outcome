package xm7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zm7.o;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001a\u0010\"\u001a\u00020!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010R\u001a\u0010(\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001c\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010R\u001c\u0010.\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010R(\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b3\u0010\fR\u001a\u00104\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u001eR\u001a\u00106\u001a\u0002008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u0002008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lxm7/l;", "", "", "", "countScenes", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "countSceneRules", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "pendantStyle", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", "Lzm7/o;", "position", "Lzm7/o;", ce.f26395j, "()Lzm7/o;", "iconSize", "getIconSize", "tabBg", "l", "", "hasBorder", "Z", ce.f26391f, "()Z", "borderColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "borderWidth", "D", "b", "()D", "tabSize", "getTabSize", "processBarEnable", "getProcessBarEnable", "processBarColor", "getProcessBarColor", "processBarBackgroundColor", "getProcessBarBackgroundColor", "textColor", "m", "", "Lxm7/m;", "stateContents", ce.f26396k, "needLoginGuide", "h", "fullDisplayDuration", "I", "f", "()I", "exitDuration", "e", "Lxm7/n;", "tipConfig", "Lxm7/n;", "getTipConfig", "()Lxm7/n;", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class l {

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_width")
    private final double borderWidth;

    @SerializedName("pendant_rules")
    private final Map<String, List<String>> countSceneRules;

    @SerializedName(InvRouter.SCENES)
    private final List<String> countScenes;

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

    @SerializedName("state_contents")
    private final Map<Integer, m> stateContents;

    @SerializedName("tab_bg")
    private final List<String> tabBg;

    @SerializedName("tab_size")
    private final String tabSize;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("tip_config")
    private final n tipConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L61:
        return true;
    L5:
        if ((r100 instanceof l) == false) goto L60;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.countScenes, r101.countScenes) == false) goto L60;
        if (Intrinsics.areEqual(this.countSceneRules, r101.countSceneRules) == false) goto L60;
        if (Intrinsics.areEqual(this.pendantStyle, r101.pendantStyle) == false) goto L60;
        if (Intrinsics.areEqual(this.position, r101.position) == false) goto L60;
        if (Intrinsics.areEqual(this.iconSize, r101.iconSize) == false) goto L60;
        if (Intrinsics.areEqual(this.tabBg, r101.tabBg) == false) goto L60;
        if (this.hasBorder != r101.hasBorder) goto L21;
        boolean r102 = true;
    L22:
        if (r102 == false) goto L60;
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == false) goto L60;
        if (Double.compare(this.borderWidth, r101.borderWidth) != 0) goto L60;
        if (Intrinsics.areEqual(this.tabSize, r101.tabSize) == false) goto L60;
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
        if (Intrinsics.areEqual(this.tipConfig, r101.tipConfig) == false) goto L60;
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
    L21:
        r102 = false;
    L60:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<String> r100 = this.countScenes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.countSceneRules;
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
        String r113 = this.iconSize;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.tabBg;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.hasBorder;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (r118 + r121) * 31;
        String r123 = this.borderColor;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        long r125 = Double.doubleToLongBits(this.borderWidth);
        int r126 = (((r122 + r124) * 31) + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        String r127 = this.tabSize;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
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
        Map<Integer, m> r142 = this.stateContents;
        if (r142 == null) goto L55;
        int r143 = r142.hashCode();
    L56:
        int r144 = (r141 + r143) * 31;
        boolean r145 = this.needLoginGuide;
        if (r145 == true) goto L60;
        r120 = r145;
    L60:
        int r146 = (((((r144 + r120) * 31) + this.fullDisplayDuration) * 31) + this.exitDuration) * 31;
        n r147 = this.tipConfig;
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
        r128 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
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
        return "PendantConfig(countScenes=" + this.countScenes + ", countSceneRules=" + this.countSceneRules + ", pendantStyle=" + this.pendantStyle + ", position=" + this.position + ", iconSize=" + this.iconSize + ", tabBg=" + this.tabBg + ", hasBorder=" + this.hasBorder + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", tabSize=" + this.tabSize + ", processBarEnable=" + this.processBarEnable + ", processBarColor=" + this.processBarColor + ", processBarBackgroundColor=" + this.processBarBackgroundColor + ", textColor=" + this.textColor + ", stateContents=" + this.stateContents + ", needLoginGuide=" + this.needLoginGuide + ", fullDisplayDuration=" + this.fullDisplayDuration + ", exitDuration=" + this.exitDuration + ", tipConfig=" + this.tipConfig + ")";
    }

    public final String a() {
        return this.borderColor;
    }

    public final double b() {
        return this.borderWidth;
    }

    public final Map<String, List<String>> c() {
        return this.countSceneRules;
    }

    public final List<String> d() {
        return this.countScenes;
    }

    public final int e() {
        return this.exitDuration;
    }

    public final int f() {
        return this.fullDisplayDuration;
    }

    public final boolean g() {
        return this.hasBorder;
    }

    public final boolean h() {
        return this.needLoginGuide;
    }

    public final String i() {
        return this.pendantStyle;
    }

    public final o j() {
        return this.position;
    }

    public final Map<Integer, m> k() {
        return this.stateContents;
    }

    public final List<String> l() {
        return this.tabBg;
    }

    public final String m() {
        return this.textColor;
    }
}
