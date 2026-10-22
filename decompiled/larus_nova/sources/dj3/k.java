package dj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldj3/k;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "textColor", "f", "", "fontSize", "Ljava/lang/Integer;", "getFontSize", "()Ljava/lang/Integer;", "fontWidth", "getFontWidth", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "selectParams", "d", "Ldj3/c;", "bubbleConfig", "Ldj3/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ldj3/c;", "", "forceSelected", "Z", "b", "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("bubble_config")
    private final c bubbleConfig;

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName("font_width")
    private final Integer fontWidth;

    @SerializedName("force_selected")
    private final boolean forceSelected;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("select_params")
    private final String selectParams;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L22;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontWidth, r101.fontWidth) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.selectParams, r101.selectParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bubbleConfig, r101.bubbleConfig) == true) goto L20;
        return false;
    L20:
        if (this.forceSelected == r101.forceSelected) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.fontSize;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.fontWidth;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.icon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.selectParams;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        c r119 = this.bubbleConfig;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        int r120 = (r118 + r101) * 31;
        boolean r121 = this.forceSelected;
        ?? r122 = r121;
        if (r121 == false) goto L33;
        r122 = 1;
    L33:
        return r120 + r122;
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
        return "SwitchButtonConfig(text=" + this.text + ", textColor=" + this.textColor + ", fontSize=" + this.fontSize + ", fontWidth=" + this.fontWidth + ", icon=" + this.icon + ", selectParams=" + this.selectParams + ", bubbleConfig=" + this.bubbleConfig + ", forceSelected=" + this.forceSelected + ")";
    }

    public k() {
        this.text = null;
        this.textColor = null;
        this.fontSize = null;
        this.fontWidth = null;
        this.icon = null;
        this.selectParams = null;
        this.bubbleConfig = null;
        this.forceSelected = false;
    }

    public final c a() {
        return this.bubbleConfig;
    }

    public final boolean b() {
        return this.forceSelected;
    }

    public final ECUrlModel c() {
        return this.icon;
    }

    public final String d() {
        return this.selectParams;
    }

    public final String e() {
        return this.text;
    }

    public final String f() {
        return this.textColor;
    }
}
