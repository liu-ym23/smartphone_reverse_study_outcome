package hm7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lhm7/a;", "", "", "position", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "iconUrlComplete", "c", "iconUrlDoing", "d", "textColor", "l", "", "tabBg", "Ljava/util/List;", ce.f26396k, "()Ljava/util/List;", "Lhm7/b;", "stateContents", ce.f26395j, "", "processBarEnable", "Z", "h", "()Z", "processBarColor", ce.f26391f, "processBarBgColor", "f", "completionToast", "b", "completionFailToast", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "schema", RXScreenCaptureService.KEY_INDEX, "Lhm7/e;", "tipsConf", "Lhm7/e;", "m", "()Lhm7/e;", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("completion_fail_toast")
    private final String completionFailToast;

    @SerializedName("completion_toast")
    private final String completionToast;

    @SerializedName("icon_url_complete")
    private final String iconUrlComplete;

    @SerializedName("icon_url_doing")
    private final String iconUrlDoing;

    @SerializedName("position")
    private final String position;

    @SerializedName("process_bar_background_color")
    private final String processBarBgColor;

    @SerializedName("process_bar_color")
    private final String processBarColor;

    @SerializedName("process_bar_enable")
    private final boolean processBarEnable;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("state_contents")
    private final List<b> stateContents;

    @SerializedName("tab_bg")
    private final List<String> tabBg;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("tips_conf")
    private final e tipsConf;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L37:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L36;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.position, r101.position) == false) goto L36;
        if (Intrinsics.areEqual(this.iconUrlComplete, r101.iconUrlComplete) == false) goto L36;
        if (Intrinsics.areEqual(this.iconUrlDoing, r101.iconUrlDoing) == false) goto L36;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == false) goto L36;
        if (Intrinsics.areEqual(this.tabBg, r101.tabBg) == false) goto L36;
        if (Intrinsics.areEqual(this.stateContents, r101.stateContents) == false) goto L36;
        if (this.processBarEnable != r101.processBarEnable) goto L21;
        boolean r102 = true;
    L22:
        if (r102 == false) goto L36;
        if (Intrinsics.areEqual(this.processBarColor, r101.processBarColor) == false) goto L36;
        if (Intrinsics.areEqual(this.processBarBgColor, r101.processBarBgColor) == false) goto L36;
        if (Intrinsics.areEqual(this.completionToast, r101.completionToast) == false) goto L36;
        if (Intrinsics.areEqual(this.completionFailToast, r101.completionFailToast) == false) goto L36;
        if (Intrinsics.areEqual(this.schema, r101.schema) == false) goto L36;
        if (Intrinsics.areEqual(this.tipsConf, r101.tipsConf) == false) goto L36;
    L21:
        r102 = false;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public final int hashCode() {
        String r100 = this.position;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconUrlComplete;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrlDoing;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.textColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.tabBg;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<b> r116 = this.stateContents;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.processBarEnable;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.processBarColor;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.processBarBgColor;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.completionToast;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.completionFailToast;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.schema;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        e r137 = this.tipsConf;
        if (r137 == null) goto L53;
        r101 = r137.hashCode();
    L53:
        return r136 + r101;
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
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
        return "PendantConf(position=" + this.position + ", iconUrlComplete=" + this.iconUrlComplete + ", iconUrlDoing=" + this.iconUrlDoing + ", textColor=" + this.textColor + ", tabBg=" + this.tabBg + ", stateContents=" + this.stateContents + ", processBarEnable=" + this.processBarEnable + ", processBarColor=" + this.processBarColor + ", processBarBgColor=" + this.processBarBgColor + ", completionToast=" + this.completionToast + ", completionFailToast=" + this.completionFailToast + ", schema=" + this.schema + ", tipsConf=" + this.tipsConf + ")";
    }

    public final String a() {
        return this.completionFailToast;
    }

    public final String b() {
        return this.completionToast;
    }

    public final String c() {
        return this.iconUrlComplete;
    }

    public final String d() {
        return this.iconUrlDoing;
    }

    public final String e() {
        return this.position;
    }

    public final String f() {
        return this.processBarBgColor;
    }

    public final String g() {
        return this.processBarColor;
    }

    public final boolean h() {
        return this.processBarEnable;
    }

    public final String i() {
        return this.schema;
    }

    public final List<b> j() {
        return this.stateContents;
    }

    public final List<String> k() {
        return this.tabBg;
    }

    public final String l() {
        return this.textColor;
    }

    public final e m() {
        return this.tipsConf;
    }
}
