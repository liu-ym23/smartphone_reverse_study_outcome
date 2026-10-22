package com.bytedance.locallife.live.goodsshelves.bean;

import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B?\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003JA\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/BackgroundConfig;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "startColor", ShareData.START_HEIGHT, "endColor", "gradientHeight", "positionColor", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getStartColor", "()Ljava/lang/String;", "I", "getStartHeight", "()I", "getEndColor", "getGradientHeight", "getPositionColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class BackgroundConfig implements Serializable {
    public static final a Companion = null;
    public static final String DEFAULT_POSITION_COLOR = "#F6F6F6";

    @SerializedName("end_color")
    private final String endColor;

    @SerializedName("gradient_height")
    private final int gradientHeight;

    @SerializedName("position_color")
    private final String positionColor;

    @SerializedName("start_color")
    private final String startColor;

    @SerializedName("start_height")
    private final int startHeight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BackgroundConfig() {
        this(null, 0, null, 0, null, 31, null);
    }

    public static /* synthetic */ BackgroundConfig copy$default(BackgroundConfig r100, String r101, int r102, String r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.startColor;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.startHeight;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.endColor;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.gradientHeight;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.positionColor;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.startColor;
    }

    public final int component2() {
        return this.startHeight;
    }

    public final String component3() {
        return this.endColor;
    }

    public final int component4() {
        return this.gradientHeight;
    }

    public final String component5() {
        return this.positionColor;
    }

    public final BackgroundConfig copy(String r100, int r101, String r110, int r111, String r112) {
        return new BackgroundConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackgroundConfig) == true) goto L8;
        return false;
    L8:
        BackgroundConfig r101 = (BackgroundConfig) r100;
        if (Intrinsics.areEqual(this.startColor, r101.startColor) == true) goto L12;
        return false;
    L12:
        if (this.startHeight == r101.startHeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endColor, r101.endColor) == true) goto L18;
        return false;
    L18:
        if (this.gradientHeight == r101.gradientHeight) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.positionColor, r101.positionColor) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.startColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.startHeight) * 31;
        String r104 = this.endColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.gradientHeight) * 31;
        String r107 = this.positionColor;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BackgroundConfig(startColor=" + this.startColor + ", startHeight=" + this.startHeight + ", endColor=" + this.endColor + ", gradientHeight=" + this.gradientHeight + ", positionColor=" + this.positionColor + ')';
    }

    public final String getEndColor() {
        return this.endColor;
    }

    public final int getGradientHeight() {
        return this.gradientHeight;
    }

    public final String getPositionColor() {
        return this.positionColor;
    }

    public final String getStartColor() {
        return this.startColor;
    }

    public final int getStartHeight() {
        return this.startHeight;
    }

    public BackgroundConfig(String r100, int r101, String r102, int r103, String r104) {
        this.startColor = r100;
        this.startHeight = r101;
        this.endColor = r102;
        this.gradientHeight = r103;
        this.positionColor = r104;
    }

    public /* synthetic */ BackgroundConfig(String r100, int r101, String r102, int r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r105 = -1;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
