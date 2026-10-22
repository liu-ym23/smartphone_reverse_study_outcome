package com.larus.home.impl.main.tab.config;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jy\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001d¨\u0006/"}, d2 = {"Lcom/larus/home/impl/main/tab/config/BottomTabItemConfig;", "", "unselectIconKey", "", "selectIconKey", "unselectTextColor", "", "selectTextColor", "unSelectIconGeckoPath", "selectIconGeckoPath", "unSelectIconBitmap", "Landroid/graphics/Bitmap;", "selectIconBitmap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "getUnselectIconKey", "()Ljava/lang/String;", "getSelectIconKey", "getUnselectTextColor", "()Ljava/util/List;", "getSelectTextColor", "getUnSelectIconGeckoPath", "setUnSelectIconGeckoPath", "(Ljava/lang/String;)V", "getSelectIconGeckoPath", "setSelectIconGeckoPath", "getUnSelectIconBitmap", "()Landroid/graphics/Bitmap;", "setUnSelectIconBitmap", "(Landroid/graphics/Bitmap;)V", "getSelectIconBitmap", "setSelectIconBitmap", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTabItemConfig {
    private transient Bitmap selectIconBitmap;

    @SerializedName("android_select_icon_gecko_path")
    private String selectIconGeckoPath;

    @SerializedName("select_icon_key")
    private final String selectIconKey;

    @SerializedName("select_text_color")
    private final List<String> selectTextColor;
    private transient Bitmap unSelectIconBitmap;

    @SerializedName("android_unselect_icon_gecko_path")
    private String unSelectIconGeckoPath;

    @SerializedName("icon_key")
    private final String unselectIconKey;

    @SerializedName("text_color")
    private final List<String> unselectTextColor;

    public BottomTabItemConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BottomTabItemConfig copy$default(BottomTabItemConfig r100, String r110, String r111, List r112, List r113, String r114, String r115, Bitmap r116, Bitmap r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.unselectIconKey;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.selectIconKey;
    L11:
        if ((r118 & 4) == 0) goto L13;
        List r103 = r100.unselectTextColor;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.selectTextColor;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.unSelectIconGeckoPath;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.selectIconGeckoPath;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Bitmap r107 = r100.unSelectIconBitmap;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Bitmap r108 = r100.selectIconBitmap;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
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

    public final String component1() {
        return this.unselectIconKey;
    }

    public final String component2() {
        return this.selectIconKey;
    }

    public final List<String> component3() {
        return this.unselectTextColor;
    }

    public final List<String> component4() {
        return this.selectTextColor;
    }

    public final String component5() {
        return this.unSelectIconGeckoPath;
    }

    public final String component6() {
        return this.selectIconGeckoPath;
    }

    public final Bitmap component7() {
        return this.unSelectIconBitmap;
    }

    public final Bitmap component8() {
        return this.selectIconBitmap;
    }

    public final BottomTabItemConfig copy(String r110, String r111, List<String> r112, List<String> r113, String r114, String r115, Bitmap r116, Bitmap r117) {
        return new BottomTabItemConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BottomTabItemConfig) == true) goto L8;
        return false;
    L8:
        BottomTabItemConfig r101 = (BottomTabItemConfig) r100;
        if (Intrinsics.areEqual(this.unselectIconKey, r101.unselectIconKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectIconKey, r101.selectIconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unselectTextColor, r101.unselectTextColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectTextColor, r101.selectTextColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.unSelectIconGeckoPath, r101.unSelectIconGeckoPath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectIconGeckoPath, r101.selectIconGeckoPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.unSelectIconBitmap, r101.unSelectIconBitmap) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectIconBitmap, r101.selectIconBitmap) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.unselectIconKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.selectIconKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.unselectTextColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.selectTextColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.unSelectIconGeckoPath;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.selectIconGeckoPath;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Bitmap r119 = this.unSelectIconBitmap;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Bitmap r122 = this.selectIconBitmap;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BottomTabItemConfig(unselectIconKey=" + this.unselectIconKey + ", selectIconKey=" + this.selectIconKey + ", unselectTextColor=" + this.unselectTextColor + ", selectTextColor=" + this.selectTextColor + ", unSelectIconGeckoPath=" + this.unSelectIconGeckoPath + ", selectIconGeckoPath=" + this.selectIconGeckoPath + ", unSelectIconBitmap=" + this.unSelectIconBitmap + ", selectIconBitmap=" + this.selectIconBitmap + ')';
    }

    public final Bitmap getSelectIconBitmap() {
        return this.selectIconBitmap;
    }

    public final String getSelectIconGeckoPath() {
        return this.selectIconGeckoPath;
    }

    public final String getSelectIconKey() {
        return this.selectIconKey;
    }

    public final List<String> getSelectTextColor() {
        return this.selectTextColor;
    }

    public final Bitmap getUnSelectIconBitmap() {
        return this.unSelectIconBitmap;
    }

    public final String getUnSelectIconGeckoPath() {
        return this.unSelectIconGeckoPath;
    }

    public final String getUnselectIconKey() {
        return this.unselectIconKey;
    }

    public final List<String> getUnselectTextColor() {
        return this.unselectTextColor;
    }

    public final void setSelectIconBitmap(Bitmap r100) {
        this.selectIconBitmap = r100;
    }

    public final void setSelectIconGeckoPath(String r100) {
        this.selectIconGeckoPath = r100;
    }

    public final void setUnSelectIconBitmap(Bitmap r100) {
        this.unSelectIconBitmap = r100;
    }

    public final void setUnSelectIconGeckoPath(String r100) {
        this.unSelectIconGeckoPath = r100;
    }

    public BottomTabItemConfig(String r100, String r101, List<String> r102, List<String> r103, String r104, String r105, Bitmap r106, Bitmap r107) {
        this.unselectIconKey = r100;
        this.selectIconKey = r101;
        this.unselectTextColor = r102;
        this.selectTextColor = r103;
        this.unSelectIconGeckoPath = r104;
        this.selectIconGeckoPath = r105;
        this.unSelectIconBitmap = r106;
        this.selectIconBitmap = r107;
    }

    public /* synthetic */ BottomTabItemConfig(String r110, String r111, List r112, List r113, String r114, String r115, Bitmap r116, Bitmap r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L10:
        Bitmap r103 = null;
        if ((r118 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r118 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Bitmap r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r103 = r117;
    L34:
        this(r101, r102, r104, r105, r106, r100, r107, r103);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
