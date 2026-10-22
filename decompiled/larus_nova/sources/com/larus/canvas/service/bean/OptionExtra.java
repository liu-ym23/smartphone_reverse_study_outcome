package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/canvas/service/bean/OptionExtra;", "", "isPresetRefImage", "", "presetRefImage", "Lcom/larus/canvas/service/bean/PresetRefImage;", "isTrending", "detectMode", "", "subDisplay", "", "optionMsg", "<init>", "(Ljava/lang/Boolean;Lcom/larus/canvas/service/bean/PresetRefImage;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPresetRefImage", "()Lcom/larus/canvas/service/bean/PresetRefImage;", "getDetectMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubDisplay", "()Ljava/lang/String;", "getOptionMsg", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Lcom/larus/canvas/service/bean/PresetRefImage;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/canvas/service/bean/OptionExtra;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionExtra {

    @SerializedName("detect_mode")
    private final Integer detectMode;

    @SerializedName("is_preset_ref_image")
    private final Boolean isPresetRefImage;

    @SerializedName("is_trending")
    private final Boolean isTrending;

    @SerializedName("option_msg")
    private final String optionMsg;

    @SerializedName("preset_ref_image")
    private final PresetRefImage presetRefImage;

    @SerializedName("sub_display")
    private final String subDisplay;

    public OptionExtra() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OptionExtra copy$default(OptionExtra r100, Boolean r101, PresetRefImage r102, Boolean r103, Integer r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.isPresetRefImage;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.presetRefImage;
    L8:
        PresetRefImage r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.isTrending;
    L11:
        Boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.detectMode;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.subDisplay;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.optionMsg;
    L20:
        Boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Boolean component1() {
        return this.isPresetRefImage;
    }

    public final PresetRefImage component2() {
        return this.presetRefImage;
    }

    public final Boolean component3() {
        return this.isTrending;
    }

    public final Integer component4() {
        return this.detectMode;
    }

    public final String component5() {
        return this.subDisplay;
    }

    public final String component6() {
        return this.optionMsg;
    }

    public final OptionExtra copy(Boolean r100, PresetRefImage r110, Boolean r111, Integer r112, String r113, String r114) {
        return new OptionExtra(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OptionExtra) == true) goto L8;
        return false;
    L8:
        OptionExtra r101 = (OptionExtra) r100;
        if (Intrinsics.areEqual(this.isPresetRefImage, r101.isPresetRefImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.presetRefImage, r101.presetRefImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isTrending, r101.isTrending) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detectMode, r101.detectMode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subDisplay, r101.subDisplay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.optionMsg, r101.optionMsg) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isPresetRefImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PresetRefImage r104 = this.presetRefImage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isTrending;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.detectMode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subDisplay;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.optionMsg;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "OptionExtra(isPresetRefImage=" + this.isPresetRefImage + ", presetRefImage=" + this.presetRefImage + ", isTrending=" + this.isTrending + ", detectMode=" + this.detectMode + ", subDisplay=" + this.subDisplay + ", optionMsg=" + this.optionMsg + ')';
    }

    public final Integer getDetectMode() {
        return this.detectMode;
    }

    public final String getOptionMsg() {
        return this.optionMsg;
    }

    public final PresetRefImage getPresetRefImage() {
        return this.presetRefImage;
    }

    public final String getSubDisplay() {
        return this.subDisplay;
    }

    public final Boolean isPresetRefImage() {
        return this.isPresetRefImage;
    }

    public final Boolean isTrending() {
        return this.isTrending;
    }

    public OptionExtra(Boolean r100, PresetRefImage r101, Boolean r102, Integer r103, String r104, String r105) {
        this.isPresetRefImage = r100;
        this.presetRefImage = r101;
        this.isTrending = r102;
        this.detectMode = r103;
        this.subDisplay = r104;
        this.optionMsg = r105;
    }

    public /* synthetic */ OptionExtra(Boolean r100, PresetRefImage r101, Boolean r102, Integer r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Boolean r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        PresetRefImage r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Boolean r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
